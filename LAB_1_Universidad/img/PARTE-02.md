## Fundamentos de Programación
# Proyecto de laboratorio: Gestión Grados Universitarios.
# Parte II

**Autores:** Toñi Reina

**Objetivos:**

- Añadir restricciones a los tipos.
- Añadir criterio de igualdad a los tipos.
- Añadir criterio de orden a los tipos.
- Implementar tipos agregados (o contenedores).	

En este primer bloque vamos a añadir propiedades a los tipos `Asignatura`, `Persona`, `Espacio`, `Nota` y `Tutoria` implementados en la Parte I [PARTE-01.md](./PARTE-01.md). También vamos a implementar los tipos contenedores `Grado`, `Expediente` y `Centro`, teniendo en cuenta las descripciones que se detallan a continuación:

### Restricciones sobre los tipos definidos en la Parte I

Añada a cada clase el código necesario para tener en cuenta las restricciones que hay que controlar sobre algunas de sus propiedades, y que se describen a continuación. Implemente también una clase de test para cada tipo en el que se comprueben sus restricciones. Debe probar tanto los constructores como los métodos que modifiquen propiedades con restricciones. En el caso de los constructores, intente construir objetos con valores incorrectos en las propiedades que tengan restricciones, y compruebe que se lanzan las excepciones correspondientes.  En el caso de los métodos modificadores, construya objetos con valores correctos y posteriormente intente asignar valores incorrectos a las propiedades con restricciones, comprobando que se lanzan las excepciones correspondientes. Use bloques `try/catch` para capturar las excepciones correspondientes.

El código numérico de una **asignatura** consta de 7 dígitos (por ejemplo, `"0000230"`). El número de créditos es siempre mayor que cero y su curso debe tener en cuenta que los grados constan de 4 años. 

El DNI de una **persona** está formado por 8 dígitos y una letra. Además, su email debe contener el carácter `'@'`, o bien ser la cadena vacía si la persona aún no ha comunicado ese dato. 

El **espacio** tiene una única restricción, y es que su capacidad debe ser mayor que 0. 

Las **notas** tienen un valor numérico comprendido entre 0 y 10, ambos inclusive. Por otro lado, una nota sólo puede tener mención de honor si su valor numérico es igual o superior a 9. 

Una **tutoria** sólo puede darse de lunes a viernes y debe tener una duración de al menos 15 minutos. 



### Criterios de igualdad y ordenación de los tipos definidos en la Parte I

Añada el código necesario a los tipos definidos en la Parte I para implementar los siguientes criterios de igualdad y ordenación. Implemente un test para cada tipo donde compruebe el correcto funcionamiento de los nuevos métodos creados. 

Se entenderá que dos objetos distintos del sistema representan a la misma **asignatura** si ambos objetos almacenan el mismo código. El sistema almacena las asignaturas ordenadas alfabéticamente por su código (se considera éste el orden natural para las asignaturas).

Dos **personas** son iguales si tienen el mismo DNI, nombre y apellidos. Las personas se ordenan por apellidos, a igualdad de apellidos por nombre, y a igualdad de nombre por DNI.

Para que dos **espacios** sean iguales deben coincidir su nombre y su planta. Los espacios se ordenan por planta, y a igualdad de ésta por nombre.

Dos **notas** son iguales si corresponden al mismo curso académico, la misma asignatura y la misma convocatoria. Las notas se ordenan por curso académico, a igualdad de curso por asignatura, y a igualdad de asignatura por convocatoria.

En cuanto a las **tutorías**, se consideran iguales si se realizan el mismo día y tienen la misma hora de comienzo. Para ordenarlas se considera el día, y a igualdad de éste la hora de comienzo.


### Tipos contenedores

#### Centro

Un `Centro` representa un centro docente de la universidad. Cada centro se identifica mediante un *nombre* (por ejemplo, `"Escuela Técnica Superior de Ingeniería Informática"`) y una *dirección* (por ejemplo, `"Av. Reina Mercedes, s/n"`), ambos sin restricciones específicas. Además, cuenta con un número de *plantas* que indica la cantidad de niveles sobre rasante (por ejemplo, 3) y un número de *sótanos* que representa las plantas subterráneas del edificio (por ejemplo, 2). Cada centro alberga un conjunto de espacios, que recoge  las distintas áreas ubicadas dentro del centro. Todas estas propiedades son consultables y permanecen inalterables una vez creado el centro. Los espacios del centro se pueden manipular a traves de las operaciones que se describen a continuación:
- `void nuevoEspacio(Espacio e)`, que añade el espacio `e` al centro, siempre que la planta del espacio sea un número de planta válido en el centro. Para ello debe estar comprendida en el intervalo [-s, p-1], siendo p el número de plantas del centro y s el número de sótanos. En caso contrario, eleve la excepción `IllegalArgumentException`.
- `void eliminaEspacio(Espacio e)`. Elimina el espacio e del centro. Si el espacio no pertenece al centro, la operación no tiene efecto.

