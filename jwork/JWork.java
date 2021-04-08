
/**
 * @author Muhammad Fadhlan Harits
 * @version 1 April 2021
 */
import java.util.Calendar;
public class JWork
{
    
    public static void main(String[] args)
    {
        Location location1 = new Location("DKI Jakarta", "Jakarta Selatan", "Kota di Jakarta"); 
         
        Recruiter r1 = new Recruiter(28, "Fadhlan", "fadhlan@hotmail.com", "081234", location1);
         
        //Job j1 = new Job(23, "Javascript Engineer", r1, 30, JobCategory.WebDeveloper);
        
        Job j2 = new Job(98, "DevOps Engineer", r1, 40, JobCategory.DevOps);
        
        Calendar c1 = Calendar.getInstance();
        
        Jobseeker js1 = new Jobseeker(20, "Harits", ".harits@.hotmail.net", "pas", c1);
        
        Jobseeker js2 = new Jobseeker(22, "Fadhlan", "fadhlan@hotmail.net", "In1passW0rd", 2021, 11, 30);
        
        Jobseeker js3 = new Jobseeker(26, "james", "james@hotmail.net", "In1passW0rd");
        
        System.out.println(js1.toString());
        System.out.println("");
        System.out.println(js2.toString());
        System.out.println("");
        System.out.println(js3.toString());
    }
}
