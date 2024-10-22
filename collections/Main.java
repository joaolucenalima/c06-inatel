package collections;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Main {
  public static void main(String[] args) {

    List doubleList = new ArrayList();
    Random random = new Random();

    for (int i = 0; i < 5; i++) {
      doubleList.add(random.nextDouble());
    }

    Collections.sort(doubleList, Collections.reverseOrder());

    for (int i = 0; i < doubleList.size(); i++) {
      System.out.println(doubleList.get(i));
    }
  }
}
