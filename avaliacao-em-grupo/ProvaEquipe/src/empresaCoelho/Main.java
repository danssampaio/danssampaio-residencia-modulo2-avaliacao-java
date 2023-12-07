package empresaCoelho;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;
import java.util.Scanner;

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	private static ArrayList<Imovel> imoveis = new ArrayList<>();
	private static ArrayList<Fatura> faturas = new ArrayList<>();
	private static ArrayList<Pagamento> pagamentos = new ArrayList<>();
	private static ArrayList<Falha> falhas = new ArrayList<>();
	private static ArrayList<Reparo> reparos = new ArrayList<>();
	private static ArrayList<Cliente> clientes = new ArrayList<>();

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

		scanner.close();
	}

	private static void menuClientes() {
		int opcaoClientes;

		do {
			System.out.println("\n---- MENU CLIENTES ----:");
			System.out.println("1. Incluir Cliente");
			System.out.println("2. Consultar Cliente");
			System.out.println("3. Listar Clientes");
			System.out.println("4. Excluir Cliente");
			System.out.println("5. Alterar Cliente");
			System.out.println("0. Voltar ao Menu Principal");
			System.out.print("Escolha uma opção: ");
			opcaoClientes = scanner.nextInt();

			switch (opcaoClientes) {
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
		} while (opcaoClientes != 0);
	}

	private static void incluirCliente() {
		scanner.nextLine();
		System.out.println("Digite o nome do cliente: ");
		String nome = scanner.nextLine();
		

		System.out.println("Digite o CPF do cliente: ");
		String cpf = scanner.nextLine();

		Cliente cliente = new Cliente(nome, cpf);

		clientes.add(cliente);

		System.out.println("Cliente incluído com sucesso!");
	}

	private static void consultarCliente() {
		System.out.println("Digite o CPF do cliente: ");
		String cpf = scanner.nextLine();

		clientes.stream().filter(cliente -> cliente.getCpf().equals(cpf)).findFirst()
				.ifPresentOrElse(clienteEncontrado -> {
					System.out.println("Cliente encontrado.");
					System.out.println("Nome: " + clienteEncontrado.getNome());
					System.out.println("CPF: " + clienteEncontrado.getCpf());
				}, () -> System.out.println("Cliente não encontrado."));
	}

	private static void listarClientes() {
		System.out.println("Lista de Clientes: ");

		if (clientes.isEmpty()) {
			System.out.println("Nenhum cliente cadastrado.");
		} else {
			for (Cliente cliente : clientes) {
				System.out.println("Nome: " + cliente.getNome() + ", CPF: " + cliente.getCpf());
			}
		}
	}

	private static void excluirCliente() {
		System.out.println("Digite o CPF do cliente que deseja remover: ");
		String cpf = scanner.nextLine();

		boolean clienteRemovido = clientes.removeIf(cliente -> cliente.getCpf().equals(cpf));

		if (clienteRemovido) {
			System.out.println("Cliente removido com sucesso.");
		} else {
			System.out.println("Cliente não encontrado.");
		}
	}

	private static void alterarCliente() {
		System.out.println("Digite o CPF do cliente que deseja alterar: ");
		String cpf = scanner.nextLine();

		clientes.stream().filter(cliente -> cliente.getCpf().equals(cpf)).findFirst()
				.ifPresentOrElse(clienteEncontrado -> {
					System.out.println("Cliente encontrado. Informações atuais:");
					System.out.println("Nome: " + clienteEncontrado.getNome());
					System.out.println("CPF: " + clienteEncontrado.getCpf());

					System.out.println("Digite o novo nome (ou pressione Enter para manter o atual): ");
					String novoNome = scanner.nextLine();
					if (!novoNome.isEmpty()) {
						clienteEncontrado.setNome(novoNome);
					}
					System.out.println("Alterações concluídas com sucesso!");
				}, () -> System.out.println("Cliente não encontrado."));
	}

	private static void menuImoveis() {
		int opcaoImoveis;

		do {
			System.out.println("\n---- MENU IMÓVEIS ----");
			System.out.println("1. Incluir Imóvel");
			System.out.println("2. Consultar Imóvel");
			System.out.println("3. Listar Imóveis");
			System.out.println("4. Excluir Imóvel");
			System.out.println("5. Alterar Imóvel");
			System.out.println("6. Voltar ao Menu Principal\n");
			System.out.print("Escolha uma opção: ");
			opcaoImoveis = scanner.nextInt();

			switch (opcaoImoveis) {
			case 1:
				incluirImovel();
				break;
			case 2:
				consultarImovel();
				break;
			case 3:
				listarImoveis();
				break;
			case 4:
				excluirImovel();
				break;
			case 5:
				alterarImovel();
				break;
			case 6:
				System.out.println("Retornando ao Menu Principal.");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		} while (opcaoImoveis != 0);
	}

	private static void incluirImovel() {
        System.out.println("\n---- INCLUIR IMÓVEL ----");
        
        System.out.println("Digite a matrícula do imóvel: ");
        int matricula = scanner.nextInt();

        System.out.println("Digite o endereço do imóvel: ");
        scanner.nextLine(); 
        String endereco = scanner.nextLine();

        System.out.println("Digite a última leitura: ");
        int ultimaLeitura = scanner.nextInt();

        System.out.println("Digite a penúltima leitura: ");
        int penultimaLeitura = scanner.nextInt();

        Imovel novoImovel = new Imovel(matricula, endereco, ultimaLeitura, penultimaLeitura);
        imoveis.add(novoImovel);

        System.out.println("Imóvel incluído com sucesso!");
    }

	private static void consultarImovel() {
        System.out.println("\n---- CONSULTAR IMÓVEL ----");
        
        System.out.println("Digite a matrícula do imóvel: ");
        int matricula = scanner.nextInt();

        Imovel imovelEncontrado = encontrarImovelPorMatricula(matricula);

        if (imovelEncontrado != null) {
            System.out.println("Imóvel encontrado:");
            System.out.println("Matrícula: " + imovelEncontrado.getMatricula());
            System.out.println("Endereço: " + imovelEncontrado.getEndereco());
            System.out.println("Penúltima Leitura: " + imovelEncontrado.getPenultimaLeitura());
            System.out.println("Última Leitura: " + imovelEncontrado.getUltimaLeitura());
        } else {
            System.out.println("Imóvel não encontrado.");
        }
    }	

	private static void listarImoveis() {
        System.out.println("\n---- LISTAR IMÓVEIS ----");

        if (imoveis.isEmpty()) {
            System.out.println("Nenhum imóvel cadastrado.");
        } else {
            System.out.println("Lista de Imóveis:");
            for (Imovel imovel : imoveis) {
                System.out.println("Imóvel encontrado:");
                System.out.println("Matrícula: " + imovel.getMatricula());
                System.out.println("Endereço: " + imovel.getEndereco());
                System.out.println("Penúltima Leitura: " + imovel.getPenultimaLeitura());
                System.out.println("Última Leitura: " + imovel.getUltimaLeitura());
                System.out.println("------------------------");
            }
        }
    }

	private static void excluirImovel() {
        System.out.println("\n---- EXCLUIR IMÓVEL ----");
        
		System.out.println("Digite a matrícula do imóvel que deseja remover: ");
        int matricula = scanner.nextInt();

        boolean imovelRemovido = imoveis.removeIf(imovel -> imovel.getMatricula() == matricula);

        if (imovelRemovido) {
            System.out.println("Imóvel removido com sucesso.");
        } else {
            System.out.println("Imóvel não encontrado.");
        }
    }

	 private static void alterarImovel() {
	        System.out.println("\n---- ALTERAR IMÓVEL ----");
	        
	        System.out.println("Digite a matrícula do imóvel que deseja alterar: ");
	        int matricula = scanner.nextInt();

	        Imovel imovelEncontrado = encontrarImovelPorMatricula(matricula);

	        if (imovelEncontrado != null) {
	            System.out.println("Imóvel encontrado:");
	            System.out.println("Matrícula: " + imovelEncontrado.getMatricula());
	            System.out.println("Endereço: " + imovelEncontrado.getEndereco());
	            System.out.println("Penúltima Leitura: " + imovelEncontrado.getPenultimaLeitura());
	            System.out.println("Última Leitura: " + imovelEncontrado.getUltimaLeitura());

	            System.out.println("Digite o novo endereço (ou pressione Enter para manter o atual): ");
	            scanner.nextLine(); 
	            
	            String novoEndereco = scanner.nextLine();
	            if (!novoEndereco.isEmpty()) {
	                imovelEncontrado.setEndereco(novoEndereco);
	            }	            

	            System.out.println("Alterações concluídas com sucesso!");
	        } else {
	            System.out.println("Imóvel não encontrado.");
	        }
	    }

	private static void menuFaturas() {
		int escolha;
		do {
			System.out.println("\n---- MENU FATURAS----");
			System.out.println("1. Gerar Fatura para Imóvel");
			System.out.println("2. Listar Todas as Faturas");
			System.out.println("3. Listar Faturas em Aberto");
			System.out.println("4. Voltar ao Menu Principal");
			System.out.print("Escolha uma opção: ");
			escolha = scanner.nextInt();

			switch (escolha) {
			case 1:
				gerarFatura();
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

	private static void gerarFatura() {
		System.out.println("Digite a matrícula do imóvel: ");
		int matriculaImovel = scanner.nextInt();

		Optional<Imovel> imovelEncontrado = imoveis.stream().filter(imovel -> imovel.getMatricula() == matriculaImovel)
				.findFirst();

		if (imovelEncontrado.isPresent()) {
			Imovel imovel = imovelEncontrado.get();

			int leituraAtual = imovel.getUltimaLeitura();
			int leituraAnterior = imovel.getPenultimaLeitura();
			double consumo = leituraAtual - leituraAnterior;

			double custoPorKWh = 9.89;
			double valorFatura = consumo * custoPorKWh;

			Fatura novaFatura = new Fatura(leituraAnterior, leituraAtual, valorFatura);
			faturas.add(novaFatura);

			imovel.setLeituraAnterior(leituraAtual);

			System.out.println("Fatura gerada com sucesso!");
		} else {
			System.out.println("Imóvel não foi encontrado. Não é possível gerar a fatura.");
		}
	}

	private static void listarTodasFaturas() {
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

	private static void listarFaturasEmAberto() {
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

	private static void menuPagamentos() {
		int escolha;
		do {
			System.out.println("\n---- MENU PAGAMENTOS ----");
			System.out.println("1. Incluir Pagamento");
			System.out.println("2. Listar Todos os Pagamentos");
			System.out.println("3. Listar Pagamentos de uma Fatura");
			System.out.println("4. Voltar ao Menu Principal");
			System.out.print("Escolha uma opção: ");
			escolha = scanner.nextInt();

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

	private static void incluirPagamento() {
		System.out.println("--- Inclusão de Pagamento ---");

		System.out.println("Digite o ID da fatura do pagamento: ");
		int idFatura = scanner.nextInt();
		Fatura fatura = encontrarFaturaPorId(idFatura);
		scanner.nextLine();

		if (fatura == null) {
			System.out.println("Fatura não encontrada.");
			return;
		}

		System.out.println("Digite o valor do pagamento: ");
		float valorPagamento = scanner.nextFloat();
		scanner.nextLine();

		Pagamento novoPagamento = new Pagamento(idFatura, valorPagamento);
		pagamentos.add(novoPagamento);

		verificarQuitacaoFatura(fatura, novoPagamento);
		System.out.println("Pagamento registrado com sucesso!");
	}

	private static void listarTodosPagamentos() {
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

	private static void listarReembolsos() {
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

	private static void verificarQuitacaoFatura(Fatura fatura, Pagamento pagamento) {
		if (fatura != null && !fatura.isQuitado()) {
			fatura.adicionarPagamento(pagamento);

			if (fatura.isQuitado()) {
				double valorEmExcesso = (fatura.getValorPago() - fatura.getValorCalculado());
				if (valorEmExcesso > 0) {
					Reembolso novoReembolso = new Reembolso(fatura.getIdFatura(), valorEmExcesso,
							Calendar.getInstance());
					reembolsos.add(novoReembolso);
				}
			}
		}
	}

	private static Fatura encontrarFaturaPorId(int idFatura) {
		for (Fatura fatura : listaDeFaturas) {
			if (fatura.getIdFatura() == idFatura) {
				return fatura;
			}
		}
		return null;
	}

	private static void menuFalhasReparos() {
		int escolha;
		do {
			System.out.println("\n---- MENU FALHAS E REPAROS ----");
			System.out.println("1. Incluir Falha");
			System.out.println("2. Listar Falhas em Aberto");
			System.out.println("3. Submenu Reparos");
			System.out.println("4. Voltar ao Menu Principal");
			System.out.print("Escolha uma opção: ");
			escolha = scanner.nextInt();

			switch (escolha) {
			case 1:
				incluirFalha();
				break;
			case 2:
				listarFalhasAberto();
				break;
			case 3:
				submenuReparos();
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

	private static void incluirFalha() {
		System.out.println("\n---- INCLUIR FALHA ----");
		System.out.println("Digite a matrícula do imóvel:");
		String matriculaImovel = scanner.next();

		Imovel imovelEncontrado = encontrarImovelPorMatricula(matriculaImovel);
		if (imovelEncontrado == null) {
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

	private static void listarFalhasAberto() {

	}

	private static void submenuReparos() {
		int escolha;
		do {
			System.out.println("\n---- MENU REPAROS ----");
			System.out.println("1. Listar Reparos em Aberto");
			System.out.println("2. Encerrar Reparo");
			System.out.println("3. Voltar ao Menu Falhas e Reparos");
			System.out.print("Escolha uma opção: ");
			escolha = scanner.nextInt();

			switch (escolha) {
			case 1:
				listarReparosEmAberto();
				break;
			case 2:
				encerrarReparo();
				break;
			case 0:
				System.out.println("Retornando ao Menu Falhas e Reparos.");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}
		} while (escolha != 0);
	}

	private static void incluirReparo() {
		System.out.println("--- Inclusão de Reparo ---");

		System.out.println("Digite o ID da falha associada ao reparo: ");
		int idFalha;
		try {
			idFalha = scanner.nextInt();
			scanner.nextLine();
		} catch (Exception e) {
			System.out.println("Entrada inválida para o ID da falha. Certifique-se de inserir um número inteiro.");
			scanner.nextLine(); 
			return;
		}

		System.out.println("Digite a descrição da atividade de reparo: ");
		String descricaoAtividade = scanner.nextLine();

		Reparo novoReparo = new Reparo(reparos.size() + 1, idFalha, descricaoAtividade, Calendar.getInstance());
		reparos.add(novoReparo);
		System.out.println("Reparo registrado com sucesso.");
	}

	private static void listarReparosEmAberto() {
		System.out.println("--- Lista de Reparos em Aberto ---");

		boolean encontrouReparoEmAberto = false;

		for (Reparo reparo : reparos) {
			if (!reparo.isResolvido()) {
				System.out.println("ID do Reparo: " + reparo.getId());
				System.out.println("Descrição da Atividade: " + reparo.getDescricaoAtividade());
				System.out.println("------------------------");
				encontrouReparoEmAberto = true;
			}
		}

		if (!encontrouReparoEmAberto) {
			System.out.println("Nenhum reparo em aberto encontrado.");
		}
	}

	private static void encerrarReparo() {
		System.out.println("--- Encerramento de Reparo ---");

		System.out.println("Digite o ID do reparo a ser encerrado: ");
		int idReparo;
		try {
			idReparo = scanner.nextInt();
			scanner.nextLine(); 
		} catch (Exception e) {
			System.out.println("Entrada inválida para o ID do reparo. Certifique-se de inserir um número inteiro.");
			scanner.nextLine(); 
			return;
		}

		Reparo reparo = encontrarReparoPorId(idReparo);

		if (reparo != null && !reparo.isResolvido()) {
			reparo.setResolvido(true);
			reparo.setDataFim(Calendar.getInstance());

			System.out.println("Reparo encerrado com sucesso!");
		} else {
			System.out.println("Reparo não encontrado ou já encerrado.");
		}
	}

	private static Imovel encontrarImovelPorMatricula(int matricula) {
		for (Imovel imovel : imoveis) {
			if (imovel.getMatricula() == matricula) {
				return imovel;
			}
		}
		return null;
	}

	private static Reparo encontrarReparoPorId(int idReparo) {
		for (Reparo reparo : reparos) {
			if (reparo.getId() == idReparo) {
				return reparo;
			}
		}
		return null;
	}

}