def precio_descuento(precio:float, descuento:float=10)->float:
    variacion=precio*descuento/100
    nuevo_precio=precio - variacion
    return nuevo_precio
# Se puede hacer en 2 líneas pero lo ponemos en 2 para hacerlo más claro

print(precio_descuento(120,50))
print(precio_descuento(50))
