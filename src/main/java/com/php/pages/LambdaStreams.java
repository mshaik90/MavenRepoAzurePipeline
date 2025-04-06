package com.php.pages;

import java.util.Arrays;
import java.util.List;

public class LambdaStreams {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		
		List<String> names=Arrays.asList("Alice","mohsin","mahesh","bob","Saba","Sana");
		names.stream().filter(name -> name.startsWith("m")).sorted().forEach(System.out::println);
		
		names.forEach(name -> System.out.println(name));
		
	}

}
