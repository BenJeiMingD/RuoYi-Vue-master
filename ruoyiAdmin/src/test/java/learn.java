import org.apache.velocity.runtime.directive.Foreach;
import org.hibernate.validator.internal.engine.constraintvalidation.PredefinedScopeConstraintValidatorManagerImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
    @Test
    public void Thread(){
        //正常使用多线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                Integer num = 20;
                if (num==20){
                    String name = Thread.currentThread().getName();
                    System.out.println(name+"线程1");
                }
            }
        }).start();
        //使用 lambda 启动多线程  name 会打印线程方法
        new Thread(()-> {
            String name = Thread.currentThread().getName();
                System.out.println(name+"线程2");
        }
        ).start();
    }
    @Test
    public void Predicate(){
        List<String> objects = new ArrayList<>();
            objects.add("张三丰");
            objects.add("张一鸣");
            objects.add("李白");
            objects.add("李太白");
            objects.add("李不易");

            /*
            方式 1：
        List<String> listA = new ArrayList<>();
            //输出三个字的 李 姓名
        for (String s : objects) {
            if (s.startsWith("李")){//存储以 李 开始的数据
                listA.add(s);
            }
        }
        List<String> listB = new ArrayList<>();
        for (String s:listA){ //筛选 长度为 3 的数据
            if (s.length()==3){
                listB.add(s);
            }
        }
        for (String s :listB){
            System.out.println("s = " + s);//遍历输出
        }*/
            objects.stream()
                    .filter(name ->name.startsWith("李"))
                    .filter(name ->name.length() == 3)
                    .forEach(name -> System.out.println("name = " + name));


    }


}



