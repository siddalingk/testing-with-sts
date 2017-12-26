package java8tutorial.comparator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ForEachListAndMap {
	public static void main(String[] args) {
		HashMap hm = new HashMap();
		hm.put("a", 1);
		hm.put("c", 3);
		hm.put("b", 2);
		hm.forEach((k, v) -> System.out.println("key : " + k + ", value : " + v));
		List list = new ArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.forEach(System.out::println);
	}
}
