package e3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
enum Estrategia {email,DNI,tlfno}
public class LoginScreen {
    String userIdentifier;
    String password;
    LoginStrategy logStr;
    Estrategia ejem;
    ArrayList<Users> usuarios = new ArrayList<>();
    static Map<String,String> mapaEmail2 = new HashMap<>();
    static Map<String,String> mapaMovil2 = new HashMap<>();
    static Map<String,String> mapaDNI2 = new HashMap<>();
    static Map<String,MfaStrategy> mapaEmailMfa = new HashMap<>();
    static Map<String,MfaStrategy> mapaMovilMfa = new HashMap<>();
    static Map<String,MfaStrategy> mapaDNIMfa = new HashMap<>();

    public static class Mapas {
        Map<String,String> mapaEmail = mapaEmail2;
        Map<String,String> mapaMovil = mapaMovil2;
        Map<String,String> mapaDNI = mapaDNI2;
    }

    public void anadirUsuario(Users persona){
        usuarios.add(persona);
        mapaEmail2.put(persona.email,persona.contrasena);
        mapaMovil2.put(persona.tlfno,persona.contrasena);
        mapaDNI2.put(persona.DNI,persona.contrasena);
        mapaEmailMfa.put(persona.email,persona.MfaFav);
        mapaMovilMfa.put(persona.tlfno,persona.MfaFav);
        mapaDNIMfa.put(persona.DNI,persona.MfaFav);
    }

    public LoginScreen(String userIdentifier, String password,Estrategia tegia){
        this.userIdentifier=userIdentifier;
        this.password=password;
        this.ejem=tegia;
        if(tegia == Estrategia.email) logStr = new Email();
        else if(tegia == Estrategia.DNI) logStr = new DNI();
        else if(tegia == Estrategia.tlfno) logStr = new Movil();
    }
    public void setUserIdentifier(String userIdentifier){
        this.userIdentifier=userIdentifier;
    }
    public void setPassword(String password){
        this.password=password;
    }

    public void setLoginStrategy(Estrategia estrat){
        if(estrat == Estrategia.email) logStr = new Email();
        else if(estrat == Estrategia.DNI) logStr = new DNI();
        else if(estrat == Estrategia.tlfno) logStr = new Movil();
        ejem=estrat;
    }

    public boolean checkID(){
        return logStr.validateId(userIdentifier);
    }
    public boolean checkPass() {
        if(checkID()) {
            return logStr.authenticatePassword(userIdentifier, password);
        }
        else return false;
    }
    public String generate(){
        if(checkPass()) {
            if (ejem == Estrategia.email) {
                return ((mapaEmailMfa.get(userIdentifier)).generateCode());
            } else if (ejem == Estrategia.DNI) {
                return ((mapaDNIMfa.get(userIdentifier)).generateCode());
            } else if (ejem == Estrategia.tlfno) {
                return ((mapaMovilMfa.get(userIdentifier)).generateCode());
            }
            else return "error";
        }
        else return "error";
    }
}
