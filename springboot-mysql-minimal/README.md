# Minimal Spring Boot + MySQL CRUD

## 1. Requirements
- JDK 17+
- Maven
- MySQL Server
- Postman (or curl)

## 2. Create the database
Run this in MySQL:
```sql
CREATE DATABASE labdb;
```

## 3. Configure database credentials
Edit `src/main/resources/application.properties` and replace `YOUR_MYSQL_PASSWORD` with your MySQL root password.
If your MySQL user has no password, leave the value blank:
`spring.datasource.password=`

## 4. Run the project
From this folder:
```bash
mvn spring-boot:run
```
Or open it in IntelliJ / Eclipse and run `DemoApplication`.

## 5. Test endpoints
Base URL: `http://localhost:8080/students`

### Add student — POST
Send JSON with `Content-Type: application/json`:
```json
{
  "name": "Anu",
  "email": "anu@example.com"
}
```

### Get all — GET
`GET http://localhost:8080/students`

### Get one — GET
`GET http://localhost:8080/students/1`

### Update — PUT
`PUT http://localhost:8080/students/1`
```json
{
  "name": "Anu Kumar",
  "email": "anu.kumar@example.com"
}
```

### Delete — DELETE
`DELETE http://localhost:8080/students/1`

## The 5 files to remember
1. `DemoApplication.java` — starts Spring Boot.
2. `Student.java` — entity/table structure.
3. `StudentRepository.java` — database CRUD via JpaRepository.
4. `StudentController.java` — API endpoints and logic.
5. `application.properties` — database connection.

## Adapt it to likely exam questions
- Quiz: create `Question` and `StudentScore` entities; add a score calculation method in the controller/service.
- Food ordering: create `Food` and `Order` entities; calculate `totalAmount` from selected food prices, then save the order.
- Library seat / booking: change `Student` to the required entity and add the fields from the question.

## Quick annotations
- `@Entity`: maps Java class to a database table.
- `@Id`: primary key.
- `@GeneratedValue`: auto-generates primary key.
- `JpaRepository<Student, Long>`: gives CRUD methods.
- `@RestController`: controller returns data (usually JSON).
- `@RequestMapping`: common URL prefix.
- `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`: map HTTP methods to Java methods.
- `@RequestBody`: converts incoming JSON into a Java object.
- `@PathVariable`: reads a value from the URL.
