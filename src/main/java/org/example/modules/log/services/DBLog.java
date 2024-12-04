package org.example.modules.log.services;

import org.example.dao.sqlite.LogSQLiteDAO;
import org.example.models.Log;
import org.example.modules.log.interfaces.ILog;

public class DBLog implements ILog {
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
