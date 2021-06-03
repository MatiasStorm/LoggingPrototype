# Kørselsvejledning
1. Open a terminal and run the following command:


     *linux:* `mvn spring-boot:run`
     
     
     *Windows:* `mvnw.cmd spring-boot:run`
    

**Endpoints:**


POST requests:
- `/log` creates a notification log
- `/error` create an error log

GET requests:
- `/log` retrieves all the logs (Notification and error).

