# Java基础
## 1.1 开发介绍
#### 1.1.1 Java的发展历史
> [参考菜鸟教程 - Java 发展历史](http://www.runoob.com/java/java-intro.html)

#### 1.1.2 Java的应用领域
略

#### 1.1.3 Java语言的特性
> [参考菜鸟教程 - Java 主要特性](http://www.runoob.com/java/java-intro.html)

#### 1.1.4 Java面向对象
> [参考菜鸟教程 - Java 对象和类](http://www.runoob.com/java/java-object-classes.html)

#### 1.1.5 Java性能分类
...

#### 1.1.6 搭建Java环境
> [参考菜鸟教程 - Java 开发环境配置](http://www.runoob.com/java/java-environment-setup.html)

#### 1.1.7 Java工作原理
...



## 1.2 熟悉Eclipse开发工具
#### 1.2.1 Eclipse简介与下载
[官网了解一下](https://www.eclipse.org/downloads/eclipse-packages/)

#### 1.2.2 安装Eclipse的中文语言包
英文多好啊，装什么中文

#### 1.2.3 Eclipse的配置与启动
#### 1.2.4 Eclipse工作台与视图
#### 1.2.5 “包资源管理器”视图
#### 1.2.6 使用Eclipse
#### 1.2.7 使用编辑器编写程序代码


## 1.3 Java语言基础
#### 1.3.1 Java主类结构
```java
public class ClassName {
    /** 程序入口 */
    public static void main(String[] args) {
        // 具体的执行程序
    }
}
```
#### 1.3.2 基本数据类型
|类型|内容空间(bit)|最小值|最大值|默认值|包装类|
|:-|:-:|:-|:-|:-|:-|
|byte|8|Unicode0|Unicode$2^{16}-1$|(byte)0|Byte|
|char|16|-128|+127|'\u0000'|Character|
|short|16|$-2^{15}$|$2^{15}-1$|(short)0|Short|
|int|32|$-2^{31}$|$2^{31}-1$|0|Integer|
|long|64|$-2^{63}$|$2^{63}-1$|0L|Long|
|float|32|IEEE 754|IEEE 754|0.0f|Float|
|double|64|IEEE 754|IEEE 754|0.0d|Double|
|boolean|-|-|-|false|Boolean|
|void|-|-|-|-|Void|
> Tips: The boolean data type has only two possible values: true and false. Use this data type for simple flags that track true/false conditions. This data type represents one bit of information, but its "size" isn't something that's precisely defined.（即与具体的JVM有关，1、4字节都可能）

#### 1.3.3 变量与常量
* 变量: `类型 变量名`
* 常量: 使用关键词 `final` 仅在初始化时可被赋值
* 自定义常量:
    * `123` : 默认为`int`
    * `1.1` : 默认为`double`

#### 1.3.4 Java运算符
* 算数运算符: `+ - * / %`
* 自增自减: `++ --`
* 关系运算符: `== > < >= <= !=`
* 逻辑运算符: `! &&(短路) ||(短路) & |` __注意判定短路现象__
* 按位操作符: `& | ~ ^`
* 移位操作符: `<< >> >>>(无符号右移，高位补0)`
* 三目运算符: `boolean-exp? value0 : value1`
* 赋值操作符: `+= -= *= /=`
* 逗号操作符: `,`

#### 1.3.5 数据类型转换
* 强制类型转换：将希望得到的数据类型置于圆括号中，放在需要进行类型强制转换的的左边`(目标类型) 变量`
* 浮点数->整数：程序默认截断小数点后的尾数，可以使用`Math.round()`完成我们通常认为的四舍五入

#### 1.3.6 代码注释与编码规范
* 单行注释 `//`
* 多行注释 `/* */`
* 文档注释 `/** */`
  * 嵌入HTML
  * 使用文档标签（以@开头）
  * 三种注释类型：类、域和方法

#### 1.3.7 Java帮助文挡
> [下载地址：](http://www.oracle.com/technetwork/java/javase/documentation/jdk8-doc-downloads-2133158.html) http://www.oracle.com/technetwork/java/javase/documentation/jdk8-doc-downloads-2133158.html

## 1.4 Java流程控制
#### 1.4.1 复合语句
#### 1.4.2 条件语句
#### 1.4.3 if条件语句
```java
if(exp1) {
    // exp1 == true    
} else if(exp2) {
    // exp2 == true
} else {
    // all exp* is false
}
```
#### 1.4.4 switch多分支语句
```java
switch(s) {
    case s1:
        // s == s1
        break;
    case s2:
        // s == s2
        break;
    // 可以多个case...
    default:
        // all case is not satified to s
}
```
__注意：__ `s`支持的类型有: `byte short int char String enum`

#### 1.4.5 while循环语句
```java
while(exp) {
    // exp is true
}
// when exp is false, the while will stop
```

#### 1.4.6 do...while循环语句
```java
do {
    // first run the repeat-body, then will verify the exp
} while(exp);
```

#### 1.4.7 for循环语句
```java
// 普通的for循环
int[] val = new int[10];
for(int i=0; i<val.length; i++) {
    // 迭代
    System.out.println(val[i]);
}
// 加强for循环-foreach
for(int tmp: val)
    System.out.println(tmp); 
```
#### 增补1.4.8 break, continue and goto
* __break:__ 跳出当前的循环或条件语句块
* __continue:__ 跳过后面的循环语句块，进行下一次迭代
* __goto:__ 声明label `lab1:`
    * `continue lab1` -> 回到标签处，仍可以进入迭代
    * `break lab1` -> 回到标签处，不能再进入迭代

## 1.5 Java字符串
#### 1.5.1 String类
#### 1.5.2 连接字符串
```java
String a = "A";
String b = "B";
String res = null;
// 1 StringBuffer
StringBuffer sb1 = new StringBuffer();
res = sb1.append(a).append(b).toString();
// 2 StringBuilder
StringBuilder sb2 = new StringBuilder();
res = sb2.append(a).append(b).toString();
// 3 + 拼接
res = a+b;
```
#### 1.5.3 获取字符串信息
#### 1.5.4 常用的字符串操作
* `length()` 获取字符串长度
* `charAt()` 
* `substring()`
* `startWith()`

#### 1.5.5 格式化字符串
`String.format("带格式化标记的字符串", Object[])`
* `%d` 整数
* `%4.1f` 浮点数
* `%s` 字符串

#### 1.5.6 使用正则表达式
#### 1.5.7 字符串生成器
* `StringBuilder`
* `StringBuffer`


## 1.6 Java数组与类和对象
#### 1.6.1 数组概述
#### 1.6.2 一维数组的创建及使用
```java
int[] arr = new int[10]
```
__注意：__ 如果为引用类型数组，则需要通过`new`为每个对象申请空间
#### 1.6.3 二维数组的创建及使用
```java
int[][] arr = new int[10][10];
```

#### 1.6.4 数组的基本操作
#### 1.6.5 数组排序算法
#### 1.6.6 Java的类和构造方法
```java
class A {
    /** 默认无参构造方法 */
    public A() {
    }
}
```
#### 1.6.7 Java的对象、属性和行为
#### 增补 1.6.8 Java类的重载
* 方法的重载：相同的方法名，但其参数类型列表不同

## 1.7 熟悉Eclipse开发工具
#### 1.7.1 数字格式化与运算
#### 1.7.2 随机数与大数据运算
#### 1.7.3 类的继承与Object类 
#### 1.7.4 对象类型的转换
#### 1.7.5 使用instanceof:操作符判断对象类型 
#### 1.7.6 方法的重载与多态
#### 1.7.7 抽象类与接口


## 1.8 I/O与反射、多结程
#### 1.8.1 流概述与File类
#### 1.8.2 文件 输入/输出流 
#### 1.8.3 缓存 输入/输出流
#### 1.8.4 Class类与Java反射
#### 1.8.5 Annotation功能类型信息
#### 1.8.6 枚举类型与泛型
#### 1.8.7 创建、操作线程与线程安全


## 1.9 Swing程序与集合类
#### 1.9.1 常用窗体
#### 1.9.2 标签组件与图标
#### 1.9.3 常用布局管理器与面板
#### 1.9.4 按钮组件与列表组件
#### 1.9.5 常用事件监听器
#### 1.9.6 集合类概述
#### 1.9.7 Set集合与Map集合及接口


## 1.10 PC端网站布局
#### 1.10.1 HTML基础，CSS基础，CSS核心属性
#### 1.10.2 css样式层叠、继承、盒模型
#### 1.10.3 窑器、溢出及元素类型
#### 1.10.4 浏览器兼容与宽高自适应
#### 1.10.5 定缸、锚点与透明
#### 1.10.6 图片整合
#### 1.10.7 表格、CSS属性与滤镜
#### 1.10.8 CSS优化


## 1.11 HTML5 + CSS3基础
#### 1.11.1 HTML5新增的元素与属性
#### 1.11.2 CSS3选择器 
#### 1.11.3 文字字体相关样式
#### 1.11.4 CSS3位移与变形处理
#### 1.11.5 CSS3 2D、3D转换与动画
#### 1.11.6 弹性盒模型
#### 1.11.7 媒体查询 
#### 1.11.8 响应式设计


## 1.12 WebApp页面布局
#### 1.12.1 移动端页面设计规范
#### 1.12.2 移动端切图
#### 1.12.3 文字流式／控件弹性／图片等比例的布局
#### 1.12.4 等比缩放布局
#### 1.12.5	viewport/meta
#### 1.12.6	rem/vw的使用
#### 1.12.7	flexbox详解
#### 1.12.8 移动web特别样式处理


## 1.13 原生JavaScript交亘功能开发
#### 1.13.1	什么是JavaScript
#### 1.13.2	JavaScript使用及运作原理
#### 1.13.3	JavaScript基本语法
#### 1.13.4	JavaScript 内童对象 
#### 1.13.5 事件，事件原理
#### 1.13.6	JavaScript基本特效制作
#### 1.13.7	cookie存储 
#### 1.13.8 正则表达式


## 1.14 Ajax异步交亘
#### 1.14.1	什么是JavaScript
#### 1.14.2	JavaScript使用及运作原理
#### 1.14.3 JavaScript基本语法
#### 1.14.4 JavaScript 内置对象
#### 1.14.5 事件，事件原理
#### 1.14.6	JavaScript基本特效制作
#### 1.14.7	cookie存储 
#### 1.13.8 正则表达式


## 1.15 jQuery应用
#### 1.15.1 各选择器使用及应用优化
#### 1.15.2 Dom节点的各种操作 
#### 1.15.3 事件处理、封装、应用
#### 1.15.4 jQuery中的各类动画使用 
#### 1.15.5 可用性表单的开发
#### 1.15.6 jQuery Ajax、函数、缓存 
#### 1.15.7 JQuery编写插件、扩展、应用 
#### 1.15.8 理解模块式开发及应用


## 1.16 数据库
#### 1.16.1 Mysql数据库
#### 1.16.2 JDBC开发
#### 1.16.3 连接池和DBUtils
#### 1.16.4 Oracle介绍
#### 1.16.5 MongoDB数据库介绍
#### 1.16.6 ApacheO务器／Nginx服务器
#### 1.16.7 Memcached 内存对象缓存系


## 1.17 JavaWeb开发核心
#### 1.17.1 XML技术
#### 1.17.2 HTTP协议
#### 1.17.3 Servlet工作原理解析
#### 1.17.4 深入理解Session与Cookie
#### 1.17.5 Tomcat的系统架构与设计模式
#### 1.17.6 JSP语法与内置对象
#### 1.17.7 JDBC技术
#### 1.17.8 大浏览量系统的静态化架构设计


## 1.18 JavaWeb开发内幕
#### 1.18.1 深入理解Web请求过程
#### 1.18.2 Java I/O的工作机制
#### 1.18.3 Java Web中文编码
#### 1.18.4 Javac编译原理
#### 1.18.5	class文件结构
#### 1.18.6	Classloader工作机制 
#### 1.18.7 JVM 体系结构与工作方式
#### 1.18.8 JVM 内存管理




