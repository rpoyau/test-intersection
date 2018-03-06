package application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Utils {
    
    static public Collection<Integer> generateRandomIntList(final int size) {
        final Collection<Integer> result = new ArrayList<Integer>(size);

        Random r = new Random();
        for (int i = 0; i < size; i++) {
            result.add(r.nextInt());
        }

        return result;

    }

}
