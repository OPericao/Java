package e3;

import java.util.Random;
public class SMS implements MfaStrategy{

    public String generateCode(){
        Random rnum = new Random();
        int x = rnum.nextInt(1000000-100000)+100000;
        return Integer.toString(x);
    }
}
