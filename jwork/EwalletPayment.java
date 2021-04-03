/**
 * @author Muhammad Fadhlan Harits
 * @version 1 April 2021
 */
public class EwalletPayment extends Invoice
{
    //variabel yang digunakan
    private static PaymentType PAYMENT_TYPE = PaymentType.EwalletPayment;
    private Bonus bonus;

    /**
     * Konstruktur kelas EwalletPayment
     * @param id, job, date, jobseeker, invoicestatus
     */
    public EwalletPayment(int id, Job job, String date, Jobseeker jobseeker, InvoiceStatus invoiceStatus)
    {
        super(id, job, date, jobseeker, invoiceStatus);
    }
    /**
     * Konstruktur kelas EwalletPayment
     * @param id, job, date, jobseeker, invoicestatus, bonus
     */
    public EwalletPayment(int id, Job job, String date, Jobseeker jobseeker, InvoiceStatus invoiceStatus, Bonus bonus)
    {
        super(id, job, date, jobseeker, invoiceStatus);
        this.bonus = bonus;
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
    * <p>Method mengambil bonus sehingga returnnya adalah bonus</p>
    * @return bonus
     */
    public Bonus getBonus()
    {
        return bonus;
    }
    /**
    * <p>Method menmberi nilai bonus sehingga paramnya adalah bonus</p>
    * @param bonus
     */
    public void setBonus(Bonus bonus)
    {
        this.bonus = bonus;
    }
    /**
    * <p>Method memberi nilai totalfee</p>
    * 
     */
    public void setTotalFee()
    {
        if(bonus != null && (bonus.getActive()==true) && getJob().getFee() >= bonus.getMinTotalFee())
        {
            totalFee = getJob().getFee() + bonus.getExtraFee();
        }
        else
        {
            totalFee = getJob().getFee();
        }
    }
    //method menampilkan data
    public void printData()
    {
        System.out.println("==== INVOICE ====");
        System.out.println("ID: " + getId());
        System.out.println("Job : " + getJob().getName());
        System.out.println("Date: " + getDate());
        System.out.println("Jobseeker: " + getJobseeker().getName());
        if(bonus != null && (bonus.getActive() == true) && getJob().getFee() >= bonus.getMinTotalFee())
        {
            System.out.println("Referral code: " + bonus.getReferralCode());
        }
        System.out.println("Total Fee: " + getTotalFee());
        System.out.println("Invoice Status: " + getInvoiceStatus());
        System.out.println("Payment type: " + getPaymentType());
    }
}
