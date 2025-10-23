## Fundamentos de Programación
# Proyecto de laboratorio: Gestión Grados Universitarios.
# Parte V

**Autores:** Toñi Reina


**Objetivos:**
- Trabajar con los tipos `Map` y `SortedMap`.
- Trabajar con el esquema de creación de `Map`.


En este quinto bloque vamos a añadir una nueva propiedad de tipo `Map` al tipo `Profesor` y definir operaciones en el tipo para gestionar esta propiedad. Además, ampliaremos los tipos `Centro`, `Departamento`, `Grado` y `Alumno` con nuevas operaciones que devuelvan objetos de tipo `Map` y `SortedMap`. Estas operaciones permitirán establecer relaciones entre distintos tipos de objetos, como los despachos que ocupan los profesores, los profesores que imparten una asignatura, etc. Para ello, añada las operaciones que se indican a continuación:


### Profesor

Además de las tutorías y el resto de propiedades especificadas en la [PARTE-03.md](./PARTE-03.md), un profesor imparte una serie de créditos en distintas asignaturas. Modelaremos esta propiedad mediante un nuevo atributo de tipo `Map<Asignatura,Double>`, donde la clave representa las asignaturas que imparte el profesor y el valor, el número de créditos que el profesor imparte de esa asignatura. 

Modifique el tipo `Profesor` para gestionar esta nueva propiedad. En concreto:

1. Añada el atributo correspondiente a la clase.
2. Modifique el constructor para inicializar la propiedad con un `HashMap` vacío.
3. Añada las siguientes operaciones al tipo:

   - `getAsignaturas`, devuelve una lista con las asignaturas en las que está involucrado el profesor.
   - `getCreditos`, devuelve una lista de valores `Double` con los créditos impartidos por el profesor.
   - `imparteAsignatura`, que dadas una asignatura y una dedicación (el número de créditos que el profesor imparte en la asignatura), añade la asignatura a las asignaturas que imparte el profesor. Si la asignatura ya era impartida por el profesor, se actualiza la dedicación. Un profesor puede impartir una asignatura si la dedicación es mayor a cero, no supera el número de créditos de la asignatura y el total de créditos que imparte no puede superar los 24 créditos. 
   - `eliminaAsignatura`, que dada una asignatura, elimina la asignatura de las asignaturas que imparte el profesor. Si la asignatura no está registrada, la operación no tiene efecto.
   - `dedicacionAsignatura`, que dada una asignatura, devuelve el número de créditos impartidos en esa asignatura. Si el profesor no la imparte, devuelve `0.0`.
   - `getDedicacionTotal`, que devuelve el total de créditos que imparte el profesor, que se calculan como la suma los créditos de dedicación a las asignaturas.

___________ 

### Centro


`getDespachosPorProfesor`, que devuelve un `SortedMap< String, Despacho>` que hace corresponder a cada profesor con el despacho que ocupa en el centro. Las claves son las representaciones como cadena de los profesores. 

_____________

### Departamento

- `getProfesoresPorAsignatura`, que devuelve un `SortedMap<Asignatura, SortedSet<Profesor>>` que hace corresponder a cada asignatura con el conjunto de profesores que la imparten. 
- `getTutoriasPorProfesor` que devuelve un `SortedMap<String, SortedSet<Tutoria>>` que hace corresponder a cada profesor con el conjunto de tutorías que tiene.  Las claves son las representaciones como cadena de los profesores. 

_____________

### Grado

- `getCreditosPorAsignatura`, que devuelve un `SortedMap<Asignatura, Double>` que hace corresponder a cada asignatura con su número de créditos. Se deben incluir tanto obligatorias como optativas.

- `getTotalCreditosPorCurso`, que devuelve un `Map<Integer, Double>` que hace corresponder a cada curso el número total de créditos de las asignaturas de ese curso. Se deben incluir tanto obligatorias como optativas.
 
_____________
### Alumno

- `getCalificacionPorAsignatura`, que devuelve un `SortedMap<Asignatura, Calificacion>` que hace corresponder a cada asignatura que aparece en el expediente del alumno la calificación máxima obtenida en ella. 

- `getNumAsignaturasPorCurso`, que devuelve un `Map<Integer, Integer>` que asocia un curso y el número de asignaturas de ese curso en las que está matriculado el alumno.

Se pide:
1. Añadir las operaciones especificadas anterioremente a los tipos correpondientes.
2. En el paquete `fp.universidad.tipos.test` añada a la clase de test implementadas en las partes anteriores para cada uno de los tipos anteriores y realice con ellos las pruebas correspondientes a las nuevas operaciones.
