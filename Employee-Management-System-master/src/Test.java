
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;


public class Test {

    public static List<LocalDate> getDateRange(LocalDate start, LocalDate end) {

        List<LocalDate> ret = new ArrayList<LocalDate>();
        LocalDate tmp = start;
        while(tmp.isBefore(end) || tmp.equals(end)) {
            ret.add(tmp);
            tmp = tmp.plusDays(1);
        }
        return ret;
    }

    public static void main(String[] args) {

    	LocalDate start = LocalDate.parse("2014-1-1");
        System.out.println("Start: " + start);

        LocalDate end = LocalDate.parse("2014-5-15");
        System.out.println("End: " + end);
        
        List<LocalDate> between = getDateRange(start, end);
        
        //if(start ==LocalDate.parse("2014-1-1")&& end ==LocalDate.parse("2014-1-15"))
   	    System.out.println();
        
        
        for (LocalDate d : between) {
           
        	
        	System.out.println("Start"+d+"\t "+"End");
        }
    }
}