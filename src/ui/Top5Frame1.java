package ui;
import java.awt.BorderLayout;
import da.*;
import java.sql.*;
import domain.*;
import java.util.Date;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
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
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.jdesktop.swingx.JXDatePicker;
import org.jdesktop.swingx.JXSearchField;
public class Top5Frame1 extends JFrame{
  //  private Top5Frame thisFrame;
    DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd");
    private JXDatePicker datePick=new JXDatePicker();
    private JXDatePicker datePick2=new JXDatePicker();
    private JTextField jtdatePick=new JTextField();
    private JTextField jtdatePick2=new JTextField();
    Font buttonFont=new Font("Serif", Font.BOLD, 23);
    private Font largeFont = new Font("Serif", Font.BOLD, 23);
    private Font smallFont = new Font("Serif", Font.PLAIN ,20);
    private ImageIcon logo = new ImageIcon(getClass().getResource("logo.gif"));
    private JLabel jlblogo = new JLabel(logo);
    private JLabel jlbTitle=new JLabel("Top 5 Route Report");
    private JLabel jlbStart = new JLabel("Start of month:");
   
    private JLabel jlbEnd = new JLabel("End of month:");
    
    private JButton jbtGenerate=new JButton("Generate Normal Bus Route Report");
    private JButton jbtGenerate2=new JButton("Generate Exclusive Bus Route Report");
    private JButton jbtHome = new JButton("Home");
    private JButton jbtBus = new JButton("Bus");
     private JButton jbtRoute=new JButton("Route");
    private JButton jbtStaff = new JButton("Staff");
    private JButton jbtSchedule = new JButton("Bus Schedule");
    private JButton jbtOrder = new JButton("Order");
    private JButton jbtExchange= new JButton("Ticket Exchange");
    private JButton jbtReport= new JButton("Report");

 private ReportFrame reportFrame=null;
   private MaintainBusSchedule scheduleFrame=null;
   private MaintainRoute routeFrame=null;
   private MaintainStaff staffFrame=null;
   private TicketExchange ticketFrame=null;
   private HomepageFrame homeFrame=null;
   private MaintainBus busFrame=null;
 JPanel jpNorth =new JPanel(new BorderLayout());
 JPanel jpNorthCenter=new JPanel();
 JPanel jpNorthLogo =new JPanel();
 JPanel jpCenter =new JPanel(new BorderLayout());
 JPanel jpSouth=new JPanel();
 JPanel jpCenterTop=new JPanel();
 JPanel jpCenterCenter=new JPanel(new GridLayout(3,2));
 JPanel jpCenterSouth=new JPanel();
  private String position;
   private String staffID;

public Top5Frame1(String position,String staffID){
    setIcon();
   // thisFrame=this;
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
    datePick.setFormats(dateFormat);
    datePick2.setFormats(dateFormat);
    jlbTitle.setFont(buttonFont);
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
    
    
    jpCenterCenter.add(jlbStart);
    jpCenterCenter.add(datePick);
    jpCenterCenter.add(jlbEnd);
    jpCenterCenter.add(datePick2);
    jpCenterCenter.add(new JLabel(""));
    jpCenterSouth.add(jbtGenerate);
    jpCenterSouth.add(jbtGenerate2);
    jpCenter.add(jpCenterTop,BorderLayout.NORTH);
    jpCenter.add(jpCenterCenter,BorderLayout.CENTER);
    jpCenter.add(jpCenterSouth,BorderLayout.SOUTH);
    jpCenterTop.add(jlbTitle);
     
    
    
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
    
        jbtHome.setBackground(new Color(77, 195, 255));
        jbtBus.setBackground(new Color(77, 195, 255));
        jbtStaff.setBackground(new Color(77, 195, 255));
        jbtRoute.setBackground(new Color(77, 195, 255));
        jbtSchedule.setBackground(new Color(77, 195, 255));
        jbtOrder.setBackground(new Color(77, 195, 255));
        jbtExchange.setBackground(new Color(77, 195, 255));
        jbtReport.setBackground(new Color(204, 255, 255));
        jbtGenerate.addActionListener(new GenerateListener());
        jbtGenerate2.addActionListener(new Generate2Listener());
        jbtHome.setFont(largeFont);
        jbtBus.setFont(largeFont);
        jbtStaff.setFont(largeFont);
        jbtRoute.setFont(largeFont);
        jbtSchedule.setFont(largeFont);
        jbtOrder.setFont(largeFont);
        jbtExchange.setFont(largeFont);
        jbtReport.setFont(largeFont);
        jbtGenerate.setFont(smallFont);
        jbtGenerate2.setFont(smallFont);
        jlbStart.setFont(smallFont);
       jlbEnd.setFont(smallFont);
       jbtBus.addActionListener(new BusListener());
     jbtStaff.addActionListener(new StaffListener());
       jbtRoute.addActionListener(new RouteListener());
    jbtSchedule.addActionListener(new ScheduleListener());
    jbtReport.addActionListener(new ReportListener());
       jbtOrder.addActionListener(new OrderListener());
       jbtExchange.addActionListener(new ExchangeListener());
     jbtHome.addActionListener(new HomeListener());
        setTitle("Generate Top 5 Route Report");        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(1000,500);
        setLocationRelativeTo(null);
        setVisible(true);
         addWindowListener(new WindowListener());
}
private class GenerateListener implements ActionListener{
    public void actionPerformed(ActionEvent e)
    {
        Date date1=datePick.getDate();
       Date date2=datePick2.getDate();
       String host="jdbc:derby://localhost:1527/finalyear";
       String user="finalyear";
       String password="finalyear";
       Connection conn=null;
       JFileChooser chooser = new JFileChooser();
       chooser.setCurrentDirectory(new java.io.File("."));
       String reportSource = "D:\\FYP\\FYP\\src\\reportTemplates\\NormalTop5.jrxml";
       Map<String,Object> params=new HashMap<String,Object>();
       
      params.put("Start", date1);
       params.put("End", date2);
       try{
           Class.forName("org.apache.derby.jdbc.ClientDriver");
           conn=DriverManager.getConnection(host,user,password);
           JasperReport jasperReport=JasperCompileManager.compileReport(reportSource);
           JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport,params,conn);
           JasperViewer.viewReport(jasperPrint,false);
       }catch(JRException jrex){
           JOptionPane.showMessageDialog(null,"Error in generating report");
          jrex.printStackTrace();
       }catch(Exception ex){
           JOptionPane.showMessageDialog(null,"Unable to generate report");
       }
    }  
    
}
private class Generate2Listener implements ActionListener{
    public void actionPerformed(ActionEvent e)
    {
        Date date1=datePick.getDate();
       Date date2=datePick2.getDate();
       String host="jdbc:derby://localhost:1527/finalyear";
       String user="finalyear";
       String password="finalyear";
       Connection conn=null;
       JFileChooser chooser = new JFileChooser();
       chooser.setCurrentDirectory(new java.io.File("."));
       String reportSource = "D:\\FYP\\FYP\\src\\reportTemplates\\Top5Exclusive.jrxml";
       Map<String,Object> params=new HashMap<String,Object>();
       
      params.put("Start", date1);
       params.put("End", date2);
       try{
           Class.forName("org.apache.derby.jdbc.ClientDriver");
           conn=DriverManager.getConnection(host,user,password);
           JasperReport jasperReport=JasperCompileManager.compileReport(reportSource);
           JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport,params,conn);
           JasperViewer.viewReport(jasperPrint,false);
       }catch(JRException jrex){
           JOptionPane.showMessageDialog(null,"Error in generating report");
          jrex.printStackTrace();
       }catch(Exception ex){
           JOptionPane.showMessageDialog(null,"Unable to generate report");
       }
    }  
    
}
private class BusListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {                        
            if(e.getSource()==jbtBus){
                if(busFrame==null)
                    busFrame=new MaintainBus(position,staffID);
                dispose();
                if(!busFrame.isVisible())
                    busFrame.setVisible(true);
        }}}
