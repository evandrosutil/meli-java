package Clients;

import Transaction.*;

import java.util.ArrayList;
import java.util.concurrent.BlockingDeque;

public class Basic implements User{

    private ArrayList<Operations> allowedOperations = new ArrayList<>();

    public Basic() {
        // set allowed operations to Basic costumer
        allowedOperations.add(Operations.BALANCE);
        allowedOperations.add(Operations.PAYMENT);
        allowedOperations.add(Operations.WITHDRAW);
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
