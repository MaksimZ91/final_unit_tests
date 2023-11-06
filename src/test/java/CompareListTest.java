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
