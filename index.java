import javax.swing.JOptionPane;

public class index {
    public static void main(String[] args) {
        String aConvertir = (JOptionPane.showInputDialog(null, "Selecciona la opcion de conversión", "Conversor",
                JOptionPane.PLAIN_MESSAGE, null,
                new Object[] { "Selecciona", "Conversor de moneda", "Conversor de temperatura",
                        "Conversor de numeros a letras" },
                "Selecciona")).toString();

        if (aConvertir == "Conversor de moneda") {
            String moneda = (JOptionPane.showInputDialog(null, "Selecciona la moneda a cambiar", "Conversor de moneda",
                    JOptionPane.PLAIN_MESSAGE, null,
                    new Object[] {
                         "Selecciona", "COP a Dolar", "COP a Euro", "COP a Libras Esterlinas","COP a Yen Japonés", "COP a Won Sul-coreano",
                         "Dolar a COP", "Euro a COP", "Libras Esterlinas a COP", "Yen Japonés a COP","Won sul-coreano a COP"
                         }, "Selecciona"))
                    .toString();

            valorConvertir(moneda);

        } else if (aConvertir == "Conversor de temperatura") {

            String escala = (JOptionPane.showInputDialog(null, "Selecciona la escala", "Conversor de Temperatura",
                    JOptionPane.PLAIN_MESSAGE, null,
                    new Object[] { "Selecciona", "Celsius a Fahrenheit", "Celsius a Kelvin", "Fahrenheit a Kelvin",
                            "Fahrenheit a Celsius","Kelvin a Celsius","Kelvin a Fahrenheit" },
                    "Selecciona"))
                    .toString();

            valorConvertir(escala);

        } else if (aConvertir == "Conversor de numeros a letras") {

            JOptionPane.showMessageDialog(null, "Tu opcion de conversion es Convertir Numeros!!", "Conversion", 0,
                    null);

        }

    }
    /*
        - Convertir de la moneda de tu país a Dólar
       - Convertir de la moneda de tu país  a Euros
       - Convertir de la moneda de tu país  a Libras Esterlinas
       - Convertir de la moneda de tu país  a Yen Japonés
       - Convertir de la moneda de tu país  a Won sul-coreano

Recordando que también debe ser posible convertir inversamente, es decir:

       - Convertir de Dólar a la moneda de tu país
       - Convertir de Euros a la moneda de tu país
       - Convertir de Libras Esterlinas a la moneda de tu país
       - Convertir de Yen Japonés a la moneda de tu país
       - Convertir de Won sul-coreano a la moneda de tu país
       */

    public static void valorConvertir(String moneda) {

        double valor = Integer.parseInt(JOptionPane.showInputDialog(null, "introduce el valor a convertir", moneda,
                JOptionPane.PLAIN_MESSAGE));
        
         switch(moneda){
             case "COP a dolar":
                 conversionCOPDolar(valor);
                 break;
            case "COP euro":
                conversionCOPEuro(valor);
                break;
            case "COP a Libras Esterlinas":
                conversionCOPLibrasEsterlinas(valor);
                break;
            case "COP a Yen Japonés":
                conversionCOPYenJapones(valor);
                break;
            case "COP a Won sul-coreano":
                conversionCOPWonSulCoreano(valor);
                break;
            case "Dolar a COP":
                conversionDolarCOP(valor);
                break;
            case "Euro a COP":
                conversionEuroCOP(valor);
                break;
            case "Libras Esterlinas a COP":
                conversionLibrasEsterlinasCOP(valor);
                break;
            case "Yen Japonés a COP":
                conversionYenJaponésCOP(valor);
                break;
            case "Won sul-coreano a COP":
                conversionWonSulCoreanoCOP(valor);
                break;
        }
    }

    private static void conversionCOPDolar(Double valor) {
        double conversion = valor / 4809;
        mostrarConversion(conversion);
    }
    
    private static void conversionCOPEuro(Double valor) {
        double conversion = valor / 5099;
        mostrarConversion(conversion);
    }
    
    private static void conversionCOPLibrasEsterlinas(double valor) {
        double conversion = valor / 5808;
        mostrarConversion(conversion);
    }
    
    private static void conversionCOPYenJapones(double valor) {
        double conversion = valor / 35.37 ;
        mostrarConversion(conversion);
    }
    
    private static void conversionCOPWonSulCoreano(double valor) {
        double conversion = valor / 3.65;
        mostrarConversion(conversion);
    }
    
    private static void conversionDolarCOP(double valor) {
        double conversion = valor * 4809;
        mostrarConversion(conversion);
    }

    private static void conversionEuroCOP(double valor) {
        double conversion = valor * 5099;
        mostrarConversion(conversion);
    }
    
    private static void conversionLibrasEsterlinasCOP(double valor) {
        double conversion = valor * 5808;
        mostrarConversion(conversion);
    }
    
    private static void conversionYenJaponésCOP(double valor) {
        double conversion = valor * 35.37;
        mostrarConversion(conversion);
    }
    
    private static void conversionWonSulCoreanoCOP(double valor) {
        double conversion = valor / 3.65;
        mostrarConversion(conversion);
    }


    //Metodo de Muestra resultado de conversion
    private static void mostrarConversion(Double conversion) {
        JOptionPane.showMessageDialog(null, "El valor de conversion es: " + conversion, "conversion",
                JOptionPane.PLAIN_MESSAGE);
    }

}