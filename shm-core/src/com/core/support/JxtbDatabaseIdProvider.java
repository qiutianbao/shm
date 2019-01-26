package com.core.support;

import org.apache.ibatis.mapping.DatabaseIdProvider;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;


public class JxtbDatabaseIdProvider implements DatabaseIdProvider {

    private Properties properties;

    private String dbDialect;

    public void setDbDialect(String dbDialect) {
        this.dbDialect = dbDialect;
    }

    public String getDatabaseId(DataSource dataSource) throws SQLException {
        return dbDialect;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

}
