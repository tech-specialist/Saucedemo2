import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class SecondTest {
    //КРАТНО 3, ВОЗВРАЩАТЬ 'Т'
    //КРАТНО 5, ВОЗВРАЩАТЬ 'М'
    //КРАТНО 3 И 5, ВОЗВРАЩАТЬ 'TIM'
    //ВОЗВРАЩАТЬ 'FAIL'
    public String trialCode(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "TIM";
        } else if (number % 5 == 0) {
            return "M";
        } else if (number % 3 == 0) {
            return "T";
        } else return "FAIL";
    }


    @Test
    public void timTest() {
        String actualResult = trialCode(9);
        assertEquals("T", actualResult);
    }


    @Test
    public void timTest2() {
        String actualResult = trialCode(25);
        assertEquals("M", actualResult);
    }

    @Test
    public void timTest3() {
        String actualResult = trialCode(15);
        assertEquals("TIM", actualResult);
    }

    @Test
    public void timTest4() {
        String actualResult = trialCode(2);
        assertEquals("FAIL", actualResult);
    }
}
