
import org.apache.poi.ss.usermodel.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


class sqltese {

    @Autowired
    public RedisTemplate redisTemplate;
    @Test
    @RequestMapping("/capacity/templatedate/Test")
    void contextLoads() throws ParseException {

        String beginTime=new String("2017-06-09 10:22:22");
        String endTime=new String("2017-06-09 10:22:22");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date sd1=df.parse(beginTime);//2017-06-09 10:22:22
        Date sd2=df.parse(endTime);//2017-05-08 11:22:22

        String nowDay= "2022-12-31";
        Date nowDate =   DateUtil.parseYYYYMMDDDate(nowDay);
        System.out.println(nowDate);
        //22年之前的日期--开始时间在最后一天前
        /*System.out.println(sd2.before(nowDate));//false
        Calendar currCal=Calendar.getInstance();
        int currentYear =currCal.get(Calendar.YEAR);//当前年
        Calendar calendar=Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, currentYear);
        calendar.roll(Calendar.DAY_OF_YEAR,-1);
        Date currYearLast=calendar.getTime();

        System.out.println("i = " + currYearLast);*/



    }
    /*** 获取当年的最后一天

     *@paramyear

     *@return

     */



}
