# 📚 Biblioteca Deploy Project

## 📋 Descripción del Proyecto

**Biblioteca Deploy Project** es una aplicación web desarrollada con **Spring Boot 3.3.0** que permite gestionar una biblioteca digital. La aplicación facilita la administración de libros y socios, proporcionando funcionalidades para crear, listar y gestionar tanto libros como miembros de la biblioteca.

### Características principales:
- ✅ Gestión completa de libros (crear, listar, editar, eliminar)
- ✅ Gestión de socios/miembros de la biblioteca
- ✅ Interfaz web moderna con Thymeleaf
- ✅ Base de datos MySQL con persistencia JPA
- ✅ Listo para desplegar en plataformas como Railway
- ✅ Arquitectura escalable y modular

---

## 🔧 Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener instalado lo siguiente:

| Requisito | Versión | Descripción |
|-----------|---------|-------------|
| **Java** | 17+ | Lenguaje de programación |
| **Maven** | 3.6+ | Gestor de dependencias |
| **MySQL** | 5.7+ | Base de datos |
| **Spring Boot** | 3.3.0 | Framework web |
| **Git** | 2.0+ | Control de versiones |

### Instalación de dependencias (Windows/Linux/Mac):

**Java 17:**
```bash
# Verificar instalación
java -version
```

**Maven:**
```bash
# Verificar instalación
mvn -version
```

**MySQL:**
```bash
# Descargar desde: https://dev.mysql.com/downloads/mysql/
# Verificar instalación
mysql --version
```

---

## 🚀 Pasos para Ejecutar el Proyecto

### 1️⃣ Clonar el Repositorio

```bash
git clone https://github.com/rvssian666/bibloteca-deploy-project.git
cd bibloteca-deploy-project
```

### 2️⃣ Crear la Base de Datos

Abre MySQL y ejecuta el script SQL incluido:

```bash
mysql -u root -p
```

Luego, en la consola de MySQL:

```sql
-- Crear base de datos (opcional si Spring Boot no la crea)
CREATE DATABASE IF NOT EXISTS bibloteca;

-- Usar la base de datos
USE bibloteca;

-- Ejecutar el script schema.sql
source schema.sql;
```

**O directamente desde la terminal:**

```bash
mysql -u root -p < schema.sql
```

### 3️⃣ Configurar application.properties

Edita el archivo `src/main/resources/application.properties` con tus credenciales de MySQL:

```properties
# Base de Datos
spring.datasource.url=jdbc:mysql://localhost:3306/bibloteca?createDatabaseIfNotExist=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=tu_contraseña_mysql
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA / Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Servidor
server.port=8080

# Thymeleaf
spring.thymeleaf.cache=false
spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html
```

### 4️⃣ Compilar y Ejecutar

**Opción A: Usando Maven directamente**

```bash
mvn clean install
mvn spring-boot:run
```

**Opción B: Usar el wrapper de Maven (recomendado)**

```bash
# En Windows
mvnw.cmd spring-boot:run

# En Linux/Mac
./mvnw spring-boot:run
```

**Opción C: Construir JAR y ejecutar**

```bash
mvn clean package
java -jar target/bibloteca-0.0.1-SNAPSHOT.jar
```

### 5️⃣ Acceder a la Aplicación

Una vez que la aplicación esté ejecutándose, abre tu navegador y accede a:

```
http://localhost:8080
```

---

## 📸 Capturas de Pantalla de las Páginas Principales

### Página de Inicio (Home)
La página principal presenta un menú navegable con opciones para gestionar libros y socios.

**URL:** `http://localhost:8080/`
- Vista general de la aplicación
- Botones de acceso rápido a funcionalidades principales

### Gestión de Libros

#### Listado de Libros
**URL:** `http://localhost:8080/libros`
- Tabla con todos los libros registrados
- Columnas: ID, Título, Autor, ISBN, Año de Publicación
- Opciones para editar y eliminar libros

#### Formulario para Agregar/Editar Libro
**URL:** `http://localhost:8080/libros/nuevo`
- Campo: Título
- Campo: Autor
- Campo: ISBN
- Campo: Año de Publicación
- Botón: Guardar

### Gestión de Socios

#### Listado de Socios
**URL:** `http://localhost:8080/socios`
- Tabla con todos los socios registrados
- Columnas: ID, Nombre, Apellido, DNI, Fecha de Alta
- Opciones para editar y eliminar socios

#### Formulario para Agregar/Editar Socio
**URL:** `http://localhost:8080/socios/nuevo`
- Campo: Nombre
- Campo: Apellido
- Campo: DNI
- Campo: Fecha de Alta
- Botón: Guardar

### Página de Error
**URL:** (Automática en caso de error)
- Página personalizada para gestión de errores HTTP

---

## 📁 Estructura del Proyecto

```
bibloteca-deploy-project/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/practicaJPA/bibloteca/
│   │   │       ├── BiblotecaApplication.java      # Clase principal
│   │   │       ├── model/                          # Entidades JPA
│   │   │       ├── Repository/                     # Interfaces Repository
│   │   │       └── controller/                     # Controladores REST
│   │   └── resources/
│   │       ├── application.properties              # Configuración
│   │       └── templates/                          # Vistas Thymeleaf
│   │           ├── inicio.html
│   │           ├── listado-libros.html
│   │           ├── listado-socios.html
│   │           ├── formulario-libro.html
│   │           ├── formulario-socio.html
│   │           └── error.html
│   └── test/                                       # Tests unitarios
├── pom.xml                                         # Configuración Maven
├── schema.sql                                      # Script de base de datos
├── Procfile                                        # Configuración para Railway
├── mvnw                                            # Maven wrapper (Linux/Mac)
├── mvnw.cmd                                        # Maven wrapper (Windows)
└── README.md                                       # Este archivo
```

---

## 🗄️ Base de Datos

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
    apellido VARCHAR(100),
    dni VARCHAR(15),
    fecha_alta DATE
);
```

---

## 🔌 Dependencias Principales

| Dependencia | Versión | Propósito |
|-------------|---------|----------|
| Spring Boot Starter Web | 3.3.0 | Framework web |
| Spring Boot Starter Data JPA | 3.3.0 | Persistencia de datos |
| Spring Boot Starter Thymeleaf | 3.3.0 | Motor de plantillas |
| MySQL Connector/J | Latest | Driver MySQL |
| Spring Boot Starter Test | 3.3.0 | Testing |

---

## 🌐 Despliegue en Railway

El proyecto está configurado para desplegar en **Railway**. Incluye:

- `Procfile`: Define el comando de inicio
- `application.properties`: Variables de entorno para Railway

### Pasos para desplegar:

1. Conecta tu repositorio GitHub a Railway
2. Railway detectará automáticamente la aplicación Maven
3. Configura las variables de entorno MySQL en Railway
4. El deploy se realizará automáticamente

---

## 🐛 Solución de Problemas

### Error: "Cannot connect to database"
```
Solución: Verifica que MySQL está corriendo y que las credenciales 
en application.properties son correctas.
```

### Error: "Port 8080 already in use"
```
Solución: Cambia el puerto en application.properties:
server.port=8081
```

### Error: "Maven build failure"
```
Solución: Ejecuta: mvn clean install -U
```

---

## 👤 Autor

**rvssian666** - [GitHub Profile](https://github.com/rvssian666)

---

## 📝 Licencia

Este proyecto está bajo licencia libre. Úsalo como consideres necesario.

---

## 📞 Soporte

¿Tienes problemas? Abre un [issue en GitHub](https://github.com/rvssian666/bibloteca-deploy-project/issues)

---

**Última actualización:** 2026-05-08
