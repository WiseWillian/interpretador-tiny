class ExpConstante extends Expressao {
    private String valor;
    
    public ExpConstante(String valor) {
        this.valor = valor;
    }

    public double avalia() {
        return Double.parseDouble(this.valor);
    }
}