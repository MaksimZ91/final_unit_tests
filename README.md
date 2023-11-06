# Урок 6. Юнит тестирование в других языках
Задание 1. Создайте программу на Python или Java, которая принимает два списка чисел и выполняет следующие действия:  
a. Рассчитывает среднее значение каждого списка.   
b. Сравнивает эти средние значения и выводит соответствующее сообщение:  
- ""Первый список имеет большее среднее значение"", если среднее значение первого списка больше.  
- ""Второй список имеет большее среднее значение"", если среднее значение второго списка больше.  
- ""Средние значения равны"", если средние значения списков равны.

  ## Class CompareList
```java
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
```

## Class CompareListTest
```java
import org.example.CompareList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CompareListTest {
    CompareList compareList;

    @BeforeEach
    void setUp(){
        compareList = new CompareList();
    }


    @Test
     void setFirstListTest(){
        int[] arr = {1,2,3,4};
        compareList.setFirstList(arr);
        assertThat(compareList.getFirstList()).isNotEmpty().hasSize(4).isEqualTo(new int[]{1, 2, 3, 4});
    }

    @Test
    void setSecondListTest(){
        int[] arr = {3,2,1};
        compareList.setSecondlist(arr);
        assertThat(compareList.getSecondlist()).isNotEmpty().hasSize(3).isEqualTo(new int[]{3, 2, 1});
    }

    @Test
    void firstListAvgPositive(){
        int[] arr = {3,2,1};
        compareList.setFirstList(arr);
        assertThat(compareList.firstListAvg()).isEqualTo(2);
    }

    @Test
    void firstListAvgNegative(){
        int[] arr = {};
        compareList.setFirstList(arr);
        Exception exc = assertThrows(RuntimeException.class, ()-> compareList.firstListAvg());
        assertEquals(exc.getMessage(), "Список пуст");
    }

    @Test
    void secondListAvgPositive(){
        int[] arr = {5,5,5};
        compareList.setSecondlist(arr);
        assertThat(compareList.secondListAvg()).isEqualTo(5);
    }

    @Test
    void secondListAvgNegative(){
        int[] arr = {};
        compareList.setSecondlist(arr);
        Exception exc = assertThrows(RuntimeException.class, ()-> compareList.secondListAvg());
        assertEquals(exc.getMessage(), "Список пуст");
    }

    @Test
    void compareAvgListsTheFirstIsBigger(){
        int[] first = {1,2,3,4};
        int[] second = {1,2,3};
        compareList.setFirstList(first);
        compareList.setSecondlist(second);
        assertThat(compareList.compareAvgLists()).isEqualTo("Первый список имеет большее среднее значение");
    }

    @Test
    void compareAvgListsTheSecondListIsBigger(){
        int[] first = {1,2,3};
        int[] second = {1,2,3,4};
        compareList.setFirstList(first);
        compareList.setSecondlist(second);
        assertThat(compareList.compareAvgLists()).isEqualTo("Второй список имеет большее среднее значение");
    }

    @Test
    void compareAvgListsAreEqual(){
        int[] first = {2,3,5};
        int[] second = {2,3,5};
        compareList.setFirstList(first);
        compareList.setSecondlist(second);
        assertThat(compareList.compareAvgLists()).isEqualTo("Средние значения равны");
    }

    @Test
    void compareAvgListsListsAreEmpty(){
        int[] first = {};
        int[] second = {2,3,5};
        compareList.setFirstList(first);
        compareList.setSecondlist(second);
        Exception exc = assertThrows(RuntimeException.class, ()-> compareList.compareAvgLists());
        assertEquals(exc.getMessage(), "Список пуст");
    }


}
```
---------------------------------------------------------------------------------------

1.     setFirstListTest(){  
       проверяет положительный сценрий работы сетеров/гетеров для первого массива
       }  

2.     setSecondListTest(){  
       проверяет положительный сценрий работы сетеров/гетеров для второго массива
       }

3.     firstListAvgPositive(){  
       проверяет положительный сценария нахождения среднего значения для первого массива
       }

4.     firstListAvgNegative(){  
       проверяет сценария поведения метода нахожднения среднего значения при пустом первом массиве
       }  

5.     secondListAvgPositive() {  
       проверяет положительный сценария нахождения среднего значения для второго массива
       }

6.     secondListAvgNegative() {  
       проверяет сценария поведения метода нахожднения среднего значения  при пустом втором массиве
       }

7.     сompareAvgListsTheFirstIsBigger() {  
       проверяет положительный сценарий когда средние значение первого массива  > второго
       }

8.     compareAvgListsTheSecondListIsBigger() {  
       проверяет положительный сценарий когда средние значение воторго массива  > первого
       }

9.     compareAvgListsAreEqual() {  
       проверяет  сценарий когда средние значение обоих массивов равны
       }

10.     compareAvgListsListsAreEmpty() {  
        проверяет негативный  сценарий когда один из массивов пуст
        }
![ut_final](https://github.com/MaksimZ91/final_unit_tests/assets/72209139/0da3f5d6-5ffc-485e-a5ea-e494a613290e)

  
