create table measurement
(
    measurement_id serial
        constraint measurement_pk
            primary key,
    raining        boolean   not null,
    sensor_id      integer   not null
        constraint fk_measurement_sensor_id
            references sensor,
    time           timestamp not null,
    value          real      not null
);

alter table measurement
    owner to postgres;

create unique index measurement_measurement_id_uindex
    on measurement (measurement_id);

create unique index measurement_measurement_id_uindex_2
    on measurement (measurement_id);


