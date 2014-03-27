package httpDemo;

import tw.edu.fcu.iecs.selab.apiDemo.apiClient.ApiClient;

public class ClientExample {
	public static void main(String[] args) {
		
		
		ApiClient apiClient = new ApiClient();
		
		System.out.println(apiClient.getData("getDate", null));
		String[] commandArgs = {"a=1","b=2","c=3"};
		System.out.println(apiClient.getData("sumNumber", commandArgs));
		
	}
}
