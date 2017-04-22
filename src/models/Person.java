package models;

import java.util.HashSet;

import static com.google.common.base.MoreObjects.toStringHelper;

/**
 * Created by ciaranroche on 19/03/2017.
 */
public class Person {
    private String person;
    private String sex;
    private int dob;
    private Person mammy;
    private Person daddy;
    //made public as needed specific attributes from set
    public HashSet<Person>children = new HashSet<>();
    public HashSet<Person>siblings = new HashSet<>();

    public Person(){

    }

    public Person(String person){
        this.person = person;
    }

    public Person(String person, String sex, int dob)
    {
        this.person = person;
        this.sex = sex;
        this.dob = dob;
    }

    public Person(String person, String sex, int dob, Person mammy, Person daddy){
        this.person = person;
        this.sex = sex;
        this.dob = dob;
        this.mammy = mammy;
        this.daddy = daddy;
    }

    public String toString(){
        return toStringHelper(getClass())
                .addValue("Name: " + person)
                .addValue("Sex: " + sex)
                .addValue("DOB: " + dob)
                .addValue("Mother: " + mammy)
                .addValue("Father: " + daddy)
                .toString();
    }

    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj==null){
            return false;
        }
        return true;
    }

    public String getPerson(){
        return person;
    }

    public void setPerson(String person){
        this.person = person;
    }

    public String getSex(){
        if(sex=="M"){
            return "Male";
        }else
        return "Female";
    }

    public void setSex(String sex){
        this.sex = sex;
    }

    public int getDob(){
        return dob;
    }

    public void setDob(int dob){
        this.dob = dob;
    }

    public Person getMammy(){
        return mammy;
    }

    public void setMammy(Person mammy){
        this.mammy = mammy;
    }

    public Person getDaddy(){
        return daddy;
    }

    public void setDaddy(Person daddy){
        this.daddy = daddy;
    }

    public HashSet<Person> getChildren() {
        		return children;
    }

    public void setChildren(Person person) {
        children.add(person);
    }

    public HashSet<Person> getSiblings() {
        return siblings;
    }

    public void setSiblings(Person person) {
        siblings.add(person);
    }
}
