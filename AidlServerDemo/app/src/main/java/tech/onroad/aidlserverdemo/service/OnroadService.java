package tech.onroad.aidlserverdemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import tech.onroad.aidlserverdemo.IOnroad;

public class OnroadService extends Service {
    public final String TAG = "OnroadService";
    public OnroadService() {
    }

    private IOnroad.Stub mBinder = new IOnroad.Stub() {
        @Override
        public String sayHello(String name, int age) throws RemoteException {
            String str = "Hello " + name + ", your age is " + age;
            Log.d(TAG, str);
            return str;
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mBinder;
    }
}
