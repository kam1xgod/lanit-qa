import animals.Kotik;

public class Application {
  private static final int HOURS = 24;
  public static void main(String[] args) {
    Kotik first = new Kotik("Jack", "Meow", 6, 2);
    Kotik second = new Kotik();
    second.setName("Lilly");
    second.setVoice("Meoow");
    second.setSatiety(4);
    second.setWeight(2); String[] jacksActions = first.liveAnotherDay();
    for (int i = 0; i < HOURS; i++) {
      System.out.println(jacksActions[i] + "\n");

    }

    System.out.println("Here's one of your precious kitties: " + second.getName() + " weight: " + second.getWeight() + ". So cute!!");
    System.out.println("Are my kittens talking the same way? " + (compareVoice(first, second) ? "yes" : "no"));
    System.out.println("You have: " + Kotik.getCount() + " kittens.");
  }

  private static boolean compareVoice(Kotik first, Kotik second) {
    return first.getVoice().equals(second.getVoice());
  }
}
