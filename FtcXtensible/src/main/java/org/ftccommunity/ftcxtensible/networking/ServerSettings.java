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

package org.ftccommunity.ftcxtensible.networking;

import org.ftccommunity.ftcxtensible.internal.NotDocumentedWell;

@NotDocumentedWell
public class ServerSettings {
    private String webDirectory;
    private String index;
    private String hardwareMapJsonPage;
    private String logPage;

    private ServerSettings() {
        setWebDirectory("/sdcard/FIRST/web");
        setIndex("/index.html");
        setHardwareMapJsonPage("/robot.json");
        setLogPage("/robot-log.html");
    }

    public static ServerSettings createServerSettings() {
        return new ServerSettings();
    }

    public String getWebDirectory() {
        return webDirectory;
    }

    public void setWebDirectory(String webDirectory) {
        this.webDirectory = webDirectory;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getHardwareMapJsonPage() {
        return hardwareMapJsonPage;
    }

    public void setHardwareMapJsonPage(String hardwareMapJsonPage) {
        this.hardwareMapJsonPage = hardwareMapJsonPage;
    }

    public String getLogPage() {
        return logPage;
    }

    public void setLogPage(String logPage) {
        this.logPage = logPage;
    }
}