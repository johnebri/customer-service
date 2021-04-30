# customer-service
A RESTful API service for a simple customer database

# Development tools
- The application was developed with Spring boot 2.3.1
- Test Framework used: Mockito
- Server: Tomcat
- Database used: MySql

# Requirements to build project
- Java SE 11
- Apache Maven ^3.6

# Method 1 (Running with Maven mvnw command)
1. Clone the repository
2. Navigate to project directory in a terminal
3. Run the command
- (for Windows users using windows command prompt app) mvnw spring-boot:run
- (for MacOS/Linux users) ./mvnw spring-boot:run
Application is started on http://localhost:8080
If port 8080 is already used by another application in your computer, open the application.properties file and change port with 'server.port=8181'

# Method 2 (Building a jar file with mvn package)
1. Clone the repository
2. Open the project directory in a terminal
3. Run "mvn package", to build a jar file in the target directory of the project
4. Navigate to target directory
5. Run java -jar customerservice-0.0.1-SNAPSHOT.jar to execute the jar file
6. Application is started on http://localhost:8080
7. If port 8080 is already used by another application in your computer, open the application.properties file and change port with 'server.port=8181
