/**
 * @author Muhammad Fadhlan Harits
 * @version 22 April 2021
 */
import java.util.*;

public class JWork
{
    
    public static void main(String[] args)
    {
        Location location1 = new Location("DKI Jakarta", "Jakarta Selatan", "Kota di Jakarta"); 
         
        //Recruiter r1 = new Recruiter(28, "Fadhlan", "fadhlan@hotmail.com", "081234", location1);

        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId()+1, "Fadhlan", "fadhlan@hotmail.com", "081234", location1));
        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Fadhlan", "fadhlan@hotmail.com", "lalala", 2021, 4, 22));
        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Fadhlan", "fadhlan@hotmail.com", "lalala", 2021, 4, 22));
        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Fajar", "fajar@hotmail.com", "lalala", 2021, 4, 23));

        ArrayList<Jobseeker> jss = DatabaseJobseeker.getJobseekerDatabase();
        //for(Jobseeker js : jss){
          //  System.out.println(js.toString());
        //}

        DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Devops", DatabaseRecruiter.getRecruiterById(DatabaseRecruiter.getLastId()), 1000000, JobCategory.DevOps));
        DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Devops Engineer", DatabaseRecruiter.getRecruiterById(DatabaseRecruiter.getLastId()), 10000001, JobCategory.DevOps));
        DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Backend Engineer", DatabaseRecruiter.getRecruiterById(DatabaseRecruiter.getLastId()), 100000034, JobCategory.BackEnd));

        ArrayList<Job> j1 = DatabaseJob.getByCategory(JobCategory.DevOps);
       /* for(Job j : j1){
            System.out.println(j.toString());
        } */

        DatabaseBonus.addBonus(new Bonus(DatabaseBonus.getLastId()+1, "a123", 200, 100, false));
        DatabaseBonus.addBonus(new Bonus(DatabaseBonus.getLastId()+1, "a123", 300, 150, true));
        ArrayList<Bonus> bn1 = DatabaseBonus.getBonusDatabase();
       // for(Bonus bn : bn1){
           // System.out.println(bn.toString());
       // }
        ArrayList<Job> jj1 = new ArrayList<Job>();
        jj1.add(new Job(DatabaseJob.getLastId()+1, "Devops", DatabaseRecruiter.getRecruiterById(DatabaseRecruiter.getLastId()), 1000000, JobCategory.DevOps));

        ArrayList<Job> jj2 = new ArrayList<Job>();
        jj2.add(new Job(DatabaseJob.getLastId()+1, "Back End", DatabaseRecruiter.getRecruiterById(DatabaseRecruiter.getLastId()), 100, JobCategory.BackEnd));


        DatabaseInvoice.addInvoice(new BankPayment(DatabaseInvoice.getLastId(), jj1, DatabaseJobseeker.getJobseekerById(1)));
        int jsID = DatabaseJobseeker.getLastId();
        ArrayList<Invoice> i1 = DatabaseInvoice.getInvoiceByJobseeker(jsID);
        for (Invoice i : i1){
            i.setTotalFee();
        }

        DatabaseInvoice.addInvoice(new EwalletPayment(DatabaseInvoice.getLastId(), jj1, DatabaseJobseeker.getJobseekerById(1)));
        int jsID1 = DatabaseJobseeker.getLastId();
        ArrayList<Invoice> i2 = DatabaseInvoice.getInvoiceByJobseeker(jsID);
        for (Invoice i : i2){
            i.setTotalFee();
        }

        ArrayList<Invoice> ii = DatabaseInvoice.getInvoiceDatabase();
        for(Invoice i : ii){
            System.out.println(i.toString());
        }

        DatabaseInvoice.addInvoice(new EwalletPayment(DatabaseInvoice.getLastId(), jj1, DatabaseJobseeker.getJobseekerById(2), DatabaseBonus.getBonusById(1)));

        DatabaseBonus.activeBonus(1);
    }
}
