package Employee;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Update extends Add implements ActionListener
{
    JFrame jf;
    JLabel lblimage,lbltitle,lblname,lblsname,lblempid,lbladdress,lblphone,lblemail,lbledu,lbljobpost,lblaadhar;
    JTextField tname,tfname,tempid,taddress,tphone,temail,tedu,tjobpost,taadhar;
    JButton bupdate,bcancel;
    String empid;
    Update(String id)
    {
        super(0);
        //JFrame Details
        jf=new JFrame("UPDATE EMPLOYEE DETAILS");
        jf.setDefaultCloseOperation(WindowConstants. EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLocation(30,30);
        jf.setLayout(null);
        jf.setSize(900,500);
        
        //Background Image
        empid=id;    
        lblimage=new JLabel();
        lblimage.setBounds(0,0,900,500);
        lblimage.setLayout(null);
        ImageIcon img=new ImageIcon("src\\Employee\\images\\add_employee.jpg");
        lblimage.setIcon(img);
        jf.add(lblimage);

        //Frame Title
        lbltitle = new JLabel("UPDATE EMPLOYEE DETAILS:");
        lbltitle.setBounds(50,10,620,50);
        lbltitle.setFont(new Font("Serif",Font.ITALIC,40));
        lbltitle.setForeground(Color.BLACK);
        lblimage.add(lbltitle);
        
        //Label Details
        //1.Name
        lblname = new JLabel("Name:");  
        lblname.setBounds(50,100,100,30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(lblname);

        tname=new JTextField();
        tname.setBounds(200,100,150,30);
        lblimage.add(tname);

        //2.Father's Name
        lblsname = new JLabel("SurName:");
        lblsname.setBounds(400,100,200,30);
        lblsname.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(lblsname);

        tfname=new JTextField();
        tfname.setBounds(600,100,150,30);
        lblimage.add(tfname);

        //3.Address
        lbladdress= new JLabel("Address:");
        lbladdress.setBounds(50,150,100,30);
        lbladdress.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(lbladdress);

        taddress=new JTextField();
        taddress.setBounds(200,150,150,30);
        lblimage.add(taddress);

        //4.Mobile No.
        lblphone= new JLabel("Mobile No:");
        lblphone.setBounds(400,150,100,30);
        lblphone.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(lblphone);

        tphone=new JTextField();
        tphone.setBounds(600,150,150,30);   
        lblimage.add(tphone);

        //Email Id
        lblemail= new JLabel("Email Id:");
        lblemail.setBounds(50,200,100,30);
        lblemail.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(lblemail);

        temail=new JTextField();
        temail.setBounds(200,200,150,30);
        lblimage.add(temail);

        //Education
        lbledu= new JLabel("Education:");
        lbledu.setBounds(400,200,100,30);
        lbledu.setFont(new Font("serif",Font.BOLD,20));    
        lblimage.add(lbledu);

        tedu=new JTextField();
        tedu.setBounds(600,200,150,30);
        lblimage.add(tedu);

        //Job Post
        lbljobpost= new JLabel("Job Post:");
        lbljobpost.setBounds(50,250,100,30);
        lbljobpost.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(lbljobpost);

        tjobpost=new JTextField();
        tjobpost.setBounds(200,250,150,30);
        lblimage.add(tjobpost);

        //Aadhar No.
        lblaadhar= new JLabel("Aadhar No:");
        lblaadhar.setBounds(400,250,100,30);  
        lblaadhar.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(lblaadhar);

        taadhar=new JTextField();
        taadhar.setBounds(600,250,150,30);
        lblimage.add(taadhar);

        //Employee ID
        lblempid= new JLabel("Employee Id:");
        lblempid.setBounds(50,300,150,30);
        lblempid.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(lblempid);
        jf.setVisible(false);
        
        tempid=new JTextField();
        tempid.setBounds(200,300,150,30);
        lblimage.add(tempid);

        bupdate=new JButton("UPDATE");
        bupdate.setBounds(250,400,120,30);
        bupdate.setBackground(Color.BLACK);
        bupdate.setForeground(Color.WHITE);
        bupdate.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        lblimage.add(bupdate);

        bcancel=new JButton("CANCEL");
        bcancel.setBounds(450,400,120,30);
        bcancel.setBackground(Color.BLACK);
        bcancel.setForeground(Color.WHITE);
        bcancel.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        lblimage.add(bcancel);

        bupdate.addActionListener(this);
        bcancel.addActionListener(this);
        showData(id);
        
        jf.setVisible(true);        
    }
    int k;
    String age,dob;
    void showData(String s1)
    {
        try{
            Databaseconn c = new Databaseconn();
            String str = "select * from employee_details where EmployeeID = '"+s1+"'";
            ResultSet rs = c.s.executeQuery(str);

            if(rs.next()){
                jf.setVisible(true);
                k=1;

                tempid.setText(rs.getString(1));
                tname.setText(rs.getString(2));
                tfname.setText(rs.getString(3));
                taddress.setText(rs.getString(6));
                tphone.setText(rs.getString(7));
                temail.setText(rs.getString(8));
                tedu.setText(rs.getString(9));
                tjobpost.setText(rs.getString(10));
                taadhar.setText(rs.getString(11));

                age=rs.getString(4);
                dob=rs.getString(5);
            }
            if(k==0)
                JOptionPane.showMessageDialog(null,"ID NOT FOUND OR EMPLOYEE DOES NOT EXISTS");
            //Search ss=new Search();
        }catch(Exception e){}
        jf.setVisible(true);
        jf.setSize(900,500);
        jf.setLocation(30,30);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==bupdate && k==1){
            try{
                Databaseconn c = new Databaseconn();
                String str = "update employee_details set Name='"+tname.getText()+"',Surname='"+tfname.getText()+"',Age='"+age+"',DOB='"+dob+"',Address='"+taddress.getText()+"',Phone='"+tphone.getText()+"',EmailID='"+temail.getText()+"',Education='"+tedu.getText()+"',JobPost='"+tjobpost.getText()+"',AadharNo='"+taadhar.getText()+"',EmployeeID='"+tempid.getText()+"' where EmployeeID='"+empid+"'";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"SUCCESSFULLY UPDATED");
                jf.dispose();
                Search ss=new Search();
            }catch(Exception e){
                System.out.println("The error is: "+e);
            }
        }
        if(ae.getSource()==bcancel){
            jf.dispose();
            MainPage mp=new MainPage();
        }
    }
    public static void main(String args[])
    {
        Update up=new Update("Update Employee");
    }
}