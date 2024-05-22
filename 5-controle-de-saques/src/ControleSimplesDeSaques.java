import java.util.Scanner;

public class ControleSimplesDeSaques {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Digite o saldo da conta:");
            double limiteDiario = sc.nextDouble();
            if (limiteDiario <= 0) {
                sc.close();
            }
            for (double i = 0; i < limiteDiario; i++) {
                System.out.println("Digite o quanto deseja sacar:");
                double valorSaque = sc.nextDouble();
                if (valorSaque <= limiteDiario) {
                    limiteDiario -= valorSaque;
                    System.out.println("Saque realizado.");
                    System.out.println("Limite restante: " + limiteDiario);
                } else {
                    throw new LimiteAtingidoException("Limite diário de saque atingido");
                }
            }
        } catch (LimiteAtingidoException ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Transações encerradas.");
            sc.close();
        }
    }

    public static class LimiteAtingidoException extends Exception {
        public LimiteAtingidoException(String msg) {
            super(msg);
        }
    }
}