package controllers;

import edu.princeton.cs.introcs.In;
import models.Person;

import java.io.*;
import java.util.*;

/**
 * Created by ciaranroche on 19/03/2017.
 */
public class FamilyTreeAPI {

    public static Map<String, Person> familyTree = new HashMap<>();
    public static Person p;
    public static Scanner scanner = new Scanner(System.in);

    public FamilyTreeAPI(){
        p = new Person();
    }

    public static void main(String[] args) throws Exception {
        prime();
        //listAll();
        //addSiblings();
        //listSibs();
        addKids();
        //listKids();
        //findKids("Parker");
        //findSiblings("Bilal")
        //findMammy("Armani");
        //findMammy("Colby");
        //System.out.println(familyTree.toString());
        addPerson();
        //addKids();
        //System.out.println(familyTree.get("test"));
        //findMammy("test");
        //findDaddy("test");
        //findKids("mammy");

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
                throw new Exception("Invalid length " + dataTokens.length);
            }
        }
        //second traversal to populate parents
        In data = new In(dataFile);
        String delim = " ";
        while(!data.isEmpty()){
            String dataDets = data.readLine();
            dataDets = dataDets.trim();
            String[] tokens = dataDets.split(delim);
            if(tokens.length==5){
                String personName = tokens[0];
                String mammyTemp = tokens[3];
                if(mammyTemp=="?"){
                    mammyTemp=null;
                }
                String daddyTemp = tokens[4];
                if(daddyTemp=="?"){
                    daddyTemp=null;
                }
                if(familyTree.get(mammyTemp)!=null){
                    Person mammy = familyTree.get(mammyTemp);
                    familyTree.get(personName).setMammy(mammy);
                }
                if(familyTree.get(daddyTemp)!=null){
                    Person daddy = familyTree.get(daddyTemp);
                    familyTree.get(personName).setDaddy(daddy);
                }
            }else{
                throw new Exception("Invalid length " + tokens.length);
            }

        }
    }

    /*
    Add children to person
     */
    public static void addKids(){
        Iterator<String> it = familyTree.keySet().iterator();
        while (it.hasNext()){
            String key = it.next();
            Person person = familyTree.get(key);
            Person mammy = person.getMammy();
            Person daddy = person.getDaddy();
            if(mammy!=null){
                mammy.setChildren(person);
            }
            if(daddy!=null){
                daddy.setChildren(person);

            }
        }
    }

    public static void findMammy(String name){
        Person person = familyTree.get(name);
        if(person.getMammy()!=null){
            String p = person.getMammy().getPerson();
            Person mammy = familyTree.get(p);
            System.out.println(mammy.getPerson() + " is the mammy of " + person.getPerson());
        }else{
            System.out.println(person.getPerson() + "'s mammy is not in our records");
        }
    }

    public static void findDaddy(String name){
        Person person = familyTree.get(name);
        if(person.getDaddy()!=null){
            String p = person.getDaddy().getPerson();
            Person daddy = familyTree.get(p);
            System.out.println(daddy.getPerson() + " is the daddy of " + person.getPerson());
        }else{
            System.out.println(person.getPerson() + "'s daddy is not in our records");
        }
    }

    public static void findKids(String name){
        Person person = familyTree.get(name);
        if(!person.children.isEmpty()){
            for(Person p : person.children){
                System.out.println(p.getPerson() + " is a child of " + person.getPerson());
            }
        }else{
            System.out.println(person.getPerson() + " does not have any kids :(");
        }
    }

