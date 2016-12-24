package ui;
import da.*;
import domain.*;
import control.MaintainStaffControl;
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
public class RetrieveStaffFrame extends JFrame{
    private RetrieveStaffFrame thisFrame;
    StaffDA staffDA=new StaffDA();
    MaintainStaffControl staffControl=new MaintainStaffControl();
    private ArrayList<Staff> staffList=new ArrayList<Staff>();
   
    private DefaultComboBoxModel dcbomStaffList=new DefaultComboBoxModel();
    private JComboBox jcbStaffID=new JComboBox(dcbomStaffList);
    Font buttonFont=new Font("Serif", Font.BOLD, 23);
    private Font largeFont = new Font("Serif", Font.BOLD, 23);
    private Font smallFont = new Font("Serif", Font.PLAIN ,20);
    DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd");
    private ButtonGroup bG =new ButtonGroup();
    private ButtonGroup bG2 =new ButtonGroup();
    private ButtonGroup bG3 =new ButtonGroup();
    private JXDatePicker datePick=new JXDatePicker();
    private JButton jbtRetrieve=new JButton("Retrieve");
    private JButton jbtConfirm = new JButton("Confirm");
    private JButton jbtReset = new JButton("Reset");
    private JButton jbtBack=new JButton("Back");
    private JTextField jtfId= new JTextField();
    private JTextField jtfName= new JTextField();
    private JTextField jtfIc= new JTextField();
    private JTextField jtfDOB= new JTextField();
    private JRadioButton jrbMale= new JRadioButton("Male");
    private JRadioButton jrbFemale= new JRadioButton("Female");
    private JRadioButton jrbManager= new JRadioButton("Manager");
    private JRadioButton jrbStaff= new JRadioButton("Normal Staff");
    private JRadioButton jrbRetired= new JRadioButton("Retired");
    private JRadioButton jrbWorking= new JRadioButton("Working");
    private JTextField jtfGender=new JTextField();
    private JTextField jtfStatus=new JTextField();
    private JTextField jtfPosition=new JTextField();
    private JTextField jtfTel=new JTextField();
    private JTextField jtfAddress= new JTextField();
    private JTextField jtfEmail= new JTextField();
    private JTextField jtfPassword= new JTextField();
    private JTextField jtfSecurity= new JTextField();
    private JLabel jl1 =new JLabel("Please select the Staff ID");
    private JLabel jlStaffId =new JLabel("Staff ID:");
    private JLabel jlName =new JLabel("Name:");
    private JLabel jlIc =new JLabel("IC:");
    private JLabel jlGender =new JLabel("Gender:");
    private JLabel jldob =new JLabel("Date of Birth:");
    private JLabel jlAddress =new JLabel("Address:");
    private JLabel jlContactNo =new JLabel("Contact No:");
    private JLabel jlEmail =new JLabel("Email:");
    private JLabel jlPosition =new JLabel("Position:");
    private JLabel jlStatus =new JLabel("Status:");
    private JLabel jlPassword =new JLabel("Password:");
    private JLabel jlSecurity =new JLabel("Security Answer:");
  private String position;
   private String staffID;
   public RetrieveStaffFrame(){}
public RetrieveStaffFrame(String position,String staffID){
    intiStaffComboBox();
    thisFrame=this;
     this.position=position;
    this.staffID=staffID;
    JPanel jpNorth=new JPanel();
    jl1.setFont(new Font("Serif", Font.BOLD, 28));
    jpNorth.add(jl1);
    add(jpNorth,BorderLayout.NORTH);
    datePick.setFormats(dateFormat);
    bG.add(jrbMale);
    bG.add(jrbFemale);
    bG2.add(jrbManager);
    bG2.add(jrbStaff);
    bG3.add(jrbWorking);
    bG3.add(jrbRetired);
    JPanel jpGender=new JPanel(new FlowLayout(FlowLayout.LEFT));
    jpGender.add(jrbMale);
    jpGender.add(jrbFemale);
     JPanel jpPosition=new JPanel(new FlowLayout(FlowLayout.LEFT));
    jpPosition.add(jrbManager);
    jpPosition.add(jrbStaff);
     JPanel jpStatus=new JPanel(new FlowLayout(FlowLayout.LEFT));
    jpStatus.add(jrbWorking);
    jpStatus.add(jrbRetired);
    JPanel jpCenter = new JPanel(new GridLayout(14, 2));
    jpCenter.add(jlStaffId);
    jpCenter.add(jcbStaffID);
    jpCenter.add(new JLabel(""));
    jpCenter.add(jbtRetrieve);
   
    jpCenter.add(jlName);
    jpCenter.add(jtfName);
    jpCenter.add(jldob);
    jpCenter.add(jtfDOB);
    jpCenter.add(jlIc);
    jpCenter.add(jtfIc);
    jpCenter.add(jlGender);
    jpCenter.add(jtfGender);
    jpCenter.add(jlContactNo);
    jpCenter.add(jtfTel);
    jpCenter.add(jlAddress);
    jpCenter.add(jtfAddress);
    jpCenter.add(jlEmail);
    jpCenter.add(jtfEmail);
    jpCenter.add(jlPosition);
    jpCenter.add(jtfPosition);
    jpCenter.add(jlStatus);
    jpCenter.add(jtfStatus);
    //jpCenter.add(jlPassword);
   // jpCenter.add(jtfPassword);
   // jpCenter.add(jlSecurity);
   // jpCenter.add(jtfSecurity);
    jtfName.setEditable(false);
    jtfIc.setEditable(false);
    jtfDOB.setEditable(false);
    jtfTel.setEditable(false);
    jtfEmail.setEditable(false);
    jtfGender.setEditable(false);
    jtfPosition.setEditable(false);
    jtfStatus.setEditable(false);
   // jtfPassword.setEditable(false);
   // jtfSecurity.setEditable(false);
    jtfAddress.setEditable(false);
      jbtReset.addActionListener(new ResetListener());
   jbtBack.addActionListener(new BackListener());
     jbtRetrieve.addActionListener(new RetrieveListener());
    JPanel jpSouth=new JPanel();
   
    jpSouth.add(jbtReset);
    jpSouth.add(jbtBack);
    add(jpSouth,BorderLayout.SOUTH);
    add(jpCenter);
    
setIcon();
        setTitle("Retrieve Staff Information");
        setSize(800, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        
         jpCenter.setBackground(new Color(204,255,255));
    jpSouth.setBackground(new Color(204,255,255));
    jpStatus.setBackground(new Color(204,255,255));
    jpNorth.setBackground(new Color(204,255,255));
    jpGender.setBackground(new Color(204,255,255));
    jpPosition.setBackground(new Color(204,255,255));
    jl1.setFont(new Font("Serif", Font.BOLD, 28));
    jlStaffId.setFont(smallFont);
jlName.setFont(smallFont);
jlIc.setFont(smallFont);
jlGender.setFont(smallFont);
    jldob.setFont(smallFont);
     jlAddress.setFont(smallFont);
    jlContactNo.setFont(smallFont);
    jlEmail.setFont(smallFont);
     jlPosition.setFont(smallFont);
    jlStatus.setFont(smallFont);
  //   jlPassword.setFont(smallFont);
  //  jlSecurity.setFont(smallFont);
    jbtReset.setFont(smallFont);
    jbtConfirm.setFont(smallFont);
    jbtBack.setFont(smallFont);
    jbtRetrieve.setFont(smallFont);
    
}

 private void clearText() {
     
      jtfName.setText("");
      jtfIc.setText("");
      jtfTel.setText("");
      jtfAddress.setText("");
      jtfEmail.setText("");
      jtfPassword.setText("");
      jtfSecurity.setText("");
      jtfId.requestFocusInWindow();
      jtfStatus.setText("");
      jtfPosition.setText("");
      jtfGender.setText("");
      jtfDOB.setText("");
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
            String StaffID = jcbStaffID.getSelectedItem().toString();
            Staff staff = staffControl.selectRecord(StaffID);
            if (staff != null) {
                jtfName.setText(staff.getName());
                jtfIc.setText(staff.getIC());
                jtfTel.setText(staff.getContactno());
                jtfStatus.setText(staff.getStatus());
                jtfAddress.setText(staff.getAddress());
                jtfEmail.setText(staff.getEmail());
                jtfPosition.setText(staff.getPosition());
                jtfGender.setText(staff.getGender());
                jtfDOB.setText(staff.getDOB().toString());
               
                
            } else {
                JOptionPane.showMessageDialog(null, "No such Member ID.Please enter correct Staff ID.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
            }
           
        }
        }
   private void intiStaffComboBox(){
    staffList=staffControl.getStaffID();
    System.out.print(staffList);
    for(int j=0;j<staffList.size();j++){
        dcbomStaffList.addElement(staffList.get(j).getStaffID());
    }
}
public static void main(String[] args) {
    try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
        new RetrieveStaffFrame();
}}



