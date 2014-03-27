package httpDemo;

import httpClient.HTTPClient;

public class ClientDemo {
	public static void main(String[] args) {
		
		
		HTTPClient apiClient = new HTTPClient();
		
		System.out.println(apiClient.getData("getDate", null));
		String[] commandArgs = {"a=1","b=2","c=3"};
		System.out.println(apiClient.getData("sumNumber", commandArgs));
		
	}
}
