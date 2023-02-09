package com.kami.testcase;

import com.kami.testcase.animals.Kotik;

public class Application {
  private static final int HOURS = 24;
  public static void main(String[] args) {
    Kotik first = new Kotik("Jack", "Meow", 6.4, 2.5);
    Kotik second = new Kotik();
    second.setName("Lilly");
    second.setVoice("Meoow");
    second.setSatiety(4.2);
    second.setWeight(2.4);
    String[] jacksActions = first.liveAnotherDay();
    for (int i = 0; i < HOURS; i++) {
      System.out.println(jacksActions[i] + "\n");

    }

    System.out.println("Here's one of your precious kitties: " + second.getName() + " weight: " + second.getWeight() + ". So cute!!");
    System.out.println("Are my kittens talking the same way? " + compareVoice(first.getVoice(), second.getVoice())); 
    System.out.println("You have: " + Kotik.getCount() + " kittens.");
  }

  private static String compareVoice(String voiceOne, String voiceTwo) {
    return voiceOne.equals(voiceTwo) ? "yes" : "no";
  }
}
