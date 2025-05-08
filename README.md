# 📚 Sistema de Gestión de Libros con Microservicios

Este proyecto implementa una arquitectura basada en microservicios para la gestión de libros y préstamos, usando **Spring Boot**, **Spring Cloud Gateway** y **MySQL**.

## 📦 Microservicios

- **📘 book-service**: Maneja libros (alta, consulta, disminución de ejemplares).
- **📄 loan-service**: Registra préstamos y comunica con `book-service`.
- **🌐 api-gateway**: Punto único de entrada para enrutar las solicitudes REST.

---

## 🔧 Tecnologías utilizadas

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Spring Cloud Gateway
- MySQL
- Lombok
- Postman (para pruebas)

---

## 🗄️ Bases de datos requeridas

Crea estas dos bases de datos en tu servidor MySQL:

```sql
CREATE DATABASE book_db;
CREATE DATABASE loan_db;

## Arquitectura del sistema

                        ┌───────────────┐
                        │  API Gateway  │
                        │   (8080)      │
                        └──────┬────────┘
                               │
          ┌────────────────────┴────────────────────┐
          │                                         │
  ┌───────▼────────┐                       ┌────────▼────────┐
  │ book-service   │                       │ loan-service    │
  │ (localhost:8081│                       │ (localhost:8082)│
  └────────────────┘                       └─────────────────┘
      │   ▲                                     │   ▲
      ▼   │                                     ▼   │
 MySQL book_db                           MySQL loan_db
