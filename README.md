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

## 🖼️​ `Ejemplo con imagenes`
Vamos a intentar entrenar los colores de las plabras con hiper enlce de wikipedia. A simple vista sabemos que es azul pero no sabemos cual es o si son varios azules distintos.
Para ello introudcimos una imagen y la mascara que indica mas o menos donde esta el color.
<p align="center">
  <img src="https://github.com/user-attachments/assets/14966b2f-332b-426d-9e16-ea5a29ea02c8" width="45%" />
  <img src="https://github.com/user-attachments/assets/6ab4f21a-3ac4-44bc-ae50-a458aefcacc2" width="45%" />
</p>

Pues una vez entrenado si usamos otra imagen de test saldria este resultado. En color blanco se indica que zonas a detectado con un color parecido o igual.
<p align="center">
  <img width="45%" src="https://github.com/user-attachments/assets/5774d144-b12c-44d0-b34f-1597c8a5816e" />
  <img width="45%" src="https://github.com/user-attachments/assets/a52f3cb7-1dad-4982-8a77-ea98f46708bb" />
</p>




## 👨‍💻 Autor

Ricardo Soto Gallo
