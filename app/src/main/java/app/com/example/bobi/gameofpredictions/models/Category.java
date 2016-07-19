package app.com.example.bobi.gameofpredictions.models;

/**
 * Created by Bobi on 4.7.2016 г..
 */
public class Category {

    private int id;
    private String title;
    private String thumbnail;
    private String info;
    private String url;
    private String author;

    public Category(){};

    public Category(int id, String title, String thumbnail, String info, String url, String author){
        this.id = id;
        this.title = title;
        this.thumbnail = thumbnail;
        this.info = info;
        this.url = url;
        this.author = author;
    }

    public int getId() {return id;}

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {return title;}

    public void setTitle(String title) {
        this.title= title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail= thumbnail;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info= info;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url= url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author= author;
    }

}
