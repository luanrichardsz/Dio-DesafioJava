import java.util.Scanner;
import java.util.ArrayList; //Lista Dinamica
import java.util.Random;

public class ContaBancaria {

    Banco banco = new Banco();
    Scanner scanner = new Scanner(System.in);
    Random gerador = new Random();
    Conta contaB = new Conta();


    private static ArrayList<Conta> contas = new ArrayList<>();

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
        System.out.println("Seu saldo já está disponível para movimentações. Para fazer seu primeiro deposito digite 1. Se não, digite qualquer outro número para sair!");

        int opcaoDeposito = scanner.nextInt();
        if (opcaoDeposito == 1) {
            depositar();
        } else {
            banco.startar();
        }
    }

    public void entrar() {
        System.out.print("Digite sua agência(com o travessão): ");
        String agenciaBuscar = scanner.nextLine();

        System.out.print("Digite o número da sua conta: ");
        int numeroBuscar = scanner.nextInt();
        scanner.nextLine();

        boolean contaEncontrada = false;
        for (Conta conta : contas) {
            if (conta.getNumeroAgencia().equals(agenciaBuscar) && conta.getNumeroConta() == numeroBuscar) {
                System.out.println("Bem Vindo, " + conta.getNomeCliente() + "!");
                contaEncontrada = true;
                menu();
            }
        }
        if(!contaEncontrada) {
            System.out.println("Conta não encontrada. Tente novamente!");
        }
    }

    public void depositar(){
        System.out.print("Digite o valor do deposito: ");
        double valor = scanner.nextDouble();
        System.out.print(" ");
        contaB.deposito(valor);
    }

    public void sacar(){
        System.out.print("Digite o valor do saque: ");
        double valor = scanner.nextDouble();
        System.out.print(" ");
        contaB.saque(valor);
    }

    public void menu(){
        while (true) {
            System.out.println("O que você deseja?");
            System.out.println("Deposito - 1");
            System.out.println("Saque - 2");
            System.out.println("Saldo - 3");
            System.out.println("Sair - 0");
            System.out.println("Digite o número da função desejada:");
            int entradaMenu = scanner.nextInt();

            if (entradaMenu == 1) {
                depositar();
            } else if (entradaMenu == 2) {
                sacar();
            } else if (entradaMenu == 3) {
                contaB.verSaldo();
            } else if (entradaMenu == 0) {
                System.out.println("Saindo do menu");
                banco.startar();
                break;
            } else {
                System.out.println("Entrada Invalida. Tente Novemente!");
            }
        }
        scanner.close();
    }
}



