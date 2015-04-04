package com.dacnx.www.server.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dacnx.www.dao.db.rowMapper.NewsRowMapper;
import com.dacnx.www.entry.News;
import com.dacnx.www.entry.Page;
import com.dacnx.www.server.INewsServer;
import com.dacnx.www.util.BuildSQLUtil;
import com.dacnx.www.util.StaticVariable;

public class NewsServerImpl implements INewsServer{
	private static final Logger logger = LoggerFactory.getLogger(NewsServerImpl.class);
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return this .jdbcTemplate;
	}
	
	public void setJdbcTemplate( JdbcTemplate jdbcTemplate ) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public News selectEntry4ID(Map<String, Object> contextMap) throws Exception{
		News news = (News)contextMap.get(StaticVariable.MS_NEWS_OBJECT);
		List<Object> fields = new ArrayList<Object>();
		List<Object> values = new ArrayList<Object>();
		fields.add("ID");
		values.add(news.getId());
		String selectSQL = BuildSQLUtil.buildSelectAllFieldsWithConditionSQL(StaticVariable.TABLE_NAME_NEWS, fields.toArray());
		News retNews = (News)jdbcTemplate.queryForObject(selectSQL, values.toArray(), new NewsRowMapper());
		return retNews;
	}
	
	public List<News> selectEntryList4Page(Map<String, Object> contextMap) {
		//获取分页信息
		Page page = (Page)contextMap.get(StaticVariable.PAGE_NEWS);
		//计算最大序号
		int numberMax = page.getCount() * page.getNumber();
		//计算最小序号
		int numberMin = (page.getNumber()-1) * page.getCount();
		String sql = "SELECT * FROM ( SELECT A.*, ROWNUM RN FROM (SELECT * FROM "+StaticVariable.TABLE_NAME_NEWS+") A WHERE ROWNUM <= "+numberMax+" ) WHERE RN > "+numberMin+"";
		List<News> newsList = jdbcTemplate.query(sql , new NewsRowMapper());
		return newsList;
	}
	
	/**
	 * 查询信息个数
	 * @param contextMap
	 */
	public Long countEntry( Map<String,Object> contextMap ){
		String countStr = BuildSQLUtil.buildCountAllSQL( StaticVariable.TABLE_NAME_PHOTO );
		Long l = jdbcTemplate.queryForLong(countStr);
		return l;
	}
}