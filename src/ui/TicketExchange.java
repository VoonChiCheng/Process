package ui;

import control.*;
import domain.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.*;


public class TicketExchange extends JFrame{
    
    
    private ExchangeControl exchangeControl;
     private ImageIcon logo = new ImageIcon(getClass().getResource("logo.gif"));
     
         private JLabel jlblogo = new JLabel(logo);

    private JButton jbtHome = new JButton("Home");
    private JButton jbtBus = new JButton("Bus");
    private JButton jbtStaff = new JButton("Staff");
    private JButton jbtBusSchedule = new JButton("Bus Schedule");
    private JButton jbtOrder = new JButton("Order");
    private JButton jbtTicketExchange = new JButton("Ticket Exchange");
    private JButton jbtReport = new JButton("Report");
    private JButton jbtRoute = new JButton("Route");
    private JPanel jpTop = new JPanel(new BorderLayout());
    private JPanel jpTopTop = new JPanel();
    private JPanel jpTopBtm = new JPanel();
    private JPanel jpCenter = new JPanel(new BorderLayout());
    private JPanel jpCenterTop = new JPanel();
    private JPanel jpCenterCenter = new JPanel(new BorderLayout());
    private JPanel jp1 = new JPanel();
    private JPanel jp2 = new JPanel();
    private JPanel jp3 = new JPanel(new BorderLayout());
    private JPanel jp4 = new JPanel();
    private JPanel jp5 = new JPanel();
    
 //  private JLabel jlb1 = new JLabel("Schedule ID :");
    private JLabel jlb2 = new JLabel("Ticket ID  :");
 ////   private JLabel jlb3 = new JLabel("Seat ID       :");
    private JTextField jtf1 = new JTextField(" ");   
    private JTextField jtf2 = new JTextField(" ");
    private JTextField jtf3 = new JTextField(" ");
      private Font largeFont = new Font("Serif", Font.BOLD, 23);
      private Font smallFont = new Font("Serif", Font.PLAIN ,20);
      private JLabel jlbTitle = new JLabel("Ticket Exchange");
      private JPanel jpSouth = new JPanel(new GridLayout(4,1));
      private JButton jbtConfirm = new JButton("Confirm");
      private JLabel space1 = new JLabel(" ");
       private JLabel space2 = new JLabel(" ");
        private JLabel space3 = new JLabel(" ");
         private JLabel space4 = new JLabel(" ");
      
