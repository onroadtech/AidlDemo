# AIDL IPC Demo
The demo used for AIDL IPC. It includes two project -- AidlClientDemo and AidlServerDemo. AidlServerDemo is a service project, AidlClientDemo is a client project.
For now, the demo support following param type as AIDL interface.
- Basic type: Int, String, boolean and so on.
- Self-define type: 
- Enum:

Also support pack aidl interface as a jar library for third apps' call.


该demo用于阐述跨进程间IPC AIDL通信问题。
该demo包括两个工程AidlClientDemo及AidlServerDemo，AidlServerDemo为Service端代码，AidlClientDemo为Client端代码。
支持的AIDL参数类型：
- 基本类型
- 自定义类型
- 枚举

详情请参阅我的个人博客:
- 基本类型：  [《跨进程间如何进行AIDL IPC 通信（一）》](http://www.onroad.tech/articles/aidl-ipc-communication-1/)
- 自定义类型：[《跨进程间如何进行AIDL IPC 通信（二）》](http://www.onroad.tech/articles/aidl-ipc-communication-2/)
- 枚举类型： [《跨进程间如何进行AIDL IPC 通信（三）》](http://www.onroad.tech/articles/aidl-ipc-communication-3/)

本项目支持将AIDL接口打包成Jar包供第三方客户端调用，请参阅：

[《跨进程间如何进行AIDL IPC 通信（四）》](http://www.onroad.tech/articles/aidl-ipc-communication-4/)

