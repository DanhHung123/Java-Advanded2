package Project_Java2;

public class Music {
    private int MusicId;
    private String MusicName;
    private String Author;
    private String Years;
    private String Type;

    public Music(int musicId, String musicName, String author, String years, String type) {
        MusicId = musicId;
        MusicName = musicName;
        Author = author;
        Years = years;
        Type = type;
    }

    public int getMusicId() {
        return MusicId;
    }

    public void setMusicId(int musicId) {
        MusicId = musicId;
    }

    public String getMusicName() {
        return MusicName;
    }

    public void setMusicName(String musicName) {
        MusicName = musicName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getYears() {
        return Years;
    }

    public void setYears(String years) {
        Years = years;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    @Override
    public String toString() {
        return "Music{" +
                "MusicId=" + MusicId +
                ", MusicName='" + MusicName + '\'' +
                ", Author='" + Author + '\'' +
                ", Years='" + Years + '\'' +
                ", Type='" + Type + '\'' +
                '}';
    }
    public void print() {
        System.out.printf("%-30s%-30s%-30s%-30s%-30s",MusicId , MusicName , Author , Years, Type);
        System.out.println();
    }
}
