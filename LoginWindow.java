import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class LoginWindow {
    private JFrame loginFrame;
    private List<JButton> buttons = new ArrayList<>();
    private  JPanel loginPanel;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    public LoginWindow(String userName) {
        loginFrame = new JFrame("Log in");
        loginFrame.setSize(900, 400);
        loginFrame.setLocation(220, 120);
        loginFrame.setLayout(null);

        JPanel canvas = new JPanel();
        canvas.setBackground(new Color(131, 193, 233));
        canvas.setBounds(0, 0, 450, 400);
        canvas.setLayout(null);
        loginFrame.add(canvas);

        ImageIcon loginIcon = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image loginImage = loginIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(loginImage);
        JLabel image = new JLabel(i3);
        image.setBounds(120, 85, 200, 200);
        canvas.add(image);

        loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBounds(450, 0, 450, 400);
        loginPanel.setBackground(Color.LIGHT_GRAY);
        loginFrame.add(loginPanel);

        JLabel userNameLabel = new JLabel("Username");
        userNameLabel.setBounds(60, 30, 100, 25);
        userNameLabel.setFont(new Font("SAN_SERIF", Font.PLAIN, 22));
        loginPanel.add(userNameLabel);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(60, 70, 300, 30);
        loginPanel.add(usernameTextField);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(60, 120, 100, 25);
        passwordLabel.setFont(new Font("SAN_SERIF", Font.PLAIN, 22));
        loginPanel.add(passwordLabel);

        passwordTextField = new JTextField();
        passwordTextField.setBounds(60, 160, 300, 30);
        passwordTextField.setBorder(BorderFactory.createEmptyBorder());
        loginPanel.add(passwordTextField);

        JButton loginButton = createButton("Log in", 60, 220, 120, 35, "LoginWindow_Button");
        JButton signupButton = createButton("Sign up", 240, 220, 120, 35, "SignupWindow_Button");
        JButton forgetButton = createButton("Forget", 150, 280, 120, 35, "ForgetWindow_Button");

        loginFrame.setVisible(true);
    }

    public JButton createButton(String label, int x, int y, int width, int height, String actionCommand) {
        JButton button = new JButton(label);
        button.setBounds(x, y, width, height);
        button.setBackground(new Color(133, 193, 233));
        button.setForeground(Color.BLACK);
        button.setBorder(new LineBorder(Color.black));
        button.setActionCommand(actionCommand);
        button.setFocusable(false);
        buttons.add(button);
        loginPanel.add(button);
        return button;
    }

    public void setMouseListener(ActionListener actionListener) {
        for (JButton button : buttons) {
            button.addActionListener(actionListener);
        }
    }

    public JFrame getFrame() {
        return loginFrame;
    }

    public String getUsernameTextFieldText() {
        return usernameTextField.getText();
    }

    public String getPasswordTextFieldText() {
        return passwordTextField.getText();
    }
}
