create table weather
(
    condition varchar(255) not null,
    location varchar(255) not null,
    temperature bigint not null,
    date DATE

);

create table endUser
(
    id bigint not null,
    username varchar(255) not null,
    name varchar(255) not null,
    password bigint not null,
    role varchar(255) not null,
    primary key (id)

);