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
            System.out.println("Search by title error");// итак, у нас случилось исключение
            // мы его перехватим, погасим.
        }
        // а дольше начнем формировать ответ - так вот - это и был тот случай, когда Return в catch очень даже уместен
        
        // и позволит избежать дальнейшших ошибок при необходимости модифицировать код
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
