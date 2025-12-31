# Java Grocery Cart Console Application (Pre-OOP)

This project is a simple console-based grocery cart application written in Java.
It was developed **before Object-Oriented Programming (OOP)** to practice Java fundamentals
such as arrays, loops, methods, and user input handling.

---

## Features

- Add products to the cart
- Display cart contents in a formatted table
- Search products by name (partial match supported)
- Limit of 5 products (array-based design)
- Case-insensitive product search

---

## Technologies Used

- Java
- Scanner (for user input)
- Arrays (String[], double[], int[])

---

## Why Arrays Instead of OOP?

This project intentionally uses **parallel arrays** instead of classes to strengthen
core Java fundamentals before transitioning to Object-Oriented Programming.

Each product is represented using:
- `productNames[]`
- `productPrices[]`
- `productQuantities[]`

The same index across arrays refers to the same product.

---

## Limitations

- Fixed cart size (maximum 5 products)
- No exception handling for invalid input
- No persistent storage (data resets on restart)

These limitations are **intentional** and will be addressed in the OOP version.

---

## Future Improvements

- Refactor using a `Product` class
- Replace arrays with `ArrayList`
- Add input validation and exception handling
- Improve menu structure

---

## How to Run

1. Clone the repository
2. Open the project in IntelliJ IDEA
3. Run the `GroceryCart` class
4. Follow the console menu instructions