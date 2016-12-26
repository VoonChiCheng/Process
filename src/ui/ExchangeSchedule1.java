package ui;

import control.ExchangeControl;
import da.CustomTable;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;
import domain.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.jdesktop.swingx.JXDatePicker;


public class ExchangeSchedule1 extends JFrame{
    SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
    private JXDatePicker datePick=new JXDatePicker();
      private ExchangeControl exchangeControl;
     private ImageIcon logo = new ImageIcon(getClass().getResource("logo.gif"));
     
         private JLabel jlblogo = new JLabel(logo);

    private JButton jbtHome = new JButton("Home");
    private JButton jbtBus = new JButton("Bus");
    private JButton jbtStaff = new JButton("Staff");
    private JButton jbtRoute = new JButton("Route");
    private JButton jbtBusSchedule = new JButton("Bus Schedule");
    private JButton jbtOrder = new JButton("Order");
    private JButton jbtTicketExchange = new JButton("Ticket Exchange");
    private JButton jbtReport = new JButton("Report");
    private JPanel jpTop = new JPanel(new BorderLayout());
    private JPanel jpCenter1 = new JPanel(new BorderLayout());
    private JPanel jpCenter = new JPanel(new FlowLayout());
    private JLabel jlbDestination = new JLabel("Destination :");
   private JLabel jlbDate = new JLabel("    Departure Date :");
   private JTextField jtf1 = new HintTextField("dd/mm/yyyy");
   private JTextField jtf = new JTextField(" ");
 