//    /*
//    Add siblings to person
//     */
//    public static void addSiblings(){
//        Iterator<String> it = familyTree.keySet().iterator();
//        while (it.hasNext()) {
//            String key = it.next();
//            Person value = familyTree.get(key);
//            Person mammy = value.getMammy();
//            Person daddy = value.getDaddy();
//            if(mammy!=null){
//                Iterator<String> mammySibs = familyTree.keySet().iterator();
//                while (mammySibs.hasNext()){
//                    String person = mammySibs.next();
//                    Person persons = familyTree.get(person);
//                    if(!persons.equals(value)){
//                        Person sibling = familyTree.get(person);
//                        Person daMammy = sibling.getMammy();
//                        if(daMammy!=null){
//                            if(daMammy.equals(mammy)){
//                                value.setSiblings(sibling);
//                            }
//                        }
//                    }
//                }
//            }
//            if(daddy!=null){
//                Iterator<String> daddySibs = familyTree.keySet().iterator();
//                while(daddySibs.hasNext()){
//                    String person = daddySibs.next();
//                    Person persons = familyTree.get(person);
//                    if(!persons.equals(value)){
//                        Person sibling = familyTree.get(person);
//                        Person daDaddy = sibling.getDaddy();
//                        if(daDaddy!=null){
//                            if(daDaddy.equals(daddy)){
//                                value.setSiblings(sibling);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }

    public static void findSiblings(String p){
        Person person = familyTree.get(p);

        if(person.getMammy() != null){
            String name = person.getMammy().getPerson();
            Person mammy = familyTree.get(name);
            HashSet<Person> children = mammy.children;
            for(Person per : children){
                if(!per.getPerson().equals(p)){
                    System.out.println(per.getPerson() + " is a sibling of " + p);
                }
            }
        }
        if(person.getDaddy() != null){
            String name = person.getDaddy().getPerson();
            Person daddy = familyTree.get(name);
            HashSet<Person> children = daddy.children;
            for(Person per : children){
                if(!per.getPerson().equals(p)){
                    System.out.println(per.getPerson() + " is a sibling of " + p);
                }
            }
        }
    }


    /*
    Add new person to familytree
     */
    public static void addPerson() throws FileNotFoundException {
        System.out.println("Please enter the details of person to be added:");
        System.out.println("Name:");
        String name = scanner.nextLine();
        System.out.println("Gender(M/F):");
        String sex = scanner.nextLine();
        System.out.print("Year of Birth:");
        int dob = Integer.parseInt(scanner.nextLine());
        System.out.println("Mother:");
        String mammyName = scanner.nextLine();
        System.out.println("Father:");
        String daddyName = scanner.nextLine();

        Person mammy = null;
        Person daddy = null;
        boolean newMammy = false;
        boolean newDaddy = false;

        if(!familyTree.containsKey(mammyName)){
            familyTree.put(mammyName, new Person(mammyName));
            newMammy = true;
        }

        if(!familyTree.containsKey(daddyName)){
            familyTree.put(daddyName, new Person(daddyName));
            newDaddy = true;
        }

        mammy = familyTree.get(mammyName);
        daddy = familyTree.get(daddyName);


        Person person = new Person(name, sex, dob, mammy, daddy);
        familyTree.put(name, person);
        addKids();

        final OutputStream os = new FileOutputStream("././dataSet");
        final PrintStream ps = new PrintStream(os);
        ps.print(name + " " + sex + " " + dob + " " + mammyName + " " + daddyName);
        if(newMammy==true){
            ps.print(mammyName + " ? ? ? ?");
        }
        if(newDaddy==true){
            ps.print(daddyName + " ? ? ? ?");
        }

        ps.close();

        System.out.println("\nNew Person(s) file has been updated!");
    }



    /*
    Update person in familytree
     */
    public static void updatePerson(){
        //todo
    }

    /*
    Cleaner way to read through <code>familyTree</code>
    */
    public static void listAll(){
        Iterator<String> iterator = familyTree.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Person value = familyTree.get(key);

            System.out.println(value);
        }
    }

//    public static void listSibs(){
//        Iterator<String> iterator = familyTree.keySet().iterator();
//        while(iterator.hasNext()){
//            String key = iterator.next();
//            Person value = familyTree.get(key);
//            System.out.println("Siblings of " + value.getPerson() + " are " + value.getSiblings().toString());
//
//        }
//    }
//
//    public static void listKids(){
//        Iterator<String> iterator = familyTree.keySet().iterator();
//
//        while(iterator.hasNext()){
//            String key = iterator.next();
//            Person value = familyTree.get(key);
//
//            System.out.println("Kids of " + value.getPerson() + " are " + value.getChildren().toString());
//        }
//    }
}

