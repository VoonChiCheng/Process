package ui;

import domain.Schedule;
import control.*;
import domain.ETicket;
import domain.Ticket;
import domain.TicketP;
import domain.VSchedule;
import java.awt.BorderLayout;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.*;

public class ExchangeSeatE extends JFrame{
    public String ticketID;
    ButtonGroup bg1 = new ButtonGroup();
 //   CheckboxGroup cbg;
    private ExchangeControl exchangeControl;
    SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        private JLabel jlbDate = new JLabel("Departure Date :");
   private JLabel jlbTime = new JLabel("Departure Time");
   private JTextField jtfDate = new JTextField();
   private JTextField jtfTime = new JTextField();
    
    private JPanel jpWest = new JPanel(new GridLayout(6,1));
    private JPanel jpEast  = new JPanel(new GridLayout(6,1));
    private JButton jbtHome = new JButton("Home");
    private JButton jbtBus = new JButton("Bus");
    private JButton jbtStaff = new JButton("Staff");
    private JButton jbtRoute = new JButton("Route");
    private JButton jbtBusSchedule = new JButton("Bus Schedule");
    private JButton jbtOrder = new JButton("Order");
    private JButton jbtTicketExchange = new JButton("Ticket Exchange");
    private JButton jbtReport = new JButton("Report");
    private JPanel jpTop = new JPanel(new BorderLayout());
    private JPanel jpTopTop = new JPanel(new FlowLayout());
    private JPanel jpTopBtm = new JPanel(new FlowLayout());
    private JLabel jlbTitle = new JLabel("Seat Selection for Ticket Exchange");
    private JPanel jpCenter = new JPanel(new BorderLayout());
    private JPanel jpLeft = new JPanel(new BorderLayout());
    private JPanel jpLeftTop = new JPanel(new GridLayout(4,2));
    private JLabel jlbDestination = new JLabel("Destination :");
    private JTextField jtfDestination = new JTextField("MELAKA");
   // private JLabel jlbPrice = new JLabel("Price :");
   // private JTextField jtfPrice = new JTextField("RM 12.20");
    private JLabel jlbPlateNo = new JLabel("Bus Plate No :");
    private JTextField jtfPlateNo = new JTextField("PAD1234");
    private JPanel jpLeftCenter = new JPanel(new GridLayout(5,5));
    private JPanel jpLeftRight = new JPanel(new BorderLayout());
    private JPanel jpLeftRightTop = new JPanel(new GridLayout(3,2));
    private JPanel jpLeftRightBtm = new JPanel(new GridLayout(8,4));
   // private JPanel jpRight = new JPanel(new BorderLayout());
    private JPanel jpSouth = new JPanel(new FlowLayout());
   // private JPanel jpRightCenter = new JPanel(new FlowLayout());
  //  private JPanel jpRightBtm = new JPanel(new FlowLayout());
   private JButton jbtBlank = new JButton(" ");
    private JButton jbtBlank1 = new JButton(" ");
    private JButton jbtBlank2= new JButton(" ");
    private JButton jbtBlank3 = new JButton(" ");
    private JButton jbtBlank4 = new JButton(" ");
    private JButton jbtBlank5 = new JButton(" ");
    private JButton jbtBlank6 = new JButton(" ");
    private JButton jbtBlank7 = new JButton(" ");
    private JButton jbt1 = new JButton("1");
    private JButton jbt2 = new JButton("2");
    private JButton jbt3 = new JButton("3");
    private JButton jbt4 = new JButton("4");
    private JButton jbt5 = new JButton("5");
    private JButton jbt6 = new JButton("6");
    private JButton jbt7 = new JButton("7");
    private JButton jbt8 = new JButton("8");
    private JButton jbt9 = new JButton(("9"));
    private JButton jbt10 = new JButton("10");
    private JButton jbt11 = new JButton("11");
    private JButton jbt12 = new JButton("12");
    private JButton jbt13 = new JButton("13");
    private JButton jbt14 = new JButton("14");
    private JButton jbt15 = new JButton("15");
    private JButton jbt16 = new JButton("16");
    private JButton jbt17 = new JButton("17");
    private JButton jbt18 = new JButton("18");
    private JButton jbt19 = new JButton("19");
    private JButton jbt20 = new JButton("20");
 /*   private JButton jbt21 = new JButton("21");
    private JButton jbt22 = new JButton("22");
    private JButton jbt23 = new JButton("23");
    private JButton jbt24 = new JButton("24");
    private JButton jbt25 = new JButton("25");
    private JButton jbt26 = new JButton("26");
    private JButton jbt27 = new JButton("27");
    private JButton jbt28 = new JButton("28");
    private JButton jbt29 = new JButton("29");
    private JButton jbt30 = new JButton("30");
    private JButton jbt31 = new JButton("31");
    private JButton jbt32 = new JButton("32");*/
    
    private JButton jbtGrey = new JButton(" ");
    private JButton jbtBlue = new JButton(" ");
    private JButton jbtGreen = new JButton(" ");
   private JLabel jlbGrey = new JLabel("  Unavailable");
   private JLabel jlbBlue = new JLabel("  Available");
   private JLabel jlbGreen = new JLabel("  Choosen");
   
