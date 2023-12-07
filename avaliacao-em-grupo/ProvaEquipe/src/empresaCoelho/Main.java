package empresaCoelho;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Optional;

import empresaCoelho.Fatura;
import empresaCoelho.Pagamento;
import empresaCoelho.Reembolso;
import empresaCoelho.Falha;
import empresaCoelho.Cliente;


public class Main {
/*
	private static Scanner scanner = new Scanner(System.in);
	private static ArrayList<Imovel> imoveis = new ArrayList<>();
	private static ArrayList<Fatura> faturas = new ArrayList<>();
	private static ArrayList<Pagamento> pagamentos = new ArrayList<>();
	private static ArrayList<Falha> falhas = new ArrayList<>();
	private static ArrayList<Reparo> reparos = new ArrayList<>();
	private static ArrayList<Cliente> clientes = new ArrayList<>();
*/
	public static void main(String[] args) {
		int opcao;

		do {
			System.out.println("\n---- MENU ---- ");
			System.out.println("1. Gestão de Clientes");
			System.out.println("2. Gestão de Imóveis");
			System.out.println("3. Gestão de Faturas");
			System.out.println("4. Gestão de Pagamentos");
			System.out.println("5. Gestão de Falhas e Reparos");
			System.out.println("6. Sair");
			System.out.print("Escolha uma opção: ");
			opcao = scanner.nextInt();

			switch (opcao) {
			case 1:
				menuClientes();
				break;
			case 2:
				menuImoveis();
			case 3:
				menuFaturas();
			case 4:
				menuPagamentos();
			case 5:
				menuFalhasReparos();
				break;
			case 6:
				System.out.println("Saindo do programa.");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		} while (opcao != 0);

	}

	public class MenuGestaoClientes {
		private List<Cliente> clientes;
		private Scanner scanner;

		public MenuGestaoClientes(List<Cliente> clientes) {
			this.clientes = clientes;
			this.scanner = new Scanner(System.in);
		}

		public void exibirMenu() {
			int escolha;
			do {
			System.out.println("\n---- MENU CLIENTES ----:");
			System.out.println("1. Incluir Cliente");
			System.out.println("2. Consultar Cliente");
			System.out.println("3. Listar Clientes");
			System.out.println("4. Excluir Cliente");
			System.out.println("5. Alterar Cliente");
			System.out.println("0. Voltar ao Menu Principal");
			System.out.print("Escolha uma opção: ");
			escolha = scanner.nextInt();
			scanner.nextLine();

			switch (escolha) {
			case 1:
				incluirCliente();
				break;
			case 2:
				consultarCliente();
				break;
			case 3:
				listarClientes();
				break;
			case 4:
				excluirCliente();
				break;
			case 5:
				alterarCliente();
				break;
			case 0:
				System.out.println("Retornando ao Menu Principal.");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		} while (escolha != 0);
	}

	private void incluirCliente() {
		System.out.println("Digite o nome do cliente: ");
		String nome = scanner.nextLine();

		System.out.println("Digite o CPF do cliente: ");
		String cpf = scanner.nextLine();

		Cliente cliente = new Cliente(nome, cpf);

		clientes.add(cliente);

		System.out.println("Cliente incluído com sucesso!");
}

	private void consultarCliente() {
	System.out.println("Digite o CPF do cliente: ");
	String cpf = scanner.nextLine();
{
	clientes.stream()
					.filter(cliente -> cliente.getCpf().equals(cpf))
					.findFirst()
					.ifPresentOrElse(
			clienteEncontrado -> {
									System.out.println("Cliente encontrado.");
									System.out.println("Nome: " + clienteEncontrado.getNome());
									System.out.println("CPF: " + clienteEncontrado.getCpf());
					)};
					() -> System.out.println("Cliente não encontrado.")
				);
			}
			
	private void alterarCliente() {
	System.out.println("Digite o CPF do cliente que deseja alterar: ");
	String cpf = scanner.nextLine();

	clientes.stream()
	.filter(cliente -> cliente.getCpf().equals(cpf))
	.findFirst()
	.ifPresentOrElse(
			clienteEncontrado -> {
				System.out.println("Cliente encontrado. Informações atuais:");
				System.out.println("Nome: " + clienteEncontrado.getNome());
				System.out.println("CPF: " + clienteEncontrado.getCpf());

				System.out.println("Digite o novo nome (ou pressione Enter para manter o atual): ");
				String novoNome = scanner.nextLine();
				if (!novoNome.isEmpty()) {
					clienteEncontrado.setNome(novoNome);
				}
				System.out.println("Alterações concluídas com sucesso!");
			});
			() -> System.out.println("Cliente não encontrado.");
}
}


	private void listarClientes() {
	System.out.println("Lista de Clientes: ");

	if(clientes.isEmpty()) {
		System.out.println("Nenhum cliente cadastrado.");
	} else {
		for (Cliente cliente : clientes) {
			System.out.println("Nome: " + cliente.getNome() + ", CPF: " + cliente.getCpf());
		}
	}

	private void excluirCliente() {
		System.out.println("Digite o CPF do cliente que deseja remover: ");
		String cpf = scanner.nextLine();

		boolean clienteRemovido = clientes.removeIf(cliente -> cliente.getCpf().equals(cpf));

		if (clienteRemovido) {
			System.out.println("Cliente removido com sucesso.");
		} else {
			System.out.println("Cliente não encontrado.");
		}
	}



public class MenuFaturas {
    private List<Fatura> faturas;
    private List<Imovel> imoveis;
    private Scanner scanner;

    public MenuFaturas(List<Fatura> faturas, List<Imovel> imoveis) {
        this.faturas = faturas;
        this.imoveis = imoveis;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int escolha;
        do {
			System.out.println("\n---- MENU FATURAS----");
			System.out.println("1. Gerar Fatura para Imóvel");
			System.out.println("2. Listar Todas as Faturas");
			System.out.println("3. Listar Faturas em Aberto");
			System.out.println("4. Voltar ao Menu Principal");
			System.out.print("Escolha uma opção: ");
			escolha = scanner.nextInt();
			scanner.nextLine();

			switch (escolha) {
			case 1:
				gerarFatura(imoveis);
				break;
			case 2:
				listarTodasFaturas();
				break;
			case 3:
				listarFaturasEmAberto();
				break;
			case 4:
				System.out.println("Retornando ao Menu Principal.");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}
		} while (escolha != 0);
	}

	private void gerarFatura(List<Imovel> imoveis) {
        System.out.println("Digite a matrícula do imóvel: ");
        String matriculaImovel = scanner.nextLine();

		Optional<Imovel> imovelEncontrado = imoveis.stream()
		.filter(imovel -> imovel.getMatricula().equals(matriculaImovel))
		.findFirst();

		if (imovelEncontrado.isPresent()) {
            Imovel imovel = imovelEncontrado.get();

		double leituraAtual = imovel.getLeituraAtual();
            double leituraAnterior = imovel.getLeituraAnterior();
            double consumo = leituraAtual - leituraAnterior;

			double custoPorKWh = 9.89; // (custo pode ser ajustado)
            double valorFatura = consumo * custoPorKWh;

			Calendar dataHoraAtual = Calendar.getInstance();

			Fatura novaFatura = new Fatura(imovel, leituraAnterior, leituraAtual, dataHoraAtual, valorFatura);
			faturas.add(novaFatura);

			imovel.setLeituraAnterior(leituraAtual);

            System.out.println("Fatura gerada com sucesso!");
        } else {
            System.out.println("Imóvel não foi encontrado. Não é possível gerar a fatura.");
        }
	}

	private void listarTodasFaturas() {
        System.out.println("\n--- Lista de Todas as Faturas ---");

        if (faturas.isEmpty()) {
            System.out.println("Nenhuma fatura foi encontrada.");
            return;
        }

		for (Fatura fatura : faturas) {
            System.out.println("Data: " + fatura.getData().getTime());
            System.out.println("Última Leitura: " + fatura.getUltimaLeitura());
            System.out.println("Penúltima Leitura: " + fatura.getPenultimaLeitura());
            System.out.println("Valor Calculado: " + fatura.getValorCalculado());
            System.out.println("Valor Pago: " + fatura.getPagamentos().stream().mapToDouble(Pagamento::getValor).sum());
            System.out.println("Valor Restante: " + fatura.getDivida());
            System.out.println("Quitado: " + (fatura.isQuitado() ? "Sim" : "Não"));
            System.out.println("------------------------");
        }
    }

	private void listarFaturasEmAberto() {
        System.out.println("--- Lista de Faturas em Aberto ---");

        if (faturas.stream().noneMatch(Fatura::isQuitado)) {
            System.out.println("Nenhuma fatura em aberto foi encontrada.");
            return;
        }

		for (Fatura fatura : faturas) {
            if (!fatura.isQuitado()) {
                System.out.println("Data: " + fatura.getData().getTime());
                System.out.println("Última Leitura: " + fatura.getUltimaLeitura());
                System.out.println("Penúltima Leitura: " + fatura.getPenultimaLeitura());
                System.out.println("Valor Calculado: " + fatura.getValorCalculado());
                System.out.println("Quitado: Não");
                System.out.println("------------------------");
            }
        }
	}
}

public class MenuPagamentos {

    private List<Pagamento> pagamentos;
    private List<Reembolso> reembolsos;
    private List<Fatura> listaDeFaturas;
    private Scanner scanner;

    public MenuPagamentos(List<Fatura> listaDeFaturas) {
        this.pagamentos = new ArrayList<>();
        this.reembolsos = new ArrayList<>();
        this.listaDeFaturas = listaDeFaturas;
        this.scanner = new Scanner(System.in);
    }

	public void exibirMenu() {
		int escolha;
		do {
			System.out.println("\n---- MENU PAGAMENTOS ----");
			System.out.println("1. Incluir Pagamento");
			System.out.println("2. Listar Todos os Pagamentos");
			System.out.println("3. Listar Reembolsos de Pagamentos");
			System.out.println("4. Voltar ao Menu Principal");
			System.out.print("Escolha uma opção: ");
			escolha = scanner.nextInt();
			scanner.nextLine();

			switch (escolha) {
			case 1:
				incluirPagamento();
				break;
			case 2:
				listarTodosPagamentos();
				break;
			case 3:
				listarReembolsos();
				break;
			case 4:
				System.out.println("Retornando ao Menu Principal.");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}
		} while (escolha != 0);
	}

	public void incluirPagamento() {
        System.out.println("--- Inclusão de Pagamento ---");
        System.out.println("Digite o ID da fatura do pagamento: ");
        int idFatura = scanner.nextInt();
        Fatura fatura = encontrarFaturaPorId(idFatura);
        scanner.nextLine();

		if(fatura == null) {
        System.out.println("Fatura não encontrada.");
        return;
        }

		System.out.println("Digite o valor do pagamento: ");
        float valorPagamento = scanner.nextFloat();
        scanner.nextLine();

		Pagamento novoPagamento = new Pagamento(idFatura, valorPagamento, Calendar.getInstance());
        pagamentos.add(novoPagamento);

		verificarQuitacaoFatura(fatura, novoPagamento);
        System.out.println("Pagamento registrado com sucesso!");
    }

	public void listarTodosPagamentos() {
		System.out.println("--- Lista de Pagamentos ---");
        for (Pagamento pagamento : pagamentos) {
        System.out.println("ID da Fatura: " + pagamento.getIdFatura());
        System.out.println("Valor do Pagamento: " + pagamento.getValor());
        System.out.println("------------------------");
        }
		if (pagamentos.isEmpty()) {
            System.out.println("Nenhum pagamento registrado.");
        }
    }

	public void listarReembolsos() {
        System.out.println("--- Lista de Reembolsos ---");
        for (Reembolso reembolso : reembolsos) {
            System.out.println("ID da Fatura: " + reembolso.getIdFatura());
            System.out.println("Valor do Reembolso: " + reembolso.getValor());
            System.out.println("------------------------");
        }

        if (reembolsos.isEmpty()) {
            System.out.println("Nenhum reembolso registrado.");
        }
    }

	private void verificarQuitacaoFatura(Fatura fatura, Pagamento pagamento) {
        if (fatura != null && !fatura.isQuitado()) {
            fatura.adicionarPagamento(pagamento);

            if (fatura.isQuitado()) {
                double valorEmExcesso = (fatura.getValorPago() - fatura.getValorCalculado());
                if (valorEmExcesso > 0) {
                    Reembolso novoReembolso = new Reembolso(fatura.getIdFatura(), valorEmExcesso, Calendar.getInstance());
                    reembolsos.add(novoReembolso);
                }
            }
        }
    }
    private Fatura encontrarFaturaPorId(int idFatura) {
        for (Fatura fatura : listaDeFaturas) {
            if (fatura.getIdFatura() == idFatura) {
                return fatura;
            }
        }
        return null;
    }
}

public class MenuFalhasReparos {

    private List<Falha> falhas;
    private List<Reparo> reparos;
    private List<Imovel> imoveis;
    private Scanner scanner;

    public MenuFalhasReparos(List<Imovel> imoveis) {
        this.falhas = new ArrayList<>();
        this.reparos = new ArrayList<>();
        this.imoveis = imoveis;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int escolha;
        do {
			System.out.println("\n---- MENU FALHAS E REPAROS ----");
			System.out.println("1. Incluir Falha");
			System.out.println("2. Incluir Reparo");
			System.out.println("3. Listar Reparos em Aberto");
			System.out.println("4. Encerrar Reparo");
			System.out.println("5. Voltar para o Menu Principal");
			System.out.print("Escolha uma opção: ");
			escolha = scanner.nextInt();
			scanner.nextLine();

			switch (escolha) {
		case 1:
			incluirFalha();
			break;
		case 2:
			incluirReparo();
			break;
		case 3:
			listarReparosEmAberto();
			break;
		case 4:
			encerrarReparo();
			break;
		case 5:
			System.out.println("Voltando para o Menu Principal");
			break;
		default:
			System.out.println("Opção inválida. Tente novamente.");
		}
	} while (opcao != 0);
}

	public void incluirFalha() {
		System.out.println("\n---- INCLUIR FALHA ----");
		System.out.println("Digite a matrícula do imóvel:");
		String matriculaImovel = scanner.next();

        Imovel imovelEncontrado = encontrarImovelPorMatricula(matriculaImovel);
        if(imovelEncontrado == null) {
        System.out.println("Imóvel não encontrado");
        return;
        }

		System.out.println("Selecione o tipo de falha (1 para Geração, 2 para Distribuição): ");
        int tipoFalhaOpcao = scanner.nextInt();
        TipoFalha tipoFalha = (tipoFalhaOpcao == 1) ? TipoFalha.GERACAO : TipoFalha.DISTRIBUICAO;
        scanner.nextLine();

        Falha novaFalha = new Falha(imovelEncontrado, tipoFalha, Calendar.getInstance(), false);
        falhas.add(novaFalha);
        System.out.println("Falha registrada com sucesso.");
    }

	public void incluirReparo() {
        System.out.println("--- Inclusão de Reparo ---");
        System.out.println("Digite o ID da falha associada ao reparo: ");
        int idFalha = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite a descrição da atividade de reparo: ");
        String descricaoAtividade = scanner.nextLine();

        Reparo novoReparo = new Reparo(reparos.size() + 1, idFalha, descricaoAtividade,
                Calendar.getInstance(), null, false);
        reparos.add(novoReparo);
        System.out.println("Reparo registrado com sucesso.");
    }

	public void listarReparosEmAberto() {
        System.out.println("--- Lista de Reparos em Aberto ---");
        for (Reparo reparo : reparos) {
            if (!reparo.isResolvido()) {
                System.out.println("ID do Reparo: " + reparo.getId());
                System.out.println("Descrição da Atividade: " + reparo.getDescricaoAtividade());
                System.out.println("------------------------");
            }
        }

        if (reparos.stream().noneMatch(reparo -> !reparo.isResolvido())) {
            System.out.println("Nenhum reparo em aberto encontrado.");
        }
    }

    public void encerrarReparo() {
        System.out.println("--- Encerramento de Reparo ---");
        System.out.println("Digite o ID do reparo a ser encerrado: ");
        int idReparo = scanner.nextInt();
        scanner.nextLine();

        Reparo reparo = encontrarReparoPorId(idReparo);

        if (reparo != null && !reparo.isResolvido()) {
            reparo.setResolvido(true);
            reparo.setDataFim(Calendar.getInstance());

            System.out.println("Reparo encerrado com sucesso!");
        } else {
            System.out.println("Reparo não encontrado ou já encerrado.");
        }
    }

    private Imovel encontrarImovelPorMatricula(String matricula) {
        for (Imovel imovel : imoveis) {
            if (imovel.getMatricula().equals(matricula)) {
                return imovel;
            }
        }
        return null;
    }

    private Reparo encontrarReparoPorId(int idReparo) {
        for (Reparo reparo : reparos) {
            if (reparo.getId() == idReparo) {
                return reparo;
            }
        }
        return null;
    }
}
