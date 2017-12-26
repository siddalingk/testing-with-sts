package java8tutorial.comparator;

import java.util.ArrayList;
import java.util.Comparator;

public class ComparatorEg {

	public static void main(String[] args) {
		ArrayList<Person> arl = new ArrayList();
		arl.add(new Person("A", 1));
		arl.add(new Person("C", 3));
		arl.add(new Person("B", 2));
		arl.add(new Person("A", 2));
		// arl.sort((x, y) -> x.name.compareTo(y.name));
		// arl.forEach(x -> System.out.println(x));

		Comparator<Person> ageComp = (x, y) -> ((x.age - y.age == 0) ? (x.name.compareTo(y.name)) : x.age - y.age);
		Comparator<Person> age2Comp = (x, y) -> ((x.name.compareTo(y.name) == 0) ? (x.age - y.age) : x.name.compareTo(y.name));
		Comparator<Person> nameComp = (x, y) -> x.name.compareTo(y.name);
		arl.sort(ageComp);
//		arl.forEach(x -> System.out.println(x));
		arl.forEach(System.out::println);
	}

}

class Person {
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

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
