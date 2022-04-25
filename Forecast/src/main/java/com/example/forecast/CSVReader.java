package com.example.forecast;

import com.example.forecast.models.Product;
import org.springframework.stereotype.Component;

import java.io. * ;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component("CSVReader")
public class CSVReader {
    public List<String> readCSV() throws Exception {
        List<String> data = new ArrayList<String>();
        Scanner sc = new Scanner(new File("src/main/java/com/example/forecast/data.csv"));
        //parsing a CSV file into the constructor of Scanner class
        sc.useDelimiter(",");
        //setting comma as delimiter pattern
        while (sc.hasNext()) {
            data.add(sc.next());
        }
        sc.close();
        //closes the scanner

        return data;
    }

    public List<String> readCSVLineRaw() throws Exception {
        try {
            File file = new File("src/main/java/com/example/forecast/data.csv");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;
            List<String> data = new ArrayList<String>();
            while((line = br.readLine()) != null) {
                data.add(line);
                /*tempArr = line.split(",");
                for(String tempStr : tempArr) {
                    System.out.print(tempStr + " ");
                }*/
            }
            br.close();
            return data;
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return  null;
    }

    public List<Product> readCSVLineObj() throws Exception {
        try {
            File file = new File("src/main/java/com/example/forecast/data.csv");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;
            List<Product> data = new ArrayList<Product>();
            Product p;
            br.readLine();
            while((line = br.readLine()) != null) {
                tempArr = line.split(",");
                p = new Product(
                        tempArr[0],
                        tempArr[1],
                        tempArr[2],
                        tempArr[3],
                        tempArr[4],
                        tempArr[5],
                        tempArr[6],
                        tempArr[7]
                );
                data.add(p);
            }
            br.close();
            return data;
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return  null;
    }
}

