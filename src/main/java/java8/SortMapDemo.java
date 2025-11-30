package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortMapDemo {

	public static void main(String[] args) {
		Map <Integer, String > map = new HashMap<Integer, String>();
		map.put(6, "a");
		map.put(2, "e");
		map.put(3, "c");
		map.put(4, "b");
		
		List<Entry<Integer, String>> entries = new ArrayList<>(map.entrySet());
		Collections.sort(entries,(o1,o2)-> o1.getKey()-o2.getKey());

        entries.sort((a,b)-> b.getValue().compareTo(a.getValue()));
        System.out.println(entries);


//		for(Entry<Integer, String> entry : entries) {
//			System.out.println(entry.getKey()+"->"+entry.getValue());
//		}
//		
//		Collections.sort(entries,(o1,o2)->o1.getValue().compareTo(o2.getValue()));
//		
//		entries.forEach(System.out::println);
		
//		System.out.println("=====================");
//		
		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
				
		System.out.println("=====================");
		
		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
	}
}
