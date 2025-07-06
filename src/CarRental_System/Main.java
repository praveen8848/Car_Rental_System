package CarRental_System;

import java.util.*;


class Car {
    private String CarName;
    private String CarBrand;
    private int CarId;
    private double RentPricePerDay;
    private boolean IsAvailable;

    public Car(String name, String Brand, int Id, double rent) {
        this.CarName = name;
        this.CarBrand = Brand;
        this.CarId = Id;
        this.RentPricePerDay = rent;
        IsAvailable = true;
    }

    public String getCarName() {
        return CarName;
    }

    public String getCarBrand() {
        return CarBrand;
    }

    public int getCarId() {
        return CarId;
    }

    public double getRentPricePerDay() {
        return RentPricePerDay;
    }

    public boolean isAvailable() {
        return IsAvailable;
    }

    public double calculateRentPrice(int RentalDays) {
        return RentPricePerDay * RentalDays;
    }

    public void rented() {
        IsAvailable = false; // ✅ Fix: Now correctly marks car as rented
    }

    public void returned() {
        IsAvailable = true;  // ✅ Fix: Correctly marks car as available
    }
}

class Customer {
    private String name;
    private int ID;

    public Customer(String name, int Id) {
        this.name = name;
        this.ID = Id;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }
}

class Rental {
    private Car car;
    private Customer customer;
    private int noOfDays;

    public Rental(Car car, Customer customer, int days) {
        this.car = car;
        this.customer = customer;
        this.noOfDays = days;
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getNoOfDays() {
        return noOfDays;
    }
}

class CarRentalSystem {
    private List<Car> carList;
    private List<Customer> customerList;
    private List<Rental> rentalList;

    public CarRentalSystem() {
        carList = new ArrayList<>();
        customerList = new ArrayList<>();
        rentalList = new ArrayList<>();
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public void rentCar(Car car, Customer customer, int days) {
        if (car.isAvailable()) {
            car.rented(); // ✅ Fix: Correctly marking the car as rented
            rentalList.add(new Rental(car, customer, days));
            System.out.println("\nCar rented successfully.");
        } else {
            System.out.println("Car is already rented.");
        }
    }

    public void returnCar(Car car) {
        Rental rentalToRemove = null;
        for (Rental rental : rentalList) {
            if (rental.getCar() == car) {
                rentalToRemove = rental;
                break;
            }
        }
        if (rentalToRemove != null) {
            rentalList.remove(rentalToRemove); // ✅ Removing the rental record
            car.returned(); // ✅ Marking the car as available again
            System.out.println("Car returned successfully.");
        } else {
            System.out.println("Car was not rented.");
        }
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== Welcome to Car Rental System =====");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter your ID: ");
                int customerID = sc.nextInt();
                sc.nextLine();

                System.out.println("\nAvailable Cars:");
                for (Car car : carList) {
                    if (car.isAvailable()) {
                        System.out.println(car.getCarId() + " - " + car.getCarBrand() + " " + car.getCarName());
                    }
                }

                System.out.print("\nEnter the car ID to rent: ");
                int carId = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter rental days: ");
                int rentalDays = sc.nextInt();
                sc.nextLine();

                Customer existingCustomer = null;
                for (Customer c : customerList) {
                    if (c.getID() == customerID) {
                        existingCustomer = c;
                        break;
                    }
                }

                Customer newCustomer = (existingCustomer != null) ? existingCustomer : new Customer("CUS" + (customerList.size() + 1), customerID);
                if (existingCustomer == null) addCustomer(newCustomer);

                for (Car car : carList) {
                    if (car.getCarId() == carId && car.isAvailable()) {
                        rentCar(car, newCustomer, rentalDays);
                        break;
                    }
                }
            } else if (choice == 2) {
                System.out.print("Enter the car ID to return: ");
                int carId = sc.nextInt();
                sc.nextLine();

                for (Car car : carList) {
                    if (car.getCarId() == carId && !car.isAvailable()) {
                        returnCar(car);
                        break;
                    }
                }
            } else if (choice == 3) {
                System.out.println("\nThank you for using the Car Rental System!");
                break;
            } else {
                System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
        sc.close();
    }
}
public class Main {
    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();

        Car car1 = new Car("C001", "Toyota", 11, 60.0);
        Car car2 = new Car("C002", "Honda", 415, 70.0);
        Car car3 = new Car("C003", "Mahindra", 812, 150.0);

        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);

        rentalSystem.menu();
    }
}
