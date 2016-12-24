package ui;

import da.*;
import control.*;
import domain.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import org.jdesktop.swingx.JXDatePicker;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OrderFrame extends JFrame{
   // public ArrayList<VSchedule> vs = new ArrayList<VSchedule>();
    SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
    private JXDatePicker datePick=new JXDatePicker();
private OrderControl orderControl;
//private OrderDA orderDA;
private ArrayList<Route> routeList = new ArrayList<Route>();
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
    private JButton jbtSearchD = new JButton("Search Destination");
    private JButton jbtSearch = new JButton("Search");
    private JPanel jpCenterCenter = new JPanel(new FlowLayout());
    private JPanel jpTopTop = new JPanel(new FlowLayout());
    private JPanel jpTopBtm = new JPanel(new FlowLayout());
    private JLabel jlb1 = new JLabel(" ");
    private JPanel jpCenterTop = new  JPanel(new BorderLayout());
    private JPanel jpSpace = new JPanel(new GridLayout(2,2));
      private Font largeFont = new Font("Serif", Font.BOLD, 23);
      private Font smallFont = new Font("Serif", Font.PLAIN ,20);
      private JLabel jlbOrder = new JLabel("Order");
      private JPanel jpSouth = new JPanel(new GridLayout(4,1));
   //   private JLabel jlbInput = new JLabel("Schedule ID : ");
    //  private JTextField jtfInput = new JTextField(" ");
      private JButton jbtConfirm = new JButton("Confirm");
     
       private JTable productTable;
     private CustomTable tableModel;
   
       private DefaultComboBoxModel dcbomRouteList= new DefaultComboBoxModel();
    private JComboBox jcboRouteList = new JComboBox(dcbomRouteList);
   private DefaultComboBoxModel jcb= new DefaultComboBoxModel();
    private JComboBox jcbDestination = new JComboBox(jcb);
    
    
    public OrderFrame(int Valid,String SaleID,String StaffID,String Position,ArrayList<VSchedule> VS){
        setIcon();
      final ArrayList<VSchedule> vs = VS;
        final String position = Position;
        final int valid = Valid;
        final String saleID = SaleID;
        final String staffID = StaffID;
   
       
        orderControl = new OrderControl();
     
        
       
        //orderDA = new OrderDA();
        initComboBox();
      
                
        
        if(position.compareTo("Staff") == 0){
            jbtBus.setEnabled(false);
           // jbtStaff.setEnabled(false);
            jbtRoute.setEnabled(false);
            jbtBusSchedule.setEnabled(false);
            jbtReport.setEnabled(false);
        }else{
            jbtOrder.setEnabled(false);
            jbtTicketExchange.setEnabled(false);
            
        }
        
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
    
       
       datePick.setFormats(dateFormat);
    
       
        jpTopBtm.setBackground(new Color(204,255,255));
        jpTopTop.setBackground(new Color(204,255,255));
        jpTop.setBackground(new Color(204, 255, 255));
        jbtHome.setBackground(new Color(77, 195, 255));
        jbtBus.setBackground(new Color(77, 195, 255));
        jbtStaff.setBackground(new Color(77, 195, 255));
        jbtBusSchedule.setBackground(new Color(77, 195, 255));
        jbtOrder.setBackground(new Color(204, 255, 255));
        jbtTicketExchange.setBackground(new Color(77, 195, 255));
        jbtReport.setBackground(new Color(77, 195, 255));
        jbtRoute.setBackground(new Color(77,195,255));
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
       
    
        jcboRouteList.setFont(smallFont);
        jpCenter.add(jcboRouteList);
        jpCenter.add(jbtSearchD);
        jpCenter.add(jlbDate);
        jtf1.setColumns(10);
      //  jpCenter.add(jtf1);
        datePick.setFont(smallFont);
        jpCenter.add(datePick);
        jpCenter.add(jbtSearch);
        jlbDestination.setFont(smallFont);
        
        jbtSearchD.setFont(smallFont);
        jlbDate.setFont(smallFont);
        jtf1.setFont(smallFont);
        jbtSearch.setFont(smallFont);
        jpCenter1.add(jpCenterTop,BorderLayout.CENTER);
        jpCenterTop.setBackground(new Color(204,255,255));
        jpCenterTop.add(jpCenterCenter,BorderLayout.CENTER);
        jpCenterCenter.setBackground(new Color(204,255,255));
        jpCenterTop.add(jpSpace,BorderLayout.NORTH);
        jpSpace.setBackground(new Color(204,255,255));
        jpSpace.add(jlb1);
        jpSpace.add(jlb1);
        jpSpace.add(jlb1);
        jpSpace.add(jlb1);
   /*     String[] columnNames = {"Schedule ID",
                        "BusID",
                        "Destination",
                        "Departure Date",
                        "Departure Time",
                        "AvailableSeat"}; */
        
    //    Object[][] data = {};
        
        
        tableModel = new CustomTable();    
        productTable = new JTable(tableModel);
       
      // tableModel.retrieveRecordsByDestination("Kuala Lumpur");
       
        productTable.setBackground(new Color(204,255,255));
        JScrollPane scrollPane = new JScrollPane(productTable);
       
       //scrollPane.setSize(new Dimension(700,700));
       scrollPane.setPreferredSize(new Dimension(820,500));
     //  scrollPane.setSize(700, 700);
       JTableHeader header = productTable.getTableHeader();
       header.setBackground(Color.red);
       scrollPane.setBackground(new Color(204,255,255));
       jpCenterCenter. add(scrollPane);
      
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
      
        Schedule schedule = orderControl.getSchedule(selectedData);
        String date = dateFormat.format(schedule.getDepartDate());
        Bus bus = orderControl.checkBusType(schedule.getBusID());
       //  int option = JOptionPane.showConfirmDialog(null, "Are you sure you want have the order to go to " + schedule.getDestination() + " at " + dateFormat.format(schedule.getDepartDate()) +  " with the time " + schedule.getDepartTime() , "Order Confirmation" , JOptionPane.YES_NO_OPTION );
        int option = JOptionPane.showConfirmDialog(null,"       Confirmation \nDestination : " + schedule.getDestination() + "\nDeparture Date : " + schedule.getDepartDate() + "\nDeparture Time : " + schedule.getDepartTime(),"Order Confirmation",JOptionPane.YES_NO_OPTION);
      //  Schedule schedule = new Schedule();
         if(option == JOptionPane.YES_OPTION){
             if(bus.getBusType().equals("Normal")){
                 dispose();
                  new SeatSelection(schedule,valid,saleID,staffID,position,vs);
                }
              else if(bus.getBusType().equals("Exclusive")){
                  dispose();
//             new SeatSelectionE(schedule,valid,saleID,staffID,position,vs);
        
         }
     
       
      }
      }
     });
       
       add(jpSouth,BorderLayout.SOUTH);
       jpSouth.add(new JLabel(" "    ));
         jpSouth.add(new JLabel(" "    ));
           jpSouth.add(new JLabel(" "    ));
             jpSouth.add(new JLabel(" "    ));
                jpSouth.setBackground(new Color(204,255,255));
   /*    jpSouth.add(jlbInput);
       jpSouth.add(jtfInput);
       jtfInput.setColumns(13);
       jpSouth.add(jbtConfirm);
       jpSouth.setBackground(new Color(204,255,255));
       jlbInput.setFont(smallFont);
       jtfInput.setFont(smallFont);
       jbtConfirm.setFont(smallFont);*/
       
       
      // jbtSearchD.addActionListener(new ButtonListener());
   //    jbtSearch.addActionListener(new ButtonListener1());
      
       /*private JButton jbtHome = new JButton("Home");
    private JButton jbtBus = new JButton("Bus");
    private JButton jbtStaff = new JButton("Staff");
    private JButton jbtRoute = new JButton("Route");
    private JButton jbtBusSchedule = new JButton("Bus Schedule");
    private JButton jbtOrder = new JButton("Order");
    private JButton jbtTicketExchange = new JButton("Ticket Exchange");
    private JButton jbtReport = new JButton("Report");
               */
                
       jbtHome.addActionListener(new ActionListener()
       {

            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the current process?","Exit Process Confirmation",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
               if(valid == 1){
                   for(int i =0;i<vs.size();i++){
                  orderControl.reverseSchedule(vs.get(i).getTotalSeat(),vs.get(i).getScheduleID());
                   }
                   orderControl.reverseTicket(saleID);
                   orderControl.deleteSale(saleID);
                   dispose();
                   new HomepageFrame(position,staffID);
               }
               else if(valid == 0){
                   dispose();
                   new HomepageFrame(position,staffID);
               }
            }
            }
           
       });
       
        jbtBus.addActionListener(new ActionListener()
       {
  @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the current process?","Exit Process Confirmation",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
               if(valid == 1){
                   for(int i =0;i<vs.size();i++){
                  orderControl.reverseSchedule(vs.get(i).getTotalSeat(),vs.get(i).getScheduleID());
                   }
                   orderControl.reverseTicket(saleID);
                   orderControl.deleteSale(saleID);
                   dispose();
                   new MaintainBus(staffID,position);
               }
               else if(valid == 0){
                     dispose();
                   new MaintainBus(staffID,position);
               }
            }
            }
           
       });
         jbtStaff.addActionListener(new ActionListener()
       {

            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the current process?","Exit Process Confirmation",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
               if(valid == 1){
                    for(int i =0;i<vs.size();i++){
                 orderControl.reverseSchedule(vs.get(i).getTotalSeat(),vs.get(i).getScheduleID());
                   }
                    orderControl.reverseTicket(saleID);
                   orderControl.deleteSale(saleID);
                     dispose();
                   new MaintainStaff(position,staffID);
               }
               else if(valid == 0){
                    dispose();
                   new MaintainStaff(position,staffID);
               }
            }
            }
           
       });
          jbtRoute.addActionListener(new ActionListener()
       {

             @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the current process?","Exit Process Confirmation",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
               if(valid == 1){
                  for(int i =0;i<vs.size();i++){
                 orderControl.reverseSchedule(vs.get(i).getTotalSeat(),vs.get(i).getScheduleID());
                   }
                  orderControl.reverseTicket(saleID);
                   orderControl.deleteSale(saleID);
                    dispose();
                   new MaintainRoute(staffID,position);
               }
               else if(valid == 0){
                   dispose();
                   new MaintainRoute(staffID,position);
               }
            }
            }
           
       });
           jbtBusSchedule.addActionListener(new ActionListener()
       {

           @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the current process?","Exit Process Confirmation",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
               if(valid == 1){
                   for(int i =0;i<vs.size();i++){
                   orderControl.reverseSchedule(vs.get(i).getTotalSeat(),vs.get(i).getScheduleID());
                   }
                   orderControl.reverseTicket(saleID);
                   orderControl.deleteSale(saleID);
                  dispose();
                   new MaintainBusSchedule(staffID,position);
               }
               else if(valid == 0){
                   dispose();
                   new MaintainBusSchedule(staffID,position);
               }
            }
            }
           
       });
            jbtOrder.addActionListener(new ActionListener()
       {

           @Override
            public void actionPerformed(ActionEvent e) {
                
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the current process?","Exit Process Confirmation",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
               if(valid == 1){
                   
                    for(int i =0;i<vs.size();i++){
                       
                   orderControl.reverseSchedule(vs.get(i).getTotalSeat(),vs.get(i).getScheduleID());
                   }
                    orderControl.reverseTicket(saleID);
                   orderControl.deleteSale(saleID);
                   dispose();
                   new OrderLink(staffID,position);
                 
               }
               else if(valid == 0){
                        for(int i =0;i<vs.size();i++){
                    
                   orderControl.reverseSchedule(vs.get(i).getTotalSeat(),vs.get(i).getScheduleID());
                   }
                 dispose();
                  new OrderLink(staffID,position);
               }
            }
            }
           
       });
             jbtTicketExchange.addActionListener(new ActionListener()
       {

           @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the current process?","Exit Process Confirmation",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
               if(valid == 1){
                  for(int i =0;i<vs.size();i++){
                  orderControl.reverseSchedule(vs.get(i).getTotalSeat(),vs.get(i).getScheduleID());
                   }
                  orderControl.reverseTicket(saleID);
                   orderControl.deleteSale(saleID);
                   dispose();
//                   new TicketExchange(staffID,position);
               }
               else if(valid == 0){
                    dispose();
//                   new TicketExchange(staffID,position);
               }
            }
            }
           
       });
              jbtReport.addActionListener(new ActionListener()
       {

         @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the current process?","Exit Process Confirmation",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
               if(valid == 1){
                  for(int i =0;i<vs.size();i++){
                orderControl.reverseSchedule(vs.get(i).getTotalSeat(),vs.get(i).getScheduleID());
                   }
                  orderControl.reverseTicket(saleID);
                   orderControl.deleteSale(saleID);
                   dispose();
//                   new ReportFrame(position,staffID);
               }
               else if(valid == 0){
                   dispose();
//                   new ReportFrame(position,staffID);
               }
            }
            }
           
       });
                
                
       jbtSearchD.addActionListener(new ActionListener()
       {
             public void actionPerformed(ActionEvent e){
            try{
               
                Object selectedDestination = jcboRouteList.getSelectedItem();
                String selectedDestinationStr = null;
                if(selectedDestination != null){
                    selectedDestinationStr = selectedDestination.toString();
                }
                dispose();
                new OrderFrame1(selectedDestinationStr,valid, saleID,staffID,position,vs);
                
                             
            }catch(Exception ex){
                showErrorDialog(ex.toString());
            }
        }
       });
       
       jbtSearch.addActionListener(new ActionListener()
       {
              public void actionPerformed(ActionEvent e){
                 try{
                       Object selectedDestination = jcboRouteList.getSelectedItem();
                String selectedDestinationStr = null;
                if(selectedDestination != null){
                    selectedDestinationStr = selectedDestination.toString();
                }
             
                String strDate = dateFormat.format(datePick.getDate());
                dispose();
                new OrderFrame2(selectedDestinationStr,strDate,valid,saleID,staffID,position,vs);
                 }catch(Exception ex){
                showErrorDialog(ex.toString());
            }
             }
       });
      
       addWindowListener(new WindowListener());
        setTitle("Order");
        setSize(1000,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }
    
   
        
         public static void main(String[] args){
             
             try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
            ArrayList<VSchedule> vs = null;
        //     new OrderFrame(0,"SA0","S002","Staff",vs);
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
       
       
        
    }
         
       
         
         
         
       
         
          private void showErrorDialog(String message){
                JOptionPane.showMessageDialog(null, message,"DB ERROR", JOptionPane.ERROR_MESSAGE);
        }
          
           private class WindowListener extends WindowAdapter{
        public void windowClosing(WindowEvent e){
            int option = JOptionPane.showConfirmDialog(null,"Confirm return to the Login Page?","Confirm?",JOptionPane.WARNING_MESSAGE);
            if(option == JOptionPane.YES_OPTION){
                dispose();
              new LoginFrame();
                orderControl.closeDB();
            }else{
                
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
         
         private void initComboBox(){
             routeList = orderControl.getRouteList();
             for(int i=0; i<routeList.size();i++){
             dcbomRouteList.addElement(routeList.get(i).getdestination());
         }
         }
         
         private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }
}
         