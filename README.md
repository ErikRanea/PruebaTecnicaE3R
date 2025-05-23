# Prueba Técnica: Servicio REST de Precios con Spring Boot



## Información General

*   **Autor:** Erik Ranea Sierra
*   **Fecha de Creación/Última Modificación Importante:** 22 de Mayo de 2024
*   **Editor/IDE Utilizado:** Visual Studio Code
*   **Versión de Java:** JDK 21
*   **Framework Principal:** Spring Boot 3.4.5

## Descripción del Proyecto

Este proyecto consiste en la implementación de un servicio RESTful utilizando Spring Boot. El objetivo principal del servicio es consultar y devolver información de precios para productos de diferentes marcas, aplicando la tarifa correcta según una fecha de aplicación dada y una prioridad establecida.

El servicio expone un endpoint principal que permite a los clientes solicitar el precio aplicable para una combinación específica de identificador de producto (`productId`), identificador de cadena (`brandId`), y una fecha y hora de aplicación.

## Librerías Utilizadas y Justificación

A continuación, se detallan las principales librerías y dependencias utilizadas en el proyecto, junto con una breve justificación de su elección:

*   **Spring Boot Starter Web:**
    *    Es el estándar para desarrollar aplicaciones web con Spring Boot, simplificando enormemente la configuración y el desarrollo de APIs REST.
*   **Spring Boot Starter Data JPA:**
   *    Permite una interacción eficiente y estandarizada con la base de datos, abstrayendo gran parte del código boilerplate de JDBC y facilitando la definición de entidades y repositorios.
*   **Spring Boot Starter Validation:**
    *    Asegura la integridad de los datos de entrada a la API de forma declarativa y centralizada, mejorando la robustez del servicio.
*   **H2 Database:**
    *    Ideal para la prueba técnica, ya que permite tener una base de datos funcional sin necesidad de configuraciones externas. Durante el desarrollo se usa en modo fichero para mantener los datos entre ejecuciones, y en los tests en memoria para asegurar un entorno limpio y aislado.
*   **Flyway Core:**
    *    Se utiliza para inicializar la tabla `prices` con los datos de prueba.
*   **Lombok:**
    *    Mejora la legibilidad y reduce la verbosidad del código al generar automáticamente métodos comunes.
*   **MapStruct:**
    *    Proporciona una forma segura, eficiente y type-safe de realizar mapeos, reduciendo el código manual propenso a errores.
*   **Spring Boot Starter Test:**
    *    Proporciona un conjunto completo y bien integrado de herramientas para escribir tanto pruebas unitarias como pruebas de integración.

## Organización y Construcción del Código

La estructura del proyecto y las decisiones de diseño se han tomado siguiendo principios de código limpio y buenas prácticas de desarrollo de software:

### Estructura de Paquetes

El código fuente se organiza en los siguientes paquetes principales: 

*   **`controller`**: Contiene los controladores REST (`@RestController`) que manejan las peticiones HTTP, validan la entrada  y delegan la lógica de negocio a la capa de servicio.
*   **`dto`**: Clases POJO utilizadas para transferir datos entre capas, especialmente entre los controladores y los clientes de la API (`PriceRequestDto`, `PriceResponseDto`).
*   **`mapper`**: Interfaces de MapStruct para la conversión entre entidades JPA y DTOs (`PriceMapper`).
*   **`model`**: Contiene las entidades JPA (`@Entity`) que representan el modelo de dominio y se mapean a las tablas de la base de datos (`Price`).
*   **`repository`**: Interfaces de Spring Data JPA (`@Repository`) que definen los métodos para el acceso a datos.
*   **`service`**:
    *   **`service` (interfaz)**: Define el contrato para la lógica de negocio.
    *   **`service.implementation`**: Contiene las implementaciones (`@Service`) de las interfaces de servicio, donde reside la lógica de negocio principal.

### Justificación de la Organización

*   **Separación de Responsabilidades:** Cada capa (controlador, servicio, repositorio) tiene una responsabilidad bien definida, lo que facilita la comprensión, el mantenimiento y la testeabilidad del código.
    *   **Controladores:** Manejo de HTTP y delegación.
    *   **Servicios:** Orquestación de la lógica de negocio y transacciones. Al tener una interfaz definiendo que se debe implementar, permite crear diferentes implementaciones con diferentes maneras de resolver como se hace. 
    *   **Repositorios:** Acceso a datos.
*   **Uso de DTOs:** Se utilizan DTOs para las peticiones y respuestas de la API para:
    *   Desacoplar la interfaz de la API del modelo de datos interno.
    *   Permitir una validación específica para las entradas de la API.
    *   Controlar qué campos se exponen o se esperan, mejorando la seguridad y la claridad de la API.
*   **Mapeo con MapStruct:** Se utiliza MapStruct para realizar las conversiones entre entidades y DTOs de forma eficiente y segura en tiempo de compilación, evitando el código de mapeo manual propenso a errores.
*   **Manejo de Errores:** Se devuelve el código de estado HTTP apropiado para indicar el resultado de las operaciones. La validación de entrada se maneja con Bean Validation en los DTOs.
*   **Pruebas:**
    *   **Pruebas Unitarias:** Se utilizan para verificar la lógica de las clases de servicio (`PriceServiceImplTest`) y de los controladores (`PriceControllerTest` usando `@WebMvcTest`) de forma aislada, utilizando Mockito para simular dependencias.
    *   **Pruebas de Integración:** Se utilizan (`PriceIntegrationTest` con `@SpringBootTest`) para verificar el flujo completo de la aplicación, desde la petición HTTP hasta la interacción con la base de datos (H2 poblada por Flyway).

### Flujo de una Petición Típica (ej. `POST /api/prices`)

1.  El cliente envía una petición POST a `/api/prices` con un cuerpo JSON que contiene `brandId`, `productId` y `applicationDate`.
2.  `PriceController` recibe la petición.
3.  El cuerpo JSON se deserializa a un `PriceRequestDto`.
4.  Se aplican las validaciones (`@Valid`) definidas en `PriceRequestDto`. Si falla, se devuelve un 400 Bad Request.
5.  `PriceController` llama al método `searchPrice` de `PriceService`, pasando los parámetros del DTO.
6.  `PriceService` llama al método correspondiente de `PriceRepository` para consultar la base de datos H2.
7.  `PriceRepository` ejecuta la query (definida con `@Query`) para encontrar el precio aplicable con la mayor prioridad.
8.  Si se encuentra un `Price` (entidad), se devuelve al servicio. Si no, se devuelve un `Optional` vacío.
9.  `PriceService` devuelve el `Optional<Price>` al controlador.
10. `PriceController` verifica si el `Optional` contiene un precio:
    *   Si está vacío, devuelve un `ResponseEntity` con estado 404 Not Found.
    *   Si contiene un `Price`, utiliza `PriceMapper` para convertir la entidad `Price` a un `PriceResponseDto`.
11. `PriceController` devuelve un `ResponseEntity` con estado 200 OK y el `PriceResponseDto` en el cuerpo, que se serializa a JSON.

Esta organización busca un código modular, fácil de entender, mantener y testear, siguiendo las convenciones y buenas prácticas habituales en el desarrollo con Spring Boot.

---

