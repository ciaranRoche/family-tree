package models;

import static com.google.common.base.MoreObjects.toStringHelper;

/**
 * Created by ciaranroche on 19/03/2017.
 */
public class Data {
    private String person;
    private char sex;
    private int dob;
    private String mammy;
    private String daddy;

    public Data(String person, char sex, int dob, String mammy, String Daddy){
        this.person = person;
        this.sex = sex;
        this.dob = dob;
        this.mammy = mammy;
        this.daddy = daddy;
    }

    public String toString(){
        return toStringHelper(this).addValue("\nName: " + person)
                .addValue("\nSex: " + sex)
                .addValue("\nDOB: " + dob)
                .addValue("\nMother: " + mammy)
                .addValue("\nFather: " + daddy)
                .toString();
    }

    public String getPerson(){
        return person;
    }

    public void setPerson(String person){
        this.person = person;
    }

    public String getSex(){
        if(sex=='M'){
            return "Male";
        }else
        return "Female";
    }

    public void setSex(char sex){
        this.sex = sex;
    }

    public int getDob(){
        return dob;
    }

    public void setDob(int dob){
        this.dob = dob;
    }

    public String getMammy(){
        return mammy;
    }

    public void setMammy(String mammy){
        this.mammy = mammy;
    }

    public String getDaddy(){
        return daddy;
    }

    public void setDaddy(String daddy){
        this.daddy = daddy;
    }
}
