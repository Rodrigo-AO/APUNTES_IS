def valor_absoluto(n:int)->int: # No ponemos float ya que puede ser un nº negativo -> integer
    if n>0:
        valor=n
    else:
        valor=-n
    return valor
# Le decimps que si n > 0 (positivo), nos lo devuelva tal cual, y si no que lo cambie de signo

print(valor_absoluto(-4))
