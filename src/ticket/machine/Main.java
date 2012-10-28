package ticket.machine;

import java.util.Scanner;

public class Main {
	
	static Scanner in = new Scanner(System.in);
	public static void main (String [] args) {
		TicketMachine ticketMachine;
		int option;
		
		ticketMachine = new TicketMachine(3);
		int quantia = 0;
		int troco = 0;
		
		option = getOption();
		while (option != 5) {
			switch(option) {
			case 1:
				quantia = getQuantia();
				try {
					ticketMachine.inserir(quantia);
					ticketMachine.imprimeSaldo();
				} catch (PapelMoedaInvalidaException e) {
					System.out.println("Você inseriu uma nota inválida.");
					System.out.println("Notas válidas: 2, 5, 10, 20, 50 ou 100.");
					System.out.println("Retire a nota e tente novamente.\n\n");
				}
				break;
			case 2:
				ticketMachine.imprimir();
				break;
			case 3:
				ticketMachine.imprimeSaldo();
				break;
			case 4:
				troco = ticketMachine.getTroco();
				System.out.format("Troco devolvido: %d\n", troco);
				ticketMachine.imprimeSaldo();
				break;
			}
			option = getOption();
		}
		
		System.out.println("Obrigado e até mais.");
	}
	
	public static int getOption() {
		int opt = 0;
		do {
			System.out.println("Informe a opção desejada:");
			System.out.println("\t1 - Inserir dinheiro.");
			System.out.println("\t2 - Imprimir Bilhete.");
			System.out.println("\t3 - Checar Saldo.");
			System.out.println("\t4 - Solicitar troco.");
			System.out.println("\t5 - Sair.");
			
			opt = in.nextInt();
			
		} while (opt < 1 || opt > 5);
		
		return opt;
	}
	
	public static int getQuantia() {
		int quantia = 0;
		System.out.println("Digite a quantia a ser inserida:");
		quantia = in.nextInt();
		return quantia;
	}
	
	
}
