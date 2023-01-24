package Employee;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class EMPMain implements ActionListener
{
    JFrame jf;
    JLabel lblimage;
    
    JButton bchange,logout,bview;
    EMPMain()
    {
        //JFrame Details
        jf=new JFrame("EMPLOYEE");
        jf.setDefaultCloseOperation(WindowConstants. EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLocation(30,30);
        jf.setLayout(null);
        jf.setSize(500,270);
        
        //Background Image
        lblimage=new JLabel();
        lblimage.setBounds(0,0,500,270);
        lblimage.setLayout(null);
        ImageIcon img=new ImageIcon("src\\Employee\\images\\emp_main1.jpg");
        lblimage.setIcon(img);
        jf.add(lblimage);
        
        
        //Button Details
        bchange=new JButton("CHANGE PASSWORD");
        logout=new JButton("LogOut");
        bview=new JButton("VIEW DETAILS");
        
        bchange.setBounds(40,50,220,30);
        bchange.setFont(new Font("Times_New_Roman",Font.BOLD,16));
        bchange.setForeground(Color.BLACK);
        bchange.setBackground(Color.WHITE);
        lblimage.add(bchange);
        
        bview.setBounds(40,100,220,30);
        bview.setFont(new Font("Times_New_Roman",Font.BOLD,16));
        bview.setForeground(Color.BLACK);
        bview.setBackground(Color.WHITE);
        lblimage.add(bview);
        
        logout.setBounds(350,180,100,30);
        logout.setFont(new Font("Times_New_Roman",Font.BOLD,16));
        logout.setForeground(Color.BLACK);
        logout.setBackground(Color.RED);
        lblimage.add(logout);
        
        bchange.addActionListener(this);
        logout.addActionListener(this);
        bview.addActionListener(this);
        
        jf.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==bchange)
        {
            jf.dispose();
            EMPpass_change f=new EMPpass_change("1");
        }
        else if(ae.getSource()==logout)
        {
            int result = JOptionPane.showConfirmDialog(null,"Sure? You want to LogOut?", "Swing Tester",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
               jf.setVisible(false);
               jf.dispose();
               EMPlogin l=new EMPlogin();
            }
        }
        else if(ae.getSource()==bview)
        {
            jf.dispose();
            EMPView v=new EMPView();
        }
    }
    public static void main(String args[])
    {
        EMPMain m=new EMPMain();
    }
}
