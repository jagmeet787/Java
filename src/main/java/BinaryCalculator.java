import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

// javac BinaryCalculator.java
// jar -cvfe BinaryCalculator.jar BinaryCalculator *.class

public class BinaryCalculator extends JFrame implements ActionListener {
      private JButton clearButton;
      private JButton convertToDecimalButton;
      private JButton convertToBinaryButton;
      private JTextField output;
      private JTextField input;

      public BinaryCalculator () {
            super("Binary and Decimal Calculator");
            setLayout(new FlowLayout());
            setSize(350,200);
            input = new JTextField(30);
            output = new JTextField(30);
            
            convertToDecimalButton = new JButton("Convert To Decimal");
            convertToBinaryButton = new JButton("Convert To Binary");
            clearButton = new JButton ("Clear");

            convertToDecimalButton.addActionListener(this);
            clearButton.addActionListener(this);
            convertToBinaryButton.addActionListener(this);

            convertToDecimalButton.setActionCommand("convertToDecimal");
            convertToBinaryButton.setActionCommand("convertToBinary");
            clearButton.setActionCommand("clear");

            this.add(new JLabel("Decimal"));
            this.add(input);
            this.add(new JLabel("Binary"));
            this.add(output);
            this.add(convertToBinaryButton);
            this.add(convertToDecimalButton);
            this.add(clearButton);
      }

      private String convertToBinary(String numString) {
            try {
                  int num = Integer.parseInt(numString);
                  return Integer.toBinaryString(num);
            } catch (Exception e) {
                  String errorMessage = "Please Enter Correct Decimal Number.";
                  input.setText("");
                  output.setText("");
                  JOptionPane.showMessageDialog(new JFrame(), errorMessage, "Invalid Decimal Number", JOptionPane.ERROR_MESSAGE);
                  e.printStackTrace();
            }
            return "";
      }

      private String convertToDecimal(String numString) {
            int num = Integer.parseInt(numString, 2);
            return "" + num;
      }

      public void actionPerformed(ActionEvent e) {
            String s = e.getActionCommand();
            if (s.contentEquals("convertToDecimal")) {
                  String aNumber = output.getText();
                  if (!aNumber.matches("[01]+")) {
                        String errorMessage = "Please Enter Correct Binary Number.";
                        input.setText("");
                        output.setText("");
                        JOptionPane.showMessageDialog(new JFrame(), errorMessage, "Invalid Binary Number", JOptionPane.ERROR_MESSAGE);
                        throw new NotInBinaryFormatException("Enter Correct Binary String", new Throwable()); 
                  }
                  input.setText(convertToDecimal(aNumber));
            }
            if (s.equals("clear")) {
                  input.setText("");
                  output.setText("");
            }
            if (s.contentEquals("convertToBinary")) {
                  String number = input.getText();
                  output.setText(convertToBinary(number));
            }
      }
      
      public static void main (String args[]) {
            BinaryCalculator b = new BinaryCalculator();
            b.setVisible(true);
      }
}

class NotInBinaryFormatException extends RuntimeException {
      public NotInBinaryFormatException(String errorMessage, Throwable err) {
            super(errorMessage, err);
      }
}
