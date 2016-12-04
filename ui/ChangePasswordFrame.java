package ui;
import da.*;
import domain.*;
import control.*;
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
public class ChangePasswordFrame extends JFrame{
    private ChangePasswordFrame thisFrame;
    StaffDA staffDA=new StaffDA();
    MaintainStaffControl staffControl=new MaintainStaffControl();
    Font buttonFont=new Font("Serif", Font.BOLD, 23);
    private Font largeFont = new Font("Serif", Font.BOLD, 23);
    private Font smallFont = new Font("Serif", Font.PLAIN ,20);
    private JButton jbtChange = new JButton("Change!");
    private JButton jbtReset = new JButton("Reset");
    private JButton jbtBack=new JButton("Back");
    private JTextField jtfOldPass= new JTextField();
    private JTextField jtfNewPass= new JTextField();
    private JLabel jl1 =new JLabel("Please enter the your old password and new password");
    private JLabel jl2 =new JLabel("Old Password:");
    private JLabel jl3 =new JLabel("New Password:");
private String position;
   private String staffID;
     public ChangePasswordFrame(){
     
 }
public ChangePasswordFrame(String position,String staffID){
    thisFrame=this;
    setIcon();
    this.position=position;
    this.staffID=staffID;
    JPanel jpNorth=new JPanel();
    jl1.setFont(new Font("Serif", Font.BOLD, 28));
    jpNorth.add(jl1);
    add(jpNorth,BorderLayout.NORTH);
    JPanel jpCenter = new JPanel(new GridLayout(4, 2));
    jpCenter.add(jl2);
    jpCenter.add(jtfOldPass);
    jpCenter.add(new JLabel(""));
    jpCenter.add(new JLabel(""));
    jpCenter.add(jl3);
    jpCenter.add(jtfNewPass);
    
    JPanel jpSouth=new JPanel();
    jpSouth.add(jbtChange);
    jpSouth.add(jbtReset);
    jpSouth.add(jbtBack);
    add(jpSouth,BorderLayout.SOUTH);
    add(jpCenter);
   
    jpCenter.setBackground(new Color(204,255,255));
    jpSouth.setBackground(new Color(204,255,255));
    
    jpNorth.setBackground(new Color(204,255,255));
  addWindowListener(new WindowListener());
    jl2.setFont(smallFont);
    jl3.setFont(smallFont);
   
    jbtReset.setFont(smallFont);
    jbtChange.setFont(smallFont);
    jbtBack.setFont(smallFont);
   jbtChange.addActionListener(new UpdateListener());
   jbtReset.addActionListener(new ResetListener());
   jbtBack.addActionListener(new BackListener());
   setTitle("Change Password");
   setSize(800, 400);
  setLocationRelativeTo(null);
   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   setVisible(true);
        
}
private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("bus-icon.jpg")));
    }
private void clearText() {
    jtfOldPass.setText("");
    jtfNewPass.setText("");
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
private class UpdateListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        try{
        String oldpassword=null;
        Staff staff=staffControl.selectRecord(staffID);
        if (staff != null){
            oldpassword=staff.getPassword();
            String typePassword=new String(jtfOldPass.getText());
            if(oldpassword.equals(typePassword)){
                staff.setPassword(jtfNewPass.getText());
            }
            else{
                JOptionPane.showMessageDialog(null, "Wrong Passowrd.Please key in your current password!");
            }
        }
        if(jtfOldPass.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please enter your current password.");
            
        }else if(jtfNewPass.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please enter your new password.");
            
        }
        else{
            staffControl.updateStaffPasswordAndSecurity(staff);
            JOptionPane.showMessageDialog(null, "Your password has been updated.");
            clearText();
            thisFrame.dispose();
            
        }
        }catch(Exception ex){
            ex.getMessage();
        }
    }}
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
        new ChangePasswordFrame("","");
}}



