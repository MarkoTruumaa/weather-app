-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-09-23 14:38:07.619

-- tables
-- Table: city
CREATE TABLE city (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    longitude decimal(15,7)  NOT NULL,
    latitude decimal(15,7)  NOT NULL,
    country varchar(10)  NOT NULL,
    status char(1)  NOT NULL,
    CONSTRAINT city_pk PRIMARY KEY (id)
);

-- Table: city_measurement
CREATE TABLE city_measurement (
    id serial  NOT NULL,
    city_id int  NOT NULL,
    measurement_id int  NOT NULL,
    CONSTRAINT city_measurement_pk PRIMARY KEY (id)
);

-- Table: measurement
CREATE TABLE measurement (
    id serial  NOT NULL,
    temperature decimal(5,2)  NOT NULL,
    wind_speed int  NOT NULL,
    humidity int  NOT NULL,
    date timestamp  NOT NULL,
    CONSTRAINT measurement_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: city_measurement_city (table: city_measurement)
ALTER TABLE city_measurement ADD CONSTRAINT city_measurement_city
    FOREIGN KEY (city_id)
    REFERENCES city (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: city_measurement_measurement (table: city_measurement)
ALTER TABLE city_measurement ADD CONSTRAINT city_measurement_measurement
    FOREIGN KEY (measurement_id)
    REFERENCES measurement (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

