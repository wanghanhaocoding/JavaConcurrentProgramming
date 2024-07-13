# Synchronized 全解读

## Synchronized的使用方法

```java
Classfile /C:/Users/wanghanhao/Desktop/JavaConcurrentProgramming/concurrent-01/target/classes/com/wanghanhao/concurrent/SyncUsingWay.class
  Last modified 2024年7月7日; size 795 bytes
  SHA-256 checksum 49191990699d00279537bf7ec2107e65bd4d0912f1e40e5a7e1be11ce36a77b4
  Compiled from "SyncUsingWay.java"
public class com.wanghanhao.concurrent.SyncUsingWay
  minor version: 0
  major version: 52
  flags: (0x0021) ACC_PUBLIC, ACC_SUPER
  this_class: #7                          // com/wanghanhao/concurrent/SyncUsingWay
  super_class: #8                         // java/lang/Object
  interfaces: 0, fields: 0, methods: 4, attributes: 1
Constant pool:
   #1 = Methodref          #8.#25         // java/lang/Object."<init>":()V
   #2 = Fieldref           #26.#27        // java/lang/System.out:Ljava/io/PrintStream;
   #3 = String             #16            // SyncMethod
   #4 = Methodref          #28.#29        // java/io/PrintStream.println:(Ljava/lang/String;)V
   #5 = String             #17            // StaticSyncMethod
   #6 = String             #18            // method
   #7 = Class              #30            // com/wanghanhao/concurrent/SyncUsingWay
   #8 = Class              #31            // java/lang/Object
   #9 = Utf8               <init>
  #10 = Utf8               ()V
  #11 = Utf8               Code
  #12 = Utf8               LineNumberTable
  #13 = Utf8               LocalVariableTable
  #14 = Utf8               this
  #15 = Utf8               Lcom/wanghanhao/concurrent/SyncUsingWay;
  #16 = Utf8               SyncMethod
  #17 = Utf8               StaticSyncMethod
  #18 = Utf8               method
  #19 = Utf8               StackMapTable
  #20 = Class              #30            // com/wanghanhao/concurrent/SyncUsingWay
  #21 = Class              #31            // java/lang/Object
  #22 = Class              #32            // java/lang/Throwable
  #23 = Utf8               SourceFile
  #24 = Utf8               SyncUsingWay.java
  #25 = NameAndType        #9:#10         // "<init>":()V
  #26 = Class              #33            // java/lang/System
  #27 = NameAndType        #34:#35        // out:Ljava/io/PrintStream;
  #28 = Class              #36            // java/io/PrintStream
  #29 = NameAndType        #37:#38        // println:(Ljava/lang/String;)V
  #30 = Utf8               com/wanghanhao/concurrent/SyncUsingWay
  #31 = Utf8               java/lang/Object
  #32 = Utf8               java/lang/Throwable
  #33 = Utf8               java/lang/System
  #34 = Utf8               out
  #35 = Utf8               Ljava/io/PrintStream;
  #36 = Utf8               java/io/PrintStream
  #37 = Utf8               println
  #38 = Utf8               (Ljava/lang/String;)V
{
  public com.wanghanhao.concurrent.SyncUsingWay();
    descriptor: ()V
    flags: (0x0001) ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 3: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   Lcom/wanghanhao/concurrent/SyncUsingWay;

  public synchronized void SyncMethod();
    descriptor: ()V
    flags: (0x0021) ACC_PUBLIC, ACC_SYNCHRONIZED//锁标志
    Code:
      stack=2, locals=1, args_size=1
         0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
         3: ldc           #3                  // String SyncMethod
         5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
         8: return
      LineNumberTable:
        line 6: 0
        line 7: 8
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       9     0  this   Lcom/wanghanhao/concurrent/SyncUsingWay;

  public static synchronized void StaticSyncMethod();
    descriptor: ()V
    flags: (0x0029) ACC_PUBLIC, ACC_STATIC, ACC_SYNCHRONIZED//锁标志
    Code:
      stack=2, locals=0, args_size=0
         0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
         3: ldc           #5                  // String StaticSyncMethod
         5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
         8: return
      LineNumberTable:
        line 11: 0
        line 12: 8

  public void method();
    descriptor: ()V
    flags: (0x0001) ACC_PUBLIC
    Code:
      stack=2, locals=3, args_size=1
         0: aload_0
         1: dup
         2: astore_1
         3: monitorenter// 进入同步代码块（进入临界范围内，锁的原子内部）
         4: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
         7: ldc           #6                  // String method
         9: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        12: aload_1
        13: monitorexit// 正常退出同步代码块
        14: goto          22
        17: astore_2
        18: aload_1
        19: monitorexit//防止任何异常情况下，退出同步代码块。JVM 仍然可以释放锁
        20: aload_2
        21: athrow
        22: return
      Exception table: //配合来了异常退出 monitorexit
         from    to  target type
             4    14    17   any
            17    20    17   any
      LineNumberTable:
        line 16: 0
        line 17: 4
        line 18: 12
        line 19: 22
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      23     0  this   Lcom/wanghanhao/concurrent/SyncUsingWay;
      StackMapTable: number_of_entries = 2
        frame_type = 255 /* full_frame */
          offset_delta = 17
          locals = [ class com/wanghanhao/concurrent/SyncUsingWay, class java/lang/Object ]
          stack = [ class java/lang/Throwable ]
        frame_type = 250 /* chop */
          offset_delta = 4
}
SourceFile: "SyncUsingWay.java"
```

