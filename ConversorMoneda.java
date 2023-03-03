import javax.swing.JOptionPane;

public class ConversorMoneda extends conversor {
    private String moneda;
    
    final String moneda1 = "COP a Dolar";
    final String moneda2 = "COP a Euro";
    final String moneda3 = "COP a Libras Esterlinas";
    final String moneda4 = "COP a Yen Japonés";
    final String moneda5 = "COP a Won Sul-Coreano";
    final String moneda6 = "Dolar a COP";
    final String moneda7 = "Euro a COP";
    final String moneda8 = "Libras Esterlinas a COP";
    final String moneda9 = "Yen Japonés a COP";
    final String moneda10 = "Won Sul-Coreano a COP";

    public void setMoneda() {
        this.moneda = (JOptionPane.showInputDialog(null, "Selecciona la moneda a cambiar",
                "Conversor de moneda",
                JOptionPane.PLAIN_MESSAGE, null,
                new Object[] {
                        "Selecciona", moneda1, moneda2, moneda3, moneda4, moneda5,
                        moneda6, moneda7, moneda8, moneda9, moneda10
                }, "Selecciona"))
                .toString();
        monedaConvertir(valorConvertir(moneda), moneda);
    }

    public String getMoneda() {
        return moneda;
    }
    
    public void monedaConvertir(double valor,String seleccion) {
        switch (seleccion) {
            case "COP a Dolar":
                convertirCOP(valor, 4809);
                break;
            case "COP a Euro":
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
    }
    
    private void convertirCOP(double valor, double tasa) {
        double conversion = valor / tasa;
        double resultado = (double) Math.round(conversion * 100d) / 100;
        mostrarConversion(resultado);
    }

    private void convertirACOP(double valor, double tasa) {
        double conversion = valor * tasa;
        double resultado = (double) Math.round(conversion * 100d) / 100;
        mostrarConversion(resultado);
    }
       
    
}
