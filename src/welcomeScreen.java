
import static OK_ExitButton.cancelButton;
import java.util.Random;
import javax.swing.JOptionPane;
import java.util.InputMismatchException;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class welcomeScreen extends JFrame {
    private JLabel welcomeScrn;


public welcomeScreen()
{
super("Guessing Game");
setLayout(new FlowLayout());


welcomeScrn = new JLabel("<html>Welcome to the number guessing "
            + "game.<br> In this game you guess a number between 1 and 500<br>"+ "\n You have " + GuessingGame.totalGuesses+
        " \n guesses to get the right answer</br></html>", SwingConstants.CENTER);
add(welcomeScrn);
 
OK_ExitButton.cancelButton=new JButton("Cancel");
add(OK_ExitButton.cancelButton);


}
}