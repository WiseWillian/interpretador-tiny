class ExpVariavel extends Expressao {
    private String nomevar;
    
    public ExpVariavel(String nomevar) {
        this.nomevar = nomevar;
    }

    public double avalia() {
        return Variaveis.getItem(this.nomevar);
    }
}