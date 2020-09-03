public class Bookshelf{

        private Book[] books;
        private int nextEmpty = 0;

        public Bookshelf(){
            books = new Book[20];
        }

        public Bookshelf(int shelfSize){
            books = new Book[shelfSize];
        }

        public Book[] getBooks(){
            return books;
        }

        public boolean add(Book newBook){
          if (nextEmpty < books.length){
              if (books[nextEmpty] == null){
                  books[nextEmpty] = newBook;
                   nextEmpty ++;
                  return true;
              }
              return false;
          } else {
              System.out.println("Bookshelf is full");
              return false;
          }
        }

        public Bookshelf getBooksByAuthor(String author){
              Bookshelf newBookshelf;
              int booksByAuthor = 0;
              for (int bookNumb = 0; bookNumb < books.length; bookNumb++){
                  if (books[bookNumb] != null){
                      if (books[bookNumb].getAuthor().equals(author)){
                          booksByAuthor ++;
                      }
                  }
              }

              newBookshelf = new Bookshelf(booksByAuthor);

              for (int bookNumb = 0; bookNumb < books.length; bookNumb++){
                  if (books[bookNumb] != null){
                      if (books[bookNumb].getAuthor().equals(author)){
                          newBookshelf.add(books[bookNumb]);
                      }
                  }
              }
              return newBookshelf;
        }

        public String toString(){
            String arrayStr = "";
            for (int i = 0; i < books.length; i++){
                if (books[i] != null){
                    arrayStr = arrayStr + books[i] + "\n";
                }
            }
            return arrayStr;
        }

        public void sort(char sortBy){
            int i, j, minIndex;
            Book temp;
            for (i = 0; i < nextEmpty; i++){
                minIndex = i;
                for (j = i+1; j < nextEmpty; j++){
                    if (books[i].compareTo(books[j], sortBy) > 0){
                        minIndex = j;
                    }
                }
                temp = books[minIndex];
                books[minIndex] = books[i];
                books[i] = temp;
            }
        }

        public static void main(String[] args){
            Bookshelf shelf1 = new Bookshelf(5);
            Book book1 = new Book("1984", "George Orwell", 10.0);
            Book book2 = new Book("Animal Farm", "George Orwell", 9.5);
            Book book3 = new Book("To Kill a Mockingbird", "Harper Lee", 9.2);
            shelf1.add(book1);
            shelf1.add(book2);
            shelf1.add(book3);
            Bookshelf shelfGeorgeOrwell = shelf1.getBooksByAuthor("George Orwell");
            System.out.println(shelf1);
            System.out.println(shelfGeorgeOrwell);
            shelf1.sort('A');
            shelfGeorgeOrwell.sort('T');
            System.out.println(shelf1);
            System.out.println(shelfGeorgeOrwell);
        }
}
