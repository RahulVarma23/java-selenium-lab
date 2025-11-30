package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingObjectOfUserDefined {

	String firstName;
	String lastName;
	int salary;

	public SortingObjectOfUserDefined(String firstName, String lastName, int salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	public String getFirstName() {
		return firstName;
	}
	
	@Override
	public String toString() {
		return firstName+" "+lastName+"->"+salary;
	}

	public static void main(String[] args) {
		SortingObjectOfUserDefined s1 = new SortingObjectOfUserDefined("Rahul", "Varma", 3000);
		SortingObjectOfUserDefined s2 = new SortingObjectOfUserDefined("Ankita", "Sinha", 2000);
		SortingObjectOfUserDefined s3 = new SortingObjectOfUserDefined("Rohit", "Ainha", 1000);
		SortingObjectOfUserDefined s4 = new SortingObjectOfUserDefined("Ashish", "Cinha", 5000);
		List<SortingObjectOfUserDefined> list = new ArrayList<SortingObjectOfUserDefined>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
//		list.stream()
//				.sorted((I1, I2) -> I1.getFirstName().compareTo(I2.getFirstName())).forEach(System.out::println);

		
		list.sort(Comparator.comparing(d -> d.lastName));
		System.out.println(list);

		System.out.println("==============================");

        list.stream().sorted((o1, o2) -> (o1.salary - o2.salary)).forEach(System.out::println);;
				
				
		System.out.println("==============================");
	
	    list.stream().sorted((o1,o2)->o1.lastName.compareTo(o2.lastName)).forEach(System.out::println);

//		for (SortingObjectOfUserDefined s : sortedSalaryList) {
//			System.out.println(s.firstName + " " + s.lastName + " " + s.salary);
//		}
	}
}
