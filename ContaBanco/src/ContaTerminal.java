import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner (System.in);
        
        System.out.println("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();

        String numeroAgencia = "";
        boolean agenciaValida = false;
        String numAgcForm = "";

        while (!agenciaValida) {
            System.out.println("Digite o número da agência: ");
            numeroAgencia = scanner.next();

            if (numeroAgencia.length() > 1) {
                agenciaValida = true; 
                numAgcForm = numeroAgencia.substring(0, numeroAgencia.length() - 1) + "-" + numeroAgencia.charAt(numeroAgencia.length() - 1);
            } else {
                System.out.println("Número da Agência inválido! Tente novamente.");
            }
        }

        System.out.println("Digite seu nome: ");
        String nomeCliente = scanner.next();

        float saldo = 0f;

        String mensagem = String.format(
            "Olá %s, obrigado por criar uma conta em nosso banco. Sua agência é %s, conta %d e seu saldo disponível é R$ %.2f.",
            nomeCliente, numAgcForm, numeroConta, saldo
        );
        System.out.println(mensagem);

        int numeroDigitado;

        do {
            System.out.println("Digite 1 para depósito, 2 para saque e 0 para sair: ");
            numeroDigitado = scanner.nextInt();

            switch(numeroDigitado) {
                case 1:
                    System.out.println("Digite o valor do seu depósito: ");
                    float valorDeposito = scanner.nextFloat();
                    saldo += valorDeposito;
                    System.out.printf("Seu saldo agora é de R$ %.2f.\n", saldo);
                    break;
                case 2:
                    System.out.println("Digite o valor do saque: ");
                    float valorSaque = scanner.nextFloat();
                    if (valorSaque > saldo) {
                        System.out.println("Não é possível sacar, valor de saque superior ao saldo!");
                    } else {
                        saldo -= valorSaque;
                        System.out.printf("Saque realizado, seu saldo atual é de R$ %.2f.\n", saldo);
                    }
                    break;
                case 0:
                    System.out.println("Você saiu da conta.");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (numeroDigitado != 0);

        scanner.close();
    }
}
