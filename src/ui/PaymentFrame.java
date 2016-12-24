package ui;
import control.PaymentControl;
import da.CustomTable;
import domain.Schedule;
import domain.Ticket;
import domain.VSchedule;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;




public class PaymentFrame extends JFrame{

    
private PaymentControl paymentControl;
    private JLabel jlbTitle = new JLabel("Payment");    
     Font buttonFont=new Font("Serif", Font.BOLD, 23);
     Font font1 = new Font("Serif", Font.BOLD, 20);
     Font font2 = new Font("Serif",Font.BOLD,23);
    private ImageIcon logo = new ImageIcon(getClass().getResource("logo.gif"));
    private JLabel jlblogo = new JLabel(logo);
    
       private Font largeFont = new Font("Serif", Font.BOLD, 23);
       
       private JButton jbtHome = new JButton("Home");
    private JButton jbtBus = new JButton("Bus");
    private JButton jbtStaff = new JButton("Staff");
    private JButton jbtBusSchedule = new JButton("Bus Schedule");
    private JButton jbtOrder = new JButton("Order");
    private JButton jbtTicketExchange = new JButton("Ticket Exchange");
    private JButton jbtReport = new JButton("Report");
    private JButton jbtRoute = new JButton("Route");
    
    private JRadioButton jrbCash = new JRadioButton("Cash",true);
    private JRadioButton jrbCreditCard = new JRadioButton("Credit Card",false);
    private JLabel jlbPayMethod = new JLabel("Pay by :");
    private JButton jbtPay = new JButton("Pay");
    private JButton jbtBack = new JButton("Back");
    private JLabel jlbTotalPrice = new JLabel("Total Price : RM");
    private JTextField jtfTotalPrice = new JTextField("");
   
    JPanel jpSouthNorthPanel = new JPanel();
    JPanel jpSouthCenterPanel = new JPanel();
    JPanel jpSouthSouthPanel = new JPanel();
    JPanel jpNorthLabel = new JPanel();
    JPanel jpSouthPanel = new JPanel(new BorderLayout());
    JPanel jpCenter = new JPanel(new BorderLayout());
    JPanel jpCenterTop = new JPanel();
    JPanel jpCenterBtm = new JPanel(new BorderLayout());
    JPanel jpCenterBtmCenter = new JPanel();
    JPanel jpCenterBtmBtm = new JPanel();
    JPanel jpCenterSouth = new JPanel();
    private int pay =0;
    public double totalAmt = 0;
    
      private Font smallFont = new Font("Serif", Font.PLAIN ,20);
      
