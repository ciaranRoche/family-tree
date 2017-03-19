package utils;


import edu.princeton.cs.introcs.In;
import models.Data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ciaranroche on 19/03/2017.
 */
public class DataInput {

    public List<Data> loadData(String filename)throws Exception{
        File dataFile = new File(filename);
        In dataIn = new In(dataFile);

        String delims = " ";
        List<Data> data = new ArrayList<Data>();
        while(!dataIn.isEmpty()){
            String dataDetails = dataIn.readLine();
            String[] dataTokens = dataDetails.split(delims);
            if(dataTokens.length == 5){
                String person = dataTokens[0];
                String sex = dataTokens[1];
                int dob = Integer.parseInt(dataTokens[2]);
                String mammy = dataTokens[3];
                String daddy = dataTokens[4];

                data.add(new Data(person, sex, dob, mammy, daddy));

            }else{
                throw new Exception("Invalid lenght " + dataTokens.length);
            }
        }
        return data;
    }
}
