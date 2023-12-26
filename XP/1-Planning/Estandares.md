# ESCUELA POLITÉCNICA NACIONAL

---

**Integrantes:**

- Simbaña Ivan
- Suntasig Ariel
- Terán José
- Torres Jeremy
- Verdezoto José
- Yanez David

---

# Estándares de codificación del Lobito


**1. Nombres de Clases:**

Los nombres de clases deben ser sustantivos y deben tener la primera letra en mayúsculas. Si el nombre es compuesto, cada palabra componente deberá comenzar con maýusculas.
Los nombres serán simples y descriptivos. Debe evitarse el uso de acrónimos o abreviaturas.

El nombre de la clase (`JuegoLobo`) sigue la convención CamelCase y es descriptivo.

---
**2. Variables:**

Las variables se escribirán siempre en minúsculas. Las variables compuestas tendrán la primera letra de cada palabra componente en mayúsculas. Los nombres de variables deben ser cortos y sus significados tienen que expresar con suficiente claridad la función que desempeñan en el código.
</br>

| Nombre                   | Descripción                                                                                             |
| --------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **leftToRight:**    | Indica la dirección del movimiento del observador y otros elementos.              |
| **leftSide:**    | Listas que contienen los elementos en el lado izquierdo y derecho del río respectivamente.              |
| **rightSide:**    | Listas que contienen los elementos en el lado izquierdo y derecho del río respectivamente..              |
| **scanner:**    | Objeto utilizado para la entrada de datos.             |

---
</br>

**3. Métodos:**

Los métodos deben ser verbos escritos en minúsculas. Cuando el método esté compuesto por varias palabras cada una de ellas tendrá la primera letra en mayúsculas.

Los nombres de los métodos (`move`, `printMoves`, `generateWater`, `printState`, `isGameOver`, `isDangerousState`, `checkDangerousState`) son descriptivos y siguen la convención CamelCase.

| Nombre                   | Descripción                                                                                             |
| --------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **move:**    | Mueve un elemento de una lista a otra, gestionando los cambios en los lados del río.        |
| **printMoves:**    | Imprime gráficamente los movimientos realizados en el juego para una mejor visualización.              |
| **generateWater:**    | Genera una representación gráfica del agua.            |
| **printState:**    | Imprime el estado actual de los elementos en ambos lados del río.         |
| **isGameOver:**    | Verifica si el juego ha llegado a su fin, es decir, si todos los elementos han cruzado el río.      |
| **isDangerousState:**    | Verifica si hay un estado peligroso en uno de los lados del río.            |
| **checkDangerousState:**    | Evalúa y maneja situaciones peligrosas en el juego.            |

---
</br>

**4. Longitud de línea**

La longitud de línea no debe superar los 80 caracteres por motivos de visualización e impresión.

---
**5. Otras prácticas**

- Paréntesis

  Es una buena práctica el uso de paréntesis en expresiones que incluyan distintos tipos de operadores para evitar problemas de precedencia de operadores. Aunque la precedencia de operadores nos pueda parecer clara, debemos asumir que otros programadores no tengan un conocimiento exhaustivo sobre las reglas de precedencia.

  Ejemplo

  if (w == x && y == z)     // INCORRECTO

  if ((w == x) && (y == z)) // CORRECTO

  ---
