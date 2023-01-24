package Employee;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Search implements ActionListener
{
    JFrame jf;
    JLabel lblimage,lblempid;
    JTextField tempid;
    JButton bsearch,bcancel;
    Search()
    {
        //Frame Details
        jf=new JFrame("SEARCH EMPLOYEE");
        jf.setDefaultCloseOperation(WindowConstants. EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLocation(30,30);
        jf.setLayout(null);
        jf.setSize(500,270);
        
        //Background Image
        lblimage=new JLabel();
        lblimage.setBounds(0,0,500,270);
        lblimage.setLayout(null);
        ImageIcon img=new ImageIcon("src\\Employee\\images\\view.jpg");
        lblimage.setIcon(img);
        jf.add(lblimage);
        
        //Label Details
        lblempid=new JLabel("EMPLOYEE ID:");
        lblempid.setBounds(40,50,250,30);
        lblempid.setForeground(Color.BLACK);
        lblempid.setFont(new Font("Times_New_Roman",Font.BOLD,25)); 
        lblimage.add(lblempid);
        
        tempid=new JTextField();
        tempid.setBounds(240,50,220,30);
        tempid.setFont(new Font("serif",Font.PLAIN,18));
        lblimage.add(tempid);
           
        //Button Details
        bsearch=new JButton("SEARCH");
        bsearch.setBounds(220,150,120,30);
        bsearch.setBackground(Color.BLACK);
        bsearch.setForeground(Color.WHITE);
        bsearch.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        lblimage.add(bsearch);

        bcancel=new JButton("CANCEL");
        bcancel.setBounds(360,150,120,30);
        bcancel.setBackground(Color.BLACK);
        bcancel.setForeground(Color.WHITE);
        bcancel.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        lblimage.add(bcancel);
        
        bsearch.addActionListener(this);
        bcancel.addActionListener(this);
        
        jf.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==bsearch)
        {
            try
            {
                Databaseconn c=new Databaseconn();
                String str = "select Name,Phone,EmailID from employee_details where EmployeeID ='"+tempid.getText()+"';";
                ResultSet rs = c.s.executeQuery(str);
                int i=0;
                if(rs.next())
                {
                    String name = rs.getString(1);
                    String mob = rs.getString(2);
                    String email=rs.getString(3);
                    i=1;
                }
                if(i==0)
                {
                    jf.dispose();
                    JOptionPane.showMessageDialog(null,"ID NOT FOUND OR EMPLOYEE DOES NOT EXISTS");
                    Search ss=new Search();
                }
                if(i==1)
                {
                    jf.dispose();
                    Update up=new Update(tempid.getText());
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==bcancel)
        {
            jf.dispose();
            MainPage mp=new MainPage();
        }
    }
    public static void main(String args[])
    {
        Search ss=new Search();
    }
}