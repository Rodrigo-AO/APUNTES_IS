# TEO-Sevici-Java
**Ejercicio: Servicio de alquiler de bicicletas públicas de Sevilla (Sevici)**

**Autor**: Mariano González, Toñi Reina. **Revisores**: José A. Troyano, Fermín Cruz. **Última modificación**: 13/03/2025

En este ejercicio vamos a trabajar con datos de la red de estaciones del servicio de alquiler de bicicletas de Sevilla (Sevici), disponibles en <https://citybik.es/>. El objetivo del ejercicio es leer estos datos y realizar distintas operaciones con ellos.

Los datos se encuentran almacenados en un fichero en formato CSV codificado en UTF-8. Cada registro del fichero ocupa una línea y contiene los datos correspondientes a una estación: el id de la estación seguido de un guión bajo y el nombre de la estación, el número total de puestos de la estación, el número de bicicletas disponibles, y la latitud y longitud donde se ubica la estación.

Estas son las primeras líneas del fichero. La primera línea es una cabecera que contiene los nombres de los campos del registro:
```
name,slots,free_bikes,latitude,longitude
149_CALLE ARROYO,20,11,37.397829929383,-5.97567172039552
257_TORRES ALBARRACIN,20,4,37.38376948792722,-5.908921914235877
243_GLORIETA DEL PRIMERO DE MAYO,15,9,37.380439481169994,-5.953481197462845
109_AVENIDA SAN FRANCISCO JAVIER,15,14,37.37988413609134,-5.974382770011586
073_PLAZA SAN AGUSTIN,15,4,37.38951386231434,-5.984362789545622
```
Los tipos que forman el modelo de datos son los siguientes:

- **Coordenadas**: ubicación geográfica de una estación.
- **Estacion**: tipo que representa una estación de la red.
- **RedEstaciones**: tipo contenedor que representa una red de estaciones de alquiler de bicicletas.
- **FactoriaRedEstaciones**: Factoría para cargar la red de estaciones del fichero. 

**Tipo Coordenadas**

Propiedades:

- **latitud**, de tipo Double. Consultable. Latitud de las coordenadas.
- **longitud**, de tipo Double. Consultable. Longitud de las coordenadas.
- **unidad**, de tipo UnidadMedida. Consultable. Puede tomar los valores GRADOS, RADIANES.


Constructores:

- Un constructor sin parámetros que crea un objeto con latitud 0º y longitud 0º.
- Un constructor que toma como parámetros la latitud y la longitud. La coordenada creada por defecto se medirá en grados.
- Un constructor que recibe un parámetro por cada propiedad básica del tipo, en el mismo orden en el que están definidas.
- Un constructor a partir de String, que crea una coordenada en grados. Ejemplo de formato de la cadena: “-1.5, 0.22”

Criterio de igualdad: dos coordenadas son iguales si su latitud, su longitud y sus unidad son iguales.

Representación como cadena: generada automáticamente con todas las propiedades básicas del tipo.

Restricciones:

- La latitud debe estar comprendida entre -90º y +90º.
- La longitud debe estar comprendida entre -180º y +180º.

Otras operaciones:
- `Double getDistanciaHaversine (Coordenadas c)`. Calcula la distancia haversine entre dos coordenadas.
- `Coordenadas aRadianes()`: Devuelve una coordenada con la latitud y longitud medida en radianes. Si la coordenada está en radianes, devuelve una copia de la coordenada original.
- `Coordenadas aGrados()`: Devuelve una coordenada con la latitud y longitud medida en grados. Si la coordenada está en grados, devuelve una copia de la coordenada original.


**Tipo Estacion**

Propiedades:

- **id**, de tipo String. Consultable. Identificador de la estación.
- **nombre**, de tipo String. Consultable. Nombre de la estación.
- **num puestos**, de tipo Integer. Consultable. Número de puestos de los que dispone la estación.
- **bicis disponibles**, de tipo Integer. Consultable y modificable. Número de bicicletas disponibles para alquiler en la estación.
- **ubicación**, de tipo Coordenadas. Consultable. Coordenadas geográficas de la estación.
- **puestos vacíos**, de tipo Integer. Consultable. Número de puestos vacíos de la estación, que se calcula como la diferencia entre el número de puestos y el número de bicicletas disponibles.
- **tiene bicis disponibles**, de tipo Boolean. Consultable. Toma valor true si la estación tiene al menos una bicicleta disponible, y false si no hay ninguna.
- **ocupacion**: de tipo Double. Consultable. Devuelve el porcentaje (en %) de ocupación de la estación. La ocupación se calcula como el ratio entre las bicis disponibles y el total de puestos de la estación.


