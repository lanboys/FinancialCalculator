package com.bing.lan.fc.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IResultSetHandler<T> {

    T handleResultSet(ResultSet resultSet) throws SQLException;
}
