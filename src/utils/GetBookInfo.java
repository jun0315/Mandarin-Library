package utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * gradle dependence
 * compile group: 'org.json', name: 'json', version: '20190722'
 */

/**
 * example:
 * GetBookInfo getBookInfo = new GetBookInfo("9780131002876");
 * System.out.println(getBookInfo.getTitle());
 */

public class GetBookInfo {

    private JSONObject volumeInfo;
    private boolean isNull = false;

    public GetBookInfo(String isbn) {
        proxySetting();
        if (isbn != null) {
            GetByISBN(isbn);
        } else {
            isNull = true;
        }
    }

    private void GetByISBN(String isbn) {
        String Publish, Name, Author, Price;

        String result = HttpUtil.sendGet
                ("https://www.googleapis.com/books/v1/volumes?q=isbn:" + isbn + "&country=HK");

        if (result.isEmpty()) {
            System.err.println("get book information failed");
            return;
        } else {
            proxyCancel();
        }

        JSONObject json = new JSONObject(result);
        if (json.getInt("totalItems")==0) {
            isNull = true;
            return;
        }

        JSONArray bookItem = json.getJSONArray("items");

        volumeInfo = bookItem.getJSONObject(0).getJSONObject("volumeInfo");


    }


    public String getTitle() {
        if (isNull)
            return "";
        try {
            return volumeInfo.getString("title");
        } catch (JSONException e) {
            return "";
        }
    }

    public String getAuthor() {
        if (isNull)
            return "";
        try {
            StringBuilder authorResult = new StringBuilder();
            JSONArray authors = volumeInfo.getJSONArray("authors");

            for (Object author : authors) {
                authorResult.append((String) author).append(" ");
            }
            return authorResult.toString();
        } catch (JSONException e) {
            return "";
        }
    }

    public String getPublisher() {
        if (isNull)
            return "";
        try {
            return volumeInfo.getString("publisher");
        } catch (JSONException ignored) {
            return "";
        }
    }

    public String getPublishedDate() {
        if (isNull)
            return "";
        try {
            return volumeInfo.getString("publishedDate");
        } catch (JSONException e) {
            return "";
        }
    }

    public int getPageCount() {
        if (isNull)
            return 0;
        try {
            return volumeInfo.getInt("pageCount");

        } catch (JSONException e) {
            return 0;
        }
    }

    public String getDescription() {
        if (isNull)
            return "";
        try {
            return volumeInfo.getString("description");
        } catch (JSONException e) {
            return "";
        }
    }


//test
//    public static void main(String[] args) {
//
//        GetBookInfo getBookInfo = new GetBookInfo("9780131002876");
//        System.out.println(getBookInfo.getAuthor());
//        System.out.println(getBookInfo.getPageCount());
//        System.out.println(getBookInfo.getPublishedDate());
//        System.out.println(getBookInfo.getPublisher());
//        System.out.println(getBookInfo.getTitle());
//
//
//    }

    private void proxySetting() {
        String proxyHost = "127.0.0.1";
        String proxyPort = "7890";
        System.setProperty("http.proxyHost", proxyHost);
        System.setProperty("http.proxyPort", proxyPort);
        System.setProperty("https.proxyHost", proxyHost);
        System.setProperty("https.proxyPort", proxyPort);
    }

    private void proxyCancel() {
        System.getProperties().remove("http.proxyHost");
        System.getProperties().remove("http.proxyPort");
        System.getProperties().remove("https.proxyHost");
        System.getProperties().remove("https.proxyPort");
    }

}

