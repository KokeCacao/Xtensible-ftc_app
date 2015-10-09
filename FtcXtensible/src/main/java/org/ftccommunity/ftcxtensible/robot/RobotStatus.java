/*
 *
 *  * Copyright © 2015 David Sargent
 *  *
 *  * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 *  * and associated documentation files (the “Software”), to deal in the Software without restriction,
 *  * including without limitation  the rights to use, copy, modify, merge, publish, distribute, sublicense,
 *  * and/or sell copies of the Software, and  to permit persons to whom the Software is furnished to
 *  * do so, subject to the following conditions:
 *  *
 *  * The above copyright notice and this permission notice shall be included in all copies or
 *  * substantial portions of the Software.
 *  *
 *  * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 *  * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 *  * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package org.ftccommunity.ftcxtensible.robot;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.ftccommunity.ftcxtensible.internal.NotDocumentedWell;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

@NotDocumentedWell
public class RobotStatus {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private final ConcurrentLinkedQueue<LogElement> logElements;
    private LogTypes logType;
    private MainStates state;
    private Type type;

    private RobotStatus() {
        logElements = new ConcurrentLinkedQueue<>();
    }

    public RobotStatus(RobotContext ctx, LogTypes type) {
        this();
        logType = type;
    }

    public String getLog() {
        if (logType == LogTypes.JSON) {
            GsonBuilder gsonBuilder = new GsonBuilder().enableComplexMapKeySerialization().setPrettyPrinting();
            Gson gson = gsonBuilder.create();
            return gson.toJson(logElements.toArray());
        } else if (logType == LogTypes.HTML) {
            final String header =
                    "<!DOCTYPE html>" +
                            "<head>" +
                            "<title>Robot Log</title>" +
                            "<!-- Latest compiled and minified CSS -->\n" +
                            "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">" +
                            "</head>" +
                            "<body>" +
                            "<table class=\"table table-bordered\">\n";
            final String footer =
                    "</table>" +
                            "</body>";
            StringBuilder builder = new StringBuilder();
            builder.append(header);
            for (LogElement logElement : logElements) {
                if (logElement.level == Level.SEVERE) {
                    builder.append("<tr class=\"danger\">");
                } else if (logElement.level == Level.WARNING) {
                    builder.append("<tr class=\"warning\">");
                } else {
                    builder.append("<tr> ");
                }
                builder.append("<td>").append(logElement.type).append("</td>");
                builder.append("<td>").append(logElement.details).append("</td>");
            }
            builder.append(footer);

            return builder.toString();
        } else {
            StringBuilder builder = new StringBuilder();
            for (LogElement logElement : logElements) {
                builder.append(logElement.type).append("\t\t");
                builder.append(logElement.details);
            }
            return builder.toString();
        }
    }

    public void log(Level level, String tag, String details) {
        synchronized (logElements) {
            logElements.add(new LogElement(level, tag, details));
        }
    }

    public MainStates getMainRobotState() {
        return state;
    }

    public RobotStatus setMainState(MainStates newState) {
        state = newState;
        return this;
    }

    public Type getCurrentStateType() {
        return type;
    }

    public RobotStatus setCurrentStateType(Type newType) {
        type = newType;
        return this;
    }

    public enum LogTypes {
        HTML,
        TEXT,
        JSON
    }

    public enum MainStates {
        CONSTRUCT, ARM, INIT, EXEC, STOP, START, EXCEPTION
    }

    public enum Type {
        SUCCESS, FAILURE, IDK
    }

    private class LogElement {
        String type;
        Level level;
        String details;

        public LogElement(Level logLevel, String entryType, String entryDetails) {
            level = logLevel;
            details = entryDetails;
            type = entryType;
        }
    }
}
