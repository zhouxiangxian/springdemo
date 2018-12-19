package cn.xiaoxian.demo;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class ResourceDemo2 {
	public static void main(String[] args) throws IOException {
		String filePath="F:"+File.separator+"MLDN学习笔记"+File.separator+"Java工作总结"+File.separator+"Java数据结构二叉树"+File.separator+"BinaryTree.java";
        File file=new File(filePath);
		Resource resource = new FileSystemResource(file);
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