Constructores:

- Un constructor que recibe un parámetro por cada propiedad básica del tipo, en el mismo orden en el que están definidas.

Criterio de igualdad: dos estaciones son iguales si tienen el mismo id.

Criterio de ordenación: por su id.

Representación como cadena: una cadena con todas las propiedades básicas del tipo.

Restricciones:

- R1: El número de puestos debe ser mayor que 0.
- R2: El número de bicicletas disponibles debe ser mayor o igual que 0 y menor o igual que el número de puestos.

**Tipo RedEstaciones**

Propiedades:

- **nombre**, de tipo `String`. Consultable y modificable. Nombre de la red.
- **estaciones**, de tipo `SortedSet<Estacion>`. Consultable. Conjunto ordenado por el id de las estaciones, con las estaciones de la red.
- **numero estaciones**: de tipo Integer, el número de estaciones de la red.
- **totalPuestos**: de tipo Integer, el número total de puestos de la red.
  
Constructores:

- C1: Constructor sin parámetros, que crea una red con la cadena vacía como nombre.
- C2: Constructor con un parámetro de tipo String, que representa el nombre de la red. Crea la red con el nombre dado y sin estaciones.
- C3: Constructor a partir de un nombre y un Set<Estacion>, que crea una red con el el nombre y las estaciones dadas como parámetro.

Criterio de igualdad: dos redes de estaciones son iguales si tienen el mismo nombre.

Representación como cadena: El nombre, seguido de un \n y cada una de las estaciones de la red separadas por retorno de carro antecedido de un índice y un guión. Por ejemplo,
```
sevici
1-Estacion[id=001, nombre=GLORIETA OLIMPICA, numPuestos=20, bicisDisponibles=19, ubicacion=Coordenadas[latitud=37.4129235511391, longitud=-5.98890593824315, unidad=GRADOS]]
2-Estacion[id=002, nombre=GRAN PLAZA, numPuestos=18, bicisDisponibles=16, ubicacion=Coordenadas[latitud=37.381578045327934, longitud=-5.96522396639778, unidad=GRADOS]]
3-Estacion[id=003, nombre=PUERTA DE LA BARQUETA, numPuestos=40, bicisDisponibles=30, ubicacion=Coordenadas[latitud=37.40564154237001, longitud=-5.998488240831263, unidad=GRADOS]]
4-Estacion[id=004, nombre=CALLE LEONARDO DA VINCI, numPuestos=40, bicisDisponibles=11, ubicacion=Coordenadas[latitud=37.41011155757378, longitud=-6.005722268777397, unidad=GRADOS]]
``` 

Otras operaciones:

- `void agregarEstacion(Estacion e)`: añade una estación a la red, si la estación no está en la red. Si ya está, no hace nada.
- `List<Estacion> getEstacionesBicisDisponibles()`: obtiene una lista con las estaciones que tienen alguna bicicleta disponible.
- `List<Estacion> getEstacionesBicisDisponibles(Integer k)`: obtiene una lista con las estaciones que tienen un número mínimo de bicicletas disponibles.
- `SortedSet<Estacion> getEstacionesCercanas(Coordenadas cs, Double distancia)`: obtiene un conjunto ordenado con las estaciones que tienen alguna bicicleta disponible y a una distancia de la ubicación dada, menor o igual que la distancia dada como parámetro.
- `Estacion getEstacionMasBicisDisponibles()`: obtiene la estación que tiene más bicicletas disponibles.
- `Integer getTotalPuestos()`: calcula el total de puestos de bicis de la ciudad.
- `Double getOcupacionMediaEstacionesConBicis()`: obtiene la ocupación media de las estaciones que tienen bicis disponibles. Si no se puede calcular la media, devuelve ```null```.
- `Boolean tienenBicisDisponiblesTodasEstacionesCercanas(Coordenadas cs, Double distancia)`: devuelve cierto si todas las estaciones que se encuentran a una distancia menor o igual que la dada como parámetro del punto con coordenadas cs, tienen bicis disponibles. False en caso contrario.
  
**Tipo FactoriaEstaciones**

Operaciones:
- `RedEstaciones leerRedEstaciones(String nombreFichero, String nombreRed)`: lee un fichero de estaciones y construye un objeto de tipo RedEstaciones con el nombre de la red dado como parámetro.
- `Estacion parsearEstacion(String lineaCSV)`: crea un objeto de tipo Estación a partir de una cadena de caracteres. La cadena de caracteres debe tener el mismo formato que las líneas del fichero CSV.


