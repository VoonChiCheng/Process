package ui;


import domain.*;
import java.awt.*;
import java.awt.event.*;;
import javax.swing.*;
import java.util.Date;
import java.util.ArrayList;
import control.*;
import org.jdesktop.swingx.*;
import org.jdesktop.swingx.prompt.PromptSupport;

public class CreditCardPaymentFrame extends JFrame{
   
    public Payment pay =null;
    private JLabel jblTotalAmt = new JLabel("Total Amount :");
   private PaymentControl paymentControl;
    private JLabel jblCreditCard = new JLabel("Card Serial Number:");
    private JTextField jtfCreditCard = new JTextField();
    private JButton jbtConfirm = new JButton("Confirm");
    private JButton jbtBack = new JButton("Back");
    private Font largeFont = new Font("Cambria", Font.BOLD, 30);
    private JButton jbtReset = new JButton("Reset");
    private Font smallFont = new Font("Serif", Font.PLAIN ,20);
    
 
    
    public CreditCardPaymentFrame(double TotalAmt,String SaleID,String StaffID,int Valid,int[] Array,ArrayList<Ticket> Ticket,Schedule Schedule,String Position,ArrayList<VSchedule> VS){
        setIcon();  
        final String position = Position;
        final ArrayList<VSchedule> vs = VS;
        final String staffID = StaffID;
       final String saleID = SaleID;
       final int valid = Valid;
       final Schedule schedule = Schedule;
       final int[] array = Array;
       final ArrayList<Ticket> ticket = Ticket;
        paymentControl = new PaymentControl();
       final double totalAmt = TotalAmt;
      // final String saleID = SaleID;
       JTextField jtfTotalAmt = new JTextField("RM " + String.format("%.2f",totalAmt ));
       JPanel jpCenter = new JPanel(new GridLayout(2,2));
       jpCenter.add(jblTotalAmt);
       jpCenter.add(jtfTotalAmt);
       jpCenter.add(jblCreditCard);
       jpCenter.add(jtfCreditCard);
       add(jpCenter);
       
       JPanel jpSouth = new JPanel();
       jpSouth.add(jbtConfirm);
       jpSouth.add(jbtBack);
       jpSouth.add(jbtReset);
       add(jpSouth, BorderLayout.SOUTH);

       
      PromptSupport.setForeground(Color.gray, jtfCreditCard);
       PromptSupport.setPrompt("1234567890123456", jtfCreditCard);
       PromptSupport.setFontStyle(3, jtfCreditCard);
       
        
   
       
       jblTotalAmt.setFont(largeFont);
       jtfTotalAmt.setFont(largeFont);
       jblCreditCard.setFont(largeFont);
       jtfCreditCard.setFont(largeFont);
     
       jtfTotalAmt.setForeground(Color.red);
       jbtConfirm.setPreferredSize(new Dimension(100,50));
       jbtBack.setPreferredSize(new Dimension(100,50));
       jbtReset.setPreferredSize(new Dimension(100,50));
    //   jbtConfirm.setFont(new Font("Cambria",Font.BOLD,15));
    //   jbtBack.setFont(new Font("Cambria", Font.BOLD,15));
       jpSouth.setBackground(new Color(204,255,255));
       jpCenter.setBackground(new Color(204,255,255));
       jbtConfirm.setFont(smallFont);
       jbtBack.setFont(smallFont);
       jbtReset.setFont(smallFont);
       jtfTotalAmt.setBackground(new Color(204,255,255));
       jtfCreditCard.setBackground(new Color(204,255,255));
       
       jbtConfirm.setMnemonic(KeyEvent.VK_C);
       jbtBack.setMnemonic(KeyEvent.VK_B);
       jbtReset.setMnemonic(KeyEvent.VK_R);
       
       
       jtfTotalAmt.setEditable(false);
       
         jbtBack.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new PaymentFrame(schedule,valid,saleID,array,ticket,staffID,position,vs);
            }
            
        });
       
       jbtReset.addActionListener(new ActionListener()
       {

            @Override
            public void actionPerformed(ActionEvent e) {
           jtfCreditCard.setText("");
            }
           
       });
       
           jbtConfirm.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
          int option =JOptionPane.showConfirmDialog(null,"Are you confirm with the credit card serial number?","Confirmation",JOptionPane.YES_NO_OPTION);
            if(option == JOptionPane.YES_OPTION){
               
                
                String creditCardNumber = jtfCreditCard.getText();
                if(creditCardNumber.length() ==16){
              //   ArrayList<OrderList> orderList = payControl.getOrderList(OD);
            //    Date date = new Date();   
             //   double totalCash = totalAmt;
              //  double TChange = 0;
              //  Payment pay = new Payment(saleID,"Credit Card",creditCardNumber,totalAmt);
                 boolean check = false;
                
                  do{
                pay = new Payment(saleID,"Credit Card",creditCardNumber,totalAmt);
               check = paymentControl.checkRepeatPaymentID(pay.getPaymentID());
                
              
                  }while(check);
                  System.out.print(pay.getPaymentID());
                  paymentControl.createPaymentRecord(pay);
                 
             //   payControl.createPaymentRecord(pay.getPaymentID(), pay.getOrderID(), pay.getDate(), pay.getTotalPrice(), pay.getPaymentMethod(),pay.getMemberID(), pay.getCreditCardNumber());
          //   ReceiptList r = new ReceiptList(OD,date,pay.getPaymentID(),SeatID,MemberID,orderList,TotalAmountBefore,Gst,Discount,totalAmt,totalCash,TChange);
                  int quantity = paymentControl.getQuantity(saleID);
                  Date date = new Date();
                Receipt r = new Receipt(saleID,date,pay.getPaymentID(),quantity, totalAmt, 0.0,"Credit Card",totalAmt);
                
            
            // dispose();
             //new Home();
          //  new PaymentReceipt(r);
                 JOptionPane.showMessageDialog(null,"Payment Succesfully, directing to receipt"); 
                 ArrayList<TicketP> t = paymentControl.getTicket(saleID);
//             PaymentReceipt p = new PaymentReceipt(r,t);
             
             dispose();
             new PaymentSuccess(r,t,staffID,position);
             //new Home();
             JFrame frame = new JFrame();
           //  frame.add(p);
//              JScrollPane scrollpane1  = new JScrollPane(p);
//             frame.add(scrollpane1);
             frame.setTitle("Payment Receipt");
             
           frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           frame.pack();
           frame.setLocationRelativeTo(null);
           frame.setVisible(true);
           
           
             JFrame frame1 = new JFrame();
           TicketFrame f = new TicketFrame(t);
           
          JScrollPane scrollpane = new JScrollPane(f);
//           frame1.add(f);
           frame1.add(scrollpane);
         frame1.setTitle("Ticket");
           frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               frame1.setSize(700,800);
         frame1.setLocationRelativeTo(null);
          frame1.setVisible(true);
      //      payControl.closeDB();
      
            }
                else{
                    JOptionPane.showMessageDialog(null, "This is not the correct format of credit card number.\n(Enter 16 digit format credit card number)","Error Format",JOptionPane.ERROR_MESSAGE);
                    jtfCreditCard.setText("");
                }
            }
        }
    });
       addWindowListener(new WindowListener());
          setTitle("Credit Card Payment");        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(800,200);
        setLocationRelativeTo(null);
        setVisible(true);
       
     
}
    public static void main(String[] args) {
          try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
//              new CreditCardPaymentFrame(120.00,"AB");
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
    
    }
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }
       private class WindowListener extends WindowAdapter{
        public void windowClosing(WindowEvent e){
            int option = JOptionPane.showConfirmDialog(null,"Confirm return to the Login Page?","Confirm?",JOptionPane.WARNING_MESSAGE);
            if(option == JOptionPane.YES_OPTION){
                dispose();
//              new LoginFrame();
               paymentControl.closeDB();
            }
            
        }
    }
    
     
}