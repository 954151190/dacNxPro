package com.dacnx.www.util;

/**
 * �����ļ�applicationContext_config.xml��Ӧ����
 * @author Administrator
 */
public class Config {
	/**
	 * ��ҳ����ͼƬ�洢·��
	 */
	public static String INDEX_PHOTO_PATH = "";
	/**
	 * ��Ʒ����ͼ�洢·��
	 */
	public static String PRODUCT_PHOTO_PATH = "";
	
	/**
	 * ��Ʒ����ͼĬ��չʾͼƬ�Ĵ洢·��(��ʱ)
	 */
	public static String PRODUCT_PHOTO_PATH_DEF  = "";
	
	public String getPRODUCT_PHOTO_PATH_DEF() {
		return PRODUCT_PHOTO_PATH_DEF;
	}
	public void setPRODUCT_PHOTO_PATH_DEF(String pRODUCT_PHOTO_PATH_DEF) {
		PRODUCT_PHOTO_PATH_DEF = pRODUCT_PHOTO_PATH_DEF;
	}
	public String getINDEX_PHOTO_PATH() {
		return INDEX_PHOTO_PATH;
	}
	public void setINDEX_PHOTO_PATH(String iNDEX_PHOTO_PATH) {
		INDEX_PHOTO_PATH = iNDEX_PHOTO_PATH;
	}
	public String getPRODUCT_PHOTO_PATH() {
		return PRODUCT_PHOTO_PATH;
	}
	public void setPRODUCT_PHOTO_PATH(String pRODUCT_PHOTO_PATH) {
		PRODUCT_PHOTO_PATH = pRODUCT_PHOTO_PATH;
	}
}
