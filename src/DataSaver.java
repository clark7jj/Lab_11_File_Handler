import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

public class DataSaver
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();
        boolean keepGoing = false;

        do
        {
            String firstName = SafeInput.getNonZeroLenString(in, "Enter your first name: ");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter your last name: ");
            int idNumber = SafeInput.getRangedInt(in, "Enter your ID number (0-999999) : ", 0, 999999);
            String email = SafeInput.getNonZeroLenString(in, "Enter your email address: ");
            int yearOfBirth = SafeInput.getRangedInt(in, "Enter your year of birth (1900-2026) : ", 1900, 2026 );

            String record = String.format("%s,%s,%06d,%s,%d", firstName, lastName, idNumber, email, yearOfBirth);
            records.add(record);
            keepGoing = SafeInput.getYNConfirm(in, "Do you want to enter another record? (Y/N): ");
        } while (keepGoing);

        JFileChooser chooser = new JFileChooser();
        File workingDirectory = new File(System.getProperty("user.dir"));
        chooser.setCurrentDirectory(workingDirectory);
        chooser.setDialogTitle("Choose Where to Save Your File!");

        if (chooser.showSaveDialog(null) != JFileChooser.APPROVE_OPTION)
        {
            System.out.println("Save cancelled. No file was saved. Exiting.");
            return;
        }
        Path savePath = chooser.getSelectedFile().toPath();
        try (BufferedWriter writer = Files.newBufferedWriter(savePath))
        {
            for (String record : records)
            {
                writer.write(record);
                writer.newLine();
            }
            System.out.println("File saved successfully!");
        }
        catch (IOException e)
        {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }
}
