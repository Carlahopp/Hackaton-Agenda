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


## 📋 Requisitos
- Java 17 (JDK)
- IntelliJ IDEA (u otro IDE para Java)

## ▶️ Cómo ejecutarlo
1. Clonar el repositorio:
   `git clone https://github.com/Carlahopp/Hackaton-Agenda.git`
2. Abrir la carpeta en IntelliJ y seleccionar el JDK 17 (File → Project Structure → SDK).
3. Correr `src/mx/com/agenda/app/Main.java`.
4. Al iniciar, el programa pregunta el tamaño de la agenda. Con Enter se usa el tamaño por defecto (10).

## 📱 Menú
| Opción | Qué hace |
|---|---|
| 1 | Añadir contacto (valida nombre y apellido vacíos, duplicados y agenda llena) |
| 2 | Comprobar si existe un contacto |
| 3 | Listar contactos en orden alfabético (`Nombre Apellido - Teléfono`) |
| 4 | Buscar contacto por nombre y apellido y mostrar su teléfono |
| 5 | Eliminar contacto |
| 6 | Modificar el teléfono de un contacto |
| 7 | Saber si la agenda está llena |
| 8 | Ver cuántos espacios libres quedan |
| 0 | Salir |

## 🧪 Pruebas
`src/mx/com/agenda/servicio/AgendaTest.java` prueba la agenda de forma automática: añadir, duplicados (sin importar mayúsculas), agenda llena, búsqueda, listado y eliminación.

## 💡 Conceptos de POO aplicados
- **Herencia:** `Contacto` hereda de la clase abstracta `Persona`.
- **Abstracción:** `Persona` es abstracta y define `mostrarInformacion()`.
- **Polimorfismo:** `Contacto` sobrescribe `mostrarInformacion()`, `equals()`, `hashCode()`, `compareTo()` y `toString()`.
- **Interfaces:** `Agenda` implementa `OperacionesAgenda`, y `Contacto` implementa `Comparable`.
- **Encapsulación:** atributos `private` y `protected` con getters y setters.
- **Colecciones:** `ArrayList<Contacto>` con `contains`, `indexOf`, `remove` y `Collections.sort`.
- **Sobrecarga de constructores:** `Agenda()` (10 por defecto) y `Agenda(int tamanoMaximo)`.

## 👥 Equipo
| Integrante | Aporte |
|---|---|
| Carla Hoppenstedt | Repositorio, estructura inicial, constructores, validaciones y mensajes de la agenda, AgendaTest |
| Jesús Álvarez | Interfaz `OperacionesAgenda`, buscar, eliminar y modificar teléfono |
| Cristian Ruiz | Modelo: `Persona` y `Contacto` (equals, hashCode, toString) |
| Isaac Razo | Menú por consola, integración de las partes y README |
