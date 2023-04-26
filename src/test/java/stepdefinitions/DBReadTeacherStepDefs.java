package stepdefinitions;

import io.cucumber.java.en.*;

import java.sql.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DBReadTeacherStepDefs {
    ResultSet resultSet;
    Connection connection;
    Statement statement;

    @Given("Find teacher by ID")
    public void find_teacher_by_id() throws SQLException {
        //SELECT * FROM teacher WHERE id = 35;
        connection = DriverManager.getConnection("jdbc:postgresql://209.38.244.227:5432/school_management", "select_user", "43w5ijfso");
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM teacher WHERE id = 35");

        resultSet.next();

    }

    @Then("Validate data")
    public void validate_data() throws SQLException {

        assertEquals("2000-01-05", resultSet.getString("birth_day"));
        assertEquals("Ankara", resultSet.getString("birth_place"));
        assertEquals("MALE", resultSet.getString("gender"));
        assertEquals("Ali", resultSet.getString("name"));
        assertEquals("333-333-9955", resultSet.getString("phone_number"));
        assertEquals("222-55-9977", resultSet.getString("ssn"));
        assertEquals("Can", resultSet.getString("surname"));
        assertEquals("alican", resultSet.getString("username"));
        assertEquals("ali.can@gmail.com", resultSet.getString("email"));
        assertTrue(resultSet.getBoolean("is_advisor"));
        assertEquals(4, resultSet.getInt("user_role_id"));

        connection.close();
        statement.close();
        resultSet.close();

    }
}
