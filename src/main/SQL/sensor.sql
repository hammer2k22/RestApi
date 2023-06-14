create table sensor
(
    sensor_id serial
        constraint sensor_pk
            primary key,
    name      varchar(30) not null
);

alter table sensor
    owner to postgres;

create unique index sensor_name_uindex
    on sensor (name);

create unique index sensor_sensor_id_uindex
    on sensor (sensor_id);


