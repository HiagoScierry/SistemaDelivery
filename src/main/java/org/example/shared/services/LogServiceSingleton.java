package org.example.shared.services;

import org.example.models.Log;
import org.example.modules.log.interfaces.ILog;

public class LogServiceSingleton {
    private static LogServiceSingleton instance;
    private ILog log;

    private LogServiceSingleton() {
    }

    public static LogServiceSingleton getInstance() {
        if (instance == null) {
            instance = new LogServiceSingleton();
        }

        return instance;
    }

    public ILog getLog() {
        return log;
    }

    public void setLog(ILog log) {
        this.log = log;
    }

    public void registrarLog(Log logData) {
        this.log.escreve(logData);
    }
}
