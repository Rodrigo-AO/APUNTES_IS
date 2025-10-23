package fp.tipos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import fp.utiles.Checkers;

public class VinotecaBucles implements Vinoteca{
	private Set<Vino> vinos;
	
	public VinotecaBucles() {
		this.vinos = new HashSet<Vino>();
	}
	
	public VinotecaBucles(Collection<Vino> vinos) {
		this.vinos = new HashSet<Vino>(vinos);
	}

	@Override
	public void agregarVino(Vino vino) {
		vinos.add(vino);
		
	}

	@Override
	public void eliminarVino(Vino vino) {
		Checkers.check("El vino está registrado", vinos.contains(vino));
		vinos.remove(vino);
	}

	@Override
	public Integer obtenerNumeroVinos() {
		return vinos.size();
	}

	@Override
	public Boolean contieneVino(Vino vino) {
		return vinos.contains(vino);
	}

	@Override
	public void agregarVinos(Collection<Vino> vinos) {
		vinos.addAll(vinos);
	}

	@Override
	public Boolean contieneVinos(Collection<Vino> vinos) {
		Boolean res = true;
		for(Vino vino: vinos) {
			if(!(vinos.contains(vino))){
				res = false;
				break;
			}
		}
		return res;
	}
	
	public Collection<Vino> getVinos() {
		return vinos;
	}
	
