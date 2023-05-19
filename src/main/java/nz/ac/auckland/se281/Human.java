package nz.ac.auckland.se281;

public class Human extends Player {

  public Human(String name) {
    super(name);
  }

  @Override
  public int[] play() {
    // initialize fingers and sum
    int fingers = 0;
    int sum = 0;

    // loop for valid input
    int trySuccess = 0;
    do {
      // parse input into array
      String input = Utils.scanner.nextLine();
      String[] inputArray = input.split(" ");

      try {
        // try to parse input into int
        fingers = Integer.parseInt(inputArray[0]);
        sum = Integer.parseInt(inputArray[1]);

        // validate parsed input
        if (fingers >= 1 && fingers <= 5 && sum >= 1 && sum <= 10)
          trySuccess = 1;
        else
          MessageCli.INVALID_INPUT.printMessage();
      } catch (Exception e) {
        MessageCli.INVALID_INPUT.printMessage();
      }
    } while (trySuccess == 0);

    return new int[] { fingers, sum };
  }

}
