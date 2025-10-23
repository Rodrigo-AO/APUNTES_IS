## Fundamentos de Programación
# Proyecto de laboratorio: Gestión Grados Universitarios.
# Parte III

**Autores:** Toñi Reina

**Objetivos:**

- Definir tipos utilizando herencia.

En este tercer bloque vamos a reutilizar mediante herencia los tipos `Persona` y `Espacio` definidos en la Parte I [PARTE-01.md](./PARTE-01.md) para implementar los tipos `Alumno`, `Profesor` y `Despacho` mediante las descripciones que se indican a continuación.

### Alumno

Un `Alumno` tiene las mismas propiedades y operaciones que una persona, y además, tiene las siguientes propiedades específicas de un alumno: un conjunto de *asignaturas*, que representa las asignaturas en las que está matriculado el alumno; y el *curso* del alumno. El curso de un alumno es el mayor de los cursos de las asignaturas en que está matriculado, o 0 si no está matriculado en ninguna asignatura. Esta propiedad no se implementa de momento. Además, todos los alumnos tienen un *expediente* en el que registran las calificaciones obtenidas por el alumno en las distintas asignaturas en las que está matriculado.

El email de un alumno no puede ser la cadena vacía y debe acabar en “@alum.us.es”. 

El tipo `Alumno` tendrá un constructor para poder crear un alumno a partir de todas todas las propiedades básicas de una persona. Inicialmente el alumno no estará matriculado en ninguna asignatura. 

Se considera que dos alumnos son iguales si tienen el mismo DNI, apellidos y nombre. Los alumnos se ordenan de forma natural utilizando el mismo criterio que cualquier otra persona.

La representación de un alumno será el número del curso seguido del carácter ‘º’, entre paréntesis, seguido de un espacio y la representación como cadena de la persona. Por ejemplo, "(1º) 28864657W – García Vaquero, Pascual – 15/09/1998”. **Nota**: hasta que no se implemente la propiedad curso, use un interrogante (?) para representar el curso del alumno; coloque un TODO para añadirlo más adelante. 

Además, sobre un alumno se pueden realizar las siguientes operaciones:

Operaciones:
- `matriculaAsignatura`, que dada una asignatura, añade esa asignatura al conjunto de asignaturas en las que está matriculado el alumno. Si el alumno ya está matriculado en esa asignatura, se elevará la excepción `IllegalArgumentException`.
- `eliminaAsignatura`, 	que dada una asignatura, la elimina del conjunto de asignaturas en las que está matriculado el alumno. Si el alumno no está matriculado en esa asignatura, se elevará la excepción `IllegalArgumentException`.
- `estaMatriculadoEn`, que dada una asignatura devuelve `true` si el alumno está matriculado en la asignatura dada, y `false` en caso contrario.
- `evaluaAsignatura`, que dados una asignatura, un curso, una convocatoria, una nota, y si el alumno tiene mención de honor, y añade esta información al expendiente del alumno, siempre que el alumno esté matriculado en la asignatura dada. Si el alumno no está matriculado en la asignatura, se elevará la excepción `IllegalArgumentException`.
_____________

### Profesor

Un `Profesor` tiene las mismas propiedades y operaciones que una persona y, además, cuenta con una *categoría*, que puede ser CATEDRATICO, TITULAR, CONTRATADO_DOCTOR, COLABORADOR, AYUDANTE_DOCTOR, AYUDANTE e INTERINO. También cuenta con un conjunto ordenado con las tutorías que oferta. La categoría de un profesor se puede modificar una vez creado el objeto.

Un profesor debe ser una persona mayor de edad (tener más de 18 años).

El tipo `Profesor` debe proporcionar un constructor que permita crear un profesor a partir de todas las propiedades básicas de una persona y la categoría del profesor. Inicialmente el profesor creado no tendrá tutorías.

Se considera que dos profesores son iguales si tienen el mismo DNI, nombre y apellidos. Dos profesores se ordenan de forma natural utilizando el mismo criterio que cualquier otra persona. Además, un profesor se representa de la misma forma que una persona, seguido de la categoría profesional entre paréntesis. Por ejemplo, "28200400P – Martín Oviedo, María – 21/05/1985 (TITULAR)".

Sobre un profesor se pueden realizar las siguientes operaciones:

- `nuevaTutoria`, que dados una hora de comienzo, de tipo `LocalTime`, un número entero que representa la duración y un día de la semana (de tipo `DayOfWeek`), añade una nueva tutoría al profesor con esos datos.
- `borraTutoria`, que dados una hora de comienzo (de tipo `LocalTime`) y un día de la semana (de tipo `DayOfWeek`), elimina la tutoría con el día y hora de comienzo indicados; si el profesor no tenía esa tutoría, la operación no tiene efecto.
- `borraTutorias`, que elimina todas las tutorías del profesor.

_____________

### Despacho

Un `Despacho` tiene las mismas propiedades y operaciones que un `Espacio`, y además, tiene un conjunto de *profesores*, que representa los profesores que ocupan el despacho. El conjunto de profesores se puede cambiar, una vez creado el despacho.

Para asegurar la integridad de los datos, se debe tener en cuenta que el número de profesores que ocupan un despacho no puede superar la capacidad del mismo. También se debe asegurar que el tipo de espacio asignado a un despacho siempre tiene que ser el correspondiente a ‘otro tipo’. Por lo tanto, si se intenta invocar a la operación `setTipo`, heredada del tipo `Espacio`, se debe elevar la excepción `UnsupportedOperationException`.

El tipo `Despacho` debe dar flexibilidad a la hora de crear los objetos, por lo que deberá proporcionar tres constructores distintos. El *primer constructor* creará un despacho a partir de los mismos parámetros que el constructor del tipo Espacio salvo el tipo, que se inicializará con el valor 'OTRO', junto con  un conjunto de profesores. El *segundo constructor* creará un despacho a partir de los mismos parámetros que el constructor del tipo Espacio salvo el tipo, que se inicializará con el valor 'OTRO', junto con un solo profesor. Finalmente, el *tercer constructor* creará un despacho a partir de los mismos parámetros que el constructor del tipo Espacio salvo el tipo, que se inicializará con el valor 'OTRO'. En este caso el despacho no tendrá ningún profesor asignado.
 
Dos despachos son iguales si tienen el mismo nombre y están en la misma planta. Además, su ordenación natural coincide con la de cualquier otro espacio. Finalmente, un despacho tiene la misma representación que los espacios, seguida de los profesores que ocupan el despacho (utilice la representación como cadena de la propiedad `profesores`). Por ejemplo: "M2.25 (planta 2) [28200400P – Martín Oviedo, María – 21/05/1985 (TITULAR), 33123210J – Vegarredonda Ordiales, Jorge – 25/11/1990 (CONTRATADO_DOCTOR)]".


Se pide:
1. Implemente los tipos anteriores en el paquete `fp.universidad.tipos'.
2. En el paquete `fp.universidad.tipos.test` implemente una clase de test para cada uno de los tipos anteriores y realice con ellos las mismas pruebas que ya ha realizado con los tipos definidos en los boletines anteriores.
