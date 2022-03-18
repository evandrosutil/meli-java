import lombok.Data;

import java.math.BigDecimal;

@Data
public class Runner {
    private Integer id;
    private Categories category;
    private String name;
    private String lastname;
    private Integer age;
    private String document;
    private String phoneNumber;
    private String emergencyNumber;
    private String bloodGroup;
    private BigDecimal registrationFee;

    public Runner(Categories category, String name, String lastname, Integer age, String document, String phoneNumber, String emergencyNumber, String bloodGroup) {
        this.name = name;
        this.category = category;
        this.lastname = lastname;
        this.age = age;
        this.document = document;
        this.phoneNumber = phoneNumber;
        this.emergencyNumber = emergencyNumber;
        this.bloodGroup = bloodGroup;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmergencyNumber() {
        return emergencyNumber;
    }

    public void setEmergencyNumber(String emergencyNumber) {
        this.emergencyNumber = emergencyNumber;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public BigDecimal getRegistrationFee() {
        return registrationFee;
    }

    public void setRegistrationFee(BigDecimal registrationFee) {
        this.registrationFee = registrationFee;
    }

    @Override
    public String toString() {
        return String.format("# %d | categoria: %8s | valor da inscrição: R$ %.2f | nome completo: %s %s"
                + "| idade: %d | RG: %s | número de celular %s | número de emergência: %s | grupo Sanguíneo: %3s",
                id, category, registrationFee, name, lastname, age, document, phoneNumber, emergencyNumber, bloodGroup);
    }
}
