package e3;

enum Mfa {SMS,Correo,App}
public class Users {
    MfaStrategy MfaFav;
    String email,DNI,tlfno,contrasena;
    public Users(String email, String DNI, String tlfno, String contrasena,Mfa Fav) {
        this.email = email;
        this.DNI = DNI;
        this.tlfno = tlfno;
        this.contrasena = contrasena;
        if(Fav == Mfa.SMS) MfaFav=new SMS();
        else if(Fav == Mfa.Correo) MfaFav=new Correo();
        else if(Fav == Mfa.App) MfaFav=new App();
    }
    public void setMfaFav(Mfa mfa){
        if(mfa==Mfa.SMS) MfaFav = new SMS();
        else if(mfa==Mfa.Correo) MfaFav = new Correo();
        else if(mfa==Mfa.App) MfaFav = new App();
    }

}