## Synchronized 的特性及对象头

1. 有序性 （读读、读写、写读、写写 互斥）
2. 可见性 （可见性是指多个线程访问⼀个资源时，该资源的状态、值信息等对于其他线程都是可见的。 synchronized和volatile都具有可见性，其中synchronized对⼀个类或对象加锁时，⼀个线程如果要访问该类或对象必须先获得它的锁，⽽这个锁的状态对于其他任何线程都是可见的，并且在释放锁之前会将对变量的修改刷新到共享内存当中，保证资源变量的可见性。）
3. 原子性 (本质上是线程互斥保证的原子性)
4. 可重入性

![image-20240707232801277](assets/image-20240707232801277.png)

![image-20240707232811449](assets/image-20240707232811449.png)

## Synchronized锁升级-偏向锁

偏向锁使用的前提：

1. 至少JDK1.6 版本且开启了偏向锁配置。偏向锁在Java 6和Java 7里是默认启用的，但是它在应用程序启动几秒钟之后才激活，如有必要可以使用JVM参数来关闭延迟：-XX:BiasedLockingStartupDelay=0。如果你确定应用程序里所有的锁通常情况下处于竞争状态，可以通过JVM参数关闭偏向锁：-XX:-UseBiasedLocking=false，那么程序默认会进入轻量级锁状态。

2. 被加锁的对象，没有真正、或者隐式的调用父类 Object 里边的hashcode方法。（如果一旦调用了object的hashcode方法，那么我们的对象头里边就有真正的hashcode值了，如果偏向锁来进行markword的替换，至少要提供一个保存hashcode的地方吧？可惜的是，偏向锁并没有地方进行markword的保存，只有轻量级锁才会有“displace mark word”）

为了让线程获得锁的代价更低而引入了偏向锁。当一个线程访问同步块并获取锁时，会在对象头和栈帧中的锁记录里（对象头：存储线程id和栈帧中的锁记录里： 线程有自己的栈帧，LOCK RECORD: 存储当前线程id）存储锁偏向的线程ID，以后该线程在进入和退出同步块时不需要进行CAS操作来加锁和解锁，只需简单地测试一下对象头的Mark Word里是否存储着指向当前线程的偏向锁（id的匹配）。如果测试成功，表示线程已经获得了锁。如果测试失败，则需要再测试一下Mark Word中偏向锁的标识是否设置成1（表示当前是偏向锁）：如果没有设置，则使用CAS竞争锁；如果设置了，则尝试使用CAS将对象头的偏向锁指向当前线程（其实是cas竞争替换 线程id）。

## Synchronized锁升级 - 轻量级锁加锁与解锁

轻量级锁加锁

线程在执行同步块之前，JVM会先在当前线程的栈桢中创建用于存储锁记录的空间（Lock Record记录），并将对象头中的Mark Word（前30位 （25位的hashcode，4位的分代年龄，1位是否为偏向锁））复制到锁记录中，官方称为Displaced Mark Word。然后线程尝试使用CAS将对象头中的Mark Word替换为指向锁记录的指针（指向线程栈帧里边的Lock Record的指针）。如果成功，当前线程获得锁，如果失败，表示其他线程竞争锁，当前线程便尝试使用自旋来获取锁。

轻量级锁解锁

轻量级解锁时，会使用原子的CAS操作将Displaced Mark Word（Lock Record记录）替换回到对象头，如果成功，则表示没有竞争发生。如果失败，表示当前锁存在竞争，锁就会膨胀成重量级锁。

真正的锁升级，是依赖于 class 的，而并不是依赖于 某一个 new出来的对象（偏向锁升级为轻量级锁）。

真正的锁升级，是依赖于 当前new出来的对象的（轻量级锁升级为重量级锁）。

轻量级锁升级为重量级锁：这个时候，只要我们的线程发生了竞争，并且CAS替换失败，就会发起锁膨胀，升级为重量级锁（针对的是一个对象实例）。