         private JLabel jlbspace1 = new JLabel(" ");
          private JLabel jlbspace2 = new JLabel(" ");
           private JLabel jlbspace3 = new JLabel(" ");
            private JLabel jlbspace4 = new JLabel(" ");
      
    
    public TicketExchange(String StaffID,String Position){
        exchangeControl = new ExchangeControl();
        setIcon();
        final String staffID = StaffID;
    final String position = Position;
        add(jpTop,BorderLayout.NORTH);
        add(jpCenter,BorderLayout.CENTER);
        add(jpSouth,BorderLayout.SOUTH);
        jpTop.add(jpTopTop,BorderLayout.NORTH);
        jpTop.add(jpTopBtm,BorderLayout.CENTER);
        jpCenter.add(jpCenterTop,BorderLayout.NORTH);
        jpCenter.add(jpCenterCenter,BorderLayout.CENTER);
        
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
        
        jpTopTop.add(jlblogo);
        jpTopBtm.add(jbtHome);
        jpTopBtm.add(jbtBus);
        jpTopBtm.add(jbtStaff);
        jpTopBtm.add(jbtRoute);
        jpTopBtm.add(jbtBusSchedule);
        jpTopBtm.add(jbtOrder);
        jpTopBtm.add(jbtTicketExchange);
        jpTopBtm.add(jbtReport);
        
        jpTopTop.setBackground(new Color(204,255,255));
        jpTopBtm.setBackground(new Color(204,255,255));
        
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
        jbtOrder.setBackground(new Color(77, 195, 255));
        jbtTicketExchange.setBackground(new Color(204, 255, 255));
        jbtReport.setBackground(new Color(77, 195, 255));
        jbtRoute.setBackground(new Color(77,195,255));
        
        jpCenterTop.add(jlbTitle);
        jlbTitle.setFont(largeFont);
        jpCenterCenter.add(jp1,BorderLayout.NORTH);
        jpCenterCenter.add(jp3,BorderLayout.CENTER);
        jpCenterCenter.add(jp5,BorderLayout.SOUTH);
        
        jpCenterTop.setBackground(new Color(204,255,255));
        jp2.setBackground(new Color(204,255,255));
       jp1.setBackground(new Color(204,255,255));
       jp3.setBackground(new Color(204,255,255));
       jp5.setBackground(new Color(204,255,255));
       jp4.setBackground(new Color(204,255,255));
       jpSouth.setBackground(new Color(204,255,255));
        
        jp3.add(jp2,BorderLayout.NORTH);
        jp3.add(jp4,BorderLayout.CENTER);
        
      //  jp1.add(jlb1);
     //   jp1.add(jtf1);
        jp1.add(jlbspace1);
         jp1.add(jlbspace2);
          jp4.add(jlbspace3);
          jp4.add(jlbspace4);
        
         jp2.add(jlb2);
        jp2.add(jtf2); 
      //  jp4.add(jlb3);
     //   jp4.add(jtf3);
        jp5.add(jbtConfirm);
        jbtConfirm.setFont(smallFont);
        
        jlbTitle.setForeground(Color.blue);
       
      jpSouth.add(space1);
      jpSouth.add(space2);
      jpSouth.add(space3);
      jpSouth.add(space4);
      
      space1.setFont(largeFont);
      space2.setFont(largeFont);
      space3.setFont(largeFont);
      jlbspace1.setFont(largeFont);
      jlbspace2.setFont(largeFont);
      jlbspace3.setFont(largeFont);
      jlbspace4.setFont(largeFont);
      
        jtf1.setColumns(13);
        jtf2.setColumns(13);
        jtf3.setColumns(13);
        
     //   jlb1.setFont(smallFont);
        jlb2.setFont(smallFont);
      //  jlb3.setFont(smallFont);
        jtf1.setFont(smallFont);
        jtf2.setFont(smallFont);
        jtf3.setFont(smallFont);
        jbtConfirm.setMnemonic(KeyEvent.VK_C);
        jtf2.setText("");
        
             jbtHome.addActionListener(new ActionListener()
       {

            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the current process?","Exit Process Confirmation",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
                 dispose();
                   new HomepageFrame(position,staffID);
            }
            }
           
       });
       
        jbtBus.addActionListener(new ActionListener()
       {
  @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the current process?","Exit Process Confirmation",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
              dispose();
                   new MaintainBus(position,staffID);
            }
            }
           
       });
         jbtStaff.addActionListener(new ActionListener()
       {

            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the current process?","Exit Process Confirmation",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
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
               dispose();
                   new MaintainRoute(position,staffID);
            }
            }
           
       });
           jbtBusSchedule.addActionListener(new ActionListener()
       {

           @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the current process?","Exit Process Confirmation",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
              dispose();
                   new MaintainBusSchedule(position,staffID);
            }
            }
           
       });
            jbtOrder.addActionListener(new ActionListener()
       {

           @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the current process?","Exit Process Confirmation",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
                 ArrayList<VSchedule> vs = null;
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
             
                   dispose();
                   new TicketExchange(staffID,position);
           
            }
            }
           
       });
              jbtReport.addActionListener(new ActionListener()
       {

         @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the current process?","Exit Process Confirmation",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
             dispose();
//                   new ReportFrame(position,staffID);
            }
            }
           
       });
       
        
        jbtConfirm.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
             String ticketID = jtf2.getText();
             boolean valid = exchangeControl.checkTicketID(ticketID);
             if(valid == false){
                 JOptionPane.showMessageDialog(null, "The Ticket ID entered is incorrect.","No Ticket ID",JOptionPane.ERROR_MESSAGE);
                 jtf2.setText("");
                 jtf2.requestFocus();
             }else if(valid == true){
                 ETicket et = exchangeControl.getTicketExchangeDetail(ticketID);
                 String busType = exchangeControl.getBusType(et.getBusID());
             /*    System.out.println(busType);
                 System.out.println(et.getDestination());
                 System.out.println(et.getBusID());
                 System.out.println(et.getScheduleID());
                 System.out.println(et.getSeatID());
                 System.out.println(et.getStatus());
                 System.out.println(et.getTicketID());*/
                 
                dispose();
                new ExchangeSchedule(et,busType,staffID,position);
             }
             
            }
            
        });
        addWindowListener(new WindowListener());
         setTitle("Ticket Exchange");
        setSize(1000,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }
    
    
    public static void main(String []args){
          try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
              new TicketExchange("S002","Staff");
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
               exchangeControl.closeDB();
            }
            
        }
    }
}