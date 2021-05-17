package MuhammadFadhlanHarits.jwork;
/**
 * @author Muhammad Fadhlan Harits
 * @version 8 Mei 2021
 */
import java.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class JWork {

    public static void main(String[] args) {
        SpringApplication.run(JWork.class, args);

        Location location1 = new Location("DKI Jakarta", "Jakarta Selatan", "Kota di Jakarta");

       // Recruiter r1 = new Recruiter(28, "Fadhlan", "fadhlan@hotmail.com", "081234", location1);

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
        try {
            DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "John", "jonathan@mail.com", "lalala", 2021, 4, 23));
            DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Wick", "wick@hotmail.com", "lalala", 2021, 4, 23));
            DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Dave", "dave@hotmail.com", "lalala", 2021, 4, 23));

        }
        catch (EmailAlreadyExistsException e){
            System.out.println(e.getMessage());
        }

        try {
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "Data Analyst", DatabaseRecruiter.getRecruiterById(1), 1000000, JobCategory.DataAnalyst));
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "Devops Engineer", DatabaseRecruiter.getRecruiterById(2), 10000001, JobCategory.DevOps));
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "Backend Engineer", DatabaseRecruiter.getRecruiterById(3), 100000034, JobCategory.BackEnd));

        }
        catch (RecruiterNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            BankPayment bp1 = new BankPayment(DatabaseInvoice.getLastId()+1, DatabaseJob.getJobDatabase(), DatabaseJobseeker.getJobseekerById(1), 5);
            bp1.setInvoiceStatus(InvoiceStatus.Finished);
            DatabaseInvoice.addInvoice(bp1);
            BankPayment bp2 = new BankPayment(DatabaseInvoice.getLastId()+1, DatabaseJob.getJobDatabase(), DatabaseJobseeker.getJobseekerById(2), 7);
            bp2.setInvoiceStatus(InvoiceStatus.Finished);
            DatabaseInvoice.addInvoice(bp2);
            DatabaseInvoice.removeInvoice(3);

        } catch (JobSeekerNotFoundException e){
            System.out.println(e.getMessage());
        } catch (OngoingInvoiceAlreadyExistsException e){
            System.out.println(e.getMessage());
        } catch (InvoiceNotFoundException e){
            System.out.println(e.getMessage());
        }

    }
}