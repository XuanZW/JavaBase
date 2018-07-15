# 2018-07-14 作业

## 自定义MyString类
[点击查看自定义String类](./MyString.java)

## Java关键字总结
* 基本数据类型(8)
    * `byte` 
    * `short` 
    * `int` 
    * `long`  
    * `float` 
    * `double` 
    * `char` 
    * `boolean`

* 访问控制(3)
    * `public` 以应用于类、方法或字段（在类中声明的变量）的访问控制修饰符，任何位置的程序都可以访问
    * `protected` 应用于类、方法或字段（在类中声明的变量）的访问控制修饰符，仅能在本类和子类中被访问
    * `private` 应用于类、方法或字段（在类中声明的变量）的访问控制修饰符，仅能在本类中被访问

* 类、方法和变量修饰符(13)
    * `class` 声明类
    * `new` 创建实例
    * `static` 声明静态方法或变量
    * `abstract` 声明抽象类或方法
    * `extends` 继承
    * `interface` 声明接口
    * `implements` 实现接口
    * `final` 声明为最终状态
    * `native` 使用本地方法，非Java语言实现
    * `strictfp` 一旦使用了strictfp来声明一个类、接口或者方法时，那么所声明的范围内Java的编译器以及运行环境会完全依照浮点规范IEEE-754来执行
    * `synchronized` 应用于方法或语句块，并为一次只应由一个线程执行的关键代码段提供保护
    * `transient` 应用于类的成员变量，以便指出该成员变量不应在包含它的类实例已序列化时被序列化
    * `volatile` 表示可以被多个线程异步修改的成员变量

* 程序控制(12)
    * `if` 条件
    * `else` 当if条件不满足时
    * `for` 迭代循环、增强foreach
    * `do` 搭配while成为do...while循环
    * `while` 循环
    * `switch` 根据值选择执行
    * `case` 定义一个值供switch选择
    * `default` switch无可选值时的选择
    * `break` 终止循环
    * `continue` 终止本次循环，进行下一次的循环
    * `return` 终止当前程序并返回
    * `instanceof` 判断是否是某一个类的实例或其子类的实例

* 错误处理(6)
    * `try` 包含可能出现异常的代码块
    * `catch` 捕获异常并处理
    * `finally` 出现异常或return后都一定会执行的代码块
    * `throws` 本方法不处理此类异常，向调用处抛出
    * `throw` 抛出一个异常
    * `assert` 断言

* 包相关(2)
    * `import` 导入类
    * `package` 声明包名

* 变量引用(3)
    * `this` 本类引用
    * `super` 父类引用
    * `void` 无返回值

* 保留字(3)
    * `const` 
    * `goto` 跳转至程序中的某处继续执行（搭配`lable:`和`continue|break`使用）
    * `null` 声明空变量 
    * `true` boolean类型的true
    * `false` boolean类型的false

## String不可被修改的原因
阅读JDK源码可知，Java使用`private final char[] value`存储String的字符数据，因此不可修改。

## 继承的限制
* Java类只允许单继承，允许多层继承，不允许多重继承（同一个类继承于多个类）
* 子类不能访问父类的私有属性和私有方法

## 构造方法的执行顺序
先执行父类的构造方法，后执行本类的构造方法

## 四数求和
[点击查看具体实现](./Works.java)

