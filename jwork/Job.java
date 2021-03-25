
/**
 * @author Muhammad Fadhlan Harits
 * @version 25 Maret 2021
 */
public class Job
{
    //variabel yang digunakan
    private int id;
    private String name;
    private Recruiter recruiter;
    private int fee;
    private JobCategory category;
    /**
    *<p>Konstruktur invoice</p>
    *@param id, name, recruiter, fee, category
     */
    public Job(int id, String name, Recruiter recruiter, int fee, JobCategory category)
    {
        this.id = id;
        this.name = name;
        this.recruiter = recruiter;
        this.fee = fee;
        this.category = category;
    }
    /**
    *<p>Method untuk menentukan ID</p>
    *@return id
     */
    public int getId()
    {
        return id;
    }
     /**
    *<p>Method untuk menentukan nama</p>
    *@return name
     */
    public String getName()
    {
        return name;
    }
     /**
    *<p>Method untuk menentukan bayaran</p>
    *@return fee
     */
    public int getFee()
    {
        return fee;
    }
     /**
    *<p>Method untuk menentukan nama</p>
    *@return category
     */
    public JobCategory getCategory()
    {
        return category;
    }
     /**
    *<p>Method untuk mengembalikan recruiter</p>
    *@return recruiter
     */
    public Recruiter getRecruiter()
    {
        return recruiter;
    }
    /**
    *<p>Method untuk memberikan nilai pada ID</p>
    *@param id
     */
    public void setId(int id)
    {
        this.id = id;
    }
    /**
    *<p>Method untuk memberikan nilai pada nama</p>
    *@param name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    /**
    *<p>Method untuk memberikan nilai pada recruiter</p>
    *@param recruiter
     */
    public void setRecruiter(Recruiter recruiter)
    {
        this.recruiter = recruiter;
    }
    /**
    *<p>Method untuk memberikan nilai pada bayaran</p>
    *@param fee
     */
    public void setFee(int fee)
    {
        this.fee = fee;
    }
    /**
    *<p>Method untuk memberikan nilai pada kategori</p>
    *@param category
     */
    public void setCategory(JobCategory category)
    {
        this.category = category;
    }
    public void printData()
    {
        System.out.println("======= JOB ======= ");
        System.out.println("ID: " + getId());
        System.out.println("Name: " +getName());
        System.out.println("Recruiter: " + getRecruiter().getName());
        System.out.println("City: " + getRecruiter().getLocation().getCity());
        System.out.println("Fee: " +getFee());
        System.out.println("Category: " +getCategory());
    }
}
