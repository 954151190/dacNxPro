package com.dacnx.www.server;

import java.util.List;
import java.util.Map;

import com.dacnx.www.entry.Product;

public interface IProductServer {
	/**
	 * 查找产品根据ID
	 * @param bulletinMap
	 * @return
	 */
	public Product selectEntry4ID( Map<String,Object> contextMap ) throws Exception; 
	
	/**
	 * 分页查询产品信息集合
	 * @param bulletinMap
	 * @return
	 */
	public List<Product> selectEntryList4Page( Map<String,Object> contextMap );
	
	/**
	 * 查询信息个数
	 * @param contextMap
	 */
	public Long countEntry( Map<String,Object> contextMap );
}
