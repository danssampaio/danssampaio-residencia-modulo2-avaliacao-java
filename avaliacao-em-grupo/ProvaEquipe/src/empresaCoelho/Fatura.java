package empresaCoelho;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

public class Fatura {
	private int numeroFatura;
	private LocalDate dataEmissao;
	private int ultimaLeitura;
	private int penultimaLeitura;
	
	

	public void setPenultimaLeitura(int penultimaLeitura) {
		this.penultimaLeitura = penultimaLeitura;
	}

	private double valor;
	

	private boolean quitado;
	private ArrayList<Pagamento> pagamentos;
	
	public Fatura(int ultimaLeitura, int penultimaLeitura, double valor) {
		this.numeroFatura = +ultimaLeitura;
		this.dataEmissao = LocalDate.now();
		this.ultimaLeitura = ultimaLeitura;
		this.penultimaLeitura = penultimaLeitura;
		this.valor = valor;
		this.quitado = false;
		this.pagamentos = new ArrayList<>();
	}
	
	public Fatura(Imovel imovel, double leituraAnterior, double leituraAtual, Calendar dataHoraAtual,
            double valorFatura) {
    }

    public int getNumeroFatura() {
		return numeroFatura;
	}
	
	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public int getUltimaLeitura() {
		return ultimaLeitura;
	}

	public int getPenultimaLeitura() {
		return penultimaLeitura;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	public ArrayList<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(Pagamento pagamento) {
		this.pagamentos.add(pagamento);
	}
	
	private double calcularValor() {
		return (ultimaLeitura - penultimaLeitura) * 10.0;
	}
	
	public void quitarFatura() {
		this.quitado = true;
		System.out.println("Fatura " + numeroFatura + " quitada com sucesso.");
	}


	
	public void incluirPagamento(double valorPagamento) {
        if (!quitado) {
			Pagamento pagamento = new Pagamento(valorPagamento);
            pagamentos.add(pagamento);

            double totalPagamentos = calcularTotalPagamentos();
            if (totalPagamentos >= valor) {
				quitarFatura();
            }
			
            System.out.println("Pagamento de R$" + valorPagamento + " incluído na fatura.");
        } else {
			System.out.println("A fatura" + numeroFatura + "já está quitada. Não é possível incluir mais pagamentos.");
        }
	}
	
	public void listarPagamentos() {
		System.out.println("Pagamentos da fatura " + numeroFatura + ":");
		
        for (Pagamento pagamento : pagamentos) {
			System.out.println("Data: " + pagamento.getDataPagamento() + ", Valor: R$" + pagamento.getValor());
        }
	}
	
	private double calcularTotalPagamentos() {
		double totalPagamentos = 0;
        for (Pagamento pagamento : pagamentos) {
			totalPagamentos += pagamento.getValor();
        }
        return totalPagamentos;
	}
	
	public boolean isQuitado() {
		return quitado;
	}

	public void setQuitado(boolean quitado) {
        this.quitado = quitado;
    }

    public LocalDate getDataQuitacao() {
        if (quitado && !pagamentos.isEmpty()) {
            return pagamentos.get(pagamentos.size() - 1).getDataPagamento();
        } else {
            return null;
        }
    }

    public String getDivida() {
        return null;
    }

    public String getValorCalculado() {
        return null;
    }

    public Calendar getData() {
        return null;
    }

    public int getIdFatura() {
        return 0;
    }

    public String getValorPago() {
        return null;
    }

    public void adicionarPagamento(Pagamento pagamento) {
    }
}