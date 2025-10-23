package fp.tipos;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.utiles.Checkers;

public class VinotecaStream implements Vinoteca {
	private Set<Vino> vinos;
	
	public VinotecaStream() {
		this.vinos = new HashSet<Vino>();
	}
	
	public VinotecaStream(Collection<Vino> vinos) {
		this.vinos = new HashSet<Vino>(vinos);
	}
	
	@Override
	public void agregarVino(Vino vino) {
		this.vinos = Stream.concat(vinos.stream(), Stream.of(vino)).collect(Collectors.toSet()); // vinos.add(vino)
	}

	@Override
	public void eliminarVino(Vino vino) {
		vinos = vinos.stream().filter(x -> !(x.equals(vino))).collect(Collectors.toSet());
		
	}

	@Override
	public Integer obtenerNumeroVinos() {
		return (int) vinos.stream().count();
	}

	@Override
	public Boolean contieneVino(Vino vino) {
		return vinos.stream().anyMatch(x -> x.equals(vino));
	}

	@Override
	public void agregarVinos(Collection<Vino> collVinos) {
		vinos = Stream.concat(vinos.stream(), collVinos.stream()).collect(Collectors.toSet());
	}

	@Override
	public Boolean contieneVinos(Collection<Vino> collVinos) {
		return vinos.stream().allMatch(x -> collVinos.contains(x));
	}

	@Override
	public Integer calcularNumeroVinosDePais(String pais) {
		return (int) vinos.stream().filter(x -> x.pais().equals(pais)).count();
	}

	@Override
	public Collection<Vino> obtenerVinosRangoPuntos(Integer inf, Integer sup) {
		Checkers.check("El límite inferior no puede ser mayor al límite superior", sup > inf);
		return vinos.stream().filter(x -> x.puntos() >= inf && x.puntos() <= sup).collect(Collectors.toList());
	}

	@Override
	public Integer calcularNumeroVinosDePaisConPuntuacionSuperior(String pais, Integer puntos) {
		return (int) this.vinos.stream().filter(x -> x.pais().equals(pais) && x.puntos() > puntos).count();
	}

	@Override
	public Set<Vino> obtenerVinosBaratos(Double precio) {
		return vinos.stream().filter(x -> x.precio() > precio).collect(Collectors.toSet());
	}

	@Override
	public Boolean existeVinoDeUvaEnRegion(String region, String uva) {
		return vinos.stream().filter(x -> x.region().equals(region)).anyMatch(x -> x.uva().equals(uva));
	}

	@Override
	public Set<String> calcularUvasDeRegion(String region) {
		return vinos.stream().filter(x -> x.region().equals(region)).map(Vino::uva).collect(Collectors.toSet());
	}

	@Override
	public Integer calcularTotalPuntosVinosDeRegion(String region) {
		return vinos.stream().filter(x -> x.region().equals(region)).mapToInt(Vino::puntos).sum();
	}

	@Override
	public Double calcularMediaPuntosVinosDeUva(String uva) {
		return vinos.stream().filter(x -> x.uva().equals(uva)).mapToDouble(Vino::puntos).average().orElse(0.);
	}

	@Override
	public Vino obtenerVinoMejorPuntuado() {
		return vinos.stream().max(Comparator.comparingInt(Vino::puntos)).get();
	}

	@Override
	public Vino obtenerVinoMejorPuntuadoDePais(String pais) {
		return vinos.stream().filter(x -> x.pais().equals(pais)).max(Comparator.comparingInt(Vino::puntos)).get();
	}

	@Override
	public List<Vino> obtenerNVinosRegionOrdenadosPrecio(String region, Integer N) {
		return vinos.stream().filter(x -> x.region().equals(region)).
				sorted(Comparator.comparingDouble(Vino::precio).reversed()).limit(N).collect(Collectors.toList());
	}

	@Override
	public Map<String, List<Vino>> agruparVinosPorPais() {
		return vinos.stream().collect(Collectors.groupingBy(Vino::pais));
	}

	@Override
	public Map<String, Set<String>> agruparUvasPorPais() {
		return vinos.stream().collect(Collectors.groupingBy(Vino::pais, Collectors.mapping(Vino::uva, Collectors.toSet())));
	} // Stream --> Creamos un Map<Pais, list<Vino>> --> Indicamos que de cada vino queremos guardar la uva --> Pasamos a Set
	
	// Puro porro
	@Override
	public Map<String, Integer> calcularCalidadPrecioPorRegionMayorDe(Double calidadPrecio) {
		return vinos.stream().filter(x -> x.calidadPrecio() > calidadPrecio).collect(Collectors.groupingBy(
				Vino::region, Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
	}

	@Override
	public Map<String, Vino> calcularVinoMasCaroPorPais() {
		return vinos.stream().collect(Collectors.groupingBy(Vino::pais, Collectors.collectingAndThen(
				Collectors.maxBy(Comparator.comparingDouble(Vino::precio)), x -> x.orElse(null))));
	}
	
	@Override
	public SortedMap<String, List<Vino>> calcularNMejoresVinosPorPais(Integer N) {
		return vinos.stream().collect(Collectors.groupingBy(Vino::pais, TreeMap::new,
				Collectors.collectingAndThen(
						Collectors.toList(),
						x -> x.stream().sorted(Comparator.comparingInt(Vino::puntos).reversed()).limit(N).collect(Collectors.toList()))));
	}

	@Override
	public String calcularRegionConMejoresVinos(Double calidadPrecio) {
		Map<String, Integer> mapaRegionCantidad = calcularCalidadPrecioPorRegionMayorDe(calidadPrecio);
		return mapaRegionCantidad.entrySet().stream().max(Comparator.comparing(x -> x.getValue())).get().getKey();
	}
	
	public String toString() {
		return String.valueOf(obtenerNumeroVinos());
	}
	
}
