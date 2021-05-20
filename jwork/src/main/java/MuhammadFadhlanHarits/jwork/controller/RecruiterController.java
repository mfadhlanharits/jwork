/**
 * @author Muhammad Fadhlan Harits
 * @version 20 Mei 2021
 */
package MuhammadFadhlanHarits.jwork.controller;

import MuhammadFadhlanHarits.jwork.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/recruiter")
@RestController

public class RecruiterController
{
    /**
     * Akan mengembalikan database recruiter sehingga returnnya getRecruiterDatabase
     * @return getRecruiterDatabase
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Recruiter> getAllRecruiter()
    {
        return DatabaseRecruiter.getRecruiterDatabase();
    }
    /**
     * akan mengembalikan recruiter berdasarkan id
     * @param id
     * @return null
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Recruiter getRecruiterById(@PathVariable int id) throws RecruiterNotFoundException
    {
        Recruiter r1=null;
        for(int i=0;i<DatabaseRecruiter.getRecruiterDatabase().size();i++)
        {
            if(DatabaseRecruiter.getRecruiterDatabase().get(i).getID() == id)
            {
                r1 = DatabaseRecruiter.getRecruiterDatabase().get(i);
            }
        }
        if(r1==null)
        {
            RecruiterNotFoundException e = new RecruiterNotFoundException(id);
            System.out.println(e.getMessage());
        }
        return r1;
    }
    /**
     * akan menambahkan recruiter sehingga returnnya recruiter
     * @return r1
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Recruiter addRecruiter(@RequestParam(value="name") String name,
                      @RequestParam(value="email") String email,
                      @RequestParam(value="phoneNumber") String phoneNumber,
                      @RequestParam(value = "province") String province,
                                  @RequestParam(value = "city") String city,
                                  @RequestParam(value = "description") String description)
    {
            Recruiter r1 = null;
            Location l1 = new Location(province, city, description);
            r1 = new Recruiter(DatabaseJobseeker.getLastId()+1, name, email, phoneNumber, l1);
            DatabaseRecruiter.addRecruiter(r1);

        return r1;
    }
}
