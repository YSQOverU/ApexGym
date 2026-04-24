# Apex Gym - Sistema de Gestión Administrativa

![Android Studio](https://img.shields.io/badge/Android%20Studio-3DDC84?style=for-the-badge&logo=android-studio&logoColor=white)
![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![SQLite](https://img.shields.io/badge/sqlite-%2307405e.svg?style=for-the-badge&logo=sqlite&logoColor=white)

Apex Gym es una aplicación móvil nativa desarrollada en **Kotlin** diseñada para optimizar la administración interna de gimnasios. Este sistema permite gestionar el acceso del personal y el control de usuarios mediante una arquitectura robusta y una interfaz moderna basada en **Material Design 3**.

## Características Principales

* **Autenticación de Seguridad:** Sistema de Login vinculado a base de datos para restringir el acceso solo a personal autorizado.
* **Gestión de Usuarios (CRUD):** Módulo completo para la búsqueda, actualización y eliminación de registros administrativos.
* **Arquitectura de Datos:** Implementación de SQLite para persistencia local de datos de forma segura y eficiente.
* **UI/UX Dinámica:** Diseño responsivo con efectos visuales (Ripple effect), tarjetas elevadas y navegación intuitiva.
* **Cierre de Sesión Seguro:** Función de Logout que limpia la pila de actividades para prevenir accesos no autorizados mediante la navegación del sistema.

## Tecnologías Utilizadas

* **Lenguaje:** [Kotlin](https://kotlinlang.org/)
* **IDE:** Android Studio (Ladybug/Jellyfish)
* **Base de Datos:** SQLite con `SQLiteOpenHelper`.
* **Componentes Visuales:** Material Components para Android.
* **Control de Versiones:** Git & GitHub.

## Estructura del Proyecto

* `/app/src/main/java`: Contiene la lógica de negocio y controladores (Activities y DatabaseHelper).
* `/app/src/main/res/layout`: Definiciones de interfaz de usuario en archivos XML.
* `/Documentacion`: Incluye el plan de gestión de riesgos, manual de usuario y presentación ejecutiva.
* `/APK`: Archivo ejecutable `app-debug.apk` listo para su instalación.

## Instalación y Pruebas

1.  **Clonar el repositorio:**
    ```bash
    git clone [https://github.com/YSQOverU/ApexGym.git](https://github.com/YSQOverU/ApexGym.git)
    ```
2.  **Importar en Android Studio:** Abrir la carpeta raíz y esperar la sincronización de Gradle.
3.  **Ejecutar APK:** Localizar el archivo en la carpeta `/APK` e instalar en un dispositivo físico o emulador (Android 8.0+).

### Credenciales de acceso predeterminadas:
- **Usuario:** `admin`
- **Contraseña:** `1234`

## Autores
* **Franco Motta**
* **Julio Basulto**
* **Marlon Lastra**
* **Eliam Trejo**

---
Proyecto desarrollado con fines académicos para la asignatura de Administración de proyectos de software
