package dao.impl;


import bean.NewsItem;
import dao.NewsDao;
import dao.exception.DAOException;
import dao.factory.DAOFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class NewsDaoImplTest {
    ArrayList<NewsItem> list;

    @DataProvider(name = "DataProvider")
    public Object[][] createDataForAddNew() {
        return new Object[][]{
                {new NewsItem(),"movie", "new film", "about film", "2017"},
        };
    }

    @Test(dataProvider = "DataProvider")
    public void testAddNewPositive(NewsItem newsItem, String category, String title, String additionalInfo, String year) throws DAOException {
        newsItem.setCategory(category);
        newsItem.setTitle(title);
        newsItem.setAdditionalInfo(additionalInfo);
        newsItem.setYear(year);
        DAOFactory daoObjectFactory = DAOFactory.getInstance();
        NewsDao newsDao = daoObjectFactory.getNewsDAO();
        newsDao.addNewsItem(newsItem);
        Assert.assertEquals(newsItem.getTitle(),"new film");
        Assert.assertEquals(newsItem.getCategory(),"movie");
        Assert.assertEquals(newsItem.getAdditionalInfo(),"about film");
        Assert.assertEquals(newsItem.getYear(),"2017");
    }
    @Test
    public void testSearchByTitle() throws DAOException {
        String title="Meet_Joe_Black";
        DAOFactory daoObjectFactory = DAOFactory.getInstance();
        NewsDao newsDao = daoObjectFactory.getNewsDAO();
        list=newsDao.searchNewsItemsByTitle(title);
        Assert.assertNotNull(list);
    }
    @Test
    public void testSearchByYear() throws DAOException {
        String year="1951";
        DAOFactory daoObjectFactory = DAOFactory.getInstance();
        NewsDao newsDao = daoObjectFactory.getNewsDAO();
        list=newsDao.searchNewsItemByYear(year);
        Assert.assertNotNull(list);
    }

}