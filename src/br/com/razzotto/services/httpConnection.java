package br.com.razzotto.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class httpConnection {
	
	private static final String Get_URL= "https://opensky-network.org/api/flights/all?begin=1617660000&end=1617663000";

	public static void restService() throws IOException
	{
		sendGet();
	}
	public static void sendGet() throws IOException {
		try {
			URL objetoURL = new URL(Get_URL);
			HttpsURLConnection conexao = (HttpsURLConnection) objetoURL.openConnection();
			conexao.setRequestMethod("GET");
			BufferedReader in = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
			String inputLine;
			while ((inputLine = in .readLine ())!= null ) { 
				System.out.println(inputLine); 
			}
			in.close();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	
	
}