Un centro se representa por su nombre. Por ejemplo, `"Escuela Técnica Superior de Ingeniería Informática"`. La implementación del tipo tendrá un constructor reciba como parámetros el nombre del centro, su dirección, el número de plantas y el número de sótanos. Los espacios se inicializan con un conjunto vacío.

Además, los objetos de tipo centro deben cumplir las siguientes restricciones: 
(1)	Un centro debe tener al menos una planta, y (2) Un centro puede tener cero o más sótanos. 

Finalmente, dos objetos de tipo `Centro` se consideran iguales si tienen el mismo nombre. Además, los centros se ordenan por su nombre.

El tipo `Centro` también tendrá las siguientes operaciones, que de momento, dejaremos en blanco, haciendo que devuelvan `null` y poniendo un comentario `//TODO`:

- `getConteosEspacios`, devuelve un array de 5 elementos de tipo Integer que representan el número de espacios de tipo aula de teoría, laboratorio, seminario, aula de examen u otro tipo, respectivamente, que hay en el centro.
- `getDespachos`, devuelve un conjunto con todos los espacios de tipo `Despacho` que hay en el centro.
- `getDespachos`, dado un departamento `d`, devuelve un conjunto con todos los despachos del centro donde hay al menos un profesor del departamento d.
- `getProfesores`, devuelve el conjunto de todos los profesores que tienen un despacho en el centro.
- `getProfesores`, dado un departametno `d`, devuelve el conjunto de todos los profesores que pertenecen al departamento d y tienen un despacho en el centro.
- `getEspacioMayorCapacidad`,  devuelve el espacio con mayor capacidad del centro.

______________
#### Expediente

Cada `Expediente` está compuesto por una lista de *notas*, que representan las calificaciones obtenidas en distintas asignaturas a lo largo de un curso académico. Estas notas son consultables y se almacenan en el orden en que se añaden. El expediente también cuenta con una *nota media*, que se calcula como el promedio de las calificaciones con valores numéricos iguales o superiores a 5. En caso de que el expediente esté vacío, la nota media será 0.0.

Un expediente se representará mediante todas las notas que lo componen, por ejemplo: `[(0000230) Fundamentos de Programación, 2014-15, PRIMERA, 7.5, NOTABLE, (2050009) Estructura de Computadores, 2014-15, PRIMERA, 6.3, APROBADO]`. El tipo implementado debe definir un constructor que no tenga parámetros. Las notas se inicializarán con la lista vacía.

Dos expedientes se consideran iguales si contienen exactamente las mismas notas en el mismo orden. No existe un criterio de orden natural definido para los expedientes. 

Las notas de un expediente se gestionan mediante las siguientes operaciones:

- `void nuevaNota(Nota n)`. Añade la nota `n` al expediente. Si en el expediente ya existe una nota para la misma asignatura, convocatoria y curso académico (es decir, otra nota igual según el criterio de igualdad del tipo Nota), se elimina la nota antigua y se añade la nueva. Las notas se añaden siempre al final de la lista.

_____________

#### Grado

Un grado representa una titulación impartida por la Universidad. Un grado se imparte en un centro y consta de unas asignaturas obligatorias y otras optativas, que son impartidas por profesores de los departamentos con docencia en el grado.

Un grado tiene un *nombre*, un conjunto de asignaturas *obligatorias* y un conjunto de asignaturas *optativas*. Además, debe registrar el número *mínimo de créditos* de asignaturas optativas que debe cursar un alumno del grado. También tiene el *número total de créditos* que debe cursar un alumno para obtener el título. Este número se calcula sumando los créditos de todas las asignaturas obligatorias y el número mínimo de créditos de asignaturas optativas que debe cursar.

El grado se representa con el nombre del grado. Por ejemplo, `"Grado en Ingeniería Informática – Ingeniería del Software"`. La implementación del tipo debe proporcionar un constructor que permita crear un grado a partir de todas sus propiedades básicas. Además, los objetos creados deben cumplir las siguientes restricciones: (1) Todas las asignaturas optativas del grado deben tener el mismo número de créditos. (2) El número mínimo de créditos de asignaturas optativas que debe cursar un alumno debe estar comprendido entre cero y el número total de créditos de asignaturas optativas del grado.

Dos grados son iguales si tienen el mismo nombre. Igualmente, el criterio de ordenación natural de los grados es por el nombre del grado.

El tipo `Grado` también tendrá las siguientes operaciones, que de momento, dejaremos en blanco, haciendo que devuelvan `null` y poniendo un comentario `//TODO`:
- `getAsignaturas`, que dado un curso, devuelve un conjunto con todas las asignaturas del grado, tanto obligatorias como optativas, que se imparten en el curso dado.
-	`getAsignatura`, que dado un código, devuelve la asignatura del grado cuyo código es el dado como parámetro, o `null` si no existe ninguna asignatura con dicho código.
	

Se pide:
1. Implemente los tipos anteriores en el paquete `fp.universidad.tipos'.
2. En el paquete `fp.universidad.tipos.test` implemente una clase de test para cada uno de los tipos anteriores y pruebe las operaciones implementadas. Piense en los casos de prueba que debe implementar para cada operación.

