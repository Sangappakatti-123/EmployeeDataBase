package edbms;

public class Employee {
   private String id;
   private int age;
   private String name;
   private double salary;
    static int count=100;
public Employee(int age, String name, double salary) {
	this.id="APPLE"+count;
	count++;
	this.age = age;
	this.name = name;
	this.salary = salary;
	
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}

public String toString() {
	 return "id: "+id+"age: "+age+"name: "+name+" salary: $"+salary;
 }
  
   
}
