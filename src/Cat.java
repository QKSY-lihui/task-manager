public class Cat extends Animal{

    public Cat(String name) {
        super(name);//调用父类的构造方法
    }

    @Override
    public void makeSound() {
        System.out.println(name + "喵喵叫！");
    }
}
