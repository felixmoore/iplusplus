USE HRSystem_iplusplus;

CREATE TABLE IF NOT EXISTS Employee (
    employee_id SMALLINT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(40) NOT NULL,
    nin CHAR(9),
    department ENUM('HR', 'Finance', 'Sales Team', 'Talent Manager', 'Technical'),
    salary DECIMAL(7,2),
    email VARCHAR(50),
    adress VARCHAR(300),
    phone_number VARCHAR(15),
    PRIMARY KEY (employee_id)
);

insert into Employee (first_name, last_name, nin, department, salary, email, adress, phone_number)
VALUES ('Aimee', 'Boyle', 123456789, 'Technical', 30000.00, 'aimee@email.com', 'Some Adress 11, City, 12345', '+441231231234' );

insert into Employee (first_name, last_name, nin, department, salary, email, adress, phone_number)
VALUES ('Sylwia', 'Łuczak-Jagieła', 987654321, 'HR', 15000.00, 'sylwia@email.com', 'My Adress 22, City, 54321', '+48987987987' );

insert into Employee (first_name, last_name, nin, department, salary, email, adress, phone_number)
VALUES ('Adam', 'Jones', 999888777, 'Sales Team', 20000.00, 'adam@email.com', 'Adam Adress 33, Oxford, 33333', '+441111444666' );

insert into Employee (first_name, last_name, nin, department, salary, email, adress, phone_number)
VALUES ('John', 'Doe', 666555666, 'Talent Manager', 45000.00, 'john@email.com', 'John Adress 4D, London, 23232', '+441888666444' );

insert into Employee (first_name, last_name, nin, department, email, salary, adress, phone_number)
VALUES ('Zoe', 'Jackson', 777333111, 'Finance', 23000.00, 'zoe@email.com', 'Zoe Adress 433d/4, Leeds, 23232', '+441236543335' );

CREATE TABLE IF NOT EXISTS BankDetails (
    employee_id SMALLINT NOT NULL,
    sortcode VARCHAR(8),
    account CHAR(26),
    bank_name VARCHAR(150),
    PRIMARY key (employee_id),
    FOREIGN KEY (employee_id)
        REFERENCES Employee (employee_id)
);

insert into BankDetails (employee_id, sortcode, account, bank_name)
VALUES (1, 12345678, 11222233334444555566667777, 'Bank of England');
insert into BankDetails (employee_id, sortcode, account, bank_name)
VALUES (2, 87654321, 99222233334444555566667777, 'Bank of Poland');

CREATE TABLE IF NOT EXISTS Customer (
    customer_id SMALLINT NOT NULL AUTO_INCREMENT,
    customer_name VARCHAR(50),
    contact VARCHAR(50),
    PRIMARY KEY (customer_id)
);

insert into Customer (customer_id, customer_name, contact)
VALUES (1, 'Ministry of Justice', 'Phone +443333444555');
insert into Customer (customer_id, customer_name, contact)
VALUES (2, 'Oxford University', 'Phone +441111222333');

CREATE TABLE IF NOT EXISTS Projects
(
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

INSERT INTO Projects (start_date, end_date, project_manager, description, name, customer_id, budget)
VALUES (2021-07-26, 2021-10-26, 'Felix Moore', 'Development of an application to handle inquiries regarding judgments', 'Judicial application', 1, 1000000.00);
INSERT INTO Projects (start_date, end_date, project_manager, description, name, customer_id, budget)
VALUES (2021-08-04, 2022-08-04, 'Amir Makanvand', 'Creation of application for students registration', 'Recruitment application', 2, 500000.00);

CREATE TABLE IF NOT EXISTS Sales (
    total_sales_monthly SMALLINT,
    employee_id SMALLINT,
    commission DECIMAL(10 , 2),
    PRIMARY KEY (employee_id),
    FOREIGN KEY (employee_id)
        REFERENCES Employee (employee_id)
);

INSERT INTO Sales (total_sales_monthly, employee_id, commission)
VALUES (1234546, 3, 555);

CREATE TABLE IF NOT EXISTS Technical (
    employee_id SMALLINT,
    projects_id SMALLINT,
    cv VARCHAR(300),
    passport_photo BLOB,
    PRIMARY KEY (employee_id),
    FOREIGN KEY (projects_id)
        REFERENCES Projects (projects_id)
);

INSERT INTO Technical (employee_id, projects_id, cv) 
VALUES (1, 1, 'Aimee is a very good programmer specializing in JAVA, moreover proficient in using the following tools: GIT, MySQL, Trello');