package MuhammadFadhlanHarits.jwork;
/**
 * @author Muhammad Fadhlan Harits
 * @version 8 April 2021
 */
public class Location
{
    // variabel yang digunakan
    private String province;
    private String city;
    private String description;

    /**
    * <p>Konstruktur kelas location</p>
    * @param province, city, description
     */
    public Location(String province, String city, String description)
    {
        this.province = province;
        this.city = city;
        this.description = description;
    }

     /**
     * <p>Method ini akan mengembalikan nama provinsi sehingga returnnya province</p>
     * @return province
     */
    public String getProvince()
    {
        return province;
    }
     /**
     * <p>Method ini akan mengembalikan nama kota sehingga returnnya kota</p>
     * @return city
     */
    public String getCity()
    {
        return city;
    }
     /**
     * <p>Method ini akan mengembalikan deskripsi sehingga returnnya description</p>
     * @return description
     */
    public String getDescription()
    {
        return description;
    }
     /**
     * <p>Method ini akan memberi nilai pada provinsi sehingga parameternya province</p>
     * @param province
     */
    public void setProvince(String province)
    {
        this.province = province;
    }
     /**
     * <p>Method ini akan memberi nilai pada kota sehingga parameternya city</p>
     * @param city
     */
    public void setCity(String city)
    {
        this.city = city;
    }
     /**
     * <p>Method ini akan memberi nilai pada deskripsi sehingga parameternya description</p>
     * @param description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
    //Method ini akan menampilkan data lokasi
    public String toString()
    {
         return "==== LOCATION ====" + "\nProvince : " + getProvince() + "\nCity: " + getCity() + "\nDescription: " + getDescription() + "\n";
    }
}
