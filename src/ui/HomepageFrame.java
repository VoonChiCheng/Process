package ui;
import da.*;
import domain.*;
import control.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
public class HomepageFrame extends JFrame{
    Font buttonFont=new Font("Serif", Font.BOLD, 23);
    private Font largeFont = new Font("Serif", Font.BOLD, 23);
    private Font smallFont = new Font("Serif", Font.PLAIN ,20);
    private ImageIcon logo = new ImageIcon(getClass().getResource("logo.gif"));
    private JLabel jlblogo = new JLabel(logo);
    private JLabel jlbTitle=new JLabel("Homepage");
    private JButton jbtHome = new JButton("Home");
    private JButton jbtBus = new JButton("Bus");
     private JButton jbtRoute=new JButton("Route");
    private JButton jbtStaff = new JButton("Staff");
    private JButton jbtSchedule = new JButton("Bus Schedule");
    private JButton jbtOrder = new JButton("Order");
    private JButton jbtExchange= new JButton("Ticket Exchange");
    private JButton jbtReport= new JButton("Report");
   private JButton jbtLogout= new JButton("Logout");
   private JButton jbtChangePass= new JButton("Change Password");
   private HomepageFrame thisFrame;
   private MaintainBus busFrame=null;
//   private MaintainBusSchedule scheduleFrame=null;
   private MaintainRoute routeFrame=null;
   private MaintainStaff staffFrame=null;
//   private ReportFrame reportFrame=null;
//   private TicketExchange ticketFrame=null;
   private HomepageFrame homeFrame=null;
//   private ChangePasswordFrame passFrame=null;
   private String position;
   private String staffID;
 JPanel jpNorth =new JPanel(new BorderLayout());
 JPanel jpNorthCenter=new JPanel();
 JPanel jpNorthLogo =new JPanel(new BorderLayout());
 JPanel jpCenter =new JPanel(new BorderLayout());
 JPanel jpSouth=new JPanel();
 JPanel jpCenterTop=new JPanel();
 JPanel jpCenterCenter=new JPanel();
 JPanel jpCenterSouth=new JPanel();
 JPanel jpNorthCentercenter=new JPanel(new FlowLayout(FlowLayout.RIGHT));
 public HomepageFrame(){
     
 }
public HomepageFrame(String position,String staffID){
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
    jlbTitle.setFont(buttonFont);
   
    jpNorthCentercenter.add(jbtChangePass);
    jpNorthCentercenter.add(jbtLogout);
    jpNorth.add(jpNorthCentercenter,BorderLayout.NORTH);
    jpNorth.add(jpNorthLogo,BorderLayout.CENTER);
    jpNorth.add(jpNorthCenter,BorderLayout.SOUTH);
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
     
    
    
    jpSouth.setBackground(new Color(204,255,255));
    jpCenter.setBackground(new Color(204,255,255));
    jpNorth.setBackground(new Color(204,255,255));
    jpNorthCenter.setBackground(new Color(204,255,255));
    jpNorthCentercenter.setBackground(new Color(204,255,255));
    jpNorthLogo.setBackground(new Color(204,255,255));
    jpCenterTop.setBackground(new Color(204,255,255));
    jpCenterCenter.setBackground(new Color(204,255,255));
    jpCenterSouth.setBackground(new Color(204,255,255));
    add(jpNorth,BorderLayout.NORTH);
    add(jpCenter,BorderLayout.CENTER);
    add(jpSouth,BorderLayout.SOUTH);
    
        jbtHome.setBackground(new Color(204, 255, 255));
        jbtBus.setBackground(new Color(77, 195, 255));
        jbtStaff.setBackground(new Color(77, 195, 255));
        jbtRoute.setBackground(new Color(77, 195, 255));
        jbtSchedule.setBackground(new Color(77, 195, 255));
        jbtOrder.setBackground(new Color(77, 195, 255));
        jbtExchange.setBackground(new Color(77, 195, 255));
        jbtReport.setBackground(new Color(77, 195, 255));
        jbtLogout.setBackground(new Color(77, 195, 255));
        jbtChangePass.setBackground(new Color(77, 195, 255));
        jbtHome.setFont(largeFont);
        jbtBus.setFont(largeFont);
        jbtStaff.setFont(largeFont);
        jbtRoute.setFont(largeFont);
        jbtSchedule.setFont(largeFont);
        jbtOrder.setFont(largeFont);
        jbtExchange.setFont(largeFont);
        jbtReport.setFont(largeFont);
        jbtLogout.setFont(smallFont);
        jbtChangePass.setFont(smallFont);
        jbtLogout.addActionListener(new LogoutListener());
       jbtBus.addActionListener(new BusListener());
       jbtStaff.addActionListener(new StaffListener());
       jbtRoute.addActionListener(new RouteListener());
       jbtSchedule.addActionListener(new ScheduleListener());
       jbtReport.addActionListener(new ReportListener());
       jbtOrder.addActionListener(new OrderListener());
       jbtExchange.addActionListener(new ExchangeListener());
//       jbtHome.addActionListener(new HomeListener());
       jbtChangePass.addActionListener(new ChangeListener());
        setTitle("Homepage");        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(1000,700);
        setLocationRelativeTo(null);
        setVisible(true);
         addWindowListener(new WindowListener());
}
private class BusListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {                        
            if(e.getSource()==jbtBus){
                if(busFrame==null)
                    busFrame=new MaintainBus(position,staffID);
                thisFrame.dispose();
                if(!busFrame.isVisible())
                    busFrame.setVisible(true);
        }}}
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
//private class HomeListener implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {                        
//            if(e.getSource()==jbtHome){
//                if(homeFrame==null)
//                    homeFrame=new HomepageFrame(position,staffID);
//                    thisFrame.dispose();
//                if(!homeFrame.isVisible())
//                    homeFrame.setVisible(true);
//        }}}
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
//                    scheduleFrame=new MaintainBusSchedule(position,staffID);
//                thisFrame.dispose();
//                if(!scheduleFrame.isVisible())
//                    scheduleFrame.setVisible(true);
        }}}
