public class Dog extends Animal{

    public Dog(String name) {
        super(name);//调用父类的构造方法
    }

    @Override
    public void makeSound() {
        System.out.println(name + "汪汪叫！");
    }
}