   private JCheckBox jcb1 = new JCheckBox("1");
   private JCheckBox jcb2 = new JCheckBox("2");
   private JCheckBox jcb3 = new JCheckBox("3");
   private JCheckBox jcb4 = new JCheckBox("4");
   private JCheckBox jcb5 = new JCheckBox("5");
   private JCheckBox jcb6 = new JCheckBox("6");
   private JCheckBox jcb7 = new JCheckBox("7");
   private JCheckBox jcb8 = new JCheckBox("8");
   private JCheckBox jcb9 = new JCheckBox("9");
   private JCheckBox jcb10 = new JCheckBox("10");
   private JCheckBox jcb11 = new JCheckBox("11");
   private JCheckBox jcb12 = new JCheckBox("12");
   private JCheckBox jcb13 = new JCheckBox("13");
   private JCheckBox jcb14 = new JCheckBox("14");
   private JCheckBox jcb15 = new JCheckBox("15");
   private JCheckBox jcb16 = new JCheckBox("16");
   private JCheckBox jcb17 = new JCheckBox("17");
   private JCheckBox jcb18 = new JCheckBox("18");
   private JCheckBox jcb19 = new JCheckBox("19");
   private JCheckBox jcb20 = new JCheckBox("20");
/*   private JCheckBox jcb21 = new JCheckBox("21");
   private JCheckBox jcb22 = new JCheckBox("22");
   private JCheckBox jcb23 = new JCheckBox("23");
   private JCheckBox jcb24 = new JCheckBox("24");
   private JCheckBox jcb25 = new JCheckBox("25");
   private JCheckBox jcb26 = new JCheckBox("26");
   private JCheckBox jcb27 = new JCheckBox("27");
   private JCheckBox jcb28 = new JCheckBox("28");
   private JCheckBox jcb29 = new JCheckBox("29");
   private JCheckBox jcb30 = new JCheckBox("30");
   private JCheckBox jcb31 = new JCheckBox("31");
   private JCheckBox jcb32 = new JCheckBox("32");*/
   
   private JButton jbtConfirm = new JButton("Confirm");
   private JButton jbtBack = new JButton("Back");
   
