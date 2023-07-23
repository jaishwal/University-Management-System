package University.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStudent extends JFrame implements ActionListener {
    JTextField tfphone, tfaddress, tfemail,cbcourse,cbbranch;
    JLabel labelrollno, tfname,tffname,dcdob;
    JButton submit , cancel;
    Choice crollno;

    UpdateStudent(){

        setSize(900,650);
        setLocation(350,50);
        setBackground(Color.WHITE);

        setLayout(null);

        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("Tahoma", Font.ITALIC, 35));
        //heading.setForeground(Color.blue);
        add(heading);

        JLabel lblrollnumber = new JLabel("Select Roll Number");
        lblrollnumber.setBounds(50,100,200,20);
        lblrollnumber.setFont(new Font("serif", Font.PLAIN,20));
        add(lblrollnumber);

        //search by choice
        crollno = new Choice();
        crollno.setBounds(250,100,200,20);
        add(crollno);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        }catch (Exception ae){
            ae.printStackTrace();
        }

        //name
        JLabel name = new JLabel("Name");
        name.setBounds(50,150,100,20);
        name.setFont(new Font("serif", Font.BOLD, 20));
        add(name);

        tfname = new JLabel();
        tfname.setBounds(200,150,200,30);
        tfname.setFont(new Font("serif", Font.PLAIN, 18));
        add(tfname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400,150,200,30);
        fname.setFont(new Font("serif", Font.BOLD, 20));
        add(fname);

        tffname = new JLabel();
        tffname.setBounds(600,150,200,30);
        tffname.setFont(new Font("serif", Font.PLAIN, 18));
        add(tffname);

        //rollno
        JLabel rollno = new JLabel("Roll Number");
        rollno.setBounds(50,200,200,30);
        rollno.setFont(new Font("serif", Font.BOLD, 20));
        add(rollno);

        labelrollno = new JLabel();
        labelrollno.setBounds(200,200,200,30);
        labelrollno.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelrollno);

        //dateofbirth
        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(400,200,200,30);
        dob.setFont(new Font("serif", Font.BOLD, 20));
        add(dob);

        //calendar
        dcdob = new JLabel();
        dcdob.setBounds(600,200,150,30);
        dcdob.setFont(new Font("serif", Font.PLAIN, 18));
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
        tfphone.setFont(new Font("serif", Font.PLAIN, 18));
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
        JLabel tfclx = new JLabel();
        tfclx.setBounds(600,300,150,30);
        tfclx.setFont(new Font("serif", Font.PLAIN, 18));
        add(tfclx);

        //class xii
        JLabel ClassXII = new JLabel("Class XII (%)");
        ClassXII.setBounds(50,350,200,30);
        ClassXII.setFont(new Font("serif", Font.BOLD, 20));
        add(ClassXII);

        //Textfield
        JLabel tfclxii = new JLabel();
        tfclxii.setBounds(200,350,150,30);
        tfclxii.setFont(new Font("serif", Font.PLAIN, 18));
        add(tfclxii);

        //adhar
        JLabel adhar = new JLabel("Aadhar Number");
        adhar.setBounds(400,350,250,30);
        adhar.setFont(new Font("serif", Font.BOLD, 20));
        add(adhar);

        //Textfield
        JLabel tfadhar = new JLabel();
        tfadhar.setBounds(600,350,150,30);
        tfadhar.setFont(new Font("serif", Font.PLAIN, 18));
        add(tfadhar);

        //course
        JLabel course = new JLabel("Course");
        course.setBounds(50,400,200,30);
        course.setFont(new Font("serif", Font.BOLD, 20));
        add(course);

        cbcourse = new JTextField();
        cbcourse.setBounds(200,400,150,30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        //branch
        JLabel branch = new JLabel("Branch");
        branch.setBounds(400,400,200,30);
        branch.setFont(new Font("serif", Font.BOLD, 20));
        add(branch);


        cbbranch = new JTextField();
        cbbranch.setBounds(600,400,150,30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);

        try{
            Conn c = new Conn();
            String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                tfname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                labelrollno.setText(rs.getString("rollno"));
                dcdob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("Phone"));
                tfemail.setText(rs.getString("email"));
                tfclx.setText(rs.getString("ClassX"));
                tfclxii.setText(rs.getString("ClassXII"));
                tfadhar.setText(rs.getString("aadhar"));
                cbcourse.setText(rs.getString("course"));
                cbbranch.setText(rs.getString("branch"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        //for new searching
        crollno.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                try{
                    Conn c = new Conn();
                    String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        tfname.setText(rs.getString("name"));
                        tffname.setText(rs.getString("fname"));
                        labelrollno.setText(rs.getString("rollno"));
                        dcdob.setText(rs.getString("dob"));
                        tfaddress.setText(rs.getString("address"));
                        tfphone.setText(rs.getString("Phone"));
                        tfemail.setText(rs.getString("email"));
                        tfclx.setText(rs.getString("ClassX"));
                        tfclxii.setText(rs.getString("ClassXII"));
                        tfadhar.setText(rs.getString("aadhar"));
                        cbcourse.setText(rs.getString("course"));
                        cbbranch.setText(rs.getString("branch"));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        //buttons
        submit = new JButton("Update");
        submit.setBounds(250, 500, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 500, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);

    }

    public static void main(String[] args) {
        new UpdateStudent();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == submit){
            String rollno = labelrollno.getText();
            String address = tfaddress.getText();
            String Phone = tfphone.getText();
            String email = tfemail.getText();
            String course = cbcourse.getText();
            String branch = cbbranch.getText();

            try{
                String query = "update student set address='"+address+"',Phone='"+Phone+"',email = '"+email+"',course='"+course+"', branch ='"+branch+"' where rollno = '"+rollno+"'";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Student Details updated Successfully");
                setVisible(false);


            }catch(Exception e){
                e.printStackTrace();
            }

        }else{
            setVisible(false);
        }
    }
}
