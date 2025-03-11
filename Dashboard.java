package aswing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class Dashboard implements ActionListener {
    private JFrame frame;
    private User user;

    public Dashboard(User user) {
        this.user = user;

        frame = new JFrame("Dashboard");
        frame.setSize(600, 600);
        frame.setLayout(null);

        JLabel welcomeLabel = new JLabel("Welcome to Dashboard, " + user.getName() + "!");
        welcomeLabel.setBounds(150, 50, 300, 30);
        frame.add(welcomeLabel);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(250, 100, 100, 30);
        logoutButton.addActionListener(this);
        frame.add(logoutButton);
        JButton databasebutton = new JButton("Database");
        databasebutton.setBounds(350, 100, 100, 30);
        databasebutton.addActionListener(this);
        frame.add(databasebutton);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("Logout")) {
                frame.dispose();
                new Login();
            }else if(button.getText().equals("Database")){
                frame.dispose();
            EmployeeM ef=new EmployeeM();
            
            }
        }
    }
}

