import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String args[])
    {
        String jbdcUrl ="jdbc:SQLite:/C:\\Users\\Benjamin Moore\\Desktop\\test\\src\\SQLite\\Policies.db";

        try
        {
            Connection con = DriverManager.getConnection(jbdcUrl);
            String sql = "SELECT * FROM DATA";
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next())
            {
                String ID = result.getString("ID");
                String Topic = result.getString("Topic");
                String subTopic = result.getString("Subtopic");
                String question = result.getString("Question");
                System.out.println(ID + " | " + Topic + " | " + subTopic + " | " + question);
            }
        }

        catch (Exception e) {
            System.out.print(e);
        }
    }
}
