package io.coderpad.ages;

import java.io.IOException;
import java.net.URISyntaxException;

public class Ages {

  public static void main(String[] args) throws URISyntaxException, IOException {

    System.out.println("Calculated via streams:");
    AgeStatsStreams.generate("ages.json");

    System.out.println("Calculated via scanner:");
    AgeStatsScanner.generate("ages.json");

  }

}
