package e3;

import java.util.Random;
public class App implements MfaStrategy{

    public String generateCode(){
        Random rnum = new Random();
        int x = rnum.nextInt(91-48)+48;
        if (x>=58 && x<=64) x=x+7;
        char a = (char) x;
        int y = rnum.nextInt(91-48)+48;
        if (y>=58 && y<=64) y=y+7;
        char b = (char) y;
        int z = rnum.nextInt(91-48)+48;
        if (z>=58 && z<=64) z=z+7;
        char c = (char) z;
        int w = rnum.nextInt(91-48)+48;
        if (w>=58 && w<=64) w=w+7;
        char d = (char) w;
        int v = rnum.nextInt(91-48)+48;
        if (v>=58 && v<=64) v=v+7;
        char e = (char) v;
        return ("" + a + b + c + d + e);
    }
}
