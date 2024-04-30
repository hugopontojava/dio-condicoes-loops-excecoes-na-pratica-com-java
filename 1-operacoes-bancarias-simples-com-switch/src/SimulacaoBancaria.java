import java.util.Scanner;

public class SimulacaoBancaria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double saldo = 0;
        System.out.println("Esse é um simulador bancário");
            // TODO: tratamento de execções e facilitar a compreensão do código
        while (true) {
            System.out.println("------------------ \n" +
                    "Escolha umas das opções: \n" +
                    "1 - Depositar \n" +
                    "2 - Sacar \n" +
                    "3 - Saldo \n" +
                    "0 - Encerrar \n" +
                    "------------------");
            double valor;
            int opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Insira o valor a ser depositado...");
                    valor = sc.nextDouble();
                    saldo += valor;
                    break;
                case 2:
                    System.out.println("Insira o valor a ser sacado...");
                    valor = sc.nextDouble();
                    saldo -= valor;
                    break;
                case 3:
                    System.out.println("Você tem R$" + saldo + " de saldo.");
                    break;
                case 0:
                    System.out.println("Finalizando simulação...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}