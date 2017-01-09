package ui;


import control.PaymentControl;
import domain.Payment;
import domain.Receipt;
import domain.Schedule;
import domain.Ticket;
import domain.TicketP;
import domain.VSchedule;
import java.awt.*;
import java.awt.event.*;;
import javax.swing.*;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.DateFormat;


public class CashPaymentFrame extends JFrame{
  
    private PaymentControl paymentControl;
    public Payment pay = null;
     private JLabel jblTotalAmt = new JLabel("Total Amount :" );
    
    private JLabel jblCash = new JLabel("Cash :");
    private JTextField jtfCash = new JTextField("");
    private JLabel jlbRM = new JLabel("RM");
    private JLabel jblPoint = new JLabel("Points :" );
    
    private JTextField jtfPoint = new JTextField();
    private JButton jbtConfirm = new JButton("Confirm");
    private JButton jbtBack = new JButton("Back");
    private JLabel empty = new JLabel();
    private Font largeFont = new Font("Cambria", Font.BOLD, 30);
    private Font font = new Font("Serif", Font.PLAIN ,20);
 //   JPanel eastPanel = new JPanel(new GridLayout(4,5,3,3));
    private JTextField jtfCashAmt = new JTextField("RM" );
    private JLabel jlbCashAmt = new JLabel("Cash Amount :");
    private int validC = 0;
    
    private JLabel jlbChange = new JLabel("Change :");
    private JTextField jtfChange = new JTextField("RM");
    private JButton jbtCal = new JButton("Calculate");
    private JPanel jp = new JPanel(new GridLayout(1,2));
   
    
  
   
    
