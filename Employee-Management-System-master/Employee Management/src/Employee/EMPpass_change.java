package Employee;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class EMPpass_change implements ActionListener
{
    JFrame jf;
    JTextField tid;
    JLabel lblid,lblnew,lblconfirm,lblimage,lblkeyid;
    JButton bcheck,bcancel,bchange,bpassgen;
    JPasswordField tconfirm,tnew,tkeyid;
    String s;
    EMPpass_change(String type)
    {
        s=type;
        
        //Frame Details
        jf=new JFrame("FORGOT PASSWORD");
        jf.setDefaultCloseOperation(WindowConstants. EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLayout(null);
        jf.setBackground(Color.green);
        jf.setLayout(null);

        //Background Image
        lblimage=new JLabel();
        lblimage.setBounds(0,0,500,500);
        lblimage.setLayout(null);
        ImageIcon img=new ImageIcon("src\\Employee\\images\\change_pass.jpg");
        lblimage.setIcon(img);
        jf.add(lblimage);

        lblid=new JLabel("ENTER EMP ID:");
        lblid.setVisible(true);
        lblid.setBounds(50,50,150,30);
        lblid.setForeground(Color.WHITE);
        lblid.setFont(new Font("serif",Font.BOLD,20)); 
        lblimage.add(lblid);
     

        //Key Id Text Field
        tid=new JTextField();
        tid.setBounds(220,50,200,30);
        tid.setFont(new Font("serif",Font.PLAIN,18));
        lblimage.add(tid);
       
        
        //Change button
        bcheck=new JButton("Change Pasword");
        bcheck.setBounds(150,120,320,30);
        bcheck.setBackground(Color.BLACK);
        bcheck.setForeground(Color.WHITE);
        bcheck.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        lblimage.add(bcheck);
        
        //Cancel button
        bcancel=new JButton("CANCEL");
        bcancel.setBounds(290,420,120,30);
        bcancel.setBackground(Color.RED);
        bcancel.setForeground(Color.BLACK);
        bcancel.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        lblimage.add(bcancel);
        if(type.equals("1")){
            bcancel.setVisible(false);
        }
        
        //auto password generating button
        bpassgen=new JButton("Generate Secure ");
        bpassgen.setBounds(350,215,130,20);
        bpassgen.setBackground(Color.WHITE);
        bpassgen.setForeground(Color.BLACK);
        bpassgen.setFont(new Font("TIMES_NEW_ROMAN",Font.BOLD,10));
        bpassgen.setVisible(false);
        bpassgen.addActionListener(this);
        lblimage.add(bpassgen);
        
        bcheck.addActionListener(this);
        bcancel.addActionListener(this);
        
        //New,Confirm Password and Key ID Label Details
        lblnew=new JLabel("NEW PASSWORD:");
        lblnew.setVisible(true);
        lblnew.setBounds(40,180,170,30);
        lblnew.setForeground(Color.WHITE);
        lblnew.setFont(new Font("serif",Font.BOLD,20)); 
        lblimage.add(lblnew);
        
        lblconfirm=new JLabel("CONFIRM PASSWORD:");
        lblconfirm.setVisible(true);
        lblconfirm.setBounds(40,250,220,30);
        lblconfirm.setForeground(Color.WHITE);
        lblconfirm.setFont(new Font("serif",Font.BOLD,20)); 
        lblimage.add(lblconfirm);
        
        lblkeyid=new JLabel("NEW KEY ID:");
        lblkeyid.setVisible(true);
        lblkeyid.setBounds(40,300,220,30);
        lblkeyid.setForeground(Color.WHITE);
        lblkeyid.setFont(new Font("serif",Font.BOLD,20)); 
        lblimage.add(lblkeyid);
        
        //New, Confirm Password and New Key Id TextField
        tnew=new JPasswordField();
        tnew.setBounds(280,180,190,30);
        tnew.setFont(new Font("serif",Font.PLAIN,18));
        lblimage.add(tnew);
        
        tconfirm=new JPasswordField();
        tconfirm.setBounds(280,250,190,30);
        tconfirm.setFont(new Font("serif",Font.PLAIN,18));
        lblimage.add(tconfirm);
        
        tkeyid=new JPasswordField();
        tkeyid.setBounds(280,300,190,30);
        tkeyid.setFont(new Font("serif",Font.PLAIN,18));
        lblimage.add(tkeyid);
        
        //Button Change
        bchange=new JButton("CHANGE PASSWORD");
        bchange.setBounds(140,350,220,30);
        bchange.setBackground(Color.BLACK);
        bchange.setForeground(Color.WHITE);
        bchange.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        lblimage.add(bchange);
        bchange.addActionListener(this);
        
        lblnew.setVisible(false);
        lblconfirm.setVisible(false);
        lblkeyid.setVisible(false);
        tnew.setVisible(false);
        tconfirm.setVisible(false);
        tkeyid.setVisible(false);
        bchange.setVisible(false);
        
        jf.setSize(500,500);
        jf.setLocation(30,30);
        jf.setVisible(true);

    }

    public void actionPerformed(ActionEvent ae)
    {

        if(ae.getSource()==bcancel)
        {
            jf.dispose();
            EMPlogin l=new EMPlogin();
        }
        String s1 = tid.getText();
        if(ae.getSource()==bcheck)
        {
            try
            {
                
                if ( s1.equals("")) {
                    JOptionPane.showMessageDialog(null, "You must fill in  the text field!",
               "Swing Tester", JOptionPane.ERROR_MESSAGE);
                }
                else{
                Databaseconn c=new Databaseconn();
                String s=tid.getText();
                String str = "select * from employee_login where username ='"+s+"' ";
                ResultSet rs = c.s.executeQuery(str);
                int i=0;
                if(rs.next())
                {
                    String username = rs.getString(1);
                    if(username.equals(s))
                        i=1;
                }
                if(i==0)
                {
                    jf.dispose();
                    JOptionPane.showMessageDialog(null,"INCORRECT EMP ID");
                    EMPpass_change f=new EMPpass_change(this.s);
                }
                if(i==1)
                {
                    lblnew.setVisible(true);
                    lblconfirm.setVisible(true);
                    lblkeyid.setVisible(true);
                    tnew.setVisible(true);
                    tconfirm.setVisible(true);
                    tkeyid.setVisible(true);
                    bchange.setVisible(true); 
                    bpassgen.setVisible(true);
                }
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        if(ae.getSource()==bchange)
        {
            String newpassword = tnew.getText();
            String confirmpassword=tconfirm.getText();
            String newkeyid=tkeyid.getText();
            try
            {
                if ( newpassword.equals("")||confirmpassword.equals("")||newkeyid.equals("")) {
                    JOptionPane.showMessageDialog(null, "You must fill in  the text fields!",
               "Swing Tester", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    Databaseconn c=new Databaseconn();
                    if(newpassword.equals(confirmpassword))
                    {
                        String str1="update employee_login set password='"+newpassword+"',keyid= '"+newkeyid+"' where username= '"+s1+"';";
                        c.s.executeUpdate(str1);
                        String str2="select * from employee_login;";
                        ResultSet rs1=c.s.executeQuery(str2);
                        String displaykeyid="";
                        while(rs1.next()){
                            displaykeyid=rs1.getString(3);
                        }
                        jf.dispose();
                        JOptionPane.showMessageDialog(null,"PASSWORD CHANGED SUCCESSFULLY AND NEW KEYID = "+displaykeyid);
                        EMPlogin l=new EMPlogin();
                    }
                    else
                    {
                        jf.dispose();
                        JOptionPane.showMessageDialog(null,"NEW PASSWORD DOES NOT MATCH");
                        EMPpass_change f=new EMPpass_change("0");
                    }
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
                    
        }
        else if(ae.getSource()==bpassgen)
        {
           PasswordGenerator passwordGenerator = new PasswordGenerator.PasswordGeneratorBuilder()
        .useDigits(true)
        .useLower(true)
        .useUpper(true)
        .build();
        String password = passwordGenerator.generate(8);
        System.out.println(password);
        tnew.setText(password);
        tconfirm.setText(password);
        JOptionPane.showMessageDialog(null, "Your Password is: "+password);
        
        }

    }
    public static void main(String[]ar)
    {
        EMPpass_change f=new EMPpass_change("0");
    }
}