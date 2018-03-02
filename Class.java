public class Class extends AbstractClass
{
    public Class(){
        f1 = 42;
        f2 = 42;
    }
    public void method(){
        System.out.println("Is there meaning to life?");
    }
    public boolean compare(AbstractClass other){
        return f1 > other.f1;
    }
}
