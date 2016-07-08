import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by anju on 7/8/16.
 */
public class converter {

     public List<Repo> convert() throws Exception{
            // open file input stream
            BufferedReader reader = new BufferedReader(new FileReader("reports/report1.csv"));

            // read file line by line
            String line = null;
            Scanner scanner = null;
            int index = 0;
            List<Repo> repoList = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                Repo rep = new Repo();
                scanner = new Scanner(line);
                scanner.useDelimiter(",");
                while (scanner.hasNext()) {
                    String data = scanner.next();
                    if (index == 0)
                        rep.setBuildingId(Integer.parseInt(data));
                    else if (index == 1)
                        rep.setModalNo(data);
                    else if (index == 2)
                        rep.setExpectedData(Double.parseDouble(data));
                    else if (index == 3)
                        rep.setActualData(Double.parseDouble(data));

                    index++;
                }
                index = 0;
                repoList.add(rep);
            }

            //close reader
            reader.close();

            System.out.println(repoList);
         return repoList;

        }

    }