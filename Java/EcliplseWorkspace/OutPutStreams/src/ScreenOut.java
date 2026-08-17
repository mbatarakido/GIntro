import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;

public class ScreenOut {
	public static void main(String[] args)
	{	/*
		String str = "ABCDEFG";
		byte[] by = str.getBytes();
		OutputStream outPut = null;
		*/
		
		Path filepath = Paths.get("/Users/Ben/Documents/JavapFiles/source.txt");
		/*String s = "MNOPQR";
		byte[] data = s.getBytes();
		OutputStream output = null; */
		InputStream input = null;
		
		try
		{	/*
				//output on to the screen
			outPut = System.out;
			outPut.write(by);
			outPut.flush();
			outPut.close();
			
				//create and write in a file
			output = new BufferedOutputStream(Files.newOutputStream(filepath,CREATE));
			output.write(data);
			output.flush();
			output.close();
			*/
			
				//read from an already existing file onto the screen
			input = Files.newInputStream(filepath);
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String string = null;
			string = reader.readLine();
			System.out.println(string);
			input.close();
		}
		catch(IOException e)
		{
			System.out.println("Message "+e);
		}
		catch(Exception n)
		{
			System.out.println(n);
		}
	}

}
