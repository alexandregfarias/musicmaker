package com.br.application.external_api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class SunoApiService {

	static String apiUrl = "http://localhost:3000/api/generate";
	static int codigoSucesso = 200;

	public static void generateMusic(String textPrompt, boolean makeInstrumental) {

		try {
			@SuppressWarnings("deprecation")
			URL url = new URL(apiUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json; utf-8");
			conn.setRequestProperty("Accept", "application/json");
			conn.setDoOutput(true);

			String jsonInputString = "{"
					+ "\"prompt\": \"" + textPrompt + "\","
					+ "\"make_instrumental\": " + makeInstrumental + ","
					+ "\"wait_audio\": true"
					+ "}";

			try (OutputStream os = conn.getOutputStream()) {
				byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
				os.write(input, 0, input.length);
			}

			// Verificando o código de resposta
			int responseCode = conn.getResponseCode();

			if (responseCode == codigoSucesso) {
				System.out.println("Música gerada com sucesso!");
				BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String inputLine;
				StringBuilder content = new StringBuilder();

				while ((inputLine = in.readLine()) != null) {
					content.append(inputLine);
				}

				in.close();
				System.out.println(content.toString());

				// Aqui você pode processar a resposta da API, se necessário
			} else {
				System.out.println("Erro ao gerar música: Código de resposta " + responseCode);
			}

			conn.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}