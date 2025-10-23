def nota_teoria1(lista_notas:list[float]) -> float:
    nota:float = 0.
    contador:int = 0.
    for i in lista_notas:
        nota += i
        contador += 1.
    res = nota/contador
    return res

def nota_teoria2(lista_notas:list[float]) -> float:
    notas:float = sum(lista_notas)
    contador:int = len(lista_notas)
    return notas/contador

def nota_cuatrimestre(listado:list[float]) -> float:
    notas_teo:list[int] = []
    nota_prac = 0.
    nota_final:float = 0.
    for i in range(0, len(listado), 1):
        if(i >=0 and i <= 1):
            notas_teo.append(listado[i])
        else:
            nota_prac = listado[i]
    med_notas_teo:float = nota_teoria2(notas_teo)
    if(med_notas_teo >= 4):
        nota_final = 0.2 * med_notas_teo + 0.8 * nota_prac
    else:
        nota_final = 0
    return nota_final