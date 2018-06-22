package com.geek99.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TableDaoImpl implements TableDao {

	@Override
	public List<Table> getAllTables() {
		// TODO Auto-generated method stub
		String sql ="select id,flag from tabletbl";
		Connection conn = ConnectionUtil.open();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			List<Table> list= new ArrayList<Table>();
			while(rs.next()) {
				int id = rs.getInt(1);
				int flag = rs.getInt(2);
				Table t = new Table();
				t.setTid(id);
				t.setFlag(flag);
				list.add(t);
			}
			return list; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(conn);
		}
		
		return null;
	}

	@Override
	public List<Table> getEmptyTables() {
		String sql = "select id,flag from tabletbl where flag = 0";
		Connection conn = ConnectionUtil.open();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			List<Table> list = new ArrayList<Table>();
			while(rs.next()){
				int id = rs.getInt(1);
				int flag = rs.getInt(2);
				Table t = new Table();
				t.setTid(id);
				t.setFlag(flag);
				list.add(t);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionUtil.close(conn);
		}
		return null;
	}

	@Override
	public List<Table> getEatingTables() {
		String sql = "select id,flag from tabletbl where flag = 1";
		Connection conn = ConnectionUtil.open();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			List<Table> list = new ArrayList<Table>();
			while(rs.next()){
				int id = rs.getInt(1);
				int flag = rs.getInt(2);
				Table t = new Table();
				t.setTid(id);
				t.setFlag(flag);
				list.add(t);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionUtil.close(conn);
		}
		return null;
	}

	@Override
	public int union(int tid1, int tid2) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionUtil.open();
		try {
			CallableStatement cstmt = conn.prepareCall("{call change_table_proc(?,?)}");
			cstmt.setInt(1, tid1);
			cstmt.setInt(2,tid2);
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}finally{
			ConnectionUtil.close(conn);
		}
		return 1;
	}

	@Override
	public int change(int tid1, int tid2) {
		// TODO Auto-generated method stub
		return 0;
	}
		
}
