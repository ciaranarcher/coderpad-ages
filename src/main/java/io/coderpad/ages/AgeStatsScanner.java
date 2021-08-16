package io.coderpad.ages;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.json.JSONObject;

public class AgeStatsScanner {

  public static void generate(String fileName) throws FileNotFoundException {

    String file = "src/main/resources/" + fileName;
    Scanner scanner = new Scanner(new File(file));
    scanner.useDelimiter("\n");

    JSONObject minPerson = null, maxPerson = null;
    int sumAges = 0;
    double count = 0;

    while (scanner.hasNext()) {
      var person = new JSONObject(scanner.next());

      if (minPerson == null || minPerson.getInt("age") > person.getInt("age")) {
        minPerson = person;
      }

      if (maxPerson == null || maxPerson.getInt("age") < person.getInt("age")) {
        maxPerson = person;
      }

      sumAges += person.getInt("age");
      count ++;

    }
    scanner.close();

    System.out.printf("Youngest person: %s %s (%s years)%n", minPerson.getString("first_name"),
        minPerson.getString("last_name"), minPerson.getInt("age"));

    System.out.printf("Oldest person: %s %s (%s years)%n", maxPerson.getString("first_name"),
        maxPerson.getString("last_name"), maxPerson.getInt("age"));

    double averageAge = sumAges / count;

    System.out.printf("Average Age: %s years%n", averageAge);

  }

}
