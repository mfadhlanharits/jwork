/**
 * @author Muhammad Fadhlan Harits
 * @version 10 April 2021
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
        for(Jobseeker js : jss){
            System.out.println(js.toString());
        }

        DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Devops", DatabaseRecruiter.getRecruiterById(28), 1000000, JobCategory.DevOps));
        DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Devops Engineer", DatabaseRecruiter.getRecruiterById(28), 10000001, JobCategory.DevOps));
        DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Backend Engineer", DatabaseRecruiter.getRecruiterById(28), 100000034, JobCategory.BackEnd));

        ArrayList<Job> jjj = DatabaseJob.getByCategory(JobCategory.DevOps);
        for(Job j : jjj){
            System.out.println(j.toString());
        }
    }
}
