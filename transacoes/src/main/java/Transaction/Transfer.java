package Transaction;

import Clients.Operations;

import java.util.ArrayList;

public class Transfer implements Transaction{
    @Override
    public void transactionOk() {
        System.out.println(successMsg);
    }

    @Override
    public void transactionNotOk() {
        System.out.println(errorMsg);
    }

    @Override
    public void checkPermission(ArrayList<Operations> allowedOperations) {
        if (allowedOperations.contains(Operations.TRANSFER)) {
            transactionOk();
        } else transactionNotOk();
    }
}
