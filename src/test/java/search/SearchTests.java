package search;

import SitePages.SearchPage;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchTests extends BaseTests {
    @Test
    public void TestSuccessfulSearch()
    {
        SearchPage searchPage = homePage.search();
        searchPage.setSearchString("laptop");
        searchPage.clickSearchButton();
        homePage.scroll(1000);
        System.out.println(searchPage.getResult());
        assertTrue(searchPage.getResult() > 0);
    }
    @Test
    public void TestSearchWithNonExistentString()
    {
        String result = "No products were found that matched your criteria.";
        SearchPage searchPage = homePage.search();
        searchPage.setSearchString("rfgxchj");
        searchPage.clickSearchButton();
        assertEquals(result, searchPage.getResult(searchPage.NoResultError), "Incorrect");
    }
    @Test
    public void TestSearchWithLessThanThreeCharacters()
    {
        String result = "Search term minimum length is 3 characters";
        SearchPage searchPage = homePage.search();
        searchPage.setSearchString("b");
        searchPage.clickSearchButton();
        assertEquals(result, searchPage.getResult(searchPage.lessThanThreeLettersError), "Incorrect");

    }
    @Test
    public void TestEmptySearch()
    {
        SearchPage searchPage = homePage.search();
        searchPage.setSearchString("");
        searchPage.clickSearchButton();
        searchPage.alert_clickToAccept();
    }
}
