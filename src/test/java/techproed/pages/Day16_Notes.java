package techproed.pages;

public class Day16_Notes {

    /*

            Assume there are 500 test cases in your test suite
        All of the classes uses Driver.getDriver().get(“https://www.techproeducation.com")
        Then requirement change and url is now  Driver.getDriver().get(“https://www.techproedu.com”)
        Then how do you fix the problem?
        Without dynamic URL: We have to fix 500 times going into each test case.
        It takes about a week. Very risky cause you can have difficulty to find the URLs
        With dynamic URL(from properties file): Just change the URL from config reader file.
        It takes about 10 seconds. It is not as risky as hard coded URL

     */
}
