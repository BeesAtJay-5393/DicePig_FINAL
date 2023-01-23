import java.util.Scanner;

public class Player {
    private String name;
    private int points;

    public Player(){
        name = "Player";
        points = 0;
    }

    public Player(String name){
        this.name = name;
        points = 0;
    }

    //Developer Notes:
    //  Here, we need to find a way to get the CLASS Player to have access
    //  to the CLASS Die.

    //The above statement is incorrect.

    public String getName(){
        return this.name;
    }

    public int getPoints(){
        return this.points;
    }

    public void addPoints(int roundPoints){
        this.points += roundPoints;
    }

    public void takeTurn(int playerNum){
        Scanner scan = new Scanner(System.in);
        //Surely there is a more efficient way to have a Die OBJECT
        //Instead of creating one every time we call this METHOD
        
        //UPDATE: Instead of creating a DIE CLASS everytime we take a turn,
        //        We can create one per PLAYER.
        //        In doing so, we remove the waste of space and/or time
        //        For creating that CLASS everytime.
        Die die = new Die();
        String response;
        int roundPoints = 0, num = 0;


        System.out.println("Player " + playerNum + ", " + this.name + ", ");
        System.out.println("You have " + this.getPoints() + " final points.");
        System.out.println("You currently have " + roundPoints + " points this round.");
        System.out.println("Would you like to roll the dice?");

        response = scan.nextLine().toLowerCase();
        while (response.equals("yes") || response.equals("y")){
            num = die.roll();
            System.out.println("You rolled: " + num);
            if (num == 1) {
                System.out.println("Better luck next time!");
                break;
            }
            else {
                roundPoints += num;
            }

            System.out.println(this.name + ", you now have " + roundPoints + " points this round.");
            System.out.println("Would you like to roll the dice again?");
            response = scan.nextLine().toLowerCase();
        }

        //The next line adds the final points from the round to the CLASS
        //VARIABLE for storage.
        if (num != 1) {
            this.addPoints(roundPoints);
        }

        System.out.println("TURN END!");
    }

    public boolean checkWinner(){
        return this.points >= 100;
    }
}
