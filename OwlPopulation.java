import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OwlPopulation {
    private String fileName;
    private Owl[] data;


    public void populateData() throws FileNotFoundException{
        File f = new File(fileName);
        Scanner scanner = new Scanner(f);

        int numLines = 0;
        while(scanner.hasNextLine()){
            numLines++;
            String s = scanner.nextLine();
        }
        scanner.close();

        data = new Owl[numLines];   //data is is allocated the exact amount of space it needs
        scanner = new Scanner(f);

        int line, owlAge;
        String owlName;
        Double owlWeight;
        String[] owlTraits;
        Owl[] owl;
        line = 0;
        while (scanner.hasNextLine()){
            String nextOwl = scanner.nextLine();
            owlTraits = nextOwl.split(",");
            owlName = owlTraits[0];
            owlAge = Integer.parseInt(owlTraits[1]);
            owlWeight = Double.parseDouble(owlTraits[2]);
            data[line] = new Owl(owlName, owlAge, owlWeight);
            line ++;
        }
        System.out.println("Total # of Owls : " + line + " for: " + fileName);
    }

    public OwlPopulation(String fileName) throws FileNotFoundException{
        this.fileName = fileName;
        this.populateData();
    }

    public Owl[] getOwlData(){
        return data;
    }

    public double averageAge(){
        double avgAge;
        int owlNumAge, totalOwlAge;
        Owl owlNum;
        totalOwlAge = 0;
        for (int i = 0; i < data.length; i++){
            owlNum = data[i];
            owlNumAge = owlNum.getOwlAge();
            totalOwlAge = totalOwlAge + owlNumAge;
        }
        avgAge = totalOwlAge / data.length;
        if (avgAge != 0)
          return avgAge;
        else
          return -1;
    }

    public Owl getYoungest(){
        if (data.length != 0){
          Owl youngestOwl = data[0];
          int youngestOwlAge = youngestOwl.getOwlAge();
          for (int i = 1; i < data.length; i++){
              if (data[i].getOwlAge() > youngestOwlAge){
                  youngestOwl = data[i];
                  youngestOwlAge = youngestOwl.getOwlAge();
              }
          }
        return youngestOwl;
        }
        else{
          return null;
        }
    }

    public Owl getHeaviest(){
      if (data.length != 0){
        Owl heaviestOwl = data[0];
        double heaviestOwlWeight = heaviestOwl.getOwlWeight();
        for (int i = 1; i < data.length; i++){
            if (data[i].getOwlWeight() > heaviestOwlWeight){
                heaviestOwl = data[i];
                heaviestOwlWeight = heaviestOwl.getOwlWeight();
            }
        }
      return heaviestOwl;
      }
      else{
        return null;
      }
    }

    public String toString(){
        if (data.length != 0){
        Owl youngestOwl = this.getYoungest();
        Owl heaviestOwl = this.getHeaviest();
        String youngestOwlName = youngestOwl.getOwlName();
        String heaviestOwlName = heaviestOwl.getOwlName();
        int youngestOwlAge = youngestOwl.getOwlAge();
        double heaviestOwlWeight = heaviestOwl.getOwlWeight();
        double averageAge = this.averageAge();
        String youngestOwlSum = youngestOwlName +"'s age is " + Integer.toString(youngestOwlAge);
        String heaviestOwlSum = heaviestOwlName + "'s weight is " + Double.toString(heaviestOwlWeight);
        String averageAgeSum = "The average age of the population is: " + Double.toString(averageAge);
        return youngestOwlSum + "\n" + heaviestOwlSum + "\n" + averageAgeSum;
        }
        else
          return null;
    }

    public boolean containsOwl(Owl other){
        boolean sameOwl = false;
        Owl owl;
        if (data.length != 0){
          for (int i = 0; i < data.length; i++){
            owl = data[i];
            if (owl.equals(other)){
              sameOwl = true;
            }
          }
        }
        return sameOwl;
    }
    public void merge(OwlPopulation other){
        Owl[] newData;
        Owl[] otherData = other.getOwlData();
        int numOwls = otherData.length;
        for (int i = 0; i < data.length; i++){
            if (! other.containsOwl(data[i])){
                numOwls ++;
            }
        }

        newData = new Owl[numOwls];
        int entry = 0;

        for (int i = 0; i < data.length; i++){
          if (! other.containsOwl(data[i])){
              newData[entry] = data[i];
              entry ++;
          }
        }
        for (int i = 0; i < otherData.length; i++){
              newData[entry] =otherData[i];
              entry ++;
          }
        this.data = newData;
        }
        //TODO: a brief overview of what you can do to implement this method is given below:

        //1) determine (and store) the distinct owls in the other population.

        //2) make a new data array to hold the correct number of owls for the merged population

        //3) copy over the distinct owls from each population to the data array

        //4) set the new data array to "this" data (where is the merged population? what happens to the original populations?)

    public int popSize(){
        return data.length;
    }
    public static void main(String[] args) {
        try {

            //The following should run when you are complete. Feel free to comment out as you see fit while you work.
            OwlPopulation pop1 = new OwlPopulation("owlPopulation1.csv");
          /*  System.out.println("Average age of Pop 1: " + pop1.averageAge());
            Owl youngestOwl1 = pop1.getYoungest();
            Owl heaviestOwl1 = pop1.getHeaviest();
            System.out.println("Youngest Owl of Pop1: " + youngestOwl1.getOwlAge());
            System.out.println("Heaviest Owl of Pop1: " + heaviestOwl1.getOwlWeight());*/
            System.out.println(pop1);
            //System.out.println(pop1.popSize());

            OwlPopulation pop2 = new OwlPopulation("owlPopulation2.csv");
            /*System.out.println("Average Age of Pop 2: " + pop2.averageAge());
            Owl youngestOwl2 = pop2.getYoungest();
            Owl heaviestOwl2 = pop2.getHeaviest();
            System.out.println("Youngest Owl of Pop 2: " + youngestOwl2.getOwlAge());
            System.out.println("Heaviest Owl of Pop 2: " + heaviestOwl2.getOwlWeight()); */
            System.out.println(pop2);
            //System.out.println(pop2.popSize());
            System.out.println("Total # of Owls for the merged list: " +  pop1.popSize());
            pop1.merge(pop2);
            System.out.println(pop1);
            //System.out.println(pop1.popSize());

        }
        catch (FileNotFoundException f){
            System.out.println("File not found.");
        }
    }


}
