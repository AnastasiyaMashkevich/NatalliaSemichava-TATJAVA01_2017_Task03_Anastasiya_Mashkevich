package dao.impl;
import bean.Catalog;
import bean.NewsItem;
import dao.NewsDao;
import dao.exception.DAOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;


public class NewsDaoImpl implements NewsDao {
    Catalog catalog = getCatalog();
    ArrayList<NewsItem> news = catalog.getNewsItem();

    public void addNewsItem(NewsItem newItem)throws DAOException{
        if (newItem.getCategory().isEmpty()|newItem.getTitle().isEmpty()|newItem.getAdditionalInfo().isEmpty()|newItem.getYear().isEmpty()){
            System.out.println("You can add all info about news.");
        } else {
            news.add(newItem);
            catalog.setNewsItem(news);
            setCatalog(catalog);
        }
    }

    public ArrayList<NewsItem> searchNewsItemsByTitle(String title) throws DAOException {
        Catalog catalog = getCatalog();
        ArrayList<NewsItem> news = catalog.getNewsItem();
        ArrayList<NewsItem> newsResult = new ArrayList<NewsItem>();
        for (NewsItem newsItem : news) {
            if (newsItem.getTitle() != null && newsItem.getTitle().equals(title)) {
                newsResult.add(newsItem);
            }
        }
        if (newsResult.isEmpty()) return null;
        System.out.println("By year '" + title + "' was found: "+ newsResult );

        return newsResult;
    }
    public ArrayList<NewsItem> searchNewsItemByYear(String year)throws DAOException {
        Catalog catalog = getCatalog();
        ArrayList <NewsItem> news = catalog.getNewsItem();
        ArrayList<NewsItem> newsResult = new ArrayList<NewsItem>();
        for (NewsItem newsItem : news) {
            if (newsItem.getYear() != null && newsItem.getYear().equals(year)) {
                newsResult.add(newsItem);
            }
        }
        if (newsResult.isEmpty()) return null;
       System.out.println("By year '" + year + "' was found: "+newsResult );

        return newsResult;
    }

    public Catalog getCatalog() {
        Catalog catalog;
        try {
            File file = new File("Catalog.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            catalog=(Catalog) jaxbUnmarshaller.unmarshal(file);
            return catalog;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setCatalog(Catalog catalog) {
        try {
            File file = new File("Catalog.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(catalog, file);
            jaxbMarshaller.marshal(catalog, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "catalog = " + getCatalog();
    }
    private String printArray(ArrayList<NewsItem> array) {
        StringBuffer sb = new StringBuffer();
        for (NewsItem newsItem : array) {
            sb.append(newsItem.toString());
            sb.append("\n");
        }
        System.out.println(sb);
        return sb.toString();
    }

}
