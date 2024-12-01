# Employee Management

**Employee Management** is a JavaFX application designed to manage employee records. It allows users to add, edit, delete, and display employee information stored in a PostgreSQL database. The application supports three types of employees: Full-time, Part-time, and Contractor, with the ability to set hire dates.

---

## Features

- **Add Employee**:
  - Input fields for employee name, type, hourly rate, hours worked, and hire date.
  - Automatic salary calculation based on employee type.
- **Delete Employee**:
  - Remove selected employee from both the table and the database.
- **Edit Employee**:
  - Modify employee details like name, type, hourly rate, hours worked, and hire date.
- **View Employees**:
  - Display a table of employees with columns:
    - Name
    - Type (Full-time, Part-time, Contractor)
    - Salary
    - Hire Date

---

## Requirements

### System Requirements
- **Java Development Kit (JDK)**: 17 or later
- **JavaFX**: UI library
- **PostgreSQL**: Database server

### Installation
**Set Up the Database**
- Ensure PostgreSQL is installed and running.
- Create a database named "employee"

**Set Up the Project**
- Clone the repository
- Open the project in your IDE 
- Ensure Maven dependencies are loaded.
- Configure the database connection in the EmployeeData class


### Project Structure
**Key Classes**
- Employee
- Abstract class representing an employee.

 **Employee Types**
- FullTimeEmployee
- PartTimeEmployee
- Contractor

**EmployeeData**
- Handles database interactions.

**Methods**
- createEmployee(Employee employee)
- getAllEmployees()
- updateEmployee(Employee employee)
- deleteEmployee(int id)

![Screenshot 2024-12-01 225031](https://github.com/user-attachments/assets/c4c00ca3-1bd3-4169-9111-a4b45083c479)
![Screenshot 2024-12-01 225122](https://github.com/user-attachments/assets/61bae96e-2bad-471a-b58d-e23e442ac0d2)
![Screenshot 2024-12-01 225131](https://github.com/user-attachments/assets/ee226469-5ad9-49ab-8010-8aa6a944f34c)

