import org.junit.jupiter.api.Test;

public class spacel {
    @Test
    public void pool(){
        String po = "6PR~AT26×9.00-12 6PR~ART+TOP-DOG~TL~P350~HB830~";

        //获得第一个点的位置
        int index = po.indexOf("~");
        System.out.println("获得第一个点的位置:"+index);

        //根据第一个点的位置 获得第二个点的位置
        int index2 = po.indexOf("~", index + 1);
        System.out.println("根据第一个点的位置 获得第二个点的位置:"+index2);

        //根据第二个点的位置，截取 字符串。得到结果 result
        String result = po.substring(index+1,index2);
        System.out.println("第二段:"+result);//规格

        int index3 = po.indexOf("~",index2+1);
        String result1 = po.substring(index2+1,index3);
        System.out.println("第三段 = " + result1);//商标

        int index4 = po.indexOf("~",index3+1);
        int index5 = po.indexOf("~",index4+1);
        String result2 = po.substring(index4+1,index5);
        System.out.println("第五段 = " + result2);//花纹



    }
}
