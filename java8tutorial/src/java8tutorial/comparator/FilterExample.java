package java8tutorial.comparator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterExample {
	public static void main(String[] args) {
		List<Person2> lstPerson = new ArrayList();
		lstPerson.add(new Person2("A", 1));
		lstPerson.add(new Person2("C", 3));
		lstPerson.add(new Person2("B", 2));
		lstPerson.add(new Person2("A", 2));
		lstPerson.forEach(x -> System.out.println(x));
//		List<Person2> collectedPerson = lstPerson.stream().filter(x -> !x.name.startsWith("A"))
//				.collect(Collectors.toList());
		List<Person2> collectedPerson = lstPerson.stream().filter(getByName(null, "A")).collect(Collectors.toList());
		collectedPerson.forEach(x -> System.out.println("collectedPersons. " + x));

	}

	public static Predicate<Person2> getByName(Collection c, String name) {
		Predicate<Person2> filterByName = x -> x.name.equals(name);
//		c.stream().
		return filterByName;
	}
}

class Person2 {
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

	Person2(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
