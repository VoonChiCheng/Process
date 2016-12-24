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
public class AddRouteFrame extends JFrame{
     private AddRouteFrame thisFrame;
     RouteDA routeDA=new RouteDA();
    MaintainRouteControl routeControl=new MaintainRouteControl();
    Font buttonFont=new Font("Serif", Font.BOLD, 23);
    private Font largeFont = new Font("Serif", Font.BOLD, 23);
    private Font smallFont = new Font("Serif", Font.PLAIN ,20);
    private JButton jbtConfirm = new JButton("Confirm");
    private JButton jbtReset = new JButton("Reset");
    private JButton jbtBack=new JButton("Back");
    private JTextField jtfDestination= new JTextField();
    private JTextField jtfPrice= new JTextField();
    private JLabel jl1 =new JLabel("Please enter the new destination and price");
    private JLabel jl2 =new JLabel("Destination:");
    private JLabel jl3 =new JLabel("Price(RM):");
private String position;
   private String staffID;
  public AddRouteFrame(){}  
public AddRouteFrame(String position,String staffID){
    thisFrame=this;
     this.position=position;
    this.staffID=staffID;
    JPanel jpNorth=new JPanel();
    jl1.setFont(new Font("Serif", Font.BOLD, 28));
    jpNorth.add(jl1);
    add(jpNorth,BorderLayout.NORTH);
    JPanel jpCenter = new JPanel(new GridLayout(4, 2));
    jpCenter.add(jl2);
    jpCenter.add(jtfDestination);
    jpCenter.add(new JLabel(""));
    jpCenter.add(new JLabel(""));
    jpCenter.add(jl3);
    jpCenter.add(jtfPrice);
    
    JPanel jpSouth=new JPanel();
    jpSouth.add(jbtConfirm);
    jpSouth.add(jbtReset);
    jpSouth.add(jbtBack);
    add(jpSouth,BorderLayout.SOUTH);
    add(jpCenter);
   
    jpCenter.setBackground(new Color(204,255,255));
    jpSouth.setBackground(new Color(204,255,255));
    
    jpNorth.setBackground(new Color(204,255,255));
 jbtConfirm.addActionListener(new ConfirmListener());
   jbtReset.addActionListener(new ResetListener());
   jbtBack.addActionListener(new BackListener());
    jl2.setFont(smallFont);
    jl3.setFont(smallFont);
   
    jbtReset.setFont(smallFont);
    jbtConfirm.setFont(smallFont);
    jbtBack.setFont(smallFont);
        setIcon();
   setTitle("Add Route");
   setSize(800, 400);
  setLocationRelativeTo(null);
   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   setVisible(true);
     
}

private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("bus-icon.jpg")));
    }
private void clearText() {
      jtfDestination.setText("");
      jtfPrice.setText("");
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
  private class ConfirmListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
            String Destination = jtfDestination.getText();
            double price=Double.parseDouble(jtfPrice.getText());

            if(jtfDestination.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the new destination.");
            }
            else if(jtfPrice.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the price.");
            }
            
            else{
            routeControl.addRecord(Destination,"Normal",Double.parseDouble(jtfPrice.getText()));
            double i=20;
            routeControl.addRecord(Destination,"Exclusive",Double.parseDouble(jtfPrice.getText())+i);
                
         
                
                JOptionPane.showMessageDialog(null, "New Bus Record added.");
                
                thisFrame.dispose();
            }

        }
    
        catch(NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(null, "Please enter number format in price text field");
        }}}
public static void main(String[] args) {
     try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
        new AddRouteFrame();
}}



