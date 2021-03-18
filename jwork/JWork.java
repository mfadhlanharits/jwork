
/**
 * @author Muhammad Fadhlan Harits
 * @version (a version number or a date)
 */
public class JWork
{
    
    public static void main(String[] args)
    {
         Jobseeker js1 = new Jobseeker(21, "Arthur", "arthur@hotmail.com", "123", "28-02-2020");
         Invoice in = new Invoice(23, 20, "24-02-2021", 45000, js1);
    }
}
