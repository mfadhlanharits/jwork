
/**
 * @author Muhammad Fadhlan Harits
 * @version 3 April 2021
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
    public BankPayment(int id, Job job, String date, Jobseeker jobseeker, InvoiceStatus invoiceStatus)
    {
        super(id, job, date, jobseeker, invoiceStatus);
    }
    /**
     * Konstruktur kelas BankPayment
     * @param id, job, date, jobseeker, invoicestatus, adminfee
     */
    public BankPayment(int id, Job job, String date, Jobseeker jobseeker, InvoiceStatus invoiceStatus, int adminFee)
    {
        super(id, job, date, jobseeker, invoiceStatus);
        this.adminFee = adminFee;
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
        if(adminFee > 0)
        {
            totalFee = getJob().getFee() - getAdminFee();
        }
        else
        {
            totalFee = getJob().getFee();
        }
    }
    public void printData()
    {
        System.out.println("==== INVOICE ====");
        System.out.println("ID: " + getId());
        System.out.println("Job : " + getJob().getName());
        System.out.println("Date: " + getDate());
        System.out.println("Jobseeker: " + getJobseeker().getName());
        System.out.println("Admin Fee: " + getAdminFee());
        System.out.println("Total Fee: " + getTotalFee());
        System.out.println("Invoice Status: " + getInvoiceStatus());
        System.out.println("Payment type: " + getPaymentType());
    }
}
