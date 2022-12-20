package e3;
public class Movil extends LoginScreen.Mapas implements LoginStrategy{
    public boolean validateId (String id){
        if (id == null) {
            return false;
        }
        else if(id.length()==9) {
            try {
                Integer.parseInt(id);
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        }
        else return false;
    }

    @Override
    public boolean authenticatePassword(String id, String password) {
        if(mapaMovil.get(id)==null) return false;
        else return mapaMovil.get(id).equals(password);
    }
}
