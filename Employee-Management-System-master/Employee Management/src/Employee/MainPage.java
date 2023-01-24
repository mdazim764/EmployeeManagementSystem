package Employee;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainPage implements ActionListener{
   
    JFrame jf;
    JLabel lblimage,lbltitle;
    JButton badd,bremove,bview,bupdate,logout;
    MainPage()
    {
        jf=new JFrame("MAIN PAGE");
        
        //Background Image
        lblimage= new JLabel();
        lblimage.setBounds(0,0,750,435);
        lblimage.setLayout(null);
        ImageIcon i = new ImageIcon("src\\Employee\\images\\emp_main.jpg");
        lblimage.setIcon(i);
        jf.add(lblimage);
        
        //Adding Buttons
        //1.Add button
        badd=new JButton("ADD");
        badd.setBounds(430,80,120,40);
        badd.setFont(new Font("Times_New_Roman",Font.BOLD,16));
        badd.setForeground(Color.BLACK);
        badd.setBackground(Color.LIGHT_GRAY);
        lblimage.add(badd);
        
        //2.Remove Button
        bremove=new JButton("REMOVE");
        bremove.setBounds(430,140,120,40);
        bremove.setFont(new Font("Times_New_Roman",Font.BOLD,16));
        bremove.setForeground(Color.BLACK);
        bremove.setBackground(Color.LIGHT_GRAY);
        lblimage.add(bremove);
        
        //3.View Button
        bview=new JButton("VIEW");
        bview.setBounds(560,80,120,40);
        bview.setFont(new Font("Times_New_Roman",Font.BOLD,16));
        bview.setForeground(Color.BLACK);
        bview.setBackground(Color.LIGHT_GRAY);
        lblimage.add(bview);
        
        //4.Update button
        bupdate=new JButton("UPDATE");
        bupdate.setBounds(560,140,120,40);
        bupdate.setFont(new Font("Times_New_Roman",Font.BOLD,16));
        bupdate.setForeground(Color.BLACK);
        bupdate.setBackground(Color.LIGHT_GRAY);
        lblimage.add(bupdate);
        
        //5.logout button
        logout=new JButton("LogOut");
        logout.setBounds(600,330,120,40);
        logout.setFont(new Font("Times_New_Roman",Font.BOLD,16));
        logout.setForeground(Color.BLACK);
        logout.setBackground(Color.RED);
        lblimage.add(logout);
        
        //Add Action Listeners to buttons
        bview.addActionListener(this);
        bremove.addActionListener(this);
        badd.addActionListener(this);
        bupdate.addActionListener(this);
        logout.addActionListener(this);
        
        
        
        
        //Frame details
        jf.setDefaultCloseOperation(WindowConstants. EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLayout(null);
        jf.setLocation(30,30);
        jf.setSize(750,435);
        jf.setVisible(true);
        
        
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==badd)
        {
            jf.dispose();
            Add a=new Add();
        }
        else if(ae.getSource()==bview)
        {
            jf.dispose();
            View v=new View();
        }
        else if(ae.getSource()==bupdate)
        {
            jf.dispose();
            Search ss=new Search();
        }
        else if(ae.getSource()==bremove)
        {
            jf.dispose();
            Remove r=new Remove();
        }
        else if(ae.getSource()==logout)
        {
            int result = JOptionPane.showConfirmDialog(null,"Sure? You want to LogOut?", "Swing Tester",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
               jf.setVisible(false);
               jf.dispose();
               Login l=new Login();
            }
        }
    }
    public static void main(String args[])
    {
        MainPage mp=new MainPage();
    }
}
