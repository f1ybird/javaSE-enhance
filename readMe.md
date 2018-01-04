### java基础知识整理

* 2017/12/19 Object类分析
* 2017/12/20 String类分析
* 2017/12/20 日期、大数值、反射调用静态方法
* 2018/01/01 泛型、反射和代理、多线程
* 2018/01/01 对象和实例，对象的创建
* 2018/01/01 访问控制符
* 2018/01/01 类和代码块初始化
* 2018/01/01 集合类框架list、set、map
* 2018/01/02 集合类框架HashMap、ArrayList

* Java ConcurrentModificationException异常原因和解决方法 

    一.ConcurrentModificationException异常出现的原因
    如果modCount不等于expectedModCount，则抛出ConcurrentModificationException异常。
    
    二.在单线程环境下的解决办法
    使用iterator.remove();代替list.remove();
    Itr类中也给出了一个remove()方法：
    较list.remove()方法多了expectedModCount = modCount;
      
    三.在多线程环境下的解决方法
    1）在使用iterator迭代的时候使用synchronized或者Lock进行同步； 
    2）使用并发容器CopyOnWriteArrayList代替ArrayList和Vector。
    
* 2018/01/04 接口和内部类    