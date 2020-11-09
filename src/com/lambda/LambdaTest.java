package com.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import com.tustman.java8.Employee;
import com.tustman.java8.FilterEmployeeForAge;
import com.tustman.java8.FilterEmployeeForSalary;
import com.tustman.java8.MyPredicate;

public class LambdaTest {

	public static void main(String[] args) {
		
		// 宣告完，再使用
		Comparator<String> com = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		};
		TreeSet<String> ts = new TreeSet<>(com);
		
		// 內部匿名類別
		TreeSet<String> ts2 = new TreeSet<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
			
		});
		
		// 使用lambda
		Comparator<String> comLambda = (x, y) -> Integer.compare(x.length(), y.length());
		TreeSet<String> tsLambda = new TreeSet<>(comLambda);
		
		
		List<Employee> emps = Arrays.asList(
				new Employee(101, "竈門炭治郎", 18, 9999.99), 
				new Employee(102, "我妻善逸", 59, 6666.66),
				new Employee(103, "嘴平伊之助", 28, 3333.33), 
				new Employee(104, "煉獄杏壽郎", 8, 7777.77),
				new Employee(105, "竈門禰豆子", 38, 5555.55));
		
		// 找出年紀比35小的
		//傳統方法
		List<Employee> list = filterEmployeeAge(emps);
		System.out.println("==========================");
		for (Employee employee : list) {
			System.out.println(employee);
		}
		
		// 使用策略模式加上匿名內部類
		List<Employee> listAnony = filterEmployee(emps, new MyPredicate<Employee>() {
			@Override
			public boolean test(Employee t) {
				return t.getAge() <= 35;
			}
		});
		System.out.println("==========================");
		for (Employee employee : listAnony) {
			System.out.println(employee);
		}
		
		// 使用lambda
		List<Employee> listLambda = filterEmployee(emps, (e) -> e.getAge() <= 35);
		System.out.println("==========================");
		listLambda.forEach(System.out::println);

		// 使用stream
		System.out.println("==========================");
		emps.stream()
		.filter((e) -> e.getAge() <= 35)
		.forEach(System.out::println);
		
	}
	
	// 傳統
	public static List<Employee> filterEmployeeAge(List<Employee> emps) {
		List<Employee> list = new ArrayList<>();
		for (Employee emp : emps) {
			if (emp.getAge() <= 35) {
				list.add(emp);
			}
		}
		return list;
	}
	
	// 策略模式
	public static List<Employee> filterEmployee(List<Employee> emps, MyPredicate<Employee> mp) {
		List<Employee> list = new ArrayList<>();
		
		for (Employee employee : emps) {
			if (mp.test(employee)) {
				list.add(employee);
			}
		}
		
		return list;
	}
	
}
