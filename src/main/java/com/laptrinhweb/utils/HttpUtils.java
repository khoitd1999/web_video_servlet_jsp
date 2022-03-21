package com.laptrinhweb.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtils {
	
	private String value;
	
	public HttpUtils(String value) {
		this.value = value;
	}
	
	public static HttpUtils StringJson(BufferedReader br) {
		StringBuilder sb = new StringBuilder("");
		try {
			String line;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return new HttpUtils(sb.toString());
	}
	public <T> T toModel(Class<T> tclass) {
		try {
			return new ObjectMapper().readValue(value, tclass);
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
