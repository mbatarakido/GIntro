import static java.nio.file.AccessMode.*;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class filePaths {
	public static void main(String[] args)
	{
		//FileSystem fs = FileSystems.getDefault();
		//Path path = fs.getPath("myFile.txt"); // /Users/Ben/eclipse-workspace/FilesAndPaths/src/
		//"/Users","Ben","Documents","JavapFiles","sample.rtf"
		Path filePath = Paths.get("/Users/Ben/eclipse-workspace/FilesAndPaths/src/testFile.txt");
		
		System.out.println("Path is " + filePath.toString());
		//to check file accessibility 
		try
		{
			filePath.getFileSystem().provider().checkAccess(filePath,READ);
			System.out.println("The file can be read.");
		}
		catch(IOException e)
		{
			System.out.println("File cannot be used for this application.");
		}
		int count = filePath.getNameCount();
		System.out.println("File name is " + filePath.getFileName());
		System.out.println("There are " + count +
				" elements in the file path");
		for(int x = 0; x < count; ++x)
			System.out.println("Element " + x + " is " +
					filePath.getName(x));
		
		//converting relative path to absolute path
		String name;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter the name of the file>>>");
		name = keyboard.nextLine();
		Path inputPath = Paths.get(name);
		Path fullPath = inputPath.toAbsolutePath();
		
		System.out.println("Full path is: "+fullPath.toString());
		
	}

}
