CREATE DATABASE Mining_Activity;

USE Mining_Activity;

CREATE TABLE Galamsey(
vegetation_color varchar(10),
color_value int NOT NULL,
latitude varchar(100),
longitude varchar(100),
yearofevent  year,
obsName varchar(100) NOT NULL
);


CREATE TABLE Observatory(
ObsName varchar(100),
country varchar(100),
year_started year,
area_covered double
);



