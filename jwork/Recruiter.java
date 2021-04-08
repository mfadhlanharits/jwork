
/**
 * @author Muhammad Fadhlan Harits
 * @version 8 April 2021
 */
public class Recruiter
{
    //variabel yang digunakan
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private Location location;

   /**
    * <p>Konstruktur recruiter</p>
    * @param id, name, email, phoneNumber, location
     */
    public Recruiter(int id, String name, String email, String phoneNumber, Location location)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
    }
     /**
     * <p>Method ini akan mengambil ID recruiter sehingga returnnya id</p>
     * @return id
     */
    public int getID()
    {
        return id;
    }
     /**
     * <p>Method ini akan mengambil nama recruiter sehingga returnnya name</p>
     * @return name
     */
    public String getName()
    {
        return name;
    }
     /**
     * <p>Method ini akan mengambil email recruiter sehingga returnnya email</p>
     * @return email
     */
    public String getEmail()
    {
        return email;
    }
     /**
     * <p>Method ini akan mengambil nomor telepon recruiter sehingga returnnya phoneNumber</p>
     * @return phoneNumber
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
     /**
     * <p>Method ini akan mengambil lokasi recruiter sehingga returnnya location</p>
     * @return location
     */
    public Location getLocation()
    {
        return location;
    }
    /**
     * <p>Method ini akan memberi nilai id recruiter sehingga parameternya id</p>
     * @param id
     */
    public void setId(int id)
    {
        this.id=id;
    }
   /**
     * <p>Method ini akan memberi nilai email recruiter sehingga parameternya email</p>
     * @param email
     */
    public void setEmail(String email)
    {
        this.email=email;
    }
    /**
     * <p>Method ini akan memberi nilai nama recruiter sehingga parameternya name</p>
     * @param name
     */
    public void setName(String name)
    {
        this.name=name;
    }
    /**
     * <p>Method ini akan memberi nilai nomor telepon recruiter sehingga parameternya phonenumber</p>
     * @param phonenumber
     */
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber=phoneNumber;
    }
    /**
     * <p>Method ini akan memberi nilai lokasi recruiter sehingga parameternya location</p>
     * @param location
     */
    public void setLocation(Location location)
    {
        this.location=location;
    }
    //Method ini akan menampilkan nama recruiter
    public String toString()
    {
        return "\nID: " + getID() + "\nName: " + getName() + "\nPhone Number: " + getPhoneNumber() + "\nLocation: " + getLocation().getCity();
    }
}
