DROP TABLE IF EXISTS cats;

CREATE TABLE cats (
    name VARCHAR(250) PRIMARY KEY,
    age INT,
    fur_colour VARCHAR(250),
    eye_colour VARCHAR(250)
);

INSERT INTO cats (name, age, fur_colour, eye_colour) VALUES
    ('Felix', 10, 'Black and white', 'Green');