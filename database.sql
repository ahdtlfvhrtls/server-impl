CREATE DATABASE server;

use server;

CREATE TABLE member (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    name VARCHAR(50) NOT NULL
);

create table post(
	id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(500) NOT NULL,
    content text NOT NULL,
    writer_id int NOT NULL,
    create_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp on update current_timestamp,
    foreign key (writer_id) references member(id) on delete cascade
);