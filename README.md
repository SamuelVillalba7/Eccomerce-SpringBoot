# 🛒 Ecommerce Backend - Spring Boot & SQL Server

![Spring Boot](https://img.shields.io/badge/Spring%2520Boot-3.x-green)
![SQL Server](https://img.shields.io/badge/SQL%2520Server-Microsoft-blue)
![License](https://img.shields.io/badge/License-MIT-yellow)

Este proyecto es un backend de **eCommerce desarrollado con Spring Boot y SQL Server**. Proporciona una API RESTful completa para gestionar productos, usuarios, categorías y pedidos, siguiendo buenas prácticas como el uso de DTOs y arquitectura en capas.

---

## 📌 Características principales

- ✅ **Conexión a SQL Server**: Configuración lista para producción.
- ✅ **API REST**: Endpoints para productos, usuarios, categorías y órdenes.
- ✅ **DTOs y Mappers**: Separación entre modelos y datos de entrada/salida.
- ✅ **Manejo global de excepciones**: Mejor control de errores.
- ✅ **Arquitectura limpia y mantenible**

---

## 🚀 Requisitos previos

- ☕ **Java 21**
- 🛢️ **SQL Server** instalado y configurado
- 🧰 **Maven** como gestor de dependencias
- 📬 **Postman** o navegador para probar desde **Swagger UI**

---

## ⚙️ Configuración del proyecto

### 1. Clonar el repositorio

```bash
git clone https://github.com/SamuelVillalba7/Eccomerce-SpringBoot.git
cd Eccomerce-SpringBoot
```
### 2. Configurar la base de datos
Modifica el archivo application.properties con tus credenciales de SQL Server:
```bash
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=ecommerce_db;encrypt=true;trustServerCertificate=true
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```
### 3. Ejecutar la aplicación
```bash
mvn spring-boot:run
```
La aplicación estará disponible en:
🔹 Local: http://localhost:8080


---

## 📄 Estructura del Proyecto
```bash
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
```


