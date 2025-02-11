public class Conta {
    private String nomeCliente;
    private String numeroAgencia;
    private int numeroConta;
    private double saldo;

    public Conta() {
        this.nomeCliente = "";
        this.numeroAgencia = "";
        this.numeroConta = 0;
        this.saldo = 0.0;
    }

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

    public void deposito(double valor) {
        if (valor > 0) {
            this.saldo += (valor);
            System.out.println("Deposito de R$" + valor + " realizado com sucesso!");
        } else {
            System.out.println("Valor invalido para deposito.");
        }
    }

    public void saque(double valor) {
        if (valor < saldo) {
            this.saldo -= (valor);
            System.out.println("Saque de R$" + valor + " realizado com sucesso!");
        } else {
            System.out.println("Valor invalido para saque.");
        }
    }

    public void verSaldo(){
        System.out.println("Seu saldo: R$" + saldo + ".");
    }
}
