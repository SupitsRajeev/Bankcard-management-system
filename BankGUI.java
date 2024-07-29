import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.time.Year;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class BankGUI implements ActionListener

{

    private JFrame frame;
    private JPanel panel, panel1, panel2;
    private JLabel Labela, Labelb, Labelc, Labeld, Labele, Labelf, Labelg, Labelh, LabelA, LabelB, LabelC, LabelD,
            LabelE, LabelF, LabelG, LabelH, LabelI, LabelJ, LabelK,  LabelL,LabelM, LabelX;
    private JTextField textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8,
            textField9, textField10, textField11, textField12, textField13, textField14, textField15, textField16,textField17;
    private JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11,
            button13, button14;
    private JComboBox Dayys,Yearrs,Monthhs,Day,Month,Year;
    // Creating Arraylistfff
    private ArrayList<BankCard> ATMs = new ArrayList<BankCard>();

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button13) {
            panel2.setVisible(true);
            panel1.setVisible(false);
            panel.setVisible(false);
        } 
        else if (e.getSource() == button14) {
            panel1.setVisible(true);
            panel2.setVisible(false);
            panel.setVisible(false);
        } 
        else if (e.getSource() == button1) {
            panel.setVisible(true);
            panel1.setVisible(false);
            panel2.setVisible(false);
        } 
        else if (e.getSource() == button8) {
            panel.setVisible(true);
            panel1.setVisible(false);
            panel2.setVisible(false);
        }
        
         else if (e.getSource() == button7) {
            int CardId = Integer.parseInt(textField10.getText());
            double Balanceamount = Double.parseDouble(textField11.getText());
            String Bankaccount = textField12.getText();
            String Issuerbank = textField13.getText();
            String Client = textField14.getText();
            int Pin = Integer.parseInt(textField15.getText());

            
            boolean one = true;
            
            //Using for each loop to go through the arraylist
            for (BankCard i : ATMs) {
                // Checking if the object is an instance of DebitCard
                if (i instanceof DebitCard){
                  DebitCard naya = (DebitCard) i;

                  if(naya.getcardid() == CardId )
                  {
                        // Display error message for duplication
                        one = false;
                    }
                } 
                
            }
            if(one == true)
            {
                DebitCard obj = new DebitCard(Balanceamount, Bankaccount, Issuerbank, CardId, Client, Pin);
                ATMs.add(obj);
                JOptionPane.showMessageDialog(frame, "Card added"); 
            }
            else if(one == false)
            {
                JOptionPane.showMessageDialog(frame, "Card already exists");
            }
          
           
        }
            else if(e.getSource() == button2) {  
            int Cardid = Integer.parseInt(textField1.getText());
            String Clientname = textField5.getText();
            String Issuerbank = textField4.getText();
            String Bankaccount = textField3.getText();
            double Balanceamount = Double.parseDouble(textField2.getText());
            int Cvc = Integer.parseInt(textField6.getText());
            double Interestrate = Double.parseDouble(textField7.getText());
            String Expirydate = textField8.getText();
           boolean one = true;
            
            //Using for each loop to go through the arraylist
            for (BankCard j : ATMs) {
                // Checking if the object is an instance of CreditCard
                if (j instanceof CreditCard){
                  CreditCard naya = (CreditCard) j;

                  if(naya.getcardid() == Cardid )
                  {
                    one = false;
                    }
                    
                } 
                
            }
        
            if(one == true)
            {
                CreditCard obj2 = new CreditCard(Cardid, Issuerbank, Bankaccount, Balanceamount, Cvc, Interestrate, Clientname, Expirydate );
                ATMs.add(obj2);
                JOptionPane.showMessageDialog(frame, "Card added"); 
                
            
            }
            else if(one == false)
            {
                JOptionPane.showMessageDialog(frame, "Card already exists");
            }
          }

          else if(e.getSource() == button11 ) {
         int Cardid = Integer.parseInt(textField17.getText());
         int Pin = Integer.parseInt(textField15.getText());
         double withdrawalamount = Double.parseDouble(textField16.getText());
        boolean one;
         for (BankCard i : ATMs) {
             if (i instanceof DebitCard) {
                 DebitCard naya = (DebitCard) i;
                 if (naya.getcardid() == Cardid ) {
                     one = true;
                    String asas = "card id:" + Cardid + "\n" + "Pin:" + Pin + "\n" + "Withdrawal amount:" + withdrawalamount + "\n";
                    JOptionPane.showMessageDialog(frame, asas);
                    //naya.withdraw(withdrawalamount,Pin,date);
                     
                 } 
                 else {
                     
                     JOptionPane.showMessageDialog(frame, "Invalid Card ID or Pin");
                 }
             }
         }
        }
          
         
         else if(e.getSource() == button9){          
            int CardId = Integer.parseInt(textField10.getText());
            
            String date = (String) Day.getSelectedItem() + "/" + (String) Month.getSelectedItem() + "/"
                    + (String) Year.getSelectedItem();
            for (BankCard j : ATMs) {
                // Checking if the object is an instance of DebtCard
                if (j instanceof DebitCard){
                  DebitCard naya = (DebitCard) j;

                  if(naya.getcardid() == CardId )
                  {
                     naya.display();
                     JOptionPane.showMessageDialog(frame, "The information of DebitCard is displayed in the output panel"+ date);
                     
                    }
                    
                } 
                
            }


         }
         
         else if(e.getSource() == button10){
             {
                textField9.setText("");
                textField10.setText("");
                textField11.setText("");
                textField12.setText("");
                textField13.setText("");
                textField14.setText("");
                textField15.setText("");
                textField16.setText("");
                textField17.setText("");
                }
         }
         
         
         //For setting the credit_limit
         else if(e.getSource () == button5) {
             int Cardid = Integer.parseInt(textField1.getText());
             double Credit_Limit = Double.parseDouble(textField7.getText());
             int Grace_period = Integer.parseInt(textField9.getText());
             
             //Using for each loop to go through the arraylist
            for (BankCard i : ATMs) {
                // Checking if the object is an instance of CreditCard
                if (i instanceof CreditCard){
                  CreditCard naya = (CreditCard) i;

                  if(naya.getcardid() == Cardid )
                  { 
                      JOptionPane.showMessageDialog(frame,"Limit Successfully Set");
                        
                      if (Credit_Limit <= 2.5 * naya.getbalanceamount()){
                          naya.setCredit_limit(Credit_Limit, Grace_period);
                          JOptionPane.showMessageDialog(frame,"Added Successfully");
                        } else{
                        JOptionPane.showMessageDialog(frame, "Insufficient balance");
                    }
                    }
                    
                } 
             
             
         }
        }
          
         //For using cancel credit button
         else if(e.getSource () == button3) {
             
              int Cardid = Integer.parseInt(textField1.getText());
              
             //Using for each loop to go through the arraylist
            for (BankCard i : ATMs) {
                // Checking if the object is an instance of CreditCard
                if (i instanceof CreditCard){
                  CreditCard naya = (CreditCard) i;
                   if(naya.getcardid() == Cardid )
                  {
                     naya.cancelCreditCard();
                     JOptionPane.showMessageDialog(frame,"The Credit Card has been cancelled");
                     
                    }
             
            }
        }
    }
     
    //For dispalying all the info of CreditCard
     else if(e.getSource () == button4) {
         
          int Cardid = Integer.parseInt(textField1.getText());
          //Using for each loop to go through the arraylist
            for (BankCard j : ATMs) {
                // Checking if the object is an instance of CreditCard
                if (j instanceof CreditCard){
                  CreditCard naya = (CreditCard) j;
                   if(naya.getcardid() == Cardid )
                  {
                     naya.display();
                     JOptionPane.showMessageDialog(frame, "The information of Credit Card is displayed in the output panel");
                     
                    }
         
            }
        
        }
       }
       // To clear all the information
       else if (e.getSource () == button6) {
           {
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
                textField6.setText("");
                textField7.setText("");
                textField8.setText("");
               
               
           }
           
       }
     }
    public void GUII() {
        // Creating JFrame
        frame = new JFrame("Bank Card");
        frame.setSize(1800, 1600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creating Panel
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.gray);
        panel.setBounds(0, 0, 1800, 1600);

        // Creating Panel 1

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(new Color(0, 153, 0));
        panel1.setBounds(0, 0, 1800, 1600);
        panel1.setVisible(false);

        // Creating label for Panel

        LabelX = new JLabel("Welcome to ATM");
        LabelX.setBounds(800, 50, 290, 50);
        LabelX.setFont(new Font("Arial", Font.BOLD, 30));
        LabelX.setOpaque(true);
        LabelX.setBackground(Color.WHITE);

        // Creating Buttons for Panel

        button13 = new JButton("Debit Card");
        button13.setBounds(450, 400, 300, 50);
        button13.setFont(new Font("Arial", Font.BOLD, 40));
        button13.addActionListener(this);

        button14 = new JButton("Credit Card");
        button14.setBounds(900, 400, 300, 50);
        button14.setFont(new Font("Arial", Font.BOLD, 40));
        button14.addActionListener(this);

        // Creating Labels for Panel 1
        Labela = new JLabel("Credit Card");
        Labela.setBounds(800, 50, 200, 50);
        Labela.setFont(new Font("Arial", Font.BOLD, 30));
        Labela.setOpaque(true);
        Labela.setBackground(Color.WHITE);

        Labelb = new JLabel("Card ID :");
        Labelb.setBounds(100, 150, 110, 45);
        Labelb.setFont(new Font("Arial", Font.BOLD, 20));
        Labelb.setOpaque(true);
        Labelb.setBackground(Color.lightGray);

        Labelc = new JLabel("Balance Amount :");
        Labelc.setBounds(100, 220, 180, 45);
        Labelc.setFont(new Font("Arial", Font.BOLD, 20));
        Labelc.setOpaque(true);
        Labelc.setBackground(Color.lightGray);

        Labeld = new JLabel("Bank Account :");
        Labeld.setBounds(100, 290, 180, 45);
        Labeld.setFont(new Font("Arial", Font.BOLD, 20));
        Labeld.setOpaque(true);
        Labeld.setBackground(Color.lightGray);

        Labele = new JLabel("Issuer Bank :");
        Labele.setBounds(100, 360, 180, 45);
        Labele.setFont(new Font("Arial", Font.BOLD, 20));
        Labele.setOpaque(true);
        Labele.setBackground(Color.lightGray);

        Labelf = new JLabel("Client Name :");
        Labelf.setBounds(1100, 150, 140, 45);
        Labelf.setFont(new Font("Arial", Font.BOLD, 20));
        Labelf.setOpaque(true);
        Labelf.setBackground(Color.lightGray);

        Labelg = new JLabel("CVC number :");
        Labelg.setBounds(1100, 220, 140, 45);
        Labelg.setFont(new Font("Arial", Font.BOLD, 20));
        Labelg.setOpaque(true);
        Labelg.setBackground(Color.lightGray);

        Labelh = new JLabel("Interest Rate :");
        Labelh.setBounds(100, 500, 140, 45);
        Labelh.setFont(new Font("Arial", Font.BOLD, 20));
        Labelh.setOpaque(true);
        Labelh.setBackground(Color.lightGray);

        LabelA = new JLabel("Expiration Date :");
        LabelA.setBounds(100, 600, 180, 45);
        LabelA.setFont(new Font("Arial", Font.BOLD, 20));
        LabelA.setOpaque(true);
        LabelA.setBackground(Color.lightGray);

        LabelB = new JLabel("Credit Limit :");
        LabelB.setBounds(100, 700, 180, 45);
        LabelB.setFont(new Font("Arial", Font.BOLD, 20));
        LabelB.setOpaque(true);
        LabelB.setBackground(Color.lightGray);

        LabelC = new JLabel("Grace Period");
        LabelC.setBounds(100, 800, 180, 45);
        LabelC.setFont(new Font("Arial", Font.BOLD, 20));
        LabelC.setOpaque(true);
        LabelC.setBackground(Color.lightGray);

        // Adding textField to Panel 1
        textField1 = new JTextField();
        textField1.setBounds(330, 150, 230, 40);
        textField1.setBackground(Color.GRAY);
        textField1.setFont(new Font("Arial", Font.BOLD, 15));

        textField2 = new JTextField();
        textField2.setBounds(330, 220, 230, 40);
        textField2.setBackground(Color.GRAY);
        textField2.setFont(new Font("Arial", Font.BOLD, 15));

        textField3 = new JTextField();
        textField3.setBounds(330, 290, 280, 40);
        textField3.setBackground(Color.GRAY);
        textField3.setFont(new Font("Arial", Font.BOLD, 15));

        textField4 = new JTextField();
        textField4.setBounds(330, 360, 280, 40);
        textField4.setBackground(Color.GRAY);
        textField4.setFont(new Font("Arial", Font.BOLD, 15));

        textField5 = new JTextField();
        textField5.setBounds(1300, 150, 280, 40);
        textField5.setBackground(Color.GRAY);
        textField5.setFont(new Font("Arial", Font.BOLD, 15));

        textField6 = new JTextField();
        textField6.setBounds(1300, 220, 280, 40);
        textField6.setBackground(Color.GRAY);
        textField6.setFont(new Font("Arial", Font.BOLD, 15));

        textField7 = new JTextField();
        textField7.setBounds(330, 500, 280, 40);
        textField7.setBackground(Color.GRAY);
        textField7.setFont(new Font("Arial", Font.BOLD, 15));

        textField8 = new JTextField();
        textField8.setBounds(330, 700, 280, 40);
        textField8.setBackground(Color.GRAY);
        textField8.setFont(new Font("Arial", Font.BOLD, 15));

        textField9 = new JTextField();
        textField9.setBounds(330, 800, 280, 40);
        textField9.setBackground(Color.GRAY);
        textField9.setFont(new Font("Arial", Font.BOLD, 15));

        // Creating Buttons
        button1 = new JButton("Go Back");
        button1.setBounds(1000, 320, 280, 40);
        button1.setBackground(Color.GRAY);
        button1.setFont(new Font("Arial", Font.BOLD, 15));
        button1.addActionListener(this);

        button2 = new JButton("Add Credit Card");
        button2.setBounds(700, 450, 300, 40);
        button2.setFont(new Font("Arial", Font.BOLD, 20));
        button2.addActionListener(this);

        button3 = new JButton("Cancel Credit Card");
        button3.setBounds(1050, 450, 300, 40);
        button3.setFont(new Font("Arial", Font.BOLD, 20));
        button3.addActionListener(this);

        button4 = new JButton("Display");
        button4.setBounds(1300, 550, 300, 40);
        button4.setFont(new Font("Arial", Font.BOLD, 20));
        button4.addActionListener(this);

        button5 = new JButton("Set Credit Limit");
        button5.setBounds(800, 750, 300, 40);
        button5.setFont(new Font("Arial", Font.BOLD, 20));
        button5.addActionListener(this);

        button6 = new JButton("Clear");
        button6.setBounds(1250, 750, 300, 40);
        button6.setFont(new Font("Arial", Font.BOLD, 20));
        button6.addActionListener(this);

        // Creating JComboBox for panel1

        String[] Days = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "15", "16", "17", "18",
                "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32" };
        JComboBox Day = new JComboBox<String>(Days);
        Day.setBounds(330, 600, 60, 45);
        Day.setFont(new Font("Arial", Font.BOLD, 20));
        Day.setOpaque(true);
        Day.addActionListener(this);

        String[] Months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        JComboBox Month = new JComboBox<String>(Months);
        Month.setBounds(500, 600, 140, 45);
        Month.setFont(new Font("Arial", Font.BOLD, 20));
        Month.setOpaque(true);
        Month.addActionListener(this);

        String[] Years = { "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028" };
        JComboBox Year = new JComboBox<String>(Years);
        Year.setBounds(780, 600, 100, 45);
        Year.setFont(new Font("Arial", Font.BOLD, 20));
        Year.setOpaque(true);
        Year.addActionListener(this);
        // Adding Labels and textFields to Panel
        panel.add(LabelX);

        // Labels
        panel1.add(Labela);
        panel1.add(Labelb);
        panel1.add(Labelc);
        panel1.add(Labeld);
        panel1.add(Labele);
        panel1.add(Labelf);
        panel1.add(Labelg);
        panel1.add(Labelh);
        panel1.add(LabelA);
        panel1.add(LabelB);
        panel1.add(LabelC);

        // textFields for panel1

        panel1.add(textField1);
        panel1.add(textField2);
        panel1.add(textField3);
        panel1.add(textField4);
        panel1.add(textField5);
        panel1.add(textField6);
        panel1.add(textField7);
        panel1.add(textField8);
        panel1.add(textField9);

        // Adding buttons to Panel 1 and Panel
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);
        panel1.add(button5);
        panel1.add(button6);
        
        
        panel.add(button13);
        panel.add(button14);

        // Adding ComboBox
        panel1.add(Day);
        panel1.add(Month);
        panel1.add(Year);

        // Creating Panel 2

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(Color.CYAN);
        panel2.setBounds(0, 0, 1000, 1600);
        panel2.setVisible(false);
        

        // Creating Labels for Panel 2

        LabelD = new JLabel("Debit Card");
        LabelD.setBounds(830, 50, 200, 50);
        LabelD.setFont(new Font("Arial", Font.BOLD, 30));
        LabelD.setOpaque(true);
        LabelD.setBackground(Color.WHITE);

        LabelE = new JLabel("Card Id: ");
        LabelE.setBounds(100, 150, 200, 50);
        LabelE.setFont(new Font("Arial", Font.BOLD, 20));
        LabelE.setOpaque(true);

        LabelF = new JLabel("Balance Amount: ");
        LabelF.setBounds(100, 220, 180, 50);
        LabelF.setFont(new Font("Arial", Font.BOLD, 20));
        LabelF.setOpaque(true);

        LabelG = new JLabel("Bank Account: ");
        LabelG.setBounds(100, 290, 180, 50);
        LabelG.setFont(new Font("Arial", Font.BOLD, 20));
        LabelG.setOpaque(true);

        LabelH = new JLabel("Issuer Bank: ");
        LabelH.setBounds(1100, 150, 180, 50);
        LabelH.setFont(new Font("Arial", Font.BOLD, 20));
        LabelH.setOpaque(true);

        LabelI = new JLabel("Client Name: ");
        LabelI.setBounds(1100, 220, 180, 50);
        LabelI.setFont(new Font("Arial", Font.BOLD, 20));
        LabelI.setOpaque(true);

        LabelJ = new JLabel("Pin Number: ");
        LabelJ.setBounds(1100, 290, 180, 50);
        LabelJ.setFont(new Font("Arial", Font.BOLD, 20));
        LabelJ.setOpaque(true);

        LabelK = new JLabel("Withdrawal Amount: ");
        LabelK.setBounds(100, 550, 200, 50);
        LabelK.setFont(new Font("Arial", Font.BOLD, 20));
        LabelK.setOpaque(true);

        LabelL = new JLabel("Date of WithDrawal: ");
        LabelL.setBounds(100, 750, 200, 50);
        LabelL.setFont(new Font("Arial", Font.BOLD, 20));
        LabelL.setOpaque(true);

        LabelM = new JLabel("Card id: ");
        LabelM.setBounds(100, 620, 200, 50);
        LabelM.setFont(new Font("Arial", Font.BOLD, 20));
        LabelM.setOpaque(true);

        // Creating textFields
        textField10 = new JTextField();
        textField10.setBounds(330, 150, 280, 40);
        textField10.setBackground(Color.LIGHT_GRAY);
        textField10.setFont(new Font("Arial", Font.BOLD, 15));

        textField11 = new JTextField();
        textField11.setBounds(330, 220, 280, 40);
        textField11.setBackground(Color.LIGHT_GRAY);
        textField11.setFont(new Font("Arial", Font.BOLD, 15));

        textField12 = new JTextField();
        textField12.setBounds(330, 290, 280, 40);
        textField12.setBackground(Color.LIGHT_GRAY);
        textField12.setFont(new Font("Arial", Font.BOLD, 15));

        textField13 = new JTextField();
        textField13.setBounds(1300, 150, 280, 40);
        textField13.setBackground(Color.LIGHT_GRAY);
        textField13.setFont(new Font("Arial", Font.BOLD, 15));

        textField14 = new JTextField();
        textField14.setBounds(1300, 220, 280, 40);
        textField14.setBackground(Color.LIGHT_GRAY);
        textField14.setFont(new Font("Arial", Font.BOLD, 15));

        textField15 = new JTextField();
        textField15.setBounds(1300, 290, 280, 40);
        textField15.setBackground(Color.LIGHT_GRAY);
        textField15.setFont(new Font("Arial", Font.BOLD, 15));

        textField16 = new JTextField();
        textField16.setBounds(330, 550, 280, 40);
        textField16.setBackground(Color.LIGHT_GRAY);
        textField16.setFont(new Font("Arial", Font.BOLD, 15));

        textField17 = new JTextField();
        textField17.setBounds(330, 620, 280, 40);
        textField17.setBackground(Color.LIGHT_GRAY);
        textField17.setFont(new Font("Arial", Font.BOLD, 15));


        // Creating Buttons

        button7 = new JButton("Add Debit Card");
        button7.addActionListener(this);
        button7.setBounds(800, 400, 200, 50);
        button7.setFont(new Font("Arial", Font.BOLD, 20));

        button8 = new JButton("Go Back");
        button8.setBounds(1300, 500, 200, 50);
        button8.setFont(new Font("Arial", Font.BOLD, 15));
        button8.setBackground(Color.gray);
        button8.addActionListener(this);

        button9 = new JButton("Display");
        button9.setBounds(1000, 650, 200, 50);
        button9.setFont(new Font("Arial", Font.BOLD, 20));
        button9.addActionListener(this);

        button10 = new JButton("Clear");
        button10.setBounds(1300, 650, 200, 50);
        button10.setFont(new Font("Arial", Font.BOLD, 20));
        button10.addActionListener(this);

        button11 = new JButton("Withdraw");
        button11.setBounds(800, 850, 200, 50);
        button11.setFont(new Font("Arial", Font.BOLD, 20));
        button11.addActionListener(this);

        // Creating Combox to Panel 2
        String[] Dayy = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "15", "16", "17", "18",
                "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32" };
        JComboBox Dayys = new JComboBox(Dayy);
        Dayys.setBounds(330, 750, 60, 45);
        Dayys.setFont(new Font("Arial", Font.BOLD, 20));
        Dayys.setOpaque(true);
        Dayys.addActionListener(this);

        String[] Monthh = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        JComboBox Monthhs = new JComboBox(Monthh);
        Monthhs.setBounds(500, 750, 140, 45);
        Monthhs.setFont(new Font("Arial", Font.BOLD, 20));
        Monthhs.setOpaque(true);
        Monthhs.addActionListener(this);

        String[] Yearr = { "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028" };
        JComboBox Yearrs = new JComboBox(Yearr);
        Yearrs.setBounds(780, 750, 100, 45);
        Yearrs.setFont(new Font("Arial", Font.BOLD, 20));
        Yearrs.setOpaque(true);
        Yearrs.addActionListener(this);

        // Adding labels and textFields to Panel 2

        // Labels
        panel2.add(LabelD);
        panel2.add(LabelE);
        panel2.add(LabelF);
        panel2.add(LabelG);
        panel2.add(LabelH);
        panel2.add(LabelI);
        panel2.add(LabelJ);
        panel2.add(LabelK);
        panel2.add(LabelL);
        panel2.add(LabelM);

        // textField
        panel2.add(textField10);
        panel2.add(textField11);
        panel2.add(textField12);
        panel2.add(textField13);
        panel2.add(textField14);
        panel2.add(textField15);
        panel2.add(textField16);
        panel2.add(textField17);

        // Adding buttons to Panel 2

        panel2.add(button7);
        panel2.add(button8);
        panel2.add(button9);
        panel2.add(button10);
        panel2.add(button11);

        // Adding Combox to Panel 2
        panel2.add(Dayys);
        panel2.add(Monthhs);
        panel2.add(Yearrs);

        panel.setLayout(null);
        panel1.setLayout(null);
        panel2.setLayout(null);

        frame.add(panel);
        frame.add(panel1);
        frame.add(panel2);
        frame.setResizable(false);
        frame.setVisible(true);
    }
      public static void main(String [] args){
        BankGUI bank = new BankGUI();
        bank.GUII();
    }

}
          


