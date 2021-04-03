
/**
 * @author Muhammad Fadhlan Harits
 * @version 1 April 2021
 */
public class JWork
{
    
    public static void main(String[] args)
    {
        Location location1 = new Location("DKI Jakarta", "Jakarta Selatan", "Kota di Jakarta"); 
         
        Recruiter r1 = new Recruiter(28, "Fadhlan", "fadhlan@hotmail.com", "081234", location1);
         
        //Job j1 = new Job(23, "Javascript Engineer", r1, 30, JobCategory.WebDeveloper);
        
        Job j2 = new Job(98, "DevOps Engineer", r1, 40, JobCategory.DevOps);
        
        Jobseeker js1 = new Jobseeker(20, "Harits", "harits@hotmail.com", "haritspass123", "27/03/2021");
        
        BankPayment bp1 = new BankPayment(101, j2, "3 April 2021", js1, InvoiceStatus.Finished);
        
        BankPayment bp2 = new BankPayment(102, j2, "3 April 2021", js1, InvoiceStatus.Finished, 10);
        
        bp1.setTotalFee();
        
        bp2.setTotalFee();
        
        bp1.printData();
        
        bp2.printData();
    }
}
