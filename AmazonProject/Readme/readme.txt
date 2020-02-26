1. Started with initializing the Chrome driver and launching driver. We can test the same script on different browsers by using their drivers. For example Firefox(geco driver) can be used to execute script in Firefox browser.
2. Now Launching the application using baseURL.
3. Used getTitle() function to retrieve title of the web page and compared it using assert function to make sure page has been loaded successfully.
4. Used id locator to find "Shop all Category" web element.
5. Clicked on that to view all categories.
6. Selected "Books and Audible" category from the drop down and used linkText locator to find web element of "Books & Audible" category.
7. Selected "Fiction Books" category from the options listed abd used linkText locator to find web element.
8. Entered "John Grisham" in the search box and clicked enter to find all "John Grisham" books. Also used id locator to find the element of search text box.
9. I have Opened "The Racketeer" book in new tab and used link text to find the web element of the object. I used COMMAND Key to open book in new tab as I used Mac Machine. For Windows machine we should be using CONTROL key
10. Open the tab which has opened with book details
11. Click on Add to Cart button
12. Click on Proceed to Buy button
13. Test ends here