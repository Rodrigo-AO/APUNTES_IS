# Funcion que responde con buenos dias, tarde o noches
import datetime


def saludos(mañana: int = 13, tarde: int = 20, noche: int = 23) -> str:
    hora = datetime.datetime.now().time().hour
    if hora > mañana and hora < tarde and hora < noche:
        saludo = "Buenos días señor Stark"
    elif hora > mañana and hora > tarde and hora < noche:
        saludo = "Buenas tardes señor Stark"
    else:
        saludo = "Buenas noches señor Stark"
    return saludo


print(saludos())
