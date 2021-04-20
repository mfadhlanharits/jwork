
/**
 * @author Muhammad Fadhlan Harits
 * @version 8 April 2021
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.text.SimpleDateFormat;
public class Jobseeker
{
    //variabel yang digunakan
    private int id;
    private String name;
    private String email;
    private String password;
    public Calendar joinDate;
    
    /**
    * <p>Konstruktur jobseeker</p>
    * @param id, name, email, password, joinDate
     */
    public Jobseeker(int id, String name, String email, String password, Calendar joinDate)
    {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        this.joinDate = joinDate;
    }
    /**
    * <p>Konstruktur jobseeker</p>
    * @param id, name, email, password, year, month, dayOfMonth
     */
    public Jobseeker(int id, String name, String email, String password, int year, int month, int dayOfMonth)
    {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        this.joinDate = new GregorianCalendar(year, month-1, dayOfMonth);
    }
    /**
    * <p>Konstruktur jobseeker tanpa joinDate</p>
    * @param id, name, email, password
     */
    public Jobseeker(int id, String name, String email, String password)
    {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);

    }
    /**
     * <p>Method ini akan mengambil ID jobseeker sehingga returnnya id</p>
     * @return id
     */
    public int getID()
    {
        return id;
    }
    /**
     * <p>Method ini akan mengambil nama jobseeker sehingga returnnya nama</p>
     * @return name
     */
    public String getName()
    {
        return name;
    }
    /**
     * <p>Method ini akan mengambil email jobseeker sehingga returnnya email</p>
     * @return email
     */
    public String getEmail()
    {
        return email;
    }
    /**
     * <p>Method ini akan mengambil password jobseeker sehingga returnnya password</p>
     * @return password
     */
    public String getPassword()
    {
        return password;
    }
    /**
     * <p>Method ini akan mengambil tanggal jobseeker bergabung sehingga returnnya joindate</p>
     * @return joinDate
     */
    public Calendar getJoinDate()
    {
        return joinDate;
    }
    /**
     * <p>Method ini akan memberi nilai ID jobseeker sehingga parameternya id</p>
     * @param id
     */
    public void setId(int id)
    {
        this.id=id;
    }
    /**
     * <p>Method ini akan memberi nilai nama jobseeker sehingga parameternya nama</p>
     * @param name
     */
    public void setName(String name)
    {
        this.name=name;
    }
    /**
     * <p>Method ini akan memberi nilai email jobseeker sehingga parameternya email</p>
     * @param email
     */
    public void setEmail(String email)
    {
        String re = "^(?!.*([.])\1)[^.][a-zA-Z0-9.&*_~]+@[^-. ][a-zA-Z0-9-.&*_~]+(?:\\.[a-zA-Z0-9-]+)*";
        Pattern p = Pattern.compile(re);
        Matcher m = p.matcher(email);
        if(m.find())
        {
            this.email = email;
        }
        else
        {
            this.email = "";
        }
    }
    /**
     * <p>Method ini akan memberi nilai password jobseeker sehingga parameternya nama</p>
     * @param password
     */
    public void setPassword(String password)
    {
        String re = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,}$";
        Pattern p = Pattern.compile(re);
        Matcher m = p.matcher(password);
        if(m.find())
        {
            this.password = password;
        }
        else
        {
            this.password = "";
        }
    }
    /**
     * <p>Method ini akan memberi nilai tanggal jobseeker bergabung sehingga parameternya joindate</p>
     * @param joinDate
     */
    public void setJoinDate(Calendar joinDate)
    {
        this.joinDate=joinDate;
    }
    /**
     * <p>Method ini akan memberi nilai tanggal jobseeker bergabung sehingga parameternya joindate</p>
     * @param joinDate
     */
    public void setJoinDate(int year, int month, int dayOfMonth)
    {
        joinDate.set(year, month-1, dayOfMonth);
    }
    //Method ini akan menampilkan nama pelamar
    public String toString()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        if(this.joinDate != null)
        {
            return "==== JOBSEEKER ====" + "\nID: " + getID() + "\nNama: " + getName() + "\nEmail: " + getEmail() + "\nPassword: " + getPassword() + "\nJoin Date: " + sdf.format(getJoinDate().getTime()) + "\n";
        }
        return "==== JOBSEEKER ====" + "\nID: " + getID() + "\nNama: " + getName() + "\nEmail: " + getEmail() + "\nPassword: " + getPassword() + "\n";
    }
    
}
