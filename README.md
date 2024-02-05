# innova-jwt
Proyecto para implementación de JWT

## Procedimiento
1. Se crea en Spring Boot Initializer un proyecto con las siguientes dependencias:
   1. Spring Web
   2. Spring Security
   3. Spring Data JPA
   4. Spring Boot DevTools
   5. Driver de Base de datos (PostgreSQL, MongoDB, etc.)
   6. Lombok (opcional)
2. De https://mvnrepository.com, se deben agregar las siguientes dependencias:
   1. https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-api
   2. https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-impl
   3. https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-jackson
   4. Se debe agregar la siguiente configuración en el `plugin` del `pom.xml`:
     ```xml
	    <configuration>
	    	<excludes>
	    		<exclude>
	    			<groupId>org.projectlombok</groupId>
	    			<artifactId>lombok</artifactId>
	    		</exclude>
	    	</excludes>
	    </configuration>
     ```
3. Refactorizar `application.configuration` a `application.yml` y agregamos la configuración
   ```yaml
   server:
     port: [portNumber]

   spring:
     application:
       name: [applicationName]
     datasource:
       url: ${POSTGRES_LOCALHOST}
       username: ${POSTGRES_USER}
       password: ${POSTGRES_PW}
       driver-class-name: [driver]
     jpa:
       hibernate:
         ddl-auto: create
       show-sql: true
       properties:
         hibernate:
           format-sql: true
       database: [databaseEngine]
       database-platform: [dialect]
   
   # Definir las variables para el JWT
   application:
     security:
       jwt:
         secret-key: ${SECRET_KEY}
         expiration: 86400000 #1 dia
   ```
4. Creamos 2 paquetes, 1 para la capa de `domain` y el otro para `application`.
5. En la capa de `domain`, creamos un paquete llamado `entity` que manejará las entidades.
6. Dentro del paquete de `entity` se crean los siguientes paquetes:
   - `entity` para las entidades (por ejemplo, `User`).
   - `dto` para los DTOs (por ejemplo `UserDto`)
   - `repository` para los Repositorios (por ejemplo `UserRepository`). Recordar de implementar la interfaz adecuada 
   (por ejemplo `JpaRepository<T,ID>`)
   - No olvidar incluir las propiedades de la clase.
7. Dentro del paquete `application` crear los siguientes paquetes:
   - `controller` para los controladores (por ejemplo `BeerController`)
   - `service` para los servicios (como `BeerService`)
   - (Opcional) Dentro del paquete `application`, crear un subpaquete llamado `lasting` para las constantes.
      - Si se va a usar un Enum, es recomendable usar la anotación `@Enumerated(EnumType.STRING)`
   - `exception` para las excepciones
8. 