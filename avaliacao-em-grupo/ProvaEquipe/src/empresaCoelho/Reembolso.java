package empresaCoelho;

class Reembolso extends Pagamento {
    public Reembolso(double valor) {
        super(valor);
    }
    public void valorAReembolsar() {
    	System.out.println("Valor a ser reembolsado: "+(this.getValor()*-1));
    }
}