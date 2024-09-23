package com.br.application.util;

import java.io.BufferedReader;
import java.io.IOException;

public class JsonConverter {

	public static String converteJsonEmString(BufferedReader bufferedReader) throws IOException {
		StringBuilder jsonEmString = new StringBuilder();
		String resposta;
		while ((resposta = bufferedReader.readLine()) != null) {
			jsonEmString.append(resposta);
		}
		return jsonEmString.toString();
	}

}