## Synchronized 锁升级 - 轻量级锁升级为重量级锁

![image-20240713174418356](assets/image-20240713174418356.png)

轻量级锁---重量级锁： 释放锁（前四步）并唤醒等待线程

1. 线程1 初始化monitor 对象；
2. 将状态设置为膨胀中（inflating）；
3. 将monitor里边的header属性，set称为对象的markword；（将自己lock record里边的存放的mark word的hashcode，分代年龄，是否为偏向锁 set 到 objectmonitor对象的header属性里）
4. 设置对象头为重量级锁状态（标记为改为10）；然后将前30位指向第1不他初始化的monitor 对象；（真正的锁升级是由线程1操控的）
5. 唤醒线程2；

线程2 开始争抢重量级锁。（线程2就干了一件事儿，就是弄了一个临时的重量级锁指针吧？还不是最后的重量级锁指针。因为最后的重量级锁指针是线程1初始化的并且是线程1修改的。 而且，线程2被唤醒之后，还不一定能够抢到这个重量级锁。Sync是非公平锁。 线程2费力不讨好，但是线程2做了一件伟大的事情：他是锁升级的奠基者。）

## Synchronized 锁升级 - Markword的转化过程

创建一个对象，此时对象里边没有hashcode，所以该对象可以使用我们的偏向锁，偏向锁不会考虑hashcode，他会直接将自己的线程id放到我们的markword里边，不需要考虑后续的替换问题。 所以呢，一旦我们的对象主动调用了Object的hashcode方法，我们的偏向锁就自动不可用了。

如果我们的对象有了hashcode和分代年龄和是否为偏向锁（30位）。在轻量级锁的状态下，这30位会被复制到我们的轻量级锁线程持有者的栈帧里的lock record里边记录。与此同时，我们的对象的markword里边存放的是我们的指向轻量级锁线程持有者的栈帧的lock recod里。如果一直存在轻量级锁竞争，在未发生锁膨胀的前提下，一直会保持轻量级锁，A线程释放的时候，会将markword替换回对象的markword里边，B线程下次再从新走一遍displace mark word；

一旦发生了轻量级膨胀为重量级锁。前提，A线程持有锁；B线程争抢。

B线程将markword里边A线程的指针替换成一个临时的（过度的）重量级锁指针，为了让A线程在cas往回替换markword的时候失败。

A线程替换回markword失败后，会发起：1.初始化monitor对象；2. 将状态设置为膨胀中；3 将替换失败的 markword放到objectmonitor的head属性里； 4。改变markword的锁标志为10；将markword里的 30 位设置为指向自己第一步初始化的那个monitor对象；5唤醒B线程； 6以后这个对象只能作为重量级锁；

Markword从未丢失。

## 死锁的避免方式

死锁产生的四个必要条件：

互斥：一个资源每次只能被一个进程使用 (资源独立)。

请求与保持：一个进程因请求资源而阻塞时，对已获得的资源保持不放 (不释放锁)。

不剥夺：进程已获得的资源，在未使用之前，不能强行剥夺 (抢夺资源)。

循环等待：若干进程之间形成一种头尾相接的循环等待的资源关闭 (死循环)。

如何避免死锁？

1. 破坏” 互斥” 条件：系统里取消互斥、若资源一般不被一个进程独占使用，那么死锁是肯定不会发生的，但一般 “互斥” 条件是无法破坏的，因此，在死锁预防里主要是破坏其他三个必要条件，而不去涉及破坏 “互斥” 条件。

2. 破坏 “请求和保持” 条件：

   方法 1：所有的进程在开始运行之前，必须一次性的申请其在整个运行过程各种所需要的全部资源。

   优点：简单易实施且安全。

   缺点：因为某项资源不满足，进程无法启动，而其他已经满足了的资源也不会得到利用，严重降低了资源的利用率，造成资源浪费。

   方法 2：该方法是对第一种方法的改进，允许进程只获得运行初期需要的资源，便开始运行，在运行过程中逐步释放掉分配到，已经使用完毕的资源，然后再去请求新的资源。这样的话资源的利用率会得到提高，也会减少进程的饥饿问题。

3. 破坏 “不剥夺” 条件：当一个已经持有了一些资源的进程在提出新的资源请求没有得到满足时，它必须释放已经保持的所有资源，待以后需要使用的时候再重新申请。这就意味着进程已占有的资源会被短暂的释放或者说被抢占了。

4. 破坏 “循环等待” 条件：可以通过定义资源类型的线性顺序来预防，可以将每个资源编号，当一个进程占有编号为 i 的资源时，那么它下一次申请资源只能申请编号大于 i 的资源。

现在我们介绍避免死锁的几个常见方法。

