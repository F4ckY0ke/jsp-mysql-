package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
				notebook1.setId(rs.getInt("id"));
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
	//����һ���µĹ��ܣ��ù�����ɴ�User���У���������id����һ����¼��������¼���ظ�������
	//
	/*
	 * �����ӵķ�������Ҫȷ�������������ݣ�
	 * 1��������public
	 * 2���������ݵ����ͣ�User�����
	 * 3�����������ƣ�load
	 * 4�������Ĳ�����User����id�ֶΣ��������������ͣ�int
	 * 5�����ܵľ���ʵ��
	 */
	public Notebook load(int pararmId) throws SQLException{
		Notebook notebook=null;
		//ʵ�ִ����ݱ��м�����¼�Ĺ���
		/*
		 * 1���������ݿ�
		 * 2������һ��Statement����
		 * 3��ִ�в�ѯ�����������¼��ResultSet������
		 * 4������в�ѯ���������ѯ����Ψһһ����¼��ת����User����
		 */
		
		Connection connection=Dbconn.getConnection();
		//ʹ��Statement������ɵĴ������Ĳ�ѯ
		/*try {
			Statement statement=connection.createStatement();
			String sql="select * from user where id="+pararmId;
			ResultSet rs=statement.executeQuery(sql);
			if(rs.next()){
				//ת��
				user=new User();
				//�ֱ���������Խ��и�ֵ
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//ʹ��PreparedStatement������ɵĴ������Ĳ�ѯ
		//select * from user where id='aa';
		
		try {
			String sql="select * from notebook where id=?";
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setInt(1, pararmId);
			//statement.setInt(1, pararmId);//����ֵ��1��ʼ
			//statement.setString(2, "����");
			
			ResultSet rs=statement.executeQuery();
			if(rs.next()){
				notebook=new Notebook();
				notebook.setId(rs.getInt("id"));
				notebook.setName(rs.getString("name"));
				notebook.setPrice(rs.getDouble("price"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return notebook;
		
	}
}

