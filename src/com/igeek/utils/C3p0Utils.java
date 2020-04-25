package com.igeek.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Utils {
	
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource("reptile");
	
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
