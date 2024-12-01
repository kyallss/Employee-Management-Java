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
