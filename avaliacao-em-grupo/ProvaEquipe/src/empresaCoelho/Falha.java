package empresaCoelho;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class Falha {
	
	private static int contadorFalhas = 0;

	private int numero;
	private String descricao;
	private String previsao;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private boolean resolvido;
	private Imovel imovel;

	public Falha(Imovel imovel, String descricao, String previsao, LocalDate dataInicio) {
		this.numero = ++contadorFalhas;
		this.imovel = imovel;
		this.descricao = descricao;
		this.previsao = previsao;
		this.dataInicio = dataInicio;
		this.resolvido = false;
	}
	
	
	 public static int getContadorFalhas() {
		return contadorFalhas;
	}


	public static void setContadorFalhas(int contadorFalhas) {
		Falha.contadorFalhas = contadorFalhas;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getPrevisao() {
		return previsao;
	}


	public void setPrevisao(String previsao) {
		this.previsao = previsao;
	}


	public LocalDate getDataInicio() {
		return dataInicio;
	}


	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}


	public LocalDate getDataFim() {
		return dataFim;
	}


	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}


	public Imovel getImovel() {
		return imovel;
	}


	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}


	public static void incluirFalha(ArrayList<Falha> falhas, ArrayList<Imovel> imoveis) {
	       
		Scanner scanner = new Scanner(System.in);

		System.out.println("Deseja fornecer a matrícula do imóvel? (S para Sim, N para Não): ");
		String opcaoMatricula = scanner.nextLine();

		Imovel imovel = null;

		if ("S".equalsIgnoreCase(opcaoMatricula)) {
			System.out.println("Digite o número de matrícula: ");
		    int matricula = scanner.nextInt();

		    imovel = imoveis.stream().filter(m -> m.getMatricula() == matricula).findFirst().orElse(null);

		    if (imovel == null) {
		         System.out.println("Imóvel não encontrado. Falha não registrada.");
		         return;
		    }
		        scanner.nextLine();
		    }

		    System.out.println("Digite a descrição da falha: ");
		    String descricao = scanner.nextLine();

		    System.out.println("Digite a previsão para resolução (DD/MM/AAAA): ");
		    String previsao = scanner.nextLine();

		    LocalDate dataInicio = LocalDate.now(); 

		    System.out.println("Selecione o tipo de falha:");
		    System.out.println("1. Falha de Geração");
		    System.out.println("2. Falha de Distribuição");
		    System.out.print("Escolha o tipo: ");

		    int tipoFalha = scanner.nextInt();
		    if (tipoFalha == 1) {
		        FalhaGeracao novaFalha = new FalhaGeracao(imovel, descricao, previsao, dataInicio);
		        falhas.add(novaFalha);
		    } else if (tipoFalha == 2) {
		        FalhaDistribuicao novaFalha = new FalhaDistribuicao(imovel, descricao, previsao, dataInicio);
		        falhas.add(novaFalha);
		    }
		    System.out.println("Falha registrada com sucesso!");
		}
	
	public boolean isResolvido() {
		return resolvido;
	}

	public void setResolvido(boolean resolvido) {
		this.resolvido = resolvido;
		if (resolvido) {
		this.dataFim = LocalDate.now();
		}
	}
	
	private static void listarFalhasAberto(ArrayList<Falha> falhas){
		System.out.println("\n---- LISTAR FALHAS EM ABERTO ----");

        for (Falha falha : falhas) {
            if (!falha.isResolvido()) {
            	
                System.out.println("Número de Falha: " + falha.getNumero());
                System.out.println("Descrição: " + falha.getDescricao());
                System.out.println("Previsão de Resolução: " + falha.getPrevisao());
                System.out.println("Data de Início: " + falha.getDataInicio());
                System.out.println("Imóvel: " + falha.getImovel().getMatricula());
                System.out.println("Status: Aberto\n");
            }
        }
	}

}



