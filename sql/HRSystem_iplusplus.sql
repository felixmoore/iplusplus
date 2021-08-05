USE HRSystem_iplusplus;

DROP TABLE IF EXISTS Employee;

CREATE TABLE Employee (
    employee_id SMALLINT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(40) NOT NULL,
    nin CHAR(9),
    department ENUM('HR', 'Finance', 'Sales Team', 'Talent Manager', 'Technical'),
    email VARCHAR(50),
    adress VARCHAR(300),
    phone_number VARCHAR(15),
    PRIMARY KEY (employee_id)
);

insert into Employee (employee_id, first_name, last_name, nin, department, email, adress, phone_number) 
VALUES (1, 'Aimee', 'Boyle', 123456789, 'Technical', 'aimee@email.com', 'Some Adress 11, City, 12345', '+441231231234' );

insert into Employee (employee_id, first_name, last_name, nin, department, email, adress, phone_number) 
VALUES (2, 'Sylwia', 'Łuczak-Jagieła', 987654321, 'HR', 'sylwia@email.com', 'My Adress 22, City, 54321', '+48987987987' );

insert into Employee (employee_id, first_name, last_name, nin, department, email, adress, phone_number) 
VALUES (3, 'Adam', 'Jones', 999888777, 'Sales Team', 'adam@email.com', 'Adam Adress 33, Oxford, 33333', '+441111444666' );

insert into Employee (employee_id, first_name, last_name, nin, department, email, adress, phone_number) 
VALUES (4, 'John', 'Doe', 666555666, 'Talent Manager', 'john@email.com', 'John Adress 4D, London, 23232', '+441888666444' );

insert into Employee (employee_id, first_name, last_name, nin, department, email, adress, phone_number) 
VALUES (4, 'Zoe', 'Jackson', 777333111, 'Finance', 'zoe@email.com', 'Zoe Adress 433d/4, Leeds, 23232', '+441236543335' );

DROP TABLE IF EXISTS BankDetails;

CREATE TABLE BankDetails (
    employee_id SMALLINT NOT NULL,
    sortcode VARCHAR(8),
    account CHAR(26),
    bank_name VARCHAR(150),
    FOREIGN KEY (employee_id)
        REFERENCES Employee (employee_id)
);

insert into BankDetails (employee_id, sortcode, account, bank_name)
VALUES (1, 12345678, 11222233334444555566667777, 'Bank of England');
insert into BankDetails (employee_id, sortcode, account, bank_name)
VALUES (2, 87654321, 99222233334444555566667777, 'Bank of Poland');

DROP TABLE IF EXISTS Customer;

CREATE TABLE Customer (
    customer_id SMALLINT NOT NULL AUTO_INCREMENT,
    customer_name VARCHAR(50),
    contact VARCHAR(50),
    PRIMARY KEY (customer_id)
);

insert into Customer (customer_id, customer_name, contact)
VALUES (1, 'Ministry of Justice', 'Phone +443333444555');
insert into Customer (customer_id, customer_name, contact)
VALUES (2, 'Oxford University', 'Phone +441111222333');

DROP TABLE IF EXISTS Projects;

CREATE TABLE Projects (
    projects_id SMALLINT NOT NULL AUTO_INCREMENT,
    start_date DATE,
    end_date DATE,
    project_manager VARCHAR(70),
    description VARCHAR(300) NOT NULL,
    name VARCHAR(200) NOT NULL,
    customer_id SMALLINT NOT NULL,
    budget SMALLINT,
    PRIMARY KEY (projects_id),
	FOREIGN KEY (customer_id)
        REFERENCES Customer (customer_id)
);

INSERT INTO Projects (projects_id, start_date, end_date, project_menager, description, name, customer_id, budget)
VALUES (1, 2021-07-26, 2021-10-26, 'Felix Moore', 'Development of an application to handle inquiries regarding judgments', 'Judicial application', 1, 1000000,00);
INSERT INTO Projects (projects_id, start_date, end_date, project_menager, description, name, customer_id, budget)
VALUES (1, 2021-08-04, 2022-08-04, 'Amir Makanvand', 'Creation of application for students registration', 'Recruitment application', 2, 500000,00);

DROP TABLE IF EXISTS Sales;

CREATE TABLE Sales (
    total_sales_monthly SMALLINT,
    employee_id SMALLINT,
    commission DECIMAL(10 , 2),
    PRIMARY KEY (employee_id),
    FOREIGN KEY (employee_id)
        REFERENCES Employee (employee_id)
);

INSERT INTO Sales (total_sales_monthly, employee_id, commission)
VALUES (1234546, 3, 555);


DROP TABLE IF EXISTS Technical;

CREATE TABLE Technical (
    employee_id SMALLINT,
    projects_id SMALLINT,
    cv VARCHAR(300),
    passport_photo BLOB,
    PRIMARY KEY (employee_id),
    FOREIGN KEY (projects_id)
        REFERENCES Projects (projects_id),
    FOREIGN KEY (employee_id)
        REFERENCES Employee (employee_id)
);

INSERT INTO Technical (employee_id, projects_id, cv) 
VALUES (1, 1, 'Aimee is a very good programmer specializing in JAVA, moreover proficient in using the following tools: GIT, MySQL, Trello');