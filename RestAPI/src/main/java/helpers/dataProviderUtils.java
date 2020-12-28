package helpers;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Scanner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderUtils {

    @DataProvider(name = "testdata")
    public Object[][] data(Method m) throws IOException {
        String s = ((Test) m.getAnnotation(Test.class)).description();
        Scanner scan = new Scanner(s);
        String value[] = new String[2];
        int i = 0;
        //Initialize the string delimiter
        scan.useDelimiter(",");
        //Printing the tokenized Strings
        while (scan.hasNext()) {
            value[i] = scan.next();
            //System.out.println(scan.next());
            i++;
        }
        System.out.println(value[0]);
        System.out.println(value[1]);
        excelUtls excel = new excelUtls(value[0], value[1]);
        Object[][] data = excelUtls.testData(excel);
        return data;
    }

}