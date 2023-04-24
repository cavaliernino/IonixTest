# Aplicación movil Ionix Test.

## 1.
    Aplicación no esta completa, debido a necesidad de recuperar conocimiento en móvil, sobre
    Hilt y Compose, particularmente. Seguiré actualizando solo para mi práctica con esos conceptos.

## 2. Propuesta de Arquitectura
    Maletas Martínez
    
    Para desarrollar una aplicación móvil de mercado electrónico, se requiere principalmente rapidez de proceso, seguridad y escalabilidad.
    
    Para cumplir los requerimientos, se necesita la siguiente arquitectura:
    Para una primera etapa, se recomienda una app multiplataforma desarrollada en Flutter, luego se podría avanzar a arquitecturas nativas. 
    Inyección de dependencias con librería injection
    Comunicación via api con Retrofit, utilizando compresión y encripción de datos
    Almacenamiento local con Room
    Firebase para mensajería
    Autenticación utilizando JWT
    Se asume pruebas unitarias con un coverage mayor a un 80%
    se utilizan las mejores prácticas de rendimiento que indica la documentación de Flutter.
    Backend en Java, en un framework como Spring para acelerar el desarrollo de la API
    Backend se conecta con microservicios Java que ejecutan tareas atómicas relacionadas con usuarios.
    Es muy importante definir la relación de procesos con la API Onmichannel del cliente, para tener información clara para desarrollar el cliente de conexión como microservicio Java y no se bloqueen tareas nuestras.
    Para microservicios se utilizará una base de datos compartida, comunicada vía Apache Kafka, utilizando PostgreSQL, donde se almacenará info de usuario y 
    La comunicación desde el móvil se centra sólo hacia backend para mantener SSOT. Es backend el que coordina y sincroniza los datos.

## 3. Plan de Actividades:
### Mobile

    Generación de estructura de proyecto para Flutter
    Desarrollo de autenticación en Flutter
    Pantalla Login
    Pantalla principal que considera Menu, sección de avisos y banners, y lista de productos inicial
    Pantalla de perfil de usuario y configuración
    Pantalla de detalle de producto
    Pantalla de carro de compras
    Pantalla de compra de producto
    Workflow de agregar un producto al carro y comprar producto
    Generación de estadísticas de cada pantalla y envio a backend
    workflow de Autenticación con Backend

### Backend y MicroServicios

    Coordinación con cliente por API de productos
    Generación de infraestructura Kafka
    Generación de estructura de backend
    Generación de estructura de microservicio de usuarios
    Desarrollo de autenticación en Backend
    Desarrollo de workflow Kafka en backend
    Desarrollo de workflow Kafka en microservicio de usuarios
    Desarrollo de cliente de API Omnichannel de acuerdo a documentación de cliente.




