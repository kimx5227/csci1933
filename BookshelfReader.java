import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class BookshelfReader{

    public static Bookshelf readBooksFromFile(String fileName) {
        Scanner scanner = null;
        try{
          scanner = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e){
          System.out.println("File not found");
        }
        Bookshelf data;

        int numLines = 0;
        while(scanner.hasNextLine()){
            numLines++;
            String s = scanner.nextLine();
        }
        scanner.close();

        data = new Bookshelf(numLines);   //data is is allocated the exact amount of space it needs
        try{
          scanner = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e){
          System.out.println("FileNotFoundException");
        }
        int line;
        String bookTitle, bookAuthor;
        Double bookRating;
        String[] bookTraits;
        Book book;
        while (scanner.hasNextLine()){
            String nextBook = scanner.nextLine();
            bookTraits = nextBook.split(",");
            bookTitle = bookTraits[0];
            bookAuthor = bookTraits[1];
            bookRating = Double.parseDouble(bookTraits[2]);
            book = new Book(bookTitle, bookAuthor, bookRating);
            data.add(book);
        }

        return data;
    }

    public static void writeShelfToFile(Bookshelf b, String fileName){
        PrintWriter p = null; // declare p outside try-catch block
        try {
            p = new PrintWriter(new File(fileName));
        } catch (Exception e) {
            System.out.println("File not found");
        }
        p.print(b.toString());
        p.close();
    }

    public static void main(String[] args){
        Bookshelf bookShelfFromFile = readBooksFromFile("bookinput.txt");
        writeShelfToFile(bookShelfFromFile, "output.txt");

    }
}
