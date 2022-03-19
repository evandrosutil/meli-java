package Transaction;

import Clients.Operations;

import java.util.ArrayList;

public interface Transaction {

    String errorMsg = "Não foi possivel realizar a operação.";
    String successMsg = "Operação realizada com sucesso.";

    void transactionOk();
    void transactionNotOk();
    void checkPermission(ArrayList<Operations> allowedOperations);
}
