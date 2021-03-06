package com.ojas.demo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class Demo {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/venudb","root","root");
			System.out.println("Connected" +con);
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter empno ?");
			CallableStatement cst = con.prepareCall("{CALL getSal(?,?)}");
			cst.setInt(1, sc.nextInt());
			cst.registerOutParameter (2, Types.FLOAT) ;
			cst.execute();
			float salary = cst.getFloat(2);
			System.out.println("Your salary is = " + salary);
			}
		catch(Exception e ) {
			System.out.println(e);
		}
	}
}
