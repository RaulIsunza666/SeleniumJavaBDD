package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerManager {
    private LoggerManager() {
    }

    public static Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }
}
