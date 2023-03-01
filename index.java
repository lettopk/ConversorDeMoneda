import javax.swing.JOptionPane;

public class index {

    private static String moneda1 = "COP a Dolar";
    private static String moneda2 = "COP a Euro";
    private static String moneda3 = "COP a Libras Esterlinas";
    private static String moneda4 = "COP a Yen Japonés";
    private static String moneda5 = "COP a Won Sul-Coreano";
    private static String moneda6 = "Dolar a COP";
    private static String moneda7 = "Euro a COP";
    private static String moneda8 = "Libras Esterlinas a COP";
    private static String moneda9 = "Yen Japonés a COP";
    private static String moneda10 = "Won Sul-Coreano a COP";
    
    private final static String[] UNIDADES = { "cero", "un ", "dos ", "tres ", "cuatro ", "cinco ", "seis ", "siete ", "ocho ",
            "nueve " };
    
    private final static String[] ESPECIALES = { "diez ", "once ", "doce ", "trece ", "catorce ", "quince ",
            "dieciseis ", "diecisiete ", "dieciocho ", "diecinueve " };
    private final static String[] DECENAS = { "","", "veinti ", "treinta ", "cuarenta ",
            "cincuenta ", "sesenta ", "setenta ", "ochenta ", "noventa " };
    private final static String[] CENTENAS = { "", "ciento ", "doscientos ", "trecientos ", "cuatrocientos ", "quinientos ",
            "seiscientos ",
            "setecientos ", "ochocientos ", "novecientos " };

    public static void main(String[] args) {
        String aConvertir = (JOptionPane.showInputDialog(null, "Selecciona la opcion de conversión", "Conversor",
                JOptionPane.PLAIN_MESSAGE, null,
                new Object[] { "Selecciona", "Conversor de moneda", "Conversor de temperatura","Conversor de numeros a letras" },
                "Selecciona")).toString();

        if (aConvertir == "Conversor de moneda") {
            String moneda = (JOptionPane.showInputDialog(null, "Selecciona la moneda a cambiar", "Conversor de moneda",
                    JOptionPane.PLAIN_MESSAGE, null,
                    new Object[] {
                         "Selecciona", moneda1 , moneda2, moneda3,moneda4, moneda5,
                         moneda6, moneda7, moneda8, moneda9,moneda10
                         }, "Selecciona"))
                    .toString();

            valorConvertir(moneda, aConvertir);

        } else if (aConvertir == "Conversor de temperatura") {

            String escalaTemperatura = (JOptionPane.showInputDialog(null, "Selecciona la escala", "Conversor de Temperatura",
                    JOptionPane.PLAIN_MESSAGE, null,
                    new Object[] { "Selecciona", "Celsius a Fahrenheit", "Celsius a Kelvin", "Fahrenheit a Kelvin",
                            "Fahrenheit a Celsius","Kelvin a Celsius","Kelvin a Fahrenheit" },
                    "Selecciona"))
                    .toString();

            valorConvertir(escalaTemperatura, aConvertir);

        } else if (aConvertir == "Conversor de numeros a letras") {

            valorConvertir(aConvertir, aConvertir);
            
        }
    }
    