    public CashPaymentFrame(double TotalAmt,String SaleID,String StaffID,int Valid,int[] Array,ArrayList<Ticket> Ticket,Schedule Schedule,String Position,ArrayList<VSchedule> VS){
        setIcon();
       final String staffID = StaffID;
       final String position = Position;
        final ArrayList<VSchedule> vs = VS;
       final String saleID = SaleID;
       final int valid = Valid;
       final Schedule schedule = Schedule;
       final int[] array = Array;
       final ArrayList<Ticket> ticket = Ticket;
     paymentControl = new PaymentControl();
     final double totalAmt = TotalAmt;
   //  final String saleID = SaleID;
 
     JTextField jtfTotalAmt = new JTextField("RM" + String.format("%.2f", totalAmt));
    JPanel jpCenter = new JPanel(new GridLayout(5,2));
    jpCenter.add(jblTotalAmt);
    jpCenter.add(jtfTotalAmt);
    jpCenter.add(jblCash);
    jpCenter.add(jp);
    jp.add(jlbRM);
    jp.add(jtfCash);
 
    jpCenter.add(jlbCashAmt);
    jpCenter.add(jtfCashAmt);
    jpCenter.add(jlbChange);
    jpCenter.add(jtfChange);
    
    add(jpCenter,BorderLayout.CENTER);
    
    
    jpCenter.setBackground(new Color(204,255,255));
    jp.setBackground(new Color(204,255,255));
    jtfCashAmt.setBackground(new Color(204,255,255));
    jtfChange.setBackground(new Color(204,255,255));
    jtfTotalAmt.setBackground(new Color(204,255,255));
    jtfCash.setBackground(new Color(204,255,255));
  
    
  jtfCash.setPreferredSize(new Dimension(400,400));
   
    jlbRM.setPreferredSize(new Dimension(20,20));
    jlbRM.setFont(largeFont);
    jlbCashAmt.setFont(largeFont);
    jtfCashAmt.setFont(largeFont);
    jtfChange.setFont(largeFont);
    jlbChange.setFont(largeFont);
     jblTotalAmt.setFont(largeFont);
       jtfTotalAmt.setFont(largeFont);
       jblCash.setFont(largeFont);
       jtfCash.setFont(largeFont);
     //  jblPoint.setFont(largeFont);
    //   jtfPoint.setFont(largeFont);
       jtfTotalAmt.setForeground(Color.red);
       jtfCashAmt.setForeground(Color.blue);
       jtfChange.setForeground(Color.green);
       jbtConfirm.setPreferredSize(new Dimension(100,50));
       jbtBack.setPreferredSize(new Dimension(100,50));
    
       jbtConfirm.setFont(font);
       jbtBack.setFont(font);
       jbtCal.setFont(font);
      jbtCal.setPreferredSize(new Dimension(130,50));
      jtfCash.requestFocusInWindow();
      
      jbtConfirm.setMnemonic(KeyEvent.VK_C);
      jbtBack.setMnemonic(KeyEvent.VK_B);
      jbtCal.setMnemonic(KeyEvent.VK_A);
       
       jtfTotalAmt.setEditable(false);
       jtfCashAmt.setEditable(false);
       jtfChange.setEditable(false);
       jbtConfirm.setEnabled(false);
    
    JPanel jpSouth = new JPanel();
    jpSouth.add(jbtConfirm);
    jpSouth.add(jbtBack);
    jpSouth.add(jbtCal);
    add(jpSouth, BorderLayout.SOUTH);
      jpSouth.setBackground(new Color(204,255,255));
      
       jbtBack.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new PaymentFrame(schedule,valid,saleID,array,ticket,staffID,position,vs);
            }
            
        });
  
     jbtCal.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {

            try{
           
        
            
               
                 String cash = jtfCash.getText();
                double dCash = Double.parseDouble(cash);
               double change = paymentControl.calChange(totalAmt, dCash);
                  //double change = totalCash - totalAmt;
             //   String RChange = String.valueOf(TChange);
              //  String sChange = String.valueOf(totalCash);
                jtfCashAmt.setText(String.format("%.2f",dCash));
                jtfChange.setText(String.format("%.2f", change));
                 if(dCash < totalAmt){
                     jbtConfirm.setEnabled(false);
                    validC = 0;
                    jtfCash.setText("");
                    jtfCash.requestFocus();
                }
                else{
                     jbtConfirm.setEnabled(true);
                    validC = 1;
                }
            
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        
    }
    });
     
         jbtConfirm.addActionListener(new ActionListener()
    {
       public void actionPerformed(ActionEvent e)
       {
          
       
             
       
           
               
               JOptionPane.showMessageDialog(null,"Payment Succesfully, directing to receipt");
            
             // Date date = new Date();              
              
               
                    String cash = jtfCash.getText();
                double dCash = Double.parseDouble(cash);
               double change = paymentControl.calChange(totalAmt, dCash);
              boolean check = false;
                
                  do{
                pay = new Payment(saleID,"Cash","0000000000000000",totalAmt);
               check = paymentControl.checkRepeatPaymentID(pay.getPaymentID());
                
              
                  }while(check);
            //      System.out.print(pay.getPaymentID());
                  paymentControl.createPaymentRecord(pay);
             
            int quantity = paymentControl.getQuantity(saleID);
                  Date date = new Date();
                Receipt r = new Receipt(saleID,date,pay.getPaymentID(),quantity, totalAmt, change,"Cash",dCash);
                ArrayList<TicketP> t = paymentControl.getTicket(saleID);
                
            
           
               dispose();
               new PaymentSuccess(r,t,staffID,position);
             //new Home();
             JFrame frame = new JFrame();
              PaymentReceipt p = new PaymentReceipt(r,t);
        //      frame.add(p);
             JScrollPane scrollpane1  = new JScrollPane(p);
             frame.add(scrollpane1);
            // frame.add(p);
             frame.setTitle("Payment Receipt");
           frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           
           JFrame frame1 = new JFrame();
           TicketFrame f = new TicketFrame(t);
           
          JScrollPane scrollpane = new JScrollPane(f);
//           frame1.add(f);
           frame1.add(scrollpane);
           scrollpane.setBackground(new Color(204,255,255));  //
         frame1.setTitle("Ticket");
           frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      //    frame1.setSize(200,200);
           frame.pack();
           frame.setLocationRelativeTo(null);
           frame.setVisible(true);
           
         //  frame1.pack();
           frame1.setSize(700,800);
         frame1.setLocationRelativeTo(null);
          frame1.setVisible(true);
         
         
           
           }
               

       }
    );
          
           addWindowListener(new WindowListener());
           setTitle("Cash Payment");
         setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
           setSize(800,500);
         setLocationRelativeTo(null);
           setVisible(true);
           }
    
    public static void main(String[] args){
          try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
          //   new CashPaymentFrame(120,"SA");
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
               new LoginFrame();
               paymentControl.closeDB();
            }
            
        }
    }
           }
               
           
      
            
       