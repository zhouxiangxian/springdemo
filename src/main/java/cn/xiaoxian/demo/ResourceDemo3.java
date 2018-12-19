package cn.xiaoxian.demo;

import java.io.IOException;
import java.util.Scanner;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ResourceDemo3 {
	public static void main(String[] args) throws IOException {
		Resource resource = new ClassPathResource("applicationContext.xml");
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
