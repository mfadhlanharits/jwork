/**
 * @author Muhammad Fadhlan Harits
 * @version 10 April 2021
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

public class JWork
{
    
    public static void main(String[] args)
    {
        Location location1 = new Location("DKI Jakarta", "Jakarta Selatan", "Kota di Jakarta"); 
         
        Recruiter r1 = new Recruiter(28, "Fadhlan", "fadhlan@hotmail.com", "081234", location1);
         
        //Job j1 = new Job(23, "Javascript Engineer", r1, 30, JobCategory.WebDeveloper);
        
        Job j2 = new Job(98, "DevOps Engineer", r1, 40, JobCategory.DevOps);
        
        Calendar c1 = new GregorianCalendar();
        
        
        Jobseeker js1 = new Jobseeker(20, "Harits", ".harits@.hotmail.net", "pas", c1);
        
        Jobseeker js2 = new Jobseeker(22, "Fadhlan", "fadhlan@hotmail.net", "In1passW0rd", 2021, 11, 30);
        
        Jobseeker js3 = new Jobseeker(26, "david", "david@hotmail.net", "In1passW0rd");
        
        EwalletPayment ep1 = new EwalletPayment(40, j2, js1, InvoiceStatus.OnGoing);
        
        BankPayment bp1 = new BankPayment(42, j2, js1, InvoiceStatus.OnGoing);
        
        ep1.setDate(c1);
        bp1.setDate(c1);
        
        System.out.println(ep1.toString());
        System.out.println(bp1.toString());
    }
}
