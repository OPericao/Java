package e3;

import java.util.Random;
public class Correo implements MfaStrategy{

    public String generateCode(){
        Random rnum = new Random();
        int y = rnum.nextInt(25);
        char a = (char) (y+65);
        int z = rnum.nextInt(25);
        char b = (char) (z+65);
        int x = rnum.nextInt(25);
        char c = (char) (x+65);
        int w = rnum.nextInt(25);
        char d = (char) (w+65);
        return ("" + a + b + c + d);
    }
}
