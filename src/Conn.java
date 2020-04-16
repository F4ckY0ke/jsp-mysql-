import java.sql.SQLException;
import java.util.List;

import model.Model;

import entity.Notebook;
public class Conn {
 public static void main(String args[]){
	 Model model=new Model();
	 try {
		List<Notebook> list=model.notebookSelect();
//		System.out.println(list.get(1).getName());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}