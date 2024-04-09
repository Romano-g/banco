import java.util.Scanner;

public class ContaCorrente {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		double saldoInicial = 2000.0;
		String mostrarSaldoAtual = """
				\n---------------------------------------------------------------
				Cliente:										Vickvi Rabello
				Tipo de conta:  								Corrente
				Saldo atual:    								R$ %.2f
				---------------------------------------------------------------
				""";

		System.out.printf(mostrarSaldoAtual, saldoInicial);

		double saldoAtual = saldoInicial;
		int escolhaCliente = 0;


		while (escolhaCliente != 4) {
			System.out.println("""
				\nSelecione uma opção:
				1 - Consultar saldo;
				2 - Receber valor;
				3 - Transferir valor;
				4 - Sair;
				""");
			escolhaCliente = leitor.nextInt();

			switch (escolhaCliente) {
				case 1:
					System.out.printf(mostrarSaldoAtual, saldoAtual);
					continue;

				case 2:
					System.out.println("\nDigite o valor a ser recebido:");
					double valorRecebido = leitor.nextDouble();

					if (valorRecebido > 0) {
						saldoAtual += valorRecebido;
						System.out.printf(mostrarSaldoAtual, saldoAtual);
						continue;
					}

					System.out.println("\nValor inválido.");
					System.out.printf(mostrarSaldoAtual, saldoAtual);
					continue;

				case 3:
					System.out.println("\nDigite o valor a ser transferido:");
					double valorTranferencia = leitor.nextDouble();

					if (valorTranferencia <= saldoAtual && valorTranferencia > 0) {
						saldoAtual -= valorTranferencia;
						System.out.printf(mostrarSaldoAtual, saldoAtual);
						continue;
					}

					System.out.println("\nSaldo insuficiente");
					System.out.printf(mostrarSaldoAtual, saldoAtual);
					continue;

				case 4:
					System.out.println("\nEncerrando operações.");
					break;

				default:
					System.out.println("\nOpção inválida.");
			}
		}
	}
}
