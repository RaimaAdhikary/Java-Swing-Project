package aswing;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

class Login implements ActionListener {
    private JFrame frame;
    private JTextField emailField;
    private JPasswordField passwordField;

    public Login() {
        frame = new JFrame("Login");
        frame.setSize(600, 600);
        frame.setLayout(null);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 50, 100, 30);
        frame.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(150, 50, 200, 30);
        frame.add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 100, 30);
        frame.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 200, 30);
        frame.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(200, 150, 100, 30);
        loginButton.addActionListener(this);
        frame.add(loginButton);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(200, 200, 100, 30);
        registerButton.addActionListener(this);
        frame.add(registerButton);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("Login")) {
                login();
            } else if (button.getText().equals("Register")) {
                frame.dispose();
                new Registration();
            }
        }
    }

    private void login() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        User user = null;

        try {
            File file = new File("userdata.txt");
            if (!file.exists()) {
                JOptionPane.showMessageDialog(frame, "No user registered yet!");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            boolean loggedIn = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[1].equals(email) && parts[2].equals(password)) {
                    loggedIn = true;
                    user = new User(parts[0], parts[1], parts[2], parts[3]);
                    break;
                }
            }
            reader.close();

            if (loggedIn) {
                JOptionPane.showMessageDialog(frame, "Login Successful!");
                frame.dispose();
                new Dashboard(user);
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid email or password!");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

