package service;


import bean.NewsItem;
import dao.exception.DAOException;
import service.exception.ServiceException;

import java.util.ArrayList;

public interface CatalogService {

    NewsItem addNewsItem(String category, String title, String additionalInfo, String year) throws ServiceException;
    ArrayList <NewsItem> searchNewsItemByTitle(String title)throws ServiceException;
    ArrayList<NewsItem> searchNewsItemByYear(String date)throws ServiceException;

}
