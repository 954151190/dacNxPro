package com.dacnx.www.dao.db.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.dacnx.www.entry.Basis;


/**
 * ��������ת��
 * �������ݿ�ResultSet����ת��ΪBasis����
 * @author Administrator
 */
public class BasisMapper implements RowMapper{
	private static final Logger logger = LoggerFactory.getLogger(BasisMapper.class);
	public BasisMapper() {
	}
	
	public Basis mapRow(ResultSet rs, int rowNum) throws SQLException {
		Basis basis = new Basis();
		basis.setPhone(rs.getString("PHOTO"));
		basis.setAddress(rs.getString("ADDRESS"));
		basis.setQq(rs.getString("QQ"));
		basis.setWx(rs.getString("WX"));
		return basis;
	}
}
