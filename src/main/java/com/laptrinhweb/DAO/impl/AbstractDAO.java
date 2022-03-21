package com.laptrinhweb.DAO.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhweb.DAO.IGenericDAO;
import com.laptrinhweb.mapper.RowMapper;

public class AbstractDAO<T> implements IGenericDAO<T> {

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/video";
			String user="root";
			String password="1234";
			return DriverManager.getConnection(url, user, password);
		}
		catch(SQLException e) {
			return null;
		}
		catch(ClassNotFoundException e) {
			return null;
		}
	}
	
	public void setParameter(PreparedStatement ps,Object...parameter ) {
		try {
			for (int i = 0 ; i < parameter.length ; i++) {
				int index = i + 1;
				if(parameter[i] instanceof Long) {
					ps.setLong(index , (Long) parameter[i]);
				}
				else if(parameter[i] instanceof String) {
					ps.setString(index , (String) parameter[i]);
				}
				else if(parameter[i] instanceof Date) {
					ps.setDate(index, (Date) parameter[i]);
				}
				else if(parameter[i] == null) {
					ps.setNull(index, Types.NULL);
				}
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public <T> List<T> query(String sql, RowMapper<T> row , Object... parameter) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<T> result = new ArrayList<T>();
		try {
			try {
				con = getConnection();
				ps = con.prepareStatement(sql);
				setParameter(ps, parameter);
				rs = ps.executeQuery();
				while(rs.next()) {
					result.add(row.mapper(rs));
				}
				return result;
			}
			finally {
				if (con != null)
					con.close();
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			}
		}catch(SQLException e) {
		
		}
		return null;
	}

	public void update(String sql, Object... parameter) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			try {
				con = getConnection();
				con.setAutoCommit(false);
				ps = con.prepareStatement(sql);
				setParameter(ps, parameter);
				ps.executeUpdate();
				con.commit();
			}
			finally {
				if (con != null)
					con.close();
				if (ps != null)
					ps.close();
			}
		}catch(SQLException e) {
			if (con != null)
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
	}

	public Long insert(String sql, Object... parameter) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Long idV = null;
		try {
			try {
				con = getConnection();
				con.setAutoCommit(false);
				ps = con.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
				setParameter(ps, parameter);
				ps.executeUpdate();
				rs = ps.getGeneratedKeys();
				if(rs.next())
					idV = rs.getLong(1);
				con.commit();
			}
			finally {
				if (con != null)
					con.close();
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			}
		}catch(SQLException e) {
			if (con != null)
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		return idV;
	}

}