    private JButton jbtSearch = new JButton("Search");
    private JPanel jpCenterCenter = new JPanel(new FlowLayout());
    private JPanel jpTopTop = new JPanel(new FlowLayout());
    private JPanel jpTopBtm = new JPanel(new FlowLayout());
    private JLabel jlb1 = new JLabel(" ");
    private JPanel jpCenterTop = new  JPanel(new BorderLayout());
    private JPanel jpSpace = new JPanel(new GridLayout(2,2));
      private Font largeFont = new Font("Serif", Font.BOLD, 23);
      private Font smallFont = new Font("Serif", Font.PLAIN ,20);
   //   private JLabel jlbOrder = new JLabel("Order");
      private JPanel jpSouth = new JPanel(new GridLayout(4,1));
   //   private JLabel jlbInput = new JLabel("Schedule ID : ");
//      private JTextField jtfInput = new JTextField(" ");
  //    private JButton jbtConfirm = new JButton("Confirm");
       private JTable productTable;
     private CustomTable tableModel;

    
    public ExchangeSchedule1(ETicket ET,String BusType,String date,String StaffID,String Position) throws ParseException{
        setIcon();
        exchangeControl = new ExchangeControl();
     final ETicket et = ET;
       final String busType = BusType;
       final String staffID = StaffID;
    final String position = Position;
        add(jpTop,BorderLayout.NORTH);
        add(jpCenter1,BorderLayout.CENTER);
        jpCenter1.add(jpCenter,BorderLayout.NORTH);
        jpTop.add(jpTopTop,BorderLayout.CENTER);
       jpTop.add(jpTopBtm,BorderLayout.NORTH);
        jpTopTop.add(jbtHome);
        jpTopTop.add(jbtBus);
        jpTopTop.add(jbtStaff);
        jpTopTop.add(jbtRoute);
        jpTopTop.add(jbtBusSchedule);
        jpTopTop.add(jbtOrder);
        jpTopTop.add(jbtTicketExchange);
        jpTopTop.add(jbtReport);
       jpTopBtm.add(jlblogo);
    
       
      if(position.compareTo("Staff") == 0){
            jbtBus.setEnabled(false);
          //  jbtStaff.setEnabled(false);
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
        jbtBusSchedule.setFont(largeFont);
        jbtOrder.setFont(largeFont);
        jbtTicketExchange.setFont(largeFont);
        jbtReport.setFont(largeFont);
        jbtRoute.setFont(largeFont);
       
        jpCenter.add(jlbDestination);
 
        jpCenter.add(jtf);
       jpCenter.add(datePick);
        jtf1.setColumns(10);
     //   jpCenter.add(jtf1);
        jpCenter.add(jbtSearch);
        jlbDestination.setFont(smallFont);
        jtf.setFont(smallFont);
        jlbDate.setFont(smallFont);
        jtf1.setFont(smallFont);
        jbtSearch.setFont(smallFont);
        
         datePick.setFormats(dateFormat);
         datePick.setFont(smallFont);
         
      
        jpCenter1.add(jpCenterTop,BorderLayout.CENTER);
        jpCenterTop.setBackground(new Color(204,255,255));
        jpCenterTop.add(jpCenterCenter,BorderLayout.CENTER);
        jpCenterCenter.setBackground(new Color(204,255,255));
        jpCenterTop.add(jpSpace,BorderLayout.NORTH);
        jpSpace.setBackground(new Color(204,255,255));
        jtf.setColumns(10);
        jtf.setText(et.getDestination());
        jtf.setEditable(false);
        jpSpace.add(jlb1);
        jpSpace.add(jlb1);
       jpSpace.add(jlb1);
        jpSpace.add(jlb1);
          Date dateP = dateFormat.parse(date);
       datePick.setDate(dateP);
   /*     String[] columnNames = {"Schedule ID",
                        "BusID",
                        "Destination",
                        "Departure Date",
                        "Departure Time",
                        "AvailableSeat"};
        
        Object[][] data = {};
       
        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(800, 70));
        table.setFillsViewportHeight(true);*/
        
       
       tableModel = new CustomTable();    
        tableModel.retrieveExchangeTicketByDate(et.getDestination(), busType,date,et.getScheduleID());
        productTable = new JTable(tableModel);
      // tableModel.retrieveRecordsByDestination("Kuala Lumpur");
       
        productTable.setBackground(new Color(204,255,255));
        JScrollPane scrollPane = new JScrollPane(productTable);
       //scrollPane.setSize(new Dimension(700,700));
       scrollPane.setPreferredSize(new Dimension(800,500));
 
        //Add the scroll pane to this panel.
       jpCenterCenter. add(scrollPane);
       //productTable.setFont(smallFont);
       productTable.setBackground(new Color(204,255,255));
       
           ListSelectionModel cellSelectionModel = productTable.getSelectionModel();
    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) {
        String selectedData = null;

        int[] selectedRow =productTable.getSelectedRows();
        //int[] selectedColumns = productTable.getSelectedColumns();
        

        for (int i = 0; i < selectedRow.length; i++) {
       //   for (int j = 0; j < selectedColumns.length; j++) {
            selectedData = (String) productTable.getValueAt(selectedRow[0],0);
       //   }
        }
      
        Schedule schedule = exchangeControl.getSchedule(selectedData);
        String date = dateFormat.format(schedule.getDepartDate());
        
       //  int option = JOptionPane.showConfirmDialog(null, "Are you sure you want have the order to go to " + schedule.getDestination() + " at " + dateFormat.format(schedule.getDepartDate()) +  " with the time " + schedule.getDepartTime() , "Order Confirmation" , JOptionPane.YES_NO_OPTION );
        int option = JOptionPane.showConfirmDialog(null,"       Confirmation \nDestination : " + schedule.getDestination() + "\nDeparture Date : " + schedule.getDepartDate() + "\nDeparture Time : " + schedule.getDepartTime(),"Order Confirmation",JOptionPane.YES_NO_OPTION);
      //  Schedule schedule = new Schedule();
         if(option == JOptionPane.YES_OPTION){
             if(busType.equals("Normal")){
                 dispose();
//           new ExchangeSeat(schedule,et,busType,staffID,position);
                }
              else if(busType.equals("Exclusive")){
                  dispose();
      //      new ExchangeSeatE(schedule,et,busType,staffID,position);
        
         }
     
       
      }
     
       
      }
      
     });
    
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
//                    new ReportFrame(position,staffID);
            }
            }
           
       });
    
     jbtSearch.addActionListener(new ActionListener()
       {
              public void actionPerformed(ActionEvent e){
                 try{
                     //  Object selectedDestination = jcboRouteList.getSelectedItem();
         //       String selectedDestinationStr = null;
             //   if(selectedDestination != null){
                  //  selectedDestinationStr = selectedDestination.toString();
             //   }
             
                String strDate = dateFormat.format(datePick.getDate());
                dispose();
                new ExchangeSchedule1( et, busType,strDate,staffID,position);
                 }catch(Exception ex){
                showErrorDialog(ex.toString());
            }
             }
       });
       
       add(jpSouth,BorderLayout.SOUTH);
       jpSouth.add(new JLabel(" "    ));
         jpSouth.add(new JLabel(" "    ));
           jpSouth.add(new JLabel(" "    ));
             jpSouth.add(new JLabel(" "    ));
                jpSouth.setBackground(new Color(204,255,255));
     //  jpSouth.add(jlbInput);
//       jpSouth.add(jtfInput);
      // jtfInput.setColumns(13);
   //    jpSouth.add(jbtConfirm);
    //   jpSouth.setBackground(new Color(204,255,255));
    //   jlbInput.setFont(smallFont);
    //   jtfInput.setFont(smallFont);
     //  jbtConfirm.setFont(smallFont);
       
       
       

      addWindowListener(new WindowListener());
        setTitle("Ticket Exchange");
        setSize(1000,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }
    
   
        
         public static void main(String[] args){
               try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
          //   new ExchangeSchedule();
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
       
    }
         
         
          private void showErrorDialog(String message){
                JOptionPane.showMessageDialog(null, message,"DB ERROR", JOptionPane.ERROR_MESSAGE);
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
          
         class HintTextField extends JTextField implements FocusListener {

  private final String hint;
  private boolean showingHint;

  public HintTextField(final String hint) {
    super(hint);
    this.hint = hint;
    this.showingHint = true;
    super.addFocusListener(this);
  }

  @Override
  public void focusGained(FocusEvent e) {
    if(this.getText().isEmpty()) {
      super.setText("");
      showingHint = false;
    }
  }
  @Override
  public void focusLost(FocusEvent e) {
    if(this.getText().isEmpty()) {
      super.setText(hint);
      showingHint = true;
    }
  }

  @Override
  public String getText() {
    return showingHint ? "" : super.getText();
  }
         }
}
         
         