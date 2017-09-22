package main;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SequentialPinger {

    public static void main(String args[]) throws InterruptedException, ExecutionException, IOException {

        ExecutorService ex = Executors.newCachedThreadPool();

        String[] hostList = {"http://crunchify.com", "http://yahoo.com",
            "http://www.ebay.com", "http://google.com",
            "http://www.e/\", \"http://techcrunch.com/\",xample.co", "https://paypal.com",
            "http://bing.com/", "http://techcrunch.com/",
            "http://mashable.com/", "http://thenextweb.com/",
            "http://wordpress.com/", "http://cphbusiness.dk/",
            "http://example.com/", "http://sjsu.edu/",
            "http://ebay.co.uk/", "http://google.co.uk/",
            "http://www.wikipedia.org/",
            "http://dr.dk", "http://pol.dk", "https://www.google.dk",
            "http://phoronix.com", "http://www.webupd8.org/",
            "https://studypoint-plaul.rhcloud.com/", "http://stackoverflow.com",
            "http://docs.oracle.com", "https://fronter.com",
            "http://imgur.com/", "http://www.imagemagick.org"
        };

        for (int i = 0; i < hostList.length; i++) {

            final String url = hostList[i];
            String status = getStatus(url);

            //System.out.println(url + "\t\tStatus:" + status);

            Callable<String> c3;
            c3 = () -> {
                String result = "Error";
                try {
                    URL siteURL = new URL(url);
                    HttpURLConnection connection = (HttpURLConnection) siteURL
                            .openConnection();
                    connection.setRequestMethod("GET");
                    connection.connect();

                    int code = connection.getResponseCode();
                    if (code == 200) {
                        result = url + " Status: Green";
                    }
                    if (code == 301) {
                        result = url + " Status: Redirect";
                    }
                } catch (Exception e) {
                    result = url + " Status: ->Red<-";
                }
                return result;
            };
            //ex.submit(c3);
            Future<String> f1 = ex.submit(c3);
            System.out.println("f1: " + f1.get());

        }

    }

    public static String getStatus(String url) throws IOException {

        String result = "Error";
        try {
            URL siteURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) siteURL
                    .openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int code = connection.getResponseCode();
            if (code == 200) {
                result = "Green";
            }
            if (code == 301) {
                result = "Redirect";
            }
        } catch (Exception e) {
            result = "->Red<-";
        }
        return result;
    }
}

