package MuhammadFadhlanHarits.jwork;
/**
 * @author Muhammad Fadhlan Harits
 * @version 22 April 2021
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;

abstract class Invoice
{
    // variabel yang digunakan
    private int id;
    private ArrayList<Job> jobs;
    private Calendar date;
    protected int totalFee;
    private Jobseeker jobseeker;
    private InvoiceStatus invoiceStatus;
    /**
    * <p>Konstruktur invoice</p>
    * @param id, idJob, date, totalFee, jobseeker, paymentType, status
     */
    public Invoice(int id, ArrayList<Job> jobs, Jobseeker jobseeker)
    {
        this.id = id;
        this.jobs = jobs;
        this.jobseeker = jobseeker;
        this.invoiceStatus = InvoiceStatus.OnGoing;
        setDate(Calendar.getInstance());
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
    public ArrayList<Job> getJobs()
    {
        return jobs;
    }
    /**
    * <p>Method menentukan tanggal</p>
    * @return date
     */
    public Calendar getDate()
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
    * @param jobs
     */
     public void setJobs(ArrayList<Job> jobs)
    {
        this.jobs = jobs;
    }
     /**
    * <p>Method memberikan nilai pada tanggal</p>
    * @param date
     */
    public void setDate(Calendar date)
    {
        this.date = date;
    }
     /**
      * <p>Method memberikan nilai pada tanggal</p>
      * @paramdate
     */
    public void setDate(int year, int month, int dayOfMonth)
    {
        date = new GregorianCalendar(year, month, dayOfMonth);
    }
     /**
    * <p>Method memberikan nilai pada total bayaran</p>
    * @paramtotalFee
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
    * @paramstatus
     */
    public void setInvoiceStatus(InvoiceStatus invoiceStatus)
    {
        this.invoiceStatus = invoiceStatus;
    }
    //Method menampilkan data
    public abstract String toString();
}
