package com.genymobile.scrcpy.wrappers;

import com.genymobile.scrcpy.Ln;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.IInterface;
import android.view.Surface;
import android.os.IBinder;

import java.lang.reflect.Method;
import com.rokid.os.master.screenstream.ISurfaceProvider;

public final class ScreenStreamManager {
    private final ISurfaceProvider manager;
    private Method getGetBinderMethod;

    static ScreenStreamManager create() {
        IInterface manager = ServiceManager.getService("screenstream.SurfaceProvider", "com.rokid.os.master.screenstream.ISurfaceProvider");
        return new ScreenStreamManager(manager);
    }

    private ScreenStreamManager(IInterface manager) {
        this.manager = (ISurfaceProvider)manager;
    }

    public void setSurface(Surface surface) {
        Ln.d("setSurface : " + surface);
        try {
            manager.setSurface(surface);
        } catch (Exception e) {
            Ln.e("Could not invoke method", e);
        }
    }
}