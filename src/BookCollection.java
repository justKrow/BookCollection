import java.util.Scanner;

public class BookCollection {
    String BookPile[];
    int top;
    int capacity;

    public BookCollection(int size) {
        BookPile = new String[size];
        top = -1;
        capacity = size;
    }

    public String stackBook() {
        Scanner sc1 = new Scanner(System.in);
        if (isFull()) {
            System.out.println("The pile is full");
            System.out.println("Can't add anymore to the pile. Remove one book first.");
            System.out.println("=======================");
            return null;
        }
        System.out.println("Enter book Name: ");
        String name = sc1.nextLine();
        System.out.println("added: " + name);
        System.out.println("=======================");
        return BookPile[++top] = name;
    }

    public String takeBook() {
        if (isEmpty()) {
            System.out.println("There is no book in the pile to remove.");
            System.out.println("=======================");
            return null;
        }
        System.out.println("Removed: " + BookPile[top]);
        System.out.println("=======================");
        return BookPile[top--];
    }

    public int getPileSize() {
        return top + 1;
    }

    public Boolean isFull() {
        return top == capacity - 1;
    }

    public Boolean isEmpty() {
        return top == -1;
    }

    public void displayPile() {
        System.out.println("=======================");
        System.out.println("Book Pile");
        System.out.println("-----------------------");
        for (int i = top; i >= 0; i--) {
            System.out.println(BookPile[i]);
        }
        System.out.println("=======================");
    }

    public String SortBooks() {
        if (isEmpty()) {
            System.out.println("There is no book in the pile to sort.");
            System.out.println("=======================");
            return null;
        }
        for (int i = 0; i < top + 1; i++) {
            int min_index = i;
            String minStr = BookPile[i];
            for (int j = i + 1 ; j < top + 1; j++) {
                if (BookPile[j].compareTo(minStr) < 0) {
                    minStr = BookPile[j];
                    min_index = j;
                }
            }
            if (min_index != i) {
                String temp = BookPile[min_index];
                BookPile[min_index] = BookPile[i];
                BookPile[i] = temp;
            }
        }
        System.out.println("Books sorted successfully");
        System.out.println("=======================");
        return null;
    }

    public String searchBook(){
        if (isEmpty()) {
            System.out.println("There is no book in the pile to search.");
            System.out.println("=======================");
            return null;
        }
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Enter the name of the book to search: ");
        String key = sc2.nextLine();
        for(int i=0;i< top+1;i++){    
            if(BookPile[i].equalsIgnoreCase(key)){    
                System.out.println(key + " is at the count of " + (i+1) + " from the bottom of the pile");  
            }    
        }
        System.out.println("=======================");
        return null;    
    }

    public void displayMenu() {
        System.out.println("=======================");
        System.out.println("Select an option");
        System.out.println("------------------------------");
        System.out.println("1. Add a book");
        System.out.println("2. Take a book");
        System.out.println("3. Display Book Pile");
        System.out.println("4. Sort Book Pile");
        System.out.println("5. Check the size of Book Pile");
        System.out.println("6. Seach a Book");
        System.out.println("7. Is Book Pile empty?");
        System.out.println("8. Is Book Pile full?");
        System.out.println("9. Leave/Quit");
        System.out.println("=======================");
    }

    public static void main(String[] args) {
        BookCollection MC = new BookCollection(5);
        MC.displayMenu();
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Pick an option(1~9): ");
            int choice = sc.nextInt();

            while (choice != 9) {
                if (choice == 1) {
                    MC.stackBook();
                    System.out.println("Pick an option(1~9): ");
                    choice = sc.nextInt();
                }
                else if (choice == 2) {
                    MC.takeBook();
                    System.out.println("Pick an option(1~9): ");
                    choice = sc.nextInt();
                }
                else if (choice == 3) {
                    MC.displayPile();
                    System.out.println("Pick an option(1~9): ");
                    choice = sc.nextInt();
                }
                else if (choice == 4) {
                    MC.SortBooks();
                    System.out.println("Pick an option(1~9): ");
                    choice = sc.nextInt();
                }
                else if (choice == 5) {
                    System.out.println("Size of the pile: " + MC.getPileSize());
                    System.out.println("Pick an option(1~9): ");
                    choice = sc.nextInt();
                }
                else if (choice == 6) {
                    MC.searchBook();
                    System.out.println("Pick an option(1~9): ");
                    choice = sc.nextInt();
                }
                else if (choice == 7) {
                    System.out.println("Is pile empty: " + MC.isEmpty());
                    System.out.println("Pick an option(1~9): ");
                    choice = sc.nextInt();
                }
                else if (choice == 8) {
                    System.out.println("Is pile full: " + MC.isFull());
                    System.out.println("Pick an option(1~9): ");
                    choice = sc.nextInt();
                }
                else {
                    System.out.println("Option number should be between 1 and 9");
                    System.out.println("Pick an option:(1~9) ");
                    choice = sc.nextInt();
                }
            }
            System.out.println("Thanks for using the service");
        } catch (Exception e) {
            System.out.println("Invalid input. Please pay attention to the instructions.\nPlease restart the application");
            System.out.println("=======================");
        }
    }
}