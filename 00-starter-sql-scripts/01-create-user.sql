-- Drop user first if they exist
DROP USER if exists 'todouser'@'localhost' ;

-- Now create user with prop privileges
CREATE USER 'todouser'@'localhost' IDENTIFIED BY 'todouser';

GRANT ALL PRIVILEGES ON * . * TO 'todouser'@'localhost';