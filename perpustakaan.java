package app;

import java.util.Scanner;
import java.util.ArrayList;

public class PerpusCul {
    String[] books = { "Laskar Pelangi", "Harry Potter", "C++ untuk Pemula", "Python untuk Pemula", "Web Master","HTML MASTER"};
    ArrayList<String> borrowed = new ArrayList<String>();
    Scanner input = new Scanner(System.in);
    int panjang;

    public PerpusCul() {
        panjang = 0;
    }

    static void freeze() {
        System.out.println("    ");

        System.out.print("Press space to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

    public void borrow() {
        int buku, durasi, harga, pembayaran;
        System.out.println("");
        System.out.println("-------------------------------");
        System.out.println("Books available to rent:");
        for (int i = 1; i <= books.length; i++) {
            System.out.println((i) + ". " + books[i - 1]);
        }
        System.out.println("-------------------------------");
        do {
            System.out.print("Choose book: ");
            buku = input.nextInt();

            if (buku > 6 || buku < 1) {
                System.out.println("\nInvalid book number!");
                System.out.println("--------------------------------------");
            } else if (borrowed.contains(books[buku - 1])) {
                System.out.println("\nBook already borrowed!");
                System.out.println("--------------------------------------");
            }
        } while (buku > 6 || buku < 1 || borrowed.contains(books[buku - 1]));

        System.out.println("");
        System.out.println("Book chosen: " + books[buku - 1]);
        System.out.println("-------------------------------------");
        borrowed.add(books[buku - 1]);
        System.out.print("Insert duration [6000 per day]: ");
        durasi = input.nextInt();

        harga = durasi * 6000;
        System.out.println("");
        do {
            System.out.println("Total price = " + harga);
            System.out.println("-----------------------------------");
            System.out.print("Payment: ");
            pembayaran = input.nextInt();

            if (pembayaran < harga) {
                System.out.println("\nPayment not enough!");
            }
        } while (pembayaran < harga);

        panjang += 1;

        System.out.println("");
        System.out.println("----------------------------------");
        System.out.println("Successfully borrowed " + books[buku - 1] + " for " + durasi + " days!");
        System.out.println("Your change is " + (pembayaran - harga));
        System.out.println("----------------------------------");
    }

    public void showBorrowed() {
        System.out.println("\n----------------------------------");
        System.out.println("Books borrowed");
        for (int i = 1; i <= panjang; i++) {
            System.out.println(i + ". " + borrowed.get(i - 1));
        }
        System.out.println("----------------------------------");
    }

    public void returnBook() {
        showBorrowed();
        int returned;

        do {
            System.out.print("Choose book: ");
            returned = input.nextInt();

            if (returned < 0 || returned > panjang) {
                System.out.println("Invalid book number!");
                showBorrowed();
            }
        } while (returned < 0 || returned > panjang);

        System.out.println("Thank you for returning " + borrowed.get(returned - 1) + " book");
        borrowed.remove(returned - 1);
        panjang -= 1;
        showBorrowed();
    }

    public static void main(String[] args) {
        PerpusCul perpus = new PerpusCul();

        int choice;

        do {
            System.out.println("Welcome to Cul Perpus!");
            System.out.println("-----------------------");
			System.out.println("-----------------------");
            System.out.println("1. Borrow a book");
            System.out.println("2. Show rented books");
            System.out.println("3. Return a book");
            System.out.println("4. out!");
            System.out.print("Choice: ");
            choice = perpus.input.nextInt();

            if (choice == 1) {
                perpus.borrow();
                freeze();
            }

            else if (choice == 2) {
                if (perpus.panjang == 0) {
                    System.out.println("No books borrowed yet");
                    freeze();
                } else {
                    perpus.showBorrowed();
                    freeze();
                }
            }

            else if (choice == 3) {
                if (perpus.panjang == 0) {
                    System.out.println("No books borrowed yet");
                    freeze();
                } else {
                    perpus.returnBook();
                    freeze();
                }
            }

            else if (choice == 4) {
                System.out.println("Terima Kasih !!!!!");
				System.out.println("------------------");
            }

            else {
                System.out.println("Salah Input !!");
            }
        } while (choice != 4);
    }
}