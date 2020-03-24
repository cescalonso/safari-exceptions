package superiterable;

import java.util.Arrays;

public class UseSuperIterable {
  public static void main(String[] args) {
    SuperIterable<String> ss =
        new SuperIterable<>(Arrays.asList("Fred", "Jim", "Sheila"));
//    for (String s : ss) {
//      System.out.println(s);
//    }

//    ss.forEvery(s -> System.out.println("--" + s));
    ss.forEach(s -> System.out.println("--" + s));

    ss
        .map(s -> s.toUpperCase())
        .forEach(s -> System.out.println(s));
    ss
        .map(s -> s.length())
        .forEach(s -> System.out.println(s));

    // what happens if we perform operations but there is
    // nothing in the SuperIterable?
  }
}
