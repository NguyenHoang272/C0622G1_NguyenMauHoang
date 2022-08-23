package read_file;


import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        List<Country> countries = readFile();

        writeFile(countries);
    }

    public static void writeFile(List<Country> countries) throws IOException {
        File file = new File("src\\read_file\\country.csv");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (Country coutry : countries) {
            bufferedWriter.write(coutry.toString());
            bufferedWriter.newLine();

        }
        bufferedWriter.close();
    }

    private static List<Country> readFile() throws IOException {
        File file = new File("src\\read_file\\country.csv");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<Country> countries = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if ("".equals(line)) {
                continue;
            }
            String[] info = line.split(",");
            Country country = new Country();
            country.setId(Integer.parseInt(info[0]));
            country.setCode(info[1]);
            country.setName(info[2]);
            countries.add(country);

            System.out.println(line);
        }

        bufferedReader.close();

        return countries;

    }

}





