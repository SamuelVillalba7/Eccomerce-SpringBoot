# 🛒 Ecommerce Backend - Spring Boot & SQL Server

![Spring Boot](https://img.shields.io/badge/Spring%2520Boot-3.x-green)
![SQL Server](https://img.shields.io/badge/SQL%2520Server-Microsoft-blue)
![License](https://img.shields.io/badge/License-MIT-yellow)

Este proyecto es un backend de **eCommerce desarrollado con Spring Boot y SQL Server**. Proporciona una API RESTful completa para gestionar productos, usuarios, categorías y pedidos, siguiendo buenas prácticas como el uso de DTOs, arquitectura en capas, seguridad con JWT y documentación con Swagger.

---

## 📌 Características principales

- ✅ **Conexión a SQL Server**: Configuración lista para producción.
- ✅ **API REST**: Endpoints para productos, usuarios, categorías y órdenes.
- ✅ **JWT Authentication**: Seguridad con tokens para endpoints protegidos.
- ✅ **Swagger UI**: Documentación interactiva y lista para testear.
- ✅ **DTOs y Mappers**: Separación entre modelos y datos de entrada/salida.
- ✅ **Manejo global de excepciones**: Mejor control de errores.
- ✅ **Arquitectura limpia y mantenible**

---

## 🚀 Requisitos previos

- ☕ **Java 17+**
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


