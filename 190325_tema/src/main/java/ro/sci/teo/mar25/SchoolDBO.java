package ro.sci.teo.mar25;

import java.sql.*;

/**
 * This class represents the database operator (DBO), where I establish the database connection and I implement
 * the required methods.
 * @author Teo
 */
public class SchoolDBO {
    private Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            System.err.println("Can't load driver. Verify CLASSPATH");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public SchoolDBO(String url) throws SQLException {
        DriverManager.setLoginTimeout(60);
        this.connection = DriverManager.getConnection(url);
    }

    private void checkConnection() {
        if (this.connection == null)
            throw new IllegalStateException("Connection already closed.");
    }

    private void closeConnection() {
        checkConnection();

        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints data for all classes from the school database.
     */
    public void printClasses() {
        checkConnection();

        Statement st = null;
        ResultSet rs = null;
        final String format = "%10s%20s%20s%20s%20s%20s%20s\n";
        try {
            st = this.connection.createStatement();
            rs = st.executeQuery("select * from classes");
            boolean hasResults = rs.next();
            if (hasResults) {
                System.out.format(format, "ClassId", "CourseId", "Days", "StartTime", "EndTime", "Building", "RoomNum");
                do {
                    System.out.format(format, rs.getInt("classid"), rs.getInt("courseid"),
                            rs.getInt("days"), rs.getString("starttime"),
                            rs.getString("endtime"), rs.getString("bldg"),
                            rs.getString("roomnum"));
                } while (rs.next());
            } else {
                System.out.println("No results");
            }
        } catch (SQLException e) {
            System.err.println("Cannot execute query: " + e.getMessage());
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
            }
            if (st != null) try {
                st.close();
            } catch (SQLException e) {
            }
        }
    }

    /**
     * Prints data for a course with a certain courseId.
     * @param courseId
     */
    public void printCourseWithId(int courseId) {
        checkConnection();

        Statement st = null;
        ResultSet rs = null;
        final String format = "%10s%20s%20s%50s%50s\n";
        try {
            st = this.connection.createStatement();
            rs = st.executeQuery("select * from courses where courseid=" + courseId);
            boolean hasResults = rs.next();
            if (hasResults) {
                System.out.format(format, "CourseId", "Area", "Title", "Description", "Prerequisites");
                do {
                    System.out.format(format, rs.getInt("courseid"), rs.getString("area"),
                            rs.getString("title"), rs.getString("descrip"),
                            rs.getString("prereqs"));
                } while (rs.next());
            } else {
                System.out.println("No results");
            }
        } catch (SQLException e) {
            System.err.println("Cannot execute query: " + e.getMessage());
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
            }
            if (st != null) try {
                st.close();
            } catch (SQLException e) {
            }
        }
    }

    /**
     * Prints data for all classes whose title (converted to lowercase letters) begins with a certain String.
     * @param titleBeginning
     */
    public void printClassesWithTitle(String titleBeginning) {
        checkConnection();

        Statement st = null;
        ResultSet rs = null;
        final String format = "%10s%20s%20s%20s%20s%20s%20s%20s\n";
        try {
            st = this.connection.createStatement();
            rs = st.executeQuery("select classid, classes.courseid, days, starttime, endtime, bldg, roomnum," +
                    "courses.title from classes inner join courses on classes.courseid = courses.courseid " +
                    "where lower(courses.title) like lower('" + titleBeginning + "%')");
            boolean hasResults = rs.next();
            if (hasResults) {
                System.out.format(format, "ClassId", "CourseId", "Days", "StartTime", "EndTime", "Building", "RoomNum",
                        "Title");
                do {
                    System.out.format(format, rs.getInt("classid"), rs.getInt("classes.courseid"),
                            rs.getInt("days"), rs.getString("starttime"),
                            rs.getString("endtime"), rs.getString("bldg"),
                            rs.getString("roomnum"), rs.getString("courses.title"));
                } while (rs.next());
            } else {
                System.out.println("No results");
            }
        } catch (SQLException e) {
            System.err.println("Cannot execute query: " + e.getMessage());
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
            }
            if (st != null) try {
                st.close();
            } catch (SQLException e) {
            }
        }
    }

    /**
     * Prints data for all classes whose dept (converted to lowercase letters) is a certain String and
     * whose coursenum begins with a certain digit.
     * Since this is the last method in use, it also closes the connection to the school database.
     * @param dept
     * @param courseNumBeginning
     */
    public void printClassesWithDeptAndCourseNum(String dept, int courseNumBeginning) {
        checkConnection();

        Statement st = null;
        ResultSet rs = null;
        final String format = "%10s%20s%20s%20s%20s%20s%20s%20s%20s\n";
        try {
            st = this.connection.createStatement();
            rs = st.executeQuery("select classid, classes.courseid, days, starttime, endtime, bldg, roomnum, " +
                    "dept, coursenum from classes inner join crosslistings on classes.courseid = crosslistings.courseid " +
                    "where lower(dept) like lower('" + dept + "') and coursenum regexp '^" + courseNumBeginning + "'");
            boolean hasResults = rs.next();
            if (hasResults) {
                System.out.format(format, "ClassId", "CourseId", "Days", "StartTime", "EndTime", "Building", "RoomNum",
                        "Department", "CourseNum");
                do {
                    System.out.format(format, rs.getInt("classid"), rs.getInt("courseid"),
                            rs.getInt("days"), rs.getString("starttime"),
                            rs.getString("endtime"), rs.getString("bldg"),
                            rs.getString("roomnum"), rs.getString("dept"),
                            rs.getString("coursenum"));
                } while (rs.next());
            } else {
                System.out.println("No results");
            }
        } catch (SQLException e) {
            System.err.println("Cannot execute query: " + e.getMessage());
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
            }
            if (st != null) try {
                st.close();
            } catch (SQLException e) {
            }

            closeConnection();
        }
    }
}
