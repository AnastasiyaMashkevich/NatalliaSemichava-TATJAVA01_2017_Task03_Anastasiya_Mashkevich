package controller.command.impl;

import bean.NewsItem;
import controller.command.Command;
import service.CatalogService;
import service.ServiceFactory;
import service.exception.ServiceException;

import java.util.ArrayList;

public class SearchNewsItemByYear implements Command {

    public String execute(String date) {

        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CatalogService catalogService = serviceFactory.getCatalogService();
        String data = date.split("/")[0];
        ArrayList<NewsItem> result = null;
        try {
            result = catalogService.searchNewsItemByYear(data);
        } catch (ServiceException e) {
            System.out.println("Search by year error");;
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
