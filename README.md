# parserbox
Реализация небольшого Web Api на SpringBoot.
Создание на spring.io, добавление dependency -> Starter-web; Lombok: Test.
Тестовое задание:
Необходимо - бекенд с REST API, получающего кусочки текста по ссылке и получающего на них короткую ссылку. Ссылку можно отправить адресату.
Пользователь указывает:
1) Срок в течение которого будет доступна ссылка (expiration time) 10 мин., 1 час, 3 часа, 1 день, 1 неделя, 1 месяцб без ограничения. После окончания срока получить доступ к ссылке нельзя.
2) Ограниченные права:
   - PUBLIC - доступ всем;
   - UNILISTED - доступно только по ссылке.
   
   Для загруженной (пасты) выдается ссылка вида:
   http://my-awesome-bin.tId/{hash}.
   Например: http://my-text.tId/ad12cd13
   Ограничение на последние 10 загруженныых паст (код/текст).
   
   Docker ->
   
   FROM openjdk:14-jdk-alpine
   
   MAINTAINER Serdyuk Sergey Borisovich
   
   COPY target/parserbox-0.0.1-SNAPSHOT.jar parserbox.jar
   
   ENTRYPOINT["java","-jar","/parserbox.jar"]
