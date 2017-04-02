package com.sd.sort.v2;

public class DateComparator implements Comparator{
  public DataComparator(){}
  public int compare(Object o1, Object o2){
    return ((Date) o1).compareTo((Date) o2);
  }
}