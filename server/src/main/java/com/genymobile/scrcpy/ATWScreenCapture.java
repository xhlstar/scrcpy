package com.genymobile.scrcpy;

import com.genymobile.scrcpy.wrappers.ServiceManager;
import com.genymobile.scrcpy.wrappers.SurfaceControl;

import android.graphics.Rect;
import android.hardware.display.VirtualDisplay;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.Surface;
import android.content.ServiceConnection;
import android.content.Context;
import android.content.ComponentName;
import android.content.Intent;
import android.app.IServiceConnection;
import static com.genymobile.scrcpy.Utils.DEFAULT_WIDTH;
import static com.genymobile.scrcpy.Utils.DEFAULT_HEIGHT;
import static com.genymobile.scrcpy.Utils.SCREEN_RECORD_STATE_PROPERTY;
import static com.genymobile.scrcpy.Utils.setSystemProperty;
public class ATWScreenCapture extends SurfaceCapture {


    public ATWScreenCapture() {

    }

    private ServiceConnection mConn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Ln.d("onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Ln.d("onServiceConnected");
        }
    };

    public void init() {
        ServiceManager.getScreenStreamManager();
        setSystemProperty(SCREEN_RECORD_STATE_PROPERTY, "0");
        //ServiceManager.getActivityManager().bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    public void start(Surface surface) {
        ServiceManager.getScreenStreamManager().setSurface(surface);
        setSystemProperty(SCREEN_RECORD_STATE_PROPERTY, "1");
        Ln.d("Todo set surface to ATW");
    }

    @Override
    public void release() {
        Ln.d("ATWScreenCapture release");
        setSystemProperty(SCREEN_RECORD_STATE_PROPERTY, "0");
    }

    @Override
    public Size getSize() {
        return new Size(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    @Override
    public boolean setMaxSize(int maxSize) {
        return true;
    }
}
