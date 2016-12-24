package ui;
import control.*;
import da.*;
import domain.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.util.*;
import javax.swing.JComponent;
import java.awt.Component;
import java.text.DateFormat;
import java.util.Date;
import org.jdesktop.swingx.JXDatePicker;
import java.text.SimpleDateFormat;
import org.jdesktop.swingx.prompt.PromptSupport;
public class UpdateRouteFrame extends JFrame{
     private UpdateRouteFrame thisFrame;
    private ArrayList<Route> routeList=new ArrayList<Route>();
    MaintainRouteControl routeControl=new MaintainRouteControl();
    private DefaultComboBoxModel dcbomRouteList=new DefaultComboBoxModel();
    private JComboBox jcbDestination=new JComboBox(dcbomRouteList);
    Font buttonFont=new Font("Serif", Font.BOLD, 23);
    private Font largeFont = new Font("Serif", Font.BOLD, 23);
    private Font smallFont = new Font("Serif", Font.PLAIN ,20);
    private JButton jbtRetrieve = new JButton("Retrieve");
    private JButton jbtUpdate = new JButton("Update");
    private JButton jbtReset = new JButton("Reset");
    private JButton jbtBack=new JButton("Back");
    private JTextField jtfDestination= new JTextField();
    private JTextField jtfPrice= new JTextField();
    private JLabel jl1 =new JLabel("Please enter the destination");
    private JLabel jl2 =new JLabel("Destination:");
    private JLabel jl3 =new JLabel("Price(RM):");
private String position;
   private String staffID;
    public UpdateRouteFrame(){}
public UpdateRouteFrame(String position,String staffID){
    thisFrame=this;
     this.position=position;
    this.staffID=staffID;
    intiRouteComboBox();
    JPanel jpNorth=new JPanel();
    jl1.setFont(new Font("Serif", Font.BOLD, 28));
    jpNorth.add(jl1);
    add(jpNorth,BorderLayout.NORTH);
    JPanel jpCenter = new JPanel(new GridLayout(5, 2));
    jpCenter.add(jl2);
    jpCenter.add(jcbDestination);
    jpCenter.add(new JLabel(""));
    jpCenter.add(jbtRetrieve);
    jpCenter.add(new JLabel(""));
    jpCenter.add(new JLabel(""));
    jpCenter.add(jl3);
    jpCenter.add(jtfPrice);
    
    JPanel jpSouth=new JPanel();
    jpSouth.add(jbtUpdate);
    jpSouth.add(jbtReset);
    jpSouth.add(jbtBack);
    add(jpSouth,BorderLayout.SOUTH);
    add(jpCenter);
   
    jpCenter.setBackground(new Color(204,255,255));
    jpSouth.setBackground(new Color(204,255,255));
    
    jpNorth.setBackground(new Color(204,255,255));
 jbtReset.addActionListener(new ResetListener());
   jbtBack.addActionListener(new BackListener());
   jbtRetrieve.addActionListener(new RetrieveListener());
   jbtUpdate.addActionListener(new UpdateListener());
    jl2.setFont(smallFont);
    jl3.setFont(smallFont);
   
    jbtReset.setFont(smallFont);
    jbtUpdate.setFont(smallFont);
    jbtBack.setFont(smallFont);
      setIcon();  
   setTitle("Update Route Information");
   setSize(800, 400);
  setLocationRelativeTo(null);
   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   setVisible(true);
       

}

private void intiRouteComboBox(){
    routeList=routeControl.getDestination();
    System.out.print(routeList);
    for(int j=0;j<routeList.size();j++){
        dcbomRouteList.addElement(routeList.get(j).getdestination());
    }
}
private void clearText() {
   jtfPrice.setText("");
    }
private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("bus-icon.jpg")));
    }
private class ResetListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        clearText();
    }}
 private class  BackListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        clearText();
        thisFrame.dispose();
       
    }}
 private class RetrieveListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
            String destination = jcbDestination.getSelectedItem().toString();
            Route route = routeControl.selectRecord(destination);
            if (route != null) {
                jtfPrice.setText(route.getprice().toString());
               
                
            } else {
                JOptionPane.showMessageDialog(null, "No such Destination.Please enter correct destination.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
            }
            
    }}
 private class UpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
            String destination =jcbDestination.getSelectedItem().toString(); 
            double price=Double.parseDouble(jtfPrice.getText());
           
            Route route = routeControl.selectRecord(destination);
            if (route != null) {
                route.setprice(Double.parseDouble(jtfPrice.getText()));
                routeControl.updateRecord(route);
                
                double i=20;
                route.setprice(Double.parseDouble(jtfPrice.getText())+i);
                routeControl.updateRecord2(route);
                
                JOptionPane.showMessageDialog(null, "Record updated.");
               } else {
                JOptionPane.showMessageDialog(null, "No such destination ", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
            }}catch(NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(null, "Please enter number format in price");
        }}}
public static void main(String[] args) {
     try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
        new UpdateRouteFrame();
}}



