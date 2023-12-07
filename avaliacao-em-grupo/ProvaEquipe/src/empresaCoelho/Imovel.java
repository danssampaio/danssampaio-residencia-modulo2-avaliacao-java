package empresaCoelho;

import java.util.ArrayList;
import java.util.Date;

public class Imovel extends Cliente {
	private int matricula;
	private String endereco;
	private int ultimaLeitura;
	private int penultimaLeitura;
	private ArrayList<Fatura> faturas;

	public Imovel(int matricula, String endereco, int ultimaLeitura, int penultimaLeitura) {
		super(nome, cpf);
		this.matricula = matricula;
		this.endereco = endereco;
		this.ultimaLeitura = ultimaLeitura;
		this.penultimaLeitura = penultimaLeitura;
		this.faturas = new ArrayList<>();
	}

	public int getMatricula() {
        return matricula;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getUltimaLeitura() {
        return ultimaLeitura;
    }

    public int getPenultimaLeitura() {
        return penultimaLeitura;
    }

    public ArrayList<Fatura> getFaturas() {
        return faturas;
    }	

    public Fatura realizarLeitura(int leituraAtual) {
        penultimaLeitura = ultimaLeitura;
        ultimaLeitura = leituraAtual;
    
        Fatura novaFatura = new Fatura(ultimaLeitura, penultimaLeitura, calcularValor(ultimaLeitura, penultimaLeitura));
    
        adicionarFatura(novaFatura);
        return novaFatura;
    }

    private double calcularValor(int ultimaLeitura, int penultimaLeitura) {
        return (ultimaLeitura - penultimaLeitura) * 10.0;
    }

	public void gerarFatura() {
        Fatura novaFatura = realizarLeitura(ultimaLeitura + 10); 
        adicionarFatura(novaFatura);
	}

    public void adicionarFatura(Fatura fatura) {
        faturas.add(fatura);
    }

	public int calcularConsumo() {
        return ultimaLeitura - penultimaLeitura;
	}

	public void alterarImovel(String novoEndereco) {
        this.endereco = novoEndereco;		
	}

	public void listarFaturas(boolean apenasEmAberto) {
        for (Fatura fatura : faturas) {
            if (!apenasEmAberto || !fatura.isQuitado()) {
                System.out.println(fatura.toString());
            }
		}
	}

    public void realizarPagamento(int numeroFatura) {
        if (numeroFatura >= 1 && numeroFatura <= faturas.size()) {
            Fatura fatura = faturas.get(numeroFatura - 1);
            if (!fatura.isQuitado()) {
                fatura.setQuitado(true);
                System.out.println("Pagamento da fatura " + numeroFatura + " realizado com sucesso.");
            } else {
                System.out.println("A fatura " + numeroFatura + " já está quitada.");
            }
        } else {
            System.out.println("Número de fatura inválido.");
        }
    }

    public void listarPagamentos() {
        for (Fatura fatura : faturas) {
            if (fatura.isQuitado()) {
                System.out.println("Fatura " + fatura.getNumeroFatura() + " quitada em " + fatura.getDataQuitacao());
            }
        }
    }

	public void listarPagamentosFatura(int numeroFatura) {
        if (numeroFatura >= 1 && numeroFatura <= faturas.size()) {
            Fatura fatura = faturas.get(numeroFatura - 1);
            if (fatura.isQuitado()) {
                System.out.println("Fatura " + numeroFatura + " quitada em " + fatura.getDataQuitacao());
            } else {
                System.out.println("A fatura " + numeroFatura + " ainda não foi quitada.");
            }
        } else {
            System.out.println("Número de fatura inválido.");
        }
	}

    public void setLeituraAnterior(double leituraAtual) {
    }

    public double getLeituraAtual() {
        return 0;
    }

    public double getLeituraAnterior() {
        return 0;
    }
}