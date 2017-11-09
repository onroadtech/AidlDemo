package tech.onroad.aidlserverdemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import tech.onroad.aidlserverdemo.IOnroad;
import tech.onroad.aidlserverdemo.bean.Person;

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

        @Override
        public Person introducePerson(Person person) throws RemoteException {
            Log.d(TAG, "My name is " + person.getName() + ", I am " + person.getAge());
            Person svcPerson = new Person();
            svcPerson.setName("ServicePerson");
            svcPerson.setAge(0);
            return svcPerson;
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mBinder;
    }
}
