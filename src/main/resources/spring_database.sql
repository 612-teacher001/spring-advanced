\c postgres
DROP DATABASE IF EXISTS spring_advanced_db;
DROP ROLE IF EXISTS student;
CREATE ROLE student WITH PASSWORD 'himitu' LOGIN;
CREATE DATABASE spring_advanced_db OWNER student ENCODING 'UTF8';