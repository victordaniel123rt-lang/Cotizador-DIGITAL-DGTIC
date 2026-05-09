README.md

md
# Cotizador Digital DGTIC

## 📋 Descripción

El **Cotizador Digital DGTIC** es un sistema web diseñado para generar cotizaciones digitales de seguros de autos. El proyecto implementa una arquitectura **MVC Monolítica** utilizando el marco de trabajo **Spring** y sus módulos asociados.

### Características Principales

- 🚗 **Cotización de Seguros de Autos**: Cálculo automático de pólizas de seguros vehiculares
- 🏗️ **Arquitectura MVC**: Separación clara entre Model, View y Controller
- 🔐 **Seguridad**: Implementación de autenticación y autorización con Spring Security
- 💾 **Persistencia de Datos**: Gestión de datos con Spring Data
- 🎨 **Interfaz Web Moderna**: Plantillas dinámicas con Thymeleaf y estilos con SCSS

### Stack Tecnológico

| Componente | Descripción |
|-----------|------------|
| **Backend** | Spring Boot, Spring Framework, Spring Data, Spring Security |
| **Frontend** | HTML5, JavaScript, Thymeleaf |
| **Estilos** | SCSS, CSS |
| **Base de Datos** | Compatible con Spring Data (SQL) |

---

## 🚀 Instalación

### Requisitos Previos

- **Java Development Kit (JDK)**: Versión 11 o superior
- **Maven**: Versión 3.6 o superior (o usar Gradle si está configurado)
- **Git**: Para clonar el repositorio
- **IDE** (opcional): IntelliJ IDEA, Eclipse o Visual Studio Code

### Pasos de Instalación

#### 1. Clonar el Repositorio

bash
git clone https://github.com/victordaniel123rt-lang/Cotizador-DIGITAL-DGTIC.git
cd Cotizador-DIGITAL-DGTIC
2. Verificar la Versión de Java
bash
java -version
Asegúrate de que tienes Java 11 o superior instalado.

3. Instalar Dependencias de Spring Boot
Navega a la raíz del proyecto donde se encuentra el archivo pom.xml (para Maven):

bash
mvn clean install
Este comando realizará:

Descarga de todas las dependencias de Spring Boot y bibliotecas asociadas
Compilación del proyecto
Empaquetamiento de la aplicación
Nota para Gradle: Si el proyecto usa Gradle en lugar de Maven:

bash
gradle clean build
4. Validar la Instalación
Para verificar que las dependencias se instalaron correctamente:

bash
mvn dependency:tree
▶️ Ejecución de la Aplicación
Opción 1: Ejecutar desde Maven
bash
mvn spring-boot:run
La aplicación se iniciará en http://localhost:8080 por defecto.

Opción 2: Ejecutar JAR Generado
Primero, compila la aplicación:

bash
mvn clean package
Luego, ejecuta el JAR generado:

bash
java -jar target/cotizador-digital-*.jar
Opción 3: Desde tu IDE
Abre el proyecto en tu IDE favorito (IntelliJ IDEA, Eclipse, etc.)
Localiza la clase main de Spring Boot (generalmente @SpringBootApplication)
Haz clic derecho y selecciona "Run" o presiona Ctrl+Shift+F10 (IntelliJ)
🧪 Acceso a la Aplicación
Una vez que la aplicación esté en ejecución:

Abre tu navegador web
Navega a: http://localhost:8080
Accede al cotizador digital y comienza a generar cotizaciones de seguros
📁 Estructura del Proyecto
Code
### Arquitectura
Cotizador-DIGITAL-DGTIC/
├── src/
│   ├── main/
│   │   ├── java/              # Código Java (Controllers, Services, Models)
│   │   ├── resources/
│   │   │   ├── templates/     # Plantillas Thymeleaf (HTML)
│   │   │   ├── static/        # Archivos estáticos (JS, CSS, SCSS)
│   │   │   └── application.properties  # Configuración
│   │   └── webapp/
│   └── test/                  # Pruebas unitarias
├── pom.xml                    # Dependencias y configuración Maven
└── README.md
⚙️ Configuración
Archivo application.properties
Modifica el archivo src/main/resources/application.properties para ajustar configuraciones:

properties
# Puerto de la aplicación
server.port=8080

# Base de datos
spring.datasource.url=jdbc:mysql://localhost:3306/cotizador
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
🔧 Dependencias Principales de Spring Boot
El proyecto incluye las siguientes dependencias clave:

### ARCHIVO POM
XML
<!-- Spring Boot Starter Web -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- Spring Data JPA -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<!-- Spring Security -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>

<!-- Spring Boot Starter Thymeleaf -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>

<!-- Base de datos (ejemplo: MySQL) -->
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>


📝 Próximos Pasos
Configurar la base de datos según tu entorno
Crear usuarios y roles en Spring Security
Generar tus primeras cotizaciones
Personalizar los formularios y lógica de negocio
📞 Soporte
Para más información sobre Spring Boot:

Documentación Oficial de Spring Boot
Guía de Referencia de Spring Framework
📄 Licencia
Este proyecto es parte del sistema de DGTIC.

Última actualización: 2026-05-09
