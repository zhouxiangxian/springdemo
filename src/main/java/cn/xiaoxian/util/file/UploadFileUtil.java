package cn.xiaoxian.util.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public class UploadFileUtil {
	
	
	public static String createFileName(String mime) {
		String fileName=UUID.randomUUID()+"."+mime.split("/")[1];
		return fileName;
	}

	public static boolean save(InputStream inputStream, File destFile) {
		boolean flag = false;
		if (!destFile.getParentFile().exists()) {
			destFile.getParentFile().mkdirs();
		}
		OutputStream output = null;
		try {
			output = new FileOutputStream(destFile);
			byte data[] = new byte[2048];
			int temp = 0;
			while ((temp = inputStream.read(data)) != -1) {
				output.write(data, 0, temp);
			}
			flag = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return flag;
	}

}
