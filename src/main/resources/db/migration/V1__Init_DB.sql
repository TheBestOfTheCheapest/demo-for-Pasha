create sequence hibernate_sequence start 1 increment 1;

CREATE TABLE section
(
    id serial PRIMARY KEY NOT NULL,
    parent_id int,
    created_date timestamp,
    updated_date timestamp,
    section_level int,
    section_key varchar(256),
    section_value varchar(256)
);

CREATE TABLE task
(
    id serial PRIMARY KEY NOT NULL,
    section_id int,
    created_date timestamp,
    updated_date timestamp,
    task_title VARCHAR(128),
    task_text varchar(4096),
    source_sample varchar(4096),
    source_template varchar(32768),
    CONSTRAINT task_section_id_fk FOREIGN KEY (section_id) REFERENCES section (id)
);

CREATE TABLE users
(
    id serial PRIMARY KEY NOT NULL,
    authority int,
    created_date timestamp,
    updated_date timestamp,
    first_name varchar(64) NOT NULL,
    middle_name varchar(64),
    last_name varchar(64) NOT NULL,
    email varchar(64) NOT NULL,
    password varchar(256)
);
CREATE UNIQUE INDEX users_email_uindex ON users (email);

CREATE TABLE solution
(
    id serial PRIMARY KEY NOT NULL,
    user_id int,
    task_id int,
    created_date timestamp,
    value varchar(32768),
    test_result varchar(2048),
    CONSTRAINT solution_users_id_fk FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT solution_tasks_id_fk FOREIGN KEY (task_id) REFERENCES task (id)
)