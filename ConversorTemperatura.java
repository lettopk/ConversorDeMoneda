import javax.swing.JOptionPane;

public class ConversorTemperatura extends conversor {
    private String escala;
    private Double ResultadoEscala;
    

    public Double getResultadoEscala() {
        return ResultadoEscala;
    }

    public void setResultadoEscala(Double resultadoEscala) {
        ResultadoEscala = resultadoEscala;
    }

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
                    setResultadoEscala(conversionCF);
                    break;
                case "Celsius a Kelvin":
                    double conversionCK = valor + 273;
                    setResultadoEscala(conversionCK);
                    break;
                case "Fahrenheit a Kelvin":
                    double conversionFK = (valor + 459.67)*(0.555);
                    setResultadoEscala(conversionFK);
                    break;
                case "Fahrenheit a Celsius":
                    double conversionFC = (5/9)*(valor-32);
                    setResultadoEscala(conversionFC);
                    break;
                case "Kelvin a Celsius":
                    double conversionKC = valor -273.15;
                    setResultadoEscala(conversionKC);
                    break;
                case "Kelvin a Fahrenheit":
                    double conversionKF = 9 / (5 * valor) - 459.67;
                    setResultadoEscala(conversionKF);
                    break;
            }
    }
    
}
