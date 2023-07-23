package University.management.system;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {
    About(){
        setSize(700,500);
        setLocation(400,150);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //heading
        JLabel heading = new JLabel("<html>University<br>Management System</html>");
        heading.setBounds(70,20,300,130);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);

        //Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dj.jpg"));
        Image i2 = i1.getImage().getScaledInstance(280,280,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,300,200);
        add(image);

        //name
        JLabel name = new JLabel("Developed By: Dheeraj Jaiswal");
        name.setBounds(70,220,550,40);
        name.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(name);

        //roll number
        JLabel roll = new JLabel("Roll Number: 210582022");
        roll.setBounds(70,280,550,40);
        roll.setFont(new Font("Tahoma", Font.PLAIN, 25));
        add(roll);

        //contact
        JLabel contact = new JLabel("Phone Number: 6203333236");
        contact.setBounds(70,330,550,40);
        contact.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(contact);

        JLabel email = new JLabel("Email: dheerajjaiswal@3333gmail.com");
        email.setBounds(70,370,550,40);
        email.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(email);

        setVisible(true);
    }

    public static void main(String[] args) {
        new About();
    }
}
