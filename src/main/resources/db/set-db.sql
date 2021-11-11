create database if not exists blogdb;

create user if not exists 'blog_user'@'localhost' identified by 'blog123';
grant all privileges on blogdb.* to 'blog_user'@'localhost';
flush privileges;