package empresaCoelho;

import java.time.LocalDate;

public class Pagamento {
	private LocalDate data;
	int id;
	private double valor;

	public Pagamento(int id, double valor) {
        this.data = LocalDate.now();
        this.id = id;
        this.valor = valor;
    }

	public LocalDate getData() {
		return data;
	}

	public double getValor() {
		return valor;
	}
	
	public void Pagar(Fatura fatura) {
		double valorTotal = 0;
		for (Pagamento pagamento : fatura.getPagamentos()) {
			valorTotal += pagamento.getValor();
		}
		fatura.setPagamentos(this);
		valorTotal += this.getValor();
		
		if (valorTotal > fatura.getValor()) {
			Reembolso reembolso = new Reembolso(valorTotal - fatura.getValor());
			reembolso.valorAReembolsar();
		}
	}

    public String getIdFatura() {
        return null;
    }


}