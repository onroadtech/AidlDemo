// IOnroad.aidl
package tech.onroad.aidlserverdemo;

// Declare any non-default types here with import statements
import tech.onroad.aidlserverdemo.bean.Person;

interface IOnroad {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    /*void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);*/
    String sayHello(String name, int age);

    Person introducePerson(inout Person person);
}
