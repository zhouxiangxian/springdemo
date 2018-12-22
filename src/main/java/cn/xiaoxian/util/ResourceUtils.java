package cn.xiaoxian.util;

import java.io.IOException;
import java.util.Scanner;

import org.springframework.core.io.Resource;

public class ResourceUtils {
	private Resource src[];

	public void setSrc(Resource[] src) {
		this.src = src;
	}

	public void print() throws IOException {
		for (int x = 0; x < src.length; x++) {
			if (src[x].exists()) {
				System.out.println(src[x].getFilename());
				Scanner scanner = new Scanner(src[x].getInputStream());
				scanner.useDelimiter(" ");
				while (scanner.hasNext()) {
					System.out.println(scanner.nextLine());
				}
				scanner.close();
			}
			System.out.println("==============================");
		}
	}

}
