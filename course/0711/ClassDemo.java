public class ClassDemo {
    public static void main(String... args) {
        // 实例化测试
        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(18);
        p1.setSex("女");

        System.out.println(p1);

    }
}

/**
 * 人类
 */
class Person {
    /** 姓名 */   
    private String name;
    /** 年龄 */
    private Integer age;
    /** 性别 */
    private String sex;

    /** 无参构造方法 */
    public Person() {}

    /** 有参构造方法 */
    public Person(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    /** 吃 */
    public void eat() {}

    /** 工作 */
    public void work() {}

    /** 排泄 */
    public void out() {}

    @Override
    public String toString() {
        return new StringBuilder().append("我的名字叫："+this.name)
            .append("\n今年"+this.age+"岁")
            .append("\n我是一个"+this.sex+"生哦！").toString();
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param age the age to set
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }
}