
/**
 * @author Muhammad Fadhlan Harits
 * @version (a version number or a date)
 */
public class JWork
{
    
    public static void main(String[] args)
    {
         Location location1 = new Location("DKI Jakarta", "Jakarta Selatan", "Kota di Jakarta"); 
         Recruiter r1 = new Recruiter(23, "Elon", "elon@hotmail.com", "081234", location1);
         Job j = new Job(23, "engineer", r1, 24000, "tech");
         Jobseeker js1 = new Jobseeker(21, "Arthur", "arthur@hotmail.com", "123", "28-02-2020");
         Invoice in = new Invoice(23, 20, "24-02-2021", 45000, js1);
    }
}
