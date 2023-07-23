package University.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class AddTeacher extends JFrame implements ActionListener {
    JTextField tfname, tffname, tfphone, tfaddress, tfemail, tfclx, tfclxii, tfadhar;
    JComboBox cbcourse, cbbranch;
    JLabel labelrollno;
    JDateChooser dcdob;
    JButton submit , cancel;
    //random number
    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);
    AddTeacher(){

        setSize(900,700);
        setLocation(350,50);
        setBackground(Color.WHITE);

        setLayout(null);

        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        //heading.setForeground(Color.blue);
        add(heading);

        //name
        JLabel name = new JLabel("Name");
        name.setBounds(50,150,100,20);
        name.setFont(new Font("serif", Font.BOLD, 20));
        add(name);

        //Textfield
        tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);

        JLabel FatherName = new JLabel("Father's Name");
        FatherName.setBounds(400,150,200,30);
        FatherName.setFont(new Font("serif", Font.BOLD, 20));
        add(FatherName);

        //Textfield
        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);

        //rollno
        JLabel empid = new JLabel("Employee Id");
        empid.setBounds(50,200,200,30);
        empid.setFont(new Font("serif", Font.BOLD, 20));
        add(empid);

        labelrollno = new JLabel("2023"+first4);
        labelrollno.setBounds(250,200,200,30);
        labelrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(labelrollno);

        //dateofbirth
        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(400,200,200,30);
        dob.setFont(new Font("serif", Font.BOLD, 20));
        add(dob);

        //calendar
        dcdob = new JDateChooser();
        dcdob.setBounds(600,200,150,30);
        add(dcdob);

        //address
        JLabel address = new JLabel("Address");
        address.setBounds(50,250,200,20);
        address.setFont(new Font("serif", Font.BOLD, 20));
        add(address);

        //Textfield
        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);

        //phone
        JLabel phone = new JLabel("Phone");
        phone.setBounds(400,250,200,20);
        phone.setFont(new Font("serif", Font.BOLD, 20));
        add(phone);

        //Textfield
        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);

        //email
        JLabel email = new JLabel("Email Id");
        email.setBounds(50,300,200,20);
        email.setFont(new Font("serif", Font.BOLD, 20));
        add(email);

        //Textfield
        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);

        //class x
        JLabel ClassX = new JLabel("Class X (%)");
        ClassX.setBounds(400,300,250,30);
        ClassX.setFont(new Font("serif", Font.BOLD, 20));
        add(ClassX);

        //Textfield
        tfclx = new JTextField();
        tfclx.setBounds(600,300,150,30);
        add(tfclx);

        //class xii
        JLabel ClassXII = new JLabel("Class XII (%)");
        ClassXII.setBounds(50,350,200,30);
        ClassXII.setFont(new Font("serif", Font.BOLD, 20));
        add(ClassXII);

        //Textfield
        tfclxii = new JTextField();
        tfclxii.setBounds(200,350,150,30);
        add(tfclxii);

        //adhar
        JLabel adhar = new JLabel("Aadhar Number");
        adhar.setBounds(400,350,250,30);
        adhar.setFont(new Font("serif", Font.BOLD, 20));
        add(adhar);

        //Textfield
        tfadhar = new JTextField();
        tfadhar.setBounds(600,350,150,30);
        add(tfadhar);

        //course
        JLabel education = new JLabel("Education");
        education.setBounds(50,400,200,30);
        education.setFont(new Font("serif", Font.BOLD, 20));
        add(education);

        //choose course
        String Course[] = {"B.Tech", "BBA", "MBA", "BCA", "Bsc", "Msc", "B.Pharma","Bsc Nurshing","MCA", "B.com", "M.com", "BA", "MA"};
        cbcourse = new JComboBox(Course);
        cbcourse.setBounds(200,400,150,30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        //branch
        JLabel branch = new JLabel("Branch");
        branch.setBounds(400,400,200,30);
        branch.setFont(new Font("serif", Font.BOLD, 20));
        add(branch);

        //choose course
        String Branch[] = {"Computer Science", "Electronics", "Mechanical", "Civil", "Chemical", "IT"};
        cbbranch = new JComboBox(Branch);
        cbbranch.setBounds(600,400,150,30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);

        //buttons
        submit = new JButton("Submit");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);


        setVisible(true);

    }

    public static void main(String[] args) {
        new AddTeacher();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == submit){
            String name = tfname.getText();
            String FatherName = tffname.getText();
            String empid = labelrollno.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String Phone = tfphone.getText();
            String email = tfemail.getText();
            String ClassX = tfclx.getText();
            String ClassXII = tfclxii.getText();
            String aadhar = tfadhar.getText();
            String education = (String) cbcourse.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();

            try{
                String query = "insert into teacher values('"+name+"','"+FatherName+"','"+ empid +"','"+dob+"','"+address+"','"+Phone+"','"+email+"','"+ClassX+"','"+ClassXII+"','"+aadhar+"','"+education+"','"+branch+"')";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Student Details inserted Successfully");
                setVisible(false);


            }catch(Exception e){
                e.printStackTrace();
            }

        }else{
            setVisible(false);
        }
    }
}
