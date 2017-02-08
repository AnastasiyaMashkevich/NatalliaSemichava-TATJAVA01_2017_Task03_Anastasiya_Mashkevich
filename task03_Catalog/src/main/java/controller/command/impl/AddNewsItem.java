package controller.command.impl;

import bean.NewsItem;
import controller.command.Command;
import dao.exception.DAOException;
import service.CatalogService;
import service.ServiceFactory;
import service.exception.ServiceException;

public class AddNewsItem implements Command {

    public String execute(String newItem) {
        String response;
        String[] inputString = newItem.split("/", 4);
        String category = inputString[0];
        String title = inputString[1];
        String additionalinfo = inputString[2];
        String year = inputString[3];
        try {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            CatalogService catalogService = serviceFactory.getCatalogService();
            NewsItem result;
                result = catalogService.addNewsItem(category, title, additionalinfo, year);
            if ((result != null)){
                response = "NewsItem added\n" + result.toString();
                return response;
            }
        } catch (IndexOutOfBoundsException | ServiceException e) {
            // ну хоть бы уже System.err
    
            System.out.println("Format of the data" + newItem + " is not correspond the pattern category/title/additionalInfo/year");
        }
        return "Not Added";
    }
}
