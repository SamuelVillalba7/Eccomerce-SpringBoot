🛒 Ecommerce Backend - Spring Boot & SQL Server
https://img.shields.io/badge/Spring%2520Boot-3.x-green
https://img.shields.io/badge/SQL%2520Server-Microsoft-blue
https://img.shields.io/badge/License-MIT-yellow

Este proyecto es un backend de ecommerce desarrollado con Spring Boot y una base de datos SQL Server. Proporciona APIs RESTful para gestionar productos, usuarios, pedidos y más, siguiendo buenas prácticas de desarrollo y arquitectura limpia.

📌 Características
✅ Conexión a SQL Server: Configuración lista para producción.

✅ API REST: Endpoints para gestionar productos, categorías, usuarios y órdenes.

✅ Autenticación y Autorización: JWT (JSON Web Tokens) para seguridad.

✅ Documentación con Swagger: API documentada y fácil de probar.

✅ Patrón DTO y Mappers: Para un código más mantenible.

✅ Manejo de excepciones globales.

🚀 Requisitos Previos
Java 17+

SQL Server instalado y configurado.

Maven para la gestión de dependencias.

Postman o Swagger UI para probar los endpoints.

⚙️ Configuración
1. Clonar el repositorio
bash
git clone https://github.com/SamuelVillalba7/Eccomerce-SpringBoot.git
cd Eccomerce-SpringBoot
2. Configurar la base de datos
Modifica el archivo application.properties con tus credenciales de SQL Server:

properties
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=ecommerce_db;encrypt=true;trustServerCertificate=true
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
3. Ejecutar la aplicación
bash
mvn spring-boot:run
La aplicación estará disponible en:
🔹 Local: http://localhost:8080
🔹 Swagger UI: http://localhost:8080/swagger-ui.html

📄 Estructura del Proyecto
text
src/
├── main/
│   ├── java/
│   │   └── com/ecommerce/
│   │       ├── config/       # Configuraciones (Security, Swagger, etc.)
│   │       ├── controller/   # Controladores REST
│   │       ├── dto/          # Objetos de Transferencia de Datos
│   │       ├── model/        # Entidades JPA
│   │       ├── repository/   # Repositorios (JPA)
│   │       ├── service/      # Lógica de negocio
│   │       └── EcommerceApplication.java
│   └── resources/
│       ├── application.properties
│       └── static/           # (Opcional) Recursos estáticos
