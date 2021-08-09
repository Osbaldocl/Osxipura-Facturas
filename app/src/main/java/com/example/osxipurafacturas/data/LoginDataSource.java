package com.example.osxipurafacturas.data;

import com.example.osxipurafacturas.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

        /*
            Primero intentamos la conexión a al DB a traves de la API
         */
        try {
            // TODO: Intentar conexión a la API que checa la base de datos
        } catch (Exception e) {
            return new Result.Error(new IOException("Error: Hubo un error de conexión", e));
        }

        /*
            despúes revisamos la base de datos por las credenciales, si no, regresa error
         */
        try {
            // TODO: handle loggedInUser authentication

            if((username.equals("ocoronadordz") && password.equals("0sxip@ss")) || (username.equals("ocoronadolpz") && password.equals("admn0sx1P4ss")))
            {
                LoggedInUser user =
                        new LoggedInUser(
                                java.util.UUID.randomUUID().toString(),
                                username.toString());
                return new Result.Success<>(user);
            }

            return new Result.Error(new IOException("Usuario incorrecto"));

        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}