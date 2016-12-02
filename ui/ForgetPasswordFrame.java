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
public class ForgetPasswordFrame extends JFrame{
    private ForgetPasswordFrame thisFrame;
    StaffDA staffDA=new StaffDA();
    MaintainStaffControl staffControl=new MaintainStaffControl();
    Font buttonFont=new Font("Serif", Font.BOLD, 23);
    private Font largeFont = new Font("Serif", Font.BOLD, 23);
    private Font smallFont = new Font("Serif", Font.PLAIN ,20);
    private JButton jbtConfirm = new JButton("Confirm");
    private JButton jbtReset = new JButton("Reset");
    private JButton jbtBack=new JButton("Back");
    private JTextField jtfUsername= new JTextField();
    private JTextField jtfSecurity= new JTextField();
    private JLabel jl1 =new JLabel("Please enter the your username and security answer");
    private JLabel jl2 =new JLabel("Username:");
    private JLabel jl3 =new JLabel("Security Answer:");
    private JLabel jlQuestion=new JLabel("Security Question:");
    private DefaultComboBoxModel dcbomQuestionList=new DefaultComboBoxModel();
    private JComboBox jcbQuestion= new JComboBox(dcbomQuestionList);
    private ArrayList<String> QuestionList=new ArrayList<String>();
    
public ForgetPasswordFrame(){
    thisFrame=this;
    setIcon();
    JPanel jpNorth=new JPanel();
    jl1.setFont(new Font("Serif", Font.BOLD, 28));
    jpNorth.add(jl1);
    add(jpNorth,BorderLayout.NORTH);
    JPanel jpCenter = new JPanel(new GridLayout(4, 2));
    jpCenter.add(jl2);
    jpCenter.add(jtfUsername);
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
    jpSouth.add(jbtConfirm);
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
    jbtConfirm.setFont(smallFont);
    jbtBack.setFont(smallFont);
    jbtConfirm.addActionListener(new ConfirmListener());
        jbtReset.addActionListener(new ResetListener());
   jbtBack.addActionListener(new BackListener());
   setTitle("Password Recovery");
   setSize(800, 400);
  setLocationRelativeTo(null);
   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   setVisible(true);
        
}
private void clearText() {
    jtfSecurity.setText("");
    jtfUsername.setText("");
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
   private class ConfirmListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        try{
        Staff staff=staffControl.selectRecord(jtfUsername.getText());
        if (staff != null){
            String password=null;
            password=staff.getPassword();
            Integer i=null;
            i=staff.getQuestionno();
            String answer=null;
            answer=staff.getSecurity();
            if(i.compareTo(jcbQuestion.getSelectedIndex())==0){
                if(answer.compareTo(jtfSecurity.getText())==0){
                    JOptionPane.showMessageDialog(null, "Your Password is "+ password +" !");
                    thisFrame.dispose();
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Invalid Username!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
        if(jtfUsername.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please enter your username.");
            
        }else if(jtfSecurity.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please enter your name.");
            
        }
          
        
        }catch(Exception ex){
            ex.getMessage();
        }
               
              
}}
private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("bus-icon.jpg")));
    }

 
public static void main(String[] args) {
     try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
        new ForgetPasswordFrame();
}}



