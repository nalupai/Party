import java.util.Scanner;

public class Party {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Guest name:");
        String name = scanner.next();
        Guest guest = new Guest();
        guest.name = name;
        System.out.printf("%s\n%s joined the Party!", guest.skin, guest.name);
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
}
