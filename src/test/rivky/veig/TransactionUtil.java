package test.rivky.veig;


import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class TransactionUtil {
    private static final String filePath="C:/Rivky/tichnut/secondYear/Java/transactions.csv";

    public static School buildSchool(List<String> l){
        return new School(l.get(0),l.get(1));
    }
    public static Transaction buildTransaction(List<String> l) {
        LocalDate lt = LocalDate.parse(l.get(4), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return new Transaction(l.get(2), l.get(3), lt, l.get(5));
    }

        public static Map<School, List<Transaction>> buildSchoolMap() {
            List<List<String>> all = CSVReader.readFileRows(filePath);
            Map<School, List<Transaction>> map = new HashMap<>();
            List<Transaction> listT;
            for (int i = 1; i < all.size(); i++) {
                School s = buildSchool(all.get(i));
                Transaction t = buildTransaction(all.get(i));

                if (map.containsKey(s))
                    listT = map.get(s);
                else
                    listT = new ArrayList<>();
                listT.add(t);
                map.put(s, listT);
            }
            return map;
        }


////////////////////////////2 options to maxSchoolForMonth method;//////////////////////////////

    public static School maxSchoolForMonth(Month month,int year){
        Map<School,List<Transaction>> map = buildSchoolMap();
        int max=0,count=0;
        School s=null;
        for (Map.Entry<School,List<Transaction>> pair : map.entrySet()){

            count=0;
            for(Transaction i : pair.getValue()){
                if(i.getDate().getMonth()==month&&i.getDate().getYear()==year){
                    count++;
                }
            }
            if(count>max){
                max=count;
                s=pair.getKey();
            }
        }
        return s;

    }

////////////////////////////////////////////jAVA 8/////////////////////////////////////////////////

    public static School maxSchoolForMonth2(Month month,int year) {
        return buildSchoolMap().entrySet().stream().max((i1, i2) -> {
            return (int) i1.getValue().stream().filter(e -> e.getDate().getMonth() == month && e.getDate().getYear() == year).count()
          - (int) i2.getValue().stream().filter(e -> e.getDate().getMonth() == month && e.getDate().getYear() == year).count();
        }).get().getKey();
    }

    }
