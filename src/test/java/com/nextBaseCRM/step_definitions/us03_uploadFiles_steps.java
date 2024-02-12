package com.nextBaseCRM.step_definitions;

import com.nextBaseCRM.pages.MessagePage;
import com.nextBaseCRM.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class us03_uploadFiles_steps {

        MessagePage messagePage = new MessagePage();

        //START SCENARIO 1

        @When("user opens a new message")
        public void user_opens_a_new_message() {
            messagePage.messageBtn.click();
        }

        @When("user clicks to upload files icon")
        public void user_clicks_to_upload_files_icon() {
            messagePage.uploadFileBtn.click();
        }

        @And("user uploads desired file or image")
        public void userUploadsDesiredFileOrImage() {
            String projectPath = System.getProperty("user.dir");
            String pngFilePath = "src/test/resources/filesToUpload/ScreenShot.png";
            String pngFullPath = projectPath + "/" + pngFilePath;
            messagePage.UploadFileAndImageBtn.sendKeys(pngFullPath);
        }

        @And("user uploads .jpg .pdf .docx and .txt files")
        public void userUploadsJpgPdfDocxAndTxtFiles(){
            String projectPath = System.getProperty("user.dir");
            String pdfFilePath = "src/test/resources/filesToUpload/THE_PLATEAU_OF_LATENT_POTENTIAL.pdf";
            String pngFullPath = projectPath + "/" + pdfFilePath;
            String jpgFilePath = "src/test/resources/filesToUpload/VTDMV2.jpg";
            String jpgFullPath = projectPath + "/" + jpgFilePath;
            String docxFilePath = "src/test/resources/filesToUpload/Test.docx";
            String docxFullPath = projectPath + "/" + docxFilePath;
            String txtFilePath = "src/test/resources/filesToUpload/note.java";
            String txtFullPath = projectPath + "/" + txtFilePath;
            messagePage.UploadFileAndImageBtn.sendKeys(pngFullPath);
            BrowserUtils.waitFor(2);
            messagePage.UploadFileAndImageBtn.sendKeys(jpgFullPath);
            BrowserUtils.waitFor(2);
            messagePage.UploadFileAndImageBtn.sendKeys(docxFullPath);
            BrowserUtils.waitFor(2);
            messagePage.UploadFileAndImageBtn.sendKeys(txtFullPath);
            BrowserUtils.waitFor(2);

            messagePage.sendBtn.click();
            BrowserUtils.waitFor(3);


        }


    @Then("user should see file or image successfully uploaded to message as attachment")
    public void user_should_see_file_or_image_successfully_uploaded_to_message_as_attachment() {
        Assert.assertTrue(messagePage.uploadedFiles.isEnabled());
        Assert.assertTrue(messagePage.uploadedImages.isEnabled());
    }


    //START SCENARIO 2

        @When("user clicks to insert file or image into text")
        public void user_clicks_to_insert_file_or_image_into_text() {
            messagePage.insertInTextBtn.click();
        }

        @Then("user should see that file or image is successfully moved into text field")
        public void user_should_see_that_file_or_image_is_successfully_moved_into_text_field() {
            String expected = "In text";
            String actual = messagePage.inTextMessage.getText();
            Assert.assertEquals(expected, actual);
        }

        //START SCENARIO 3

        @When("user clicks remove file or image icon")
        public void user_clicks_remove_file_or_image_icon() {
            messagePage.deleteUploadBtn.click();
        }
    @Then("user should see the remove file option is available")
    public void user_should_see_the_remove_file_option_is_available() {
        Assert.assertTrue(messagePage.deleteUploadBtn.isEnabled());
    }

    }


