# Book Inventory Management System

A Java-based application for managing a book inventory, allowing users to add, search, filter, update, and export book information using a MySQL database.

## Prerequisites

- **Java SE Development Kit (JDK)** — Java SE 8 or newer installed
- **NetBeans IDE** — required to run and develop the project
- **MySQL Server** — required for storing and managing book information
- **MySQL Connector/J** — required to connect the Java application to MySQL

> **Note:** You need to download and install the above tools separately.

Make sure the MySQL server is running before starting the application. The database connection must also be configured correctly in the project.

## Installation

### Clone the Repository

    git clone https://github.com/your-username/Book-Inventory-Management-System.git
    cd Book-Inventory-Management-System

### Set Up the MySQL Database

1. Open MySQL Command Line Client.
2. Create the database required by the application.
3. Run the provided SQL script to create the necessary table.
```sql
CREATE TABLE your_table_name (
    Entry_ID INT NOT NULL AUTO_INCREMENT,
    Title TEXT NULL,
    Author VARCHAR(100) NULL,
    Genre VARCHAR(100) NULL,
    Publication_Date DATE NULL,
    ISBN VARCHAR(20) NULL,
    PRIMARY KEY (Entry_ID)
);
```


4. Configure the database connection in the Java application with your MySQL username, password, host, and database name.

## Usage

### Run in NetBeans IDE

1. Open NetBeans IDE.
2. Go to **File → Open Project →** select `Book-Inventory-Management-System`.
3. Ensure the MySQL server is running.
4. Run `BookInvSysUI` in the package.

> **Note:** The project must have a valid MySQL database connection before running the application.

## Project Structure

    Book-Inventory-Management-System/
    ├── nbproject/                   # NetBeans project metadata
    ├── src/
    │   └── BookInvSysUI/           # Java source code
    │       ├── BookInvSysUI.java
    │       ├── BookInvSysUI.form
    ├── build.xml                    # Ant build script
    ├── manifest.mf
    └── README.md                    # (this file)

## Features

- **Book Management:** Add, update, view, and delete books from the inventory
- **Book Information:** Store title, author, genre, ISBN, publication year, and quantity
- **Book Filtering:** Filter and search books by title, author, genre, and other attributes
- **CSV Export:** Export book inventory information to a CSV file
- **Input Validation:** Prevent invalid or incomplete book information from being added

## License

Released under the MIT License.

## Author

Aniruddha Nandy
