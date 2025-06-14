# Java Banking System using Swing and JDBC

## 🏦 Project Overview
This project is a desktop-based Banking System developed using **Java**, **Swing GUI**, and **JDBC (Java Database Connectivity)**. It allows two main roles — users and admins — to interact with the system through a simplified interface similar to an ATM experience.

## 👤 Roles and Functionalities

### 🔐 User Functions
- **Login** using `accountnumber` and `password`
- **Deposit** funds into the account
- **Withdraw** funds with balance validation
- **Check account balance**
- **Logout** from the session

### 🛠️ Admin Functions
- **Login** using admin credentials
- **View all users** and their balances
- **View total money** in the system
- **Create new user accounts**
- **Logout**

---

## 💡 OOP Concepts Applied
- **Encapsulation**: Private fields for account data with getters/setters  
- **Abstraction**: Methods for deposit, withdraw, authenticate, etc.  
- **Modularity**: Organized into `User`, `Bank`, `DB_connection`, and `BANKSYSTEM` classes  

---

## 🗃️ Database Schema

### Database: `bank`

| Field         | Type     | Description                  |
|---------------|----------|------------------------------|
| accountnumber | VARCHAR  | Primary Key - Unique account |
| accountname   | VARCHAR  | Name of the account holder   |
| password      | VARCHAR  | Account login password       |
| balance       | DOUBLE   | Current balance              |

> SQL Example for Account Creation:
```sql
CREATE TABLE accounts (
  accountnumber VARCHAR(20) PRIMARY KEY,
  accountname VARCHAR(100),
  password VARCHAR(50),
  balance DOUBLE
);
⚙️ How to Run
Clone the repository

bash
Copy
Edit
git clone https://github.com/DotYohan/Cpe121-Album.git
Open the project in NetBeans (or your preferred IDE)

Configure the database:

Create a MySQL database named bank

Run the CREATE TABLE command above

Ensure your JDBC URL, username, and password are correct in the DB_connection class

Build and run the BANKSYSTEM main class

🧪 Features in Action
Feature	Description
Create	Admins can add new accounts (balance defaults to 0)
View	Admins see all users and balances
Update	Deposits/Withdrawals modify the balance
Search	Account login checks via accountnumber + password
Delete	Not yet implemented

🧠 Lessons Learned
Modular design made the project easy to expand and maintain

JDBC requires disciplined exception handling and SQL syntax care

Input validation is critical in financial applications

📎 Link to Report
View the Full Lab Report (PDF/Docx)

🔗 GitHub Repository
📂 Cpe121-Briones-FinalProject on GitHub

📌 Author
Naldrelle Yuan M. Briones
BS Electronics and Communication Engineering
Cor Jesu College
