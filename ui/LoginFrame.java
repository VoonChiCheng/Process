package ui;
import da.*;
import domain.*;
import control.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.Toolkit;  
import java.sql.*;
import javax.swing.JPanel;

public class LoginFrame extends JFrame {
    StaffDA staffDA=new StaffDA();
    MaintainStaffControl staffControl=new MaintainStaffControl();
    Font buttonFont=new Font("Serif", Font.BOLD, 23);
    private Font largeFont = new Font("Serif", Font.BOLD, 23);
    private Font smallFont = new Font("Serif", Font.PLAIN ,20);
    JPanel jpanel=new JPanel(new BorderLayout()){
        public void paintComponent(Graphics g){
            Image img=Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("logo.gif"));
            g.drawImage(img, 0, 0, this.getWidth(),this.getHeight(),this);
        }
    };
private String host = "jdbc:derby://localhost:1527/taste2";
    private String user = "taste2";
    private String password = "taste2";
    private String tableName = "LoginInfo";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private JTextField jtfUsername = new JTextField();
    private JPasswordField jtfPassword = new JPasswordField();
    private JButton jbtLogin = new JButton("Login");
    private JButton jbtReset = new JButton("Reset");
    private JButton jbtForget = new JButton("Forget Password");
   private JLabel jlbUsername=new JLabel("Username:");
   private JLabel jlbPassword=new JLabel("Password:");
   private LoginFrame thisFrame;
   private ForgetPasswordFrame forgetFrame=null;

    public LoginFrame() {
    thisFrame=this;
        jtfPassword.setEchoChar('*');

        JPanel jpInput = new JPanel(new GridLayout(2, 2));
        jpInput.add(jlbUsername);
        jpInput.add(jtfUsername);
        jpInput.add(jlbPassword);
        jpInput.add(jtfPassword);
        jpanel.add(jpInput,BorderLayout.SOUTH);
        
        JPanel jpButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jpButtons.add(jbtLogin);
        jpButtons.add(jbtReset);
        jpButtons.add(jbtForget);
        add(jpButtons, BorderLayout.SOUTH);    
        
        jbtReset.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            jtfUsername.setText("");
            jtfPassword.setText("");
            
        }
    });
       add(jpanel);
       setTitle("Login");
        jbtLogin.setFont(smallFont);
        jbtReset.setFont(smallFont);
        jbtForget.setFont(smallFont);
        jlbUsername.setFont(smallFont);
        jlbPassword.setFont(smallFont);
        setTitle("Login");
        setSize(600,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setVisible(true);
       setIcon();
        jbtReset.addActionListener(new ResetListener());
        jbtLogin.addActionListener(new LoginListener());
        jbtForget.addActionListener(new ForgetListener());
    }
  private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("bus-icon.jpg")));
    }
    public ResultSet selectRecord(String username,String password)
    {
        String sql="SELECT * FROM "+tableName+" WHERE username=? AND userpassword =?";
        ResultSet rs=null;
        try
        {
            stmt=conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            
            rs=stmt.executeQuery();
                 
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return rs;
    }
   private void clearText() {
   jtfUsername.setText("");
   jtfPassword.setText("");
   }
  private class ResetListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        clearText();
    }}
  private class ForgetListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
          if(e.getSource()==jbtForget){
                if(forgetFrame==null)
                    forgetFrame=new ForgetPasswordFrame();
                if(!forgetFrame.isVisible())
                    forgetFrame.setVisible(true);
      }
  }}
  private class LoginListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        Staff staff=staffControl.selectRecord(jtfUsername.getText());
        if(staff!=null){
            String status=null;
            status=staff.getStatus();
            String position=null;
            position=staff.getPosition();
            String password=null;
            password=staff.getPassword();
            String IC=null;
            IC=staff.getIC();
            String staffID=null;
            String name=null;
            name=staff.getName();
            staffID=staff.getStaffID();
            
             
            String typePassword=new String(jtfPassword.getPassword());
            if(password.equals(typePassword)){
                if(status.equals("Retired")){
                    JOptionPane.showMessageDialog(null, "This user is no longer able to access this system!","WARNING",JOptionPane.WARNING_MESSAGE);
                   clearText();
                }else{
                if(typePassword.equals(IC)){
                     JOptionPane.showMessageDialog(null, "Welcome " + name +" !");
                    FirstChangePasswordFrame changepass=new FirstChangePasswordFrame(position,staffID);                    thisFrame.dispose();
                }else{
                    if(position.equals("Manager")){
                         JOptionPane.showMessageDialog(null, "Welcome " + name +" !");
                      
                        HomepageFrame manager=new HomepageFrame(position,staffID);
                        thisFrame.dispose();
                    }else if(position.equals("Staff")){
                         JOptionPane.showMessageDialog(null, "Welcome " + name +" !");
                        HomepageFrame normalstaff=new HomepageFrame(position,staffID);
                        thisFrame.dispose();
                    }
                }}
            }else{
                JOptionPane.showMessageDialog(null, "WRONG PASSWORD!");
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "INVALID USERNAME!");
        }
        
    }}
            
    

    public static void main(String[] args) {
          try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
   new LoginFrame();
        
    }
}
