package finalProject;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FinalProj {

    public static final String PATH = "C://Users//edson//Documents//Simplilearn//FinalProjectTest//";
            
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        String choice = null; 
        String filename = null;
        
        
        do {
            
        	System.out.println("****************************************************************");
            System.out.println("******************** Welcome TO LOCKED ME. COM  ****************");
            System.out.println("\nMain Menu");
            System.out.println("1\t - File Lists");
            System.out.println("2\t - Add File to the directory");
            System.out.println("3\t - Delete file");
            System.out.println("4\t - Search file");
            System.out.println("5\t - Close application");
            
            System.out.println("Option: ");
            choice = scanner.nextLine();

            switch (choice) {
	            case "1":
	            	String[] folderContent = new File(PATH).list();

	            	for (int i = 0; i < folderContent.length; i++) {
	            		System.out.println(folderContent[i]);
            		}
	                break;
                case "2":
                    System.out.println("enter filename: ");
                    filename = scanner.nextLine();
                    createFile(filename);
                    break;
                case "3":
                    System.out.println("enter filename: ");
                    filename = scanner.nextLine();
                    deleteFile(filename);
                    break;
                case "4":
                    System.out.println("enter filename: ");
                    filename = scanner.nextLine();
                    searchFile(filename);
                    break;
                case "5":
                    exit = true;
                    break;
                default:
                    System.out.println("wrong option. please try again");
            }
            
        } while (!exit);
        
        System.out.println("Shutting down...");
        scanner.close();
   }
    
    private static void createFile(String filename) {
        try {  
            File file = new File(PATH + filename);  // this is used to create the file
            
            if (file.createNewFile()) {  
                System.out.println("New File is created!");  
            } else {                   
                if(file.exists())
                {
                    System.out.println("File already exists."); 
                    System.out.println("File path:" + file.getAbsolutePath());
                    System.out.println("File name:  " + file.getName());
                    System.out.println("File class:  " + file.getClass());
                    System.out.println("File parent:  " + file.getParent());
                    System.out.println("File space allocated:  " + file.getUsableSpace());
                    System.out.println("File length: " + file.length());
                    System.out.println("File list:   " + file.list());
                    
                }
                else
                {
                    System.out.println("File does not exists.");
                }
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }
    }
    
    private static void deleteFile(String filename) {
        
        File file = new File(PATH + filename);
        
        if(file.exists()) {
            
            //--------------Delete the file code below-------------//
            boolean b = file.delete();
            if(b==true)
            {
                System.out.println("File deleted !!");
            }
            else
            {
                System.out.println("File not deleted");
            }
            //------------end of the above code--------------------//
            
        } else {
            System.out.println("File does not exists.");
        }  
    }
    
    private static void searchFile(String filename) {
        
        String[] pathnames = new File(PATH).list();

        boolean isFound = false;

        for (String pathname : pathnames) {
        	if (pathname.equalsIgnoreCase(filename)) {
        		isFound = true;
        		break; 
        	}
        }
    
		if (isFound) {
			System.out.println(filename + " found");	
		} else {
			System.out.println(filename + " not found");
		}
    }
}
