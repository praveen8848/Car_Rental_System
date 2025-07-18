package Parole_System;

import java.util.ArrayList;

abstract  class Employee {
     private String name;
     private int ID;

     public Employee(String name, int ID){
         this.name = name;
         this.ID = ID;
     }
     public String getName(){
         return name;
     }

     public void setName(String name){
         this.name = name;
     }
     public int getID(){
         return ID;
     }

     public abstract double calculateSalary();

     @Override
     public String toString(){
         return "Employee Name "+ name + " and Id = " + ID+ " and Salary = "+calculateSalary();
     }
}
class FulltimeEmployee extends Employee{
     private double MonthlySalary;
     public FulltimeEmployee(String name, int id, double MSalary){
         super(name, id);
         this.MonthlySalary = MSalary;
     }

     @Override
     public double calculateSalary(){
         return MonthlySalary;
     }

}

class PartTimeEmployee extends Employee{
     private double Hourlysalary;

     private int HoursWorked;

     public PartTimeEmployee(String name, int id, double salary, int work){
         super(name, id);
         this.Hourlysalary = salary;
         this.HoursWorked = work;
     }

     @Override
     public double calculateSalary(){
         return Hourlysalary*HoursWorked;
     }
}

class PayrollSystem{
     private ArrayList<Employee> list;

     public PayrollSystem(){
         list = new ArrayList<>();
     }
     public void AddEmplyee(Employee  employee){
         list.add(employee);
     }
     public void RemoveEmployee(int ID){
         Employee emptoRemove = null;
         for(Employee e : list){
             if(e.getID() == ID){
                 emptoRemove = e;
                 break;
             }
         }
         if(emptoRemove != null){
             list.remove(emptoRemove);
         }
     }
     public void displayEmployees(){
         for (Employee emp : list){
             System.out.println(emp);
         }
     }
}
class Main{
    public static void main(String[] args) {
        PayrollSystem p1 = new PayrollSystem();
        FulltimeEmployee e1 = new FulltimeEmployee("Akash", 12, 70000.0);
        PartTimeEmployee e2 = new PartTimeEmployee("Kisu", 23, 1000, 4);
        p1.AddEmplyee(e1);
        p1.AddEmplyee(e2);
        System.out.println("Employee details : ");
        p1.displayEmployees();
        System.out.println("Removing Employee : ");
        p1.RemoveEmployee(12);
        System.out.println("Remaining Employee ater removing: ");
        p1.displayEmployees();
    }
}
