# 并发编程初探

## 天生的多线程

[6]Monitor Ctrl-Break（IDEA通过反射的方式，开启一个随着我们运行的jvm进程开启与关闭的一个监听线程）

[5]Attach Listener（附加监听器。jdk中一个工具类提供的**jvm线程之间通信的工具**（java -version、jstack、jmap、dump））开启我们这个线程的两个方式： 1. 通过jvm参数开启：-XX: StartAttachListener  2.延迟开启： cmd -- java -version -->  JVM 适时开启AL线程

[4]Signal Dispatcher（信号分发器。 我们通过cmd 发送jstack，传到了jvm进程，这时候信号分发器就要发挥作用了。）

[3]Finalizer（1. 只有当开始一轮垃圾收集的时候，才会开始调用finalize方法。 2.  daemon prio=10 高优先级的守护线程。  3. jvm在垃圾收集的时候，会将失去引用的对象封装到我们的 Fianlizer 对象（Reference）， 放入我们的 F-queue 队列中。由 Finalizer 线程执行inalize方法）

[2]Reference Handler（引用处理的线程。强，软，弱，虚。 -GC 有不同表现）

[1]main主线程

"main" #1 prio=5 os_prio=0 tid=0x00000000028f4800 nid=0x25ac waiting on condition [0x00000000028ef000] （操作系统面向的是JVM 进程，JVM 进程里面向的是 我们的main函数，。所以对于我们的操作系统如何看待我们的main函数优先级，无所谓。 只要os 给我们jvm进程足够公平的优先级就行。）
