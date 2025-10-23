## Fundamentos de Programación
# Ejercicio de laboratorio: Extranjería
### Autora: Toñi Reina
---

En este proyecto trabajaremos sobre datos del Ayuntamiento de Sevilla relativos a extranjeros residentes en la ciudad. 

## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes módulos de Python que conforman el proyecto.
    * **extranjeria.py**: Contiene funciones para explotar los datos de extranjería.
    * **extranjeria_test.py**: Contiene funciones de test para probar las funciones del módulo `extranjeria.py`. En este módulo está el main.
* **/data**: Contiene el dataset o datasets del proyecto
    * **extranjeriaSevilla.csv**: Archivo con los datos de extranjeros residentes en Sevilla.

## Ejercicios a realizar

Accediendo al portal de datos abiertos del Ayuntamiento de Sevilla, obtenemos un fichero en formato CSV, codificado en UTF-8, con datos sobre el número de extranjeros que habitan en los distintos barrios, distritos y secciones de distritos. Cada registro del fichero ocupa una línea y contiene los datos correspondientes a los extranjeros de un país en un barrio, de forma que cada línea contiene: el código del distrito, el código de la sección del distrito, el nombre del barrio, el país del que proceden los extranjeros, el número de extranjeros hombres y el número de extranjeros mujeres que viven en ese barrio. Estas son las primeras líneas del fichero:

```
"DISTRITO","SECCION","BARRIO","PAIS_NACIMIENTO","HOMBRES","MUJERES" 
" 01"," 001","SANTA CATALINA","ALEMANIA",8,6 
" 01"," 001","SANTA CATALINA","ARGELIA",0,1 
" 01"," 001","SANTA CATALINA","ARGENTINA",2,4 
" 01"," 001","SANTA CATALINA","ARMENIA",0,1 
```

Para almacenar estos datos en memoria, utilizaremos tuplas con nombre con la siguiente definición:

``
RegistroExtranjeria = namedtuple('RegistroExtranjeria', 'distrito,seccion,barrio,pais,hombres,mujeres')
``

El  objetivo  del  ejercicio  es  leer  estos  datos  y  realizar  distintas  operaciones  con  ellos.  Cada  operación  se implementará en una función distinta. Use funciones auxiliares cuando lo crea conveniente para mejorar la legibilidad del código. Las funciones a implementar son:

* **lee_datos_extranjeria(ruta_fichero)**: recibe la ruta del fichero CSV, devolviendo una lista de tuplas de tipo RegistroExtranjeria con toda la información contenida en el fichero.
* **numero_nacionalidades_distintas(registros)**: recibe una lista de tuplas de tipo RegistroExtranjeria y devuelve el número de nacionalidades distintas  presentes en los registros de la lista recibida como parámetro.  
* **secciones_distritos_con_extranjeros_nacionalidades(registros,  paises)**:  recibe una lista de tuplas de tipo RegistroExtranjeria y un conjunto de cadenas con nombres de países, y devuelve  una lista  de  tuplas  (distrito,  seccion)  con  los distritos y secciones en los que  hay  extranjeros del conjunto de paises dado como parámetro. La lista de tuplas devuelta estará ordenada por distrito.  
* **total_extranjeros_por_pais(registros)**: recibe una lista de tuplas de tipo RegistroExtranjeria y devuelve un diccionario de tipo `{str:int}` en el que las claves son los países y los valores son el número total de extranjeros (tanto hombres como mujeres) de cada país.
* **top_n_extranjeria(registros,  n=3)**: recibe una lista de tuplas de tipo RegistroExtranjeria y devuelve  una  lista  de  tuplas (pais,  numero_extranjeros) con los n países de los que hay más población extranjera en los registros pasados como parámetros. 
* **barrio_mas_multicultural(registros)**: recibe una lista de tuplas de tipo RegistroExtranjeria y devuelve  el  nombre  del  barrio  en  el  que hay un mayor número de países de procedencia distintos.
* **barrio_con_mas_extranjeros(registros, tipo=None)**: recibe una lista de tuplas de tipo RegistroExtranjeria y devuelve el nombre del barrio en el que hay un mayor número de extranjeros, bien sea en total (tanto hombres como mujeres) si `tipo` tiene el valor `None`, bien sea de hombres si `tipo` es `'Hombres'`, o de mujeres si `tipo` es `'Mujeres'`.
* **pais_mas_representado_por_distrito(registros)**: recibe una lista de tuplas de tipo RegistroExtranjeria y devuelve un diccionario de tipo `{str:str}` en el que las claves son los distritos y los valores los países de los que hay más extranjeros residentes en cada distrito.

