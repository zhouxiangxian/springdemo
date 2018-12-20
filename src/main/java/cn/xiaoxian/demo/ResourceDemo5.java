package cn.xiaoxian.demo;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class ResourceDemo5 {
	public static void main(String[] args) throws IOException {
		String path="classpath:applicationContext.xml";
        ResourceLoader loader=new DefaultResourceLoader();
        Resource resource = loader.getResource(path);
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
