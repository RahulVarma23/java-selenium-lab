package java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StreamOperations {

	public static void main(String[] args) {
		Integer [] arr = {10,15,8,49,25,98,32,15,8};
		List<Integer> myList = Arrays.asList(arr);


		
		//find out all the even numbers exist in the list 
		myList.stream().filter(n->n%2==0).forEach(System.out::println);

		System.out.println("------------------------------");
	    //find out all the numbers starting with 1
		myList.stream().map(n->String.valueOf(n)).filter(s->s.startsWith("1")).forEach(System.out::println);
		
		System.out.println("------------------------------");
		
		//find duplicate elements in a given integers list
		Set<Integer> set = new HashSet<>();
		myList.stream().filter(n-> !set.add(n)).forEach(System.out::println);
		
		System.out.println("------------------------------");
		//find the first element of the list 
		
		myList.stream().findFirst().ifPresent(System.out::println);
		
		System.out.println("------------------------------");
		//find the maximum value element present 
		int max = myList.stream().max(Integer::compare).get();
		System.out.println("max ele -> "+max);
		
		System.out.println("------------------------------");
		//sort all the values present in it using Stream
		myList.stream().sorted().forEach(System.out::println);
		
		System.out.println("------------------------------");
		//sort all the values present in it in reverse order using Stream
		myList.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
	}
}
