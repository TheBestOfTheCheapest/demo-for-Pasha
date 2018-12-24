# demo-for-Pasha backend module
В проете используется база данных [PostgreSQL](https://www.postgresql.org/download/)

## Запуск проекта на локальном компьютере
* скачать автуальную версию проекта с GitHub
* создать базу данных demo-for-pasha
* в *src/main/resources/* создать файл *application-dev.properties*
* в него добавить следующие строки:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/demo-for-pasha
spring.datasource.username=%database_username%
spring.datasource.password=%your_db_password%
spring.jpa.generate-ddl=true
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=validate

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
```
* в luncher в раздел *Enviroment* в строку *Program arguments* установить значение *--spring.profiles.active=dev*
* запустить проект

Во время запуска flywaydb автоматически создаст все необходимые таблицы в БД и заполнит их данными

## Запуск на сервере

## Версионность

## Лицензирование

## Авторы
