/**
 * @author Muhammad Fadhlan Harits
 * @version 5 Juni 2021
 */
package MuhammadFadhlanHarits.jwork;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnectionPostgre
{
    /**
     * Akan membuat koneksi dengan database sehingga returnnya connection
     * @return c
     */
    public static Connection connection(){
        //Variabel yang digunakan serta username dan password untuk mengakses database
        Connection c = null;
        Statement stat = null;
        String db_name = "jwork";
        String db_user = "postgres";
        String db_password = "harits2804";

        //Akan membuat koneksi dengan kelas driver postgresql
        try{
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+db_name,db_user,db_password);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        return c;
    }
}
