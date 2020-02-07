本demo是为了演示Binder跨进程通信原理和AIDL工具使用，相关的说明讲解在https://blog.csdn.net/caizehui/article/details/104045174

两个对象能直接互相访问的前提是这两个对象都存在于相同的内存地址空间中，如果两个对象位于两个不同进程，则不能直接互相调用。Binder 是Android中的一种跨进程通信方式，即IPC（Inter-process Communication）一种。
Binder主要分为Binder服务端、Binder客户端和Binder驱动。
![](https://github.com/qingdaofu1/binderdemo/blob/master/Binder.png)
