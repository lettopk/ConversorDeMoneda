public class ConversorLiteral extends conversor{
    private String literal ;
    private double numero;

    private final String[] UNIDADES = { "cero", "un ", "dos ", "tres ", "cuatro ", "cinco ", "seis ", "siete ",
            "ocho ","nueve " };

    private final String[] ESPECIALES = { "diez ", "once ", "doce ", "trece ", "catorce ", "quince ",
            "dieciseis ", "diecisiete ", "dieciocho ", "diecinueve " };
    private final String[] DECENAS = { "", "", "veinti ", "treinta ", "cuarenta ",
            "cincuenta ", "sesenta ", "setenta ", "ochenta ", "noventa " };
    private final String[] CENTENAS = { "", "ciento ", "doscientos ", "trecientos ", "cuatrocientos ",
            "quinientos ","seiscientos ","setecientos ", "ochocientos ", "novecientos " };
    
    public double getNumero() {
        return numero;
    }
    public void setNumero(double numero) {
        this.numero = numero;
        numeroConvetir(numero);
    }

    public String getLiteral() {
        return literal;
    }

    public void setLiteral(String literal) {
        this.literal =literal;
    }


    public void numeroConvetir(double valor){
            
            if (valor < 10) {
                literal = getUnidades((int) valor);
                mostrarLiteral(literal);
            } else if (valor < 20) {
                literal = getEspeciales((int) valor);
                mostrarLiteral(literal);
            }else if (valor < 100){
                literal = getDecenas((int) valor);
                mostrarLiteral(literal);
            } else if (valor < 1000) {
                literal = getCentenas((int) valor);
                mostrarLiteral(literal);
            } else if (valor < 1000000) {
                literal = getMiles((int) valor);
                mostrarLiteral(literal);
            } else {
                mostrarLiteral("numero demaciado grande");
            }
        }    
        
    private  String getMiles(int valor) {
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

    private  String getCentenas(int valor) {
        if (valor > 99) {// es centena
            if (valor == 100) {// caso especial
                return " cien ";
            } else {
                return CENTENAS[(Math.round(valor / 100))] + getDecenas((valor % 100));
            }
        } 
        return null;
    }

    private  String getDecenas(int valor) {
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

    private  String getEspeciales(int valor) {
        String literal = ESPECIALES[(((int) valor) - 10)];
        return literal;
    }

    private  String getUnidades(int valor) {
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
}
