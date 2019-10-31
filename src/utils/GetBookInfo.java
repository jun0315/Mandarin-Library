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

    private MyJSONObject volumeInfo;

    public GetBookInfo(String isbn) {
        proxySetting();
        if (isbn != null) {
            GetByISBN(isbn);
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

        JSONArray bookItem = json.getJSONArray("items");
        volumeInfo = (MyJSONObject) bookItem.getJSONObject(0).getJSONObject("volumeInfo");
    }


    public String getTitle() {
        return volumeInfo.getString("title");
    }

    public String getAuthor() {
        StringBuilder authorResult = new StringBuilder();
        JSONArray authors = volumeInfo.getJSONArray("authors");

        for (Object author : authors) {
            authorResult.append((String) author);
        }
        return authorResult.toString();
    }

    public String getPublisher() {
        return volumeInfo.getString("publisher");
    }

    public String getPublishedDate() {
        return volumeInfo.getString("publishedDate");
    }

    public int getPageCount() {
        return volumeInfo.getInt("pageCount");
    }

    public String getDescription() {
        return volumeInfo.getString("description");
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

class MyJSONObject extends JSONObject {
    @Override
    public String getString(String key) throws JSONException {
        Object object = this.get(key);
        if (object instanceof String) {
            return super.getString(key);
        } else {
            return "";
        }
    }
}