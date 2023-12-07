package empresaCoelho;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pagamento {
	private LocalDate data;
	private double valor;

	public Pagamento(double valor) {
        this.data = LocalDate.now();
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
	
	

}
