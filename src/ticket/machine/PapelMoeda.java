package ticket.machine;

public class PapelMoeda {
	protected int valor;
	protected int quantidade;
	
	public PapelMoeda(int valor, int quantidade) {
		 this.valor = valor;
		 this.quantidade = quantidade;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getValor() {
		return valor;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
}

