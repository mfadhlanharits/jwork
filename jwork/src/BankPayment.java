import java.text.SimpleDateFormat;

/**
 * @author Muhammad Fadhlan Harits
 * @version 10 April 2021
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
    public BankPayment(int id, Job job, Jobseeker jobseeker, InvoiceStatus invoiceStatus)
    {
        super(id, job, jobseeker, invoiceStatus);
    }
    /**
     * Konstruktur kelas BankPayment
     * @param id, job, date, jobseeker, invoicestatus, adminfee
     */
    public BankPayment(int id, Job job, Jobseeker jobseeker, InvoiceStatus invoiceStatus, int adminFee)
    {
        super(id, job, jobseeker, invoiceStatus);
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
    * @param adminfee
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
        if(adminFee != 0)
        {
            totalFee = getJob().getFee() - getAdminFee();
        }
        else
        {
            totalFee = getJob().getFee();
        }
    }
    public String toString()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        return "==== INVOICE ====" + "\nID: " + getId() + "\nJob : " + getJob().getName() + "\nDate: " + sdf.format(getDate().getTime()) + "\nJobseeker: " + getJobseeker().getName() + "\nAdmin Fee: " + getAdminFee() + "\nTotal Fee: " + getTotalFee() + "\nInvoice Status: " + getInvoiceStatus() + "\nPayment type: " + getPaymentType();
    }
}
