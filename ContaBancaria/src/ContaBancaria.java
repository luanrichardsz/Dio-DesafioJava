import java.util.Scanner;

public class ContaBancaria {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Usuario conta = new Usuario();

        System.out.println(" Bem Vindo ao Banco Proative");


        System.out.println("Você é novo aqui?");
        System.out.println("Se sim Digite 1.");
        System.out.println("Se não Digite 2.");

        while (true) {
            int entradaUsuario = ler.nextInt();
            if (entradaUsuario == 1) {
                conta.entrar();
                break;
            } else if (entradaUsuario == 2) {
                conta.cadastrar();
                break;
            } else {
                System.out.println("Entrada Invalida. Tente Novamente");
            }
        }
        ler.close();
    }
}