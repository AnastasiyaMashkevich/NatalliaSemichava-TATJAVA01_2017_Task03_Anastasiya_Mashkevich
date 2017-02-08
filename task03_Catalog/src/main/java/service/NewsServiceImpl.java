package service;


import bean.NewsItem;
import dao.NewsDao;
import dao.exception.DAOException;
import dao.factory.DAOFactory;
import service.exception.ServiceException;

import java.util.ArrayList;

public class NewsServiceImpl implements CatalogService {

    public NewsItem addNewsItem(String category, String title, String additionalInfo, String year) throws ServiceException {
        // а входные параметры КТО валидироват будет? Это же уже слой сервисов!
        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            NewsDao newsDao = daoObjectFactory.getNewsDAO();
            NewsItem newsItem = new NewsItem(category, title, additionalInfo, year);
            newsDao.addNewsItem(newsItem);
            return newsItem;
        } catch (DAOException e) {
            throw new ServiceException("Error! Was not added new news. ");// и чпециально обращала внимание, чтобы не теряли реальные исключения
            // а их оборачивали
            // все равно, упорно пишут антипаттерн
        }
    }

    public ArrayList<NewsItem> searchNewsItemByTitle(String title) throws ServiceException {
        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            NewsDao newsItemDAO = daoObjectFactory.getNewsDAO();
            ArrayList<NewsItem> result = newsItemDAO.searchNewsItemsByTitle(title);
            return result;
        } catch (DAOException e) {
            throw new ServiceException ("Search by title error");
        }
    }

    public ArrayList<NewsItem> searchNewsItemByYear(String year) throws ServiceException {
        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            NewsDao newsItemDAO = daoObjectFactory.getNewsDAO();
            ArrayList<NewsItem> result = newsItemDAO.searchNewsItemByYear(year);
            return result;
        } catch (DAOException e) {
            throw new ServiceException("Search by date error");
        }
    }
}
