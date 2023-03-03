import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class conversor {
    private boolean iniciar = true;
    public String aConvertir ="";
    
    public void setaConvertir(boolean inicio) {
        while (inicio) {
            this.aConvertir = (JOptionPane.showInputDialog(null, "Selecciona la opcion de conversión", "Conversor",
                    JOptionPane.PLAIN_MESSAGE, icono("noun-inverter-66282.png", 40, 40),
                    new Object[] { "Selecciona", "Conversor de moneda", "Conversor de temperatura",
                            "Conversor de numeros a letras" },
                    "Selecciona")).toString();
            opcionConversion(aConvertir);
        }
    }
    public void opcionConversion(String aConvertir) {
        if (aConvertir == "Conversor de moneda") {
            ConversorMoneda moneda = new ConversorMoneda();
            moneda.setMoneda();
        } else if (aConvertir == "Conversor de temperatura") {
            ConversorTemperatura escala = new ConversorTemperatura();
            escala.setEscala();
        } else if (aConvertir == "Conversor de numeros a letras") {
            ConversorLiteral numero = new ConversorLiteral();
            numero.setNumero(valorConvertir(aConvertir));
        }
    }
    
    private  Icon icono(String path, int width, int heigth) {
        final Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage().getScaledInstance(width, heigth, java.awt.Image.SCALE_SMOOTH));
        return img;
    }
    
    public double valorConvertir(String seleccion) {
        double valor = Integer.parseInt(JOptionPane.showInputDialog(null, "introduce el valor a convertir", seleccion,
                JOptionPane.PLAIN_MESSAGE));
        return valor;
    }
    
    public boolean isIniciar() {
        return iniciar;
    }
    public void setIniciar(boolean iniciar) {
        this.iniciar = iniciar;
    }
        
    public String getaConvertir() {
        return aConvertir;
    }

    
    
    public void mostrarLiteral(String literal) {
        String[] botones = { "Inicio", "Continuar con " + getaConvertir(), "Cancelar" };
        int opciones = JOptionPane.showOptionDialog(null, "El valor de conversion es: " + literal, "conversion",
                JOptionPane.PLAIN_MESSAGE, 0, null, botones, "Inicio");
        
                repetir(opciones);
                
    }
    
    public void mostrarConversion(Double conversion) {
        String[] botones = { "Inicio", "Continuar con " + getaConvertir(), "Cancelar" };
        int opciones = JOptionPane.showOptionDialog(null, "El valor de conversion es: " + conversion, "conversion",
                JOptionPane.PLAIN_MESSAGE, 0, null, botones, "Inicio");
        repetir(opciones);
       
    }

    private void repetir(int opciones) {
        if (opciones == 0) {
            setIniciar(true);
        } else if (opciones == 1) {
            setIniciar(false);
            opcionConversion(getaConvertir());
        } else if (opciones == 2) {
            setIniciar(false);
        }
    }
    

}
