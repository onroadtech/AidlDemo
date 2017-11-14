package tech.onroad.aidlserverdemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import tech.onroad.aidljar.IAidlJarTest;
import tech.onroad.aidlserverdemo.IOnroad;
import tech.onroad.aidlserverdemo.bean.Hobby;
import tech.onroad.aidlserverdemo.bean.Person;

public class AidlJarService extends Service {
    public final String TAG = "AidlJarService";
    public AidlJarService() {
    }

    private IAidlJarTest.Stub mBinder = new IAidlJarTest.Stub() {

        @Override
        public void add(int a, int b) throws RemoteException {
            Log.d(TAG, "Add result: " + (a + b));
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mBinder;
    }
}
