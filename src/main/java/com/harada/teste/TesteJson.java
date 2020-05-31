/**
 * 
 */
package com.harada.teste;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * @author Daniel
 *
 */
public class TesteJson {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String authToken = getAuthenticationToken();
			testAuthenticatedJson(authToken);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void testAuthenticatedJson(String authToken)
			throws MalformedURLException, IOException, ProtocolException, UnsupportedEncodingException {
		URL url = new URL ("http://localhost/clientes/1");
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json; utf-8");
		con.setRequestProperty("Authorization",authToken);
		con.setDoOutput(true);
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
			System.out.println(response.toString());

		}
	}

	private static String getAuthenticationToken()
			throws MalformedURLException, IOException, ProtocolException, UnsupportedEncodingException {
		URL url = new URL ("http://localhost/login");
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json; utf-8");			
		con.setDoOutput(true);
		
		String jsonInputString = "{\r\n" + 
				"	\"email\":\"jao@teste.com\",\r\n" + 
				"	\"senha\":\"segredo\"\r\n" + 
				"}";
		try(OutputStream os = con.getOutputStream()) {
		    byte[] input = jsonInputString.getBytes("utf-8");
		    os.write(input, 0, input.length);           
		}
		return con.getHeaderField("Authorization");
	}

}
