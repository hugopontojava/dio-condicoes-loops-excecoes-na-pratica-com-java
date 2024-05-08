import java.util.Scanner;

public class SimulacaoBancaria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double saldo = 0;

        while (true) {
            System.out.println("------------------ \n" +
                    "Escolha umas das opções: \n" +
                    "1 - Depositar \n" +
                    "2 - Sacar \n" +
                    "3 - Saldo \n" +
                    "0 - Encerrar \n" +
                    "------------------");
            int opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("INSIRA O VALOR A SER DEPOSITADO...");
                    try {
                        saldo = deposita(saldo);
                    } catch (ValorNaoSuportadoException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("INSIRA O VALOR A SER SACADO...");
                    try {
                        saldo = saca(saldo);
                    } catch (SaldoInsuficienteException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Saldo atual: R$" + saldo);
                    break;
                case 0:
                    System.out.println("Encerrando simulação...");
                    // Usando System.exit por enquanto porque não tenho um tratamento para o erro de sc.close()
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // Operações
    public static double deposita(double saldo) throws ValorNaoSuportadoException{
        Scanner sc = new Scanner(System.in);
        double valor = sc.nextDouble();
        if (valor <= 0) {
            throw new ValorNaoSuportadoException("Valor não suportado");
        } else {
            return saldo + valor;
        }
    }
    public static double saca(double saldo) throws SaldoInsuficienteException {
        Scanner sc = new Scanner(System.in);
        double valor = sc.nextDouble();
        if (saldo < valor) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        } else {
            return saldo - valor;
        }
    }

    // Exceptions
    public static class SaldoInsuficienteException extends Exception {
        public SaldoInsuficienteException(String msg) {
            super(msg);
        }
    }
    public static class ValorNaoSuportadoException extends Exception {
        public ValorNaoSuportadoException(String msg) {
            super(msg);
        }
    }
}