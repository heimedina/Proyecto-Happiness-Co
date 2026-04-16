/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package happinessandco;

/**
 *
 * @author heidi
 */
public class Favorito {
    
    private String correoUsuario;
    private String idEvento;

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public String getIdEvento() {
        return idEvento;
    }

    @Override
    public String toString() {
        return "Favoritos{" + "correoUsuario=" + correoUsuario + ", idEvento=" + idEvento + '}';
    }
    
    
}
