package helpers;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class ConsoleLog {

    private static Logger log = Logger.getLogger(ConsoleLog.class);

    public ConsoleLog() {
    }

    public static void debug(String msg) {
        String thread = "Thread ID = " + Thread.currentThread().getId();
        if (!StringUtils.isBlank(msg)) {
            msg = String.format("%-14s -- %s", thread, msg);
            log.debug(msg);
        }

    }

    public static void error(String msg) {
        String thread = "Thread ID = " + Thread.currentThread().getId();
        if (!StringUtils.isBlank(msg)) {
            msg = String.format("%-14s -- %s", thread, msg);
            log.error(msg);
        }

    }

    public static void info(String msg) {
        String thread = "Thread ID = " + Thread.currentThread().getId();
        if (!StringUtils.isBlank(msg)) {
            msg = String.format("%-14s -- %s", thread, msg);
            log.info(msg);
        }

    }

    public static void error(String msg, Throwable thrown) {
        String thread = "Thread ID = " + Thread.currentThread().getId();
        if (!StringUtils.isBlank(msg)) {
            msg = String.format("%-14s -- %s", thread, msg);
            log.error(msg, thrown);
        }

    }

    public static void setLogLevel(int logLvl) {
        log.setLevel(Level.toLevel(logLvl));
    }

    public static void setLogLevel(String logLvl) {
        log.setLevel(Level.toLevel(logLvl));
    }
}
