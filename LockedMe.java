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

    private static void displayFilesAscending() {
        File directory = new File(ROOT_DIR);
        File[] files = directory.listFiles();

        if (files != null && files.length > 0) {
            List<String> fileNames = new ArrayList<>();
            for (File file : files) {
                fileNames.add(file.getName());
            }

            Collections.sort(fileNames);
            System.out.println("\n=== Files in Ascending Order ===");
            for (String fileName : fileNames) {
                System.out.println(fileName);
            }
        } else {
            System.out.println("The directory is empty.");
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

    private static void handleFileOperations(int choice) {
        switch (choice) {
            case 1:
                addFile();
                showFileOperationsMenu();
                break;
            case 2:
                deleteFile();
                showFileOperationsMenu();
                break;
            case 3:
                searchFile();
                showFileOperationsMenu();
                break;
            case 4:
                showMainMenu();
                break;
        }
    }

    private static void addFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name to add: ");
        String fileName = scanner.nextLine();

        File file = new File(ROOT_DIR + fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("File added successfully.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while adding the file.");
        }
    }

    private static void deleteFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name to delete: ");
        String fileName = scanner.nextLine();

        File file = new File(ROOT_DIR + fileName);
        if (file.delete()) {
            System.out.println("File deleted successfully.");
        } else {
            System.out.println("Unable to delete the file.");
        }
    }

    private static void searchFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name to search: ");
        String fileName = scanner.nextLine();

        File directory = new File(ROOT_DIR);
        File[] files = directory.listFiles();
        boolean fileFound = false;

        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    System.out.println("File found: " + file.getName());
                    fileFound = true;
                    break;
                }
            }
        }

        if (!fileFound) {
            System.out.println("File not found.");
        }
    }
}