# Que nos diga si el 1º nº es multiplo del 2º

def es_multiplo(n:int, m:int)->bool:
    if n%m==0:
        valor=True
    else:
        valor=False
    return valor

print(es_multiplo(4,2))
