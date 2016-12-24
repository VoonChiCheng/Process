package ui;


import control.PaymentControl;
import domain.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.*;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PaymentReceipt extends JPanel{
  
    
        private PaymentControl paymentControl;
    private ImageIcon logo = new ImageIcon(getClass().getResource("logo.gif"));
    private JTextArea textarea = new JTextArea();
     private JLabel jlblogo = new JLabel(logo);
    private JPanel jpTop = new JPanel(new BorderLayout());
 //   private JPanel jpTopTop = new JPanel();
    private JPanel jpTopCenter = new JPanel();
    private JPanel jpTopBtm = new JPanel();
    private JPanel jpCenter = new JPanel();
    private JLabel jlb1 = new JLabel("Sale ID :");
    private JLabel jlb11 = new JLabel("");
    private JLabel jlb2 = new JLabel("Payment ID :");
    private JLabel jlb22 = new JLabel("");
    private JLabel jlb3 = new JLabel("Date :");
    private JLabel jlb33 = new JLabel("");
    private JLabel jlb4 = new JLabel("Quantity of ticket purchased :");
    private JLabel jlb44 = new JLabel("");
    private JLabel jlb5 = new JLabel("Total Amount :");
    private JLabel jlb55 = new JLabel("");
    private JLabel jlb6 = new JLabel("Change :");
    private JLabel jlb66 = new JLabel("");
    private JLabel jlbTitle = new JLabel("Top Bus Company");
    private JLabel jlbSubTitle = new JLabel("Receipt");
    private JPanel jpSouth = new JPanel();
    private JButton jbtPrint = new JButton("Print");
    
    private Font LargeFont = new Font("Serif",Font.BOLD,26);
      private Font largeFont = new Font("Serif", Font.BOLD, 23);
      private Font smallFont = new Font("Serif", Font.PLAIN ,20);
      
  //    private JPanel jp1 = new JPanel();
 //     private JPanel jp2 = new JPanel();
  //    private JPanel jp3 = new JPanel();
   //   private JPanel jp4 = new JPanel();
   //   private JPanel jp5 = new JPanel();
   //   private JPanel jp6 = new JPanel();
      private JPanel jp = new JPanel(new BorderLayout());
    
  public PaymentReceipt(Receipt r,ArrayList<TicketP> t){
//      setIcon();
      paymentControl = new PaymentControl();
       SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
      String dateStr = DATE_FORMAT.format(r.getDate());
      String str = "";
   // add(jpTop,BorderLayout.NORTH);
    //add(jpCenter,BorderLayout.CENTER);
    add(jp);
    jp.add(jpTop,BorderLayout.NORTH);
    jp.add(jpCenter,BorderLayout.CENTER);
    jp.add(jpSouth,BorderLayout.SOUTH);
   // add(jpSouth,BorderLayout.SOUTH);
 //   jpTop.add(jpTopTop,BorderLayout.NORTH);
    jpTop.add(jpTopCenter,BorderLayout.CENTER);
    jpTop.add(jpTopBtm,BorderLayout.SOUTH);
    
  jlbTitle.setFont(LargeFont);
  jlbSubTitle.setFont(largeFont);
  //  jpTopTop.add(jlblogo);
    jpTopCenter.add(jlbTitle);
    jpTopBtm.add(jlbSubTitle);
  /*  jpCenter.add(jlb1);
   jpCenter.add(jlb11);
     jpCenter.add(jlb2);
    jpCenter.add(jlb22);
     jpCenter.add(jlb3);
    jpCenter.add(jlb33);
     jpCenter.add(jlb4);
   jpCenter.add(jlb44);
     jpCenter.add(jlb5);
    jpCenter.add(jlb55);
     jpCenter.add(jlb6);
    jpCenter.add(jlb66);*/
    jpSouth.add(jbtPrint);
    
    jbtPrint.setFont(smallFont);
    
    jlb1.setFont(smallFont);
    jlb2.setFont(smallFont);
    jlb3.setFont(smallFont);
    jlb4.setFont(smallFont);
    jlb5.setFont(smallFont);
    jlb6.setFont(smallFont);
  //  jp.setBackground(new Color(204,255,255));
    jlb11.setFont(smallFont);
    jlb22.setFont(smallFont);
    jlb33.setFont(smallFont);
    jlb44.setFont(smallFont);
    jlb55.setFont(smallFont);
    jlb66.setFont(smallFont);
    
 //   jpTopTop.setBackground(new Color(204,255,255));
  //  jpTopCenter.setBackground(new Color(204,255,255));
  //  jpTopBtm.setBackground(new Color(204,255,255));
  //  jpCenter.setBackground(new Color(204,255,255));
  //  imglabelapprove.setHorizontalAlignment(JLabel.CENTER);
    
  /*  jlb1.setText("Sale ID");
    jlb2.setText("Payment ID");
    jlb3.setText("Date");
    jlb4.setText("Quantity of Ticket Purchased ");
    jlb5.setText("Total Amount");
    jlb6.setText("Change");
    jlb11.setText(": " + r.getSaleID());
    jlb22.setText(": " + r.getPaymentID());
    jlb33.setText(": " + dateStr);
    jlb44.setText(": " + r.getQuantity());
    jlb55.setText(": RM" +String.format("%.2f", r.getTotalAmount()) );
    jlb66.setText(": RM" + String.format("%.2f", r.getChange()));*/
    
    str += "\t  Top Bus Receipt\n\n"
            + "============================================\n"
            + "Sale ID : " +  r.getSaleID() + "\nPayment ID : " + r.getPaymentID()
            + "\nDate : " + dateStr + "\nQuantity of Ticket Purchased : " + r.getQuantity() + "\n\n"
            + "    Ticket No  \t" + "              Destination" + "        \tPrice\n"
                +"============== ============  \t=======\n";
    
    for(int i =0;i<t.size();i++){
        str +=  t.get(i).getTicketID() + "      " + t.get(i).getDestination() + "\t  " + "RM"+ t.get(i).getPrice() + "\n";
    }
    
    str += "=============================================\n"
            + "Total Amount : RM" + String.format("%.2f",r.getTotalAmount()) + "\n"
            + "Total Amount Paid : RM" + String.format("%.2f", r.getAmtPaid()) + "\n"
            + "Pay Method : " + r.getPayMethod() + "\n"
            + "Change : RM" + String.format("%.2f", r.getChange()); 
  
    //textarea.set
    textarea.setText(str);
     textarea.setEditable(false);
     textarea.setOpaque(true);
     textarea.setFont(smallFont);
    jpCenter.add(textarea);
    
    jbtPrint.setMnemonic(KeyEvent.VK_P);
     jbtPrint.addActionListener(new java.awt.event.ActionListener() {

         
          public void actionPerformed(java.awt.event.ActionEvent evt){
              try {
                  jbutton_printActionPerformed(evt);
              } catch (PrinterException ex) {
                  Logger.getLogger(TicketFrame.class.getName()).log(Level.SEVERE, null, ex);
              }
           }
       } );
    
    setBackground(new Color(204,255,255));
    jpTopCenter.setBackground(new Color(204,255,255));
    jpTopBtm.setBackground(new Color(204,255,255));
    jpCenter.setBackground(new Color(204,255,255));
  
//////   jp1.add(jlb1);
 //  jp2.add(jlb2);
 // jp3.add(jlb3);
 //jp4.add(jlb4);
 // jp5.add(jlb5);
 // jp6.add(jlb6);
  
//  jp1.setBackground(new Color(204,255,255));
 // jp2.setBackground(new Color(204,255,255));
 // jp3.setBackground(new Color(204,255,255));
 // jp4.setBackground(new Color(204,255,255));
//  jp5.setBackground(new Color(204,255,255));
//  jp6.setBackground(new Color(204,255,255));
  jpSouth.setBackground(new Color(204,255,255));
  
  
     
     
    /*   setTitle("Payment Receipt");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          pack();
        setLocationRelativeTo(null);
           setVisible(true);*/
  }
   
  public static void main(String[] args){
      
       try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
         // Receipt r = new Receipt();
            Date date = new Date();
          //  Receipt r = new Receipt("TestSale",date,"TestPAy",3, 50,0,"Cash",50);
               
               
//          new PaymentReceipt( r,t);
             
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
     
      
  }
  
   private void jbutton_printActionPerformed(java.awt.event.ActionEvent evt) throws PrinterException{
        boolean complete = textarea.print();
    }
  
 

    
   
  
  
}
