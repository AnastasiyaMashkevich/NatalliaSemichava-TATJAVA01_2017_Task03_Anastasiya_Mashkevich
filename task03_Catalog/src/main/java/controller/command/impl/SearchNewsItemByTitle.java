package controller.command.impl;

import bean.NewsItem;
import controller.command.Command;
import service.CatalogService;
import service.ServiceFactory;
import service.exception.ServiceException;

import java.util.ArrayList;

public class SearchNewsItemByTitle implements Command {

    public String execute(String title) {
        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CatalogService catalogService = serviceFactory.getCatalogService();
        ArrayList<NewsItem> result = null;
        try {
            result = catalogService.searchNewsItemByTitle(title);
        } catch (ServiceException e) {
            System.out.println("Search by title error");
        }
        if (result != null && result.size() > 0) {
            response = "Result: \n";
            for (NewsItem item : result) {
                response += item.toString() + "\n";
            }
            return response.trim();
        }
        return "Not Found";
    }
}
