package empresaCoelho;

import java.util.Calendar;

class Reembolso extends Pagamento {
    public Reembolso(double valor) {
        super(valor);
    }
    public Reembolso(int idFatura, double valorEmExcesso, Calendar instance) {
    }
    public void valorAReembolsar() {
    	System.out.println("Valor a ser reembolsado: "+(this.getValor()*-1));
    }
    public String getIdFatura() {
        return null;
    }
}