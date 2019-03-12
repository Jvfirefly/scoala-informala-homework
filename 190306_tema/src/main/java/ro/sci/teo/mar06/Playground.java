package ro.sci.teo.mar06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class contains all the methods that are needed for the application.
 *
 * @author Teo
 */
public class Playground {
    private List<Person> persons = new ArrayList<>();

    public Playground() {
    }

    /**
     * This method is the heart of the application. At first, it checks if the target month is
     * valid - via the validateMonth(int) method. It also uses the methods readFile(Path)
     * and writeFile(Path) to get the input respectively to write the output.
     * Using a stream it filters the persons, so there remain only the once that were born in
     * a certain month (=targetMonth) and sorts these alphabetically after their first name.
     * The stream is then finally saved into the initial persons' list.
     *
     * @param inputFileName  String; the name of the input file
     * @param targetMonth    integer from 1 to 12
     * @param outputFileName String; the name of the file that will be created
     * @see #validateMonth(int)
     * @see #readFile(Path)
     * @see #writeFile(Path)
     */
    public void runApp(String inputFileName, int targetMonth, String outputFileName) {
        if (validateMonth(targetMonth) && readFile(Paths.get("190306_tema/resources/" + inputFileName))) {
            persons = persons
                    .stream()
                    .filter(person -> person.getDateOfBirth().getMonthValue() == targetMonth)
                    .sorted((p1, p2) -> p1.getFirstName().compareToIgnoreCase(p2.getFirstName()))
                    //.sorted(Comparator.comparing(Person::getFirstName)) //does same thing as line above
                    .collect(Collectors.toCollection(ArrayList::new));
            writeFile(Paths.get("190306_tema/resources/" + outputFileName));
            System.out.println("The " + outputFileName + " has been successfully created.");
        }
    }

    /**
     * Checks if the target month is a valid value between 1 and 12.
     *
     * @param targetMonth
     * @return true or false
     */
    public boolean validateMonth(int targetMonth) {
        if (targetMonth < 1 || targetMonth > 12) {
            System.out.println("Error: The target month isn't a value between 1 and 12.");
            return false;
        }
        return true;
    }

    /**
     * If the path is valid, it reads the input file and populates the persons' list.
     *
     * @param inPath of type Path; the relative path where the input file can be found
     * @return true if the input file was found, false if not
     */
    public boolean readFile(Path inPath) {
        String sCurrentLine;
        try (BufferedReader br = Files.newBufferedReader(inPath)) {
            while ((sCurrentLine = br.readLine()) != null) {
                String[] column = sCurrentLine.split(",");
                persons.add(new Person(column[0], column[1], stringToLocalDate(column[2])));
            }
        } catch (NoSuchFileException e) {
            System.out.println("The specified file doesn't exist. Check if you wrote the correct name.");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Converts the String str, having the pattern "dd-MM-yyyy", into an instance of type LocalDate.
     *
     * @param str String
     * @return instance of type LocalDate
     */
    public LocalDate stringToLocalDate(String str) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(str, format);
    }

    /**
     * Writes the content of the updated persons' list into the output file.
     *
     * @param outPath of type Path; the relative path, where we want to save the output file
     */
    public void writeFile(Path outPath) {
        try (BufferedWriter bw = Files.newBufferedWriter(outPath)) {
            for (Person person : persons)
                bw.write(person.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