private class StaffListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {                        
            if(e.getSource()==jbtStaff){
                if(staffFrame==null)
                    staffFrame=new MaintainStaff(position,staffID);
               dispose();
                if(!staffFrame.isVisible())
                    staffFrame.setVisible(true);
        }}}
private class HomeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {                        
            if(e.getSource()==jbtHome){
                if(homeFrame==null)
                    homeFrame=new HomepageFrame(position,staffID);
                   dispose();
                if(!homeFrame.isVisible())
                    homeFrame.setVisible(true);
        }}}
private class RouteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {                        
            if(e.getSource()==jbtRoute){
                if(routeFrame==null)
                    routeFrame=new MaintainRoute(position,staffID);
              dispose();
                if(!routeFrame.isVisible())
                    routeFrame.setVisible(true);
        }}}
private class ScheduleListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {                        
            if(e.getSource()==jbtSchedule){
                if(scheduleFrame==null)
                    scheduleFrame=new MaintainBusSchedule(position,staffID);
              dispose();
                if(!scheduleFrame.isVisible())
                    scheduleFrame.setVisible(true);
        }}}
private class ReportListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {                        
            if(e.getSource()==jbtReport){
                if(reportFrame==null)
                    reportFrame=new ReportFrame(position,staffID);
                dispose();
                if(!reportFrame.isVisible())
                    reportFrame.setVisible(true);
        }}}
private class OrderListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {                        
            
               new OrderLink(position,staffID);
                dispose();
        }}
private class ExchangeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {                        
            if(e.getSource()==jbtExchange){
                if(ticketFrame==null)
                    ticketFrame=new TicketExchange(position,staffID);
                    dispose();
                if(!ticketFrame.isVisible())
                    ticketFrame.setVisible(true);
        }}}
private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("bus-icon.jpg")));
    }
 private class WindowListener extends WindowAdapter{
        public void windowClosing(WindowEvent e){
            int option = JOptionPane.showConfirmDialog(null,"Confirm return to the Login Page?","Confirm?",JOptionPane.WARNING_MESSAGE);
            if(option == JOptionPane.YES_OPTION){
                dispose();
                new LoginFrame();
              
            }
            
        }
    }
public static void main(String[] args) {
     try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
        //new Top5Frame("","");
    }
}