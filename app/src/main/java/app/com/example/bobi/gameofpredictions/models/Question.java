package app.com.example.bobi.gameofpredictions.models;

/**
 * Created by Bobi on 14.7.2016 г..
 */
public class Question {

    private int catId;
    private int id;
    private String title;
    private String thumbnail;
    private String info;
    private String author;

    public Question(int catId, int id, String title, String thumbnail, String info, String author){
        this.catId = catId;
        this.id = id;
        this.title = title;
        this.thumbnail = thumbnail;
        this.info = info;
        this.author = author;
    }

    public int getCatId() {return catId;}

    public void setCatId(int catId) {this.catId = catId;}

    public int getId() {
        return id;
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author= author;
    }

}
