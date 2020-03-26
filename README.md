#This project depicts the Spring Boot Example with Spring Data MongoDB

#If you add some Unit Tests, you would start them with mvn clean test.

#You can build the project with : mvn clean install -U.

#To run the project, Choose the Spring Boot Application file (search for @SpringBootApplication). Right Click on the file (UserApplication) and Run as Java Application

#the server get started on port 8081

#URLs

http://localhost:8081/users/	:POST method is to insert user information to database.
http://localhost:8081/users/email/rakhicc29@gmail.com	:GET	method to get user information based on email address.
http://localhost:8081/users/email/9497357899	:GET	method retrieves user information based on phone number.
