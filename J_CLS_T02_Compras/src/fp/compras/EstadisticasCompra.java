package fp.compras;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.SortedMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EstadisticasCompra {
	
	private List<Compra> compras;

	public EstadisticasCompra(List<Compra> compras) {
		this.compras = compras;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((compras == null) ? 0 : compras.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstadisticasCompra other = (EstadisticasCompra) obj;
		if (compras == null) {
			if (other.compras != null)
				return false;
		} else if (!compras.equals(other.compras))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String s= compras.stream()
					.map(Compra::toString)
					.collect(Collectors.joining(",\n"));
		return "EstadisticasCompra [compras=" + s + "]";
	}

	
	/**
	 * @param provincia
	 * @return Devuelve una una pareja de elementos con  el importe máximo y el mínimo de las 
	 * compras que se hann realizado en la provincia dada como parámetro. 
	 * Si la provincia toma es null, se devuelve una tupla con el importe máximo y 
	 * el mínimo calculados a partir de todas las compras.
	 */
	public Pair<Double> compraMaximaMinimaProvincia(String provincia){
		DoubleSummaryStatistics st=		compras.stream()
					.filter(compra->provincia == null ||  compra.getProvincia().equals(provincia))
					.collect(Collectors.summarizingDouble(Compra::getTotalCompra));
		return new Pair<Double>(st.getMax(), st.getMin());
	}
	
	/**
	 * @return Devuelve la hora de menos afluencia al supermercado
	 */
	public Integer horaMenosAfluencia () {
		Map<Integer, Long> conteo = contarComprasPorHora(); 
		
		Comparator<Map.Entry<Integer, Long>> c = Map.Entry.comparingByValue();
		return conteo.entrySet().stream()
					.min(c)
					.get()
					.getKey();
	}
	
	/**
	 * @return Un Map en el que las claves son las horas y los valores el número de compras 
	 *    realizadas esa hora
	 */
	private Map<Integer, Long> contarComprasPorHora(){
		return compras.stream()
					.collect(Collectors.groupingBy(compra->compra.getFechaLlegada().getHour(),
												   Collectors.counting()));
	}

	/**
	 * @param n Número entero
	 * @return Una lista con los nombres de los n supermercados con más facturación.
	 */
	public List<String> supermercadosMasFacturacion (Integer n){
		Map<String, Double> acum = acumularComprasPorSupermercado();
		Comparator<Map.Entry<String, Double>> c = Map.Entry.comparingByValue(); 
		return acum.entrySet().stream()
				.sorted(c.reversed())
				.limit(n)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());		
	}
	
	/**
	 * @return Devuelve un Map en el que las claves son los nombres de los supermercados
	 * y los valores el total de compras realizadas en esos supermercados.
	 */
	private Map<String, Double> acumularComprasPorSupermercado(){
		return compras.stream()
				.collect(Collectors.groupingBy(Compra::getSupermercado,
										Collectors.summingDouble(Compra::getTotalCompra)));
	}

	/**
	 * @param n Número entero n
	 * @return devuelve una Map cuya clave es el dni del cliente y el valor es la lista de provincias 
	 * donde el cliente ha realizado sus compras, ordenadas alfabéticamente. 
	 * Solo se devolverán aquellos clientes que hayan comprado en un número de provincias 
	 * mayor que el parámetro n. 
	 */
	public Map<String, List<String>> clientesItinerantes(Integer n){
		Map<String, Set<String>> provinciasPorCliente = compras.stream()
							.collect(Collectors.groupingBy(Compra::getDNI,
												Collectors.mapping(Compra::getProvincia, 
																	Collectors.toSet())));
		return provinciasPorCliente.entrySet().stream()
					.filter((Map.Entry<String, Set<String>> entry)->entry.getValue().size()>n)
					.collect(Collectors.toMap(Map.Entry::getKey,
									e->ordenarProvincias(e.getValue())
									));
	}
	private List<String> ordenarProvincias(Collection<String> provincias){
		return provincias.stream()
						 .sorted()
						 .collect(Collectors.toList());
	}
	
	
	/**
	 * @param supermercado Supermercado buscado
	 * @param provincia Provincia buscada
	 * @return Una lista con  ordenada cronológicamente con las ‘fechas estrella’ de ese 
	 * supermercado en esa provincia. Se consideran ‘fechas estrella’ aquellos días en los 
	 * que el supermercado factura más que el día anterior y más que el día siguiente.
	 */
	public List<LocalDate> diasEstrella (String supermercado, String provincia){
		
		SortedMap<LocalDate, Double> m=  totalComprasPorDia(supermercado, provincia);
		List<LocalDate> fechas = m.keySet().stream()
									.toList();
		
		List<LocalDate> res = new ArrayList<LocalDate>();
		for (int i=1; i<fechas.size()-1;i++) {
			LocalDate anterior = fechas.get(i-1);
			LocalDate actual = fechas.get(i);
			LocalDate siguiente = fechas.get(i+1);
			if (m.get(actual)>m.get(anterior) && m.get(actual) > m.get(siguiente)) {
				res.add(actual);
			}
		}	
		return res;
	}

	/**
	 * Método auxiliar
	 * @param supermercado
	 * @param provincia
	 * @return Un SortedMap en el que las claves son los días y los valores el total de compras de ese día
	 * para el supermercado y la provincia dados como parámetros
	 */
	private SortedMap<LocalDate, Double> totalComprasPorDia(String supermercado, String provincia) {
		SortedMap<LocalDate, Double> res = new TreeMap<LocalDate, Double>();
		for (Compra compra: compras) {
			if (compra.getProvincia().equals(provincia) &&
							compra.getSupermercado().equals(supermercado)) {
				LocalDate clave = compra.getFechaSalida().toLocalDate();
				if (res.containsKey(clave)){
					res.put(clave, res.get(clave)+ compra.getTotalCompra());
				}else {
					res.put(clave, compra.getTotalCompra());
				}
			}
		}
		return res;
	}
}
