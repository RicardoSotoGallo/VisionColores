# 🎨 VisionColores

![Java](https://img.shields.io/badge/Java-17+-orange)
![Status](https://img.shields.io/badge/status-en%20desarrollo-yellow)
![License](https://img.shields.io/badge/license-educational-blue)

Sistema de detección de colores en imágenes desarrollado en Java, basado en aprendizaje supervisado, lógica difusa y estructuras tipo árbol de decisión.

---

## 📌 Descripción

**VisionColores** es un proyecto que permite entrenar un sistema para reconocer colores específicos dentro de imágenes y aplicar ese conocimiento a nuevas imágenes.

El enfoque combina:

- 🌈 Procesamiento de imágenes
- 🧠 Lógica difusa (Fuzzy Logic)
- 🌳 Árbol de decisión (`ArbolColores`)
- 🎯 Aprendizaje supervisado mediante máscaras

---

## 🧠 Idea principal del proyecto

El sistema aprende colores a partir de **dos imágenes**:

1. 🖼️ **Imagen original (color)**
2. ⚫⚪ **Imagen en blanco y negro (máscara)**

### 🔍 ¿Cómo funciona la máscara?

- ⚪ **Blanco (valor = 1)** → zonas que **SÍ se usan para aprender**
- ⚫ **Negro (valor = 0)** → zonas que **NO se usan**

Esto permite indicar exactamente qué partes de la imagen contienen el color que queremos entrenar.

---

## 🎯 Ejemplo de uso

Caso práctico:

- Se entrena el sistema para aprender el **color azul de Wikipedia**
- Se proporciona:
  - Imagen original
  - Máscara indicando solo las zonas azules
- Luego se prueba con una imagen nueva

Resultado:
➡️ El sistema detecta automáticamente ese color en otras imágenes

---

## 📂 Estructura del Proyecto

```
src/
└── main/
    └── java/
        ├── Main.java
        └── DeteccionColor/
            ├── (lógica del sistema)
```

---

## 🚀 Flujo de ejecución

### 1. Inicialización

```java
ArbolColores arbol = new ArbolColores("src/ImagenEntrenamiento/Wikipedia");
```

---

### 2. Entrenamiento

```java
arbol.obtenerTodaRaizes(0);
```

- Aprende los colores de las zonas marcadas
- Permite filtrar colores poco relevantes

---

### 3. Guardado

```java
arbol.guardarDatos();
```

---

### 4. Evaluación con nueva imagen

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

---

## ⚙️ Funcionamiento interno

1. Se cargan imagen y máscara
2. Se filtran píxeles según la máscara (blanco = válido)
3. Se aplican técnicas de lógica difusa para interpretar colores
4. Se construye un árbol de decisión (`ArbolColores`)
5. Se eliminan colores poco representativos
6. Se guarda el modelo
7. Se aplica a nuevas imágenes

---

## 🔍 `Main.java`

Coordina todo el flujo:

- Inicializa el sistema
- Ejecuta entrenamiento
- Guarda datos
- Prueba con nuevas imágenes

---

## 🛠️ Tecnologías

- Java
- BufferedImage
- Lógica difusa (Fuzzy Logic)
- Árboles de decisión
- Aprendizaje supervisado con máscara

---

## 💡 Características destacadas

- Entrenamiento personalizado por zonas
- Control total sobre qué aprende el modelo
- Reducción de ruido mediante umbral
- Sistema extensible

---

## 📌 Posibles mejoras

- Interfaz gráfica para crear máscaras
- Visualización de resultados
- Soporte para múltiples clases de color
- Integración con OpenCV

---

## 📄 Licencia

Uso educativo y experimental.

---

## 👨‍💻 Autor

Ricardo Soto Gallo
