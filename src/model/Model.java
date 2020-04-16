package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbutil.Dbconn;

import entity.Notebook;

public class Model {
	public List<Notebook> notebookSelect() throws SQLException{
		List<Notebook> lists=new ArrayList<Notebook>();
//		List list=new ArrayList<Notebook>();
		//connection�������ݿ����
		//statement����ִ�������ָ��
		//resultset����Statement���󷵻صĽ��
		Connection conn=Dbconn.getConnection();
		try {
			Statement statement=conn.createStatement();
			//����һ������.���ַ���.SQL��䣩
			String sql="select * from notebook";
			ResultSet rs=statement.executeQuery(sql);
			//�����ݱ��еļ�¼ת����java�еĶ���
			
			//rs��һ�����ݼ���Ҫ����������ÿһ�����ݷֱ�ͨ��notebook�����set������
			//Ϊÿ����ʱ������и�ֵ�����ÿ����ʱ�������List�����С�
			//ResultSet-->Listת������
			while(rs.next()){
				Notebook notebook1=new Notebook();
				notebook1.setName(rs.getString("name"));
				notebook1.setPrice(rs.getDouble("price"));
				notebook1.setDate(rs.getDate("date"));
				notebook1.setBrand(rs.getString("brand"));
				notebook1.setConfiguration(rs.getString("configuration"));
				notebook1.setPurpose(rs.getString("purpose"));
				notebook1.setDurable(rs.getInt("durable"));
				notebook1.setLocation(rs.getString("location"));
				lists.add(notebook1);//��notebook1������ӵ�list��.
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lists;
	}
	}
