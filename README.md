# 🎨 VisionColores

![Java](https://img.shields.io/badge/Java-17+-orange)
![Status](https://img.shields.io/badge/status-en%20desarrollo-yellow)
![License](https://img.shields.io/badge/license-educational-blue)

Sistema de detección de colores en imágenes desarrollado en Java, basado en aprendizaje a partir de datos y técnicas como lógica difusa y estructuras tipo árbol de decisión.

---

## 📌 Descripción

**VisionColores** es un proyecto que permite entrenar un sistema para reconocer y clasificar colores a partir de imágenes, y posteriormente aplicar ese conocimiento a nuevas imágenes.

El enfoque combina:

- 🌈 **Procesamiento de imágenes**
- 🧠 **Lógica difusa (Fuzzy Logic)** para tratar la incertidumbre en los colores
- 🌳 **Árbol de decisión** (`ArbolColores`) para estructurar y organizar el aprendizaje

> ⚠️ Nota: Solo la carpeta `DeteccionColor` contiene la lógica relevante del proyecto.

---

## 📂 Estructura del Proyecto

```
src/
└── main/
    └── java/
        ├── Main.java
        └── DeteccionColor/
            ├── (clases de detección de color)
```

- `Main.java` → Punto de entrada del programa  
- `DeteccionColor/` → Núcleo del sistema (procesamiento y lógica)

---

## 🚀 Flujo de ejecución

### 1. Inicialización

```java
ArbolColores arbol = new ArbolColores("src/ImagenEntrenamiento/Wikipedia");
```

- Se indica la carpeta con las imágenes de entrenamiento
- A partir de aquí se construye el modelo

---

### 2. Entrenamiento

```java
arbol.obtenerTodaRaizes(0);
```

- El sistema analiza todas las imágenes
- Aprende los colores presentes
- El parámetro indica el umbral mínimo de aparición de un color

Ejemplo:
- `0` → no se elimina ningún color
- `10` → elimina colores poco frecuentes (<10%)

---

### 3. Guardado de datos

```java
arbol.guardarDatos();
```

- Guarda el modelo aprendido
- Ruta de salida:

```
Wikipedia/Ficheros
```

---

### 4. Análisis de nuevas imágenes

```java
BufferedImage entrada;
try {
    File archivo = new File("src/ImagenEntrenamiento/Wikipedia/Ficheros/imgTest.png");
    entrada = ImageIO.read(archivo);

    arbol.analizarTodoSeleccion(entrada , "src/ImagenEntrenamiento/Wikipedia/Ficheros");

} catch (Exception e) {
    throw new RuntimeException(e);
}
```

- Se carga una imagen nueva
- Se aplica el modelo entrenado
- Se realiza la detección de colores

---

## 🧠 Funcionamiento interno

El sistema sigue este proceso:

1. **Lectura de imágenes de entrenamiento**
2. **Extracción de información de píxeles**
3. **Aplicación de lógica difusa**
   - Permite manejar transiciones suaves entre colores
   - Evita clasificaciones rígidas (ej: rojo vs naranja)
4. **Construcción de un árbol de decisión (`ArbolColores`)**
   - Organiza los colores aprendidos
   - Facilita la clasificación posterior
5. **Filtrado de ruido**
   - Eliminación de colores poco representativos
6. **Persistencia de datos**
7. **Aplicación del modelo a nuevas imágenes**

---

## 🔍 Rol de `Main.java`

La clase `Main` actúa como orquestador del sistema:

- Inicializa el modelo (`ArbolColores`)
- Ejecuta el entrenamiento
- Guarda los datos generados
- Carga imágenes de prueba
- Aplica la detección de colores

No contiene lógica compleja, sino que coordina el flujo completo del programa.

---

## 🛠️ Tecnologías utilizadas

- Java
- `BufferedImage` para procesamiento de imágenes
- Programación orientada a objetos
- Lógica difusa (Fuzzy Logic)
- Árboles de decisión

---

## 📌 Posibles mejoras

- Visualización gráfica de resultados
- Soporte para más formatos de imagen
- Ajuste dinámico de parámetros fuzzy
- Integración con OpenCV

---

## 📄 Licencia

Proyecto orientado a aprendizaje y experimentación. Uso libre con fines educativos.

---

## 👨‍💻 Autor

Desarrollado por Ricardo Soto Gallo
