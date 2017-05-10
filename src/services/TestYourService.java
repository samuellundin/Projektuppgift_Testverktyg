package services;

import java.time.LocalDate;

/**
 * Created by johan on 2017-05-09.
 */
public class TestYourService {
    public static void main(String[] args){
        TestService testService = new TestService();
        LocalDate localDate =  LocalDate.now();


        testService.addTest("Ett prov", localDate, localDate, 10,true, true);

    }
}
