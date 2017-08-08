package com.teradata.rtim.json;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonDecoder {
	public static void main(String[] args) throws IOException {
		JsonDecoder decoder = new JsonDecoder();
		final Path path = Paths.get(args[0]);
		if (Files.notExists(path)) {
			throw new IllegalArgumentException("file " + path.toString() + "does not exist");
		}
		final String jsonString = decoder.loadFile(path);
		final JSONObject jsonObject = decoder.getJSONObject(jsonString);
//		final Scanner scanner = new Scanner(jsonString).useDelimiter("\\n");
//		while(scanner.hasNext()) {
//
//		}


	}

	private String loadFile(final Path path) throws IOException {
		final FileInputStream fis = new FileInputStream(path.toFile());
		final BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
		final StringBuilder jsonString = new StringBuilder();
		String line;
		while((line = reader.readLine()) != null) {
			jsonString.append(line);
		}
		return jsonString.toString();
	}

	private JSONObject getJSONObject(final String jsonString) {
		return new JSONObject(jsonString);
	}


}
