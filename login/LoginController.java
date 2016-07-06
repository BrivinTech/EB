package login;

import javafx.event.*;

import javafx.fxml.FXML;

import javafx.scene.control.*;

/** Controls the login screen */
public class LoginController
 {
    private static int sessionID = 0;
    @FXML
    private TextField user;
    @FXML
    private TextField password;
    @FXML
    private Button loginButton;
    @FXML
    private Button changePasswordButton;
    @FXML
    private Label loginStatus;

    /**
     * Check authorization credentials.
     *
     * If accepted, return a sessionID for the authorized session
     * otherwise, return null.
     */
    private boolean authorize(final String userName, final String userPassword)
     {
        return userName.equals(user.getText()) && userPassword.equals(password.getText());
    }

    public void initManager(final LoginManager loginManager, final String userName, final String userPassword)
     {
        loginButton.setOnAction(new EventHandler<ActionEvent>()
                                {
                                   @Override
                                   public void handle(ActionEvent event)
                                    {
                                       boolean isAuthendicated = authorize(userName, userPassword);

                                       if (isAuthendicated)
                                        {
                                           loginManager.authenticated();
                                       }
                                       else
                                        {
                                           loginStatus.setText("Username or Password is incorrect");
                                       }
                                   }
                               });
        
        changePasswordButton.setOnAction(new EventHandler<ActionEvent>()
                                         {
                                            @Override
                                            public void handle(ActionEvent event)
                                             {
                                                loginManager.changePassword();
                                            }
                                        });
    }

    public void initialize() {}

   
}


//~ Formatted by Jindent --- http://www.jindent.com
