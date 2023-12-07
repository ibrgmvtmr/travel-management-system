import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Color.blue;

public class SignupWindow {

    private JFrame signupFrame;
    private JPanel signupPanel;
    private List<JButton> buttons = new ArrayList<>();

    private JTextField userNameTextField;
    private JTextField nameTextField;
    private JTextField passwordTextField;
    private JTextField answerTextField;
    private JComboBox comboBox;

    public SignupWindow() {
        signupFrame = new JFrame("Sign up");
        signupFrame.setBounds(330, 150, 720, 406);

        signupPanel = new JPanel();
        signupFrame.setContentPane(signupPanel);
        signupFrame.setBackground(Color.WHITE);
        signupPanel.setLayout(null);

        JLabel usernameLabel = createLabel("Username :", 100, 86, 90, 26);
        userNameTextField = createTextField(265, 91, 148, 20);

        JLabel nameLabel = createLabel("Name :", 100, 123, 90, 26);
        nameTextField = createTextField(265, 128, 148, 20);

        JLabel passwordLabel = createLabel("Password :", 100, 160, 90, 26);
        passwordTextField = createTextField(265, 165, 148, 20);

        JLabel answerLabel = createLabel("Answer: ", 100, 234, 90, 26);
        answerTextField = createTextField(265, 239, 148, 20);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"Your NickName?", "Your Lucky Number?",
                "Your child SuperHero?", "Your childhood Name ?"}));
        comboBox.setBounds(265, 202, 148, 20);
        signupPanel.add(comboBox);

        JLabel lblSecurityQuestion = createLabel("Security Question :", 99, 197, 140, 26);

        JButton create = createButton("Create", 140, 289, 100, 30, "SignupWindow_Create");
        JButton back = createButton("Back", 300, 289, 100, 30, "SignupWindow_Back");

        ImageIcon signupIcon = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image signupWindow = signupIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(signupWindow);
        JLabel l6 = new JLabel(i2);
        l6.setBounds(460, 70, 200, 200);
        signupFrame.add(l6);

        JPanel panel = new JPanel();
        panel.setForeground(new Color(34, 139, 34));
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Create-Account",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
        panel.setBounds(31, 30, 640, 310);
        panel.setBackground(Color.WHITE);
        signupPanel.add(panel);

        signupFrame.setVisible(false);
    }

    public JLabel createLabel(String labelText, int x, int y, int width, int height) {
        JLabel label = new JLabel(labelText);
        label.setForeground(Color.DARK_GRAY);
        label.setFont(new Font("Tahoma", Font.BOLD, 14));
        label.setBounds(x, y, width, height);
        signupFrame.add(label);
        return label;
    }

    public JTextField createTextField(int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        textField.setBorder(BorderFactory.createLineBorder(blue));
        signupFrame.add(textField);
        return textField;
    }

    public JButton createButton(String label, int x, int y, int width, int height, String actionCommand) {
        JButton button = new JButton(label);
        button.setBounds(x, y, width, height);
        button.setFont(new Font("Tahoma", Font.BOLD, 13));
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setBorder(new LineBorder(Color.black));
        button.setActionCommand(actionCommand);
        button.setFocusable(false);
        buttons.add(button);
        signupPanel.add(button);
        return button;
    }

    public void setMouseListener(ActionListener actionListener) {
        for (JButton button : buttons) {
            button.addActionListener(actionListener);
        }
    }

    public JFrame getFrame() {
        return signupFrame;
    }

    public String getUserNameTextFieldText() {
        return userNameTextField.getText();
    }

    public String getNameTextFieldText() {
        return nameTextField.getText();
    }

    public String getPasswordTextFieldText() {
        return passwordTextField.getText();
    }

    public String getAnswerTextFieldText() {
        return answerTextField.getText();
    }

    public String getComboBoxChoice() {
        return (String) comboBox.getSelectedItem();
    }
}
