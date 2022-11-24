import org.junit.jupiter.api.Test;
public class learn {

    @Test
    public void apk() {
        //SubClass:子类接口的实现
        Factory factory = new SubClass();//多态  接口指向实现类
        User user = (User) factory.getObject();
        System.out.println("user = " + user);
        /*匿名内部类*/
        factory = new Factory() {//new 接口
            @Override//重写方法
            public Object getObject() {
                return new User("张三", 26);//给方法赋值
            }
        };
        User user1 = (User) factory.getObject();
        System.out.println("user1 = " + user1);
        factory =()->{//new 接口
            return new User("李四", 26);//给方法赋值
        };
        User object = (User) factory.getObject();
        System.out.println("user1 = " + object);
    }
}



