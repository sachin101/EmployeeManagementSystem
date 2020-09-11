import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.joda.time.Interval;

public class Test2 {
   // public static void main(String[] args) throws java.lang.Exception {
    	public static void main(String[] args) {
    	    // TODO Auto-generated method stub


    	    ArrayList<Test2.Interval> list = new ArrayList<Test2.Interval>();


    	    
    	    
    	    list.add(new Test2.Interval("01Jan2014 ", "30Jan2014"));
    	    list.add(new Test2.Interval("15Jan2014 ", "15Feb2014"));
    	    list.add(new Test2.Interval("10Mar2014 ", "15Apr2014"));
    	    list.add(new Test2.Interval("10Apr2014 ", "15May2014")); 

    	    System.out.println("Input Dates");
    	    System.out.print("01Jan2014 "+"\t"+ "30Jan2014"+"\n"+"15Jan2014 "+"\t"+"15Feb2014"+"\n"+"10Mar2014 "+"\t"+"15Apr2014"+"\n"+"10Apr2014 "+"\t"+"15May2014");
    	    
    	    System.out.println();
    	    System.out.println();
    	    
    	    System.out.println("Output Dates");
    	for (Iterator iterator = mergeInterval(list).iterator(); iterator.hasNext();) {
    	    Interval interval = (Interval) iterator.next();

    	    System.out.println(interval.getStart()+ "\t"+interval.getEnd());
    	}


    	}

    	public static List<Interval>  mergeInterval(ArrayList<Test2.Interval> list){

    	    /*
    	     * Sort the list , Interval class have implemented Comparable Interface.
    	     *  So we will get sorted intervals. Intervals sorted based on start of interval
    	     */
    	    Collections.sort(list);
    	    Set<Test2.Interval> resultlist = new TreeSet<Test2.Interval>();

    	    List<Test2.Interval> mergedIntervals = new ArrayList<Test2.Interval>();

    	    //declare date formate to parse and format date from string to and from
    	    SimpleDateFormat sdf = new SimpleDateFormat("ddMMMMyyyy");
    	    if(list.size() == 1){
    	        //resultlist = list
    	        return list;
    	    }
    	    if(list.size() > 1){
    	        // get first interval Object. conside it as first interval
    	        Interval mergeInterval = list.get(0);

    	        // loop other intervals from second in the list
    	        for(int i=1; i< list.size() ; i++){

    	            Interval interval2 = list.get(i);
    	            try{


    	                Date startDate1  = sdf.parse(mergeInterval.getStart());
    	                Date endDate1  = sdf.parse(mergeInterval.getEnd());



    	                Date startDate2  = sdf.parse(interval2.getStart());
    	                Date endDate2  = sdf.parse(interval2.getEnd());


    	                // compare if current interval's start date is before merging interval's end date
    	                // then the two intervals are overlaping
    	                if(startDate2.compareTo(endDate1) < 0 ){

    	                    // check whether end date of current loop interval is after the merging interval.
    	                    // then we need to update the end date of merging interval with looping interval's end date
    	                    if(endDate2.compareTo(endDate1) > 0 ){

    	                        mergeInterval.setEnd(interval2.getEnd());

    	                    }
    	                }else{
    	                    // compare if current interval's start date is after merging interval's end date
    	                    // then it must be a new interval start so swap mergInterval variable with  current looping interval

    	                     mergeInterval = interval2;

    	                }

    	                //add merge interval to set. 
    	                resultlist.add(mergeInterval);
    	            }catch(Exception ex){
    	                ex.printStackTrace();
    	            }

    	        }

    	    }
    	    mergedIntervals.addAll(resultlist);
    	    return mergedIntervals;

    	}

    	public static class Interval implements Comparable<Interval>{

    	    private String start;
    	    private String end;

    	    public String getStart() {
    	        return start;
    	    }
    	    public void setStart(String start) {
    	        this.start = start;
    	    }
    	    public String getEnd() {
    	        return end;
    	    }
    	    public void setEnd(String end) {
    	        this.end = end;
    	    }
    	    public Interval(){



    	            }
    	    public Interval(String start,String end){

    	        this.start = start;
    	        this.end = end;

    	    }
    	        @Override
    	        public boolean equals(Object obj) {
    	            // TODO Auto-generated method stub
    	            Interval inteval = (Interval)obj;
    	            return this.getStart().equals(inteval.getStart()) && this.getEnd().equals(inteval.getEnd()) ;
    	        }

    	    @Override
    	    public int compareTo(Interval o) {
    	        // TODO Auto-generated method stub

    	        SimpleDateFormat sdf = new SimpleDateFormat("ddMMMMyyyy");
    	        try{
    	            Date startDate  = sdf.parse(start);
    	            Date endDate  = sdf.parse(end);
    	            Date pstartDate  = sdf.parse(o.start);
    	            Date pendDate  = sdf.parse(o.end);


    	            return startDate.compareTo(pstartDate);

    	        }catch(Exception ex){
    	            ex.printStackTrace();
    	        }
    	        return 0;
    	    }


    	}}
