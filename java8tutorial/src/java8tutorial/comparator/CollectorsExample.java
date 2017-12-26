package java8tutorial.comparator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsExample {
	public static void main(String[] args) {
		List<String> lst = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
		Map<String, Long> collect = lst.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(collect);
	}
}
