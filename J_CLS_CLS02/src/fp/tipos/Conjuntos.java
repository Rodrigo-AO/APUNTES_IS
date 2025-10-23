package fp.tipos;

public class Conjuntos {

	/*
	La diferencia entre Set<> y List<> es que, mientras que en los Set no se puede almacenar
	más un on objeto igual de la misma clase, en las listas se pueden almacenar 2 o más objetos
	iguales (en ambas solo se puede almacenar objetos de la misma clase dado el tipado de java)
	
	Estas colecciones (Collection) se pueden recorrer con un for y tienen funciones comunes.
	En listas los objetos tienen índice y los puedes ordenar, los Set tienen un método SortedSet
	que solo los ordena (no tienen índice ya que no se pueden repetir)
	*/
	
	/*
	Operaciones comunes en Collectiion
	Tipo conservadoras
		.size(): int 
		.isEmpity(): boolean
		.contains(o:Object): boolean
	Tipo modificadoras
		.add(e: T): boolean
		.remove(o: Object): boolean
	Tipo operacion con grupos
		.containsAll(c: Collection<?>): boolean
		.addAll(c: Collection<? extends T>): boolean
		.removeAll(c: Collection<?>): boolean
		.retainAllc: Collection<?>): boolean
		.clear(): void
	*/
	
	/*
	Operaciones de List
		.get(int index): T
		.set(int index, element T): T
		.add(int index, element T): void
		.remove(int index): boolean									true o false según se pueda o no
		.addAll(int index, c: Collection<? extends T>): boolean
		.indexOf(o: Object): int									devuelve el índice en la lista del obj que buscamos
		.lastIndexOf(o: Object): int
		.subList(int fromIndex, int toIndex): List<T>				devuelve sublista entre indices
	
	Implementaciones de listas
		LinkedList				mejor para modificaciones
		ArrayList				mejor para operaciones de búsqueda
	*/
}
