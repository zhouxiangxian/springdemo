package cn.xiaoxian.demo;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class TestJersey {
	public static void main(String[] args) {
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8080/springdemo/rest/member/list");
		System.out.println(resource.get(String.class));
	}

}
