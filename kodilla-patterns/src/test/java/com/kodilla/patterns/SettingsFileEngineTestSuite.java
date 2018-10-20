package com.kodilla.patterns;

import com.kodilla.patterns.singleton.SettingsFileEngine;
import org.junit.*;

public class SettingsFileEngineTestSuite {

    @BeforeClass
    public static void openSettingsFile() {
        SettingsFileEngine.getInstance().open("myapp.settings");
    }

    @AfterClass
    public static void closeSettingsFile() {
        SettingsFileEngine.getInstance().close();
    }

    @Test
    public void should_return_settings_file_name() {
        //Given
        //When
        String fileName = SettingsFileEngine.getInstance().getFileName();
        System.out.println("Opened: " + fileName);
        //Then
        Assert.assertEquals("myapp.settings", fileName);
    }

    @Test
    public void should_return_return_true_after_loading_settings() {
        //Given
        //When
        boolean result =SettingsFileEngine.getInstance().loadSettings();
        //Then
        Assert.assertTrue(result);
    }

    @Test
    public void should_return_true_after_saving_settings() {
        //Given
        //When
        boolean result = SettingsFileEngine.getInstance().saveSettings();
        //Then
        Assert.assertTrue(result);
    }
}