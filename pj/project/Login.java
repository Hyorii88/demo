package project;

import java.util.HashMap;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login implements ActionListener {
    JFrame frame = new JFrame("Login Page");
    JButton dangnhap = new JButton("Dang nhap");
    JTextField user = new JTextField();
    JPasswordField pass = new JPasswordField();
    JLabel userlabel = new JLabel("Ten dang nhap");
    JLabel passLabel = new JLabel("Mat khau");
    JLabel message = new JLabel("");

    HashMap<String, String> login4 = new HashMap<String, String>();

    Login(HashMap<String, String> logininfor) {
        // Set layout manager
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // User label
        userlabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(userlabel, gbc);

        // User text field
        user.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        frame.add(user, gbc);

        // Password label
        passLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(passLabel, gbc);

        // Password field
        pass.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        frame.add(pass, gbc);

        // Login button
        dangnhap.setPreferredSize(new Dimension(100, 30));
        dangnhap.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 2;
        frame.add(dangnhap, gbc);

        // Message label
        message.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 1;
        gbc.gridy = 3;
        frame.add(message, gbc);

        // Frame settings
        login4 = logininfor;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dangnhap) {
            String userid = user.getText();
            String passwords = String.valueOf(pass.getPassword());
            if (login4.containsKey(userid)) {
                if (login4.get(userid).equals("admin") && login4.get(userid).equals("admin")) {
                    message.setForeground(Color.GREEN);
                    message.setText("Dang nhap thanh cong");
                    Quanlysinhvien newpage = new Quanlysinhvien();
                    newpage.setVisible(true);
                    frame.setVisible(false);
                } else {
                    Dangkymon newpage = new Dangkymon();
                    newpage.setVisible(true);
                }
            } else {
                message.setForeground(Color.RED);
                message.setText("Sai ten dang nhap hoac mat khau");
            }
        }
    }
}

