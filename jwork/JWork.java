
/**
 * @author Muhammad Fadhlan Harits
 * @version 25 Maret 2021
 */
public class JWork
{
    
    public static void main(String[] args)
    {
        Location location1 = new Location("DKI Jakarta", "Jakarta Selatan", "Kota di Jakarta"); 
         
        Recruiter r1 = new Recruiter(28, "Fadhlan", "fadhlan@hotmail.com", "081234", location1);
         
        Job j1 = new Job(23, "Javascript Engineer", r1, 24000, JobCategory.WebDeveloper);
        
        Jobseeker js1 = new Jobseeker(20, "Harits", "harits@hotmail.com", "haritspass123", "27/03/2021");
        
        Invoice iv1 = new Invoice(30, j1.getId(), "27/03/2021", j1.getFee(), js1, PaymentType.BankPayment, InvoiceStatus.OnGoing);
         
        iv1.printData();
        
    }
}
