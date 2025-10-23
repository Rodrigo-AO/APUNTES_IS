# T03.4-Lexico
Queremos construir un proyecto para analizar el vocabulario usado en distintos textos, para ello vamos a construir un tipo _Lexico_ y vamos a hacer pruebas con dos libros clásicos de la literatura española, "El Lazarillo de Tormes", una obra anónima, y "Platero y yo", la obra cumbre del premio Nobel Juan Ramón Jiménez. Para ello implementa los siguientes ejercicios:

1. Añade al paquete _fp.lexico_ un tipo _Lexico_ implementado como una clase, con la siguiente descripción:

Propiedades:

- _palabras_: de tipo SortedSet<String>. Consultable.
- _total palabras_: de tipo Integer. Consultable. Número de palabras del léxico.

Contructores:
- C1: Constructor sin parámetros. Crea un objeto de tipo Lexico con un conjunto de palabras vacío.
- C2: Constructor con un parámetro de tipo Collection<String>. Crea un objeto de tipo Lexico con la colección de palabras que se pasa como parámetro. Las palabras se deben almacenar en minúsculas.

Criterio de igualdad:
- Dos objetos de tipo Lexico son iguales si tienen el mismo conjunto de palabras.

Representación como cadena:
- La que genera Eclipse.

Otras operaciones:
- **void agregarPalabra(String palabra)**:  Agrega la palabra al léxico. Antes de agregarla, la convierte a minúsculas.
- **void agregarPalabras(Collection<String> palabras)**: Agrega las palabras de la colección palabras al léxico. Antes de agregarlas las convierte en minúsculas.
- **Set<String> getPalabrasComunes(Lexico lexico)**: Devuelve el conjunto de palabras comunes entre los dos léxicos.
- **Set<String> getTodasPalabras(Lexico lexico)**: Devuelve un conjunto con las palabras de los dos léxicos.
- **Set<String> getDiferenciaPalabras(Lexico lexico)**: Devuelve un conjunto con las palabras del léxico con el que se invoca al método que no están en el objeto léxico que se pasa como parámetro.


1. Añade el código necesario para implementar las operaciones especificadas al tipo _Lexico_.
2. En la clase _TestLexico_ del paquete _fp.lexico.test_  sustituye el comentario //TODO por líneas de código para hacer las siguientes operaciones:

	1. Cree dos objetos de tipo Lexico, uno que contenga las palabras del lazarillo y otro las palabras de platero.
	2. Muestre el número de palabras de cada objeto de tipo Lexico.
	3. Obtenga el conjunto de palabras comunes a los dos léxicos y muéstrelas por consola.
	4. Obtenga todas las palabras usadas en los dos léxicos y muéstrelas por consola.
	5. Obtenga las palabras que están en el lazarillo y no están en platero.



