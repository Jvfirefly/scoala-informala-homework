package ro.sci.teo.mar25;

import java.sql.SQLException;

/**
 * This is the main class where the required methods are used.
 * @author Teo
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/school?user=root&password=password";
        SchoolDBO schoolDBO = new SchoolDBO(url);

        System.out.println("All clases:");
        schoolDBO.printClasses();

        System.out.println("\nCourse with id=200:");
        schoolDBO.printCourseWithId(200);

        System.out.println("\nAll clases with title starting with \"intro\":");
        schoolDBO.printClassesWithTitle("inTRo");

        System.out.println("\nAll clases with dept=\"cos\" and coursenum beginning with \"3\":");
        schoolDBO.printClassesWithDeptAndCourseNum("cOs", 3);

        schoolDBO.closeConnection();
    }
}
