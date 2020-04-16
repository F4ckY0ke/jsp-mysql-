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
		//connection连接数据库对象
		//statement发出执行命令的指令
		//resultset返回Statement对象返回的结果
		Connection conn=Dbconn.getConnection();
		try {
			Statement statement=conn.createStatement();
			//定义一个命令.（字符串.SQL语句）
			String sql="select * from notebook";
			ResultSet rs=statement.executeQuery(sql);
			//将数据表中的记录转换成java中的对象
			
			//rs是一个数据集。要遍历它。将每一行数据分别通过notebook对象的set访问器
			//为每个临时对象进行赋值，最后将每个临时对象放入List集合中。
			//ResultSet-->List转换过程
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
				lists.add(notebook1);//把notebook1对象添加到list中.
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lists;
	}
	}
