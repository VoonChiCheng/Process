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
public class FirstChangePasswordFrame extends JFrame{
    private FirstChangePasswordFrame thisFrame;
    StaffDA staffDA=new StaffDA();
    MaintainStaffControl staffControl=new MaintainStaffControl();
    Font buttonFont=new Font("Serif", Font.BOLD, 23);
    private Font largeFont = new Font("Serif", Font.BOLD, 23);
    private Font smallFont = new Font("Serif", Font.PLAIN ,20);
    private JButton jbtChange = new JButton("Change!");
    private JButton jbtReset = new JButton("Reset");
    private JButton jbtBack=new JButton("Back");
    private JTextField jtfSecurity= new JTextField();
    private JTextField jtfNewPass= new JTextField();
    private JLabel jl1 =new JLabel("Please enter the your new password and security answer");
    private JLabel jl2 =new JLabel("New Password:");
    private JLabel jl3 =new JLabel("Security Answer:");
    private JLabel jlQuestion=new JLabel("Security Question:");
    private DefaultComboBoxModel dcbomQuestionList=new DefaultComboBoxModel();
    private JComboBox jcbQuestion= new JComboBox(dcbomQuestionList);
    private ArrayList<String> QuestionList=new ArrayList<String>();
    private String position;
    private String staffID;
     public FirstChangePasswordFrame(){
     
 }
public FirstChangePasswordFrame(String position,String staffID){
    setIcon() ;
    thisFrame=this;
    this.position=position;
    this.staffID=staffID;
    
    JPanel jpNorth=new JPanel();
    jl1.setFont(new Font("Serif", Font.BOLD, 28));
    jpNorth.add(jl1);
    add(jpNorth,BorderLayout.NORTH);
    JPanel jpCenter = new JPanel(new GridLayout(4, 2));
    jpCenter.add(jl2);
    jpCenter.add(jtfNewPass);
    QuestionList.add("What is your pet name?");
    QuestionList.add("What is your dad name?");
    QuestionList.add("What is your mom name?");
    jpCenter.add(jlQuestion);
    
    for(int i=0;i<QuestionList.size();i++){
        dcbomQuestionList.addElement(QuestionList.get(i));
    }
    jpCenter.add(jcbQuestion);
    jpCenter.add(jl3);
    jpCenter.add(jtfSecurity);
    
    JPanel jpSouth=new JPanel();
    jpSouth.add(jbtChange);
    jpSouth.add(jbtReset);
    jpSouth.add(jbtBack);
    add(jpSouth,BorderLayout.SOUTH);
    add(jpCenter);
   
    jpCenter.setBackground(new Color(204,255,255));
    jpSouth.setBackground(new Color(204,255,255));
    
    jpNorth.setBackground(new Color(204,255,255));
 
    jl2.setFont(smallFont);
    jl3.setFont(smallFont);
    jlQuestion.setFont(smallFont);
    jbtReset.setFont(smallFont);
    jbtChange.setFont(smallFont);
    jbtBack.setFont(smallFont);
   jbtChange.addActionListener(new UpdateListener());
   jbtReset.addActionListener(new ResetListener());
   jbtBack.addActionListener(new BackListener());
   setTitle("First Time Login");
   setSize(800, 400);
  setLocationRelativeTo(null);
   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   setVisible(true);
         addWindowListener(new WindowListener());
}
private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("bus-icon.jpg")));
    }
private void clearText() {
    jtfSecurity.setText("");
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
//        LoginFrame login=new LoginFrame();
       
    }}
private class UpdateListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        try{
        Staff staff=staffControl.selectRecord(staffID);
        if (staff != null){
            staff.setPassword(jtfNewPass.getText());
            staff.setQuestionno(jcbQuestion.getSelectedIndex());
            staff.setSecurity(jtfSecurity.getText());
        }
        if(jtfNewPass.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please enter your new password.");
            
        }else if(jtfSecurity.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please enter your name.");
            
        }else{
            staffControl.updateStaffPasswordAndSecurity(staff);
            JOptionPane.showMessageDialog(null, "Your password,security question and answer have been updated.");
            thisFrame.dispose();
//            HomepageFrame home=new HomepageFrame(position,staffID);
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
//                new LoginFrame();
              
            }
            
        }
    }
public static void main(String[] args) {
     try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
        new FirstChangePasswordFrame();
}}



