package Project;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LockedMe {
    private static final String ROOT_DIR = "C://Users//prati//eclipse-workspace//files//";

    public static void main(String[] args) {
        welcomeScreen();
        showMainMenu();
    }

    private static void welcomeScreen() {
        System.out.println("==========================================");
        System.out.println("         Welcome to LockedMe.com        ");
        System.out.println("       Developer: Pratinav Hingonia     ");
        System.out.println("==========================================");
    }

    private static void showMainMenu() {
        System.out.println("\n=== Main Menu ===");
        System.out.println("1. View files");
        System.out.println("2. File operations");
        System.out.println("3. Exit");

        int choice = getChoice();
        handleMenu(choice);
    }

    private static int getChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    private static void handleMenu(int choice) {
        switch (choice) {
            case 1:
                displayFilesAscending();
                showMainMenu();
                break;
            case 2:
                showFileOperationsMenu();
                break;
            case 3:
                System.out.println("Thank you for using LockedMe.com!");
                System.exit(0);
                break;
   
        }
    }

    private static void showFileOperationsMenu() {
        System.out.println("\n=== File Operations Menu ===");
        System.out.println("1. Add a file");
        System.out.println("2. Delete a file");
        System.out.println("3. Search for a file");
        System.out.println("4. Back to main menu");

        int choice = getChoice();
        handleFileOperations(choice);
    }

}