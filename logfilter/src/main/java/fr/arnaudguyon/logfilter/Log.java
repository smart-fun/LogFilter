/*
    Copyright 2016 Arnaud Guyon

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
 */
package fr.arnaudguyon.logfilter;

/**
 * Log Helper
 */

public class Log {

    public enum Priority {
        VERBOSE(android.util.Log.VERBOSE),
        DEBUG(android.util.Log.DEBUG),
        INFO(android.util.Log.INFO),
        WARN(android.util.Log.WARN),
        ERROR(android.util.Log.ERROR);

        private int mAndroidPriority;

        Priority(int androidPriority) {
            mAndroidPriority = androidPriority;
        }
    }

    private Priority mPriority;
    private static Log sInstance;

    /**
     * Constructor. Keep a reference to it in the Application class
     * @param priority Log Level priority. All logs with a >= priority will be displayed.
     */
    public Log(Priority priority) {
        mPriority = priority;
        sInstance = this;
    }

    private static Priority getPriority() {
        if (sInstance == null) {
            return Priority.VERBOSE;
        } else {
            return sInstance.mPriority;
        }
    }

    private static boolean isActive(int logLevel) {
        return (logLevel >= getPriority().mAndroidPriority);
    }

    public static void v(String tag, String msg) {
        if (isActive(android.util.Log.VERBOSE)) {
            android.util.Log.v(tag, msg);
        }
    }
    public static void d(String tag, String msg) {
        if (isActive(android.util.Log.DEBUG)) {
            android.util.Log.d(tag, msg);
        }
    }
    public static void i(String tag, String msg) {
        if (isActive(android.util.Log.INFO)) {
            android.util.Log.i(tag, msg);
        }
    }
    public static void w(String tag, String msg) {
        if (isActive(android.util.Log.WARN)) {
            android.util.Log.w(tag, msg);
        }
    }
    public static void e(String tag, String msg) {
        if (isActive(android.util.Log.ERROR)) {
            android.util.Log.e(tag, msg);
        }
    }
    public static void e(String tag, String msg, Exception exception) {
        if (isActive(android.util.Log.ERROR)) {
            android.util.Log.e(tag, msg, exception);
        }
    }

}
