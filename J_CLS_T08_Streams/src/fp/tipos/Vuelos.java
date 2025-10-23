package fp.tipos;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Vuelos extends Vuelo{
	
	public Vuelos(Trayecto trayecyo, Double precio, Integer numPasajeros, Integer numPlazas, String codigo,
			LocalDate fecha, Duration duracion, List<String> tripulacion, String destino) {
		super(trayecyo, precio, numPasajeros, numPlazas, codigo, fecha, duracion, tripulacion, destino);
		// TODO Auto-generated constructor stub
	}

	private List<Vuelo> vuelos;
	
	public List<Vuelo> getVuelos(){
		return new ArrayList<Vuelo>(vuelos);
	}
	
	/*
	Los Stream nos permiten hacer un tratamiento secuencial de datos, como filtros, ordenamientos y transofrmaciones
	Ejemplos abajo:
	*/
	
	// Crea una funcion que devuelva el numero de vuelos en una fecha determinada
	public Integer numeroVuelosFecha1(LocalDate fecha) {
		Integer res = 0;
		for(Vuelo v: getVuelos()) {
			if(v.getFecha().equals(fecha)) {
				res++;
			}
		}
		return res;
	}
	
	public Long numeroVuelosFecha2(LocalDate fecha) {
		return getVuelos().stream().filter(x -> x.getFecha().equals(fecha)).count();
	}
	
	// Crea una función que nos de los destinos de los vuelos de una fecha determinada
	public List<String> listaDestOrdFecha1(LocalDate fecha) {
		List<Vuelo> vuelos = new ArrayList<Vuelo>();
		for(Vuelo v: getVuelos()) {
			if(v.getFecha().equals(fecha)) {
				vuelos.add(v);
			}
		}
		vuelos.sort(Comparator.comparing(Vuelo::getFecha));
		List<String> res = new ArrayList<String>();
		for(Vuelo v: vuelos) {
			res.add(v.getDestino());
		}
		return res;
	}
	
	public List<String> listaDestOrdFecha2(LocalDate fecha){
		return getVuelos().stream().filter(x -> x.getFecha().equals(fecha)).sorted(Comparator.comparing(Vuelo::getFecha))
				.map(Vuelo::getDestino).collect(Collectors.toList());
	}
	/*
	Interfaz Funtion: Stream map(Function): recibe una función que nos permite pasar de trabajar con un objeto de una
	clase a trabajar con una propiedad de la misma
	- map: transforma el objeto en la propiedad indicada por una funcion (mapToInt, mapToLong...)
	*/

	/*
	Stream cuenta con múltiples operaciones, adelante muestro algunas de las más comunes:
	- Stream.concat(stream1, stream2): permite crear un stream compuesto por el stream 1 seguido del stream 2
	
	Operaciones intermedias:
	- distinct: elimina todo los duplicados de una lista
	- filter: filtra elementos según una función lambda
	- flatMap: "aplana estructuras anidadas": convierte listas con sublistas en una única lista
	- map: convierte datos a un map de lo indicado según un método de la clase
	- sorted: ordena según el criterio dado
	- limit: limita el tamaño del stream al numero que se le de
	- peek: aplica una acción a todos los elementos del stream, devolviendo el stream original (como el forEach pero intermedio)
	
	Operaciones terminales:
	- allMatch: true si todos los elementos pasados cumplen cierta coindicion
	- anyMatch: true si alguno de los elementos pasados cumplen cierta coindicion
	- average: devuelve la media de los valores que se le pasen
	- collect: recoje elementos del stream para convertirlos a una estructura final
	- count: cuenta todos los elementos que cumplan lo que se indique previo a este
	- forEach: permite ejecutar una acción para cada elemento que le llegue
	- max: devuelve el máximo
	- min: devuelve el mínimo
	- sum: devuelde la suma
	- orElse: se usa tras una terminal para evitar lanzar una excepcion
	- noneMatch: true si ninguno de los elementos pasado cumplen cierta condición
	*/
	
	public Boolean todosVuelosFechaCompletos(LocalDate fecha) {
		return getVuelos().stream().filter(x -> x.getFecha().equals(fecha)).allMatch(x -> x.getNumPlazas().equals(x.getNumPasajeros()));
	}
	
	public Boolean existeVueloFechaYDestino(LocalDate fecha, String destino) {
		return getVuelos().stream().anyMatch(x -> x.getDestino().equals(destino) && x.getFecha().equals(fecha));
	}
	
	public Vuelo primerVueloDestino1(String destino) {							// Si no hay ninguno, lanzaria una excepción
		return getVuelos().stream().filter(x -> x.getDestino().equals(destino))
				.min(Comparator.comparing(Vuelo::getFecha)).get();
	}
	
	public Vuelo primerVueloDestino2(String destino) {							// Si no hay ninguno, devolvería null
		return getVuelos().stream().filter(x -> x.getDestino().equals(destino))
				.min(Comparator.comparing(Vuelo::getFecha)).orElse(null);
	}
	
	public Vuelo vueloMayorOcupacionFecha(LocalDate fecha) {
		return getVuelos().stream().filter(x -> x.getFecha().equals(fecha)).max(Comparator.comparing(Vuelo::getNumPasajeros)).get();
	}
	
	public List<Vuelo> ordenaFechaDestino() {
		return getVuelos().stream().sorted(Comparator.comparing(Vuelo::getFecha).thenComparing(Comparator.comparing(Vuelo::getDestino)))
				.collect(Collectors.toList());
	}
	
	/*
	Consumer: realiza acciones sobre el objeto al que se le aplica, como modificar una propiedad del mismo
	Permite hacer funciones "tipo void"
	Suele emplear funciones lambda para ello
	Se suele implementar con un .forEach al final, aunque se le puede aplicar cualquier método intermedio y terminal
	*/
	
	Consumer<Vuelo> retrasaFecha = x -> x.setFecha(x.getFecha().plusDays(-1));
	String nuevoDestino = null;
	Consumer<Vuelo> cambiaDestino = x -> x.setDestino(nuevoDestino);
	
	// Esto se puede combinar facilmente con los streams mediante su método forEach
	
	public void desviaVuelosDestino(String destino, String nuevoDestino) {
		getVuelos().stream().filter(x -> x.getDestino().equals(destino)).forEach(x -> x.setDestino(nuevoDestino));
	}
	
	public void muestraDestinosVuelosFecha(LocalDate fecha) {
		getVuelos().stream().filter(x -> x.getFecha().equals(fecha)).forEach(x -> System.out.println(x.getDestino()));
	}
	
	/*
	Método collect e interfaz Collectors: permite recoger los datos procesados y transformarlos en una estructura
	de datos, normalmente usado para generar una Collection como una List, un Set, un Map, ...
	Cuentan con algunas funciones interesantes como:
	- Collectors.toSet()/toList(): permite devolver el stream como un Set/List
	- groupingBy(Fuction): crea un map con claves lo determinado por la Fuction y como valores por defecto listas
		del objeto tratado, aunque se le puede indicar dentro del groupingBy que métodos le haga a las claves
	- partitionBy(Predicate): es un caso particular de la previa pero, en vez de usarse criterios numéricos
		como un contador, se emplean booleanos (usando normalmente una función lambda)
	*/
	
	// Ordena una lista con el número de pasajeros de cada vuelo de una fecha determinada
	public List<Integer> numPasajerosVuelosFecha(LocalDate fecha) {
		return getVuelos().stream().filter(x -> x.getFecha().equals(fecha))
				.map(x -> x.getNumPasajeros()).collect(Collectors.toList());
	}
	
	// Obtener una agrupación de los vuelos según su destino
	public Map<String, List<Vuelo>> vuelosPorDestino() {
		return getVuelos().stream().collect(Collectors.groupingBy(Vuelo::getDestino));
	}
	
	// Obtener una agrupación que relacione los destinos con el número de vuelos que se dirijen a este
	public Map<String, Long> numeroVuelosPorDestino() {
		return getVuelos().stream().collect(Collectors.groupingBy(Vuelo::getDestino, Collectors.counting()));
	}
	
	// Obtener una agrupación de los vuelos que están completos y los que no
	public Map<Boolean, List<Vuelo>> completosYConPlazas() {
		return getVuelos().stream().collect(Collectors.partitioningBy(x -> x.getNumPasajeros().equals(x.getNumPlazas())));
	}
	
	// Calcular el número total de pasajeros que se dirigen a cada destino
	public Map<String, Integer> numeroTotalPasajerosPorDestino() {
		return getVuelos().stream().collect(Collectors.groupingBy(Vuelo::getDestino, Collectors.summingInt(Vuelo::getNumPasajeros)));
	}
	
	// Calcular la media de pasajeros que se dirigen a cada destino
	public Map<String, Double> numeroMedioPasajeosPorDestino() {
		return getVuelos().stream().collect(Collectors.groupingBy(Vuelo::getDestino, Collectors.averagingInt(Vuelo::getNumPasajeros)));
	}
	
	// Obten los diferentes modelos de avión por compañía
	public Map<String,  Set<String>> getModelosPorCompañia() {
		return vuelos.stream().collect(Collectors.groupingBy(Vuelo::getCompañia, Collectors.mapping(Vuelo::getModelo, Collectors.toSet())));
	}

}
