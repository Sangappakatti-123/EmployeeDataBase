package edbms;

import java.util.Scanner;

import customexception.InvalidChoiceException;

public class Solution {
 public static void main(String[] args) {
	 System.out.println("Welcome to Employee DataBase Management System");
		System.out.println("------------------------------------------------");
		Scanner sc=new Scanner(System.in);
		EmployeeManagementSystem emp=new EmployeeManagementSystemImpl();
		while(true) {
			System.out.println("MENU DRIVEN PROGRAM");
			System.out.println("1.Add Employee \n2.Display Employee \n3.DisplayAll Employee");
			System.out.println("4.Remove Employee\n5.RemoveAll Employee\n6.update Employee");
			System.out.println("7.count Employee\n8.sort Employee\n9.Find Employee with highest Salary");
			System.out.println("10.Find Employee with Lowest Salary\n11.EXIT");
			int choice=sc.nextInt();
			switch(choice) {
			case 1: emp.addEmployee();
			break;
			case 2: emp.displayEmployee();
			break;
			case 3: emp.displayAllEmployee();
			break;
			case 4: emp.removeEmployee();
			break;
			case 5: emp.removeAllEmployee();
			break;
			case 6: emp.updateEmployee();
			break;
			case 7: emp.countEmployee();
			break;
			case 8: emp.sortEmployee();
			break;
			case 9: emp.findEmployeeWithHighestSalary();
			break;
			case 10: emp.findEmployeeWithLowestSalary();
			break;
			case 11:System.out.println("THANK YOU!");
			System.exit(0);
			default:try {
				String message="invalid choice,kindly enter valid choice";
				throw new InvalidChoiceException(message);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
}
}
 }}
