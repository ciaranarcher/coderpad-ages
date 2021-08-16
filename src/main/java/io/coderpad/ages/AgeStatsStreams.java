package io.coderpad.ages;


import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.json.JSONObject;

public class AgeStatsStreams {

  public static void generate(String fileName) throws URISyntaxException {

    var file = AgeStatsStreams.class.getClassLoader()
        .getResource(fileName);

    if (file == null) {
      System.out.println("file not found");
    }

    var path = Paths.get(file.toURI());

    Supplier<Stream<JSONObject>> peopleSupplier = () -> {
      Stream<String> lines;
      try {
        lines = Files.lines(path);
        return lines.map(JSONObject::new);
      } catch (IOException e) {
        e.printStackTrace();
        return null;
      }
    };

    var min = peopleSupplier.get().min((Comparator.comparingInt(o -> o.getInt("age"))));
    if (min.isPresent()) {
      var person = min.get();
      System.out.printf("Youngest person: %s %s (%s years)%n", person.getString("first_name"),
          person.getString("last_name"), person.getInt("age"));
    } else {
      System.out.println("No youngest person found");
    }

    var max = peopleSupplier.get().max((Comparator.comparingInt(o -> o.getInt("age"))));
    if (max.isPresent()) {
      var person = max.get();
      System.out.printf("Oldest person: %s %s (%s years)%n", person.getString("first_name"),
          person.getString("last_name"), person.getInt("age"));
    } else {
      System.out.println("No oldest person found");
    }

    var average = peopleSupplier.get().collect(Collectors.averagingInt(o -> o.getInt("age")));

    System.out.printf("Average Age: %s years%n", average);
  }
}
