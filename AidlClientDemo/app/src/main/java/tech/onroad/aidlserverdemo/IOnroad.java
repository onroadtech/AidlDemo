/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: E:\\workspace\\Sample\\AidlServerDemo\\app\\src\\main\\aidl\\tech\\onroad\\aidlserverdemo\\IOnroad.aidl
 */
package tech.onroad.aidlserverdemo;
// Declare any non-default types here with import statements

public interface IOnroad extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements tech.onroad.aidlserverdemo.IOnroad
{
private static final String DESCRIPTOR = "tech.onroad.aidlserverdemo.IOnroad";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an tech.onroad.aidlserverdemo.IOnroad interface,
 * generating a proxy if needed.
 */
public static tech.onroad.aidlserverdemo.IOnroad asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof tech.onroad.aidlserverdemo.IOnroad))) {
return ((tech.onroad.aidlserverdemo.IOnroad)iin);
}
return new tech.onroad.aidlserverdemo.IOnroad.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_sayHello:
{
data.enforceInterface(DESCRIPTOR);
String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
String _result = this.sayHello(_arg0, _arg1);
reply.writeNoException();
reply.writeString(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements tech.onroad.aidlserverdemo.IOnroad
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public String sayHello(String name, int age) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
_data.writeInt(age);
mRemote.transact(Stub.TRANSACTION_sayHello, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_sayHello = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public String sayHello(String name, int age) throws android.os.RemoteException;
}
