package smsc_utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import smsc_accelerators.SMSC_Base;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class SMSC_Utils extends SMSC_Base {


//    public static String CONFIG = System.getProperty("user.dir")+"\\smsc_Data\\config.properties";
    public static String CONFIG = System.getProperty("C:\\ForPractice\\selenium-cucumber-automation\\src\\test");
    public static Properties properties=null;

    static void NewFile(String File){
        java.io.File f = new File(File);
        properties = new Properties();
        FileInputStream in;
        try {
            in = new FileInputStream(f);
            properties.load(in);

        } catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to get File Name" + File );
            e.printStackTrace();
        }

    }

    public static String getConfigProperty() {
        return getConfigProperty(null);
    }

    public static String getConfigProperty(String strKey) {
        String strValue = null;
        try{
            File f = new File(CONFIG);
            NewFile(CONFIG);
            if(f.exists()){
                strValue=properties.getProperty(strKey);
            }
            else
                System.out.println("File not found!");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return strValue;
    }

    public static String getTestCaseName(String sTestCase)throws Exception{
        String value = sTestCase;
        try{
            int posi = value.indexOf("@");
            value = value.substring(0, posi);
            posi = value.lastIndexOf(".");
            value = value.substring(posi + 1);
            return value;
        }catch (Exception e){
            throw (e);
        }
    }

    public static void takeScreenshot(WebDriver driver, String sTestCaseName, String path) throws Exception{
        try{
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(path + sTestCaseName +".jpg"));
        } catch (Exception e){
            throw new Exception();
        }
    }
    public static void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    public static boolean uploadFile(String fileLocation) {
        try {
            //Setting clipboard with file location
            setClipboardData(fileLocation);

            Thread.sleep(4000);
            //native key strokes for CTRL, V and ENTER keys

            Robot robot = new Robot();
            robot.delay(250);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(100);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            //Thread.sleep(1500);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return true;
    }

    public static void writeDataIntoFile(String sFilepath,String sContent) throws IOException {
        BufferedWriter bw=null;
        FileWriter fw =null;
        try {
            fw = new FileWriter(sFilepath);
            bw = new BufferedWriter(fw);
            bw.write(sContent);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            bw.close();
            fw.close();
        }
    }

    public static String readDataFromFile(String sFilepath) throws IOException{

        BufferedReader br = new BufferedReader(new FileReader(sFilepath));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }
    public static void updateDataInFile(String sFilePath,String sKey,String sValue) throws IOException{
        try {
            if(!sKey.contains("@")) {
                sKey="@"+sKey;
            }
            Path path = Paths.get(sFilePath);
            String fileContent = new String(Files.readAllBytes(path));
            Files.write(path, fileContent.getBytes());
            if(fileContent.contains(sKey)) {
                fileContent = fileContent.replaceAll(sKey, sValue);
            }
            Files.write(path, fileContent.getBytes());
        }
        catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to update Data In File" + sFilePath );
        }
    }

    public static void deleteFile(String sFilepath) throws IOException{
        try {
            File file = new File(sFilepath);
            if(file.delete()){
                System.out.println(file.getName() + " is deleted!");
            }else{
                System.out.println("Delete operation is failed.");
            }
        }
        catch (Exception e) {
            SMSC_ExceptionHandler.HandleException(e, "Failed to delete File" + sFilepath );
        }
    }

}
