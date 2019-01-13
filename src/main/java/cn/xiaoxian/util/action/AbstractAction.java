package cn.xiaoxian.util.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.multipart.MultipartFile;

import cn.xiaoxian.util.file.UploadFileUtil;

public abstract class AbstractAction {
	@Resource
	private MessageSource msgSource;
	
	
	public String getValue(String msgKey,Object ...args) {
		return this.msgSource.getMessage(msgKey,args, Locale.getDefault());
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdf, true));
	}
	
	
	
	public String createFileName(MultipartFile photo) {
		if(photo.isEmpty()) {
			return "nophoto.png";
		}else {
			return UploadFileUtil.createFileName(photo.getContentType());
		}
	}
	
	
	public boolean saveFile(MultipartFile photo,String fileName,HttpServletRequest request) {
		String filepath=request.getServletContext().getRealPath(getFileUploadDir())+fileName;
		if(!photo.isEmpty()) {
			try {
				return UploadFileUtil.save(photo.getInputStream(), new File(filepath));
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}else {
			return false;
		}
	}
	
	public abstract String getFileUploadDir();

}
