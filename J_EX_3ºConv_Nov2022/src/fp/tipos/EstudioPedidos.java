package fp.tipos;

import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public record EstudioPedidos(Set<Pedido> pedidos) {
	
	@Override
	public Set<Pedido> pedidos() {
		return new HashSet<Pedido>(pedidos);
	}
	
	public Map<Envio, Integer> getTotalPedidosPorEnvio(Set<Envio> envios, Integer mes) {
		Set<Pedido> aux = new HashSet<Pedido>();
		Map<Envio, Integer> res = new HashMap<Envio, Integer>();
		for(Pedido pedido: pedidos) {
			if(pedido.fecha().getMonth().equals(Month.of(mes))) {
				aux.add(pedido);
			}
		}
		for(Envio envio: envios) {
			Envio clave = envio;
			if(res.containsKey(clave)) {
				res.put(clave, res.get(clave) + 1);
			} else {
				res.put(clave, 1);
			}
		}
		return res;
	}
	
	
	public Double getMediaPrecioPorPedidoUsuarioAlemania(String usuario, String categoria) {
		return pedidos.stream()
				.filter(p-> p.usuario().equals(usuario))
					.filter(p -> p.categorias().contains(categoria))
						.mapToDouble(p -> p.precioUnitario()*p.precioUnitario()*1.19)
							.average().getAsDouble();
	}
	
	
	public Map<String, List<Double>> getResumenPedidosUsuario() {
		return pedidos.stream()
				.collect(Collectors.groupingBy(
						Pedido::usuario, Collectors.collectingAndThen(
								Collectors.toList(), p -> creaLista(p))));
	}
	
	private List<Double> creaLista(List<Pedido> pedidos) {
		Double minimo = pedidos.stream().mapToDouble(Pedido::precioUnitario).min().getAsDouble();
		Double media = pedidos.stream().mapToDouble(Pedido::precioUnitario).average().getAsDouble();
		Double maximo = pedidos.stream().mapToDouble(Pedido::precioUnitario).max().getAsDouble();
		return List.of(minimo, media, maximo);
	}
	
	
	public String getUsuarioMasDerrochadorPosicion(LocalDate fecha, Integer n) {
		return pedidos.stream()
				.filter(p -> p.fecha().equals(fecha))
					.sorted(Comparator.comparingDouble(Pedido::precioTotal).reversed())
						.map(p -> p.usuario())
							.collect(Collectors.toList()).get(n);
	}
	
	
	public Map<String, String> getProductoMayorPrecioPorPais(LocalDate fecha) {
		return pedidos.stream()
				.filter(p -> p.fecha().equals(fecha))
					.collect(Collectors.groupingBy(Pedido::pais,
							Collectors.collectingAndThen(Collectors.toList(), l -> listaAProducto(l))));
	}
	
	private String listaAProducto (List<Pedido> pedidos) {
		return pedidos.stream()
				.collect(Collectors.maxBy(
						Comparator.comparingDouble(Pedido::precioTotal)))
							.map(Pedido::producto)
								.get();
	}
	
}
