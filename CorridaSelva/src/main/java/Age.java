public enum Age {
    ABOVEEIGHTEEN,
    BELOWEIGHTEEN;

    public static Enum checkAge(Integer age) {
        if (age < 18)
            return Age.BELOWEIGHTEEN;
        return Age.ABOVEEIGHTEEN;
    }
}
