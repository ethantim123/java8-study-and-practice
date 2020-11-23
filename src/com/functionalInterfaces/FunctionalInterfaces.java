package com.functionalInterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
 * Java8 内置的核心函数式接口
 * 
 * Consumer<T> : 消费型接口
 * 		void accept(T t);
 * 
 * Supplier<T> : 供给型接口
 * 		T get(); 
 * 
 * Function<T, R> : 函数型接口
 * 		R apply(T t);
 * 
 * Predicate<T> : 断言型接口
 * 		boolean test(T t);
 * 
 */
public class FunctionalInterfaces {

	public static void main(String[] args) {

		// Predicate<T> 断言型接口：
		List<String> list = Arrays.asList("Hello", "tustman", "Lambda", "www", "ok");
		// 條件長度大於3
		List<String> strList = filterStr(list, (s) -> s.length() > 3);

		for (String str : strList) {
			System.out.println(str);
		}

		System.out.println("==========================");

		// Function<T, R> : 函数型接口
		// 放入trim
		String newStr = strHandler("\t\t\t 我大Java8威武   ", (str) -> str.trim());
		System.out.println(newStr);
		// 放入substring
		String subStr = strHandler("我大Java8威武", (str) -> str.substring(2, 5));
		System.out.println(subStr);

		System.out.println("==========================");

		// Supplier<T> 供给型接口 :
		List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));

		for (Integer num : numList) {
			System.out.println(num);
		}

		System.out.println("==========================");
		
		testRunnable(() -> System.out.println("Hello Lambda!"));
		
		System.out.println("==========================");

		// Consumer<T> 消费型接口 :
		happy(10000, (m) -> System.out.println("二哥每晚讀春秋" + m + "次"));

	}

	// 需求：滿足pre才放入list
	public static List<String> filterStr(List<String> list, Predicate<String> pre) {
		List<String> strList = new ArrayList<>();

		for (String str : list) {
			if (pre.test(str)) {
				strList.add(str);
			}
		}

		return strList;
	}

	// 需求：依照放入的function對字串進行不同事情
	public static String strHandler(String str, Function<String, String> fun) {
		return fun.apply(str);
	}

	// 需求：依照sup產出， 放入list
	public static List<Integer> getNumList(int num, Supplier<Integer> sup) {
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < num; i++) {
			Integer n = sup.get();
			list.add(n);
		}

		return list;
	}

	public static void testRunnable(Runnable runnable) {
		runnable.run();
	}

	// 需求：依照sup產出， 放入list
	public static void happy(int money, Consumer<Integer> con) {
		con.accept(money);
	}
}