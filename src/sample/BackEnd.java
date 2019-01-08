package sample;

import java.io.*;
import java.util.Scanner;

public class BackEnd
{
    static String high1;
    static String high2;
    static String high3;

    public static void generateCsvFile(String sFileName, String s1, String s2, String s3)
    {
        high1 = s1;
        high2 = s2;
        high3 = s3;
        try
        {
            //creates CSV FILE
            FileWriter writer = new FileWriter(sFileName);

            //Appends to CSV FILE
            writer.append("Highscores");
            writer.append("\n");

            writer.append(s1);
            writer.append("\n");

            writer.append(s2);
            writer.append("\n");

            writer.append(s3);
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

    /*public static void updateList(int score, String filePath)
    {
        boolean changed = false;
        File file = new File(filePath);
        try
        {
            Scanner inputStream = new Scanner(file);
            inputStream.next();
            while(inputStream.hasNext())
            {
                String data = inputStream.next();

                if(score>Integer.parseInt(data) && !changed)
                {
                    String tempFile = "temp.csv";
                    File oldFile = new File(filePath);
                    File newFile = new File(tempFile);

                    try
                    {
                        FileWriter fw = new FileWriter(tempFile,true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(bw);
                        Scanner x = new Scanner(new File(filePath));
                        x.useDelimiter("[,\n]");

                        String checkScore = x.next();
                        System.out.println(checkScore);
                        pw.println(checkScore);
                        while(x.hasNext())
                        {
                            checkScore = x.next();
                            System.out.println(checkScore);

                            if(score>Integer.parseInt(checkScore) && !changed)
                            {
                                checkScore = score + "";
                                changed = true;
                            }

                            System.out.println(checkScore);
                            pw.println(checkScore);
                        }
                        x.close();
                        pw.flush();
                        pw.close();
                        file.delete();
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
            }
            inputStream.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }*/
}