   private JLabel jlbOrderNo = new JLabel("Sale No :");
   private JTextField jtfOrderNo = new JTextField("");
 
         
      private Font font = new Font("Serif",Font.PLAIN,18);
      private Font largeFont = new Font("Serif", Font.BOLD, 23);
      private Font smallFont = new Font("Serif", Font.PLAIN ,20);
     
    
    public ExchangeSeatE(Schedule Schedule,ETicket ET,String BusType,String StaffID,String Position){
        setIcon();
      //  cbg = new CheckboxGroup();
        final String busType = BusType;
        final ETicket et = ET;
        final String staffID = StaffID;
    final String position = Position;
        exchangeControl = new ExchangeControl();
        final Schedule schedule = Schedule;
        String busPlateNo = exchangeControl.getBusPlateNo(schedule.getBusID());
        
            final ArrayList<Ticket> ticket = exchangeControl.checkSeatAvailablity(schedule.getScheduleID());
        add(jpWest,BorderLayout.WEST);
        add(jpEast,BorderLayout.EAST);
        
        jpWest.add(new JLabel("                                                                                     "));
        jpEast.add(new JLabel("                                                     "));
        jpWest.setBackground(new Color(204,255,255));
        jpEast.setBackground(new Color(204,255,255));
                
    add(jpTop,BorderLayout.NORTH);
    jpTop.add(jpTopTop,BorderLayout.NORTH);
     jpTopTop.add(jbtHome);
        jpTopTop.add(jbtBus);
        jpTopTop.add(jbtStaff);
        jpTopTop.add(jbtRoute);
        jpTopTop.add(jbtBusSchedule);
        jpTopTop.add(jbtOrder);
        jpTopTop.add(jbtTicketExchange);
        jpTopTop.add(jbtReport);
        jpTop.add(jpTopBtm,BorderLayout.SOUTH);
        jpTopBtm.add(jlbTitle);
        
        if(position.compareTo("Staff") == 0){
            jbtBus.setEnabled(false);
            jbtStaff.setEnabled(false);
            jbtRoute.setEnabled(false);
            jbtBusSchedule.setEnabled(false);
            jbtReport.setEnabled(false);
        }else{
            jbtOrder.setEnabled(false);
            jbtTicketExchange.setEnabled(false);
            
        }
        
           jpTopBtm.setBackground(new Color(204,255,255));
        jpTopTop.setBackground(new Color(204,255,255));
        jpTop.setBackground(new Color(204, 255, 255));
        jbtHome.setBackground(new Color(77, 195, 255));
        jbtBus.setBackground(new Color(77, 195, 255));
        jbtStaff.setBackground(new Color(77, 195, 255));
        jbtRoute.setBackground(new Color(77,195,255));
        jbtBusSchedule.setBackground(new Color(77, 195, 255));
        jbtOrder.setBackground(new Color(77, 195, 255));
        jbtTicketExchange.setBackground(new Color(204, 255, 255));
        jbtReport.setBackground(new Color(77, 195, 255));
        jpCenter.setBackground(new Color(204,255,255));
        jbtHome.setFont(largeFont);
        jbtBus.setFont(largeFont);
        jbtStaff.setFont(largeFont);
        jbtRoute.setFont(largeFont);
        jbtBusSchedule.setFont(largeFont);
        jbtOrder.setFont(largeFont);
        jbtTicketExchange.setFont(largeFont);
        jbtReport.setFont(largeFont);
        jlbTitle.setFont(largeFont);
        jlbTitle.setForeground(Color.blue);
        
        
        add(jpCenter,BorderLayout.CENTER);
        jpCenter.add(jpLeft,BorderLayout.CENTER);
        jpLeft.add(jpLeftTop,BorderLayout.NORTH);
        jpLeftTop.add(jlbDestination);
        jpLeftTop.add(jtfDestination);
     //   jpLeftTop.add(jlbPrice);
      //  jpLeftTop.add(jtfPrice);
        jpLeftTop.add(jlbPlateNo);
        jpLeftTop.add(jtfPlateNo);
          jpLeftTop.add(jlbDate);
        jpLeftTop.add(jtfDate);
        jpLeftTop.add(jlbTime);
        jpLeftTop.add(jtfTime);
        jtfDestination.setEditable(false);
     //   jtfPrice.setEditable(false);
        jtfPlateNo.setEditable(false);
        jlbDestination.setFont(smallFont);
        jtfDestination.setFont(smallFont);
    //    jlbPrice.setFont(smallFont);
//        jtfPrice.setFont(smallFont);
        jlbPlateNo.setFont(smallFont);
        jtfPlateNo.setFont(smallFont);
         jlbDate.setFont(smallFont);
        jtfDate.setFont(smallFont);
        jlbTime.setFont(smallFont);
        jtfTime.setFont(smallFont);
        jtfDate.setEditable(false);
        jtfTime.setEditable(false);
        
          jtfPlateNo.setText(busPlateNo);
        jtfDestination.setText(schedule.getDestination());
     //   jtfPrice.setText("RM" + String.format("%.2f",schedule.getTicketPrice()));
        
        jtfDate.setText(dateFormat.format(schedule.getDepartDate()));
        jtfTime.setText(schedule.getDepartTime());
        
        jpLeft.add(jpLeftCenter,BorderLayout.CENTER);
        jpLeft.add(jpLeftRight,BorderLayout.EAST);
        jpLeftRight.add(jpLeftRightTop,BorderLayout.NORTH);
        jpLeftRight.add(jpLeftRightBtm,BorderLayout.CENTER);
        
      jpLeftCenter.add(jbt1);
        jpLeftCenter.add(jbt2);
        jpLeftCenter.add(jbtBlank1);
         jpLeftCenter.add(jbt3);
        jpLeftCenter.add(jbt4);
         jpLeftCenter.add(jbt5);
        jpLeftCenter.add(jbt6);
        jpLeftCenter.add(jbtBlank2);
         jpLeftCenter.add(jbt7);
        jpLeftCenter.add(jbt8);
         jpLeftCenter.add(jbt9);
        jpLeftCenter.add(jbt10);
        jpLeftCenter.add(jbtBlank3);
         jpLeftCenter.add(jbt11);
        jpLeftCenter.add(jbt12);
         jpLeftCenter.add(jbt13);
        jpLeftCenter.add(jbt14);
        jpLeftCenter.add(jbtBlank4);
           jpLeftCenter.add(jbt15);
        jpLeftCenter.add(jbt16);
         jpLeftCenter.add(jbt17);
        jpLeftCenter.add(jbt18);
        jpLeftCenter.add(jbtBlank5);
           jpLeftCenter.add(jbt19);
        jpLeftCenter.add(jbt20);
/*         jpLeftCenter.add(jbt21);
        jpLeftCenter.add(jbt22);
        jpLeftCenter.add(jbtBlank6);
           jpLeftCenter.add(jbt23);
        jpLeftCenter.add(jbt24);
         jpLeftCenter.add(jbt25);
        jpLeftCenter.add(jbt26);
        jpLeftCenter.add(jbtBlank7);
           jpLeftCenter.add(jbt27);
        jpLeftCenter.add(jbt28);
         jpLeftCenter.add(jbt29);
        jpLeftCenter.add(jbt30);
        jpLeftCenter.add(jbtBlank);
       jpLeftCenter.add(jbt31);
        jpLeftCenter.add(jbt32);*/
        
        jbtBlank.setEnabled(false);
        jbtBlank1.setEnabled(false);
        jbtBlank2.setEnabled(false);
        jbtBlank3.setEnabled(false);
        jbtBlank4.setEnabled(false);
        jbtBlank5.setEnabled(false);
        jbtBlank6.setEnabled(false);
        jbtBlank7.setEnabled(false);
      
        
      jbtBlank.setOpaque(false);
jbtBlank.setContentAreaFilled(false);
jbtBlank.setBorderPainted(false);
   jbtBlank1.setOpaque(false);
jbtBlank1.setContentAreaFilled(false);
jbtBlank1.setBorderPainted(false);
   jbtBlank2.setOpaque(false);
jbtBlank2.setContentAreaFilled(false);
jbtBlank2.setBorderPainted(false);
   jbtBlank3.setOpaque(false);
jbtBlank3.setContentAreaFilled(false);
jbtBlank3.setBorderPainted(false);
   jbtBlank4.setOpaque(false);
jbtBlank4.setContentAreaFilled(false);
jbtBlank4.setBorderPainted(false);
   jbtBlank6.setOpaque(false);
jbtBlank6.setContentAreaFilled(false);
jbtBlank6.setBorderPainted(false);
   jbtBlank7.setOpaque(false);
jbtBlank7.setContentAreaFilled(false);
jbtBlank7.setBorderPainted(false);
   jbtBlank5.setOpaque(false);
jbtBlank5.setContentAreaFilled(false);
jbtBlank5.setBorderPainted(false);
  
      jpLeftRightTop.add(jbtGrey);
      jpLeftRightTop.add(jlbGrey);
      jpLeftRightTop.add(jbtBlue);
      jpLeftRightTop.add(jlbBlue);
      jpLeftRightTop.add(jbtGreen);
      jpLeftRightTop.add(jlbGreen);
      
     // jbtGrey.setEnabled(false);
     // jbtBlue.setEnabled(false);
     // jbtGreen.setEnabled(false);
      jlbBlue.setFont(font);
      jlbGrey.setFont(font);
      jlbGreen.setFont(font);
      
      jbtGrey.setBackground(Color.gray);
      jbtBlue.setBackground(Color.cyan
      );
      jbtGreen.setBackground(Color.GREEN);
        
    jpLeftRightBtm.add(jcb1);
    jpLeftRightBtm.add(jcb2);
    jpLeftRightBtm.add(jcb3);
    jpLeftRightBtm.add(jcb4);
    jpLeftRightBtm.add(jcb5);
    jpLeftRightBtm.add(jcb6);
    jpLeftRightBtm.add(jcb7);
    jpLeftRightBtm.add(jcb8);
    jpLeftRightBtm.add(jcb9);
    jpLeftRightBtm.add(jcb10);
    jpLeftRightBtm.add(jcb11);
    jpLeftRightBtm.add(jcb12);
    jpLeftRightBtm.add(jcb13);
    jpLeftRightBtm.add(jcb14);
    jpLeftRightBtm.add(jcb15);
    jpLeftRightBtm.add(jcb16);
    jpLeftRightBtm.add(jcb17);
    jpLeftRightBtm.add(jcb18);
    jpLeftRightBtm.add(jcb19);
    jpLeftRightBtm.add(jcb20);
 /*   jpLeftRightBtm.add(jcb21);
    jpLeftRightBtm.add(jcb22);
    jpLeftRightBtm.add(jcb23);
    jpLeftRightBtm.add(jcb24);
    jpLeftRightBtm.add(jcb25);
    jpLeftRightBtm.add(jcb26);
    jpLeftRightBtm.add(jcb27);
    jpLeftRightBtm.add(jcb28);
    jpLeftRightBtm.add(jcb29);
    jpLeftRightBtm.add(jcb30);
    jpLeftRightBtm.add(jcb31);
    jpLeftRightBtm.add(jcb32);*/
    
    jcb1.setFont(font);
    jcb2.setFont(font);
    jcb3.setFont(font);
    jcb4.setFont(font);
    jcb5.setFont(font);
    jcb6.setFont(font);
    jcb7.setFont(font);
    jcb8.setFont(font);
    jcb9.setFont(font);
    jcb10.setFont(font);
    jcb11.setFont(font);
    jcb12.setFont(font);
    jcb13.setFont(font);
    jcb14.setFont(font);
    jcb15.setFont(font);
    jcb16.setFont(font);
    jcb17.setFont(font);
    jcb18.setFont(font);
    jcb19.setFont(font);
    jcb20.setFont(font);
/*    jcb21.setFont(font);
    jcb22.setFont(font);
    jcb23.setFont(font);
    jcb24.setFont(font);
    jcb25.setFont(font);
    jcb26.setFont(font);
    jcb27.setFont(font);
    jcb28.setFont(font);
    jcb29.setFont(font);
    jcb30.setFont(font);
    jcb31.setFont(font);
    jcb32.setFont(font);
    */
    jbt1.setFont(font);
    jbt2.setFont(font);
    jbt3.setFont(font);
    jbt4.setFont(font);
    jbt5.setFont(font);
    jbt6.setFont(font);
    jbt7.setFont(font);
    jbt8.setFont(font);
    jbt9.setFont(font);
    jbt10.setFont(font);
    jbt11.setFont(font);
    jbt12.setFont(font);
    jbt13.setFont(font);
    jbt14.setFont(font);
    jbt15.setFont(font);
    jbt16.setFont(font);
    jbt17.setFont(font);
    jbt18.setFont(font);
    jbt19.setFont(font);
    jbt20.setFont(font);
   /* jbt21.setFont(font);
    jbt22.setFont(font);
    jbt23.setFont(font);
    jbt24.setFont(font);
    jbt25.setFont(font);
    jbt26.setFont(font);
    jbt27.setFont(font);
    jbt28.setFont(font);
    jbt29.setFont(font);
    jbt30.setFont(font);
    jbt31.setFont(font);
    jbt32.setFont(font);*/
    
    jbt1.setBackground(Color.cyan);
     jbt2.setBackground(Color.cyan);
      jbt20.setBackground(Color.cyan);
       jbt12.setBackground(Color.cyan);
       
  //  jbt9.setBackground(Color.green);
    jbt10.setBackground(Color.cyan);
   // jbt25.setBackground(Color.cyan);
    jbt15.setBackground(Color.cyan);
    
    jbt3.setBackground(Color.cyan);
    jbt4.setBackground(Color.cyan);
    jbt5.setBackground(Color.cyan);
    jbt6.setBackground(Color.cyan);
    jbt7.setBackground(Color.cyan);
    jbt8.setBackground(Color.cyan);
    jbt9.setBackground(Color.cyan);
    jbt11.setBackground(Color.cyan);
    jbt13.setBackground(Color.cyan);
    jbt14.setBackground(Color.cyan);
    jbt16.setBackground(Color.cyan);
    jbt17.setBackground(Color.cyan);
    jbt18.setBackground(Color.cyan);
    jbt19.setBackground(Color.cyan);
 /*   jbt21.setBackground(Color.cyan);
    jbt22.setBackground(Color.cyan);
    jbt23.setBackground(Color.cyan);
    jbt24.setBackground(Color.cyan);
    jbt26.setBackground(Color.cyan);
    jbt27.setBackground(Color.cyan);
    jbt28.setBackground(Color.cyan);
    jbt29.setBackground(Color.cyan);
    jbt30.setBackground(Color.cyan);
    jbt31.setBackground(Color.cyan);
    jbt32.setBackground(Color.cyan);*/
    
    
    bg1.add(jcb1);
    bg1.add(jcb2);
    bg1.add(jcb3);
    bg1.add(jcb4);
    bg1.add(jcb5);
    bg1.add(jcb6);
    bg1.add(jcb7);
    bg1.add(jcb8);
    bg1.add(jcb9);
    bg1.add(jcb10);
    bg1.add(jcb11);
    bg1.add(jcb12);
    bg1.add(jcb13);
    bg1.add(jcb14);
    bg1.add(jcb15);
    bg1.add(jcb16);
    bg1.add(jcb17);
    bg1.add(jcb18);
    bg1.add(jcb19);
    bg1.add(jcb20);
   /* bg1.add(jcb21);
    bg1.add(jcb22);
    bg1.add(jcb23);
    bg1.add(jcb24);
    bg1.add(jcb25);
    bg1.add(jcb26);
    bg1.add(jcb27);
    bg1.add(jcb28);
    bg1.add(jcb29);
    bg1.add(jcb30);
    bg1.add(jcb31);
    bg1.add(jcb32);*/
    
    jcb1.addItemListener(new checkBoxListener());
    jcb2.addItemListener(new checkBoxListener());
    jcb3.addItemListener(new checkBoxListener());
    jcb4.addItemListener(new checkBoxListener());
    jcb5.addItemListener(new checkBoxListener());
    jcb6.addItemListener(new checkBoxListener());
    jcb7.addItemListener(new checkBoxListener());
    jcb8.addItemListener(new checkBoxListener());
    jcb9.addItemListener(new checkBoxListener());
    jcb10.addItemListener(new checkBoxListener());
    jcb11.addItemListener(new checkBoxListener());
    jcb12.addItemListener(new checkBoxListener());
    jcb13.addItemListener(new checkBoxListener());
    jcb14.addItemListener(new checkBoxListener());
    jcb15.addItemListener(new checkBoxListener());
    jcb16.addItemListener(new checkBoxListener());
    jcb17.addItemListener(new checkBoxListener());
    jcb18.addItemListener(new checkBoxListener());
    jcb19.addItemListener(new checkBoxListener());
    jcb20.addItemListener(new checkBoxListener());
/*    jcb21.addItemListener(new checkBoxListener());
    jcb22.addItemListener(new checkBoxListener());
    jcb23.addItemListener(new checkBoxListener());
    jcb24.addItemListener(new checkBoxListener());
    jcb25.addItemListener(new checkBoxListener());
    jcb26.addItemListener(new checkBoxListener());
    jcb27.addItemListener(new checkBoxListener());
    jcb28.addItemListener(new checkBoxListener());
    jcb29.addItemListener(new checkBoxListener());
    jcb30.addItemListener(new checkBoxListener());
    jcb31.addItemListener(new checkBoxListener());
    jcb32.addItemListener(new checkBoxListener());*/
    
    
   
                
    
    
 
  jbtConfirm.setMnemonic(KeyEvent.VK_C);
  jbtBack.setMnemonic(KeyEvent.VK_B);
  
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
        //            new ReportFrame(position,staffID);
            }
            }
           
       });
  
   jbtBack.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
             dispose();
             new ExchangeSchedule(et,busType,staffID,position);
            }
      
  });

   jbtConfirm.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                int oldSeat = exchangeControl.getOldSeatAvailability(et.getScheduleID());
                  if(jcb1.isSelected()){
                      exchangeControl.updateExchangeTicketOld(et.getTicketID());
                      exchangeControl.updateExchangeTicketNew(et.getSaleID(), ticket.get(0).getTicketID());
                       ticketID = ticket.get(0).getTicketID();
                    //  orderControl.updateTicket(ticket,0);
                   //   array1[0] = 1;
                  }
                  if(jcb2.isSelected()){
                      exchangeControl.updateExchangeTicketOld(et.getTicketID());
                      exchangeControl.updateExchangeTicketNew(et.getSaleID(), ticket.get(1).getTicketID());
                       ticketID = ticket.get(1).getTicketID();
                    //  orderControl.updateTicket(ticket,1);
                    //  array1[1] = 1;
                  }
                  if(jcb3.isSelected()){
                      exchangeControl.updateExchangeTicketOld(et.getTicketID());
                      exchangeControl.updateExchangeTicketNew(et.getSaleID(), ticket.get(2).getTicketID());
                       ticketID = ticket.get(2).getTicketID();
                    //  orderControl.updateTicket(ticket,2);
                      //  array1[2] = 1;
                  }
                   if(jcb4.isSelected()){
                       exchangeControl.updateExchangeTicketOld(et.getTicketID());
                      exchangeControl.updateExchangeTicketNew(et.getSaleID(), ticket.get(3).getTicketID());
                       ticketID = ticket.get(3).getTicketID();
                   //   orderControl.updateTicket(ticket,3);
                        //array1[3] = 1;
                  }
                    if(jcb5.isSelected()){
                        exchangeControl.updateExchangeTicketOld(et.getTicketID());
                      exchangeControl.updateExchangeTicketNew(et.getSaleID(), ticket.get(4).getTicketID());
                       ticketID = ticket.get(4).getTicketID();
                   //   orderControl.updateTicket(ticket,4);
                       // array1[4] = 1;
                  }
                     if(jcb6.isSelected()){
                         exchangeControl.updateExchangeTicketOld(et.getTicketID());
                      exchangeControl.updateExchangeTicketNew(et.getSaleID(), ticket.get(5).getTicketID());
                       ticketID = ticket.get(5).getTicketID();
                   //   orderControl.updateTicket(ticket,5);
                       // array1[5] = 1;
                  }
                      if(jcb7.isSelected()){
                          exchangeControl.updateExchangeTicketOld(et.getTicketID());
                      exchangeControl.updateExchangeTicketNew(et.getSaleID(), ticket.get(6).getTicketID());
                       ticketID = ticket.get(6).getTicketID();
                   //   orderControl.updateTicket(ticket,6);
                     //   array1[6] = 1;
                  }
                       if(jcb8.isSelected()){
                           exchangeControl.updateExchangeTicketOld(et.getTicketID());
                      exchangeControl.updateExchangeTicketNew(et.getSaleID(), ticket.get(7).getTicketID());
                       ticketID = ticket.get(7).getTicketID();
                     // orderControl.updateTicket(ticket,7);
                      //  array1[7] = 1;
                  }
                        if(jcb9.isSelected()){
                            exchangeControl.updateExchangeTicketOld(et.getTicketID());
                      exchangeControl.updateExchangeTicketNew(et.getSaleID(), ticket.get(8).getTicketID());
                       ticketID = ticket.get(8).getTicketID();
                    //  orderControl.updateTicket(ticket,8);
                         //   array1[8] = 1;
                  }
                         if(jcb10.isSelected()){
                             exchangeControl.updateExchangeTicketOld(et.getTicketID());
                      exchangeControl.updateExchangeTicketNew(et.getSaleID(), ticket.get(9).getTicketID());
                       ticketID = ticket.get(9).getTicketID();
                   //   orderControl.updateTicket(ticket,9);
                          //   array1[9] = 1;
                  }
                          if(jcb11.isSelected()){
                              exchangeControl.updateExchangeTicketOld(et.getTicketID());
                      exchangeControl.updateExchangeTicketNew(et.getSaleID(), ticket.get(10).getTicketID());
                       ticketID = ticket.get(10).getTicketID();
                   //   orderControl.updateTicket(ticket,10);
                            //  array1[10] = 1;
                  }
                           if(jcb12.isSelected()){
                               exchangeControl.updateExchangeTicketOld(et.getTicketID());
                      exchangeControl.updateExchangeTicketNew(et.getSaleID(), ticket.get(11).getTicketID());
                       ticketID = ticket.get(11).getTicketID();
                     // orderControl.updateTicket(ticket,11);
                            //   array1[11] = 1;
                  }
                            if(jcb13.isSelected()){
                                exchangeControl.updateExchangeTicketOld(et.getTicketID());
                      exchangeControl.updateExchangeTicketNew(et.getSaleID(), ticket.get(12).getTicketID());
                       ticketID = ticket.get(12).getTicketID();
                     // orderControl.updateTicket(ticket,12);
                             //   array1[12] = 1;
                  }
                             if(jcb14.isSelected()){
                                 exchangeControl.updateExchangeTicketOld(et.getTicketID());
                      exchangeControl.updateExchangeTicketNew(et.getSaleID(), ticket.get(13).getTicketID());
                       ticketID = ticket.get(13).getTicketID();
                      //orderControl.updateTicket(ticket,13);
                               //  array1[13] = 1;
                  }
                              if(jcb15.isSelected()){
                                  exchangeControl.updateExchangeTicketOld(et.getTicketID());
                      exchangeControl.updateExchangeTicketNew(et.getSaleID(), ticket.get(14).getTicketID());
                       ticketID = ticket.get(14).getTicketID();
                     // orderControl.updateTicket(ticket,14);
                              //    array1[14] = 1;
                  }
                               if(jcb16.isSelected()){
                                   exchangeControl.updateExchangeTicketOld(et.getTicketID());
                      exchangeControl.updateExchangeTicketNew(et.getSaleID(), ticket.get(15).getTicketID());
                       ticketID = ticket.get(15).getTicketID();
                     // orderControl.updateTicket(ticket,15);
                                 //  array1[15] = 1;
                  }
                                if(jcb17.isSelected()){
                                    exchangeControl.updateExchangeTicketOld(et.getTicketID());
                      exchangeControl.updateExchangeTicketNew(et.getSaleID(), ticket.get(16).getTicketID());
                       ticketID = ticket.get(16).getTicketID();
                   //   orderControl.updateTicket(ticket,16);
                              //      array1[16] = 1;
                  }
                                 if(jcb18.isSelected()){
                                     exchangeControl.updateExchangeTicketOld(et.getTicketID());
                      exchangeControl.updateExchangeTicketNew(et.getSaleID(), ticket.get(17).getTicketID());
                       ticketID = ticket.get(17).getTicketID();
                    //  orderControl.updateTicket(ticket,17);
                                //     array1[17] = 1;
                  }
                                  if(jcb19.isSelected()){
                                      exchangeControl.updateExchangeTicketOld(et.getTicketID());
                      exchangeControl.updateExchangeTicketNew(et.getSaleID(), ticket.get(18).getTicketID());
                       ticketID = ticket.get(18).getTicketID();
                    //  orderControl.updateTicket(ticket,18);
                                 //     array1[18] = 1;
                  }
                                   if(jcb20.isSelected()){
                                       exchangeControl.updateExchangeTicketOld(et.getTicketID());
                      exchangeControl.updateExchangeTicketNew(et.getSaleID(), ticket.get(19).getTicketID());
                       ticketID = ticket.get(19).getTicketID();
                   //   orderControl.updateTicket(ticket,19);
                                  //     array1[19] = 1;
                  }
                                   
                                               
          JOptionPane.showMessageDialog(null,"Update Succesful, The ticket had been updated."); 
                    dispose();
                      String saleID = exchangeControl.getSaleID(ticketID);
                     ArrayList<TicketP> t = exchangeControl.getTicket(ticketID);
                        int newSeat = exchangeControl.getNewSeatAvailability(ticketID);
                        oldSeat += 1;
                        newSeat -= 1;
                        exchangeControl.updateOldSeat(oldSeat, et.getScheduleID());
                        exchangeControl.updateNewSeat(newSeat, t.get(0).getScheduleID());
                    new ExchangeSuccess(t,staffID,position);
                    JFrame frame1 = new JFrame();
           TicketFrame f = new TicketFrame(t);
           
          JScrollPane scrollpane = new JScrollPane(f);
