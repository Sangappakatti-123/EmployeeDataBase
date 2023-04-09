package customsorting;

import java.util.Comparator;

import edbms.Employee;

public class SortEmployeeById implements Comparator<Employee> {

	@Override
	public int compare(Employee x, Employee y) {
		String a=x.getId();
		String b=y.getId();
		return a.compareTo(b);
	}

}
