//Toobejay Yaaj
//Steve Hughes
//CS245
//1/22/23

public class Main {
    public static void main(String[] args) {

        //Create an CLASS OBJECT that represents the player as they both will share the
        //same METHODS and VARIABLES. (We wouldn't want to copy and paste, would we?)
        Player player1 = new Player("John");
        Player player2 = new Player("Sarah");

        boolean win = false;

        while (!win) {
            player1.takeTurn(1);
            if (player1.checkWinner()) {
                System.out.println("Player 1 wins!");
                break;
            }

            player2.takeTurn(2);
            if (player2.checkWinner()){
                System.out.println("Player 2 wins!");
                break;
            }
        }
    }
}