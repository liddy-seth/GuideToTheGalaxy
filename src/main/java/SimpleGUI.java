import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class SimpleGUI {

    JButton submitButton = new JButton("Submit");
    String fullFilePath = "";
    JFrame ui = new JFrame();
    JTextField inputField = new JTextField();
    JTextField outputFile = new JTextField();
    JPanel panel = new JPanel();

    public SimpleGUI(){

        panel.setBorder(BorderFactory.createEmptyBorder(100,100,50,100));
        panel.setLayout(new GridLayout(0,1) );
        //panel.add(inputField);
        panel.add(new JLabel("Input File Name: "));
        panel.add(inputField);
        panel.add(new JLabel("Output File Name: "));
        panel.add(outputFile);
        panel.add(submitButton);

        ui.add(panel, BorderLayout.CENTER);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setTitle("Conversion Guide");
        ui.pack();
        ui.setVisible(true);

    }

    public void submitButtonClick (ActionEvent event){
        if (event.getSource() == submitButton){
            Process processData = new Process();
            try {
                processData.parseFile(inputField.toString(), outputFile.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

