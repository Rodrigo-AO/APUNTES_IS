package fp.tipos;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import fp.utiles.Checkers;

public record Pedido(LocalDate fecha, String usuario, String pais, String ciudad, Envio envio,
		Set<String> categorias, String producto, Double precioUnitario, Integer unidadesCompradas) {
	
	public Pedido {
		Checkers.check("La fecha del pedido no puede ser futura, es decir, no pueden ser posteriores al día actual", 
				fecha.isBefore(LocalDate.now()));
		Checkers.check("El precio unitario y las unidades compradas tienen que ser igual o mayor a 0", 
				precioUnitario >= 0 && unidadesCompradas >= 0);
		Checkers.checkNoNull(producto, precioUnitario, unidadesCompradas);;
	}
	
	public Double precioTotal() {
		Double precioSinIva = precioUnitario * unidadesCompradas;
		return precioSinIva + precioSinIva * 0.21;
	}

	public int compareTo(Pedido p) {
		int res = this.fecha.compareTo(p.fecha);
		if(res == 0) {
			res = this.usuario.compareTo(p.usuario);
			if(res == 0) {
				res = this.producto.compareTo(p.producto);
			}
		}
		return res;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(this == null || this.getClass() != obj.getClass()) return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(fecha, other.fecha) && Objects.equals(usuario, other.usuario) && Objects.equals(producto, other.producto);
	}
	
	@Override
	public String toString() {
		return "Pedido = [Fecha: " + fecha + ", usuario: " + usuario + ", pais: " + pais + ", ciudad: " + ciudad + ", envio: " + envio +
				", categorias: " + categorias + ", producto: " + producto + ", precio unitario: " + precioUnitario +
				", unidades compradas: " + unidadesCompradas + ", precio total: " + precioTotal() + "]";
	}
	
}
