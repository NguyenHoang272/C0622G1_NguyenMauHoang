package classwirte_java;

public class Student {
    private String name;
    private String classes;

    public Student(){
        this.name= "Hoang";
        this.classes = "C06";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public String getClasses() {
        return classes;
    }
}
