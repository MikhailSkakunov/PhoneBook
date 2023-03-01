# PhoneBook
Таблицы БД формируются при запуске PhoneBookApplication (предварительно раскомментировать spring.jpa.hibernate.ddl-auto=create в файле application.properties), 
После формирования таблиц, закомментировать данную строку(spring.jpa.hibernate.ddl-auto=create).
Заполнение таблицы первоначальными данными: 
INSERT INTO persons (first_name, surname, patronymic) VALUES ('Антон', 'Владимирович', 'Балкин');
INSERT INTO persons (first_name, surname, patronymic) VALUES ('Игорь', 'Сергеевич', 'Цибульский');
INSERT INTO persons (first_name, surname, patronymic) VALUES ('Михаил', 'Юрьевич', 'Скакунов');
INSERT INTO persons (first_name, surname, patronymic) VALUES ('Михаил', 'Маркович', 'Глуховской');

INSERT INTO phone_types (type_name) VALUES ('мобильный');
INSERT INTO phone_types (type_name) VALUES ('корпоративный');
INSERT INTO phone_types (type_name) VALUES ('корпортативный 2');
INSERT INTO phone_types (type_name) VALUES ('мобильный');

INSERT INTO phones (number, person_id, type_id) VALUES ('89991234567', 1, 1);
INSERT INTO phones (number, person_id, type_id) VALUES ('89039577070', 2, 3);
INSERT INTO phones (number, person_id, type_id) VALUES ('89059789999', 3, 4);
INSERT INTO phones (number, person_id, type_id) VALUES ('89611539181', 4, 2);

INSERT INTO streets (street_name)  VALUES ('Московский проспект');
INSERT INTO streets (street_name)  VALUES ('Володарского');
INSERT INTO streets (street_name)  VALUES ('Свободы');
INSERT INTO streets (street_name)  VALUES ('проспект Авиаторов');

INSERT INTO addresses (city, street_id, building_number, person_id) VALUES ('Ярославль', 1, '11', 1);
INSERT INTO addresses (city, street_id, building_number, person_id) VALUES ('Ярославль', 2, '72', 2);
INSERT INTO addresses (city, street_id, building_number, person_id) VALUES ('Ярославль', 3, '16', 3);
INSERT INTO addresses (city, street_id, building_number, person_id) VALUES ('Ярославль', 4, '6', 4);
