public class ClassDemo {
    public static void main(String... args) {
        // ʵ��������
        Person person1 = new Person();

        System.out.println("Hello");
        System.out.println(person1);

    }
}

/**
 * ����
 */
class Person {
    /** ���� */   
    private String name;
    /** ���� */
    private Integer age;
    /** �Ա� */
    private String sex;

    /** �޲ι��췽�� */
    public Person() {}

    /** �вι��췽�� */
    public Person(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    /** �� */
    public void eat() {}

    /** ���� */
    public void work() {}

    /** ��й */
    public void out() {}

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