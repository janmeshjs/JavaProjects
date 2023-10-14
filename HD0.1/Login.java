import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Login implements ActionListener {
    private static JFrame frame;
    private static JLabel label;
    private static JTextField username;
    private static JButton loginButton;
    private static JButton registerButton;
    private static JButton exitButton;
    private static JPasswordField password;

    public Login() {
        frame = new JFrame("LOGIN PAGE");
        frame.setSize(450, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setLocation(
            (Toolkit.getDefaultToolkit().getScreenSize().width - frame.getWidth()) / 2,
            (Toolkit.getDefaultToolkit().getScreenSize().height - frame.getHeight()) / 2
        );
        frame.setUndecorated(true);

        
        JLabel headingLabel = new JLabel("Login Account");
        headingLabel.setBounds(60, 20, 380, 60); 
        headingLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 55));
        headingLabel.setForeground(new Color(128, 0, 128)); // Purple color
        frame.add(headingLabel);

        
        label = new JLabel("Username");
        label.setBounds(130, 105, 70, 20);
        frame.add(label);

        username = new JTextField();
        username.setBounds(130, 140, 193, 28);
        frame.add(username);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(130, 190, 70, 20);
        frame.add(passwordLabel);

        password = new JPasswordField();
        password.setBounds(130, 225, 193, 28);
        frame.add(password);

        loginButton = new JButton("Login");
        loginButton.setBounds(130, 300, 80, 25);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(Color.BLACK);
        loginButton.addActionListener(this);
        frame.add(loginButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(230, 300, 80, 25);
        exitButton.setForeground(Color.WHITE);
        exitButton.setBackground(Color.RED);
        exitButton.addActionListener(e -> System.exit(0));
        frame.add(exitButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(180, 340, 100, 25);
        registerButton.setForeground(Color.WHITE);
        registerButton.setBackground(new Color(0, 128, 0)); //Dark green
        registerButton.addActionListener(this);
        frame.add(registerButton);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String Username = username.getText();
            String Password1 = new String(password.getPassword());

            if (Username.equals("HD1.0") && Password1.equals("123")) {
                JOptionPane.showMessageDialog(null, "Login Successful");
                frame.dispose();
                new BookStore();
            } else {
                JOptionPane.showMessageDialog(null, "Username or Password mismatch");
            }
        } else if (e.getSource() == registerButton) {
            frame.dispose(); // Close the login frame
            new Register(); // Open the registration page
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Login();
        });
    }
}

 