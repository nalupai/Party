import java.util.Scanner;

public class Party {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Guest name:");
        String name = scanner.next();
        Guest guest = new Guest();
        guest.name = name;
        System.out.printf("%s\n%s joined the Party!\n\n", guest.skin, guest.name);
        boolean wantDance = true;
        while (wantDance) {
            System.out.printf("Wanna dance %s? 1 - yes, 0 - no\n", guest.name);
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    if (guest.energy > 0) {
                        guest.energy = Guest.dance(guest.energy);
                    } else {
                        System.out.printf("%s is away from the dance floor\n", guest.name);
                        wantDance = false;
                    }
                    break;
                case 0:
                    wantDance = false;
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

    static  int danceEnergyDrop(int energy) {
        
        int cost = 5;
        return energy - cost;
    }

    static String dancePowerMessage(int energy) {

        if (energy >= 20) {
            return "what a great time! let's dance!\n";
        } else if (energy >= 10) {
            return "dance! dance!\n";
        } else {
            return "whoah! maybe a drink after this dance?\n";
        }
    }

    static int dance(int energy) {
        
        System.out.println(dancePowerMessage(energy));
        return danceEnergyDrop(energy);
    }
}
