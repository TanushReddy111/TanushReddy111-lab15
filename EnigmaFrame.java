import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;
import javax.swing.*;


public class EnigmaFrame extends JFrame{

    JComboBox<Integer> innerCombo = new JComboBox<>();
    JComboBox<Integer> middleCombo = new JComboBox<>();
    JComboBox<Integer> outerCombo = new JComboBox<>();

    JButton encryptButton = new JButton("Encrypt");
    
    JButton decryptButton = new JButton("Decrypt");

    JTextField initalPositionText = new JTextField("EST",5);
    JTextArea  inputTextArea = new JTextArea(5, 50);

    JTextArea outputArea = new JTextArea(5,50);


    public EnigmaFrame(){
        addcomponents();
        encryptButton.addActionListener((e)->{
            performEncryption();
        });
        decryptButton.addActionListener((e)->{
            performDecryption();
        });

    }

    private void performEncryption() {
        String positionText = initalPositionText.getText();
        
        int inner = ((Integer) innerCombo.getSelectedItem());
        int middle = ((Integer) middleCombo.getSelectedItem());
        int outer = ((Integer) outerCombo.getSelectedItem());
        
        Enigma enigma = new Enigma(inner, middle, outer, positionText);
        
        String encrypted = enigma.encrypt(inputTextArea.getText());
        
        outputArea.setText(encrypted);
    }


    private void performDecryption(){

       String positionText = initalPositionText.getText();
        
        int inner = ((Integer) innerCombo.getSelectedItem());
        int middle = ((Integer) middleCombo.getSelectedItem());
        int outer = ((Integer) outerCombo.getSelectedItem());
        
        Enigma enigma = new Enigma(inner, middle, outer, positionText);
        
        String decrypted = enigma.decrypt(inputTextArea.getText());
        
        outputArea.setText(decrypted);
    }


    public void addcomponents()
    {
        encryptButton.setBackground(Color.LIGHT_GRAY);
        decryptButton.setBackground(Color.LIGHT_GRAY);

        for (int i =1; i<=5; i++){
            innerCombo.addItem(i);
            middleCombo.addItem(i);
            outerCombo.addItem(i);
        }

        JLabel inner = new JLabel("inner");
        JLabel middle = new JLabel("middle");
        JLabel outer = new JLabel("outer");

        JLabel initialPosition = new JLabel("Initial Positions");


        
        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new FlowLayout());

        panelNorth.add(inner);
        panelNorth.add(innerCombo);
        panelNorth.add(middle);
        panelNorth.add(middleCombo);
        panelNorth.add(outer);
        panelNorth.add(outerCombo);

        panelNorth.add(initialPosition);
        panelNorth.add(initalPositionText);


        panelNorth.add(encryptButton);
        panelNorth.add(decryptButton);


        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new FlowLayout());

        JLabel inputLabel = new JLabel("Input");
        inputTextArea.setEditable(true);

        panelCenter.add(inputLabel);
        panelCenter.add(inputTextArea);




        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new FlowLayout());


        JLabel outputLabel = new JLabel("Output");
        outputArea.setEditable(false);
        panelSouth.add(outputLabel);
        panelSouth.add(outputArea);
        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);

    }


}