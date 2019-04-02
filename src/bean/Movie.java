package bean;

public class Movie {
    //电影的ID
    private int id;
    //电影名称
    private String title;
    //电影剧照
    private String image;
    //导演
    private String director;
    //演员
    private String actor;
    //编剧
    private String author;
    //上映日期
    private String datePublished;
    //类型
    private String genre;
    //电影时长
    private String duration;
    //电影描述
    private String description;
    //电影类型
    private String type;
    //国家
    private String country;
    //语言
    private String language;

    @Override
    public String toString() {
        return "id="+id+"" +
                "\ntitle="+title+"" +
                "\nimage="+image+"" +
                "\ndirector="+director+"" +
                "\nactor="+actor+"" +
                "\nauthor="+author+"" +
                "\ndatePublished="+datePublished+"" +
                "\ngenre="+genre+"" +
                "\nduration="+duration+"" +
                "\ndescription="+description+"" +
                "\ntype="+type+"" +
                "\ncountry="+country+"" +
                "\nlanguage="+language;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
