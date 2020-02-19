public class Owl{

    private String owlName = "";
    private int owlAge = 0;
    private double owlWeight = 0;

    public Owl(){}

    public String getOwlName(){
        return owlName;
    }

    public int getOwlAge(){
        return owlAge;
    }

    public double getOwlWeight(){
        return owlWeight;
    }

    public boolean equals(Owl other){
        boolean sameOwl = false;
        if (owlName.equals(other.getOwlName()) && owlAge == other.getOwlAge() && owlWeight == other.getOwlWeight()){
            sameOwl = true;
        }
        return sameOwl;

    }

    public Owl(String name, int age, double weight){
        owlName = name;
        owlAge = age;
        owlWeight = weight;
    }

    public static void main(String[] args){
        Owl owlOne = new Owl("Fred", 10, 20.5);
        Owl owlTwo = new Owl("Mark", 10, 20.5);
        Owl owlThree = new Owl("Fred", 10, 20.5);
        boolean oneEqualsTwo, oneEqualsThree;
        System.out.println(owlOne.equals(owlTwo));
        System.out.println(owlOne.equals(owlThree));
    }
}
