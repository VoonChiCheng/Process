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
public class UpdateBusFrame extends JFrame{
    private UpdateBusFrame thisFrame;
    private ArrayList<Bus> busList=new ArrayList<Bus>();
    MaintainBusControl busControl=new MaintainBusControl();
    private DefaultComboBoxModel dcbomBusList=new DefaultComboBoxModel();
    private JComboBox jcbBusID=new JComboBox(dcbomBusList);
    Date date=new Date();
    DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd");
    Font buttonFont=new Font("Serif", Font.BOLD, 23);
    private Font largeFont = new Font("Serif", Font.BOLD, 23);
    private Font smallFont = new Font("Serif", Font.PLAIN ,20);
    private ButtonGroup bG =new ButtonGroup();
    private ButtonGroup bG2 =new ButtonGroup();
    
    private JButton jbtRetrieve=new JButton("Retrieve");
    private JButton jbtUpdate = new JButton("Update");
    private JButton jbtReset = new JButton("Reset");
    private JButton jbtBack=new JButton("Back");
    private JTextField jtfBusId= new JTextField();
    private JTextField jtfPlateNo= new JTextField();
    private JTextField jtfSeat= new JTextField();
    private JTextField jtfStatus=new JTextField();
    private JRadioButton jrbNormal= new JRadioButton("Normal");
    private JRadioButton jrbExclusive= new JRadioButton("Exclusive");
    private JTextField jtfPurchase=new JTextField();
    private JRadioButton jrbService= new JRadioButton("In Service");
    private JRadioButton jrbNotInService= new JRadioButton("Not In Service");
    private JLabel jl1 =new JLabel("Please select the Bus ID");
    private JLabel jl2 =new JLabel("Bus ID:");
    private JLabel jl3 =new JLabel("Bus Type:");
    private JLabel jl4 =new JLabel("Plate No:");
    private JLabel jl5 =new JLabel("Purchase Year:");
    private JLabel jl6 =new JLabel("Total Seat:");
    private JLabel jl7 =new JLabel("Status:");
    private String position;
   private String staffID;
   public UpdateBusFrame(){}
public UpdateBusFrame(String position,String staffID){
    thisFrame=this;
    this.position=position;
    this.staffID=staffID;
    intiBusComboBox();
    JPanel jpNorth=new JPanel();
    jl1.setFont(new Font("Serif", Font.BOLD, 28));
    jpNorth.add(jl1);
    add(jpNorth,BorderLayout.NORTH);
    
    bG.add(jrbNormal);
    bG.add(jrbExclusive);
    
    bG2.add(jrbService);
    bG2.add(jrbNotInService);
    JPanel jpStatus=new JPanel(new FlowLayout(FlowLayout.LEFT));
    jpStatus.add(jrbService);
    jpStatus.add(jrbNotInService);
    JPanel jpCenter = new JPanel(new GridLayout(8, 2));
    jpCenter.add(jl2);
    
    jpCenter.add(jcbBusID);
    jpCenter.add(new JLabel(""));
    jpCenter.add(jbtRetrieve);
    
    jtfPurchase.setEditable(false);
 
    jpCenter.add(jl4);
    jpCenter.add(jtfPlateNo);
    jpCenter.add(jl5);
    jpCenter.add(jtfPurchase);
    jpCenter.add(jl6);
    jpCenter.add(jtfSeat);
    jpCenter.add(jl7);
    jpCenter.add(jpStatus);
    jtfSeat.setEditable(false);
    
    
    JPanel jpSouth=new JPanel();
    jpSouth.add(jbtUpdate);
    jpSouth.add(jbtReset);
    jpSouth.add(jbtBack);
    add(jpSouth,BorderLayout.SOUTH);
    add(jpCenter);
    
    jpCenter.setBackground(new Color(204,255,255));
    jpSouth.setBackground(new Color(204,255,255));
    jpStatus.setBackground(new Color(204,255,255));
    jpNorth.setBackground(new Color(204,255,255));
 
    jl2.setFont(smallFont);
    jl3.setFont(smallFont);
    jl4.setFont(smallFont);
    jl5.setFont(smallFont);
    jl6.setFont(smallFont);
    jl7.setFont(smallFont);
    jbtReset.setFont(smallFont);
    jbtUpdate.setFont(smallFont);
    jbtBack.setFont(smallFont);
    jbtRetrieve.setFont(smallFont);
   jbtReset.addActionListener(new ResetListener());
   jbtBack.addActionListener(new BackListener());
   jbtRetrieve.addActionListener(new RetrieveListener());
   jbtUpdate.addActionListener(new UpdateListener());
    jrbService.addActionListener(new StatusListener());
    jrbNotInService.addActionListener(new StatusListener());
    setIcon();
   setTitle("Update Bus Details");
   setSize(800, 400);
  setLocationRelativeTo(null);
   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   setVisible(true);
    
}

private void intiBusComboBox(){
    busList=busControl.getBusID();
    System.out.print(busList);
    for(int j=0;j<busList.size();j++){
        dcbomBusList.addElement(busList.get(j).getBusID());
    }
}

private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("bus-icon.jpg")));
    }
private void clearText() {
    jtfSeat.setText("");
      jtfPlateNo.setText("");
      
      jtfPlateNo.requestFocusInWindow();
      bG.clearSelection();
      bG2.clearSelection();
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
            String busID = jcbBusID.getSelectedItem().toString();
            Bus bus = busControl.selectRecord(busID);
            if (bus != null) {
                jtfPlateNo.setText(bus.getPlateNo());
                jtfPurchase.setText(bus.getPurchase());
                jtfSeat.setText(bus.getTotalSeat().toString());
                jtfStatus.setText(bus.getStatus());
               
                
            } else {
                JOptionPane.showMessageDialog(null, "No such Member ID.Please enter correct Staff ID.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
            }
            if(jtfStatus.getText().equals("In Service")){
                jrbService.setSelected(true);
            }else{
                jrbNotInService.setSelected(true);
            }
           
        }
        }
 
 private class UpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
            String busID =jcbBusID.getSelectedItem().toString(); 
            
            int seat=Integer.parseInt(jtfSeat.getText());
           
            Bus bus = busControl.selectRecord(busID);
            if (bus != null) {
                bus.setPlateNo(jtfPlateNo.getText());
                bus.setPurchase(jtfPurchase.getText());
                bus.setStatus(jtfStatus.getText());
                bus.setTotalSeat(Integer.parseInt(jtfSeat.getText()));
              
               
                
               
                
                busControl.updateRecord(bus);
                JOptionPane.showMessageDialog(null, "Record updated.");
              
               } else {
                JOptionPane.showMessageDialog(null, "No such bus ID ", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
            }}catch(NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(null, "Please enter number format in Purchase Year");
        }}}
public static void main(String[] args) {
     try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
        new UpdateBusFrame();
}}



