package sample;

import java.io.*;
import java.util.Scanner;

public class BackEnd
{
    public static void generateCsvFile(String sFileName)
    {
        try
        {
            //creates CSV FILE
            FileWriter writer = new FileWriter(sFileName);

            //Appends to CSV FILE
            writer.append("Highscores");
            writer.append("\n");

            writer.append("24");
            writer.append("\n");

            writer.append("10");
            writer.append("\n");

            writer.append("1");
            writer.append("\n");

            //can still generate any data u want
            writer.flush();
            writer.close();

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void updateList(int score, String filePath)
    {
        File file = new File(filePath);
        try
        {
            Scanner inputStream = new Scanner(file);
            inputStream.next();
            while(inputStream.hasNext())
            {
                String data = inputStream.next();

                if(score>Integer.parseInt(data))
                {
                    String tempFile = "temp.txt";
                    File oldFile = new File(filePath);
                    File newFile = new File(tempFile);

                    try
                    {
                        FileWriter fw = new FileWriter(tempFile,true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(bw);
                        Scanner x = new Scanner(new File(filePath));
                        x.useDelimiter("[,\n]]");

                        while(x.hasNext())
                        {
                            String score1 = x.next();
                            String score2 = x.next();
                            String score3 = x.next();

                            pw.println(score1 + "," + score2 + "," + score3);
                        }
                        x.close();
                        pw.flush();
                        pw.close();
                        oldFile.delete();
                        File dump = new File(filePath);
                        newFile.renameTo(dump);
                        break;
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error");
                    }
                }

                System.out.println("");
            }
            inputStream.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
