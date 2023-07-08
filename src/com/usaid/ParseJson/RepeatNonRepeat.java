package com.usaid.ParseJson;

import java.util.HashMap;
import java.util.Map;

public class RepeatNonRepeat {
	
	
	public static String processInput(String type, String input) {
		if (type.equals("first non repeating")) {
			return findFirstNonRepeating(input);
		} else if (type.equals("first repeating")) {
			return findFirstRepeating(input);
		}
		return "";
	}

	private static String findFirstNonRepeating(String input) {
		Map<Character, Integer> countMap = new HashMap<>();

		for (char ch : input.toCharArray()) {
			countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
		}

		for (char ch : input.toCharArray()) {
			if (countMap.get(ch) == 1) {
				return String.valueOf(ch);
			}
		}

		return "-";
	}

	private static String findFirstRepeating(String input) {
		Map<Character, Integer> countMap = new HashMap<>();

		for (char ch : input.toCharArray()) {
			countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
			if (countMap.get(ch) == 2) {
				return String.valueOf(ch);
			}
		}

		return "-";
	}

}
