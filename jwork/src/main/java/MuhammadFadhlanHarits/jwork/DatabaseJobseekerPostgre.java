/**
 * @author Muhammad Fadhlan Harits
 * @version 5 Juni 2021
 */
package MuhammadFadhlanHarits.jwork;


import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DatabaseJobseekerPostgre extends DatabaseConnectionPostgre
{
    private static ArrayList<Jobseeker> JOBSEEKER_DATABASE = new ArrayList<Jobseeker>();
    private static int lastId;

    /**
     * Akan mengembalikan database pelamar sehingga returnnya JOBSEEKER_DATABASE
     * @return JOBSEEKER DATABASE
     */
    public static ArrayList<Jobseeker> getJobseekerDatabase() throws SQLException {
        JOBSEEKER_DATABASE.clear();
        Connection c = connection();
        PreparedStatement st;
        String name = null;
        String email = null;
        String password = null;
        Jobseeker js = null;
        String query = "SELECT * FROM jobseeker;";
        st = c.prepareStatement(query);
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            lastId = rs.getInt("id");
            name = rs.getString("name");
            email = rs.getString("email");
            password = rs.getString("password");
            js = new Jobseeker(lastId, name, email, password);
            JOBSEEKER_DATABASE.add(js);
        }
        return JOBSEEKER_DATABASE;
    }



    /**
     * Akan menambah pelamar sehingga parameternya jobseeker
     * @param jobseeker
     */
    public static Jobseeker insertJobseeker(Jobseeker jobseeker) throws EmailAlreadyExistsException
    {
        Connection c = connection();
        PreparedStatement st;
        Jobseeker js = null;
        try{
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
            String query = "INSERT INTO jobseeker (id, name, email, password, joindate) VALUES (?,?,?,?,?) RETURNING id;";
            st = c.prepareStatement(query);
            st.setInt(1, DatabaseJobseekerPostgre.getLastJobseekerId()+1);
            st.setString(2, jobseeker.getName());
            st.setString(3, jobseeker.getEmail());
            st.setString(4, jobseeker.getPassword());
            st.setString(5, sdf.format(date.getTime()));
            ResultSet rs = st.executeQuery();

            js = new Jobseeker(DatabaseJobseekerPostgre.getLastJobseekerId()+1, jobseeker.getName(), jobseeker.getEmail(), jobseeker.getPassword());
            st.close();
            c.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return js;
    }

    /**
     * Akan mengembalikan id terakhir sehingga returnnya lastId
     * @return lastId
     */
    public static int getLastJobseekerId() throws SQLException {
        Connection c = connection();
        PreparedStatement st;
        lastId=0;
        String query = "SELECT id FROM jobseeker;";
        st = c.prepareStatement(query);
        ResultSet rs = st.executeQuery();
        while (rs.next()){
            lastId = rs.getInt(1);
        }
        st.close();
        c.close();

        return lastId;
    }

    /**
     * Akan mengembalikan database pelamar sehingga returnnya js
     * @return js
     */
    public static Jobseeker getJobseeker(String emailjs, String passjs) throws SQLException {
        Connection c = connection();
        PreparedStatement st;
        int id = 0;
        String name = null;
        String email = null;
        String password = null;
        String joinDate = null;
        Jobseeker js;
        String query = "SELECT id, name, email, password, joindate FROM jobseeker WHERE email=? AND password=?;";
        st = c.prepareStatement(query);
        st.setString(1, emailjs);
        st.setString(2, passjs);
        ResultSet rs = st.executeQuery();
        while (rs.next()){
            id = rs.getInt("id");
            name = rs.getString("name");
            email = rs.getString("email");
            password = rs.getString("password");
            joinDate = rs.getString("joindate");
        }
        st.close();
        c.close();
        js = new Jobseeker(id, name, email, password);
        return js;
    }

    /**
     * Akan menghapus pelamar sehingga parameternya id
     * @param id
     */
    public static boolean removeJobseeker(int id){
        Connection c = connection();
        PreparedStatement st;
        boolean b;
        try{
            String query = "DELETE FROM jobseeker WHERE id=?;";
            st = c.prepareStatement(query);
            st.setInt(1, id);
            st.execute();
            st.close();
            c.close();
            b = true;
        } catch (SQLException e){
            b = false;
            e.printStackTrace();
        }
        return b;
    }

    /**
     * Akan melakukan login jobseeker sehingga parameternya email dan password
     * @param  email, password
     */
    public static Jobseeker jobseekerLogin(String email, String password) throws SQLException
    {
        Jobseeker js1 = null;
        for(Jobseeker js : getJobseekerDatabase()){
            if(js.getEmail().equals(email) && js.getPassword().equals(password)){
                js1 = js;
            }
        }

        return js1;
    }

    /**
     * Akan mengembalikan jobseeker berdasarkan id sehingga returnnya jobseeker
     * @param  id
     */
    public static Jobseeker getJobseekerFromId(int id) throws JobSeekerNotFoundException
    {
        Connection c = connection();
        Jobseeker js1 = null;
        PreparedStatement st;
        int idjs = 0;
        String name = null;
        String email = null;
        String password = null;
        try{
            String query = "SELECT * FROM jobseeker WHERE id=?;";
            st = c.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                idjs = rs.getInt("id");
                name = rs.getString("name");
                email = rs.getString("email");
                password = rs.getString("password");
            }
            st.close();
            c.close();
            js1 = new Jobseeker(idjs, name, email, password);
        } catch(SQLException e){
            e.printStackTrace();
        }
        if(js1==null)
        {
            JobSeekerNotFoundException e = new JobSeekerNotFoundException(id);
            System.out.println(e.getMessage());
        }
        return js1;
    }
}
