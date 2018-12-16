package cn.xiaoxian.filecopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {
	public static void main(String[] args) {
		File inFile=new File("F:\\tmp\\用户信息.xls");
		File outFile=new File("F:\\tmp\\copyFile.xls");
		copyFile(inFile,outFile);
	}

	public static void copyFile(File inFile, File outFile) {
		if (!outFile.getParentFile().exists()) {
			outFile.getParentFile().mkdirs();// 创建目标文件目录
		}

		// 实现文件得拷贝
		InputStream input;
		OutputStream output;
		try {
			input = new FileInputStream(inFile);
			output = new FileOutputStream(outFile);
			int temp = 0;
			byte data[] = new byte[1024];
			while ((temp = input.read(data)) != -1) {
				output.write(data, 0, temp);
			}
			input.close();
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
