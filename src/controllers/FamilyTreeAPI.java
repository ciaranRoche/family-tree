package controllers;

import edu.princeton.cs.introcs.In;
import models.Person;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ciaranroche on 19/03/2017.
 */
public class FamilyTreeAPI {

    public static Map<String, Person> familyTree = new HashMap<>();

    public FamilyTreeAPI(){}

    public static void main(String[] args) throws Exception {
        prime();
        System.out.println(familyTree.toString());
    }


    public static void prime()throws Exception{

        //first traversal to populate map with type person
        File dataFile = new File("././data/dataSet");
        In dataIn = new In(dataFile);

        String delims = " ";

        while(!dataIn.isEmpty()){
            String dataDetails = dataIn.readLine();
            dataDetails=dataDetails.trim();
            String[] dataTokens = dataDetails.split(delims);
            if(dataTokens.length == 5){
                String name = dataTokens[0];
                String sex = dataTokens[1];
                int dob = Integer.parseInt(dataTokens[2]);

                Person person = new Person(name, sex, dob);
                familyTree.put(name, person);
            }else{
                throw new Exception("Invalid lenght " + dataTokens.length);
            }
        }
        //second traversal to populate parents
        //todo
    }

    /*
    Add children to person
     */
    public static void addKids(){
        //todo
    }

    /*
    Add siblings to person
     */
    public static void addSiblings(){
        //todo
    }
}

