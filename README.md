# Identity-Management
This project is designed to securely manage user identity

## Requirements
- #### Java SDK
Just go on [official Oracle website](https://www.oracle.com/java/technologies/javase-downloads.html) and download the suitable Java SE Development Kit installer for your OS. (In my local machine I use Java SE Development Kit 11)
- #### PostgreSQL
Postgresql is used as database in this project.
For [download](https://www.postgresql.org/) Postqresql on your local computer.
## Project Install

    $ https://github.com/muhammedsedef/identity-management.git

## Configure app
    Open application.properties file on that file directory => $ cd src/main/resources/application.properties
    
    Then copy and paste that configuration settings
     
    spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.hibernate.show-sql=true
    spring.datasource.url=jdbc:postgresql://localhost:5432/IdentityManagementDemo
    spring.datasource.username=postgres
    spring.datasource.password=123456
    spring.jpa.properties.javax.persistence.validation.mode = none
    
    You should change username and password according to your information. 

## Running the project

     $ cd src/main/java/com.example.identitymanagement
     run IdentityManagementApplication.java on your IDE
