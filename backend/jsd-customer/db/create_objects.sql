CREATE DATABASE IF NOT EXISTS josivansilva;

CREATE  TABLE josivansilva.customer ( 
customer_id INT NOT NULL ,
customer_type INT NOT NULL ,
customer_name VARCHAR(255) NOT NULL ,
customer_monthly_income NUMERIC(10,2) ,
customer_risk CHAR(1) NOT NULL ,
customer_address VARCHAR(355) NOT NULL ,
customer_total_patrimony NUMERIC(15,2) NULL,
customer_current_debts NUMERIC(15,2) NULL,
customer_employed TINYINT(1) NULL,
PRIMARY KEY (customer_id) );