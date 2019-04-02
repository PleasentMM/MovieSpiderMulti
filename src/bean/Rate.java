package bean;

public class Rate {
    //评分ID
    private int id;
    //电影ID
    private int movieId;
    //豆瓣电影评分
    private float ratingValue;
    //评价人数
    private int ratingCount;
    //五星率
    private float fivePercent;
    //四星率
    private float fourPercent;
    //三星率
    private float threePercent;
    //二星率
    private float twoPercent;
    //一星率
    private float onePercent;

    private long DataTime;

    @Override
    public String toString() {
        return "id="+id+"" +
                "\nmovieId="+movieId+"" +
                "\nratingValue="+ratingValue+"" +
                "\nratingCount="+ratingCount+"" +
                "\nfivePercent="+fivePercent+"" +
                "\nfourPercent="+fourPercent+"" +
                "\nthreePercent="+threePercent+"" +
                "\ntwoPercent="+twoPercent+"" +
                "\nonePercent="+onePercent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public float getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(float ratingValue) {
        this.ratingValue = ratingValue;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }

    public float getFivePercent() {
        return fivePercent;
    }

    public void setFivePercent(float fivePercent) {
        this.fivePercent = fivePercent;
    }

    public float getFourPercent() {
        return fourPercent;
    }

    public void setFourPercent(float fourPercent) {
        this.fourPercent = fourPercent;
    }

    public float getThreePercent() {
        return threePercent;
    }

    public void setThreePercent(float threePercent) {
        this.threePercent = threePercent;
    }

    public float getTwoPercent() {
        return twoPercent;
    }

    public void setTwoPercent(float twoPercent) {
        this.twoPercent = twoPercent;
    }

    public float getOnePercent() {
        return onePercent;
    }

    public void setOnePercent(float onePercent) {
        this.onePercent = onePercent;
    }

    public long getDataTime() {
        return DataTime;
    }

    public void setDataTime(long dataTime) {
        DataTime = dataTime;
    }
}
