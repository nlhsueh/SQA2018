package httpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;





public class ApiClient {


	private String apiURL = "http://localhost/apiDemo/api.php";
	
	public String getData(String command,String[] args)
	{
		String url = apiURL + "?command=" + command;
		String getData = "";
		if(args !=null)
		{
			for (String arg : args) {
				url = url + "&" + arg;
			}
		}
		System.out.println(url);
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
	 
		
		try {
			HttpResponse response = client.execute(request);

			BufferedReader rd = new BufferedReader
					  (new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				getData = getData + line ;
			} 
		} catch (IOException e) {
			e.printStackTrace();
			return "Error";
		}
		return getData;
	}
	
}
