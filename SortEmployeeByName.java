package customsorting;

import java.util.Comparator;

import edbms.Employee;

public class SortEmployeeByName implements Comparator<Employee> {

	@Override
	public int compare(Employee x, Employee y) {
		String a=x.getName();
		String b=y.getName();
		
		return a.compareTo(b);
	}

}