    public static void valorConvertir(String seleccion, String  tipoConversion) {

        double valor = Integer.parseInt(JOptionPane.showInputDialog(null, "introduce el valor a convertir", seleccion,
                JOptionPane.PLAIN_MESSAGE));
        if (tipoConversion == "Conversor de moneda"){
            switch (seleccion) {
                case "COP a Dolar":
                    convertirCOP(valor, 4809);
                    break;
                case "COP Euro":
                    convertirCOP(valor, 5099);
                    break;
                case "COP a Libras Esterlinas":
                    convertirCOP(valor, 5785.68);
                    break;
                case "COP a Yen Japonés":
                    convertirCOP(valor, 35.37);
                    break;
                case "COP a Won Sul-Coreano":
                    convertirCOP(valor, 3.65);
                    break;
                case "Dolar a COP":
                    convertirACOP(valor, 4809);
                    break;
                case "Euro a COP":
                    convertirACOP(valor, 5099);
                    break;
                case "Libras Esterlinas a COP":
                    convertirACOP(valor, 5785.68);
                    break;
                case "Yen Japonés a COP":
                    convertirACOP(valor, 35.37);
                    break;
                case "Won Sul-Coreano a COP":
                    convertirACOP(valor, 3.65);
                    break;
            }
            
        } else if (tipoConversion == "Conversor de temperatura") {
            switch (seleccion) {
                case "Celsius a Fahrenheit":
                    double conversionCF = ((valor * (9/5))+ 32);
                    mostrarConversion(conversionCF);
                    break;
                case "Celsius a Kelvin":
                    double conversionCK = valor + 273;
                    mostrarConversion(conversionCK);
                    break;
                case "Fahrenheit a Kelvin":
                    double conversionFK = 5/9*(valor+459.67);
                    mostrarConversion(conversionFK);
                    break;
                case "Fahrenheit a Celsius":
                    double conversionFC = 5/9*(valor-32);
                    mostrarConversion(conversionFC);
                    break;
                case "Kelvin a Celsius":
                    double conversionKC = valor -273.15;
                    mostrarConversion(conversionKC);
                    break;
                case "Kelvin a Fahrenheit":
                    double conversionKF = 9 / (5 * valor) - 459.67;
                    mostrarConversion(conversionKF);
                    break;
            }
        } else if (tipoConversion == "Conversor de numeros a letras") {
            
            String literal = "";
            
            if (valor < 10) {
                literal = getUnidades((int) valor);
                mostrarlieral(literal);
            } else if (valor < 20) {
                literal = getEspeciales((int) valor);
                mostrarlieral(literal);
            }else if (valor < 100){
                literal = getDecenas((int) valor);
                mostrarlieral(literal);
            } else if (valor < 1000) {
                literal = getCentenas((int) valor);
                mostrarlieral(literal);
            } else if (valor < 1000000) {
                literal = getMiles((int) valor);
                mostrarlieral(literal);
            } else {
                mostrarlieral("numero demaciado grande"); ;
            }
        }
    }
    


    private static String getMiles(int valor) {
        if (valor > 999) {
            if (valor == 1000) {
                return "mil";
            } else {
                int miles = Math.round(valor/ 1000);
                int centenas = Math.round((valor - (miles * 1000)));
                return getUnidades(miles)+"mil "+ getCentenas(centenas);
            }
        }return null;
    }

    private static String getCentenas(int valor) {
        if (valor > 99) {// es centena
            if (valor == 100) {// caso especial
                return " cien ";
            } else {
                return CENTENAS[(Math.round(valor / 100))] + getDecenas((valor % 100));
            }
        } 
        return null;
    }

    private static String getDecenas(int valor) {
        String literal = "";
        if (valor < 100 && valor % 10 == 0){   
            int index = (int) ((valor / 10) );
            literal = DECENAS[index];
            return literal;
        } else if (valor < 100) {
            int dIndex = (int) ((valor / 10) );
            int uIndex = (int) (valor % 10);
            if (valor < 30) {
                if (valor < 20) {
                return getEspeciales(valor);
                } else {
                    return literal = DECENAS[dIndex] + UNIDADES[uIndex];
                } 
            } else {
                return literal = DECENAS[dIndex] + "y " + UNIDADES[uIndex];
            }
        } else {
            return "false";
        }
    }

    private static String getEspeciales(int valor) {
        String literal = ESPECIALES[(((int) valor) - 10)];
        return literal;
    }

    private static String getUnidades(int valor) {
        if (valor < 10) {
            String literal = UNIDADES[(int) valor];
            return literal;
        } else if (valor < 100) {
            if (valor < 20) {
                return getEspeciales(valor);
            } else {
                return getDecenas(valor);
            } 
        } else if (valor < 1000) {
            return getCentenas(valor);
        } else {
            return "numero demaciado grande";
        }
    }

    private static void mostrarlieral(String literal) {
        JOptionPane.showMessageDialog(null, "El valor de conversion es: " + literal, "conversion",
                JOptionPane.PLAIN_MESSAGE);
    }

    private static void convertirCOP(double valor, double tasa) {
        double conversion = valor / tasa;
        double resultado = (double) Math.round(conversion * 100d) / 100;
        mostrarConversion(resultado);
    }

    private static void convertirACOP(double valor, double tasa) {
        double conversion = valor * tasa;
        double resultado = (double) Math.round(conversion * 100d) / 100;
        mostrarConversion(resultado);
    }
    

    //Metodo de Muestra resultado de conversion
    private static void mostrarConversion(Double conversion) {
        JOptionPane.showMessageDialog(null, "El valor de conversion es: " + conversion, "conversion",
                JOptionPane.PLAIN_MESSAGE);
    }
}