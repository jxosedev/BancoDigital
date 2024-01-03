package programa;

import util.Utils;

public class Conta {

    private static int contadorDeContas = 1;
    private int numeroConta;
    private  Cliente cliente;
    private Double saldo = 0.0 ;

    public Conta(Cliente cliente) {
        this.numeroConta = numeroConta;
        this.cliente = cliente;
        this.saldo = saldo;
        contadorDeContas += 1;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    //esse to string vai servir pra mostrar os dados da conta do cliente e com o valor ja formatado com o Utils
   public String toString() {
        return "\nNúmero da conta: " + this.getNumeroConta() +
                "\nNome: " + this.cliente.getNome() +
                "\nCPF: " + this.cliente.getCpf() +
                "\nEmail " + this.cliente.getEmail() +
                "\nSaldo " + Utils.doubleToString(this.getSaldo()) +
                "\n";
   }

   //classe para os depositos
   public void depositar(Double valor) {
        if(valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println("Seu deposito foi feito com sucesso !!");
        }else {
            System.out.println("Não foi possivel realizar o deposito, insira um valor maior que 0 !!");
        }
   }
    // classe para sacar
   public void sacar(Double valor) {
        if (valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            System.out.println("Seu saque foi efetuado com sucesso !!");
        }else {
            System.out.println("Não foi possivel realizar o saque !");
        }
   }
    // classe para transferir
   public void transferir(Conta contaDestino, Double valor) {
        if (valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);

            contaDestino.saldo = contaDestino.getSaldo() + valor;
            System.out.println("Transferencia realizada com sucesso.");
        }else {
            System.out.println("Não foi possivel realizar a sua transferencia !");
        }
   }
}
