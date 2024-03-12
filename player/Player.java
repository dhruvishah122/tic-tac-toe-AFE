package player;

public class Player {
    private String name;
    private int age;
    private String address;
    private long contact;
    private String email;
    private char symbol;

    public void setDetails(String name, int age, String address, long contact, String email, char symbol) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.symbol = symbol;

    }

    public void setNameAge(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setNameSymbolEmailAge(String name, char symbol, String email, int age) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.symbol = symbol;
    }

    public void seNameSymbol(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return this.name;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public void getDetails() {
        System.out.println(this.name + " " + this.symbol + " " + this.age + " " + this.contact + " " + this.address
                + "  " + this.email);
    }

}
