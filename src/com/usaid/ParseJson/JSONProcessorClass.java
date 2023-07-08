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
				String output = RepeatNonRepeat.processInput(type, input);
				opList.add(output);
			}

			JSONArray outputJsonArray = new JSONArray(opList);
			Files.write(Paths.get(inputPath + "output.json"), outputJsonArray.toString().getBytes());
			System.out.println("Output written to " + inputPath + "output.json");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	

	
}