package com.dacnx.www.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dacnx.www.entry.Photo;
import com.opensymphony.xwork2.ActionSupport;
  
/**
 * 负责首页中图片数据的展示
 * @author Administrator
 */
public class PhotoAction extends ActionSupport {  
	private static final Logger logger = LoggerFactory.getLogger(PhotoAction.class);
    /**
     * 首页展示单独对象
     */
    private Photo photo;
    
    /**
     * 图片类型
     * 0:滚动图片类型
     * 1:产品图片类型
     */
    private String photoType;
    
    /**
     * 存储图片的路径（临时）
     */
    public static String photoPuth = "C:\\impageManage\\";
    
    /**
     * 产品图片的路径(临时)
     */
    public static String productPhotoPath = "C:\\impageManage\\product\\";
    
    @Override
    public String execute() throws Exception {
    	return SUCCESS;
    }
    
    public synchronized String showPhoto()  {
    	synchronized (this.photo) {
    		try {
    			String photoPath = "";
    			if( "0".equals(photoType) ) {
    				//展示滚动图片
    				photoPath = photoPuth + this.photo.getId() + ".jpg";
    			}else if( "1".equals(photoType) ) {
    				//展示产品图片
    				photoPath = productPhotoPath + this.photo.getId();
    			}
    	        loadPhotoStream(photoPath);
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
		}
    	return null;
    }

	private void loadPhotoStream(String photoPath) throws IOException,
			FileNotFoundException {
		HttpServletResponse response = ServletActionContext.getResponse();
		ServletOutputStream out = response.getOutputStream();
		InputStream is = new FileInputStream(new File(photoPath));
		int b = 0;
		byte[] bytes = new byte[0xffff];
		while ((b = is.read(bytes, 0, 0xffff)) > 0) {
			out.write(bytes, 0, b);
		}
		is.close();
		out.flush();
	}
    
	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public String getPhotoType() {
		return photoType;
	}

	public void setPhotoType(String photoType) {
		this.photoType = photoType;
	}
}