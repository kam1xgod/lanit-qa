package com.kami.testcase.animals;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.*;

public class Kotik {
  @Getter @Setter private String name;
  @Getter @Setter private String voice;
  @Getter @Setter private double satiety;
  @Getter @Setter private double weight;

  @Getter
  @Setter(AccessLevel.NONE)
  private static AtomicInteger count = new AtomicInteger(0);

  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  private final int METHODS = 5;

  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  private final int HOURS = 24;

  public Kotik() {
    count.incrementAndGet();
  }

  public Kotik(String name, String voice, double satiety, double weight) {
    this.name = name;
    this.voice = voice;
    this.satiety = satiety;
    this.weight = weight;
    count.incrementAndGet();
  }

  // честно говоря, я бы все этим методы объединил в один, просто передавал бы енам того, чем занят
  // котик, но задание требует разных методов, так что.
  public boolean play() {
    if (satiety > 0) {
      printAction("played");
      satiety--;
      return true;
    }
    askForFood();
    return false;
  }

  public boolean sleep() {
    if (satiety > 0) {
      printAction("slept");
      satiety -= 0.5;
      return true;
    }
    askForFood();
    return false;
  }

  public boolean wash() {
    if (satiety > 0) {
      printAction("washed itself");
      satiety--;
      return true;
    }
    askForFood();
    return false;
  }

  public boolean walk() {
    if (satiety > 0) {
      printAction("walked for some time");
      satiety -= 2;
      return true;
    }
    askForFood();
    return false;
  }

  public boolean hunt() {
    if (satiety > 0) {
      printAction("hunted some smaller animal. Yay! Congratulations");
      satiety -= 3;
      return true;
    }
    askForFood();
    return false;
  }

  public boolean eat() {
    eat(5, "Extra super healthy food for your kitties.");
    return true;
  }

  public boolean eat(int amount) {
    this.satiety += amount;
    return true;
  }

  public boolean eat(int amount, String foodName) {
    this.satiety += amount;
    return true;
  }

  public String[] liveAnotherDay() {
    String[] actions = new String[24];
    for (int i = 0; i < HOURS; i++) {
      switch (new Random().nextInt(METHODS) + 1) {
        case 1:
          if (!play()) {
            eat();
            actions[i] = i + " - ate.";
            break;
          }
          actions[i] = i + " - played.";
          break;
        case 2:
          if (!sleep()) {
            eat();
            actions[i] = i + " - ate.";
            break;
          }
          actions[i] = i + " - slept.";
          break;
        case 3:
          if (!wash()) {
            eat();
            actions[i] = i + " - ate.";
            break;
          }
          actions[i] = i + " - washed itself.";
          break;
        case 4:
          if (!walk()) {
            eat();
            actions[i] = i + " - ate.";
            break;
          }
          actions[i] = i + " - walked.";
          break;
        case 5:
          if (!hunt()) {
            eat();
            actions[i] = i + " - ate.";
            break;
          }
          actions[i] = i + " - hunt.";
          break;
        default:
      }
    }
    return actions;
  }

  private void printAction(String action) {
    System.out.println("Kotik named " + this.name + " have " + action + ".");
  }

  private void askForFood() {
    System.out.println("How dare you! Your kitty is starving. Hurry, feed him!!");
  }
}
