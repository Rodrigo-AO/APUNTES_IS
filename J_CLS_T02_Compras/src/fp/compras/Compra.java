package fp.compras;

import fp.compras.utiles.*;
import java.time.LocalDateTime;

public class Compra {

	private String dni;
	private String supermercado;
	private String provincia;
	private LocalDateTime fechaLlegada;
	private LocalDateTime fechaSalida;
	private Double totalCompra;
	
	
	public Compra(String dni, String supermercado, String provincia, LocalDateTime fechaLlegada,
			LocalDateTime fechaSalida, Double totalCompras) {
		Checkers.check("El dni es incorrecto", Validators.validarDNI(dni));
		String msg = String.format("Fecha llegada(%s) posterior a fecha salida(%s)", fechaLlegada, fechaSalida);
		Checkers.check(msg, ! fechaLlegada.isAfter(fechaSalida));
		this.dni = dni;
		this.supermercado = supermercado;
		this.provincia = provincia;
		this.fechaLlegada = fechaLlegada;
		this.fechaSalida = fechaSalida;
		this.totalCompra = totalCompras;
	}


	public String getDNI() {
		return dni;
	}


	public String getSupermercado() {
		return supermercado;
	}


	public String getProvincia() {
		return provincia;
	}


	public LocalDateTime getFechaLlegada() {
		return fechaLlegada;
	}


	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}


	public Double getTotalCompra() {
		return totalCompra;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((fechaLlegada == null) ? 0 : fechaLlegada.hashCode());
		result = prime * result + ((fechaSalida == null) ? 0 : fechaSalida.hashCode());
		result = prime * result + ((provincia == null) ? 0 : provincia.hashCode());
		result = prime * result + ((supermercado == null) ? 0 : supermercado.hashCode());
		result = prime * result + ((totalCompra == null) ? 0 : totalCompra.hashCode());
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
		Compra other = (Compra) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (fechaLlegada == null) {
			if (other.fechaLlegada != null)
				return false;
		} else if (!fechaLlegada.equals(other.fechaLlegada))
			return false;
		if (fechaSalida == null) {
			if (other.fechaSalida != null)
				return false;
		} else if (!fechaSalida.equals(other.fechaSalida))
			return false;
		if (provincia == null) {
			if (other.provincia != null)
				return false;
		} else if (!provincia.equals(other.provincia))
			return false;
		if (supermercado == null) {
			if (other.supermercado != null)
				return false;
		} else if (!supermercado.equals(other.supermercado))
			return false;
		if (totalCompra == null) {
			if (other.totalCompra != null)
				return false;
		} else if (!totalCompra.equals(other.totalCompra))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Compra [getDni()=" + getDNI() + ", getSupermercado()=" + getSupermercado() + ", getProvincia()="
				+ getProvincia() + ", getFechaLlegada()=" + getFechaLlegada() + ", getFechaSalida()=" + getFechaSalida()
				+ ", getTotalCompras()=" + getTotalCompra() + ", hashCode()=" + hashCode() + "]";
	}
}