	public String toString() {
		return String.valueOf(obtenerNumeroVinos());
	}
	
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		VinotecaBucles other = (VinotecaBucles) obj;
		return Objects.equals(vinos, other.vinos);
	}

	@Override
	public Integer calcularNumeroVinosDePais(String pais) {
		Integer res = 0;
		for(Vino vino: vinos) {
			if(vino.pais().equals(pais)) {
				res++;
			}
		}
		return res;
	}

	@Override
	public Collection<Vino> obtenerVinosRangoPuntos(Integer inf, Integer sup) {
		Checkers.check("El límite inferior no puede ser mayor al límite superior", sup > inf);
		Collection<Vino> res = new HashSet<Vino>();
		for(Vino vino: vinos) {
			if(vino.puntos() >= inf && sup >= vino.puntos()) {
				res.add(vino);
			}
		}
		return res;
	}

	@Override
	public Integer calcularNumeroVinosDePaisConPuntuacionSuperior(String pais, Integer puntos) {
		Integer res = 0;
		for(Vino vino: vinos) {
			if(vino.pais().equals(pais) && vino.puntos() >= puntos) {
				res++;
			}
		}
		return res;
	}

	@Override
	public Set<Vino> obtenerVinosBaratos(Double precio) {
		Set<Vino> res = new HashSet<Vino>();
		for(Vino vino: vinos) {
			if(vino.precio() < precio) {
				res.add(vino);
			}
		}
		return res;
	}

	@Override
	public Boolean existeVinoDeUvaEnRegion(String uva, String region) {
		Boolean res = false;
		for(Vino vino: vinos) {
			if(vino.region().equals(region) && vino.uva().equals(uva)) {
				res = true;
				break;
			}
		}
		return res;
	}

	@Override
	public Set<String> calcularUvasDeRegion(String region) {
		Set<String> res = new HashSet<String>();
		for(Vino vino: vinos) {
			if(vino.region().equals(region)) {
				res.add(vino.uva());
			}
		}
		return res;
	}

	@Override
	public Integer calcularTotalPuntosVinosDeRegion(String region) {
		Integer res = 0;
		for(Vino vino: vinos) {
			if(vino.region().equals(region)) {
				res = res + vino.puntos();
			}
		}
		return res;
	}

	@Override
	public Double calcularMediaPuntosVinosDeUva(String uva) {
		Integer puntuacion = 0;
		Integer contador = 0;
		Double res = 0.;
		for(Vino vino: vinos) {
			if(vino.uva().equals(uva)) {
				puntuacion = puntuacion + vino.puntos();
				contador++;
			}
		}
		if(puntuacion != 0 && contador != 0) {
			res = (double) puntuacion/contador;
		}
		return res;
	}

	@Override
	public Vino obtenerVinoMejorPuntuado() {
		Vino res = null;
		for(Vino vino: vinos) {
			if(res == null) res = vino;
			if(res.puntos() < vino.puntos()) res = vino;
		}
		return res;
	}

	@Override
	public Vino obtenerVinoMejorPuntuadoDePais(String pais) {
		Vino res = null;
		for(Vino vino: vinos) {
			if(res == null && vino.pais().equals(pais)) {
				res = vino;
				if(res.puntos() < vino.puntos()) res = vino;
			}
		}
		return res;
	}

	@Override
	public List<Vino> obtenerNVinosRegionOrdenadosPrecio(String region, Integer N) {
		List<Vino> res = new ArrayList<Vino>();
		List<Vino> listaVinos = new ArrayList<Vino>();
		for(Vino vino: vinos) {
			if(vino.region().equals(region)) {
				listaVinos.add(vino);
			}
		}
		listaVinos.sort(Comparator.comparingDouble(Vino::precio));
		for(int i = 0; i<N; i++) {
			res.add(listaVinos.get(i)); // Posible error OutOfBounds
		}
		return res;
	}

	@Override
	public Map<String, List<Vino>> agruparVinosPorPais() {
		Map<String, List<Vino>> res = new HashMap<String, List<Vino>>();
		for(Vino vino: vinos) {
			String clave = vino.pais();
			if(res.containsKey(clave)) {
				List<Vino> vinos = res.get(clave);
				vinos.add(vino);
				res.put(clave, vinos);
			} else {
				res.put(clave, new ArrayList<Vino>(List.of(vino)));
			}
		}
		return res;
	}

	@Override
	public Map<String, Set<String>> agruparUvasPorPais() {
		Map<String, Set<String>> res = new HashMap<String, Set<String>>();
		for(Vino vino: vinos) {
			String clave = vino.pais();
			if(res.containsKey(clave)) {
				Set<String> vinos = res.get(clave);
				vinos.add(clave);
				res.put(clave, vinos);
			} else {
				res.put(clave, new HashSet<String>(Set.of(vino.uva())));
			}
		}
		return res;
	}

	@Override
	public Map<String, Integer> calcularCalidadPrecioPorRegionMayorDe(Double calidadPrecio) {
		Map<String, Integer> res = new HashMap<String, Integer>();
		for(Vino vino: vinos) {
			if(vino.calidadPrecio() >= calidadPrecio) {
				String clave = vino.region();
				if(res.containsKey(clave)) {
					Integer contador = res.get(clave);
					contador++;
					res.put(clave, contador);
				} else {
					Integer contador = 1;
					res.put(clave, contador);
				}
			}
		}
		return res;
	}

	@Override
	public Map<String, Vino> calcularVinoMasCaroPorPais() {
		Map<String, Vino> res = new HashMap<String, Vino>();
		for(Vino vino: vinos) {
			String clave = vino.pais();
			if(res.containsKey(clave) && res.get(clave).precio() < vino.precio()) {
				res.put(clave, vino);
			} else {
				res.put(clave, vino);
			}
		}
		return res;
	}

	@Override
	public SortedMap<String, List<Vino>> calcularNMejoresVinosPorPais(Integer N) {
		SortedMap<String, List<Vino>> res = new TreeMap<String, List<Vino>>();
		for(Vino vino: vinos) {
			String clave = vino.pais();
			if(!(res.containsKey(clave))) {
				List<Vino> vinos = obtenerNVinosPaisOrdenadosPrecio(clave, N);
				res.put(clave, vinos);
			}
		}
		return res;
	}
	
	private List<Vino> obtenerNVinosPaisOrdenadosPrecio(String pais, Integer N) {
		List<Vino> res = new ArrayList<Vino>();
		List<Vino> listaVinos = new ArrayList<Vino>();
		for(Vino vino: vinos) {
			if(vino.pais().equals(pais)) {
				listaVinos.add(vino);
			}
		}
		listaVinos.sort(Comparator.comparingDouble(Vino::precio));
		for(int i = 0; i<N; i++) {
			if(i < listaVinos.size()) {
				res.add(listaVinos.get(i));
			}
		}
		return res;
	}

	@Override
	public String calcularRegionConMejoresVinos(Double calidadPrecio) {
		String res = null;
		Map<String, Integer> precioCantCalidadPrecio = calcularCalidadPrecioPorRegionMayorDe(calidadPrecio);
		for(String clave: precioCantCalidadPrecio.keySet()) {
			if(res == null) res = clave;
			if(precioCantCalidadPrecio.get(clave) > precioCantCalidadPrecio.get(res)) {
				res = clave;
			}
		}
		return res;
	}
	
}
