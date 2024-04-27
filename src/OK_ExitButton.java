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

public class OK_ExitButton extends JButton{
    public static JButton cancelButton;
    public JButton okButton;
    
    public OK_ExitButton()
    {
        cancelButton=new JButton("Cancel");
        //add(cancelButton);
        
        //okButton= new JButton("Ok");
    }
    
}
