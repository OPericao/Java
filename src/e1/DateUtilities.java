package e1;

public class DateUtilities {
    public static boolean isLeap(int year){
        if (year == 0)
            throw new IllegalArgumentException();
        if (year % 4 == 0) //Si el ano es divisble entre 4 devuelve true,
            if (year % 100 == 0) //a no ser que sea divisible entre 100, en cuyo caso solo devolvera true si tambien
                return year % 400 == 0; //es divisible entre 400
            else return true;
        else return false;
    }

    public static int numberOfDays(int month , int year){
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                if(!isLeap(year))
                {
                    return 28;
                } else return 29;
            default: throw new IllegalArgumentException ("Error");
        }
    }

    public static String convertToISODate (String dateText)
    {
        String[] partes = dateText.split("[ ,]+");
        return switch (partes[0]) {
            case "January" -> (partes[2] + "-01-" + partes[1]);
            case "February" -> (partes[2] + "-02-" + partes[1]);
            case "March" -> (partes[2] + "-03-" + partes[1]);
            case "April" -> (partes[2] + "-04-" + partes[1]);
            case "May" -> (partes[2] + "-05-" + partes[1]);
            case "June" -> (partes[2] + "-06-" + partes[1]);
            case "July" -> (partes[2] + "-07-" + partes[1]);
            case "August" -> (partes[2] + "-08-" + partes[1]);
            case "September" -> (partes[2] + "-09-" + partes[1]);
            case "October" -> (partes[2] + "-10-" + partes[1]);
            case "November" -> (partes[2] + "-11-" + partes[1]);
            case "December" -> (partes[2] + "-12-" + partes[1]);
            default -> throw new IllegalArgumentException("Error");
        };
    }

    public static boolean isNumeric(String strNum) { //Metodo auxiliar utilizado en checkISODate para comprobar
        if (strNum == null) { //si una cadena esta compuesta solo por cifras
            return false;
        }
        try {
            Integer.parseInt(strNum);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean checkISODate (String ISODate){
        String[] partes = ISODate.split("-");
        if((partes[0].length()>4)||(partes[1].length()>2)||(partes[2].length()>2)) return false; //Comprobacion para
        //evitar longitudes erroneas
        else {
            if (isNumeric(partes[0])&&isNumeric(partes[1])&&isNumeric(partes[2])) { // Comprobacion para evitar cadenas
                //no numericas
                int ano = Integer.parseInt(partes[0]);
                int mes = Integer.parseInt(partes[1]);
                int dia = Integer.parseInt(partes[2]);
                if ((mes > 12) || (mes < 0)) return false; //Comprobaciones de la validez de la fecha
                else return ((numberOfDays(mes, ano)) >= dia) && dia >= 0; ////Comprobaciones de la validez de la fecha
            }
            else return false;
            }
        }
    }
