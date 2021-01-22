drop database if exists ims_test;
create database if not exists ims_test;
create table if not exists ims_test.customers(customer_id int auto_increment NOT NULL, first_name varchar(40), surname varchar(40), address varchar(40), PRIMARY KEY (customer_id));
create table if not exists ims_test.items(item_id int auto_increment NOT NULL, item_name varchar(40), item_price NUMERIC(19,2), PRIMARY KEY (item_id));
create table if not exists ims_test.orders(order_id int auto_increment NOT NULL, customer_id INT NOT NULL, PRIMARY KEY (order_id), FOREIGN KEY (customer_id) REFERENCES ims_test.customers(customer_id));
create table if not exists ims_test.orderline(orderline_id int auto_increment NOT NULL, item_id int, order_id int, orderline_price NUMERIC(19,2), quantity INT, PRIMARY KEY (orderline_id), foreign key(item_id) references ims_test.items(item_id), foreign key(order_id) references ims_test.orders(order_id));