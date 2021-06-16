package MuhammadFadhlanHarits.jwork;
/**
 * @author Muhammad Fadhlan Harits
 * @version 27 Mei 2021
 */
import java.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class JWork {

    public static void main(String[] args) {

        Location location1 = new Location("DKI Jakarta", "Jakarta Selatan", "Kota di Jakarta");

        // Recruiter r1 = new Recruiter(28, "Fadhlan", "fadhlan@hotmail.com", "081234", location1);


        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Harits", "harits@hotmail.com", "081234", location1));

        try {
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "DevOps", DatabaseRecruiter.getRecruiterById(1), 250000, JobCategory.DevOps));
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, "Frontend Engineer", DatabaseRecruiter.getRecruiterById(1), 20000, JobCategory.FrontEnd));


        }
        catch (RecruiterNotFoundException e){
            System.out.println(e.getMessage());
        }


        SpringApplication.run(JWork.class, args);


    }
}