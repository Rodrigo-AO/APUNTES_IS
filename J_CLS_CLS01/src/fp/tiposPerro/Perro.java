package fp.tiposPerro;

public class Perro implements Animal{ // Aqui describimos al perro
	// El implements Animal le obliga a que los metodos de Animal estén en Perro
	
	
	// ATRIBUTOS: siempre privados (no deben de poder alterarse externamente)
	private String raza;
	private Color color; 		// Color no es un tipo, por lo que tendremos que definirlo
	private Integer edad;
	
	
	// MÉTODOS:
	// Constructor: permite inicializar objetos con distintos atributos
	public Perro
	(String raza, Color color, Integer edad) {		// Definimos qué tendra la clase 'Perro'
		this.raza = raza;
		this.color = color;
		this.edad = edad;
		
		// Con this.___ accedemos a la clase que habiamos creado, y se lo asignamos a los
		// atributos de nuestra clase 'Perro'
	}
	
	
	// Getters and setters
		// Getter:permite colsultar los valores de clases privadas
		// Setters: permite establecer valores en clases privadas
	
	// Getter de raza
	public String getRaza() {
		return this.raza;			// return dado que nos tiene que devolver la raza
	}
	
	// Setter de raza
	public void setRaza(String raza) {
		this.raza = raza;			// establecemos que la raza que le demos se la asigne a raza
	}


	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}


	public Integer getEdad() {
		return edad;
	}
	
	
	// toStrings, equals, hashCode
		// toString: permite concadenar valores para facilitar su lectura (como un NamedTuple)
	@Override
	public String toString() {
		return "Perro [raza=" + raza + ", color=" + color + ", edad=" + edad + "]";
	}


	@Override
	public void correr() {
		// TODO Auto-generated method stub
		System.out.println("El perro corre");
		
	}
}
