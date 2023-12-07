import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DashboardWindow {
    private String username, name, gender, id, idNumber, country, phone, totalPrice, email;
    private JFrame dashboard;
    private JPanel dashboardPanel, dashboardPanel2;
    private JLabel lblUsername, lblName, lblGender, labelName, labelUsername, lblId, foodIncluded, lblTotalPrice, daysAmount, labelId, lblIdNumber, lblCountry, lblPhone, lblEmail, selectHotel;
    private JTextField tfNumber, tfCountry, tfPhone, tfEmail;
    private JComboBox<String> comboId, genderBox;
    private JButton update, addButton, clear, delete, checkPrice, bookHotel;
    private JTextField tfSelectHotel, tfDaysAmount;
    private List<JButton> mainButtons = new ArrayList<>();
    private List<JButton> buttons = new ArrayList<>();
    private List<String> hotels;
    private JComboBox<String> foodIncludedComboBox;
    private JComboBox<String> selectHotelComboBox;
    private JLabel totalPerson;
    private JTextField tfTotalPerson;


    public DashboardWindow(String username, String name) {
        hotels = new ArrayList<>();
        this.username = username;
        this.name = name;
        dashboard = new JFrame();
        dashboard.setSize(1235, 800);
        dashboard.setLayout(null);

        dashboardPanel = new JPanel();
        dashboardPanel.setLayout(null);
        dashboardPanel.setBounds(70, 45, 1150, 655);
        dashboard.add(dashboardPanel);

        dashboardPanel2 = new JPanel();
        dashboardPanel2.setLayout(null);
        dashboardPanel2.setBackground(new Color(96, 96, 96));
        dashboardPanel2.setBounds(0, 0, 70, 1000);
        dashboard.add(dashboardPanel2);

        JPanel dashboardPanel3 = new JPanel();
        dashboardPanel3.setLayout(null);
        dashboardPanel3.setBackground(new Color(96, 96, 96));
        dashboardPanel3.setBounds(70, 0, 1500, 45);
        dashboard.add(dashboardPanel3);

        JPanel dashboardPanel4 = new JPanel();
        dashboardPanel4.setLayout(null);
        dashboardPanel4.setBackground(new Color(96, 96, 96));
        dashboardPanel4.setBounds(70, 700, 1500, 45);
        dashboard.add(dashboardPanel4);

        ImageIcon personalInfoIcon = scaleImage("images/personal-information.png", 50, 50);
        JButton addPersonalDetails = createButton("Add personal details", 8, 45, 50, 50, 70, "Dashboard_AddPersonalDetails", personalInfoIcon);
//        JButton updatePersonalDetails = createButton("Update personal details", 0, 50, 300, 50, 50, "Dashboard_UpdatePersonalDetails");
//        JButton viewPersonalDetails = createButton("View personal details", 0, 100, 300, 50, 70, "Dashboard_ViewPersonalDetails");
        ImageIcon deletePersonalInfoIcon = scaleImage("images/delete.png", 50, 50);
        JButton deletePersonalDetails = createButton("Delete personal details", 8, 120, 300, 50, 70, "Dashboard_DeletePersonalDetails", deletePersonalInfoIcon);
//        JButton checkPackages = createButton("Check packages", 0, 200, 300, 50, 110, "Dashboard_CheckPackages");
//        JButton bookPackages = createButton("Book packages", 0, 250, 300, 50, 110, "Dashboard_bookPackages");
//        JButton viewPackages = createButton("View packages", 0, 300, 350, 50, 110, "Dashboard_viewPackages");
//        JButton viewHotels = createButton("View hotels", 0, 350, 300, 50, 150, "Dashboard_viewHotels");
        ImageIcon bookHotelIcon = scaleImage("images/2310064.png", 50, 50);
        JButton bookHotels = createButton("Book hotels", 8, 200, 300, 50, 70, "Dashboard_bookHotels", bookHotelIcon);
//        JButton viewBookedHotels = createButton("View booked hotels", -7, 450, 350, 50, 110, "Dashboard_viewBookedHotels");
//        JButton destinations = createButton("Destinations", 0, 500, 300, 50, 155, "Dashboard_Destinations");
//        JButton payment = createButton("Payment", 0, 550, 300, 50, 175, "Dashboard_Payment");
//        JButton calculator = createButton("Calculator", 0, 550, 300, 50, 175, "Dashboard_Calculator");
//        JButton about = createButton("About", 0, 600, 300, 40, 195, "Dashboard_About");
//        JButton logout = createButton("Logout", 1000, 15, 200, 45, 0, "Dashboard_Logout");

//        ImageIcon dashboardIcon = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
//        Image dashbordImage = dashboardIcon.getImage().getScaledInstance(1950, 1000,Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(dashbordImage);
//        JLabel NewLabel = new JLabel(i3);
//        NewLabel.setBounds(250, 50, 1150, 700);
//        dashboard.add(NewLabel);

//        JLabel showName = new JLabel("Welcome "+username+"");
//        showName.setBounds(600 , 15 , 500 , 35);
//        showName.setForeground(Color.white);
//        showName.setFont(new Font("Tahoma", Font.PLAIN, 35));
//        dashboardPanel.add(showName);

        dashboardPanel2.setBackground(new Color(0, 42, 48)); // #A67C00
        dashboardPanel3.setBackground(new Color(0, 42, 48)); // #A67C00
        dashboardPanel4.setBackground(new Color(0, 42, 48));

        initializeAddPersonalDetails();

        dashboard.setVisible(true);
    }

    public void initializeAddPersonalDetails() {
        lblUsername = createLabel("Username :", 50, 108, 300, 32);
        labelUsername = createLabel(username, 200, 108, 200, 32);

        lblId = createLabel("ID :", 50, 160, 300, 32);
        comboId = createComboBox(new String[]{"Aadhar Card", "Passport", "Driving Licence", "Others"}, 200, 160, 200, 32);

        createLabel("ID Number:", 50, 207, 300, 32);
        tfNumber = createTextField(200, 207, 200, 32);

        lblName = createLabel("Name :", 50, 259, 300, 32);
        labelName = createLabel(name, 200, 259, 200, 32);

        lblGender = createLabel("Gender :", 50, 311, 300, 32);
        genderBox = createComboBox(new String[]{"Male", "Female"}, 200, 311, 200, 32);

        createLabel("Country:", 50, 363, 300, 32);
        tfCountry = createTextField(200, 363, 200, 32);

        createLabel("Phone:", 50, 415, 300, 32);
        tfPhone = createTextField(200, 415, 200, 32);

        createLabel("Email:", 50, 467, 300, 32);
        tfEmail = createTextField(200, 467, 200, 32);

        addButton = createButton("Add", 50, 530, 100, 30);
        addButton.setActionCommand("AddPersonalDetails_Add");

        update = createButton("Update", 300, 530, 100, 30);
        update.setActionCommand("UpdatePersonalDetails_Update");

        clear = createButton("Clear", 175, 530, 100, 30);
        clear.setActionCommand("ClearPersonalDetails_Clear");

        ImagePanel newImagePanel = new ImagePanel("images/8917182.jpg");
        newImagePanel.setBounds(0, 0, 1150, 655);

        JLabel l1 = new JLabel("Add personal details");
        l1.setForeground(new Color(255, 178, 0));
        l1.setFont(new Font("Lobster", Font.PLAIN, 45));
        l1.setBounds(730, 20, 1000, 55);
        dashboardPanel.add(l1);

        dashboardPanel.add(newImagePanel);
    }

    public void initializeDeletePersonalDetails() {
        lblUsername = createLabel("Username :", 140, 100, 300, 32);
        labelUsername = createLabel(username, 300, 100, 260, 32);

        lblId = createLabel("ID :", 140, 150, 300, 32);
        labelId = createLabel(id, 300, 150, 200, 32);

        createLabel("ID Number:", 140, 200, 300, 32);
        lblIdNumber = createLabel(idNumber, 300,  200, 300, 32);

        createLabel("Country:", 140, 250, 300, 32);
        lblCountry = createLabel(country, 300, 250, 300, 32);

        lblName = createLabel("Name :", 620, 100, 300, 32);
        labelUsername = createLabel(name, 740, 100, 260, 32);

        createLabel("Phone :", 620, 150, 300, 32);
        lblPhone = createLabel(phone, 740, 150, 200, 32);

        createLabel("Email:", 620, 200, 300, 32);
        lblEmail = createLabel(email, 740, 200, 500, 28);

        createLabel("Gender:", 620, 250, 300, 32);
        lblGender = createLabel(gender, 740, 250, 300, 32);

        delete = createButton("Delete", 430, 350, 200, 40);
        delete.setFont(new Font("", Font.PLAIN, 18));
        delete.setActionCommand("DeleteInformation_DashBoard");

        JLabel l1 = new JLabel("Delete Personal Details");
        l1.setForeground(new Color(255, 178, 0));
        l1.setFont(new Font("Lobster", Font.PLAIN, 45));
        l1.setBounds(380, 20, 1000, 55);
        dashboardPanel.add(l1);

        ImagePanel newImagePanel = new ImagePanel("images/8917198.jpg");
        newImagePanel.setBounds(0, 0, 1150, 655);

        dashboardPanel.add(newImagePanel);
    }

    public void initializeBookHotels() {
        lblUsername = createLabel("Username :", 80, 80, 300, 32);
        labelUsername = createLabel(username, 310, 80, 260, 32);

        selectHotel = createLabel("Select Hotel :", 80, 130, 300, 32);
        String[] hotelsArray = hotels.toArray(new String[0]);
        selectHotelComboBox = createComboBox(hotelsArray, 310, 130, 200, 32);

        totalPerson = createLabel("Total Person :", 80, 180, 300, 32);
        tfTotalPerson = createTextField(310, 180, 200, 32);

        daysAmount = createLabel("Amount of days :", 80, 230, 300, 32);
        tfDaysAmount = createTextField(310, 230, 200, 32);

        foodIncluded = createLabel("Food Included :", 80, 280, 300, 32);
        foodIncludedComboBox = createComboBox(new String[]{"Yes", "No"}, 310, 280, 200, 32);

        lblId = createLabel("ID :", 80, 330, 300, 32);
        labelId = createLabel(id, 310, 330, 200, 32);

        createLabel("ID Number:", 80, 380, 300, 32);
        lblIdNumber = createLabel(idNumber, 310,  380, 300, 32);

        createLabel("Phone :", 80, 430, 300, 32);
        lblPhone = createLabel(phone, 310, 430, 200, 32);

        createLabel("Total Price :", 80, 480, 300, 32);
        lblTotalPrice = createLabel(totalPrice, 310, 480, 200, 32);

        checkPrice = createButton("Check Price", 80, 540, 180, 30);
        checkPrice.setActionCommand("CheckPrice_BookHotel");

        bookHotel = createButton("Book Hotel", 320, 540, 180, 30);
        bookHotel.setActionCommand("BookHotel_BookHotel");

        JLabel l1 = new JLabel("Book Hotel");
        l1.setForeground(new Color(255, 178, 0));
        l1.setFont(new Font("Lobster", Font.PLAIN, 45));
        l1.setBounds(900, 0, 1000, 55);
        dashboardPanel.add(l1);

        ImagePanel newImagePanel = new ImagePanel("images/8908580.jpg");
        newImagePanel.setBounds(0, 0, 1150, 655);

        dashboardPanel.add(newImagePanel);
    }

    private JButton createButton(String label, int x, int y, int width, int height) {
        JButton button = new JButton(label);
        button.setForeground(Color.white);
        button.setBackground(Color.black);
        button.setFocusable(false);
        button.setBounds(x, y, width, height);
        dashboardPanel.add(button);
        buttons.add(button);
        return button;
    }

    public void setActionListener(ActionListener actionListener) {
        for (JButton button : buttons) {
            button.addActionListener(actionListener);
        }
    }

    public void setActionListenerMainButtons(ActionListener actionListener) {
        for (JButton button : mainButtons) {
            button.addActionListener(actionListener);
        }
    }

    private JLabel createLabel(String text, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Abril Fatface", Font.PLAIN, 27));
        label.setBounds(x, y, width, height);
        dashboardPanel.add(label);
        return label;
    }

    private JTextField createTextField(int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        textField.setBackground(Color.white);
        textField.setFont(new Font("Abril Fatface", Font.PLAIN, 18));
        dashboardPanel.add(textField);
        return textField;
    }

    private JComboBox<String> createComboBox(String[] items, int x, int y, int width, int height) {
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setBounds(x, y, width, height);
        comboBox.setBackground(Color.white);
        comboBox.setFont(new Font("Abril Fatface", Font.PLAIN, 18));
        dashboardPanel.add(comboBox);
        return comboBox;
    }

    public JButton createButton(String label, int x, int y, int width, int height, int right, String actionCommand, ImageIcon icon) {
        JButton button = new JButton(label);
        button.setBounds(x, y, width, height);
        button.setFont(new Font("Tohoma", Font.PLAIN, 20));
        button.setMargin(new Insets(0, 0, 0, right));
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setLayout(new BorderLayout());
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setVerticalAlignment(SwingConstants.CENTER);
        button.setActionCommand(actionCommand);
        button.setIcon(icon);
        dashboardPanel2.add(button);
        mainButtons.add(button);
        return button;
    }

    public static ImageIcon scaleImage(String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }

    public void clearDashboardPanel() {
        dashboardPanel.removeAll();
        dashboardPanel.revalidate();
        dashboardPanel.repaint();
    }


    public JFrame getDashboardFrame() {
        return dashboard;
    }

    public String getTfEmailText() {
        return tfEmail.getText();
    }
    public String getTfPhoneText() {
        return tfPhone.getText();
    }

    public String getTfCountryText() {
        return tfCountry.getText();
    }

    public String getTfNumberText() {
        return tfNumber.getText();
    }

    public String getIdComboBoxChoice() {
        return Objects.requireNonNull(comboId.getSelectedItem()).toString();
    }

    public String getGenderComboBoxChoice() {
        return Objects.requireNonNull(genderBox.getSelectedItem()).toString();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public JPanel getDashboardPanel() {
        return dashboardPanel;
    }

    public String getSelectHotelText() {
        return (String) selectHotelComboBox.getSelectedItem();
    }

    public String getDaysAmountText() {
        return tfDaysAmount.getText();
    }

    public String getTotalPerson() {
        return tfTotalPerson.getText();
    }

    public String getFoodIncludedText() {
        return (String) foodIncludedComboBox.getSelectedItem();
    }

    public void clearFields() {
        tfNumber.setText("");
        tfCountry.setText("");
        tfPhone.setText("");
        tfEmail.setText("");
        comboId.setSelectedItem("");
        genderBox.setSelectedItem("");
    }

    public void setHotels(List<String> hotelNames) {
        hotels = hotelNames;
    }
}