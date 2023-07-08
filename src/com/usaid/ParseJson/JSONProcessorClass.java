package com.usaid.ParseJson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONProcessorClass {

	public static void main(String[] args) {
		try {
			String inputPath = "C:\\Users\\Mohammad Usaid\\Desktop\\";

			String jsonStr = new String(Files.readAllBytes(Paths.get(inputPath + "input.json")));
			JSONArray jsonAry = null;
			try {
				jsonAry = new JSONArray(jsonStr);
			} catch (JSONException e) {

				e.printStackTrace();
			}

			List<String> opList = new ArrayList<>();
			for (int i = 0; i < jsonAry.length(); i++) {
				JSONObject jsonObj = null;
				try {
					jsonObj = jsonAry.getJSONObject(i);
				} catch (JSONException e) {

					e.printStackTrace();
				}
				String type = jsonObj.optString("type");
				String input = jsonObj.optString("input");
				String output = processInput(type, input);
				opList.add(output);
			}

			JSONArray outputJsonArray = new JSONArray(opList);
			Files.write(Paths.get(inputPath + "output.json"), outputJsonArray.toString().getBytes());
			System.out.println("Output written to " + inputPath + "output.json");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String processInput(String type, String input) {
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