package test.rivky.veig;


import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {

        System.out.println(TransactionUtil.maxSchoolForMonth(Month.FEBRUARY,2022));
        System.out.println(TransactionUtil.maxSchoolForMonth2(Month.FEBRUARY,2022));
    }
}
