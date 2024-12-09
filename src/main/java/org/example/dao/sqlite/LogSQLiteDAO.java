package org.example.dao.sqlite;

import org.example.dao.interfaces.ILogSQLiteDAO;
import org.example.models.Log;
import org.example.shared.config.database.SQLiteConnection;

import java.sql.*;

public class LogSQLiteDAO implements ILogSQLiteDAO {

    public LogSQLiteDAO() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS `log` ("
                + "`id` INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "`date` DATETIME,"
                + "`nomeUsuario` TEXT, "
                + "`codigoPedio` TEXT, "
                + "`nomeOperacao` TEXT, "
                + "`nomeCliente` TEXT "
                + ")";

        try (Statement sqliteConnection = SQLiteConnection.getConexao().createStatement()) {
            sqliteConnection.execute(sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(Log log) {
        String sql = "INSERT INTO log (date, nomeUsuario, codigoPedio, nomeOperacao, nomeCliente) VALUES (?, ?, ?, ?, ?);";

        try (PreparedStatement preparedStatement = SQLiteConnection.getConexao().prepareStatement(sql)) {

            preparedStatement.setTimestamp(1, Timestamp.valueOf(log.getData()));
            preparedStatement.setString(2, log.getNomeUsuario());
            preparedStatement.setString(3, String.valueOf(log.getCodigoPedido()));
            preparedStatement.setString(4, log.getNomeOperacao());
            preparedStatement.setString(5, log.getNomeCliente());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
