package com.ojas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ojas.model.Person;

public class PersonDAO {
	Connection con;

	static Connection getConnect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java200", "root", "root");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	public static boolean addPreson(Person per) {
        boolean b = false;
        try {
            Connection con = getConnect();
            PreparedStatement pmt = con
                    .prepareStatement("insert into persons(ename,contactno,email,gender,address)values(?,?,?,?,?)");
            // pmt.setInt(1, per.getPid());
            pmt.setString(1, per.getEname());
            pmt.setString(2, per.getContactno());
            pmt.setString(3, per.getEmail());
            pmt.setString(4, per.getGender());
            pmt.setString(5, per.getAddress());
            int res = pmt.executeUpdate();
            if (res > 0) {
                b = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return b;
    	}
	public List<Person> listPerson() {
		List<Person> list = new ArrayList<Person>();
		try {
			Connection con = getConnect();
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery("select * from persons");
			while(res.next()) {
				Person p = new Person(res.getInt(1),
						res.getString(2),
						res.getString(3),
						res.getString(4),
						res.getString(5),
						res.getString(6));
				list.add(p);
			}
			res.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return list;	
	}
	public boolean validate(String uname,String pword) {
		boolean b = false;
		  try {
			  Connection con = getConnect();
			  PreparedStatement pst = con.prepareStatement("Select * from persons where ename=? and constructor=?");
			  pst.setString(1,uname);
			  pst.setString(1,pword);
			  ResultSet res = pst.executeQuery();
			  if(res.next()) {
				  b = true;
			  }
		  }
			  catch(Exception e) {
				  System.out.println(e);
			  }
			  return b;
		  }
	public boolean delPerson(int num) {
		boolean b = false;
		  try {
			  Connection con = getConnect();
			  PreparedStatement pst = con.prepareStatement("delete from persons where pid =?");
			  pst.setInt(1,num);
			  int res = pst.executeUpdate();
			  if(res>0) {
				  b = true;
			  }
		  }
			  catch(Exception e) {
				  System.out.println(e);
			  }
			  return b;
		  }
}
	 
  

