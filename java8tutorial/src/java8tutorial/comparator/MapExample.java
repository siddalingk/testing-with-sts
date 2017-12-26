package java8tutorial.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapExample {
	public static void main(String[] args) {
		List<String> alpha = Arrays.asList("a", "b", "c", "d");
		alpha.stream().map(x -> x.toUpperCase()).forEach(System.out::println);
		List<Integer> numba = Arrays.asList(1, 2, 3, 4);
		numba.stream().map(x -> x + 2).collect(Collectors.toList()).forEach(System.out::println);

		List<Person3> lstPerson = new ArrayList();
		lstPerson.add(new Person3("A", 1));
		lstPerson.add(new Person3("C", 3));
		lstPerson.add(new Person3("B", 2));
		lstPerson.add(new Person3("A", 2));
		lstPerson.stream().map(x -> (x.name.equals("A")) ? x : null).filter(x -> x != null)
				.forEach(System.out::println);
	}
}

class Person3 {
	String name;
	int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	Person3(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
