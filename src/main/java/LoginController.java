import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class LoginController {

    private ArrayList<User> users = new ArrayList<>();

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label messageLabel;

    @FXML
    public void handleLogin() {

        String username = usernameField.getText();
        String password = passwordField.getText();

        boolean found = false;

        for (User user : users) {

            if (user.getName().equals(username)
                    && user.getPassword().equals(password)) {

                found = true;
                break;
            }
        }

        if (found) {

            messageLabel.setText("Welcome");

        } else {

            messageLabel.setText("Wrong username or password");
        }
    }
}