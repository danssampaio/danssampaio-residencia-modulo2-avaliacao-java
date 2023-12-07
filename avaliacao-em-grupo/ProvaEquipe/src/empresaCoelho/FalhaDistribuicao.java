package empresaCoelho;

	class FalhaDistribuicao extends Falha {
		
		private Reparo reparo;
		
	    public FalhaDistribuicao(Imovel imovel, String descricao, String previsao, LocalDate dataInicio) {
	        super(imovel, descricao, previsao, dataInicio);
	        reparo = criaReparo();
	    }
	}
}
