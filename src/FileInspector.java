import javax.swing.JFileChooser;
import java.io.File;
import java.nio.file.Path;

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
        System.out.println("Selected file: " + selectedPath.getFileName());
    }
}

