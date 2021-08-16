package io.coderpad.ages;

import java.io.IOException;
import java.net.URISyntaxException;

public class Ages {

  public static void main(String[] args) throws URISyntaxException, IOException {

    System.out.println("hello");

    AgeStatsStreams.generate("agents.json");

  }

}
