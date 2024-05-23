import java.util.Scanner;

public class VerificacaoChequeEspecial {
    public static void main(String[] args) throws LimiteExceditoException {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Digite o saldo desejado:");
            double saldo = sc.nextDouble();
            System.out.println("Digite o valor a ser sacado:");
            double saque = sc.nextDouble();
            saca(saldo, saque);
        } catch (LimiteExceditoException ex) {
            System.out.println(ex.getMessage());
        } finally {
            sc.close();
        }
    }

    // Sem funcionalidade de saque porque não foi pedido
    public static void saca (double saldo, double saque) throws LimiteExceditoException{
        double limiteChequeEspecial = 500;
        if (saque > saldo) {
            if (saque > limiteChequeEspecial) {
                throw new LimiteExceditoException("Transação não realizada! Limite do cheque especial excedido");
            } else {
                System.out.println("Transação realizada com sucesso utilizando o cheque especial.");
            }
        } else {
            System.out.println("Transação realizada com sucesso.");
        }
    }

    public static class LimiteExceditoException extends Exception {
        public LimiteExceditoException(String msg) {
            super(msg);
        }
    }
}