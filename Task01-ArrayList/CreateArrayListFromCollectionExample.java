package ArrayList;

import java.util.ArrayList;
import java.util.List;

public class CreateArrayListFromCollectionExample {

    public static void main(String[] args) {
        List<Integer> FiveList = new ArrayList<>();
        FiveList.add(2);
        FiveList.add(3);
        FiveList.add(5);
        FiveList.add(7);
        FiveList.add(11);

        List<Integer> TenList = new ArrayList<>(FiveList);

        List<Integer> nextFiveList = new ArrayList<>();
        nextFiveList.add(13);
        nextFiveList.add(17);
        nextFiveList.add(19);
        nextFiveList.add(23);
        nextFiveList.add(29);

        TenList.addAll(nextFiveList);

        System.out.println(TenList);

    }
}
