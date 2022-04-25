import java.util.Scanner;

public class Party {

    public static void main(String[] args) {

        Drink drink1 = new Drink();
        Drink drink2 = new Drink("Time Warp", 50);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Guest name:");
        String name = scanner.next();
        Guest guest = new Guest();
        guest.name = name;
        System.out.printf("%s\n%s joined the Party!\n\n", guest.skin, guest.name);

        boolean party = true;
        while(party) {
            System.out.printf("1. Dance with %s\n", guest.name);
            System.out.println("2. How many times did you dance?");
            System.out.printf("3. Choose a drink for %s!\n", guest.name);
            System.out.printf("0. Bye, %s!\n", guest.name);
            int option = scanner.nextInt();
            switch(option) {
                case 1:
                    if (guest.energy > 0) {
                        guest.energy = Guest.dance(guest.energy);
                        guest.incrementValueOfDanceCounter();
                    } else {
                        System.out.printf("%s is away from the dance floor\n", guest.name);
                        party = false;
                    }
                    break;
                case 2:
                    System.out.println(guest.giveValueOfDanceCounter());
                    break;
                case 3:
                    System.out.println("1 - Blink, 2 - Time Warp, 0 - I changed my mind");
                    option = scanner.nextInt();
                    switch(option) {
                        case 1:
                            System.out.printf("%s feels a little tipsy from the %s (\\|) ^_^ (|/)\n\n", guest.name, drink1.name);
                            guest.energy += drink1.power;
                            break;
                        case 2:
                            System.out.printf("%s feels a little tipsy from the %s (\\|) ^_^ (|/)\n\n", guest.name, drink2.name);
                            guest.energy += drink2.power;
                            break;
                        case 0:
                            System.out.println("Maybe next time!\n");
                            break;
                        default:
                            System.out.printf("OOOOPS! No drink for %s!\n\n", guest.name);
                    }
                    break;
                case 0:
                    party = false;
                    break;
                default:
                    System.out.println("something went wrong\n");
            }
        }
    }
}

class Guest {

    String name;
    String skin = """

         /\\
        ( /     O O     ()
         \\\\   _ | | _   /
          \\/          \\/
         /-|   = v =   |-\\
        / /-\\         /-\\ \\
         / /-'-------'-\\ \\
          /             \\  
          """;
    int energy = 25;
    
    private int danceCounter = 0;

    int giveValueOfDanceCounter() {

        return danceCounter;
    }

    int incrementValueOfDanceCounter() {

        return danceCounter++;
    }

    static int danceEnergyDrop(int energy) {
        
        int cost = 5;
        return energy - cost;
    }

    static String dancePowerMessage(int energy) {

        if (energy >= 20) {
            return "what a great time! let's dance!\n(\\|) ._. (|/)\n";
        } else if (energy >= 10) {
            return "dance! dance!\n(|/) ._. (\\|)\n";
        } else {
            return "whoah! maybe a drink after this dance?\n(||) ._. (||)\n";
        }
    }

    static int dance(int energy) {
        
        System.out.println(dancePowerMessage(energy));
        return danceEnergyDrop(energy);
    }
}
