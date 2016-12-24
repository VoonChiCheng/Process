package ui;
import da.BusTableModel;
import da.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.table.TableRowSorter;
import org.jdesktop.swingx.JXSearchField;
public class MaintainBus extends JFrame{
   
    Font buttonFont=new Font("Serif", Font.BOLD, 23);
    private Font largeFont = new Font("Serif", Font.BOLD, 23);
    private Font smallFont = new Font("Serif", Font.PLAIN ,20);
    private ImageIcon logo = new ImageIcon(getClass().getResource("logo.gif"));
    private JLabel jlblogo = new JLabel(logo);
    private JLabel jlbTitle=new JLabel("Maintain Bus");
    private JLabel jlbSearch=new JLabel("Search by Criteria:");
    private JButton jbtHome = new JButton("Home");
    private JButton jbtBus = new JButton("Bus");
     private JButton jbtRoute=new JButton("Route");
    private JButton jbtStaff = new JButton("Staff");
    private JButton jbtSchedule = new JButton("Bus Schedule");
    private JButton jbtOrder = new JButton("Order");
    private JButton jbtExchange= new JButton("Ticket Exchange");
    private JButton jbtReport = new JButton("Report");
    private JButton jbtAdd = new JButton("Add");
    private JButton jbtUpdate = new JButton("Update");
    private JButton jbtRefresh = new JButton("Refresh");
    private JButton jbtSearch = new JButton("Search");
    private JXSearchField jtfSearch=new JXSearchField();
    private TableRowSorter sorter;
    private BusTableModel busTable;
    private JTable tablemodel;
   private MaintainBus thisFrame; 
  
//   private MaintainBusSchedule scheduleFrame=null;
   private MaintainRoute routeFrame=null;
   private MaintainStaff staffFrame=null;
//   private ReportFrame reportFrame=null;
//   private TicketExchange ticketFrame=null;
//   private HomepageFrame homeFrame=null;

   private String position;
   private String staffID;
 JPanel jpNorth =new JPanel(new BorderLayout());
 JPanel jpNorthCenter=new JPanel();
 JPanel jpNorthLogo =new JPanel();
 JPanel jpCenter =new JPanel(new BorderLayout());
 JPanel jpSouth=new JPanel();
 JPanel jpCenterTop=new JPanel();
 JPanel jpCenterCenter=new JPanel();
 JPanel jpCenterSouth=new JPanel();
 private AddBusFrame addframe=null;
 private UpdateBusFrame updateframe=null;
 public MaintainBus(){
     
 }
 
 
public MaintainBus(String position,String staffID){
    thisFrame=this;
    
    setIcon();
    this.position=position;
    this.staffID=staffID;
    if(position.compareTo("Staff")==0){
        jbtBus.setEnabled(false);
        jbtStaff.setEnabled(true);
        jbtRoute.setEnabled(false);
        jbtSchedule.setEnabled(false);
        jbtReport.setEnabled(false);
    }else{
        jbtBus.setEnabled(true);
        jbtStaff.setEnabled(true);
        jbtRoute.setEnabled(true);
        jbtSchedule.setEnabled(true);
        jbtReport.setEnabled(true);
        jbtOrder.setEnabled(false);
        jbtExchange.setEnabled(false);
    }
     busTable=new BusTableModel();
    tablemodel=new JTable(busTable);
    sorter = new TableRowSorter(busTable);
    tablemodel.setRowSorter(sorter);
    jlbTitle.setFont(buttonFont);
    jlbSearch.setFont(buttonFont);
    jtfSearch.setPreferredSize(new Dimension(300,25));
    jpNorth.add(jpNorthLogo,BorderLayout.NORTH);
    jpNorth.add(jpNorthCenter,BorderLayout.CENTER);
    jpNorthLogo.add(jlblogo);
    jpNorthCenter.add(jbtHome);
    jpNorthCenter.add(jbtBus);
    jpNorthCenter.add(jbtStaff);
    jpNorthCenter.add(jbtRoute);
    jpNorthCenter.add(jbtSchedule);
    jpNorthCenter.add(jbtOrder);
    jpNorthCenter.add(jbtExchange);
    jpNorthCenter.add(jbtReport);
    jpCenter.add(jpCenterTop,BorderLayout.NORTH);
    jpCenter.add(jpCenterCenter,BorderLayout.CENTER);
    jpCenter.add(jpCenterSouth,BorderLayout.SOUTH);
    jpCenterTop.add(jlbTitle);
    jpCenterSouth.add(jbtAdd);
    jpCenterSouth.add(jbtUpdate);
    jpCenterSouth.add(jbtRefresh);
       
     
        tablemodel.setPreferredScrollableViewportSize(new Dimension(600, 150));
        tablemodel.setFillsViewportHeight(true);
        
        tablemodel.setBackground(new Color(204,255,255));
    JScrollPane scrollPane = new JScrollPane(tablemodel);
    jpCenterCenter.add(scrollPane);
    jpSouth.add(jlbSearch);
    jpSouth.add(jtfSearch);
    jpSouth.add(jbtSearch);
    
    jlbSearch.setHorizontalAlignment(JLabel.RIGHT);
    jpSouth.setBackground(new Color(204,255,255));
    jpCenter.setBackground(new Color(204,255,255));
    jpNorth.setBackground(new Color(204,255,255));
    jpNorthCenter.setBackground(new Color(204,255,255));
    jpNorthLogo.setBackground(new Color(204,255,255));
    jpCenterTop.setBackground(new Color(204,255,255));
    jpCenterCenter.setBackground(new Color(204,255,255));
    jpCenterSouth.setBackground(new Color(204,255,255));
    add(jpNorth,BorderLayout.NORTH);
    add(jpCenter,BorderLayout.CENTER);
    add(jpSouth,BorderLayout.SOUTH);
//      jbtBus.addActionListener(new BusListener());
       jbtStaff.addActionListener(new StaffListener());
       jbtRoute.addActionListener(new RouteListener());
       jbtSchedule.addActionListener(new ScheduleListener());
       jbtReport.addActionListener(new ReportListener());
       jbtOrder.addActionListener(new OrderListener());
       jbtExchange.addActionListener(new ExchangeListener());
        jbtRefresh.addActionListener(new RefreshListener());
     jbtHome.addActionListener(new HomeListener());
   jbtAdd.addActionListener(new CreateListener());
   jbtUpdate.addActionListener(new UpdateListener());
    addWindowListener(new WindowListener());
   jbtSearch.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent e) {
        String text = jtfSearch.getText();
        if (text.trim().length() == 0)
          sorter.setRowFilter(null);
        else
          sorter.setRowFilter(RowFilter.regexFilter(text));
      }
    });
    
        jbtHome.setBackground(new Color(77, 195, 255));
        jbtBus.setBackground(new Color(204, 255, 255));
        jbtStaff.setBackground(new Color(77, 195, 255));
        jbtRoute.setBackground(new Color(77, 195, 255));
        jbtSchedule.setBackground(new Color(77, 195, 255));
        jbtOrder.setBackground(new Color(77, 195, 255));
        jbtExchange.setBackground(new Color(77, 195, 255));
        jbtReport.setBackground(new Color(77, 195, 255));
        
        jbtHome.setFont(largeFont);
        jbtBus.setFont(largeFont);
        jbtStaff.setFont(largeFont);
        jbtRoute.setFont(largeFont);
        jbtSchedule.setFont(largeFont);
        jbtOrder.setFont(largeFont);
        jbtExchange.setFont(largeFont);
        jbtReport.setFont(largeFont);
        jbtAdd.setFont(smallFont);
        jbtUpdate.setFont(smallFont);
        jbtSearch.setFont(smallFont);
      jbtRefresh.setFont(smallFont);
       setIcon();
        setTitle("Maintain Bus");        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(1000,700);
        setLocationRelativeTo(null);
        setVisible(true);
}

