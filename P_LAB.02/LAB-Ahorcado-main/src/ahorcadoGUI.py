import tkinter as tk
from tkinter import messagebox

from ahorcado import *

# Clase principal con interfaz gráfica
class AhorcadoApp:
    def __init__(self, root, palabras, max_intentos=6):
        self.root = root
        self.root.title("Juego del Ahorcado")

        # Variables del juego
        self.palabras = palabras
        self.max_intentos = max_intentos
        self.intentos_restantes = max_intentos
        self.letras_probadas = set()
        self.palabra_secreta = elegir_palabra(self.palabras)

        # Interfaz gráfica
        self.label_palabra = tk.Label(root, text=enmascarar_palabra(self.palabra_secreta, self.letras_probadas), font=("Helvetica", 20))
        self.label_palabra.pack(pady=20)

        self.label_intentos = tk.Label(root, text=f"Intentos restantes: {self.intentos_restantes}", font=("Helvetica", 14))
        self.label_intentos.pack(pady=10)

        self.entry_letra = tk.Entry(root, font=("Helvetica", 16))
        self.entry_letra.pack(pady=10)

        self.boton_comprobar = tk.Button(root, text="Comprobar letra", command=self.comprobar_letra_gui)
        self.boton_comprobar.pack(pady=10)

        self.label_mensaje = tk.Label(root, text="", font=("Helvetica", 14), fg="red")
        self.label_mensaje.pack(pady=10)

        # Área de dibujo del ahorcado
        self.canvas = tk.Canvas(root, width=200, height=250)
        self.canvas.pack(pady=20)

        # Dibujar la base de la horca
        self.dibujar_base()

    def dibujar_base(self):
        """Dibuja la base de la horca"""
        self.canvas.create_line(20, 230, 180, 230, width=5)  # Base horizontal
        self.canvas.create_line(50, 230, 50, 50, width=5)    # Pilar vertical
        self.canvas.create_line(50, 50, 150, 50, width=5)    # Parte superior horizontal
        self.canvas.create_line(150, 50, 150, 80, width=5)   # Cuerda

    def dibujar_ahorcado(self, intentos):
        """Dibuja las partes del ahorcado según los intentos fallidos"""
        if intentos == 5:  # Cabeza
            self.canvas.create_oval(125, 80, 175, 130, width=3)
        elif intentos == 4:  # Cuerpo
            self.canvas.create_line(150, 130, 150, 180, width=3)
        elif intentos == 3:  # Brazo izquierdo
            self.canvas.create_line(150, 140, 120, 160, width=3)
        elif intentos == 2:  # Brazo derecho
            self.canvas.create_line(150, 140, 180, 160, width=3)
        elif intentos == 1:  # Pierna izquierda
            self.canvas.create_line(150, 180, 130, 210, width=3)
        elif intentos == 0:  # Pierna derecha
            self.canvas.create_line(150, 180, 170, 210, width=3)

    def comprobar_letra_gui(self):
        letra = self.entry_letra.get().lower()

        if len(letra) != 1 or not letra.isalpha():
            self.label_mensaje.config(text="Introduce una sola letra.")
            return

        if letra in self.letras_probadas:
            self.label_mensaje.config(text="Ya has probado esa letra.")
            return

        # Reset mensaje
        self.label_mensaje.config(text="")
        self.letras_probadas.add(letra)

        # Comprobar si la letra está en la palabra
        if comprobar_letra(self.palabra_secreta, letra):
            self.label_mensaje.config(text=f"¡La letra '{letra}' está en la palabra!", fg="green")
        else:
            self.label_mensaje.config(text=f"La letra '{letra}' no está en la palabra.", fg="red")
            self.intentos_restantes -= 1
            self.dibujar_ahorcado(self.intentos_restantes)

        # Actualizar interfaz
        self.label_palabra.config(text=enmascarar_palabra(self.palabra_secreta, self.letras_probadas))
        self.label_intentos.config(text=f"Intentos restantes: {self.intentos_restantes}")
        self.entry_letra.delete(0, tk.END)

        # Comprobar si el jugador ha ganado
        if comprobar_palabra_completa(self.palabra_secreta, self.letras_probadas):
            self.fin_juego(ganador=True)

        # Comprobar si el jugador ha perdido
        if self.intentos_restantes == 0:
            self.fin_juego(ganador=False)

    def fin_juego(self, ganador):
        if ganador:
            messagebox.showinfo("Juego Terminado", f"¡Felicidades! Has adivinado la palabra: {self.palabra_secreta}")
        else:
            messagebox.showinfo("Juego Terminado", f"Has perdido. La palabra era: {self.palabra_secreta}")

        # Reiniciar el juego
        self.reiniciar_juego()

    def reiniciar_juego(self):
        self.palabra_secreta = elegir_palabra(self.palabras)
        self.letras_probadas.clear()
        self.intentos_restantes = self.max_intentos
        self.label_palabra.config(text=enmascarar_palabra(self.palabra_secreta, self.letras_probadas))
        self.label_intentos.config(text=f"Intentos restantes: {self.intentos_restantes}")
        self.label_mensaje.config(text="")
        self.canvas.delete("all")  # Limpiar el canvas
        self.dibujar_base()  # Dibujar nuevamente la base de la horca


# Cargar palabras desde un archivo
palabras = cargar_palabras("data/palabras_ahorcado.txt")

# Crear ventana
root = tk.Tk()
app = AhorcadoApp(root, palabras, 6)

# Iniciar la aplicación
root.mainloop()
