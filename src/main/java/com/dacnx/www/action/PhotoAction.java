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
 * ������ҳ��ͼƬ���ݵ�չʾ
 * @author Administrator
 */
public class PhotoAction extends ActionSupport {  
	private static final Logger logger = LoggerFactory.getLogger(PhotoAction.class);
    /**
     * ��ҳչʾ��������
     */
    private Photo photo;
    
    /**
     * ͼƬ����
     * 0:����ͼƬ����
     * 1:��ƷͼƬ����
     */
    private String photoType;
    
    /**
     * �洢ͼƬ��·������ʱ��
     */
    public static String photoPuth = "C:\\impageManage\\";
    
    /**
     * ��ƷͼƬ��·��(��ʱ)
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
    				//չʾ����ͼƬ
    				photoPath = photoPuth + this.photo.getId() + ".jpg";
    			}else if( "1".equals(photoType) ) {
    				//չʾ��ƷͼƬ
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