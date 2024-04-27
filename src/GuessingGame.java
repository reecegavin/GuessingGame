import java.util.Random;
import javax.swing.JOptionPane;
import java.util.InputMismatchException;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;
/**
 * The class GuessingGame is a game that generates a random number between 1 and 500. Users have a certain amount
 * of goes to try and guess what this number is . If they are wrong, they are told whether the number is higher or
 * lower than the generated number. If they use up their guesses, the application closes. If they are right, 
 * the are congratulated.
 * 
 * @author: Reece gavin 
 * @Date last modified: 07/03/2018
 * @ID Number: 17197589
 * 
 * 
 ********************************************
 * Step 2 . Dialogs to be deployed
 * Message dialog of type information to display to the user what the game is about 
 * Option dialog of type question asking the user if they want to play
 * Input dialog of type information to get input from user
 * Mesage dialog of type error to show if input is out of range or is anything other than an integer
 * Message dialog of type information to tell user guess is incorrect or correct
 * Message dialog of type warning to tell user maximum amount of guesses has been reached (if applicable)
 *
 ********************************************
 *Step 3.Pseudocode
 * 0.Begin
 * 1.Generate number between 1-500
 * 2.Limit the amount of guesses to x ( x being Any number)
 * 3.Display message dialog describing game to the user
 * 4.Ask user if they want to play
 * 5.Use input dialog to get the input guess from the user
 * 6.If number out of range or input not an integer, throw an exception
 * 7.For each incorrect guess, use a message dialog to display to 
 * the user if guess is correct or if guess is higher or lower than the random number.
 * 8.Repeat steps 5-7 until maximum guesses is reached or correct guess
 * 9. If user guesses the number. Display to them that they guessed it and in how many tries.
 * 
 * 
 * The maximum number of guesses needed to know the correct answer is 8 guesses. 
 * If we guess half the range and then plus or minus half the previous guess,
 * EXAMPLE: Take the secret number to be 435
 * 
 * Guess1 = 250      Returns: Lower
 * Guess2 = 375      Returns: Lower
 * Guess3 = 438      Returns: Higher
 * Guess4 = 406      Returns: Lower
 * Guess5 = 422      Returns: Lower
 * Guess6 = 430      Returns: Lower
 * Guess7 = 434      Returns: Lower
 * Guess8 = 436      Returns: Higher
 * 
 * So therefore it is known that 435 is the number as 436 is higher and 434 is lower.
 */

public class GuessingGame{
    //instance variables
    private final Random randomNumber;
    private static final int Min = 1;
    private static final int Max = 500;
    public static final int totalGuesses = 8;

    public GuessingGame(){
        randomNumber=new Random();
    }

    public static void main(String[] args) {
        playGuessingGame();
    }

    public int randomGenerator(int min, int max){
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return randomNumber.nextInt((max - min) + 1) + min; 
    }

    public static void playGuessingGame(){
        String input; 
        int countGuesses = 0;
        int guess=0;
        boolean continueLoop=true;
        GuessingGame newrandomGenerator = new GuessingGame();
        int secretnumber=newrandomGenerator.randomGenerator(Min,Max);

        if(secretnumber>Max|| secretnumber<Min){
            throw new InputMismatchException ("Secret number is out of range");
        }

        JOptionPane.showMessageDialog(null, "Welcome to the number guessing "
            + "game. In this game you guess a number between 1 and 500"+ "\n You have " + totalGuesses+ " tries to get the right answer","Game information",JOptionPane.INFORMATION_MESSAGE);

        Object[] options = {"Yes",
                "No"};
        int n = JOptionPane.showOptionDialog(null,
                "Do you want to play the guessing game?",
                "Guessing game",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);

        if (n == JOptionPane.NO_OPTION || n == JOptionPane.CLOSED_OPTION) {
            System.exit(0);
        }

        do{
            countGuesses++;

            do{
                try{ 

                    input = JOptionPane.showInputDialog(null,"Guess a number in range 1"
                        + " to 500 " +":","Guess no:" + countGuesses,JOptionPane.INFORMATION_MESSAGE);

                    if(input == null ){

                        System.exit(0);
                    }
                    guess = Integer.parseInt(input);

                    if (guess<=Max && guess>=Min){
                        continueLoop=false;

                    }
                    else if(guess>Max|| guess<Min){
                        throw new InputMismatchException ("Integer is out of range.");
                    }

                }catch(InputMismatchException e2) { // Something other than a number

                    JOptionPane.showMessageDialog(null, "Please enter only number in the range 1 - 500","Error",JOptionPane.ERROR_MESSAGE);
                    continueLoop=true;
                }    
                catch (NumberFormatException e1) { // Range check

                    JOptionPane.showMessageDialog(null, "Please enter only integers","Error",JOptionPane.ERROR_MESSAGE);
                    continueLoop=true;
                }  
            }while(continueLoop);

            if (guess == secretnumber) {
                JOptionPane.showMessageDialog(null, "HOOARAY!  Perfect - you "
                    + "guessed the number " + secretnumber + " in "
                    + countGuesses + " guesses.","Correct guess",JOptionPane.INFORMATION_MESSAGE);
            } 

            else if(guess != secretnumber) {
                if(guess>secretnumber){
                    JOptionPane.showMessageDialog(null, "Incorrect -  Your guess it higher than the "
                        + "secret number.Please guess again..","Incorrect guess",JOptionPane.INFORMATION_MESSAGE);   
                }

                else  {
                    JOptionPane.showMessageDialog(null, "Incorrect -  Your guess it lower than the "
                        + "secret number. Please guess again..","Incorrect guess",JOptionPane.INFORMATION_MESSAGE); 

                }

                if(countGuesses>=totalGuesses){
                    JOptionPane.showMessageDialog(null,"The maximum amount of guesses has been reached."+ " The secret number was "
                        + secretnumber + "\nThe program will now close", "Max guesses reached",JOptionPane.WARNING_MESSAGE);
                    System.exit(0);
                }
            }

        } while (secretnumber != guess );
    }
}
