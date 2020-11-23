package com.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamTest {

	public static void main(String[] args) {
		System.out.println("ㄏノ Java 8: ");

		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		System.out.println("﹃: " + strings);

		long count = strings.stream().filter(string -> string.isEmpty()).count();
		System.out.println("﹃计秖: " + count);

		count = strings.stream().filter(string -> string.length() == 3).count();
		System.out.println("﹃ 3 计秖: " + count);

		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		System.out.println("縵匡﹃: " + filtered);

		String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("ㄖ﹃: " + mergedString);

		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		System.out.println("﹃: " + numbers);

		List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
		System.out.println("Squares List: " + squaresList);

		List<Integer> integers = Arrays.asList(1, 2, 13, 4, 15, 6, 17, 8, 19);
		System.out.println("﹃: " + integers);

		IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();

		System.out.println("﹃い程计 : " + stats.getMax());
		System.out.println("﹃い程计 : " + stats.getMin());
		System.out.println("┮Τ计ぇ㎝ : " + stats.getSum());
		System.out.println("キА计 : " + stats.getAverage());
		System.out.println("睹计: ");

		Random random = new Random();

		random.ints(0, 20).limit(10).sorted().forEach(System.out::println);

		// ︽矪瞶
		count = strings.parallelStream().filter(string -> string.isEmpty()).count();
		System.out.println("﹃计秖: " + count);
	}

}
