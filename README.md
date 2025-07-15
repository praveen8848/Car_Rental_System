🚗 Car Rental System – Java Console Application
A simple Java-based Car Rental System that allows users to rent and return cars. It manages a list of available cars, tracks customer information, and handles rental records in a structured and object-oriented way.

📌 Features
✅ Add and manage multiple cars

✅ Rent available cars to customers

✅ Return rented cars

✅ Calculates rental cost based on number of days

✅ Maintains availability status of each car

✅ Object-Oriented Design using classes: Car, Customer, Rental, CarRentalSystem

🛠️ Technologies Used
Java (JDK 21)

Console-based UI (Scanner class for input)

🧾 Classes Overview
🔹 Car
Represents a car available for rent.

Method	Description
calculateRentPrice(int days)	Calculates total rent
isAvailable()	Checks if the car is available
rented() / returned()	Change availability status

🔹 Customer
Stores customer name and ID.

🔹 Rental
Maintains record of a car rented by a customer for a number of days.

🔹 CarRentalSystem
Main system managing cars, customers, and rentals.

Functionality	Description
addCar(Car car)	Adds a new car
addCustomer(Customer c)	Adds a new customer
rentCar(...)	Rents a car to a customer
returnCar(...)	Handles car returns
menu()	CLI menu loop


