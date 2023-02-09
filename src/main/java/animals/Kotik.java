package animals;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Kotik {
  private String name;
  private String voice;
  private int satiety;
  private int weight;
  
  private static Integer count = 0;

  private final int METHODS = 5;

  private final int HOURS = 24;

  public Kotik() {
    count++;
  }

  public Kotik(String name, String voice, int satiety, int weight) {
    this.name = name;
    this.voice = voice;
    this.satiety = satiety;
    this.weight = weight;
    count++;
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
      satiety -= 2;
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getVoice() {
    return voice;
  }

  public void setVoice(String voice) {
    this.voice = voice;
  }

  public int getSatiety() {
    return satiety;
  }

  public void setSatiety(int satiety) {
    this.satiety = satiety;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public static AtomicInteger getCount() {
    return count;
  }
}
