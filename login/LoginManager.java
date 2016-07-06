package login;

import java.io.IOException;

import java.util.logging.*;

import javafx.fxml.FXMLLoader;

import javafx.scene.*;

/** Manages control flow for logins */
public class LoginManager
 {
    private String defaultUserName = "admin",
                   defaultPassword = "stack";
    private String secretKey       = "stack";
    private Scene scene;

    public LoginManager(Scene scene)
     {
        this.scene = scene;
    }

    /**
     * Callback method invoked to notify that a user has been authenticated.
     * Will show the main application screen.
     */
    public void authenticated()
     {
        showMainView();
    }

    /**
     * Callback method invoked to notify that a user has been authenticated.
     * Will show the main application screen.
     */
    public void changePassword()
     {
        showChangePassword();
    }

    /**
     * Callback method invoked to notify that a user has logged out of the main application.
     * Will show the login application screen.
     */
    public void logout()
     {
        showLoginScreen();
    }

    private void showChangePassword()
     {
        try
         {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("changepasswordview.fxml"));

            scene.setRoot((Parent) loader.load());

            ChangePasswordController controller = loader.<ChangePasswordController>getController();

            controller.initSessionID(this);
        }
        catch (IOException ex)
         {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showLoginScreen()
     {
        try
         {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));

            scene.setRoot((Parent) loader.load());

            LoginController controller = loader.<LoginController>getController();

            controller.initManager(this, getDefaultUserName(), getDefaultPassword());
        }
        catch (IOException ex)
         {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showMainView()
     {
        try
         {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mainview.fxml"));

            scene.setRoot((Parent) loader.load());

            MainViewController controller = loader.<MainViewController>getController();

            controller.initSessionID(this);
        }
        catch (IOException ex)
         {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Callback method invoked to notify that a user has been authenticated.
     * Will show the main application screen.
     */
    public void updatePassword(final String secretKeyArg, final String newPasswordArg)
     {
        if (secretKeyArg.equals(getSecretKey()))
         {
            this.setDefaultPassword(newPasswordArg);
        }

        showLoginScreen();
    }

    public String getDefaultPassword()
     {
        return this.defaultPassword;
    }

    public void setDefaultPassword(final String passwordArg)
     {
        this.defaultPassword = passwordArg;
    }

    public String getDefaultUserName()
     {
        return this.defaultUserName;
    }

    public void setDefaultUserName(final String userNameArg)
     {
        this.defaultUserName = userNameArg;
    }

    public String getSecretKey()
     {
        return this.secretKey;
    }

    public void setSecretKey(final String secretKeyArg)
     {
        this.secretKey = secretKeyArg;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
