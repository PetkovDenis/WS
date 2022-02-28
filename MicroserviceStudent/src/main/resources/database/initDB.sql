CREATE TABLE IF NOT EXISTS students
(
    id    SERIAL PRIMARY KEY ,
    firstName  VARCHAR(200) NOT NULL ,
    middleName  VARCHAR(200) NOT NULL ,
    lastName  VARCHAR(200) NOT NULL ,
    specialization  VARCHAR(200) NOT NULL ,
    age  VARCHAR(200) NOT NULL,
    course  VARCHAR(200) NOT NULL
    );
