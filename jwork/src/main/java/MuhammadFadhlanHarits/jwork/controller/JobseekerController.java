/**
 * @author Muhammad Fadhlan Harits
 * @version 20 Mei 2021
 */
package MuhammadFadhlanHarits.jwork.controller;

import MuhammadFadhlanHarits.jwork.*;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RequestMapping("/jobseeker")
@RestController

public class JobseekerController
{
    /**
     * akan mengembalikan jobseeker berdasarkan id
     * @param id
     * @return jobseeker
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Jobseeker getJobseekerById(@PathVariable int id) {
        Jobseeker jobseeker = null;
        try {
            jobseeker = DatabaseJobseeker.getJobseekerById(id);
        } catch (JobSeekerNotFoundException e) {
            e.getMessage();
            return null;
        }
        return jobseeker;
    }
    /**
     * Akan mendaftarkan pelamar sehingga returnnya jobseeker
     * @return jobseeker
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Jobseeker registerJobseeker(@RequestParam(value="name") String name,
                                  @RequestParam(value="email") String email,
                                  @RequestParam(value="password") String password) throws SQLException {
        Jobseeker jobseeker = new Jobseeker(DatabaseJobseekerPostgre.getLastJobseekerId()+1, name, email, password);
        try {
            DatabaseJobseekerPostgre.insertJobseeker(jobseeker);
        } catch (EmailAlreadyExistsException e) {
            e.getMessage();
            return null;
        }
        return jobseeker;
    }

    /**
     * Akan melakukan login sehingga returnnya jobseeker
     * @return jobseeker
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Jobseeker loginJobseeker(@RequestParam(value="email") String email,
                                       @RequestParam(value="password") String password) throws SQLException {
        Jobseeker jobseeker = DatabaseJobseekerPostgre.jobseekerLogin(email, password);
        return jobseeker;
    }
}
