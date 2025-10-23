def calcula_imc(peso: float, estatura: float) -> float:
    imc = (peso)/(estatura * estatura)
    return imc


peso = float(input("Introduzca su peso en kilogramos: ", ))
estatura = float(input("Introduzca su altura en metros: ", ))

print(calcula_imc(peso, estatura))
