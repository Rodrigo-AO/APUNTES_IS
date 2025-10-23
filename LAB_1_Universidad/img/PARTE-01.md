## Fundamentos de Programación
# Proyecto de laboratorio: Gestión Grados Universitarios.
# Parte I

**Autores:** Toñi Reina

**Revisores**: 

**Objetivos:**

- Conocer cuándo un tipo se implementa con una clase y cuándo se puede implementar con un record.
- Distinguir entre propiedades básicas y propiedades derivadas.
- Saber diseñar un tipo , y
	- Definir sus atributos.
	- Implementar los constructores.
	- Implementar los getters y setters y otras operaciones.
	- Implementar el método `toString`.
- Decidir si un tipo se implementa como una clase o como un *record*.

En este primer bloque vamos a implementar las entidades `Asignatura`, `Persona`, `Espacio`, `Nota` y `Tutoria`, teniendo en cuenta las siguientes descripciones:

#### Asignatura

Una `Asignatura` es una entidad fundamental en la aplicación. Cada asignatura se identifica mediante un *nombre* (por ejemplo `"Fundamentos de Programación"`), un *acrónimo* (que se construye a partir de las mayúsculas que aparecen en el nombre de la asignatura, por ejemplo `"FP"`) y un *código* numérico de 7 dígitos (por ejemplo, `"0000230"`). Cada asignatura tiene un número determinado de *créditos* (se admiten asignaturas con número no entero de créditos). Las asignaturas pueden ser de tres *tipos*, según el periodo del curso en el que se imparten: anual, de primer cuatrimestre o de segundo cuatrimestre. Cada asignatura es impartida en un *curso*. Ninguna de las propiedades que definen a una asignatura varía, una vez creada la misma.

Las asignaturas serán representadas textualmente en la aplicación mediante el código de la misma entre paréntesis, seguido del nombre, por ejemplo, `"(0000230) Fundamentos de Programación"`. Se requiere que la  implementación del tipo contenga un constructor que permita crear objetos para representar asignaturas a partir de todas las propiedades básicas que las definen. **Nota**: aún no sabemos cómo calcular el acrónimo de la asignatura, así que de momento haga que el método devuelva `null` y coloque un comentario de tipo `//TODO` para completarlo más adelante.
______________

#### Persona

El tipo `Persona` se utiliza para modelar a todas las personas que participan en la aplicación. Cada persona tiene un *DNI* (formado siempre por ocho dígitos y una letra), un *nombre*, unos *apellidos*, una *fecha de nacimiento*, una *dirección de email* y una *edad*. Todas las propiedades de la persona pueden variar una vez creada.

Una persona se representará mediante el DNI, seguido de un guión, los apellidos, una coma, el nombre, otro guión y la fecha de nacimiento. Por ejemplo: `"28864657W – García Vaquero, Pascual – 15/09/1998"`. Se requiere que la implementación del tipo contenga dos constructores, uno que permita crear objetos para representar personas a partir de todas sus propiedades básicas, y otro con todas las propiedades básicas excepto el email, que se inicializará con una cadena vacía.

______________
#### Espacio

Un `Espacio` representa un lugar físico ubicado en un centro y en el cual se realizan tareas docentes. Un espacio puede ser de varios *tipos*: un aula de teoría, un laboratorio, un seminario, un aula de examen o de otro tipo. Cada espacio tiene un *nombre* (por ejemplo, "A3.10") y una *capacidad* dada por el número máximo de personas que admite. Además, un espacio está ubicado en una determinada *planta*. Todas las propiedades de un espacio pueden variar una vez creado, con excepción de la planta.

Un espacio se representará mediante su nombre seguido de la planta entre paréntesis. Por ejemplo, `"A3.10 (planta 3)"`. La implementación del tipo tendrá un único constructor con todas sus propiedades básicas.
______________
#### Nota

Una `Nota` representa la calificación obtenida por un alumno en una *asignatura* de un *curso académico* concreto, dado por el año de comienzo del mismo (por ejemplo, 2014 para el curso 2014/15). La nota corresponde a una *convocatoria*, que puede ser la primera, la segunda, o la tercera, y tiene un *valor* numérico comprendido entre 0 y 10. Si el valor numérico es mayor o igual a 9, la nota puede ser distinguida con una *mención de honor*. La nota también tiene una calificación, que se calcula a partir del valor numérico y de la mención de honor, y que puede ser suspenso (si el valor numérico es menor que 5), aprobado (si el valor numérico es mayor o igual que 5 y menor que 7), notable (si el valor numérico es mayor o igual que 7 y menor que 9), sobresaliente (si el valor numérico es mayor o igual que 9 y la nota no tiene mención de honor) o matrícula de honor (si el valor numérico es mayor o igual que 9 y la nota tiene mención de honor). Ninguna de las propiedades que definen a una nota varía una vez creada la misma.

Una nota se representará mediante la asignatura, el curso académico (formado por el año de inicio del curso seguido de un guión y de los dos últimos dígitos del año de final del curso), la convocatoria, el valor numérico y la calificación, separados por comas. Por ejemplo, `"(0000230) Fundamentos de Programación, 2014-15, PRIMERA, 7.5, NOTABLE"`. La implementación del tipo tendrá dos constructores, uno que permita crear objetos para representar notas a partir de todas sus propiedades básicas, y otro con todas las propiedades básicas excepto la mención de honor, que se inicializará con un valor falso.
______________
#### Tutoría

La `Tutoria` representa un intervalo de tiempo que todo profesor tiene reservado para atender a sus alumnos. Una tutoría tiene lugar un *día de la semana* (de lunes a viernes)[^1] y tiene una *hora de comienzo*, una *hora de fin* y una *duración* en minutos, que es la diferencia entre la hora de fin y la hora de comienzo. Ninguna de las propiedades que definen a una tutoría varía una vez creada la misma.

Una tutoría se representará por un carácter que indica el día (L, M, X, J o V), seguido de la hora de comienzo, un guión y la hora de fin. Por ejemplo, `"X 10:30-12:30"`. La implementación del tipo tendrá dos constructores, uno con el día de la semana, la hora de inicio y la hora de fin, y otro con el día, la hora de inicio y la duración.

[^1]: Utilice el tipo de Java `DayOfWeek`(http://docs.oracle.com/javase/8/docs/api/java/time/DayOfWeek.html). 

Se pide:
1. Cree un paquete `fp.universidad.tipos` e implemente los tipos anteriores. ¿Cuales se implementarán como una clase y cuáles como un record?. Incluya para cada uno de ellos los atributos necesarios, los constructores, los getters/setters, y la representación como cadena (`toString`). Implemente también en el mismo paquete los tipos enumerados que dan soporte a las entidades descritas anteriormente.
2. Cree un paquete `fp.universidad.tipos.test` e implemente una clase de test para cada uno de los tipos anteriores. En la clase de test debe crear un objeto por cada constructor disponible, y posteriormente debe mostrar en la consola el objeto completo y también cada una de sus propiedades consultables por separado. 


