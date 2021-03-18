
/**
 * @author Muhammad Fadhlan Harits
 * @version 18 Maret 2021
 */
public class Jobseeker
{
    //variabel yang digunakan
    private int id;
    private String name;
    private String email;
    private String password;
    private String joinDate;
    
    /**
    * <p>Konstruktur jobseeker</p>
    * @param id, name, email, password, joinDate
     */
    public Jobseeker(int id, String name, String email, String password, String joinDate)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
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
    public String getJoinDate()
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
        this.email=email;
    }
    /**
     * <p>Method ini akan memberi nilai password jobseeker sehingga parameternya nama</p>
     * @param password
     */
    public void setPassword(String password)
    {
        this.password=password;
    }
    /**
     * <p>Method ini akan memberi nilai tanggal jobseeker bergabung sehingga parameternya joindate</p>
     * @param joinDate
     */
    public void setJoinDate(String joinDate)
    {
        this.joinDate=joinDate;
    }
    //Method ini akan menampilkan nama pelamar
    public void printData()
    {
        System.out.println("Nama pelamar : " + getName());
    }
}
