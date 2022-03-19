import Clients.BankCollector;
import Clients.Basic;
import Clients.Executive;

public class Main {

    public static void main(String[] args) {

        System.out.println("----> Operações usuário básico <----");
        Basic basic = new Basic();
        System.out.println("Saldo: ");
        basic.balance();
        System.out.println("Transferência: ");
        basic.transfer();

        System.out.println("\n----> Operações usuário executivo <----");
        Executive executive = new Executive();
        System.out.println("Saldo: ");
        executive.balance();
        System.out.println("Transaferência: ");
        executive.transfer();

        System.out.println("\n----> Operações usuário cobrador <----");
        BankCollector collector = new BankCollector();
        System.out.println("Saque: ");
        collector.withdraw();
        System.out.println("Depósito: ");
        collector.deposit();
    }
}
