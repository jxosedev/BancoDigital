package programa;

import javax.swing.*;
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

        //painel de operações pra deixar mais profissional o menu
        int operacao = Integer.parseInt(JOptionPane.showInputDialog("--- Selecione uma operação ---" +

                                "\n1- Criar Conta" +
                                "\n2- Depositar" +
                                "\n3- Sacar" +
                                "\n4- Transferir" +
                                "\n5- Listar" +
                                "\n6- Sair"));

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
                JOptionPane.showMessageDialog(null, "Obrigado por usar nossa agencia !!");
                System.exit(0);

            default:
                JOptionPane.showMessageDialog(null, "Obrigado por usar nossa agencia !!");
                operacoes();
                break;
        }
    }

    public static void criarConta() {

        Cliente cliente = new Cliente();

        cliente.setNome(JOptionPane.showInputDialog("Nome: "));

        cliente.setCpf(JOptionPane.showInputDialog("CPF: "));

        cliente.setEmail(JOptionPane.showInputDialog("Email: "));

        cliente.setEndereco(JOptionPane.showInputDialog("Endereço: "));

        cliente.setTelefone(JOptionPane.showInputDialog("Telefone: "));

        Conta conta = new Conta(cliente);

        contasBancarias.add(conta);
        JOptionPane.showMessageDialog(null, "Sua conta foi criada com sucesso !!!");
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


        int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Número da conta para deposito: "));

        Conta conta = encontrarConta(numeroConta);// aqui ele chama o numero da conta que o usuario digitou e aplica o valor

        if(conta != null) {

            System.out.println("Insira o valor que deseja depositar.");

            Double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja depositar ? "));
            conta.depositar(valorDeposito);

            JOptionPane.showMessageDialog(null, "O valor foi depositado com sucesso !!");

        }else{

            JOptionPane.showMessageDialog(null, "Conta não encontrada !!");

        }

        operacoes();

    }

    public static void sacar() {

        int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Numero da conta para saque: "));

        Conta conta = encontrarConta(numeroConta);// aqui ele chama o numero da conta que o usuario digitou e aplica o valor

        if(conta != null) {

            Double valorSaque = Double.parseDouble((JOptionPane.showInputDialog("Qual o valor que deseja sacar ? ")));
            conta.sacar(valorSaque);

        }else{

            JOptionPane.showMessageDialog(null, "A conta destino para o saque não foi encontrada !!");

        }
        operacoes();
    }

    // aqui verifica se a conta de destino e a de envio existe, faz a validação e depois a operação
    public static void transferir(){

        int numeroContaRemetente = Integer.parseInt(JOptionPane.showInputDialog("Insira o numero da conta do remetente: "));

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if(contaRemetente != null) {

            int numeroContaDestinatario = Integer.parseInt(JOptionPane.showInputDialog("Insira o numero da conta do remetente: "));

            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if(contaDestinatario != null){

                Double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor da transferencia: "));

                contaRemetente.transferir(contaDestinatario, valor);
            }else {

                JOptionPane.showMessageDialog(null, "Conta para transferencia não encontrada.");

            }
        } else {

            JOptionPane.showMessageDialog(null, "Conta para transferencia não encontrada !!");

        }
        operacoes();
    }

    public static void listar(){
        if(contasBancarias.size() > 0) {

            for (Conta conta: contasBancarias){
                System.out.println(conta);
            }
        }else{

            JOptionPane.showMessageDialog(null, "Não há contas cadastradaS.");

        }
        operacoes();
    }


}