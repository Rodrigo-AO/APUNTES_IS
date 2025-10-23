# 📘 Análisis de la Complejidad y Eficiencia de Algoritmos

**Asignatura:** Estructuras de Datos y Algoritmos  
**Curso:** 2025-2026  
**Autor:** Rodrigo Arambarri Osuna 

---

## 🧭 Contenido

1. [Introducción](#introducción)
2. [Análisis de la complejidad](#análisis-de-la-complejidad)
3. [Complejidad de sumatorios](#complejidad-de-sumatorios)
4. [Complejidad de recurrencias](#complejidad-de-recurrencias)
5. [Relación entre sumatorios y recurrencias](#relación-sumatorios-y-recurrencias)
6. [Ejemplos prácticos](#ejemplos-prácticos)
7. [Caso mejor, peor y medio](#caso-mejor-peor-y-medio)

---

## 🧩 Introducción

A la hora de **elegir un algoritmo**, se busca que:

- Sea **fácil de entender, codificar, depurar y mantener.**
- Use **eficientemente los recursos** (tiempo, memoria).
- Se ejecute en el **menor tiempo posible.**

Estos objetivos son a menudo **contrapuestos**, teniendo que sacrificar uno para obtener otro, por lo que es esencial **analizar su complejidad**.

---

### 🔹 ¿Qué es el análisis de complejidad?

Es el **estudio del tiempo de ejecución** de un algoritmo en función del **tamaño del problema** (`n`).

Se representa con una **función T(n)**, generalmente **monótona creciente**.

Queremos saber:
> ¿Cómo se comporta T(n) cuando n crece mucho?

---

### 🔹 Jerarquía de órdenes de complejidad

| Orden | Nombre | Ejemplo típico |
|:------|:--------|:----------------|
| O(1) | Constante | Acceso a un elemento de un array |
| O(log n) | Logarítmico | Búsqueda binaria |
| O(n) | Lineal | Recorrido de una lista |
| O(n log n) | Cuasi-lineal | MergeSort, QuickSort promedio |
| O(n²) | Cuadrático | BubbleSort |
| O(n³) | Cúbico | Multiplicación de matrices |
| O(aⁿ) | Exponencial | Backtracking, fuerza bruta |
| O(n!) | Factorial | Generar todas las permutaciones |

---

### 🔹 Ejemplo comparativo

| T(n) | n = 100 | n = 200 | Efecto de duplicar tamaño |
|:------|:----------|:----------|:----------------------------|
| k·log n | 1 s | 1.15 s | casi igual |
| k·n | 1 s | 2 s | el doble |
| k·n log n | 1 s | 2.3 s | algo más del doble |
| k·n² | 1 s | 4 s | cuadruplica |
| k·n³ | 1 s | 8 s | octuplica |
| k·2ⁿ | 1 s | 1.27×10³⁰ s | inasumible 🚫 |

---

## ⚙️ Análisis de la complejidad

### 🔹 Tamaño del problema (n)

Es la **cantidad de información necesaria** para representarlo.  
Cada subproblema debe ser **más pequeño que el original**.

Ejemplo:

```java
boolean contieneMultiplo(List<Integer> lista, int a) {
    for (int e : lista) {
        if (e % a == 0)
            return true; // termina antes si encuentra uno
    }
    return false;
}
```

---

### 🔹 Tipos de bloques

#### Bloque secuencial

```c
s1;
s2;
s3;
```
**Complejidad total:**  
T(n) = T(s1) + T(s2) + T(s3)

#### Bloque condicional (if)

```c
if (g) {
    s1;
} else {
    s2;
}
```

**Complejidad:**  
T(n) = f₁·T(s1) + f₂·T(s2)  
donde `f₁` y `f₂` son las frecuencias de ejecución.

#### Bloque iterativo (while/for)

```c
while (g) {
    s;
}
```

**Complejidad:**  
T(n) = Σ T(s) para cada iteración i  
(número de iteraciones depende de n)

---

## 🧮 Complejidad de sumatorios

Los **bucles** suelen expresarse como **sumatorios**, y su complejidad depende del tipo de progresión:

- **Progresión aritmética (PA):**  
  La variable de control se incrementa en una cantidad fija.  
  Ejemplo: `for (i = 0; i < n; i++)`

- **Progresión geométrica (PG):**  
  La variable se multiplica por una razón constante.  
  Ejemplo: `for (i = 1; i < n; i *= 2)`

### Propiedades útiles

1. Linealidad del sumatorio:  
   Σ(f(i) + g(i)) = Σf(i) + Σg(i)

2. Producto de sumas:  
   Σi Σj f(i)g(j) = (Σi f(i)) (Σj g(j))

3. Extracción de constantes:  
   Si `g(x)` no depende de `i`:  
   Σi g(x)·f(i) = g(x)·Σi f(i)

---

## 🔁 Complejidad de recurrencias

### 🔹 Concepto

Un **algoritmo recursivo** se define en términos de **subproblemas más pequeños**.

**Ecuación de recurrencia:**

```
T(n) = a · T(n/b) + g(n)
```

- `a`: número de subproblemas
- `b`: factor de reducción del tamaño
- `g(n)`: coste fuera de las llamadas recursivas

---

### 🔹 Tipos

| Tipo | Forma general | Ejemplo |
|:-----|:---------------|:----------|
| Lineal | T(n) = a·T(n - b) + g(n) | Recursión simple |
| No lineal | T(n) = a₁·T(n/b₁) + a₂·T(n/b₂) + … + g(n) | Divide y vencerás |

---

### 🔹 Ejemplo: Fibonacci

#### Versión sin memoria

```java
int fib(int n) {
    if (n <= 1) return n;
    return fib(n - 1) + fib(n - 2);
}
```

Ecuación de recurrencia:
> T(n) = T(n-1) + T(n-2) + O(1)

**Complejidad:** O(2ⁿ)

#### Versión con memoria (DP)

```java
int fibDP(int n) {
    int[] f = new int[n+1];
    f[0] = 0; f[1] = 1;
    for (int i = 2; i <= n; i++)
        f[i] = f[i-1] + f[i-2];
    return f[n];
}
```

**Complejidad:** O(n)

---

## 🔗 Relación sumatorios y recurrencias

Transformar una **recursión final** a **iterativa** produce **idéntico orden de complejidad**.

| Forma recursiva | Forma iterativa | Orden |
|:----------------|:----------------|:-------|
| T(n) = T(n-1) + O(1) | Bucle lineal | O(n) |
| T(n) = 2·T(n/2) + O(n) | MergeSort | O(n log n) |
| T(n) = T(n/2) + O(1) | Búsqueda binaria | O(log n) |

---

## 💡 Ejemplos prácticos

### Ejemplo 1 — Bucle simple

```c
for (int i = 0; i < n; i++)
    s;
```

Σ (1) → O(n)

---

### Ejemplo 2 — Bucle anidado

```c
for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++)
        s;
```

Σ Σ (1) → O(n²)

---

### Ejemplo 3 — Recursión doble con bucles

```java
void algo(int n) {
    if (n <= 1) return;
    for (int i = 0; i < n; i++)
        algo(n / 2);
}
```

T(n) = n·T(n/2) + O(n)  
≈ O(n log n)

---

## ⚖️ Caso mejor, peor y medio

Los algoritmos **no siempre tardan lo mismo** para entradas del mismo tamaño.

| Caso | Definición | Símbolo | Ejemplo |
|:------|:-------------|:----------|:----------|
| **Mejor** | Tiempo mínimo posible | Tm(n) | Primer elemento ya cumple condición |
| **Peor** | Tiempo máximo posible | Tp(n) | Ningún elemento cumple condición |
| **Medio** | Tiempo promedio | Td(n) | Depende de distribución f(p) |

---

### 🔹 Ejemplo práctico

```java
boolean contieneMultiplo(List<Integer> lis, int a) {
    for (int e : lis) {
        if (e % a == 0)
            return true;
    }
    return false;
}
```

| Caso | Complejidad | Explicación |
|:-----|:-------------|:------------|
| Mejor | Θ(1) | Primer elemento es múltiplo |
| Peor | Θ(n) | Ninguno lo es |
| Medio | Θ(1) (si la probabilidad es alta) | Depende de distribución |

---

## 🧠 Conclusiones

- La **eficiencia** de un algoritmo depende tanto de su diseño como de su implementación.
- El **análisis de complejidad** permite **comparar algoritmos objetivamente**.
- Las **recurrencias y sumatorios** son las herramientas principales para calcular T(n).
- Es esencial considerar **casos extremos y promedio** para una evaluación completa.

---

## 📚 Referencias recomendadas

- *Thomas H. Cormen et al., "Introduction to Algorithms" (CLRS)*  
- *Weiss, Data Structures and Algorithm Analysis in Java*  
- *Sedgewick, Algorithms in C++*  

---

> 💡 **Consejo final:**  
> Antes de optimizar un algoritmo, mide su rendimiento.  
> “Premature optimization is the root of all evil.” — Donald Knuth
