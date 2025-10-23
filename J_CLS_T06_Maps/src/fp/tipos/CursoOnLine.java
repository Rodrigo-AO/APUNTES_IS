package fp.tipos;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import fp.utiles.Checkers;

public class CursoOnLine {
	
	private String id;
	private String titulo;
	private String organizacion;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private Integer duracion;
	private TipoCertificacion tipoCertificacion;
	private Double valoracion;
	private NivelDificultad nivelDificultad;
	private Integer numeroEstudiantes;
	private Boolean gratis;
	
	public CursoOnLine(String id, String titulo, String organizacion, LocalDate fechaInicio,
			LocalDate fechaFin, Integer duracion, TipoCertificacion tipoCertificacion, Double valoracion,
			NivelDificultad nivelDificultad, Integer numeroEstudiantes, Boolean gratis) {
		checkId(id);
		Checkers.check("Valoracion inválida", 0.0 <= valoracion && valoracion <= 5.0);
		Checkers.check("Cantidad de estudiantes inválida", numeroEstudiantes >= 0);
		this.id = id;
		this.titulo = titulo;
		this.organizacion = organizacion;
		setFechaInicio(fechaInicio);
		setFechaFin(fechaFin);
		setDuracion(duracion);
		this.tipoCertificacion = tipoCertificacion;
		this.valoracion = valoracion;
		this.nivelDificultad = nivelDificultad;
		this.numeroEstudiantes = numeroEstudiantes;
		setGratis(gratis);
	}
	
	private void checkId(String id) {
		Checkers.check("Formato de id inválido", id.length() == 8);
		for(int i = 0; i<id.length(); i++) {
			if(0 < i && i < 3) {
				if(!(Character.isLetter(id.charAt(i)))) {
					throw new IllegalArgumentException("Formato de id inválido");
				}
			} else {
				if(!(Character.isDigit(id.charAt(i)))) {
					throw new IllegalArgumentException("Formato de id inválido");
				}
			}
		}
	}
	
	public String getId() {
		return id;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public String getOrganizacion() {
		return organizacion;
	}
	
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fecha) {
		Checkers.check("Fechas inválidas", fechaInicio.isBefore(fechaFin));
		this.fechaInicio = fecha;
	}
	
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	
	public void setFechaFin(LocalDate fecha) {
		Checkers.check("Fechas inválidas", fechaInicio.isBefore(fechaFin));
		this.fechaFin = fecha;
	}
	
	public Integer getDuracion() {
		return duracion;
	}
	
	public void setDuracion(Integer duracion) {
		Checkers.check("Duración insuficiente", duracion >= 1);
		this.duracion = duracion;
	}
	
	public Integer getDuracionMeses() {
		return Period.between(fechaInicio, fechaFin).getMonths();
	}
	
	public TipoCertificacion getTipoCertificacion() {
		return tipoCertificacion;
	}
	
	public Double getValoracion() {
		return valoracion;
	}
	
	public NivelDificultad getNivelDificultad() {
		return nivelDificultad;
	}
	
	public Integer getNumeroEstudiantes() {
		return numeroEstudiantes;
	}

	public boolean getGratis() {
		return gratis;
	}
	
	public void setGratis(Boolean gratis) {
		this.gratis = gratis;
	}
	
	public Double getMediaHorasSemanales() {
		Double semanas = (double) Period.between(fechaInicio, fechaFin).getDays()/7;
		return getDuracion()/semanas;
	}
	
	public EstadoCurso getEstadoCurso() {
		EstadoCurso res = null;
		if(LocalDate.now().isBefore(fechaInicio)) {
			res = EstadoCurso.PROXIMO;
		} else if(LocalDate.now().isAfter(fechaFin)) {
			res = EstadoCurso.FINALIZADO;
		} else {
			res = EstadoCurso.EN_CURSO;
		}
		return res;
	}
	
	public int hashCode() {
		return Objects.hash(id);
	}
	
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		CursoOnLine other = (CursoOnLine) obj;
		return Objects.equals(getId(), other.getId());
	}
	
	public int compareTo(CursoOnLine cur) {
		int res = getTitulo().compareTo(cur.getTitulo());
		if(res == 0) {
			res = getId().compareTo(cur.getId());
		}
		return res;
	}

}
