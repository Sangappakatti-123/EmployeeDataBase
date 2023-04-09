package edbms;
import java.util.*;

import customexception.*;

import customsorting.*;

public class EmployeeManagementSystemImpl implements EmployeeManagementSystem {
     Scanner sc=new Scanner(System.in);
	Map<String ,Employee> db=new LinkedHashMap<String ,Employee>();
	
	@Override
	public void addEmployee() {
		System.out.println("enter employee age");
		int age=sc.nextInt();
		System.out.println("enter name ");
		String name=sc.next();
		System.out.println("enter salary");
		double salary=sc.nextDouble();
		
		Employee emp=new Employee(age,name,salary);
		db.put(emp.getId(), emp);
		System.out.println("employee data is saved succesfully");
		
	}

	@Override
	public void displayEmployee() {
		System.out.println("enter employee id ");
		String id=sc.next().toUpperCase();
		if(db.containsKey(id)) {
	     System.out.println(db.get(id));
	   
		}
		else {try {
			String message="employee record is not present";
			throw new EmployeeNotFoundException(message);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}}

	@Override
	public void displayAllEmployee() {
		if(!db.isEmpty()) {
			   Set<String> keys=db.keySet();
			   for(String key:keys) {
				   System.out.println(db.get(key));
			   }}
		else {try {
			String message="employee record is not present";
			throw new EmployeeNotFoundException(message);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}} 
		
	}

	@Override
	public void removeEmployee() {
		System.out.println("enter employee id");
		String id=sc.next().toUpperCase();
		if(db.containsKey(id)) {
			db.remove(id);
			System.out.println("employee data deleted successfully");
		}
		else {try {
			String message="employee record is not present";
			throw new EmployeeNotFoundException(message);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}} 
	}

	@Override
	public void removeAllEmployee() {
		if(!db.isEmpty()) {
			db.clear();
			System.out.println("employee record deleted ");
		}
		else {try {
			String message="employee record is not present";
			throw new EmployeeNotFoundException(message);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}} 
		
	}

	@Override
	public void updateEmployee() {
		System.out.println("enter employee id");
		String id=sc.next().toUpperCase();
		if(db.containsKey(id)) {
			
			System.out.println("1.to updated age\n2.to update name\n3.to update salary");
		    System.out.println("enetr choice");
		    int choice=sc.nextInt();
		    switch(choice) {
		    case 1:System.out.println("enter the age");
		           db.get(id).setAge(sc.nextInt());
		           System.out.println("age updated successfully");
		           break;
		    case 2:System.out.println("enter the new name");
		           db.get(id).setName(sc.next());
		           System.out.println("name updated successfully");
		           break;
		    case 3:System.out.println("enter the salary ");
		           db.get(id).setSalary(sc.nextDouble());
		           System.out.println("salary updated successfully");
		           break;
		    
		    default:
		    	try {
		    		String message="invalid choice ,kindely enter valid choice";
		    		throw new InvalidChoiceException(message);
		    	}catch(Exception e) {
		    		
		    		System.out.println(e.getMessage());	    		
		    	}
		           
		    }
			}}
		

	@Override
	public void countEmployee() {
		System.out.println("number of employee is"+db.size());
		
	}

	@Override
	public void sortEmployee() {
		if(!db.isEmpty()) {
			
			Set<String> keys=db.keySet();
			
			List<Employee> list=new ArrayList<Employee>();
			
			
			for(String key:keys) {
				list.add(db.get(key));
					
				}
			System.out.println("1.Sort Employee By id\n2.sor Employee by age");
			System.out.println("3.Sort Employee By name\n4.sor Employee by salary");
			System.out.println("enter choice");
			int choice=sc.nextInt();
			switch(choice) {

			case 1:
				Collections.sort(list,new SortEmployeeById());
				display(list);
				break;
			case 2:
				Collections.sort(list,new SortEmployeeByAge());
				display(list);
				break;
			case 3:
				Collections.sort(list,new SortEmployeeByName());
				display(list);
				break;
			case 4:
				Collections.sort(list,new SortEmployeeBySalary());
				display(list);
				break;
				default:try {
					String message="invalid choice dear,kindly enter valid choice kid";
					throw new InvalidChoiceException(message);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			
			}
		     else {
		    	 try{String message="No sufficient student records to sort";
		 		throw new EmployeeNotFoundException(message);}
		 		catch(Exception e) {
		 			System.out.println(e.getMessage());
		 		}
			 
			}
			
			}
			private static void display(List<Employee> list) {
				for(Employee s:list) {
					System.out.println(s);
				}
			}


	@Override
	public void findEmployeeWithHighestSalary() {
		Set<String> keys=db.keySet();
		
		List<Employee> list=new ArrayList<Employee>();
		
		
		
		for(String key:keys) {
			list.add(db.get(key));
		}
           /*double max=list.get(0).getSalary();
		
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getSalary()>max) {
				max=list.get(i).getSalary();
			}
		}
		System.out.println("maximum salary is"+max);*/
		Collections.sort(list,new SortEmployeeBySalary());
		System.out.println("Employee with highest salary");
		System.out.println(list.get(list.size()-1));
		
	}

	@Override
	public void findEmployeeWithLowestSalary() {
		Set<String> keys=db.keySet();
		
		List<Employee> list=new ArrayList<Employee>();
		
		
		
		for(String key:keys) {
			list.add(db.get(key));
		}
		
		Collections.sort(list,new SortEmployeeBySalary());
		System.out.println("Employee with Lowest salary");
		System.out.println(list.get(0));
		
	}

	

}
