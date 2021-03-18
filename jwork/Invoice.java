
/**
 * @author Muhammad Fadhlan Harits
 * @version 18 Maret 2021
 */
public class Invoice
{
    // variabel yang digunakan
    private int id;
    private int idJob;
    private String date;
    private int totalFee;
    private Jobseeker jobseeker;
    /**
    * <p>Konstruktur invoice</p>
    * @param id, idJob, date, totalFee, jobseeker
     */
    public Invoice(int id, int idJob, String date, int totalFee, Jobseeker jobseeker)
    {
        this.id = id;
        this.idJob = idJob;
        this.date = date;
        this.totalFee = totalFee;
        this.jobseeker = jobseeker;
    }
    /**
    * <p>Method mengambil id invoice sehingga memiliki return id</p>
    * @return id
     */
    public int getId()
    {
        return id;
    }
    /**
    * <p>Method mengambil id pekerjaan dari kelas pekerjaan sehingga returnnya adalah idJob</p>
    * @return idJob
     */
    public int getIdJob()
    {
        return idJob;
    }
    /**
    * <p>Method menentukan tanggal</p>
    * @return date
     */
    public String getDate()
    {
        return date;
    }
    /**
    * <p>Method menentukan total bayaran</p>
    * @return totalFee
     */
     public int getTotalFee()
    {
        return totalFee;
    }
    /**
    * <p>Method mengembalikan jobseeker</p>
    * @return jobseeker
     */
    public Jobseeker getJobseeker()
    {
        return jobseeker;
    }
     /**
    * <p>Method memberikan nilai pada id</p>
    * @param id
     */
    public void setId(int id)
    {
        this.id = id;
    }
     /**
    * <p>Method memberikan nilai pada id pekerjaan</p>
    * @param idJob
     */
     public void setIdJob(int idJob)
    {
        this.idJob = idJob;
    }
     /**
    * <p>Method memberikan nilai pada tanggal</p>
    * @param date
     */
    public void setDate(String date)
    {
        this.date = date;
    }
     /**
    * <p>Method memberikan nilai pada total bayaran</p>
    * @param totalFee
     */
    public void setTotalFee(int totalFee)
    {
        this.totalFee = totalFee;
    }
     /**
    * <p>Method memberikan nilai pada pelamar kerja</p>
    * @param jobseeker
     */
    public void setJobseeker(Jobseeker jobseeker)
    {
        this.jobseeker = jobseeker;
    }
    public void printData()
    {
    }
}
