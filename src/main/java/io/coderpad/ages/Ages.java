package io.coderpad.ages;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.time.Instant;

public class Ages {

  public static void main(String[] args) throws URISyntaxException, IOException {

    System.out.println("Calculated via streams:");
    var startStreams = Instant.now();
    AgeStatsStreams.generate("ages.json");
    System.out.println("Duration (ms):" + Duration.between(startStreams, Instant.now()).toMillis());


    System.out.println("Calculated via scanner:");
    var startScanner = Instant.now();
    AgeStatsScanner.generate("ages.json");
    System.out.println("Duration (ms):" + Duration.between(startScanner, Instant.now()).toMillis());

  }

}
