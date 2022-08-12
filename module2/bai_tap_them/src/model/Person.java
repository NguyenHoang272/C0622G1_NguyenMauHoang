package model;

public abstract class Person {
    private int id;
    private String name;
    private String dayOfBrith;

    public Person(){

    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dayOfBrith='" + dayOfBrith + '\'' +
                '}';
    }

    public Person(int id, String name, String dayOfBrith) {
        this.id = id;
        this.name = name;
        this.dayOfBrith = dayOfBrith;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBrith() {
        return dayOfBrith;
    }

    public void setDayOfBrith(String dayOfBrith) {
        this.dayOfBrith = dayOfBrith;
    }
}
