package animal_class_and_interface_edible.Model;

public class Tiger extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Tiger: roarrrrr!";
    }
    @Override
    public String howToEat() {
        return "could be fried";
    }
}
