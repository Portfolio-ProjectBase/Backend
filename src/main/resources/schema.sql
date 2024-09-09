IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='users' AND xtype='U')
CREATE TABLE users (
    id INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
    is_deleted BIT,
    deleted_at DATETIME,
    last_modified DATETIME,
    created_date DATETIME,
    name VARCHAR(255),
    surname VARCHAR(255),
    email_address VARCHAR(255),
    username VARCHAR(255),
    password VARCHAR(255),
    about_me VARCHAR(255),
    detail VARCHAR(255)
);
