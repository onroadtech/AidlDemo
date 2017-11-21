package tech.onroad.aidljar;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by TMS on 21/11/2017.
 */

public enum Student implements Parcelable {
    Bill,
    TOM,
    KATE;

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return Student.valueOf(in.readString());
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}
