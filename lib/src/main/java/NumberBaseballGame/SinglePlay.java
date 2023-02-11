package NumberBaseballGame;

import java.util.*;

// Try to run this code on my school folder

public class SinglePlay {

    // initialize ans, strike, and ball
    int strike, ball;

    // initialize an array list for random number and guess
    ArrayList<Integer> ans, guess = new ArrayList<>();

    public static void main(String[] args) {
        SinglePlay first = new SinglePlay();
    }

    // Initialize all variables and executes functions for proceeding the game
    SinglePlay(){
        // set the values for the int variables
        strike = 0;
        ball = 0;
        // call functions to proceed
        randomList();
        gameStart();
        gamePlay();
    }

    // generate a random 4-digits number (= ans) and return
    public void randomList(){

        // import random function
        Random random = new Random();

        // generate 4 random numbers and add them to the list
        for (int i = 0; i < 4; i ++){
            int int_random = random.nextInt(10); // bound is 10
            ans.add(int_random);
        }
    }

    // prepare for the game (set up and show instruction):
    public void gameStart(){
        // print the welcome message
        System.out.println("Welcome to play NUMBER BASEBALL ! ");

        // ask if need instruction
        System.out.println("\n Do you want to read the instruction? Please type (Yes / No) ");


        // import Scanner to get the user input and get the input
        Scanner sc = new Scanner(System.in); // System.in is a standard input stream
        String userInput = (sc.nextLine()).toLowerCase();

        // if the input is "yes" then print the instruction
        if (userInput == "yes") {
            System.out.println("---------------------------- Instruction ----------------------------");
            System.out.println(" Summary: you need to guess the 4-digits mystery number " +
                    "\n that the computer generates" +
                    "\n" +
                    "\n 1. Input the each digit of the mystery number one by one" +
                    "\n 2. Once you input one digit please press 'enter' to input the next digit" +
                    "\n 3. If you get the digit and number then your score is strike." +
                    "\n    If you get the number but different digit then your score is ball" +
                    "\n 4. For example, if the mystery number is 3819 and your input is 3082," +
                    "\n    then your score is 1 strike and 1 ball." +
                    "\n 5. If you get 4 strikes in 8 trials then you are the WINNER !" +
                    "\n    But if you don't then you will be the LOSER :'( " +
                    "\n");
            System.out.println("----------------------------- GOOD LUCK -----------------------------");
        }
        // if the input is "no" then start the game
        else{
            System.out.println(" Then the game will start soon :) ");
        }
    }

    // start the game:
    public void gamePlay(){
        System.out.println("Now the game starts !");

        // set the trial
        int trial = 1;

        // set up for getting the user's input
        Scanner sc = new Scanner(System.in);

        // 8 trials are given but if the user gets 4 strikes then the game ends:
        while ((strike <= 3) || trial < 9){

            // each trial:
            // ask the user to input the guessing number (= guess)
            for (int n_th = 1; n_th < 5; n_th++) {
                System.out.println(" Please input the " + n_th + "th digit:");

                // get the user's input and
                int userInput = sc.nextInt();

                // check the number of digit by converting int to str (check length)
                String inputString = Integer.toString(userInput);
                int size = inputString.length();

                // if the user input is not int &
                // more than 1 digit then ask the user to input again
                if ( size != 1){
                    System.out.println("Please input the digit again");
                    userInput = sc.nextInt();
                }
                // if the digit is 1, then add to the guess list
                else{
                    // add it to the guess array list
                    guess.add(userInput);
                }

                // if it has the same location & same number ->  count strike + !
                if (guess.get(n_th) == ans.get(n_th)){
                    strike += 1;
                }
            }

            // if it has the same number but diff location -> count ball + 1
            // check if any of number from the guess list is in the ans list
            for (Object i : guess){
                boolean have = ans.contains(i);
                if (have){
                    ball += 1;
                }
            }

            // show the result of n th trial:
            System.out.println( trial + "th result is : " + strike + " strike (s) and "
                    + ball + " ball(s) !");

            // after all these steps, increase the number of trial
            trial += 1;

            // otherwise pass

            // if it gets 4 strikes before 8th trial, then print congrats message
            if ((trial < 9) && (strike == 4)){
                System.out.println("Congratulation ! WELL DONE !! YAYYYY ;)");
                break;
            }
            else{
                System.out.println("Try again...");
            }
        }

        System.out.println("AIYA you lost this game... Try again next time");
    }

}
