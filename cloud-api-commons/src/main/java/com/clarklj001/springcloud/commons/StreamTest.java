package com.clarklj001.springcloud.commons;

import java.util.stream.LongStream;

public class StreamTest {
	public static void main(String[] args) {
		long reduce = LongStream.rangeClosed(0L, 10_000_0000L).parallel().reduce(0, Long::sum);
		System.out.println(reduce);
	}

}
