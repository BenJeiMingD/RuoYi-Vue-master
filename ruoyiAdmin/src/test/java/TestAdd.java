import org.junit.jupiter.api.Test;

public class TestAdd {

    @Test
    @MeG
    public void method(){
        System.out.println("true = " + true);
        int num = 6/0;
        try {
            if (num<6){
                System.out.println("num = " + num);
            }
        }catch (Exception e){}
        finally {
            System.out.println("true = " + true);
        }
    }
}
