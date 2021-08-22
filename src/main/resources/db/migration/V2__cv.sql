insert into persons (contact_details_id, name, year_of_birth)
values (NULL, 'Jack Doe', 2000);
insert into address (city, house_number, street, zip_code)
VALUES ('Xuzhou', '12', 'Apple street', 3658);
insert into contacts (address_id, email, mobile_number)
VALUES (1, 'valaki@valaki.hu', '+36701234567');
update persons
set contact_details_id=1
where id = 1;
insert into educations (major, person_id, year_of_finished)
VALUES ('chemist', 1, '2000');
insert into educations (major, person_id, year_of_finished)
VALUES ('Java', 1, '2021');
insert into workplaces (finish_year, name_of_the_company, person_id, starting_year)
VALUES (2017, 'CUMT', 1, '2015');
insert into workplaces (finish_year, name_of_the_company, person_id, starting_year)
VALUES (2020, 'NOKIA', 1, '2017');