package service;

import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoesService {
    //private final ShoesRepository shoesRepository;

    public ShoesService() {}

    public List<Integer /*ShoesEntity*/> getRightShoe (String color, String material, String form)
    {
        // get ShoesModel from different table with the Repository
        return null;
    }


    // algorithm: Filter possible right shoe
    // return: the list of right shoes available
    public static List<Integer> filter(List<Pair<Integer, Integer>> existingPair,
                                Integer leftShoe, List<Integer> available)
    {
        if (leftShoe == null || available == null)
            return null;
        else if (available.isEmpty())
            return new ArrayList<>();

        List<Integer> res = new ArrayList<>();

        existingPair = existingPair.stream().filter( pair -> pair.getValue0().equals(leftShoe)).collect(Collectors.toList());
        if (existingPair.isEmpty())
            return available;

        for (var rightShoe: available)
        {
            boolean pairExist = false;
            for (var uniquesPair: existingPair)
            {
                if (uniquesPair.getValue1() == rightShoe)
                {
                    pairExist = true;
                    break;
                }
            }
            if (pairExist != true)
                res.add(rightShoe);
        }
        return res;
    }
}
