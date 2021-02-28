import java.util.Scanner;

public class Conta {

	// Vari�veis da classe
	double saldo;
	double transacaoAnterior;
	String nomeCliente;
	String idCliente;
	boolean transacaoValida;

	// Construtor da classe
	Conta(String nome, String id) {
		nomeCliente = nome;
		idCliente = id;
	}

	// Fun��o para dep�sito
	void deposita(double valor) {
		if (valor > 0) {
			this.saldo += valor;
			transacaoAnterior = valor;
		}
	}

	// Fun��o para saque
	void saca(double valor) {
		if (valor <= saldo) {
			this.saldo -= valor;
			transacaoAnterior = -valor;
		} else {
			transacaoValida = false;
			System.out.println("Saldo insuficiente!");
		}
	}

	// Fun��o para mostrar transa��o anterior
	void getTransacaoAnterior() {
		if (transacaoAnterior > 0) {
			System.out.println("Depositou: " + transacaoAnterior);
		} else if (transacaoAnterior < 0) {
			System.out.println("Sacou: " + Math.abs(transacaoAnterior));
		}
	}

	// Calcular rendimento
	void calcularRendimento(int anos) {
		double juros = .0185;
		double novoSaldo = (saldo * juros * anos) + saldo;
		double taxaAtual = (float) Math.round(juros * 100);
		System.out.println("A taxa de juros atual �: " + (taxaAtual));
		System.out.println("Depois de " + anos + " anos, seu saldo ser� de: " + novoSaldo);
	}

	// Fun��o do menu principal
	void mostraMenu() {
		char opcao = '\0';
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ol�, " + nomeCliente + "!");
		System.out.println("Sua conta �: " + idCliente + ".");
		System.out.println();
		System.out.println("O que gostaria de fazer?");
		System.out.println("A. Ver meu saldo.");
		System.out.println("B. Fazer um dep�sito.");
		System.out.println("C. Fazer um saque.");
		System.out.println("D. Verificar �ltima opera��o.");
		System.out.println("E. Calcular rendimento da conta.");
		System.out.println("F. Sair.");

		do {
			System.out.println();
			System.out.println("Digite a letra: ");
			char opcao1 = scanner.next().charAt(0);
			opcao = Character.toUpperCase(opcao1);
			System.out.println();
			switch (opcao) {
			// Exibe saldo
			case 'A':
				System.out.println("===================");
				System.out.println("Saldo: R$ " + saldo);
				System.out.println("===================");
				System.out.println();
				break;
			// Dep�sito
			case 'B':
				System.out.println("Digite o valor a ser depositado: ");
				double valor = scanner.nextDouble();
				deposita(valor);
				System.out.println();
				break;
			// Saque
			case 'C':
				System.out.println("Digite a quantia a ser sacada: ");
				double valor2 = scanner.nextDouble();
				saca(valor2);
				System.out.println();
				break;
			// Verificar �ltima transa��o
			case 'D':
				System.out.println("===================");
				getTransacaoAnterior();
				System.out.println("===================");
				System.out.println();
				break;
			// Rendimento
			case 'E':
				System.out.println("===================");
				System.out.println("Digite o n�mero de anos: ");
				int anos = scanner.nextInt();
				calcularRendimento(anos);
				System.out.println("===================");
				break;
			// Sair do sistema
			case 'F':
				System.out.println("===================");
				break;
			default:
				System.out.println("Erro: op��o inv�lida. Por favor, digite A, B, C, D, E ou F");
				break;
			}

		} while (opcao != 'F');
		System.out.println("Obrigado por escolher nosso banco!");

	}
}
