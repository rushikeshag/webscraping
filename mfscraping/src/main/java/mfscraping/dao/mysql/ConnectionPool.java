package mfscraping.dao.mysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import mfscraping.util.CommonUtil;

public abstract class ConnectionPool {
	static final HikariDataSource ds;

	static {
		Properties dbConfig = CommonUtil.load("mysqldb.properties");
		HikariConfig cfg = new HikariConfig(dbConfig);
		cfg.setPoolName("mfdata-mysql" + "-pool");
		ds = new HikariDataSource(cfg);
	}

	private ConnectionPool() {
	}

	public static Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e); // NOSONAR
		}
	}
}
