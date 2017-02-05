package dao;


import bean.NewsItem;
import dao.exception.DAOException;

import java.util.ArrayList;

public interface NewsDao {
    void addNewsItem(NewsItem newItem) throws DAOException;
    ArrayList <NewsItem> searchNewsItemsByTitle(String title)throws DAOException;
    ArrayList searchNewsItemByYear(String year)throws DAOException;


}
