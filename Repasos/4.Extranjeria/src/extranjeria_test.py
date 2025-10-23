from extranjeria import *

listado = lee_datos_extranjeria('Repaso_convo/Repaso_laboratorios/4.Extranjeria/data/extranjeriaSevilla.csv')
barrio_multicultural:str = barrio_mas_multicultural(listado)
barrio_extranjeros:str = barrio_con_mas_extranjeros(listado)
print(barrio_multicultural)
print(barrio_extranjeros)
