package programa;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static Scanner entrada = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {

    contasBancarias = new ArrayList<Conta>();
    operacoes();
    }

    public static void operacoes() {
        System.out.println("------------------------------------------------------");
        System.out.println("---------------- Menu de Operações -------------------");
        System.out.println("------------------------------------------------------");
        System.out.println("1- Criar Conta");
        System.out.println("2- Depositar");
        System.out.println("3- Sacar");
        System.out.println("4- Transferir");
        System.out.println("5- Listar");
        System.out.println("6- Sair");
        System.out.println("Digite um numero de acordo com a operaçã desejada:  ");
        int operacao = entrada.nextInt();

        switch (operacao){
            case 1:
                criarConta();
                break;

            case 2:
                depositar();
                break;

            case 3:
                sacar();
                break;

            case 4:
                transferir();
                break;

            case 5:
                listar();
                break;

            case 6:
                System.out.println("Você saiu !");
                System.exit(0);

            default:
                System.out.println("Opção inválida !!!!");
                operacoes();
                break;
        }
    }

    public static void criarConta() {

        System.out.println("Nome: ");
        String nome = entrada.next();

        System.out.println("CPF: ");
        String cpf = entrada.next();

        System.out.println("Email: ");
        String email = entrada.next();

        Cliente cliente = new Cliente(nome, cpf, email);

        Conta conta = new Conta(cliente);
        System.out.println("Sua conta foi criada com sucesso !!");

        operacoes();

    }

    //aqui ele confere se a conta que vai receber o dinheiro da transferecia existe
    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if(contasBancarias.size() > 0) {// verifico se existe conta bancaria dentro da agencia e vejo cada conta
            for (Conta c: contasBancarias) {
                if (c.getNumeroConta() == numeroConta);// se tiver a conta que o usuario digitou
                conta = c;
            }
        }
        return conta;
    }

    public static void depositar() {
        System.out.println("Insira o numero da conta para deposito: ");
        int numeroConta = entrada.nextInt();

        Conta conta = encontrarConta(numeroConta);// aqui ele chama o numero da conta que o usuario digitou e aplica o valor

        if(conta != null) {
            System.out.println("Insira o valor que deseja depositar.");
            Double valorDeposito = entrada.nextDouble();
            conta.depositar(valorDeposito);
            System.out.println("O valor foi depositado com sucesso !!");
        }else{
            System.out.println("A conta destino para o deposito não foi encontrada !!");
        }
        operacoes();

    }

    public static void sacar() {
        System.out.println("Insira o numero da conta para deposito: ");
        int numeroConta = entrada.nextInt();

        Conta conta = encontrarConta(numeroConta);// aqui ele chama o numero da conta que o usuario digitou e aplica o valor

        if(conta != null) {
            System.out.println("Insira o valor que deseja sacar.");
            Double valorSaque = entrada.nextDouble();
            conta.sacar(valorSaque);
            System.out.println("O valor foi sacado com sucesso !!");
        }else{
            System.out.println("A conta destino para o saque não foi encontrada !!");
        }
        operacoes();
    }

    // aqui verifica se a conta de destino e a de envio existe, faz a validação e depois a operação
    public static void transferir(){
        System.out.println("Insira o numero da conta do remetente: ");
        int numeroContaRemetente = entrada.nextInt();

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if(contaRemetente != null) {
            System.out.println("Numero da conta do destinatario: ");
            int numeroContaDestinatario = entrada.nextInt();

            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if(contaDestinatario != null){
                System.out.println("Insira o valor da transferencia: ");
                Double valor = entrada.nextDouble();

                contaRemetente.transferir(contaDestinatario, valor);
            }else {
                System.out.println("Conta para transferencia não encontrada.");
            }
        }
        operacoes();
    }

    public static void listar(){
        if(contasBancarias.size() > 0) {
            for (Conta conta: contasBancarias){
                System.out.println(conta);
            }
        }else{
            System.out.println("Não há contas cadastradaS.");
        }
        operacoes();
    }


}