package org.example.dao.sqlite;

import org.example.dao.interfaces.ILogSQLiteDAO;
import org.example.models.Log;
import org.example.shared.config.database.SQLiteConnection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class LogSQLiteDAO implements ILogSQLiteDAO {

    public LogSQLiteDAO() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS `log` ("
                + "`id` INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "`date` DATE,"
                + "`hour` TIME,"
                + "`nomeUsuario` TEXT, "
                + "`codigoPedio` TEXT, "
                + "`nomeOperacao` TEXT, "
                + "`nomeCliente` TEXT, "
                + ")";

        try (Statement sqliteConnection = SQLiteConnection.getConexao().createStatement()) {
            sqliteConnection.execute(sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(Log log) {
        String sql = "INSERT INTO log (date, hour, nomeUsuario, codigoPedio, nomeOperacao, nomeCliente) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = SQLiteConnection.getConexao().prepareStatement(sql)) {

            preparedStatement.setDate(1, Date.valueOf(log.getData()));
            preparedStatement.setDate(2, Date.valueOf(log.getHora()));
            preparedStatement.setString(3, log.getNomeUsuario());
            preparedStatement.setString(4, log.getCodigoPedido());
            preparedStatement.setString(5, log.getNomeOperacao());
            preparedStatement.setString(6, log.getNomeCliente());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
