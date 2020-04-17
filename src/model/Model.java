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
				notebook1.setId(rs.getInt("id"));
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
	//加入一项新的功能，该功能完成从User表中，根据主键id检索一条记录，并将记录返回给调用者
	//
	/*
	 * 新增加的方法，需要确定以下内项内容：
	 * 1、访问域：public
	 * 2、返回数据的类型：User类对象
	 * 3、方法的名称：load
	 * 4、方法的参数：User表中id字段，参数的数据类型：int
	 * 5、功能的具体实现
	 */
	public Notebook load(int pararmId) throws SQLException{
		Notebook notebook=null;
		//实现从数据表中检索记录的过程
		/*
		 * 1、连接数据库
		 * 2、声明一个Statement对象
		 * 3、执行查询，并将结果记录中ResultSet对象中
		 * 4、如果有查询结果，将查询到的唯一一条记录，转换成User对象
		 */
		
		Connection connection=Dbconn.getConnection();
		//使用Statement对象完成的带参数的查询
		/*try {
			Statement statement=connection.createStatement();
			String sql="select * from user where id="+pararmId;
			ResultSet rs=statement.executeQuery(sql);
			if(rs.next()){
				//转换
				user=new User();
				//分别对三个属性进行赋值
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//使用PreparedStatement对象完成的带参数的查询
		//select * from user where id='aa';
		
		try {
			String sql="select * from notebook where id=?";
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setInt(1, pararmId);
			//statement.setInt(1, pararmId);//索引值从1开始
			//statement.setString(2, "张三");
			
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

