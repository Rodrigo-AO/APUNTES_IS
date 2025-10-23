## Fundamentos de Programación
# Proyecto de laboratorio: Gestión Grados Universitarios.
# Parte IV

**Autores:** Toñi Reina


**Objetivos:**

- Implementar constructores a partir de `String`.
- Implementar una factoría con métodos creacionales y métodos para la lectura de datos de ficheros.
- Añadir tratamientos secuenciales con bucles al tipo agregado (contenedor).

En este cuarto bloque vamos a implementar constructores a partir de `String`, factorías que tendrán tanto métodos creacionales como métodos para leer datos de archivos de los distintos tipos implementados. Finalmente, implementaremos operaciones para trabajar con tratamientos secuenciales con bucles.

### Constructores a partir de String

Añada a las siguientes clases un nuevo constructor que permita construir un objeto a partir de una cadena de caracteres según las siguientes descripciones:

- **Espacio**: El constructor deberá crear un objeto de tipo `Espacio` a partir de una cadena con el siguiente formato: `"A0.10,0,100,TEORIA"`, donde primero aparece el nombre del espacio (`A0.10`), seguido de la planta (`0`), la capacidad (`100`) y el tipo de espacio (`TEORIA`).
- **Despacho**: El constructor deberá crear un objeto de tipo `Despacho` a partir de una cadena con el siguiente formato: `"F1.43,1,3"`, donde primero aparece el nombre del despacho (`F1.43`), seguido de la planta (`1`) y, por último, la capacidad (`3`).

Añada a las clases `TestEspacio` y `TestDespacho` sendos métodos de test para probar los constructores anteriores.

### FactoriaUniversidad

Cree una clase `FactoriaUniversidad` que va a ser la responsable de la creación de objetos de la aplicación. Una clase de factoría es una utilidad, por lo que sus métodos deben tener el modificador `static`. `FactoriaUniversidad` va a contener tanto métodos creacionales como métodos de lectura de archivos (Use la clase [Ficheros](./Ficheros.java), que debe añadir al paquete `fp.utiles`, para realizar la lectura de los archivos). Añada a esta clase los métodos de factoría que se indican a continuación:

- **Espacio**: Añada un método `creaEspacio` que cree un `Espacio` a partir de una cadena de caracteres con el mismo formato indicado en el constructor a partir de `String`. Añada un segundo método `leeEspacios` que, dado un fichero con espacios, devuelva una lista con objetos de tipo `Espacio` creados a partir de la información del fichero. Use el archivo [espacios.csv](./data/espacios.csv) de la carpeta `data` para realizar las pruebas pertinentes.

- **Despacho**: Añada un método `creaDespacho` que cree un `Despacho` a partir de una cadena de caracteres con el mismo formato indicado en el constructor a partir de `String`. Añada un segundo método `leeDespachos` que, dado un fichero con despachos, devuelva una lista con objetos de tipo `Despacho` creados a partir de la información del fichero. Use el archivo [despachos.csv](./data/despachos.csv) de la carpeta `data` para realizar las pruebas pertinentes.

- **Alumno**: Añada un método `creaAlumno` que cree un `Alumno` a partir de una cadena de caracteres con el formato: `"12345678Z,Juan,Lopez Garcia,20/7/1998,juan@alum.us.es"`. Añada un segundo método `leeAlumnos` que, dado un fichero con alumnos, devuelva una lista con objetos de tipo `Alumno` creados a partir de la información del fichero. Use el archivo [alumnos.csv](./data/alumnos.csv) de la carpeta `data` para realizar las pruebas pertinentes.

- **Asignatura**: Añada un método `creaAsignatura` que cree una `Asignatura` a partir de una cadena de caracteres con el formato: `"Fundamentos de Programación#1234567#12.0#ANUAL#1"`, donde primero aparece el nombre de la asignatura (`Fundamentos de Programación`), seguido del código de la misma (`1234567`), luego el número de créditos (`12.0`), a continuación el tipo de asignatura (`ANUAL`) y, por último, el curso. Añada un segundo método `leeAsignaturas` que, dado un fichero con asignaturas, devuelva una lista con objetos de tipo `Asignatura` creados a partir de la información del fichero. Use el archivo [asignaturas.txt](./data/asignaturas.txt) de la carpeta `data` para realizar las pruebas pertinentes.

- **Nota**: Añada un método `creaNota` que cree una `Nota` a partir de una cadena de caracteres con el formato: `"Fundamentos de Programación#1234567#12.0#ANUAL#1,2014,PRIMERA,10.0,true"`. Añada un segundo método `leeNotas` que, dado un fichero con notas, devuelva una lista con objetos de tipo `Nota` creados a partir de la información del fichero. Use el archivo [notas.csv](./data/notas.csv) de la carpeta `data` para realizar las pruebas pertinentes.

### Departamento

Un departamento tiene un nombre, está formado por un conjunto de profesores y tiene a su cargo la impartición de un conjunto de asignaturas. Tanto los profesores como las asignaturas solo se pueden consultar y se deberán manipular con las siguientes operaciones:

- `nuevoProfesor`: dado un profesor, lo añade al departamento.
- `eliminaProfesor`: dado un profesor, lo elimina del departamento. Si el profesor no pertenece al departamento, la operación no tiene efecto.
- `nuevaAsignatura`: dada una asignatura, la añade al departamento.
- `eliminaAsignatura`: dada una asignatura, la elimina del departamento. Si la asignatura no es impartida por el departamento, la operación no tiene efecto.

Para construir un objeto de tipo `Departamento` solo será necesario proporcionar su nombre, ya que inicialmente el departamento no tendrá ni profesores ni asignaturas.

Se considera que dos departamentos son iguales si tienen el mismo nombre. Se ordenan de manera natural por nombre, y su representación es el nombre del departamento. Por ejemplo, `Lenguajes y Sistemas Informáticos`.

Añada también las siguientes operaciones al tipo `Departamento`:

- `borraTutorias`: elimina las tutorías de todos los profesores del departamento.
- `borraTutorias` (por categoría): dada una categoría, elimina las tutorías de todos los profesores del departamento cuya categoría sea la dada como parámetro.


Se pide:

1. Añada al paquete `fp.universidad.tipos` el tipo `Departamento`.
2. En el paquete `fp.universidad.tipos.test`, implemente una clase de test para probar los métodos del tipo.
3. Implemente los métodos pendientes de los tipos definidos en las partes anteriores:
   - **Asignatura**: `getAcronimo`.	
   - **Alumno**: `getCurso`.
   - **Centro**: `getConteosEspacios`, `getDespachos` (las dos versiones), `getProfesores` (las dos versiones), `getEspacioMayorCapacidad`.
   - **Grado**: `getAsignaturas`, `getAsignatura`.
