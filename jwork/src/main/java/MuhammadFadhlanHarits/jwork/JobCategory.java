package MuhammadFadhlanHarits.jwork;
/**
 * @author Muhammad Fadhlan Harits
 * @version 25 Maret 2021
 */
public enum JobCategory
{
    //Nilai dari tiap enum 
    WebDeveloper("Web Developer"), 
    FrontEnd("Front End"), 
    BackEnd("Back End"), 
    UI("UI"), 
    UX("UX"), 
    DevOps("DevOps"), 
    DataScientist("Data Scientist"), 
    DataAnalyst("Data Analyst");
    
    //variabel untuk constructur
    private final String NAME;
    
    /**
     * Konstruktur untuk enum JobCategory
     * @param NAME
     */
    JobCategory(String NAME)
    {
        this.NAME = NAME;
    }
    
    /**
     * Method untuk mengembalikan enum dalam bentuk string
     * @return NAME
     */
    public String toString()
    {
        return NAME;
    }
}
