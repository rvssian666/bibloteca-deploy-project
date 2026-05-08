# Biblioteca Deploy Project

## Descripcion del Proyecto

**Biblioteca Deploy Project** es una aplicacion web desarrollada con **Spring Boot 3.3.0** que permite gestionar una biblioteca digital. La aplicacion facilita la administracion de libros y socios, proporcionando funcionalidades para listar y dar de alta tanto libros como miembros de la biblioteca.

### Caracteristicas principales:
- Gestion completa de libros (listar y crear)
- Gestion de socios/miembros de la biblioteca (listar y crear)
- Interfaz web moderna con Thymeleaf
- Base de datos MySQL con persistencia JPA
- Listo para desplegar en plataformas como Railway
- Arquitectura escalable y modular

---

## Requisitos Previos

Antes de ejecutar el proyecto, asegurate de tener instalado lo siguiente:

| Requisito | Version | Descripcion |
|-----------|---------|-------------|
| **Java** | 17+ | Lenguaje de programacion |
| **Maven** | 3.6+ | Gestor de dependencias |
| **MySQL** | 5.7+ | Base de datos |
| **Spring Boot** | 3.3.0 | Framework web |
| **Git** | 2.0+ | Control de versiones |

---

## Pasos para Ejecutar el Proyecto

### 1. Clonar el Repositorio

```bash
git clone https://github.com/rvssian666/bibloteca-deploy-project.git
cd bibloteca-deploy-project
```

### 2. Crear la Base de Datos

Abre MySQL y ejecuta el script SQL incluido:

```bash
mysql -u root -p
```

Luego, en la consola de MySQL:

```sql
CREATE DATABASE IF NOT EXISTS bibloteca;
USE bibloteca;
source schema.sql;
```

**O directamente desde la terminal:**

```bash
mysql -u root -p < schema.sql
```

### 3. Configurar application.properties

Edita el archivo `src/main/resources/application.properties` con tus credenciales de MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bibloteca?createDatabaseIfNotExist=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=tu_contraseña_mysql
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

server.port=8080

spring.thymeleaf.cache=false
spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html
```

### 4. Compilar y Ejecutar

**Opcion A: Usando Maven directamente**

```bash
mvn clean install
mvn spring-boot:run
```

**Opcion B: Usar el wrapper de Maven (recomendado)**

```bash
# En Windows
mvnw.cmd spring-boot:run

# En Linux/Mac
./mvnw spring-boot:run
```

### 5. Acceder a la Aplicacion

Una vez que la aplicacion este ejecutandose, abre tu navegador y accede a:

```
http://localhost:8080/inicio
```

---

## Capturas de Pantalla de las Paginas Principales

### Pagina de Inicio
![Inicio](docs/screenshots/inicio.png)

### Listado de Libros
![Listado de Libros](docs/screenshots/listado-libros.png)

### Formulario de Alta de Libro
![Alta de Libro](docs/screenshots/formulario-libro.png)

### Listado de Socios
![Listado de Socios](docs/screenshots/listado-socios.png)

### Formulario de Alta de Socio
![Alta de Socio](docs/screenshots/formulario-socio.png)

### Pagina de Error
![Error](docs/screenshots/error.png)

---

## Estructura del Proyecto

```
bibloteca-deploy-project/
+-- src/
|   +-- main/
|   |   +-- java/
|   |   |   +-- com/practicaJPA/bibloteca/
|   |   |       +-- BiblotecaApplication.java      # Clase principal (controlador)
|   |   |       +-- model/                          # Entidades JPA
|   |   |       +-- Repository/                     # Interfaces Repository
|   |   +-- resources/
|   |       +-- application.properties              # Configuracion
|   |       +-- templates/                          # Vistas Thymeleaf
|   |           +-- inicio.html
|   |           +-- listado-libros.html
|   |           +-- listado-socios.html
|   |           +-- formulario-libro.html
|   |           +-- formulario-socio.html
|   |           +-- error.html
|   +-- test/                                       # Tests unitarios
+-- pom.xml                                         # Configuracion Maven
+-- schema.sql                                      # Script de base de datos
+-- Procfile                                        # Configuracion para Railway
+-- mvnw                                            # Maven wrapper (Linux/Mac)
+-- mvnw.cmd                                        # Maven wrapper (Windows)
+-- README.md                                       # Este archivo
```

---

## Base de Datos

### Tablas Principales

**Tabla: libro**
```sql
CREATE TABLE IF NOT EXISTS libro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255),
    autor VARCHAR(255),
    isbn VARCHAR(20),
    anio_publicacion INT
);
```

**Tabla: socio**
```sql
CREATE TABLE IF NOT EXISTS socio (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    apellidos VARCHAR(100),
    dni VARCHAR(15),
    fecha_alta DATE
);
```

---

## Dependencias Principales

| Dependencia | Version | Proposito |
|-------------|---------|----------|
| Spring Boot Starter Web | 3.3.0 | Framework web |
| Spring Boot Starter Data JPA | 3.3.0 | Persistencia de datos |
| Spring Boot Starter Thymeleaf | 3.3.0 | Motor de plantillas |
| MySQL Connector/J | Latest | Driver MySQL |
| Spring Boot Starter Test | 3.3.0 | Testing |

---

## Despliegue en Railway

El proyecto esta desplegado en **Railway** y funciona correctamente.

### URL del despliegue:

**https://bibloteca-deploy-project-production.up.railway.app/inicio**

### Pasos para desplegar:

1. Conecta tu repositorio GitHub a Railway
2. Railway detectara automaticamente la aplicacion Maven
3. Configura las variables de entorno MySQL en Railway
4. El deploy se realizara automaticamente

---

## Solucion de Problemas

### Error: "Cannot connect to database"
Solucion: Verifica que MySQL esta corriendo y que las credenciales en application.properties son correctas.

### Error: "Port 8080 already in use"
Solucion: Cambia el puerto en application.properties: server.port=8081

### Error: "Maven build failure"
Solucion: Ejecuta: mvn clean install -U

---

## Autor

**Alexander Fuentes Valladares** - [GitHub Profile](https://github.com/rvssian666)

---

## Licencia

Este proyecto esta bajo licencia libre. Usalo como consideres necesario.

---

## Soporte

Tienes problemas? Abre un [issue en GitHub](https://github.com/rvssian666/bibloteca-deploy-project/issues)

---

**Ultima actualizacion:** 2026-05-08
