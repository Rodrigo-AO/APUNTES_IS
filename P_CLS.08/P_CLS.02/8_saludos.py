import datetime

# def saludos()->str:
#         hora=datetime.datetime.now().time().hour()
#         if hora>6 and hora<13:
#             saludo="Buenos días señor Stark"
#         elif hora>13 and hora<20:
#             saludo="Buenas tardes señor Stark"
#         else:
#             saludo="Buenas noches señor Stark"
#         return saludo

def saludos(mañana:int=13, tarde:int=20, noche:int=6)->str:
    hora=datetime.datetime.now().time().hour
    if hora>noche and hora<mañana:
        saludo="Buenos días señor Stark"
    elif hora>mañana and hora<tarde:
        saludo="Buenas tardes señor Stark"  
    else:
        saludo="Buenas noches señor Stark"
    return saludo

print(saludos())  