//           frame1.add(f);
           frame1.add(scrollpane);
           scrollpane.setBackground(new Color(204,255,255));  //
         frame1.setTitle("Ticket");
           frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      //    frame1.setSize(200,200);
        //   frame.pack();
         //  frame.setLocationRelativeTo(null);
          // frame.setVisible(true);
           
         //  frame1.pack();
           frame1.setSize(700,800);
         frame1.setLocationRelativeTo(null);
          frame1.setVisible(true);
         
         
            }
            
                   
        });
  
    
    
    
    
    add(jpSouth,BorderLayout.SOUTH);
    jpSouth.add(jbtConfirm);
    jpSouth.add(jbtBack);
    
 //   add(jpRight,BorderLayout.EAST);
  //  jpRight.add(jpRightCenter,BorderLayout.NORTH);
  //  jpRightCenter.add(jlbOrderNo);
  //  jpRightCenter.add(jtfOrderNo);
    jtfOrderNo.setColumns(14);
    jtfOrderNo.setEditable(false);
    
  //  jpRight.add(jpRightBtm,BorderLayout.CENTER);
    
      String[] columnNames = {"Schedule ID",
                        "Bus ID",
                        "Destination",
                           "Depart Date",
                        "Depart Time",
                        "Seat No"};
        
        Object[][] data = {};
       
        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
       
        JScrollPane scrollPane = new JScrollPane(table);
   //     jpRightBtm.add(scrollPane);
        jpLeftRight.setBackground(new Color(204,255,255));
        jpLeftRightTop.setBackground(new Color(204,255,255));
        jpLeftRightBtm.setBackground(new Color(204,255,255));
     //   jpRightCenter.setBackground(new Color(204,255,255));
        table.setBackground(new Color(204,255,255));
    //    jpRightBtm.setBackground(new Color(204,255,255));
        jpLeftCenter.setBackground(new Color(204,255,255));
        jpLeftTop.setBackground(new Color(204,255,255));
        jcb1.setBackground(new Color(204,255,255));
        jcb2.setBackground(new Color(204,255,255));
        jcb3.setBackground(new Color(204,255,255));
        jcb4.setBackground(new Color(204,255,255));
        jcb5.setBackground(new Color(204,255,255));
        jcb6.setBackground(new Color(204,255,255));
        jcb7.setBackground(new Color(204,255,255));
        jcb8.setBackground(new Color(204,255,255));
        jcb9.setBackground(new Color(204,255,255));
        jcb10.setBackground(new Color(204,255,255));
        jcb11.setBackground(new Color(204,255,255));
        jcb12.setBackground(new Color(204,255,255));
        jcb13.setBackground(new Color(204,255,255));
        jcb14.setBackground(new Color(204,255,255));
        jcb15.setBackground(new Color(204,255,255));
        jcb16.setBackground(new Color(204,255,255));
        jcb17.setBackground(new Color(204,255,255));
        jcb18.setBackground(new Color(204,255,255));
        jcb19.setBackground(new Color(204,255,255));
        jcb20.setBackground(new Color(204,255,255));
      
        
        jcb1.setEnabled(false);
         jcb2.setEnabled(false);
          jcb12.setEnabled(false);
           jcb20.setEnabled(false);
           jbt10.setBackground(Color.cyan);
           jbt15.setBackground(Color.cyan);
          
        
           checkSeat(ticket);
        
        jpSouth.setBackground(new Color(204,255,255));
        
        jlbOrderNo.setFont(smallFont);
        jtfOrderNo.setFont(smallFont);
        jbtConfirm.setFont(smallFont);
        jbtBack.setFont(smallFont);
         
        
        addWindowListener(new WindowListener());
        setTitle("Seat Selection");
        setSize(1000,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
}
    
      public static void main(String[] args){
            try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
//             new ExchangeSeat();
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
        
    }
      
      class checkBoxListener implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
             JCheckBox jcb = (JCheckBox) e.getSource();
          if(jcb == jcb1){
              if(jcb1.isSelected()){
                  jbt1.setBackground(Color.green);
              }
              else{
                  jbt1.setBackground(Color.cyan);
              }
          }
          else if(jcb == jcb2){
              if(jcb2.isSelected()){
                  jbt2.setBackground(Color.green);
              }
              else{
                  jbt2.setBackground(Color.cyan);
              }
          }
          else if(jcb == jcb3){
              if(jcb3.isSelected())
              {
                  jbt3.setBackground(Color.green);
              }
              else {
                  jbt3.setBackground(Color.cyan);
              }
              
          }
             else if(jcb == jcb4){
              if(jcb4.isSelected())
              {
                  jbt4.setBackground(Color.green);
              }
              else {
                  jbt4.setBackground(Color.cyan);
              }
              
          }
            else if(jcb == jcb5){
              if(jcb5.isSelected())
              {
                  jbt5.setBackground(Color.green);
              }
              else {
                  jbt5.setBackground(Color.cyan);
              }  
          }
          else if(jcb == jcb6){
              if(jcb6.isSelected())
              {
                  jbt6.setBackground(Color.green);
              }
              else {
                  jbt6.setBackground(Color.cyan);
              }  
          }
           else if(jcb == jcb7){
              if(jcb7.isSelected())
              {
                  jbt7.setBackground(Color.green);
              }
              else {
                  jbt7.setBackground(Color.cyan);
              }  
          }
          else if(jcb == jcb8){
              if(jcb8.isSelected())
              {
                  jbt8.setBackground(Color.green);
              }
              else {
                  jbt8.setBackground(Color.cyan);
              }  
          }
            else if(jcb == jcb9){
              if(jcb9.isSelected())
              {
                  jbt9.setBackground(Color.green);
              }
              else {
                  jbt9.setBackground(Color.cyan);
              }  
          }
           else if(jcb == jcb10){
              if(jcb10.isSelected())
              {
                  jbt10.setBackground(Color.green);
              }
              else {
                  jbt10.setBackground(Color.cyan);
              }  
          }
            else if(jcb == jcb11){
              if(jcb11.isSelected())
              {
                  jbt11.setBackground(Color.green);
              }
              else {
                  jbt11.setBackground(Color.cyan);
              }  
          }
           else if(jcb == jcb12){
              if(jcb12.isSelected())
              {
                  jbt12.setBackground(Color.green);
              }
              else {
                  jbt12.setBackground(Color.cyan);
              }  
          }
           else if(jcb == jcb13){
              if(jcb13.isSelected())
              {
                  jbt13.setBackground(Color.green);
              }
              else {
                  jbt13.setBackground(Color.cyan);
              }  
          }
          if(jcb == jcb14){
              if(jcb14.isSelected()){
                  jbt14.setBackground(Color.green);
              }
              else{
                  jbt14.setBackground(Color.cyan);
              }
          }
        if(jcb == jcb15){
              if(jcb15.isSelected()){
                  jbt15.setBackground(Color.green);
              }
              else{
                  jbt15.setBackground(Color.cyan);
              }
          }
         if(jcb == jcb16){
              if(jcb16.isSelected()){
                  jbt16.setBackground(Color.green);
              }
              else{
                  jbt16.setBackground(Color.cyan);
              }
          }
         if(jcb == jcb17){
              if(jcb17.isSelected()){
                  jbt17.setBackground(Color.green);
              }
              else{
                  jbt17.setBackground(Color.cyan);
              }
          }
         if(jcb == jcb18){
              if(jcb18.isSelected()){
                  jbt18.setBackground(Color.green);
              }
              else{
                  jbt18.setBackground(Color.cyan);
              }
          }
          if(jcb == jcb19){
              if(jcb19.isSelected()){
                  jbt19.setBackground(Color.green);
              }
              else{
                  jbt19.setBackground(Color.cyan);
              }
          }
              if(jcb == jcb20){
              if(jcb20.isSelected()){
                  jbt20.setBackground(Color.green);
              }
              else{
                  jbt20.setBackground(Color.cyan);
              }
          }
       
          
      }
      }
      
      
       
            
       public void checkSeat(ArrayList<Ticket> ticket){
           String check = "Sold";
         //  ArrayList<> test = new ArrayList<>();
         if(ticket.get(0).getStatus().equals(check )){
             jbt1.setBackground(Color.gray);
             jcb1.setEnabled(false);
         }
         
        if(ticket.get(1).getStatus().equals(check )){
             jbt2.setBackground(Color.gray);
             jcb2.setEnabled(false);
         }
        if(ticket.get(2).getStatus().equals(check )){
             jbt3.setBackground(Color.gray);
             jcb3.setEnabled(false);
         }
         if(ticket.get(3).getStatus().equals(check )){
             jbt4.setBackground(Color.gray);
             jcb4.setEnabled(false);
         }
          if(ticket.get(4).getStatus().equals(check )){
             jbt5.setBackground(Color.gray);
             jcb5.setEnabled(false);
         }
           if(ticket.get(5).getStatus().equals(check )){
             jbt6.setBackground(Color.gray);
             jcb6.setEnabled(false);
         }
          if(ticket.get(6).getStatus().equals(check )){
             jbt7.setBackground(Color.gray);
             jcb7.setEnabled(false);
         }
        if(ticket.get(7).getStatus().equals(check )){
             jbt8.setBackground(Color.gray);
             jcb8.setEnabled(false);
         }
         if(ticket.get(8).getStatus().equals(check )){
             jbt9.setBackground(Color.gray);
             jcb9.setEnabled(false);
         }
          if(ticket.get(9).getStatus().equals(check )){
             jbt10.setBackground(Color.gray);
             jcb10.setEnabled(false);
         }
           if(ticket.get(10).getStatus().equals(check )){
             jbt11.setBackground(Color.gray);
             jcb11.setEnabled(false);
         }
             if(ticket.get(11).getStatus().equals(check )){
             jbt12.setBackground(Color.gray);
             jcb12.setEnabled(false);
         }
               if(ticket.get(12).getStatus().equals(check )){
             jbt13.setBackground(Color.gray);
             jcb13.setEnabled(false);
         }
          if(ticket.get(13).getStatus().equals(check )){
             jbt14.setBackground(Color.gray);
             jcb14.setEnabled(false);
         }
            if(ticket.get(14).getStatus().equals(check )){
             jbt15.setBackground(Color.gray);
             jcb15.setEnabled(false);
         }
             if(ticket.get(15).getStatus().equals(check )){
             jbt16.setBackground(Color.gray);
             jcb16.setEnabled(false);
         }
               if(ticket.get(16).getStatus().equals(check )){
             jbt17.setBackground(Color.gray);
             jcb17.setEnabled(false);
         }
              if(ticket.get(17).getStatus().equals(check )){
             jbt18.setBackground(Color.gray);
             jcb18.setEnabled(false);
         }
             if(ticket.get(18).getStatus().equals(check )){
             jbt19.setBackground(Color.gray);
             jcb19.setEnabled(false);
         }
               if(ticket.get(19).getStatus().equals(check )){
             jbt20.setBackground(Color.gray);
             jcb20.setEnabled(false);
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