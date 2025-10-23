package fp.tipos;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

public interface Vinoteca {
	
	public void agregarVino(Vino vino);
	public void eliminarVino(Vino vino);
	public Integer obtenerNumeroVinos();
	public Boolean contieneVino(Vino vino);
	public void agregarVinos(Collection<Vino> vinos);
	public Boolean contieneVinos(Collection<Vino> vinos);
	public Integer calcularNumeroVinosDePais(String pais);
	public Collection<Vino> obtenerVinosRangoPuntos(Integer inf, Integer sup);
	public Integer calcularNumeroVinosDePaisConPuntuacionSuperior(String pais, Integer puntos);
	public Set<Vino> obtenerVinosBaratos(Double precio);
	public Boolean existeVinoDeUvaEnRegion(String region, String uva);
	public Set<String> calcularUvasDeRegion(String region);
	public Integer calcularTotalPuntosVinosDeRegion(String region);
	public Double calcularMediaPuntosVinosDeUva(String uva);
	public Vino obtenerVinoMejorPuntuado();
	public Vino obtenerVinoMejorPuntuadoDePais(String pais);
	public List<Vino> obtenerNVinosRegionOrdenadosPrecio(String region, Integer N);
	public Map<String, List<Vino>> agruparVinosPorPais();
	public Map<String, Set<String>> agruparUvasPorPais();
	public Map<String, Integer> calcularCalidadPrecioPorRegionMayorDe(Double calidadPrecio);
	public Map<String, Vino> calcularVinoMasCaroPorPais();
	public SortedMap<String, List<Vino>> calcularNMejoresVinosPorPais(Integer N);
	public String calcularRegionConMejoresVinos(Double calidadPrecio);
	
}
