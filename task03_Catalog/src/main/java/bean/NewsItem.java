package bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement (name = "newsItem")
@XmlType(propOrder = {"category","title", "additionalInfo", "year"})
public class NewsItem {
    private String category;
    private String title;
    private String additionalInfo;
    private String year;

    public NewsItem(String category, String title, String additionalInfo, String year) {
        this.category = category;
        this.title = title;
        this.additionalInfo = additionalInfo;
        this.year = year;
    }
    public NewsItem () {
    }

    public String getCategory() {
        return category;
    }

    @XmlElement(name = "category")
    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    @XmlElement(name = "title")
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    @XmlElement(name = "additionalInfo")
    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getYear() {
        return year;
    }

    @XmlElement(name = "year")
    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "category = " + category + ", title = " + title + ", additionalInfo = " + additionalInfo + ", year = " + year;
    }
}
