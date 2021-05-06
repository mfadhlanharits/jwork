import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * @author Muhammad Fadhlan Harits
 * @version 22 April 2021
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
    public EwalletPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker)
    {
        super(id, jobs, jobseeker);
    }
    /**
     * Konstruktur kelas EwalletPayment
     * @param id, job, date, jobseeker, invoicestatus, bonus
     */
    public EwalletPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker, Bonus bonus)
    {
        super(id, jobs, jobseeker);
        super.setDate(getDate());
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
        for(Job j : getJobs())
        {
            if (bonus != null && (bonus.getActive() == true) && j.getFee() >= bonus.getMinTotalFee())
            {
                totalFee = j.getFee() + bonus.getExtraFee();
            }
            else
            {
                totalFee = j.getFee();
            }
        }
    }

    //method menampilkan data
    public String toString()
    {
        String output="";
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        for(Job j : getJobs()){
            if (bonus != null && (bonus.getActive() == true) && j.getFee() >= bonus.getMinTotalFee()) {
                output = "==== PAYMENT ====" + "\nID: " + getId() + "\nJob : " + j.getName() + "\nDate: " + sdf.format(getDate().getTime()) + "\nJobseeker: " + getJobseeker().getName() + "\nReferral code: " + bonus.getReferralCode() + "\nTotal Fee: " + getTotalFee() + "\nInvoice Status: " + getInvoiceStatus() + "\nPayment type: " + getPaymentType();
            }
            output = "==== PAYMENT ====" + "\nID: " + getId() + "\nJob : " + j.getName() + "\nDate: " + sdf.format(getDate().getTime()) + "\nJobseeker: " + getJobseeker().getName() + "\nTotal Fee: " + getTotalFee() + "\nInvoice Status: " + getInvoiceStatus() + "\nPayment type: " + getPaymentType();

        }
        return output;
    }
}
