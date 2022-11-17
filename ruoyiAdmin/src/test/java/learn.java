import net.sf.jsqlparser.statement.create.table.Index;
import org.apache.ibatis.javassist.expr.NewArray;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class learn {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("b");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());//这样只执行三次
            System.out.println(iterator);//写成这样就无线执行
            System.out.println("单次循环");
        }
    }
}
