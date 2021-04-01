
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
         
        Job j1 = new Job(23, "Javascript Engineer", r1, 24000, JobCategory.WebDeveloper);
        
        Jobseeker js1 = new Jobseeker(20, "Harits", "harits@hotmail.com", "haritspass123", "27/03/2021");
        
        Bonus bn1 = new Bonus(35, "a123", 234, 33, true);
        
        EwalletPayment ep1 = new EwalletPayment(35, j1, "01-04-2021", js1, InvoiceStatus.OnGoing);
        
        EwalletPayment ep2 = new EwalletPayment(70, j1, "01-04-2021", js1, bn1, InvoiceStatus.OnGoing);
        
        EwalletPayment ep3 = new EwalletPayment(100, j1, "01-04-2021", js1, bn1, InvoiceStatus.OnGoing);
        
        ep2.totalFee = 12;
        
        ep3.totalFee = 400;
        
        ep1.printData();
        
        ep2.printData();
        
        ep3.printData();
    }
}
