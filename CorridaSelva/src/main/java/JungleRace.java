import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class JungleRace {
    private ArrayList<Runner> runners = new ArrayList<>();

    public ArrayList<Runner> listRunners() {
        return runners;
    }

    private Boolean checkRegistered(Runner newRunner) {
        for (Runner runner:
             runners) {
            if (newRunner.getDocument().equals(runner.getDocument()))
                return true;
        }
        return false;
    }

    private Boolean validateRegistration(Runner newRunner) {
        // Error message template
        String errorMsg = String.format("Não foi possível realizar a inscrição de %s %s",
                newRunner.getName(), newRunner.getLastname());

        // check runner age and category
        if (newRunner.getAge() < 18 && newRunner.getCategory().equals(Categories.AVANCADO)) {
            System.out.println(errorMsg.concat(": apenas maiores de 18 podem se inscrever no circuito avançado."));
            return false;
        } else if (checkRegistered(newRunner)) {
            System.out.println(errorMsg.concat(" : corredore já inscrite"));
            return false;
        }
        return true;
    }

    public void addRunner(Runner newRunner) {
        // get the number of participants
        int registerNumber = runners.size() + 1;

        if (validateRegistration(newRunner)){
            newRunner.setId(registerNumber);
            BigDecimal registrationFee = calcRegistrationFee(newRunner);
            newRunner.setRegistrationFee(registrationFee);
            runners.add(newRunner);
            System.out.printf("Inscrição realizada com sucesso: %s\n", newRunner);
        }
    }

    public void removeRunner(Runner runner) {
        Optional<Runner> runnerToDelete = runners.stream().filter(c -> c.getId().equals(runner.getId())).findFirst();
        runnerToDelete.ifPresent(value -> runners.remove(value));
    }

    public BigDecimal calcRegistrationFee(Runner newRunner) {

        Integer age = newRunner.getAge();
        Categories category = newRunner.getCategory();

        HashMap<Categories,BigDecimal> aboveEighteen = new HashMap<>();
        aboveEighteen.put(Categories.PEQUENO, BigDecimal.valueOf(1500.0));
        aboveEighteen.put(Categories.MEDIO, BigDecimal.valueOf(2300.0));
        aboveEighteen.put(Categories.AVANCADO, BigDecimal.valueOf(2800.0));

        HashMap<Categories, BigDecimal> belowEighteen = new HashMap<>();
        belowEighteen.put(Categories.PEQUENO, BigDecimal.valueOf(1300.0));
        belowEighteen.put(Categories.MEDIO, BigDecimal.valueOf(2000.0));

        if (Age.checkAge(age).equals(Age.ABOVEEIGHTEEN)) {
            return aboveEighteen.get(category);
        }
        return belowEighteen.get(category);
    }

    public void printRunners() {
        runners.forEach(System.out::println);
    }

}
