package Employee;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Remove implements ActionListener
{
    JFrame jf;
    JLabel lblimage,lblempid,lblname,lblphone,lblname1,lblphone1,lblemail,lblemail1;
    JTextField tempid;
    JButton bsearch,bback,bremove,bcancel;
    Remove()
    {
        //Frame Details
        jf=new JFrame("REMOVE EMPLOYEE");
        jf.setDefaultCloseOperation(WindowConstants. EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLocation(30,30);
        jf.setLayout(null);
        jf.setSize(500,500);
        
        //Background Image
        lblimage=new JLabel();
        lblimage.setBounds(0,0,500,500);
        lblimage.setLayout(null);
        ImageIcon img=new ImageIcon("src\\Employee\\images\\remove.jpg");
        lblimage.setIcon(img);
        jf.add(lblimage);
        
        //Label Details
        lblempid=new JLabel("EMPLOYEE ID:");
        lblempid.setBounds(50,50,250,30);
        lblempid.setForeground(Color.BLACK);
        lblempid.setFont(new Font("Times_New_Roman",Font.BOLD,25)); 
        lblimage.add(lblempid);

        tempid=new JTextField();
        tempid.setBounds(250,50,150,30);
        tempid.setFont(new Font("serif",Font.PLAIN,18));
        lblimage.add(tempid);

        //Button Details
        bsearch=new JButton("SEARCH");
        bsearch.setBounds(200,100,120,30);
        bsearch.setBackground(Color.BLACK);
        bsearch.setForeground(Color.WHITE);
        bsearch.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        lblimage.add(bsearch);

        bback=new JButton("BACK");
        bback.setBounds(340,100,100,30);   
        bback.setBackground(Color.BLACK);
        bback.setForeground(Color.WHITE);
        bback.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        lblimage.add(bback);
        
        bremove=new JButton("REMOVE");
        bremove.setBounds(120,300,120,30);
        bremove.setBackground(Color.BLACK);
        bremove.setForeground(Color.WHITE);
        bremove.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        lblimage.add(bremove);
        
        bcancel=new JButton("CANCEL");
        bcancel.setBounds(300,300,120,30);
        bcancel.setBackground(Color.BLACK);
        bcancel.setForeground(Color.WHITE);
        bcancel.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        lblimage.add(bcancel);
        
        //Other Labels
        lblname=new JLabel("Name:"); 
        lblname.setBounds(50,150,250,30);
        lblname.setForeground(Color.white);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(lblname);

        lblname1=new JLabel();    
        lblname1.setBounds(200,150,350,30);
        lblname1.setForeground(Color.white);
        lblname1.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(lblname1);

        lblphone=new JLabel("Mobile No:");
        lblphone.setBounds(50,200,250,30);
        lblphone.setForeground(Color.white);
        lblphone.setFont(new Font("serif",Font.BOLD,20)); 
        lblimage.add(lblphone);
        
        lblphone1=new JLabel();
        lblphone1.setBounds(200,200,350,30);
        lblphone1.setForeground(Color.white);
        lblphone1.setFont(new Font("serif",Font.BOLD,20)); 
        lblimage.add(lblphone1);

        lblemail=new JLabel("Email Id:");
        lblemail.setBounds(50,250,250,30);
        lblemail.setForeground(Color.white);
        lblemail.setFont(new Font("serif",Font.BOLD,20)); 
        lblimage.add(lblemail);

        lblemail1=new JLabel();
        lblemail1.setBounds(200,250,350,30);
        lblemail1.setForeground(Color.white);
        lblemail1.setFont(new Font("serif",Font.BOLD,20)); 
        lblimage.add(lblemail1);

        lblname.setVisible(false);
        lblemail.setVisible(false);
        lblphone.setVisible(false);
        bremove.setVisible(false);
        bcancel.setVisible(false);
        
        //Button ActionListener
        bsearch.addActionListener(this);
        bback.addActionListener(this);
        bremove.addActionListener(this);
        bcancel.addActionListener(this);
        
        jf.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==bsearch)
        {
            try{
                Databaseconn c = new Databaseconn();
                String s1=tempid.getText();
                String str = "select Name,Phone,EmailID from employee_details where EmployeeID ='"+s1+"' ";
                ResultSet rs = c.s.executeQuery(str);
                int i=0;
                if(rs.next()){
                    String name = rs.getString(1);
                    String mob = rs.getString(2);
                    String email=rs.getString(3);

                    lblname.setVisible(true);
                    lblphone.setVisible(true);
                    lblemail.setVisible(true);
                    bremove.setVisible(true);
                    bcancel.setVisible(true);    
                    i=1;
                    lblname1.setText(name);
                    lblphone1.setText(mob);
                    lblemail1.setText(email);
                }
                if(i==0)
                    JOptionPane.showMessageDialog(null,"ID NOT FOUND OR EMPLOYEE DOES NOT EXISTS");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        if(ae.getSource()==bremove){
            try{
                Databaseconn c = new Databaseconn();
                String s1=tempid.getText();
                String str = "delete from employee_details where EmployeeID = '"+s1+"'";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"DELETED SUCCESSFULLY");
                lblname.setVisible(false);
                lblphone.setVisible(false);
                lblemail.setVisible(false);
                lblname1.setVisible(false);
                lblphone1.setVisible(false);
                lblemail1.setVisible(false);
                bremove.setVisible(false);
                bcancel.setVisible(false);

            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"EXCEPTION OCCURED WHILE DELETING RECORD "+e);
            }
        }
        if(ae.getSource()==bcancel){
            jf.dispose();
            MainPage mp=new MainPage();
        }
        if(ae.getSource()==bback){
            jf.dispose();
            MainPage mp=new MainPage();
        }
    }
    public static void main(String args[])
    {
        Remove r=new Remove();
    }
}
