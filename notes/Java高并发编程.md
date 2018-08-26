# Java高并发编程

1. 线程安全性
    1. 原子性（互斥访问）
        1. ***package atomic***
            - ***CAS原理, ABA问题(面试)***
            - 常用类
                - LongAdder
                - AtomicLong
                - AtomicReference
                - AtomicStampReference
        2. 锁
            - synchronized(同步锁)，**依赖于JVM**
                - 不可中断锁，适合竞争不激烈情况下使用，可读性好
                - 修饰对象，作用范围，作用对象
                - 修饰代码块，作用于调用对象
                - 修饰方法
                - 修饰静态方法
                - 修饰类
            - lock，**依赖于特殊的CPU指令**
                - 可中断锁，适合竞争激烈情况下使用        
    2. 可见性
        > 参考inside-jvm
        - 线程安全性
            1. 原子性：提供了互斥访问，同一时刻只能有一个线裎来对它进行操作
            1. 可见性：一个线裎对主内存的修改可以及时的被其他线裎观察到
            1. 有序性：一个线裎观察其他线裎中的指令执行顺序，由于指令重排序的存在，该观察结果一般杂乱无序
        - volatile
            - 插入指令屏障，禁用指令重排序
            - 非原子操作，不能保证线程安全性
            - 应用示例
            
                ![volatile](./img/volatile.png)

    3. 有序性
        - 指令重排序
        - 保证有序性
            - volatile, synchronized, lock
        - happens-before原则
            - 程序次序规则
            - 锁定规则
                > 一个unlock操作先行发生于后面对同一个锁的lock操作
            - volatile变量规则
            - 传递规则
            - 线程启动规则
            - 线程中断规则
            - 线程终结规则
            - 对象终结规则    
2.