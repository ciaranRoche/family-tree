package controllers;

import asg.cliche.Command;
import asg.cliche.ShellFactory;
import asg.cliche.Shell;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by ciaranroche on 22/04/2017.
 */
public class FamilyTreeClient {
    public static Scanner scanner;
    public FamilyTreeAPI api;

    public FamilyTreeClient(){}

    public static void main(String[] args) throws IOException {
        FamilyTreeClient client = new FamilyTreeClient();
        scanner = new Scanner(System.in);
        System.out.println(" _______                  __ __             _______                   ");
        System.out.println("|    ___|.---.-.--------.|__|  |.--.--.    |_     _|.----.-----.-----.");
        System.out.println("|    ___||  _  |        ||  |  ||  |  |      |   |  |   _|  -__|  -__|");
        System.out.println("|___|    |___._|__|__|__||__|__||___  |      |___|  |__| |_____|_____|");
        System.out.println("                                |_____|                               ");
        Shell shell = ShellFactory.createConsoleShell("Family",
                "      <<<<------------------------------------------------->>>>\n             " +
                        "        Welcome to the Family Tree\n      <<<<------------------------------------------------->>>>" +
                            "\n- ?help for instructions\n- ?list for commands",client);
        shell.commandLoop();
    }

    @Command(description = "Prime from File")
    public void prime() throws Exception {
        api.prime();
        api.addKids();
        System.out.println("Critical Data loaded!");
    }

    @Command(description = "Load list of Data")
    public void loadAll(){
        api.listAll();
        System.out.println("\n Loading Data was a Success");
    }

    @Command(description = "Add a Person")
    public void addPerson() throws IOException {
        api.addPerson();
    }

    @Command(description = "Find a Persons Kids")
    public void findKid(){
        System.out.println("Please enter a persons name to which you want to find their youngens?");
        String name = scanner.nextLine();
        api.findKids(name);
    }

    @Command(description = "Find a Persons Mammy")
    public void findMammy(){
        System.out.println("Please enter a persons name to which you want to find their Mammy?");
        String name = scanner.nextLine();
        api.findMammy(name);
    }

    @Command(description = "Find a Persons Daddy")
    public void findDaddy(){
        System.out.println("Please enter a persons name to which you want to find their Daddy?");
        String name = scanner.nextLine();
        api.findDaddy(name);
    }

    @Command(description = "Find a Persons Siblings")
    public void findSiblings(){
        System.out.println("Please enter a persons name to which you want to find their siblings?");
        String name = scanner.nextLine();
        api.findSiblings(name);
    }

    @Command(description = "Exit Program")
    public void quit(){
        System.out.println("If you leave me now . . . . ");
        System.exit(0);
    }
}
