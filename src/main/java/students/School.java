package students;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface StudentToString {
  String apply(Student s);
}

class SimplePrompt implements StudentToString {
  @Override
  public String apply(Student s) {
    return "> " + s;
  }
}
public class School {
  public static void showAll(List<?> stuff) {
    for (Object o : stuff) System.out.println(o);
  }

  public static List<String> formatStudents(
      List<Student> roster, StudentToString op) {
    List<String> res = new ArrayList<>();
    for (Student s : roster) {
      res.add(op.apply(s));
    }
    return res;
  }

  public static List<Student> getSmartStudents(
      List<Student> roster, double threshold) {
    List<Student> res = new ArrayList<>();
    for (Student s : roster) {
      if (s.getGpa() > threshold) {
        res.add(s);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    List<Student> roster = Arrays.asList(
        new Student("Fred", 3.2, "Math", "Physics"),
        new Student("Jim", 2.2, "Art"),
        new Student("Sheila", 3.9, "Math", "Physics", "Astrophysics", "Quantum Mechanics")
    );
//    showAll(formatStudents(getSmartStudents(roster, 3.5), new SimplePrompt()));
    showAll(formatStudents(getSmartStudents(roster, 3.5), s -> "> " + s));
  }
}
