package testCases;

import java.io.File;
import org.testng.Assert;
import org.testng.annotations.Test;
import testPages.FileDownloadPage;
import utilities.Utils;

public class Ten_FileDownload extends BaseTest{
	@Test
	public void fileDownload_10(){
		
		FileDownloadPage fl = new FileDownloadPage(driver);
		driver.get(Utils.BASE_URLS + "/download");
		sleepTest(1000);
		//https://github.com/uma5958/TestNG_SwtestAcademy/tree/master/src/test/java/com
		//https://github.com/swtestacademy/SeleniumDownloadFile/blob/master/src/main/java/Demo.java
		
		//Test clicks on the file.
		//Test asserts that the file is downloaded.
		
		fl.getTextDownload().click();
		sleepTest(2000);
		File folder = new File(System.getProperty("user.dir"));
        //List the files on that folder
        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File f = null;
        //Look for the file in the files
        // You should write smart REGEX according to the filename
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                if (fileName.matches("test.txt" )) {
                    f = new File(fileName);
                    found = true;
                }
            }
        }
        //Verifying the files
        Assert.assertTrue(found, "Downloaded document is not found");
        // Deleting the file 
        f.deleteOnExit();
	}
}
