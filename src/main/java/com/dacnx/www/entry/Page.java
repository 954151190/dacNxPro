package com.dacnx.www.entry;

/**
 * ��ҳ����
 * @author Administrator
 *
 */
public class Page {
	
	public Page() {
		this.number = 1;
		this.count = 20;
	}
	
	public Page( int number , int count ) {
		this.number = 1;
		this.count = 20;
	}
	
	/**
	 * ҳ��
	 */
	private int number;
	
	/**
	 * ÿҳ��ʾ����
	 */
	private int count;

	/**
	 * ��Ϣ����
	 */
	private long allCount;
	
	/**
	 * ��ҳ��ҳ��
	 * @return
	 */
	private long allPage;
	
	public long getAllCount() {
		return allCount;
	}

	public void setAllCount(long allCount) {
		this.allCount = allCount;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public long getAllPage() {
		return allPage;
	}

	public void setAllPage(long allPage) {
		this.allPage = allPage;
	}
}