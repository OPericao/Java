package e3;
public class Email extends LoginScreen.Mapas implements LoginStrategy{
    public boolean validateId (String id){
        return (id.contains("@")&&(id.contains(".")));
    }
    public boolean authenticatePassword(String id, String password) {
        if(mapaEmail.get(id)==null) return false;
        else return mapaEmail.get(id).equals(password);
    }

}
