package service;


public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();
    private final CatalogService catalogService = new NewsServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public CatalogService getCatalogService() {
        return catalogService;
    }
}
