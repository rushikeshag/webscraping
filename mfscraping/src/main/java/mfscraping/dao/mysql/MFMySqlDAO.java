package mfscraping.dao.mysql;

import java.sql.Connection;
import java.sql.SQLException;

import mfscraping.dao.MFDAO;
import mfscraping.dto.TableMeta;

public class MFMySqlDAO implements MFDAO {

	@Override
	public void saveMFNames(TableMeta table) {
		// Auto-generated method stub
		try (Connection connection = ConnectionPool.getConnection()) {

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);// NOSONAR
		}

	}

}
