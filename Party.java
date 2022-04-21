import java.util.Scanner;

public class Party {

    public static void main(String[] args) {

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
            System.out.printf("0. Bye, %s!\n", guest.name);
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    if (guest.energy > 0) {
                        guest.energy = Guest.dance(guest.energy);
                        guest.danceCounter++;
                    } else {
                        System.out.printf("%s is away from the dance floor\n", guest.name);
                        party = false;
                    }
                    break;
                case 2:
                    System.out.println(guest.danceCounter);
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
    int danceCounter = 0;

    static  int danceEnergyDrop(int energy) {
        
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
