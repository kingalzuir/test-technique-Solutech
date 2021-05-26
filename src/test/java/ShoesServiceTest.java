import org.javatuples.Pair;
import org.junit.jupiter.api.Test;
import service.ShoesService;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class ShoesServiceTest {


    @Test
    public void NoAvailable(){
        Pair<Integer, Integer> pair1 = new Pair<>(001, 101);
        Pair<Integer, Integer> pair2 = new Pair<>(001, 102);
        Pair<Integer, Integer> pair3 = new Pair<>(002, 102);
        Pair<Integer, Integer> pair4 = new Pair<>(003, 103);
        List<Pair<Integer, Integer>> existingPair = Arrays.asList(pair1, pair2, pair3, pair4);
        List<Integer> available = null;
        Integer left_idShoe = 001;

         List<Integer> expected = null;

        var actual = ShoesService.filter(existingPair,  left_idShoe, available);

        assertEquals(expected,actual);
    }

    @Test
    public void NoLeftShoe(){
        Pair<Integer, Integer> pair1 = new Pair<>(001, 101);
        Pair<Integer, Integer> pair2 = new Pair<>(001, 102);
        Pair<Integer, Integer> pair3 = new Pair<>(002, 102);
        Pair<Integer, Integer> pair4 = new Pair<>(003, 103);
        List<Pair<Integer, Integer>> existingPair = Arrays.asList(pair1, pair2, pair3, pair4);
        List<Integer> available = Arrays.asList(100,101,102);
        Integer left_idShoe = null;

        List<Integer> expected = null;

        var actual = ShoesService.filter(existingPair,  left_idShoe, available);

        assertEquals(expected,actual);
    }


    @Test
    public void Simple1(){
        Pair<Integer, Integer> pair1 = new Pair<>(001, 101);
        Pair<Integer, Integer> pair2 = new Pair<>(001, 102);
        Pair<Integer, Integer> pair3 = new Pair<>(002, 102);
        Pair<Integer, Integer> pair4 = new Pair<>(003, 103);
        List<Pair<Integer, Integer>> existingPair = Arrays.asList(pair1, pair2, pair3, pair4);
        List<Integer> available = Arrays.asList(100, 101, 103);
        Integer left_idShoe = 002;

        List<Integer> expected = Arrays.asList(100, 101, 103);

        var actual = ShoesService.filter(existingPair,  left_idShoe, available);

        assertEquals(expected,actual);
    }

    @Test
    public void AlreadyExistSome(){
        Pair<Integer, Integer> pair1 = new Pair<>(001, 101);
        Pair<Integer, Integer> pair2 = new Pair<>(001, 102);
        Pair<Integer, Integer> pair3 = new Pair<>(002, 102);
        Pair<Integer, Integer> pair4 = new Pair<>(003, 103);
        List<Pair<Integer, Integer>> existingPair = Arrays.asList(pair1, pair2, pair3, pair4);
        List<Integer> available = Arrays.asList(100,101,102);
        Integer left_idShoe = 001;

        List<Integer> expected = Arrays.asList(100);

        var actual = ShoesService.filter(existingPair,  left_idShoe, available);

        assertEquals(expected,actual);
    }
}
