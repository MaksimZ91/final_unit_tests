package org.example;
import java.util.Arrays;

public class CompareList {
    private int[] firstList ;
    private int[] secondlist;

    public CompareList() {
        this.firstList = new int[]{};
        this.secondlist = new int[]{};
    }
    public double firstListAvg(){
        if (firstList.length == 0 )
            throw  new RuntimeException("Список пуст");
        return (double) Arrays.stream(firstList).sum() / firstList.length;
    }

    public int[] getFirstList() {
        return firstList;
    }

    public void setFirstList(int[] firstList) {
        this.firstList = firstList;
    }

    public int[] getSecondlist() {
        return secondlist;
    }

    public void setSecondlist(int[] secondlist) {
        this.secondlist = secondlist;
    }
    public double secondListAvg(){
        if (secondlist.length == 0 )
            throw  new RuntimeException("Список пуст");
        return (double) Arrays.stream(secondlist).sum() / secondlist.length;    }
    public String compareAvgLists(){
        if(firstListAvg() == secondListAvg())
            return "Средние значения равны";
        if(firstListAvg() > secondListAvg())
            return "Первый список имеет большее среднее значение";
        return "Второй список имеет большее среднее значение";
    }
}
