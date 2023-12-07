package empresaCoelho;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Reparo {
	private static int contadorReparos = 0;

	private int numero;
	private String descricao;
	private String previsao;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private boolean resolvido;
	private Falha falha;

	public Reparo(Falha falha, String descricao, String previsao, LocalDate dataInicio) {
		this.numero = ++contadorReparos;
		this.falha = falha;
		this.descricao = descricao;
		this.previsao = previsao;
		this.dataInicio = dataInicio;
		this.resolvido = false;
	}


	public int getNumero() {
		return numero;
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
	
	public LocalDate getDataInicio() {
        return dataInicio;
    }
	
	public LocalDate getDataFim() {
        return dataFim;
    }
	
	public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
	
	public String getDescricao() {
	        return descricao;
	}
	 
	public String getPrevisao() {
	        return previsao;
	}
	 
	public static List<Reparo> reparosEmAberto(List<Reparo> reparos) {
		 List<Reparo> reparosEmAberto = new ArrayList<>();
		 for (Reparo reparo : reparos) {
			 if (!reparo.isResolvido()) {
				 reparosEmAberto.add(reparo);
             }
		 }
		 return reparosEmAberto;
    }
	 
	public static void encerrarReparo(Reparo reparo, boolean resolvido, String descricaoNovoReparo, Falha falha) {
		 reparo.setResolvido(resolvido);
	     if (resolvido) {
	    	 reparo.setDataFim(LocalDate.now());
	     }
	}

	public Falha getFalha() {
		return falha;
	}
}