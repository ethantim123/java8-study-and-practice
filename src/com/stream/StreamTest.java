package com.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamTest {

	public static void main(String[] args) {
		System.out.println("�ϥ� Java 8: ");

		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		System.out.println("��C: " + strings);

		long count = strings.stream().filter(string -> string.isEmpty()).count();
		System.out.println("�Ŧr��ƶq��: " + count);

		count = strings.stream().filter(string -> string.length() == 3).count();
		System.out.println("�r����׬� 3 ���ƶq��: " + count);

		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		System.out.println("�z��᪺��C: " + filtered);

		String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("�X�֦r��: " + mergedString);

		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		System.out.println("��C: " + numbers);

		List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
		System.out.println("Squares List: " + squaresList);

		List<Integer> integers = Arrays.asList(1, 2, 13, 4, 15, 6, 17, 8, 19);
		System.out.println("��C: " + integers);

		IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();

		System.out.println("��C���̤j���� : " + stats.getMax());
		System.out.println("��C���̤p���� : " + stats.getMin());
		System.out.println("�Ҧ��Ƥ��M : " + stats.getSum());
		System.out.println("������ : " + stats.getAverage());
		System.out.println("�ü�: ");

		Random random = new Random();

		random.ints(0, 20).limit(10).sorted().forEach(System.out::println);

		// �æ�B�z
		count = strings.parallelStream().filter(string -> string.isEmpty()).count();
		System.out.println("�Ŧr�ꪺ�ƶq��: " + count);
	}

}
