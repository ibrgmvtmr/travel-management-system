import javax.swing.*;
import java.util.List;

public class Viewer {
    private Controller controller;
    private LoginWindow loginWindow;
    private SignupWindow signupWindow;
    private DashboardWindow dashboardWindow;
    private final Repository repository;
    private String userName;
    private String name;

    public Viewer() {
        repository = new Repository(this);
        controller = new Controller(this);
        initializeLoginWindow();
        initializeSignupWindow();
        System.out.println(repository);
    }


    public void initializeLoginWindow() {
        loginWindow = new LoginWindow("");
        loginWindow.setMouseListener(controller);
    }

    public void initializeSignupWindow() {
        signupWindow = new SignupWindow();
        signupWindow.setMouseListener(controller);
    }

    public void initializeDashboardWindow(String userName, String name) {
        dashboardWindow = new DashboardWindow(userName, name);
        dashboardWindow.setActionListenerMainButtons(controller);
    }

    public void initializeViewBookedHotelWindow() {
        dashboardWindow.initializeViewBookedHotels();
    }

    public JFrame getLoginFrame() {
        return loginWindow.getFrame();
    }

    public JFrame getSignupFrame() {
        return signupWindow.getFrame();
    }

    public JFrame getDashboardFrame() {
        return dashboardWindow.getDashboardFrame();
    }

    public String getSignupUserNameFieldText() {
        return signupWindow.getUserNameTextFieldText();
    }

    public String getSignupNameFieldText() {
        return signupWindow.getNameTextFieldText();
    }

    public String getSignupPasswordFieldText() {
        return signupWindow.getPasswordTextFieldText();
    }

    public String getAnswerTextFieldText() {
        return signupWindow.getAnswerTextFieldText();
    }

    public String getComboBoxChoice() {
        return signupWindow.getComboBoxChoice();
    }

    public String getLoginUsernameFieldText() {
        return loginWindow.getUsernameTextFieldText();
    }

    public String getLoginPasswordFieldText() {
        return loginWindow.getPasswordTextFieldText();
    }

    public String getTfEmailText() {
        return dashboardWindow.getTfEmailText();
    }

    public String getTfPhoneText() {
        return dashboardWindow.getTfPhoneText();
    }

    public String getTfCountryText() {
        return dashboardWindow.getTfCountryText();
    }

    public String getTfNumberText() {
        return dashboardWindow.getTfNumberText();
    }

    public String getIdComboBoxChoice() {
        return dashboardWindow.getIdComboBoxChoice();
    }

    public String getGenderComboBoxChoice() {
        return dashboardWindow.getGenderComboBoxChoice();
    }

    public void clearDashboardPanel() {
        dashboardWindow.clearDashboardPanel();
    }

    public String getSelectHotelText() {
        return dashboardWindow.getSelectHotelText();
    }

    public String getDaysAmountText() {
        return dashboardWindow.getDaysAmountText();
    }

    public String getTotalPerson() {
        return dashboardWindow.getTotalPerson();
    }

    public String getFoodIncludedText() {
        return dashboardWindow.getFoodIncludedText();
    }

    public void initializeDeletePersonalDetails() {
        dashboardWindow.initializeDeletePersonalDetails();
    }

    public void initializeBookHotelsWindow() {
        dashboardWindow.initializeBookHotels();
    }

    public void initializeAddPersonalDetails() {
        dashboardWindow.initializeAddPersonalDetails();
    }

    public void setUserName() {
        this.userName = loginWindow.getUsernameTextFieldText();
    }

    public void setUsernameDashBoard(String userName) {
        dashboardWindow.setUsername(userName);
    }

    public void setGender(String gender) {
        dashboardWindow.setGender(gender);
    }

    public void setId(String id) {
        dashboardWindow.setId(id);
    }

    public void setIdNumber(String idNumber) {
        dashboardWindow.setIdNumber(idNumber);
    }

    public void setCountry(String country) {
        dashboardWindow.setCountry(country);
    }

    public void setPhone(String phone) {
        dashboardWindow.setPhone(phone);
    }

    public void setEmail(String email) {
        dashboardWindow.setEmail(email);
    }

    public String getUserName() {
        return userName;
    }

    public void clearFields() {
        dashboardWindow.clearFields();
    }

    public void setActionListener(Controller controller) {
        dashboardWindow.setActionListener(controller);
    }

    public JPanel getDashboardPanel() {
        return dashboardWindow.getDashboardPanel();
    }

    public Controller getController() {
        return controller;
    }

    public void setHotels(List<String> hotels) {
        dashboardWindow.setHotels(hotels);
    }

    public Repository getRepository() {
        return repository;
    }
}
