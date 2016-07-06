package login;

import javafx.event.*;

import javafx.fxml.FXML;

import javafx.scene.control.*;

/** Controls the main application screen */
public class ChangePasswordController
 {
    @FXML
    private TextField secretKey;
    @FXML
    private TextField newPassword;
    @FXML
    private Button changePassWord;

    public void initSessionID(final LoginManager loginManager)
     {
        changePassWord.setOnAction(new EventHandler<ActionEvent>()
            {
               @Override
               public void handle(ActionEvent event)
                {
                    System.out.println("secretKey " + secretKey);
                   loginManager.updatePassword(secretKey.getText(), newPassword.getText());
               }
           });
    }

    public void initialize() {}
}