private class ReportListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {                        
            if(e.getSource()==jbtReport){
//                if(reportFrame==null)
//                    reportFrame=new ReportFrame(position,staffID);
//                thisFrame.dispose();
//                if(!reportFrame.isVisible())
//                    reportFrame.setVisible(true);
        }}}
private class OrderListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {                        
            
              new OrderLink(staffID,position);
                thisFrame.dispose();
               
        }}
private class ExchangeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {                        
            if(e.getSource()==jbtExchange){
//                if(ticketFrame==null)
//                    ticketFrame=new TicketExchange(staffID,position);
//                thisFrame.dispose();
//                if(!ticketFrame.isVisible())
//                    ticketFrame.setVisible(true);
        }}}
private class ChangeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {                        
            if(e.getSource()==jbtChangePass){
//                if(passFrame==null)
//                    passFrame=new ChangePasswordFrame(position,staffID);
//       
//                if(!passFrame.isVisible())
//                    passFrame.setVisible(true);
        }}}
private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("bus-icon.jpg")));
    }
 private class WindowListener extends WindowAdapter{
        public void windowClosing(WindowEvent e){
            int option = JOptionPane.showConfirmDialog(null,"Confirm return to the Login Page?","Confirm?",JOptionPane.WARNING_MESSAGE);
            if(option == JOptionPane.YES_OPTION){
                dispose();
//                new LoginFrame();
              
            }
            
        }
    }
 private class LogoutListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {                        
           
              int option = JOptionPane.showConfirmDialog(null,"Are you sure you want to logout?","Confirm?",JOptionPane.WARNING_MESSAGE);
            if(option == JOptionPane.YES_OPTION){
                dispose();
//                new LoginFrame();
        }}}
public static void main(String[] args) {
     try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
        new HomepageFrame("","");
    }
}