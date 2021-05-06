/**
 * @author Muhammad Fadhlan Harits
 * @version 22 April 2021
 */
import java.util.*;

public class JWork {

    public static void main(String[] args) {
        Location location1 = new Location("DKI Jakarta", "Jakarta Selatan", "Kota di Jakarta");

        Recruiter r1 = new Recruiter(28, "Fadhlan", "fadhlan@hotmail.com", "081234", location1);

        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Fadhlan", "fadhlan@hotmail.com", "081234", location1));


        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Fadhlan", "fadhlan@hotmail.com", "081234", location1));

        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Fadhlan", "fadhlan@hotmail.com", "081234", location1));
      /*  try {
            DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Fadhlan", "fadhlan@hotmail.com", "lalala", 2021, 4, 22));
            DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Fadhlan", "fadhlan@hotmail.com", "lalala", 2021, 4, 22));
            DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "John", "John@hotmail.com", "lalala", 2021, 4, 23));
            DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Wick", "Wick@hotmail.com", "lalala", 2021, 4, 23));

            ArrayList<Jobseeker> jss = DatabaseJobseeker.getJobseekerDatabase();
            Jobseeker js1 = DatabaseJobseeker.getJobseekerById(5);
        }
        catch (EmailAlreadyExistsException e)
        {
            System.out.println(e.getMessage());
        } catch (JobSeekerNotFoundException e){
            System.out.println(e.getMessage());
        } */

        /*try {
            DatabaseBonus.addBonus(new Bonus(DatabaseBonus.getLastId()+1, "a125", 200, 100, false));
            DatabaseBonus.addBonus(new Bonus(DatabaseBonus.getLastId()+1, "a126", 300, 150, true));
            ArrayList<Bonus> bn1 = DatabaseBonus.getBonusDatabase();
           for (Bonus b : bn1){
               System.out.println(b.toString());
           }

        } catch (ReferralCodeAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

         */


        /*try {
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "Devops", DatabaseRecruiter.getRecruiterById(DatabaseRecruiter.getLastId()), 1000000, JobCategory.DevOps));
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "Devops Engineer", DatabaseRecruiter.getRecruiterById(DatabaseRecruiter.getLastId()), 10000001, JobCategory.DevOps));
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "Backend Engineer", DatabaseRecruiter.getRecruiterById(DatabaseRecruiter.getLastId()), 100000034, JobCategory.BackEnd));

            Job jj = DatabaseJob.getJobById(4);
            //System.out.println(jj.toString());


        } catch (JobNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (RecruiterNotFoundException e) {
            System.out.println(e.getMessage());
        }

         */
        try {
            DatabaseJobseeker.addJobseeker(new Jobseeker(1, "John", "jonathan@mail.com", "lalala", 2021, 4, 23));
            DatabaseJobseeker.addJobseeker(new Jobseeker(2, "Wick", "jonathan@hotmail.com", "lalala", 2021, 4, 23));

        }
        catch (EmailAlreadyExistsException e){
            System.out.println(e.getMessage());
        }

        DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "Devops", r1, 1000000, JobCategory.DevOps));
        DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "Devops Engineer", r1, 10000001, JobCategory.DevOps));
        DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "Backend Engineer", r1, 100000034, JobCategory.BackEnd));

        try {
            BankPayment bp1 = new BankPayment(1, DatabaseJob.getJobDatabase(), DatabaseJobseeker.getJobseekerById(1));
            BankPayment bp2 = new BankPayment(100, DatabaseJob.getJobDatabase(), DatabaseJobseeker.getJobseekerById(1));
            BankPayment bp3 = new BankPayment(101, DatabaseJob.getJobDatabase(), DatabaseJobseeker.getJobseekerById(1));
            DatabaseInvoice.addInvoice(bp1);
            DatabaseInvoice.addInvoice(bp2);
            DatabaseInvoice.addInvoice(bp3);

            ArrayList<Invoice> iv = DatabaseInvoice.getInvoiceDatabase();
            for(Invoice i : iv){
                new Thread(new FeeCalculator(i.getId())).start();
            }

        } catch (JobSeekerNotFoundException e){
            System.out.println(e.getMessage());
        }




        /*try {
            DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Fadhlan", "fadhlan@hotmail.com", "081234", location1));
            Recruiter rr = DatabaseRecruiter.getRecruiterById(3);
        } catch (RecruiterNotFoundException e) {
            System.out.println(e.getMessage());
        }

         */
    }
}