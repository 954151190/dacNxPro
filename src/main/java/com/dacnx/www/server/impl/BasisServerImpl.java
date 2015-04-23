package com.dacnx.www.server.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dacnx.www.entry.Basis;
import com.dacnx.www.server.IBasisServer;
import com.dacnx.www.util.BuildSQLUtil;
import com.dacnx.www.util.QueryHelper;
import com.dacnx.www.util.StaticVariable;

public class BasisServerImpl implements IBasisServer {
	private static final Logger logger = LoggerFactory.getLogger(BasisServerImpl.class);
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return this .jdbcTemplate;
	}
	
	public void setJdbcTemplate( JdbcTemplate jdbcTemplate ) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public BasisServerImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public Basis selectEntry(Map<String, Object> entryMap) {
		try{
			String selectsql = BuildSQLUtil.buildSelectAllFieldsWithoutConditionSQL(StaticVariable.TABLE_NAME_BASIS);
			Connection conn = jdbcTemplate.getDataSource().getConnection();
			Map<String,Object> tempMap = QueryHelper.selectSqlForMap(conn, selectsql);
			return Basis.Map2Basis(tempMap);
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error("“Ï≥£–≈œ¢:{}",ex);
			return null;
		}
	}
}