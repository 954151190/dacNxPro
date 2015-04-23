package com.dacnx.www.server;

import java.util.Map;

import com.dacnx.www.entry.Basis;

public interface IBasisServer {
	
	/**
	 * 获取基础信息
	 */
	public Basis selectEntry( Map<String,Object> entryMap ) ;
}