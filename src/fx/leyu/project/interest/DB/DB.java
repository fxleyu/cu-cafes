package fx.leyu.project.interest.DB;

import java.sql.*;

import fx.leyu.project.interest.bean.Record;

public class DB {
	
	private String table;
	private Connection con;
	
	public DB(String db, String table){
		this.table = table;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/"+db, "fxleyu", "fxyuer");
		} catch (Exception e) {
			System.out.println("DataBase Connection has exception!!!");
		}
	}
	
	public String insert(Record r){
		try{
			con.setAutoCommit(false);
			String sql = "insert into "+table+"  values (?,?,?,?,?,?,?,?,?,?,?)";
			java.sql.PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, r.getId());
			ps.setString(2, r.getName());
			ps.setString(3, r.getGender());
			ps.setString(4, r.getAge());
			ps.setString(5, r.getBirthday());
			ps.setString(6, r.getLocation());
			ps.setString(7, r.getPhone());
			ps.setString(8, r.getEmail());
			ps.setString(9, r.getNation());
			ps.setString(10, r.getSite());
			ps.setString(11, r.getTime());
			ps.executeUpdate();
			con.commit();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Insert id = " + r.getId() + " has Exception!!!");
		}
		return r.getId();
	}
	
	public void close(){
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Closing DataBase has Exception!!!");		
		}
	}
}
