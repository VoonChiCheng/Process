package ui;
import da.BusDA;
import domain.Bus;
import control.BusSeatControl;
import control.MaintainBusControl;
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
public class AddBusFrame extends JFrame{
    private AddBusFrame thisFrame;
    BusDA busDA=new BusDA();
    MaintainBusControl busControl=new MaintainBusControl();
    BusSeatControl seatControl=new BusSeatControl();
    Date date=new Date();
    DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd");
    Font buttonFont=new Font("Serif", Font.BOLD, 23);
    private Font largeFont = new Font("Serif", Font.BOLD, 23);
    private Font smallFont = new Font("Serif", Font.PLAIN ,20);
    private ButtonGroup bG =new ButtonGroup();
    private ButtonGroup bG2 =new ButtonGroup();
    private JButton jbtConfirm = new JButton("Confirm");
    private JButton jbtReset = new JButton("Reset");
    private JButton jbtBack=new JButton("Back");
    private JTextField jtfBusId= new JTextField();
    private JTextField jtfPlateNo= new JTextField();
    private JTextField jtfSeat= new JTextField();
    private JTextField jtfType= new JTextField();
    private JTextField jtfStatus= new JTextField();
    private JRadioButton jrbNormal= new JRadioButton("Normal");
    private JRadioButton jrbExclusive= new JRadioButton("Exclusive");
    private JTextField jtfPurchase=new JTextField();
    private JRadioButton jrbService= new JRadioButton("In Service");
    private JRadioButton jrbNotInService= new JRadioButton("Not In Service");
    private JLabel jl1 =new JLabel("Please enter the new Bus Information");
    private JLabel jl2 =new JLabel("Bus ID:");
    private JLabel jl3 =new JLabel("Bus Type:");
    private JLabel jl4 =new JLabel("Plate No:");
    private JLabel jl5 =new JLabel("Purchase Year:");
    private JLabel jl6 =new JLabel("Total Seat:");
    private JLabel jl7 =new JLabel("Status:");
    private String position;
   private String staffID;
   public AddBusFrame(){
     
 }  
public AddBusFrame(String position,String staffID){
PromptSupport.setForeground(Color.LIGHT_GRAY, jtfPlateNo);
PromptSupport.setPrompt("Example:ABC1234",jtfPlateNo);

    thisFrame=this;
    this.position=position;
    this.staffID=staffID;
    JPanel jpNorth=new JPanel();
    jl1.setFont(new Font("Serif", Font.BOLD, 28));
    jpNorth.add(jl1);
    add(jpNorth,BorderLayout.NORTH);
    
    bG.add(jrbNormal);
    bG.add(jrbExclusive);
    JPanel jpBusType=new JPanel(new FlowLayout(FlowLayout.LEFT));
    jpBusType.add(jrbNormal);
    jpBusType.add(jrbExclusive);
    bG2.add(jrbService);
    bG2.add(jrbNotInService);
    JPanel jpStatus=new JPanel(new FlowLayout(FlowLayout.LEFT));
    jpStatus.add(jrbService);
    jpStatus.add(jrbNotInService);
    JPanel jpCenter = new JPanel(new GridLayout(8, 2));
    jpCenter.add(jl2);
    jpCenter.add(jtfBusId);
    jpCenter.add(jl3);
    jpCenter.add(jpBusType);
    jpCenter.add(jl4);
    jpCenter.add(jtfPlateNo);
    jpCenter.add(jl5);
    jtfPurchase.setEditable(false);
    jtfPurchase.setText(dateFormat.format(date));
    jpCenter.add(jtfPurchase);
    jpCenter.add(jl6);
    jpCenter.add(jtfSeat);
    jpCenter.add(jl7);
    jpCenter.add(jpStatus);
    jtfSeat.setEditable(false);
    jtfBusId.setEditable(false);
    jtfBusId.setText(automatedCode());
    JPanel jpSouth=new JPanel();
    jpSouth.add(jbtConfirm);
    jpSouth.add(jbtReset);
    jpSouth.add(jbtBack);
    add(jpSouth,BorderLayout.SOUTH);
    add(jpCenter);
    jpBusType.setBackground(new Color(204,255,255));
    jpCenter.setBackground(new Color(204,255,255));
    jpSouth.setBackground(new Color(204,255,255));
    jpStatus.setBackground(new Color(204,255,255));
    jpNorth.setBackground(new Color(204,255,255));
 jbtConfirm.addActionListener(new ConfirmListener());
   jbtReset.addActionListener(new ResetListener());
   jbtBack.addActionListener(new BackListener());
   jrbNormal.addActionListener(new TypeListener());
    jrbExclusive.addActionListener(new TypeListener());
    jrbService.addActionListener(new StatusListener());
    jrbNotInService.addActionListener(new StatusListener());
    jl2.setFont(smallFont);
    jl3.setFont(smallFont);
    jl4.setFont(smallFont);
    jl5.setFont(smallFont);
    jl6.setFont(smallFont);
    jl7.setFont(smallFont);
    jbtReset.setFont(smallFont);
    jbtConfirm.setFont(smallFont);
    jbtBack.setFont(smallFont);
        setIcon();
   setTitle("Add New Bus");
   setSize(800, 400);
  setLocationRelativeTo(null);
   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   setVisible(true);
      
}
public String automatedCode(){
    String automatedCode="";
    automatedCode=busDA.displayAutomatedCode();
    return automatedCode;
}

private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("bus-icon.jpg")));
    }
 private void clearText() {
      jtfPlateNo.setText("");
      
      jtfPlateNo.requestFocusInWindow();
      bG.clearSelection();
      bG2.clearSelection();
    }
 private class TypeListener implements ActionListener{
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() instanceof JRadioButton){
            JRadioButton radioButton = (JRadioButton) e.getSource();
            if(radioButton.isSelected()){
                jtfType.setText(radioButton.getText());
            }
        }
        if(jrbNormal.isSelected()){
            jtfSeat.setText("32");
        }
        else if(jrbExclusive.isSelected()){
            jtfSeat.setText("20");
        }
    }
}
  private class StatusListener implements ActionListener{
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() instanceof JRadioButton){
            JRadioButton radioButton = (JRadioButton) e.getSource();
            if(radioButton.isSelected()){
                jtfStatus.setText(radioButton.getText());
            }
        }
        
            
    }
}
   private class ConfirmListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
            String BusID = jtfBusId.getText();
           
            int seat=Integer.parseInt(jtfSeat.getText());

            if(jtfPurchase.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the purchase year.");
            }
            else if(jtfPlateNo.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the plate number.");
            }
            else if(jtfSeat.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the number of seat.");
            }
            else if(jtfType.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please select the bus type.");
            }
            else if(jtfStatus.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please select the status of the bus.");
            }
            
            else{
            busControl.addRecord(BusID,jtfPlateNo.getText(),Integer.parseInt(jtfSeat.getText()),jtfType.getText(),jtfStatus.getText(),jtfPurchase.getText());
                
                String seatAlpha="A";
                String seatID="";
                for(int i=1;i<=Integer.parseInt(jtfSeat.getText());i++)
                {
                    seatID=seatAlpha+String.format("%02d", i);
                    seatControl.addRecord(seatID,BusID);
                }
                
                JOptionPane.showMessageDialog(null, "New Bus Record added.");
                
                thisFrame.dispose();
            }

        }
    
        catch(NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(null, "Please enter number format in purchase year and seat text field");
        }}}
  private class ResetListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        clearText();
    }}
  private class  BackListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        clearText();
        thisFrame.dispose();
       
    }}
public static void main(String[] args) {
     try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
        new AddBusFrame("","");
}}



