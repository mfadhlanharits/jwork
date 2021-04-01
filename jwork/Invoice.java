
/**
 * @author Muhammad Fadhlan Harits
 * @version 1 April 2021
 */
public abstract class Invoice
{
    // variabel yang digunakan
    private int id;
    private Job job;
    private String date;
    protected int totalFee;
    private Jobseeker jobseeker;
    private InvoiceStatus invoiceStatus;
    /**
    * <p>Konstruktur invoice</p>
    * @param id, idJob, date, totalFee, jobseeker, paymentType, status
     */
    public Invoice(int id, Job job, String date, Jobseeker jobseeker, InvoiceStatus invoiceStatus)
    {
        this.id = id;
        this.job = job;
        this.date = date;
        this.jobseeker = jobseeker;
        this.invoiceStatus = invoiceStatus;
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
    * <p>Method mengambil referralcode sehingga returnnya adalah referralcode</p>
    * @return idJob
     */
    public Job getJob()
    {
        return job;
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
    * <p>Method mengembalikan tipe pembayaran</p>
    * @return paymentType
     */
     public abstract PaymentType getPaymentType();
    /**
    * <p>Method mengembalikan status invoice</p>
    * @return status
     */
    public InvoiceStatus getInvoiceStatus()
    {
        return invoiceStatus;
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
    * <p>Method memberikan nilai pada pekerjaan</p>
    * @param Job
     */
     public void setJob(Job job)
    {
        this.job = job;
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
    public abstract void setTotalFee();
     /**
    * <p>Method memberikan nilai pada pelamar kerja</p>
    * @param jobseeker
     */
    public void setJobseeker(Jobseeker jobseeker)
    {
        this.jobseeker = jobseeker;
    }
    /**
    * <p>Method memberikan nilai pada  status invoice</p>
    * @param status
     */
    public void setInvoiceStatus(InvoiceStatus status)
    {
        this.invoiceStatus = invoiceStatus;
    }
    //Method menampilkan data
    public abstract void printData();
}
