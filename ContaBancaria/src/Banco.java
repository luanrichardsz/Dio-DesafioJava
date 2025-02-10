import java.util.Scanner;
import java.util.ArrayList; //Lista Dinamica
import java.util.Random;

public class Banco {

    Scanner scanner = new Scanner(System.in);
    Random gerador = new Random();
    ArrayList<Conta> contas = new ArrayList<>();

    class Conta {
        private String nomeCliente;
        private String numeroAgencia;
        private int numeroConta;
        private double saldo;

        public Conta(String nomeCliente, String numeroAgencia, int numeroConta, double saldo) {
            this.nomeCliente = nomeCliente;
            this.numeroAgencia = numeroAgencia;
            this.numeroConta = numeroConta;
            this.saldo = saldo;
        }

        public String getNomeCliente() {
            return nomeCliente;
        }

        public String getNumeroAgencia() {
            return numeroAgencia;
        }

        public int getNumeroConta() {
            return numeroConta;
        }

        public double getSaldo() {
            return saldo;
        }

        public void depositar(double valor) {
            if (valor > 0) {
                this.saldo += (valor);
                System.out.println("Deposito de R$" + valor + " realizado com sucesso!");
            } else {
                System.out.println("Valor invalido para deposito.");
            }
        }
    }

    ArrayList<String> nomeCliente = new ArrayList<>();
    ArrayList<String> numeroAgencia = new ArrayList<>();
    ArrayList<Integer> numeroConta = new ArrayList<>();
    ArrayList<Double> saldo = new ArrayList<>();

    public void cadastrar() {

        System.out.print("Digite seu nome: ");
        String nomeCliente = scanner.nextLine();

        int tresDigitos = gerador.nextInt(999);
        int numeroFinal = gerador.nextInt(9);
        String agencia = String.format("%03d-%d", tresDigitos, numeroFinal);

        int contaNumero = gerador.nextInt(9999);

        Conta contaNova = new Conta(nomeCliente, agencia, contaNumero, 0.0);
        contas.add(contaNova);

        System.out.println("Olá, " + nomeCliente + "!");
        System.out.println("Obrigado por criar uma conta em nosso banco, sua agência é " + agencia + ", conta " + contaNumero);
        System.out.println("Seu saldo já está disponível para movimentações. Para fazer seu primeiro deposito digite 1. Se não, digite qualquer outro número!");

        int opcaoDeposito = scanner.nextInt();
        if (opcaoDeposito == 1) {
            System.out.print("Digite o valor do deposito: ");
            double valor = scanner.nextDouble();
            System.out.print(" ");
            contaNova.depositar(valor);
        }

        System.out.println(contaNova.numeroAgencia);
    }

    public void entrar() {
        System.out.print("Digite sua agência(com o travessão): ");
        String agenciaBuscar = scanner.nextLine();

        System.out.print("Digite o número da sua conta: ");
        int numeroBuscar = scanner.nextInt();

        for (Conta conta : contas) {
            if( conta.getNumeroAgencia().equals(agenciaBuscar) && conta.getNumeroConta() == numeroBuscar ) {
                System.out.println("Bem Vindo, " + conta.getNomeCliente() + "!");
                
            }
        }
    }
}





