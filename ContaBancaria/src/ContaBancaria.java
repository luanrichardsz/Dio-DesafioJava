import java.util.Scanner;

public class ContaBancaria {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Banco banco = new Banco();

        System.out.println(" Bem Vindo ao Banco Proative");


        System.out.println("Você é novo aqui?");
        System.out.println("Se sim Digite 1.");
        System.out.println("Se não Digite 2.");

        while (true) {
            int entradaUsuario = ler.nextInt();
            if (entradaUsuario == 1) {
                banco.entrar();
                break;
            } else if (entradaUsuario == 2) {
                banco.cadastrar();
                break;
            } else {
                System.out.println("Entrada Invalida. Tente Novamente");
            }
        }
        ler.close();
    }
}