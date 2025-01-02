package com.saucedemo.utils;

import org.apache.hc.client5.http.classic.methods.HttpHead;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LinkValidator {
    /**
     * This function counts all links, checks their status, and clicks on active links.
     *
     * @param driver Selenium WebDriver instance
     */
    public static void countAndValidateLinks(WebDriver driver) {
        int totalLinks = 0;
        int activeLinks = 0;
        int brokenLinks = 0;

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // Find all anchor (<a>) elements on the page
            List<WebElement> links = driver.findElements(By.tagName("a"));
            totalLinks = links.size();

            System.out.println("Total links found: " + totalLinks);

            for (WebElement link : links) {
                String url = link.getAttribute("href");

                if (url == null || url.isEmpty()) {
                    System.out.println("Skipping empty or null URL");
                    continue; // Skip links without URLs
                }

                // Check the link's status using an HTTP HEAD request
                HttpHead request = new HttpHead(url);
                HttpResponse response = httpClient.execute(request);
                //int statusCode = response.getStatusLine().getStatusCode();
                int statusCode = response.getCode();


                if (statusCode >= 200 && statusCode < 400) {
                    System.out.println("Active link: " .+ url + " [Status: " + statusCode + "]");
                    activeLinks++;

                    // Click the active link
                    try {
                        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                        wait.until(ExpectedConditions.elementToBeClickable(link));
                        link.click();
                        driver.navigate().back(); // Return to the original page after clicking
                    } catch (Exception e) {
                        System.out.println("Failed to click link: " + url + " - " + e.getMessage());
                    }
                } else {
                    System.out.println("Broken link: " + url + " [Status: " + statusCode + "]");
                    brokenLinks++;
                }
            }
        } catch (Exception e) {
            System.out.println("Error while validating links: " + e.getMessage());
        }

        System.out.println("Summary:");
        System.out.println("Total Links: " + totalLinks);
        System.out.println("Active Links: " + activeLinks);
        System.out.println("Broken Links: " + brokenLinks);
    }




}
