package MuhammadFadhlanHarits.jwork;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * @author Muhammad Fadhlan Harits
 * @version 22 April 2021
 */
public class BankPayment extends Invoice
{
    // variabel yang digunakan
    private static PaymentType PAYMENT_TYPE = PaymentType.BankPayment;
    private int adminFee;

    /**
     * Konstruktur kelas BankPayment
     * @param id, job, date, jobseeker, invoicestatus
     */
    public BankPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker)
    {
        super(id, jobs, jobseeker);
    }
    /**
     * Konstruktur kelas BankPayment
     * @param id, job, date, jobseeker, invoicestatus, adminfee
     */
    public BankPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker, int adminFee)
    {
        super(id, jobs, jobseeker);
        this.adminFee = adminFee;
        super.setDate(getDate());
    }
  /**
    * <p>Method mengambil paymenttype sehingga memiliki return paymenttype</p>
    * @return paymentType
    */
    public PaymentType getPaymentType()
    {
        return PAYMENT_TYPE;
    }
    /**
    * <p>Method mengambil adminfee sehingga memiliki return adminfee</p>
    * @return adminFee
    */
    public int getAdminFee()
    {
        return adminFee;
    }
    /**
    * <p>Method memberi nilai adminfee sehingga paramnya adalah adminfee</p>
    * @paramadminfee
     */
    public void setAdminFee(int adminFee)
    {
        this.adminFee = adminFee;
    }
    /**
    * <p>Method memberi nilai totalfee</p>
    * 
     */
    public void setTotalFee()
    {
        for(Job j : getJobs())
        {
            if(adminFee != 0)
            {
                totalFee = j.getFee() - getAdminFee();
            }
            else
            {
                totalFee = j.getFee();
            }
        }
    }
    public String toString()
    {
        String output="";
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        for(Job j : getJobs())
        {
            output = "\n==== INVOICE ====" + "\nID: " + getId() + "\nJob : " + j.getName() + "\nDate: " + sdf.format(getDate().getTime()) + "\nJobseeker: " + getJobseeker().getName() + "\nAdmin Fee: " + getAdminFee() + "\nTotal Fee: " + getTotalFee() + "\nInvoice Status: " + getInvoiceStatus() + "\nPayment type: " + getPaymentType();

        }
        return output;
    }
}
