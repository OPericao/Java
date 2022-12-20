package e3;
public class DNI extends LoginScreen.Mapas implements LoginStrategy{
    public boolean validateId (String id){
        boolean check=true;
        if((id.charAt(id.length()-1)<=65 || id.charAt(id.length()-1)>=90)) {
            check = false;
        }
        else{
            for(int i=0;i<id.length()-2;i++){
                if (id.charAt(i) < '0' || id.charAt(i) > '9') {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }

    public boolean authenticatePassword(String id, String password) {
        if(mapaDNI.get(id)==null) return false;
        else return mapaDNI.get(id).equals(password);
    }
}
