package tech.onroad.aidlserverdemo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Liting Wang on 09/11/2017.
 */

public class Person implements Parcelable {
    private String name;
    private int age;
    private Hobby hobby;

    public Person(){

    }

    protected Person(Parcel in) {
        name = in.readString();
        age = in.readInt();
        hobby = Hobby.values()[in.readInt()];
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Hobby getHobby() {
        return hobby;
    }

    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(age);
        parcel.writeInt(hobby.ordinal());
    }

    public void readFromParcel(Parcel reply) {
        this.name = reply.readString();
        this.age = reply.readInt();
        this.hobby = Hobby.values()[reply.readInt()];
    }
}
