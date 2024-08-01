package com.genymobile.scrcpy;

import java.lang.reflect.Method;

public final class Utils {

    public static final int DEFAULT_WIDTH = 1920;

    public static final int DEFAULT_HEIGHT = 1200;

    public static final String SCREEN_RECORD_STATE_PROPERTY = "debug.rokid.screenrecord_state";

    public static void setSystemProperty(String name, String value) {
        try {
            Class<?> c =Class.forName("android.os.SystemProperties");
            Method set =c.getMethod("set", String.class, String.class);
            set.invoke(c, name, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
