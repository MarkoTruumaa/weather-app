-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-09-24 11:00:56.341

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

-- Table: measurement
CREATE TABLE measurement (
    id serial  NOT NULL,
    city_id int  NOT NULL,
    temperature decimal(5,2)  NOT NULL,
    wind_speed int  NOT NULL,
    humidity int  NOT NULL,
    date_time timestamp  NOT NULL,
    CONSTRAINT measurement_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: measurement_city (table: measurement)
ALTER TABLE measurement ADD CONSTRAINT measurement_city
    FOREIGN KEY (city_id)
    REFERENCES city (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

