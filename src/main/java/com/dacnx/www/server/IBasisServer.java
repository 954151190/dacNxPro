package com.dacnx.www.server;

import java.util.Map;

import com.dacnx.www.entry.Basis;

public interface IBasisServer {
	
	/**
	 * ��ȡ������Ϣ
	 */
	public Basis selectEntry( Map<String,Object> entryMap ) ;
}