package com.metadata.databaseview.table;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCSample {

	public static void main(String[] args) {
		try (Connection con = DBConnection.getConnection();
				Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery("SELECT * FROM emp");

		) {
			System.out.println("The database is connected");

			System.out.println("The number of rows present in table is:" + rs.getRow());

//			Entity.getEntity(rs);
		

			rs.last();
//			System.out.println(rs.getString("ename"));

		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}

