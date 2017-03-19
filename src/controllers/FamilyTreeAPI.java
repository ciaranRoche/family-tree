package controllers;

import models.Data;
import utils.DataInput;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ciaranroche on 19/03/2017.
 */
public class FamilyTreeAPI {

    public static ArrayList<Data> tempData = new ArrayList<>();

    public FamilyTreeAPI(){}

    public static void main(String[] args) throws Exception {
        prime();
        System.out.println(tempData.toString());
    }

    public static void prime()throws Exception{
        DataInput loader = new DataInput();
        List<Data> data = loader.loadData("././data/dataSet");
        for(Data d : data){
            tempData.add(d);
        }
    }
}
