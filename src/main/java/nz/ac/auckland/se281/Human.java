package nz.ac.auckland.se281;

public class Human extends Player{

    public Human(String name) {
        super(name);
        //TODO Auto-generated constructor stub
    }

    @Override
    public int[] play() {
        int fingers = 0;
        int sum = 0;
        int trySuccess = 0;
        do {
        String input = Utils.scanner.nextLine();
        String[] inputArray = input.split(" ");

        try{
            fingers = Integer.parseInt(inputArray[0]);
            sum = Integer.parseInt(inputArray[1]);

            if (fingers >= 1 && fingers <= 5 && sum >= 1 && sum <= 10)
            trySuccess = 1;
            else
                MessageCli.INVALID_INPUT.printMessage();
        } catch (Exception e) {
            MessageCli.INVALID_INPUT.printMessage();
        }
        } while (trySuccess == 0);

        return new int[]{fingers, sum};
    }
    
}
