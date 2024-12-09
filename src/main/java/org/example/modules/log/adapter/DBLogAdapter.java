package org.example.modules.log.adapter;

import org.example.dao.sqlite.LogSQLiteDAO;
import org.example.models.Log;
import org.example.modules.log.interfaces.ILogAdapter;

public class DBLogAdapter implements ILogAdapter {
    @Override
    public void escreve(Log logData) {
        try {
            LogSQLiteDAO logSQLiteDAO = new LogSQLiteDAO();

            logSQLiteDAO.insert(logData);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