private class UpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==jbtUpdate){
                if(updateframe==null)
                    updateframe=new UpdateBusFrame(position,staffID);
                if(!updateframe.isVisible())
                    updateframe.setVisible(true);
        }}}
public void refreshTable(){
    busTable.refreshTable();
}
private class RefreshListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        
        refreshTable();}}
private class CreateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {                        
            if(e.getSource()==jbtAdd){
                if(addframe==null)
                    addframe=new AddBusFrame(position,staffID);
                if(!addframe.isVisible())
                    addframe.setVisible(true);
        }}}
 private class WindowListener extends WindowAdapter{
        public void windowClosing(WindowEvent e){
            int option = JOptionPane.showConfirmDialog(null,"Confirm return to the Login Page?","Confirm?",JOptionPane.WARNING_MESSAGE);
            if(option == JOptionPane.YES_OPTION){
                dispose();
//                new LoginFrame();
              
            }
            
        }
    }
//private class BusListener implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {                        
//            if(e.getSource()==jbtBus){
//                if(busFrame==null)
//                    busFrame=new MaintainBus(position,staffID);
//                thisFrame.dispose();
//                if(!busFrame.isVisible())
//                    busFrame.setVisible(true);
//        }}}
private class StaffListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {                        
            if(e.getSource()==jbtStaff){
                if(staffFrame==null)
                    staffFrame=new MaintainStaff(position,staffID);
                thisFrame.dispose();
                if(!staffFrame.isVisible())
                    staffFrame.setVisible(true);
        }}}
private class HomeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {                        
            if(e.getSource()==jbtHome){
//                if(homeFrame==null)
////                    homeFrame=new HomepageFrame(position,staffID);
//                    thisFrame.dispose();
//                if(!homeFrame.isVisible())
//                    homeFrame.setVisible(true);
        }}}
private class RouteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {                        
            if(e.getSource()==jbtRoute){
                if(routeFrame==null)
                    routeFrame=new MaintainRoute(position,staffID);
                thisFrame.dispose();
                if(!routeFrame.isVisible())
                    routeFrame.setVisible(true);
        }}}
private class ScheduleListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {                        
            if(e.getSource()==jbtSchedule){
//                if(scheduleFrame==null)
////                    scheduleFrame=new MaintainBusSchedule(position,staffID);
//                thisFrame.dispose();
//                if(!scheduleFrame.isVisible())
//                    scheduleFrame.setVisible(true);
        }}}
private class ReportListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {                        
            if(e.getSource()==jbtReport){
//                if(reportFrame==null)
////                    reportFrame=new ReportFrame(position,staffID);
//                thisFrame.dispose();
//                if(!reportFrame.isVisible())
//                    reportFrame.setVisible(true);
        }}}
private class OrderListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {                        
            
                new OrderLink(position,staffID);
                thisFrame.dispose();
               
        }}
private class ExchangeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {                        
            if(e.getSource()==jbtExchange){
//                if(ticketFrame==null)
//                    ticketFrame=new TicketExchange(position,staffID);
                thisFrame.dispose();
//                if(!ticketFrame.isVisible())
//                    ticketFrame.setVisible(true);
        }}}
private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("bus-icon.jpg")));
    }
public static void main(String[] args) {
     try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
        new MaintainBus("","");
    }
}