package empresaCoelho;

import java.util.ArrayList;

public class Cliente {
	private String nome;
	private String cpf;
	private ArrayList<Imovel> imoveis;

	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.imoveis = new ArrayList<>();
	}

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
    	this.nome = nome;
    }

	
	public String getCpf() {
		return cpf;
    }

    public ArrayList<Imovel> getImoveis() {
        return imoveis;
    }


	public void adicionarImovel(Imovel imovel) {
		imoveis.add(imovel);
	}

	public void removerImovel(Imovel imovel) {
		imoveis.remove(imovel);
	}
	
	public void listarImoveis() {
        for (Imovel imovel : imoveis) {
            System.out.println("Matrícula: " + imovel.getMatricula() + ", Endereço: " + imovel.getEndereco());
        }
    }

	public void alterarCliente(String novoNome, String novoCpf) {
		this.nome = novoNome;
		this.cpf = novoCpf;
    }

	public void gerarFatura() {
		for (Imovel imovel : imoveis) {
			Fatura fatura = imovel.realizarLeitura(imovel.getUltimaLeitura() + 10);
			System.out.println(fatura.toString());
		}
    }	
}