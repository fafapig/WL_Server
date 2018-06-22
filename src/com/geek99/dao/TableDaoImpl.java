package com.geek99.dao;

import java.sql.Connection;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int union(int tid1, int tid2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int change(int tid1, int tid2) {
		// TODO Auto-generated method stub
		return 0;
	}
		
}
