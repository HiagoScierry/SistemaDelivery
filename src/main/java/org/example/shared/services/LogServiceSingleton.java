package org.example.shared.services;

import org.example.models.Log;
import org.example.modules.log.interfaces.ILogAdapter;

public class LogServiceSingleton {
    private static LogServiceSingleton instance;
    private ILogAdapter log;

    private LogServiceSingleton() {
    }

    public static LogServiceSingleton getInstance() {
        if (instance == null) {
            instance = new LogServiceSingleton();
        }

        return instance;
    }

    public ILogAdapter getLog() {
        return log;
    }

    public void setLog(ILogAdapter log) {
        this.log = log;
    }

    public void registrarLog(Log logData) {
        this.log.escreve(logData);
    }
}
