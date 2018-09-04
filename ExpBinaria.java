class ExpBinaria extends Expressao {
    private String op;
    private Expressao exp1;
    private Expressao exp2;
    
    public ExpConstante(String op, Expressao exp1, Expressao exp2) {
        this.op = op;
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    public double avalia() {
        switch(this.op) {
            case "+":
                return this.exp1.avalia() + this.exp2.avalia();
                break;
            case "-":
                return this.exp1.avalia() - this.exp2.avalia();
                break;
            case "*":
                return this.exp1.avalia() * this.exp2.avalia();
                break;
            case "/":
                return this.exp1.avalia() / this.exp2.avalia();
                break;
        }
        return 0;
    }
}