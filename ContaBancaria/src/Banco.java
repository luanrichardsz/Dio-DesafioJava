import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {
        startar();
    }

    public static void startar() {
        Scanner ler = new Scanner(System.in);
        ContaBancaria contaB = new ContaBancaria();

        System.out.println(" Bem Vindo ao Banco Proative");

        System.out.println("Você é novo aqui?");
        System.out.println("Se sim Digite 1.");
        System.out.println("Se não Digite 2.");

        while (true) {
            int entradaUsuario = ler.nextInt();
            if (entradaUsuario == 1) {
                contaB.cadastrar();
                break;
            } else if (entradaUsuario == 2) {
                contaB.entrar();
                break;
            } else {
                System.out.println("Entrada Invalida. Tente Novamente");
            }
        }
        ler.close();
    }
}