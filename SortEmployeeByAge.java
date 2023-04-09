package customsorting;

import java.util.Comparator;

import edbms.Employee;

public class SortEmployeeByAge implements Comparator<Employee>{

	@Override
	public int compare(Employee x, Employee y) {
      Integer a=x.getAge();//auto boxing
      Integer b=y.getAge();
		return a.compareTo(b);//return x.getAge()-y.getAge();
	}

}
