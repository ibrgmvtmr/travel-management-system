public class Model {
    private final Viewer viewer;

    private final Repository repository;

    public Model(Viewer viewer) {
        this.viewer = viewer;
        this.repository = viewer.getRepository();
        System.out.println(viewer.getRepository());
    }

    public void initializeWindows(String command) {
        if (command.equals("SignupWindow_Button")) {
            viewer.getLoginFrame().setVisible(false);
            viewer.getSignupFrame().setVisible(true);
        } else if (command.equals("LoginWindow_Button")) {
            viewer.setUserName();
            repository.getAccount();
        } else if (command.equals("AddPersonalDetails_Add")) {
            repository.addCustomer();
        } else if (command.equals("UpdatePersonalDetails_Update")) {
            repository.updateAccount();
        } else if (command.equals("DeleteInformation_DashBoard")) {
            repository.deleteCustomer();
        } else if (command.equals("SignupWindow_Create")) {
            repository.createAccount();
        } else if (command.equals("SignupWindow_Back")) {
            viewer.getLoginFrame().setVisible(true);
            viewer.getSignupFrame().setVisible(false);
        } else if (command.equals("Dashboard_DeletePersonalDetails")) {
            viewer.clearDashboardPanel();
            viewer.initializeDeletePersonalDetails();
            viewer.setActionListener(viewer.getController());
            viewer.getDashboardFrame().repaint();
            repository.getCustomer();
        } else if (command.equals("Dashboard_AddPersonalDetails")) {
            viewer.clearDashboardPanel();
            viewer.initializeAddPersonalDetails();
            viewer.setActionListener(viewer.getController());
            viewer.getDashboardFrame().repaint();
        } else if (command.equals("ClearPersonalDetails_Clear")) {
            viewer.clearFields();
        } else if (command.equals("Dashboard_bookHotels")) {
            viewer.clearDashboardPanel();
            viewer.initializeBookHotelsWindow();
            viewer.setActionListener(viewer.getController());
            viewer.getDashboardFrame().repaint();
            viewer.setHotels(repository.getAllHotelNames());
            viewer.setUserName();
            viewer.setPhone(repository.getPhoneNumber(viewer.getUserName()));
            viewer.setId(repository.getId(viewer.getUserName()));
            viewer.setIdNumber(repository.getIdNumber(viewer.getUserName()));
        } else if (command.equals("CheckPrice_BookHotel")) {

        }
    }

//    public int calculateBookCost(int cost, int days, int personAmount, boolean isFoodIncluded) {
//
//    }
}

