package bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement (name = "catalog")
public class Catalog {
    private ArrayList<NewsItem> newsItem;

    public ArrayList<NewsItem> getNewsItem() {
        return newsItem;
    }

    @XmlElement
    public void setNewsItem(ArrayList<NewsItem> newsItem) {
        this.newsItem = newsItem;
    }

    @Override
    public String toString() {
        return "newsItem = " + printArray(newsItem);
    }

    private String printArray(List<NewsItem> array) {
        StringBuffer sb = new StringBuffer();
        for (NewsItem newsItem : array) {
            sb.append(newsItem.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

}
