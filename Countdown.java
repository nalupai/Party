public class Countdown {

    public static void main(String[] args) throws InterruptedException {

        Countdown countdown = new Countdown();

        for (int i = 10; i >= 0; i--) {
            countdown.animation(String.valueOf(i));
            Thread.sleep(900);
        }

        System.out.println("\u001B[31m\r!! TIME FOR THE PARTY !!\u001B[0m");
    }

    private String existingLine = "";

    public void print(String line) {
        
        if (existingLine.length() > line.length()) {

            String eraserLine = "";

            for (int i = 0; i < existingLine.length(); i++) {
                eraserLine += " ";
            }

            if (eraserLine.length() > 1)
                System.out.print("\r" + eraserLine);
        }

        System.out.print("\r" + line);
        
        existingLine = line;
    }

    private int crabPosition;

    public void animation(String line) {

        switch (crabPosition) {
            case 1:
                print("\u001B[35m (\\|) ._. (|/) " + line + "\u001B[0m");
                break;
            case 2:
                print("\u001B[36m (|/) ._. (\\|) " + line + "\u001B[0m");
                break;
            case 3:
                print("\u001B[32m (\\/) ._. (\\/) " + line + "\u001B[0m");
                break;
            default:
                crabPosition = 0;
                print("\u001B[34m (||) ._. (||) " + line + "\u001B[0m");
        }
        crabPosition++;
    }
}
