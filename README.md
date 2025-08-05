# 🐾 PaseoPets: Control Inteligente de Paseos

<div align="center">

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)
![Room](https://img.shields.io/badge/Room-FF6B35?style=for-the-badge&logo=sqlite&logoColor=white)

**Una app práctica para llevar control total sobre los paseos y clientes del negocio de mascotas.**

[📸 Capturas](#-capturas) • [⚙️ Funciones](#-funciones) • [📦 Estructura del Proyecto](#-estructura) • [🚀 Cómo Empezar](#-instalación)

</div>

---

## 📘 Introducción

**PaseoPets** es una aplicación Android desarrollada con **Jetpack Compose** y **Kotlin** para ayudar a cuidadores de mascotas a registrar sus paseos, gestionar cobros, y mantener un historial de clientes y servicios. Todo se almacena localmente usando **Room**, asegurando acceso rápido y offline.

---

## ⚙️ Funciones

### 🧾 Registro de Paseos
- Ingreso de datos de mascotas y clientes
- Cálculo automático de montos
- Registro de duración, tarifa y notas
- Almacenamiento inmediato en base local

### 💵 Control Financiero
- Seguimiento de ingresos cobrados y pendientes
- Estadísticas en tiempo real
- Indicadores visuales para ver rápidamente el estado de los cobros

### 👥 Gestión de Clientes
- Panel agrupado por cliente
- Historial de paseos por cliente
- Totales acumulados y últimos paseos registrados

### ✏️ Edición y Eliminación
- Marcar paseos como pagados
- Borrar registros innecesarios o duplicados

---

## 📦 Estructura
com.tesmiguegazocar.controlpaseosmascotas/
├── 🧠 modelovista/ -> ViewModel y lógica de negocio
├── 💾 datos/ -> Base de datos Room y entidades
├── 🔁 repositorio/ -> Capa intermedia DAO/VM
├── 🖼️ ui/
│ ├── 📱 screens/ -> Pantallas como Home, Cliente, etc.
│ ├── 🧩 components/ -> Composables reutilizables (tarjetas, botones)
│ └── 🎨 theme/ -> Colores, tipografías, etc.
└── 🧰 utilidades/ -> Funciones comunes (formateo, validaciones)



---

## 🚀 Instalación

### 🔧 Requisitos
- Android Studio Giraffe o superior
- SDK mínimo: API 24
- Kotlin y Gradle configurados

### 🛠️ Pasos
```
    1. Clona este repositorio:
    bash
    git clone https://github.com/usuario/controlpaseosmascotas.git
    
    2. Abre la carpeta en Android Studio y espera a que Gradle sincronice.
    3. Ejecuta en un dispositivo o emulador
```
## 🧠 Arquitectura Usada
* MVVM (Model-View-ViewModel)
* Jetpack Compose para UI reactiva
* Room como base de datos
* Coroutines + Flow para asincronismo
* Material 3 como sistema de diseño

## 💡 Ideas Futuras
* 🔎 Búsqueda de paseos por cliente
* 📅 Filtros por fecha o estado de pago
* 📊 Gráficos y reportes financieros
* 🔔 Notificaciones para recordar cobros
* ☁️ Sincronización en la nube

## 🤝 Contribuciones
* Se aceptan mejoras, pruebas, diseño y documentación.
* Abrí un PR o enviá un Issue con tu sugerencia.

## ⚖️ Licencia
* Distribuido bajo la Licencia MIT. Ver LICENSE para más información.

🧑‍💻 Autores
* José Miguel Testor (tesmigue) y Gregorio Azócar (GAZOCAR5)
* Proyecto académico / educativo desarrollado con fines prácticos