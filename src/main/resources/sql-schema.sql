create database if not exists ims;
create table if not exists ims.customers(customer_id int auto_increment, first_name varchar(40), surname varchar(40), address varchar(40), PRIMARY KEY (customer_id));
create table if not exists ims.items(item_id int auto_increment, item_name varchar(40), item_price NUMERIC(19,2), PRIMARY KEY (item_id));