避免一个线程同时获取多个锁。

避免一个线程在锁内同时占用多个资源，尽量保证每个锁只占用一个资源。

尝试使用定时锁，使用lock.tryLock（timeout）来替代使用内部锁机制。

对于数据库锁，加锁和解锁必须在一个数据库连接里，否则会出现解锁失败的情况。

## ObjectMonitor的属性

1. header ： 重量级锁保存markword的地方

2.  own: 指向我们持有锁的线程；对象的markword里边也保存了指向monitor的指针；

3.  _cxq 队列： 竞争队列。 A线程持有锁没有释放； B和C线程同时过来争抢锁，都被block了，此时会将B和C线程加入到 该队列。

4.  EntryList队列：同步队列。A线程释放锁，B和C线程中会选定一个继承者（可以去争抢锁的这个线程），另外一个线程会被放入我们的EntryList队列里边。

5.  waitset：等待队列。Object wait的线程。

A线程持有锁，BC线程过来竞争失败，进入cxq -- 下轮竞争会把 cxq里的线程移动到EntrylIst中。假设B线程竞争到了锁，然后B线程调用了 Object.Wait方法，这时候B线程进入waitset，并释放锁。C线程拿到了锁，然后唤醒B线程。B线程会从waitset里边出来，直接竞争锁。如果竞争失败进入cxq，继续轮回，如果竞争成功，ok了。

## 用户态与内核态

### 什么是CPU的用户态与内核态

CPU 的两种工作状态：内核态（管态）和用户态（目态）。

内核态：
1. 系统中既有操作系统的程序，也有普通用户程序。为了安全性和稳定性，操作系统的程序不能随便访问，这就是内核态。即需要执行操作系统的程序就必须转换到内核态才能执行！

2. 内核态可以使用计算机所有的硬件资源！

用户态：不能直接使用系统资源，也不能改变 CPU 的工作状态，并且只能访问这个用户程序自己的存储空间！

当一个进程在执行用户自己的代码时处于用户运行态（用户态），此时特权级最低，为 3 级，是普通的用户进程运行的特权级，大部分用户直接面对的程序都是运行在用户态。Ring3 状态不能访问 Ring0 的地址空间，包括代码和数据；当一个进程因为系统调用陷入内核代码中执行时处于内核运行态（内核态），此时特权级最高，为 0 级。执行的内核代码会使用当前进程的内核栈，每个进程都有自己的内核栈。

用户运行一个程序，该程序创建的进程开始时运行自己的代码，处于用户态。如果要执行文件操作、网络数据发送等操作必须通过 write、send 等系统调用，这些系统调用会调用内核的代码。进程会切换到 Ring0，然后进入内核地址空间去执行内核代码来完成相应的操作。内核态的进程执行完后又会切换到 Ring3，回到用户态。这样，用户态的程序就不能随意操作内核地址空间，具有一定的安全保护作用。这说的保护模式是指通过内存页表操作等机制，保证进程间的地址空间不会互相冲突，一个进程的操作不会修改另一个进程地址空间中的数据。

### 用户态与内核态切换的触发条件

当在系统中执行一个程序时，大部分时间是运行在用户态下的，在其需要操作系统帮助完成一些用户态自己没有特权和能力完成的操作时就会切换到内核态。

用户态切换到内核态的 3 种方式
（1）系统调用
   这是用户态进程主动要求切换到内核态的一种方式。用户态进程通过系统调用申请使用操作系统提供的服务程序完成工作。例如 fork（）就是执行了一个创建新进程的系统调用。系统调用的机制是使用了操作系统为用户特别开放的一个中断来实现，如 Linux 的 int 80h 中断。
（2）异常
   当 cpu 在执行运行在用户态下的程序时，发生了一些没有预知的异常，这时会触发由当前运行进程切换到处理此异常的内核相关进程中，也就是切换到了内核态，如缺页异常。
（3）外围设备的中断
   当外围设备完成用户请求的操作后，会向 CPU 发出相应的中断信号，这时 CPU 会暂停执行下一条即将要执行的指令而转到与中断信号对应的处理程序去执行，如果前面执行的指令时用户态下的程序，那么转换的过程自然就会是 由用户态到内核态的切换。如硬盘读写操作完成，系统会切换到硬盘读写的中断处理程序中执行后边的操作等。

这三种方式是系统在运行时由用户态切换到内核态的最主要方式，其中系统调用可以认为是用户进程主动发起的，异常和外围设备中断则是被动的。从触发方式上看，切换方式都不一样，但从最终实际完成由用户态到内核态的切换操作来看，步骤有事一样的，都相当于执行了一个中断响应的过程。系统调用实际上最终是中断机制实现的，而异常和中断的处理机制基本一致。
