package Clients;

import Transaction.Balance;
import Transaction.Deposit;
import Transaction.Withdraw;

import java.util.ArrayList;

public class Executive implements User{

    private final ArrayList<Operations> allowedOperations = new ArrayList<>();

    public Executive() {
        // set allowed operations to Basic costumer
        allowedOperations.add(Operations.DEPOSIT);
        allowedOperations.add(Operations.TRANSFER);
    }

    @Override
    public void balance() {
        new Balance().checkPermission(allowedOperations);
    }

    @Override
    public void deposit() {
        new Deposit().checkPermission(allowedOperations);
    }

    @Override
    public void payment() {
        new Deposit().checkPermission(allowedOperations);
    }

    @Override
    public void transfer() {
        new Deposit().checkPermission(allowedOperations);
    }

    @Override
    public void withdraw() {
        new Withdraw().checkPermission(allowedOperations);

    }
}