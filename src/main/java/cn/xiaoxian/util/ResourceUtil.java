package cn.xiaoxian.util;

import java.io.IOException;
import java.util.Scanner;

import org.springframework.core.io.Resource;

public class ResourceUtil {
	private Resource src;
	public void setSrc(Resource src) {
		this.src=src;
	}
	
	public void print() throws IOException {
		if(src.exists()) {
			Scanner scanner=new Scanner(src.getInputStream());
			scanner.useDelimiter(" ");
			while(scanner.hasNext()) {
				System.out.println(scanner.nextLine());
			}
			scanner.close();
		}
	}

}
