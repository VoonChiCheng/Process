package ui;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.awt.print.*;
import javax.swing.plaf.basic.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.text.rtf.*;
import javax.swing.undo.*;
import javax.swing.*;
import domain.*;
import java.awt.*;
import java.awt.print.Printable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.text.View.X_AXIS;
import static javax.swing.text.View.Y_AXIS;

public class TicketFrame extends javax.swing.JPanel implements Printable{
    
   protected PrintView m_printView;
   protected DefaultStyledDocument m_doc;
    StyleContext m_context;
 
 private JLabel jlbTitle = new JLabel("Top Bus Ticket");
    private JPanel j = new JPanel();
       private Font largeFont = new Font("Serif", Font.BOLD, 23);
 javax.swing.JTextArea  textarea = new javax.swing.JTextArea();
       private JPanel jp = new JPanel();
       private JPanel jp1 = new JPanel(new BorderLayout());
           private Font smallFont = new Font("Serif", Font.PLAIN, 20);
               private ImageIcon logo = new ImageIcon(getClass().getResource("logo.gif"));
           private JButton jbtPrint = new JButton("Print");
            private JPanel jpSouth = new JPanel();
     
         private JLabel jlblogo = new JLabel(logo);
    
    public TicketFrame(ArrayList<TicketP> t){
       m_context = new StyleContext();
        m_doc = new DefaultStyledDocument(m_context);
        textarea.setDocument(m_doc);
          
        j.add(jlblogo);
     //   j.add(jlbTitle);
        jlbTitle.setFont(largeFont);
        String str = "";
        for(int i =0;i<t.size();i++){

             SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
      String dateStr = DATE_FORMAT.format(t.get(i).getDepartDate());
            
            str += "\n=====================================\n" + "\tTop Bus Ticket\n\n"
                    + "Ticket ID :" + t.get(i).getTicketID() + "\nSchedule ID : " + t.get(i).getScheduleID() +
                    "\nBus Plate No : " + t.get(i).getPlateNo() + "\nDestination : " + t.get(i).getDestination() + "\nDeparture Date " +
                    dateStr + "\nDeparture Time : " + t.get(i).getDepartTime() + "\nPrice : RM" + String.format("%.2f", t.get(i).getPrice()) +
                    "\nSeat No : " + t.get(i).getSeatID() + "\n\n";
    
           
        }
        textarea.setText(str);
       
        textarea.setOpaque(true);
       //final TextArea text = textarea;
        textarea.setBackground(new Color(255,255,255));
        jp1.setOpaque(true);
       jp.add(textarea);
       textarea.setEditable(false);
       textarea.setFont(largeFont);
     //  textarea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
      // textarea.setHorizontalAlignment(JTextField.LEFT);
      
    //   textarea.setAlignmentX(LEFT_ALIGNMENT);
     //  textarea.setLineWrap(true);
     //  textarea.setWrapStyleWord(true);
      
        add(jp1);
        jbtPrint.setMnemonic(KeyEvent.VK_P);
    //  add(jpSouth,BorderLayout.SOUTH);
      //  jp1.add(jbtPrint);
        jpSouth.add(jbtPrint);
        jpSouth.setBackground(new Color(204,255,255));
        jbtPrint.setFont(smallFont);
       
   /*     jbtPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });*/
        
        jbtPrint.addActionListener(new java.awt.event.ActionListener() {

         
          public void actionPerformed(java.awt.event.ActionEvent evt){
              try {
                  jbutton_printActionPerformed(evt);
              } catch (PrinterException ex) {
                  Logger.getLogger(TicketFrame.class.getName()).log(Level.SEVERE, null, ex);
              }
           }
       } );
      
      j.setBackground(new Color(204,255,255));
     setBackground(new Color(204,255,255));
        jp1.add(j,BorderLayout.NORTH);
        jp1.add(jp,BorderLayout.CENTER);
        jp1.add(jpSouth,BorderLayout.SOUTH);
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setPrintable(TicketFrame.this);
        if (pj.printDialog()) {
            try { pj.print(); }
            catch (PrinterException pe) {
                System.out.println(pe);
            }
        }
    }
    
    public int print(Graphics pg, PageFormat pageFormat,
    int pageIndex) throws PrinterException {
        pg.translate((int)pageFormat.getImageableX(),
        (int)pageFormat.getImageableY());
        int wPage = (int)pageFormat.getImageableWidth();
        int hPage = (int)pageFormat.getImageableHeight();
        pg.setClip(0, 0, wPage, hPage);
         
        // Only do this once per print
        if (m_printView == null) {
            BasicTextUI btui = (BasicTextUI)textarea.getUI();
            View root = btui.getRootView( textarea );
           
            m_printView = new PrintView(
            m_doc.getDefaultRootElement(),
            root, wPage, hPage);
        }
         
        boolean bContinue = m_printView.paintPage(pg,
        hPage, pageIndex);
        System.gc();
         
        if (bContinue)
            return PAGE_EXISTS;
        else {
            m_printView = null;
            return NO_SUCH_PAGE;
        }
    }
    
    class PrintView extends BoxView {
        protected int m_firstOnPage = 0;
        protected int m_lastOnPage = 0;
        protected int m_pageIndex = 0;
         
        public PrintView(Element elem, View root, int w, int h) {
            super(elem, Y_AXIS);
            setParent(root);
            setSize(w, h);
            layout(w, h);
        }
    
     
         
        public boolean paintPage(Graphics g, int hPage,
        int pageIndex) {
            if (pageIndex > m_pageIndex) {
                m_firstOnPage = m_lastOnPage + 1;
                if (m_firstOnPage >= getViewCount())
                    return false;
                m_pageIndex = pageIndex;
            }
            int yMin = getOffset(Y_AXIS, m_firstOnPage);
            int yMax = yMin + hPage;
            Rectangle rc = new Rectangle();
             
            for (int k = m_firstOnPage; k < getViewCount(); k++) {
                rc.x = getOffset(X_AXIS, k);
                rc.y = getOffset(Y_AXIS, k);
                rc.width = getSpan(X_AXIS, k);
                rc.height = getSpan(Y_AXIS, k);
                if (rc.y+rc.height > yMax)
                    break;
                m_lastOnPage = k;
                rc.y -= yMin;
                paintChild(g, rc, k);
            }
            return true;
        }
   
}
    private void jbutton_printActionPerformed(java.awt.event.ActionEvent evt) throws PrinterException{
        boolean complete = textarea.print();
    }
}