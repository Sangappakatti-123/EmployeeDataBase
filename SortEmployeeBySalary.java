package customsorting;

import java.util.Comparator;

import edbms.Employee;

public class SortEmployeeBySalary implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
	     Double a=o1.getSalary();
	     Double b=o2.getSalary();
		return a.compareTo(b);
	}

}