Implemente tests para cada una de las funciones de `extranjeria.py` en el módulo `extranjeria_test.py`. A continuación, se le proporciona una posible salida de dicho test:

```
TEST DE LA FUNCIÓN lee_datos_extranjeria:
Leídos 19231 registros.
Mostrando los 3 primeros:
DatosExtranjeros(distrito=' 01', seccion=' 001', barrio='SANTA CATALINA', pais='ALEMANIA', hombres=8, mujeres=6)
DatosExtranjeros(distrito=' 01', seccion=' 001', barrio='SANTA CATALINA', pais='ARGELIA', hombres=0, mujeres=1)
DatosExtranjeros(distrito=' 01', seccion=' 001', barrio='SANTA CATALINA', pais='ARGENTINA', hombres=2, mujeres=4)
Mostrando los 3 últimos:
DatosExtranjeros(distrito=' 11', seccion=' 019', barrio='LOS REMEDIOS', pais='TOGO', hombres=0, mujeres=1)
DatosExtranjeros(distrito=' 11', seccion=' 019', barrio='LOS REMEDIOS', pais='TUNEZ', hombres=1, mujeres=0)
DatosExtranjeros(distrito=' 11', seccion=' 019', barrio='LOS REMEDIOS', pais='UCRANIA', hombres=0, mujeres=3)
##############################################################

TEST DE LA FUNCIÓN numero_nacionalidades_distintas:
Hay 186 nacionalidades distintas en los datos.
##############################################################

TEST DE LA FUNCIÓN secciones_distritos_con_extranjeros_nacionalidades:
Hay 503 secciones de distritos con residentes cuya procedencia es ALEMANIA o ITALIA.
Mostrando 3 secciones:
[(' 01', ' 001'), (' 01', ' 002'), (' 01', ' 003')]
##############################################################

TEST DE LA FUNCIÓN total_extranjeros_por_pais:
Mostrando el número de residentes para algunos países de procedencia:
ALEMANIA: 2074
ITALIA: 1538
MARRUECOS: 6035
##############################################################

TEST DE LA FUNCIÓN top_n_extranjeria:
Mostrando los 5 países de los que proceden más residentes:
[('MARRUECOS', 6035), ('BOLIVIA', 3409), ('COLOMBIA', 3284), ('CHINA', 3232), ('ECUADOR', 3100)]
##############################################################

TEST DE LA FUNCIÓN barrio_mas_multicultural:
El barrio más multicultural de sevilla es COLORES, ENTREPARQUES
##############################################################

TEST DE LA FUNCIÓN barrio_con_mas_extranjeros:
El barrio con más residentes extranjeros es COLORES, ENTREPARQUES.
El barrio con más hombres residentes extranjeros es LA PLATA.
El barrio con más mujeres residentes extranjeras es LOS REMEDIOS.
##############################################################

TEST DE LA FUNCIÓN pais_mas_representado_por_distrito:
Los países con más residentes en cada distrito son los siguientes:
Distrito: 01 => FRANCIA
Distrito: 02 => BOLIVIA
Distrito: 03 => MARRUECOS
Distrito: 04 => MARRUECOS
Distrito: 05 => MARRUECOS
Distrito: 06 => MARRUECOS
Distrito: 07 => MARRUECOS
Distrito: 08 => MARRUECOS
Distrito: 09 => COLOMBIA
Distrito: 10 => MARRUECOS
Distrito: 11 => MARRUECOS
##############################################################```
