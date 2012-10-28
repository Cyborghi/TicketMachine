package ticket.machine;

public class TicketMachine {
	
	protected int saldo;
	protected int precoBilhete;
	
	protected static int localizador = 1;
	
	TicketMachine (int precoBilhete) {
		this.precoBilhete = precoBilhete;
	}
	
	public void inserir (int quantia) throws PapelMoedaInvalidaException {
		if (!this.validaQuantia(quantia)) {
			throw new PapelMoedaInvalidaException();
		} else {
			this.saldo += quantia;
		}
	}
	
	public int getSaldo() {
		return this.saldo;
	}
	
	public int getTroco() {
		int troco = 0;
		//this.saldo = 0;
		
		while (this.saldo >= 2)
		{
			if(this.saldo >= 100)
			{
				this.saldo -= 100;
				troco += 100;
			}
			else
				if(this.saldo >= 50)
				{
					this.saldo -= 50;
					troco += 50;
				}
				else
					if(this.saldo >= 20)
					{
						this.saldo -= 20;
						troco += 20;
					}
					else
						if(this.saldo >= 10)
						{
							this.saldo -= 10;
							troco += 10;
						}
						else
							if(this.saldo >= 5)
							{
								this.saldo -= 5;
								troco += 5;
							}
							else
								if(this.saldo >= 2)
								{
									this.saldo -= 2;
									troco += 2;
								}
		}
		return troco;
	}
	
	public void imprimir() {
		if (this.saldo >= this.precoBilhete) {
			this.saldo -= this.precoBilhete;
			System.out.println("Bilhete impresso: " + localizador++ );
		} else {
			System.out.println("Você não tem saldo suficiente.");
		}
		this.imprimeSaldo();
	}
	
	public void imprimeSaldo() {
		System.out.println("Saldo atual:");
		System.out.format("R$ %d\n", this.getSaldo());
	}
	
	public boolean validaQuantia(int quantia) {
		switch (quantia) {
		case 2:
		case 5:
		case 10:
		case 20:
		case 50:
		case 100:
			return true;
		default:
			return false;
		}
	}
}
