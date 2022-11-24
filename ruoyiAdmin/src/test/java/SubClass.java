/**
 * 继承 Factory接口 ，重新他的方法
 */
public class SubClass implements Factory{
    @Override
    public Object getObject() {
        return new User();//返回实体类
    }
}
