# Library Management System

A console-based Java application for managing books, members, and borrowing.

## Features
- Add books and list them with their status (Available / Borrowed)
- Search for a book by title (case-insensitive)
- Register members, with duplicate ID protection
- Borrow and return books, with validation (unknown member, unknown book, already borrowed)
- Input validation: invalid menu input does not crash the program

## Tech
Java 21, OOP (encapsulation), Collections (`ArrayList`, `HashMap`), exception handling, Git

## Project Structure
- `Book` – title and availability
- `Member` – id and name
- `Library` – holds books and members, and contains the borrowing logic
- `Main` – console menu

## How to Run
1. Clone the repository
2. Open it in IntelliJ IDEA
3. Run `Main.java`

## What I Learned
- Designing classes and keeping data private with getters and setters
- Using `ArrayList` and `HashMap` instead of fixed arrays
- Handling invalid input with `try/catch`
- Using Git and GitHub from the first day of the project

## Next
Turning this into a REST API with Spring Boot, adding database storage, an AI feature, and cloud deployment.
