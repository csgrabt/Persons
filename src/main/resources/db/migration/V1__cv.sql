create table address (id bigint not null auto_increment, city varchar(255), house_number varchar(255), street varchar(255), zip_code varchar(255), primary key (id)) engine=InnoDB;
create table contacts (id bigint not null auto_increment, email varchar(255), mobile_number varchar(255), address_id bigint, primary key (id)) engine=InnoDB;
create table educations (id bigint not null auto_increment, major varchar(255), year_of_finished integer, person_id bigint, primary key (id)) engine=InnoDB;
create table persons (id bigint not null auto_increment, name varchar(255), year_of_birth integer, contact_details_id bigint, primary key (id)) engine=InnoDB;
create table workplaces (id bigint not null auto_increment, finish_year integer, name_of_the_company varchar(255), starting_year integer, person_id bigint, primary key (id)) engine=InnoDB;
alter table contacts add constraint FKqk4vtt75unaf7ipdks3437h5p foreign key (address_id) references address (id);
alter table educations add constraint FK6ouq5aatwkt1cgmfqmx681vse foreign key (person_id) references persons (id);
alter table persons add constraint FK2uofx1a2ddiy1519jib2t3bad foreign key (contact_details_id) references contacts (id);
alter table workplaces add constraint FKddnkjll59ctc5ua4gswfifvp4 foreign key (person_id) references persons (id);