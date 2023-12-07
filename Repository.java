import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class Repository {
    private final Viewer viewer;
    private final DatabaseConnector databaseConnector;
    private int accountId;

    public Repository(Viewer viewer) {
        this.viewer = viewer;
        databaseConnector = new DatabaseConnector();
    }

    public void createAccount() {
        String username = viewer.getSignupUserNameFieldText();
        String name = viewer.getSignupNameFieldText();
        String password = viewer.getSignupPasswordFieldText();
        String question = viewer.getComboBoxChoice();
        String answer = viewer.getAnswerTextFieldText();

        try {

            String query = "INSERT INTO account (username, name, password, security, answer) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = databaseConnector.connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, password);
                preparedStatement.setString(4, question);
                preparedStatement.setString(5, answer);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {

                    ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        int accountId = generatedKeys.getInt(1);
                    }
                    System.out.println(accountId);
                    JOptionPane.showMessageDialog(null, "Account Created Successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to create the account");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addCustomer() {
        String userName = viewer.getUserName();
        String email = viewer.getTfEmailText();
        String phone = viewer.getTfPhoneText();
        String country = viewer.getTfCountryText();
        String id = viewer.getIdComboBoxChoice();
        String idNumber = viewer.getTfNumberText();
        String gender = viewer.getGenderComboBoxChoice();

        try {
            String getAccountIdQuery = "SELECT account_id FROM Account WHERE username = ?";
            try (PreparedStatement accountIdStatement = databaseConnector.connection.prepareStatement(getAccountIdQuery)) {
                accountIdStatement.setString(1, userName);
                ResultSet accountIdResultSet = accountIdStatement.executeQuery();

                if (accountIdResultSet.next()) {
                    int accountId = accountIdResultSet.getInt("account_id");

                    String insertCustomerQuery = "INSERT INTO Customer (customer_id, username, id, id_number, gender, country, number, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement preparedStatement = databaseConnector.connection.prepareStatement(insertCustomerQuery)) {
                        preparedStatement.setInt(1, accountId);
                        preparedStatement.setString(2, userName);
                        preparedStatement.setString(3, id);
                        preparedStatement.setString(4, idNumber);
                        preparedStatement.setString(5, gender);
                        preparedStatement.setString(6, country);
                        preparedStatement.setString(7, phone);
                        preparedStatement.setString(8, email);

                        int rowsAffected = preparedStatement.executeUpdate();

                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Information saved Successfully");
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to save the customer");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to retrieve account_id for username: " + userName);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void updateAccount() {
        String email = viewer.getTfEmailText();
        String phone = viewer.getTfPhoneText();
        String country = viewer.getTfCountryText();
        String id = viewer.getIdComboBoxChoice();
        String idNumber = viewer.getTfNumberText();
        String gender = viewer.getGenderComboBoxChoice();

        try {
            StringBuilder queryBuilder = new StringBuilder("UPDATE customer SET ");
            List<String> columnsToUpdate = new ArrayList<>();
            if (!id.isEmpty()) columnsToUpdate.add("id = ?");
            if (!idNumber.isEmpty()) columnsToUpdate.add("id_number = ?");
            if (!gender.isEmpty()) columnsToUpdate.add("gender = ?");
            if (!country.isEmpty()) columnsToUpdate.add("country = ?");
            if (!phone.isEmpty()) columnsToUpdate.add("number = ?");
            if (!email.isEmpty()) columnsToUpdate.add("email = ?");

            queryBuilder.append(String.join(", ", columnsToUpdate));

            queryBuilder.append(" WHERE username = ?");

            try (PreparedStatement preparedStatement = databaseConnector.connection.prepareStatement(queryBuilder.toString())) {
                int parameterIndex = 1;
                if (!id.isEmpty()) preparedStatement.setString(parameterIndex++, id);
                if (!idNumber.isEmpty()) preparedStatement.setString(parameterIndex++, idNumber);
                if (!gender.isEmpty()) preparedStatement.setString(parameterIndex++, gender);
                if (!country.isEmpty()) preparedStatement.setString(parameterIndex++, country);
                if (!phone.isEmpty()) preparedStatement.setString(parameterIndex++, phone);
                if (!email.isEmpty()) preparedStatement.setString(parameterIndex++, email);

                preparedStatement.setString(parameterIndex, viewer.getLoginUsernameFieldText());

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    if (!email.isEmpty()) {
                        viewer.setEmail(email);
                    }
                    if (!id.isEmpty()) {
                        viewer.setId(id);
                    }
                    if (!idNumber.isEmpty()) {
                        viewer.setIdNumber(idNumber);
                    }
                    if (!gender.isEmpty()) {
                        viewer.setGender(gender);
                    }
                    if (!country.isEmpty()) {
                        viewer.setCountry(country);
                    }
                    if (!phone.isEmpty()) {
                        viewer.setPhone(phone);
                    }
                    if (email.isEmpty()) {
                        viewer.setEmail(email);
                    }
                    JOptionPane.showMessageDialog(null, "Account Updated Successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to update the account");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void getAccount() {
        String username = viewer.getLoginUsernameFieldText();
        String password = viewer.getLoginPasswordFieldText();

        try {
            String query = "SELECT * FROM account WHERE username = ? AND password = ?";

            try (PreparedStatement preparedStatement = databaseConnector.connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                ResultSet rs = preparedStatement.executeQuery();

                if (rs.next()) {
                    String userName = rs.getString("username");
                    String name = rs.getString("name");
                    viewer.getLoginFrame().setVisible(false);
                    viewer.initializeDashboardWindow(userName, name);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getCustomer() {
        String username = viewer.getLoginUsernameFieldText();

        try {
            String query = "SELECT * FROM customer WHERE username = ?";

            try (PreparedStatement preparedStatement = databaseConnector.connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);

                ResultSet rs = preparedStatement.executeQuery();

                if (rs.next()) {
                    String customerUsername = rs.getString("username"); // No need for alias here
                    String id = rs.getString("id");
                    String idNumber = rs.getString("id_number");
                    String gender = rs.getString("gender");
                    String country = rs.getString("country");
                    String phone = rs.getString("number");
                    String email = rs.getString("email");

                    viewer.setUsernameDashBoard(customerUsername);
                    viewer.setId(id);
                    viewer.setIdNumber(idNumber);
                    viewer.setGender(gender);
                    viewer.setCountry(country);
                    viewer.setPhone(phone);
                    viewer.setEmail(email);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteCustomer() {
        String username = viewer.getLoginUsernameFieldText();

        try {
            String checkCustomerQuery = "SELECT * FROM customer WHERE username = ?";
            try (PreparedStatement checkStatement = databaseConnector.connection.prepareStatement(checkCustomerQuery)) {
                checkStatement.setString(1, username);

                ResultSet checkResultSet = checkStatement.executeQuery();

                if (!checkResultSet.next()) {
                    JOptionPane.showMessageDialog(null, "Customer with username: " + username + " not found");
                    return;
                }
            }

            String deleteCustomerQuery = "DELETE FROM customer WHERE username = ?";
            try (PreparedStatement preparedStatement = databaseConnector.connection.prepareStatement(deleteCustomerQuery)) {
                preparedStatement.setString(1, username);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Information Deleted Successfully");

                    viewer.setId("");
                    viewer.setIdNumber("");
                    viewer.setGender("");
                    viewer.setCountry("");
                    viewer.setPhone("");
                    viewer.setEmail("");
                    viewer.clearDashboardPanel();
                    viewer.initializeDeletePersonalDetails();
                    viewer.setActionListener(viewer.getController());
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to delete the information");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public List<String> getAllHotelNames() {
        List<String> hotelNames = new ArrayList<>();

        try {
            String query = "SELECT hotel_name FROM Hotels";

            try (PreparedStatement preparedStatement = databaseConnector.connection.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String hotelName = resultSet.getString("hotel_name");
                    hotelNames.add(hotelName);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return hotelNames;
    }

    public String getId(String username) {
        try {
            String query = "SELECT id FROM Customer WHERE username = ?";
            try (PreparedStatement preparedStatement = databaseConnector.connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    return resultSet.getString("id");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public String getIdNumber(String username) {
        try {
            String query = "SELECT id_number FROM Customer WHERE username = ?";
            try (PreparedStatement preparedStatement = databaseConnector.connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    return resultSet.getString("id_number");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public String getPhoneNumber(String username) {
        try {
            String query = "SELECT number FROM Customer WHERE username = ?";
            try (PreparedStatement preparedStatement = databaseConnector.connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    return resultSet.getString("number");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
