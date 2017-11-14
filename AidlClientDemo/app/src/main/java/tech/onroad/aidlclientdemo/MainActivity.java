package tech.onroad.aidlclientdemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import tech.onroad.aidljar.IAidlJarTest;
import tech.onroad.aidlserverdemo.IOnroad;
import tech.onroad.aidlserverdemo.bean.Hobby;
import tech.onroad.aidlserverdemo.bean.Person;

public class MainActivity extends AppCompatActivity {
    private IOnroad mIOnroad;
    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mIOnroad = IOnroad.Stub.asInterface(iBinder);
            try {
                String svcRet = mIOnroad.sayHello("Liting", 20);
                Log.d("Client", "Service return " + svcRet);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            Person person = new Person();
            person.setName("Liting");
            person.setAge(20);
            person.setHobby(Hobby.SWIM);
            try {
                Person svcPerson = mIOnroad.introducePerson(person);
                Log.d("Client", "Service return: Hello " + svcPerson.getName() +
                        ", you hobby is " + svcPerson.getHobby());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mIOnroad = null;
        }
    };

    private IAidlJarTest mIAidlJarTest;
    ServiceConnection aidlServiceconn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mIAidlJarTest = IAidlJarTest.Stub.asInterface(iBinder);
            try {
                mIAidlJarTest.add(8, 8);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mIAidlJarTest = null;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent mServiceIntent = new Intent();
        //mServiceIntent.setAction("tech.onroad.aidlservicedemo.onroadservice");
        //mServiceIntent.setPackage("tech.onroad.aidlserverdemo");
        //bindService(mServiceIntent, conn, Context.BIND_AUTO_CREATE);

        //Test aidl jar service
        mServiceIntent.setAction("tech.onroad.aidlservicedemo.aidljarservice");
        mServiceIntent.setPackage("tech.onroad.aidlserverdemo");
        bindService(mServiceIntent, aidlServiceconn, Context.BIND_AUTO_CREATE);
    }
}
