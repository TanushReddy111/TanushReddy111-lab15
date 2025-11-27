import javax.swing.*;

public class EnigmaGUI {

    public static void main(String[] args){

        EnigmaFrame en= new EnigmaFrame();
        en.setTitle("           Enigma GUI");
        
        en.setLocation(200, 200);
        en.setSize(500, 300);
        en.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        en.setVisible(true);
        en.pack();

    }
}