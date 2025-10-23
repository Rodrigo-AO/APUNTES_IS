# Funcion que me diga si 3 numeros forman una terna pitagorica

def terna_pitagorica(a:float, b:float, c:float)->bool:
    if a**2+b**2==c**2 or b**2+c**2==a**2 or c**2+a**2==b**2:
        terna=True
    else:
        terna=False
    return terna

print(terna_pitagorica(5, 3, 4))
# Estos 3 valores cumplen pitágoras
