package cn.xiaoxian.demo;

import java.io.IOException;
import java.util.Scanner;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;

public class ResourceDemo {
	public static void main(String[] args) throws IOException {
		String info="www.xiaoxian.com www.test.com";
		Resource resource = new ByteArrayResource(info.getBytes());
		if(resource.exists()) {
			Scanner scanner=new Scanner(resource.getInputStream());
			scanner.useDelimiter(" ");
			while(scanner.hasNext()) {
				System.out.println(scanner.nextLine());
			}
			scanner.close();
		}
	}

}
