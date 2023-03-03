import javax.swing.JOptionPane;

public class ConversorTemperatura extends conversor {
    private String escala;
    

    public String getEscala() {
        return escala;
    }

    public void setEscala() {
        this.escala = (JOptionPane.showInputDialog(null, "Selecciona la escala",
                "Conversor de Temperatura",
                JOptionPane.PLAIN_MESSAGE, null,
                new Object[] { "Selecciona", "Celsius a Fahrenheit", "Celsius a Kelvin", "Fahrenheit a Kelvin",
                        "Fahrenheit a Celsius", "Kelvin a Celsius", "Kelvin a Fahrenheit" },
                "Selecciona"))
                .toString();
        escalaConvertir(valorConvertir(escala), escala);
    }
    
    public void escalaConvertir(Double valor, String seleccion) {
        switch (seleccion) {
                case "Celsius a Fahrenheit":
                    double conversionCF = ((valor * (9 / 5)) + 32);
                    System.out.println(conversionCF);
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
    }
    
}