        private JTable productTable;
     private CustomTable tableModel;
    
    
    public PaymentFrame(Schedule Schedule,int Valid,String SaleID,int[] Array,ArrayList<Ticket> Ticket,String StaffID,String Position,ArrayList<VSchedule> VS){
        setIcon();
    paymentControl = new PaymentControl();
    final String position = Position;
        final ArrayList<VSchedule> vs = VS;
     final String staffID = StaffID;
       final String saleID = SaleID;
       final int valid = Valid;
       final Schedule schedule = Schedule;
       final int[] array = Array;
       final ArrayList<Ticket> ticket = Ticket;
      
          for(int i =0;i<vs.size();i++){
        System.out.println(vs.get(i).getScheduleID());
        System.out.println(vs.get(i).getTotalSeat());
                }
       
       if(position.compareTo("Staff") == 0){
            jbtBus.setEnabled(false);
         //   jbtStaff.setEnabled(false);
            jbtRoute.setEnabled(false);
            jbtBusSchedule.setEnabled(false);
            jbtReport.setEnabled(false);
        }else{
            jbtOrder.setEnabled(false);
            jbtTicketExchange.setEnabled(false);
            
        }
       
        jpNorthLabel.add(jlblogo);
     //   jpNorthLabel.add(jlbTitle);
    
        
        jlbTitle.setFont(buttonFont);
        jlbTitle.setHorizontalAlignment(JLabel.CENTER);
        jlbTitle.setVerticalAlignment(JLabel.CENTER);
        
        jpCenter.add(jpCenterTop,BorderLayout.NORTH);
        jpCenter.add(jpCenterBtm,BorderLayout.CENTER);
        jpCenter.add(jpCenterSouth,BorderLayout.SOUTH);
         jpCenterTop.add(jbtHome);
        jpCenterTop.add(jbtBus);
        jpCenterTop.add(jbtStaff);
        jpCenterTop.add(jbtRoute);
        jpCenterTop.add(jbtBusSchedule);
        jpCenterTop.add(jbtOrder);
        jpCenterTop.add(jbtTicketExchange);
       jpCenterTop.add(jbtReport);
        
          jbtHome.setFont(largeFont);
        jbtBus.setFont(largeFont);
        jbtStaff.setFont(largeFont);
        jbtBusSchedule.setFont(largeFont);
        jbtOrder.setFont(largeFont);
        jbtTicketExchange.setFont(largeFont);
        jbtReport.setFont(largeFont);
        jbtRoute.setFont(largeFont);
        
          jbtHome.setBackground(new Color(77, 195, 255));
        jbtBus.setBackground(new Color(77, 195, 255));
        jbtStaff.setBackground(new Color(77, 195, 255));
        jbtBusSchedule.setBackground(new Color(77, 195, 255));
        jbtOrder.setBackground(new Color(204, 255, 255));
       jbtTicketExchange.setBackground(new Color(77, 195, 255));
        jbtReport.setBackground(new Color(77, 195, 255));
        jbtRoute.setBackground(new Color(77,195,255));
        
          String[] columnNames = {"Schedule ID",
                        "Bus ID",
                        "Destination",
                           "Depart Date",
                        "Depart Time",
                        "Seat No","Price (RM)"};
        
        Object[][] data = {};
        tableModel = new CustomTable();    
        tableModel.getSaleDetail(saleID);
        productTable = new JTable(tableModel);
        productTable.setBackground(new Color(204,255,255));
        JScrollPane scrollPane = new JScrollPane(productTable);     
        //final JTable table = new JTable(data, columnNames);
        productTable.setPreferredScrollableViewportSize(new Dimension(850, 70));
     //   table.setFillsViewportHeight(true);
        
     //   table.setBackground(new Color(204,255,255));
        
       totalAmt = paymentControl.calTotalAmt(saleID);
        jtfTotalPrice.setText(String.format("%.2f" ,totalAmt));
        jpCenterBtm.add(jpCenterBtmCenter,BorderLayout.NORTH);
        jpCenterBtm.add(jpCenterBtmBtm,BorderLayout.CENTER);
       
      //  JScrollPane scrollPane = new JScrollPane(table);
        jpCenterBtmBtm.add(scrollPane);
        
        jpCenterBtmCenter.add(jlbTitle);
        jpCenterBtmCenter.setBackground(new Color(204,255,255));
        jpCenterTop.setBackground(new Color(204,255,255));
        jpCenterBtmBtm.setBackground(new Color(204,255,255));
        
        jpCenterSouth.add(jlbTotalPrice);
        jpCenterSouth.add(jtfTotalPrice);
        jtfTotalPrice.setColumns(7);
        jtfTotalPrice.setEditable(false);
        jlbTotalPrice.setFont(font2);
        jtfTotalPrice.setFont(font2);
        jpCenterSouth.setBackground(new Color(204,255,255));
        jtfTotalPrice.setBackground(new Color(204,255,255));
        jlbTotalPrice.setForeground(Color.red);
        jtfTotalPrice.setForeground(Color.red);
        
       
       
        ButtonGroup group = new ButtonGroup();
        group.add(jrbCash);
        group.add(jrbCreditCard);
        jpSouthPanel.add(jpSouthNorthPanel,BorderLayout.NORTH);
        jpSouthPanel.add(jpSouthCenterPanel,BorderLayout.CENTER);
        jpSouthCenterPanel.add(jlbPayMethod);
        jpSouthCenterPanel.add(jrbCash);
        jpSouthCenterPanel.add(jrbCreditCard);
        jpSouthPanel.add(jpSouthSouthPanel,BorderLayout.SOUTH);
        
        //jrbCash.addActionListener(new RadioListener());
       // jrbCreditCard.addActionListener(new RadioListener());
       
     jlbTitle.setForeground(Color.blue);
     jbtPay.setMnemonic(KeyEvent.VK_P);
     jbtBack.setMnemonic(KeyEvent.VK_B);
     jrbCash.setMnemonic(KeyEvent.VK_A);
     jrbCreditCard.setMnemonic(KeyEvent.VK_R);
        
       jpSouthSouthPanel.add(jbtPay);
       jpSouthSouthPanel.add(jbtBack);
 
       jlbPayMethod.setFont(buttonFont);
    //   jlbPayMethod.setForeground(new Color(139,69,19));
       jrbCash.setFont(buttonFont);
      // jrbCash.setForeground(new Color(139,69,19));
       jrbCreditCard.setFont(buttonFont);
     //  jrbCreditCard.setForeground(new Color(139,69,19));
        
       jrbCash.setBackground(new Color(204,255,255));
       jrbCreditCard.setBackground(new Color(204,255,255));
       jpSouthNorthPanel.setBackground(new Color(204,255,255));
       jpSouthSouthPanel.setBackground(new Color(204,255,255));
       jpSouthCenterPanel.setBackground(new Color(204,255,255));
     //   jlbTitle.setForeground(new Color(139,69,19));
      
        
       jpNorthLabel.setBackground(new Color(204,255,255));
       jpSouthPanel.setBackground(new Color(204,255,255));
        
        add(jpNorthLabel,BorderLayout.NORTH);
        add(jpSouthPanel,BorderLayout.SOUTH);
        add(jpCenter,BorderLayout.CENTER);
        jbtPay.setFont(smallFont);
        jbtBack.setFont(smallFont);
        
           jbtHome.addActionListener(new ActionListener()
       {

            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the current process?","Exit Process Confirmation",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
                for(int i =0;i<vs.size();i++){
                  paymentControl.reverseSchedule(vs.get(i).getTotalSeat(),vs.get(i).getScheduleID());
                   }
                     paymentControl.reverseTicket(saleID);
                     paymentControl.deleteSale(saleID);
                     dispose();
//                  new HomepageFrame(position,staffID);
            }
            }
           
       });
       
        jbtBus.addActionListener(new ActionListener()
       {
  @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the current process?","Exit Process Confirmation",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
                 for(int i =0;i<vs.size();i++){
                  paymentControl.reverseSchedule(vs.get(i).getTotalSeat(),vs.get(i).getScheduleID());
                   }
                     paymentControl.reverseTicket(saleID);
                     paymentControl.deleteSale(saleID);
                     dispose();
//                  new MaintainBus(staffID,position);
            }
            }
           
       });
         jbtStaff.addActionListener(new ActionListener()
       {

            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the current process?","Exit Process Confirmation",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
                  for(int i =0;i<vs.size();i++){
                  paymentControl.reverseSchedule(vs.get(i).getTotalSeat(),vs.get(i).getScheduleID());
                   }
                     paymentControl.reverseTicket(saleID);
                     paymentControl.deleteSale(saleID);
                     dispose();
                  new MaintainStaff(position,staffID);
            }
            }
           
       });
          jbtRoute.addActionListener(new ActionListener()
       {

             @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the current process?","Exit Process Confirmation",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
                  for(int i =0;i<vs.size();i++){
                  paymentControl.reverseSchedule(vs.get(i).getTotalSeat(),vs.get(i).getScheduleID());
                   }
                     paymentControl.reverseTicket(saleID);
                     paymentControl.deleteSale(saleID);
                     dispose();
//                  new MaintainRoute(staffID,position);
            }
            }
           
       });
           jbtBusSchedule.addActionListener(new ActionListener()
       {

           @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the current process?","Exit Process Confirmation",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
                 for(int i =0;i<vs.size();i++){
                  paymentControl.reverseSchedule(vs.get(i).getTotalSeat(),vs.get(i).getScheduleID());
                   }
                     paymentControl.reverseTicket(saleID);
                     paymentControl.deleteSale(saleID);
                     dispose();
//                  new MaintainBusSchedule(staffID,position);
            }
            }
           
       });
            jbtOrder.addActionListener(new ActionListener()
       {

           @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the current process?","Exit Process Confirmation",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
             
                      for(int i =0;i<vs.size();i++){
                  paymentControl.reverseSchedule(vs.get(i).getTotalSeat(),vs.get(i).getScheduleID());
                   }
                     paymentControl.reverseTicket(saleID);
                     paymentControl.deleteSale(saleID);
                    
                   dispose();
                  new OrderLink(staffID,position);
               
               
            }
            }
           
       });
             jbtTicketExchange.addActionListener(new ActionListener()
       {

           @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the current process?","Exit Process Confirmation",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
            
                      for(int i =0;i<vs.size();i++){
                  paymentControl.reverseSchedule(vs.get(i).getTotalSeat(),vs.get(i).getScheduleID());
                   }
                     paymentControl.reverseTicket(saleID);
                     paymentControl.deleteSale(saleID);
                   dispose();
//                   new TicketExchange(staffID,position);
               
               
            }
            }
           
       });
              jbtReport.addActionListener(new ActionListener()
       {

         @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the current process?","Exit Process Confirmation",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
                  for(int i =0;i<vs.size();i++){
                  paymentControl.reverseSchedule(vs.get(i).getTotalSeat(),vs.get(i).getScheduleID());
                   }
                     paymentControl.reverseTicket(saleID);
                     paymentControl.deleteSale(saleID);
                     dispose();
//                  new ReportFrame(staffID,position);
            }
            }
           
       });
        
          jbtBack.addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent e) {
               
                dispose();
                new MultipleOrderConfirmation(schedule,valid,saleID,array,ticket,staffID,position,vs);
            }
            
        });
        
        jrbCash.addActionListener(new CashListener());
        jrbCreditCard.addActionListener(new CreditCardListener());
        jbtPay.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(pay == 0){
                    dispose();
             new CashPaymentFrame(totalAmt,saleID,staffID,valid,array,ticket,schedule,position,vs);
         }
         else{
                    dispose();
//             new CreditCardPaymentFrame(totalAmt,saleID,staffID,valid,array,ticket,schedule,position,vs);
         }
            }
        });
   
       
        
          addWindowListener(new WindowListener());
        setTitle("Payment");        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(1000,700);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    

 
  
    public static void main(String[] args) {
           try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
            //  new PaymentFrame("SA001");
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
       ;
    }
    
    private class CashListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
       pay  =0;
    }
}
 
 private class CreditCardListener implements ActionListener{
     @Override
     public void actionPerformed(ActionEvent e){
         pay = 1;
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
//                new LoginFrame();
                paymentControl.closeDB();
            }
            
        }
    }

}