use petshelter;
drop table if exists users;
create table users (
                       user_id int(16) NOT NULL AUTO_INCREMENT,
                       username varchar(16) NOT NULL,
                       password varchar(16) NOT NULL,
                       email varchar(32) NOT NULL,
                       primary key (user_id)
);

drop table if exists posts;
create table posts (
                       post_id int(16) not null AUTO_INCREMENT,
                       post_by_id int(16) NOT NULL,
                       post_pet_id int(16) NOT NULL,
                       post_date date not null,
                       post_is_closed boolean not null default false,
                       post_adopter_id int(16),
                       primary key (post_id)
);

drop table if exists applications;
create table applications (
                              application_id int(16) not null AUTO_INCREMENT,
                              application_applicant_id int(16) not null,
                              application_post_id int(16) not null,
                              application_message varchar(100),
                              application_is_accepted boolean not null default false,
                              application_is_closed boolean not null default false,
                              application_date date not null,
                              primary key (application_id)
);

drop table if exists pets;
create table pets (
                      pet_id int(16) not null auto_increment,
                      pet_name varchar(16) not null,
                      pet_age int(2) not null,
                      pet_species  varchar(16) not null,
                      primary key (pet_id)
)