import javax.swing.JFileChooser;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.List;
import java.io.IOException;

public class FileInspector
{
    public static void main(String [] args)
    {
        JFileChooser chooser = new JFileChooser();
        File workingDirectory = new File(System.getProperty("user.dir"));
        chooser.setCurrentDirectory(workingDirectory);
        if (chooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION)
        {
            System.out.println("No file selected. Exiting.");
            System.exit(0);
        }
        Path selectedPath = chooser.getSelectedFile().toPath();
        try
        {
            List<String> lines = Files.readAllLines(selectedPath);
            for (String line : lines)
            {
                System.out.println(line);
            }
            System.out.println("\n--- File Report ---");
            System.out.println("File Name: " + selectedPath.getFileName());
            System.out.println("Total lines: " + lines.size());
        }
        catch (IOException e)
        {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }

    }
}

