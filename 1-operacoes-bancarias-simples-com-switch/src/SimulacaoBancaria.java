import java.util.Scanner;

public class SimulacaoBancaria {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        double saldo = 0;
        double valor;
        boolean loop = true;
        System.out.println("Esse é um simulador bancário");
            // TODO: tratamento de execções e facilitar a compreensão do código
        while (loop == true) {
            System.out.println("------------------ \n" +
                    "Escolha umas das opções: \n" +
                    "1 - Depositar \n" +
                    "2 - Sacar \n" +
                    "3 - Saldo \n" +
                    "0 - Encerrar \n" +
                    "------------------");
            int opcao = Integer.parseInt(String.valueOf(sc.nextInt()));
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
                    // TODO: achar uma maneira mais "simples" de finalizar o loop
                    System.out.println("Finalizando simulação...");
                    Thread.sleep(1000);
                    loop = false;
                    System.out.println("Simulação encerrada com sucesso!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}