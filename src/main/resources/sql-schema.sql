create database if not exists ims;
create table if not exists ims.customers(customerid int primary key auto_increment, first_name varchar(40), surname varchar(40), address varchar(40));
create table if not exists ims.orders(orderid int primary key auto_increment, first_name varchar(40), surname varchar(40), address varchar(40));

