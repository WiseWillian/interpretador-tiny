class ExpLogica extends Expressao {
    private String op;
    private Expressao exp1;
    private Expressao exp2;
    
    public ExpLogica(String op, Expressao exp1, Expressao exp2) {
        this.op = op;
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    public double avalia() {
        double resultado = 0;

        switch(this.op) {
            case "and":
                (this.exp1.avalia() && this.exp2.avalia()) ? resultado = 1 : resultado = 0;
                break;
            case "or":
                (this.exp1.avalia() || this.exp2.avalia()) ? resultado = 1 : resultado = 0;
                break;
        }
        
        return resultado;
    }
}