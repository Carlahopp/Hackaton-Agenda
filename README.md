# Hackaton-Agenda

Este proyecto consiste en un sistema estructurado en **Java** para la gestión eficiente de una agenda de contactos, desarrollado bajo buenas prácticas de Programación Orientada a Objetos (POO) y una arquitectura limpia por capas.

## 🚀 Características y Reglas de Negocio
- **Estructura jerárquica:** Extensión de modelos utilizando clases abstractas.
- **Contratos de servicio:** Desacoplamiento de la lógica mediante el uso de Interfaces.
- **Validación estricta:** Control de campos obligatorios (nombres y apellidos no vacíos).
- **Control de duplicados:** Identificación inteligente de contactos repetidos de manera insensible a mayúsculas/minúsculas (*case-insensitive*).
- **Flexibilidad de inicialización:** Capacidad de definir un límite personalizado o usar el tamaño por defecto de 10 elementos.

## 🛠️ Arquitectura del Proyecto (Estructura de Paquetes)
El código se encuentra organizado bajo el paquete raíz `mx.com.agenda`:

- `mx.com.agenda.modelo`: Contiene la clase abstracta `Persona` y la clase entidad `Contacto`.
- `mx.com.agenda.servicio`: Contiene la interfaz `OperacionesAgenda` con los métodos requeridos para el negocio y su implementación concreta en `Agenda`.
- `mx.com.agenda.app`: Aloja la clase ejecutora `Main` junto con el flujo interactivo de consola.

## ⚙️ Tecnologías Utilizadas
- **Lenguaje:** Java
- **Colecciones:** Java Collections Framework (`ArrayList`)
- **Interfaz de Usuario:** Consola interactiva estructurada con un ciclo `do-while` y `Scanner`.
