import java.util.ArrayList;
import java.util.List;

public class ObserverPatternExample {

    // Subject Interface: Stock
    public interface Stock {
        void registerObserver(Observer observer);
        void deregisterObserver(Observer observer);
        void notifyObservers();
    }

    // Concrete Subject: StockMarket
    public static class StockMarket implements Stock {
        private List<Observer> observers = new ArrayList<>();
        private String stockName;
        private double stockPrice;

        public StockMarket(String stockName) {
            this.stockName = stockName;
        }

        public void setStockPrice(double stockPrice) {
            this.stockPrice = stockPrice;
            notifyObservers();
        }

        @Override
        public void registerObserver(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void deregisterObserver(Observer observer) {
            observers.remove(observer);
        }

        @Override
        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(stockName, stockPrice);
            }
        }
    }

    // Observer Interface
    public interface Observer {
        void update(String stockName, double stockPrice);
    }

    // Concrete Observer: MobileApp
    public static class MobileApp implements Observer {
        private String appName;

        public MobileApp(String appName) {
            this.appName = appName;
        }

        @Override
        public void update(String stockName, double stockPrice) {
            System.out.println(appName + " MobileApp: Stock " + stockName + " is now $" + stockPrice);
        }
    }

    // Concrete Observer: WebApp
    public static class WebApp implements Observer {
        private String appName;

        public WebApp(String appName) {
            this.appName = appName;
        }

        @Override
        public void update(String stockName, double stockPrice) {
            System.out.println(appName + " WebApp: Stock " + stockName + " is now $" + stockPrice);
        }
    }

    // Test Class to demonstrate the Observer Pattern
    public static class ObserverPatternTest {
        public static void main(String[] args) {
            // Create a stock market
            StockMarket stockMarket = new StockMarket("TechCorp");

            // Create observers
            Observer mobileApp = new MobileApp("MySuper");
            Observer webApp = new WebApp("StockWatch");

            // Register observers
            stockMarket.registerObserver(mobileApp);
            stockMarket.registerObserver(webApp);

            // Change stock price and notify observers
            stockMarket.setStockPrice(150.00);

            // Deregister an observer
            stockMarket.deregisterObserver(mobileApp);

            // Change stock price again and notify remaining observers
            stockMarket.setStockPrice(155.00);
        }
    }
}
