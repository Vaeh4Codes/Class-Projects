public class ArtInstallation {
    private String agency;
    private String stationName;
    private int line;
    private String artist;
    private String artTitle;
    private int artDate;
    private String artMaterial;
    private String artImageLink;

    public ArtInstallation() {
        this.agency = "n/a";
        this.stationName = "n/a";
        this.line = 0;
        this.artist = "n/a";
        this.artTitle = "n/a";
        this.artDate = 0;
        this.artMaterial = "n/a";
        this.artImageLink = "n/a";
    }
    public ArtInstallation(String agency, String stationName, int line, String artist, String artTitle, int artDate, String artMaterial, String artImageLink) {
        this.agency = agency;
        this.stationName = stationName;
        this.line = line;
        this.artist = artist;
        this.artTitle = artTitle;
        this.artDate = artDate;
        this.artMaterial = artMaterial;
        this.artImageLink = artImageLink;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getArtTitle() {
        return artTitle;
    }

    public void setArtTitle(String artTitle) {
        this.artTitle = artTitle;
    }

    public int getArtDate() {
        return artDate;
    }

    public void setArtDate(int artDate) {
        this.artDate = artDate;
    }

    public String getArtMaterial() {
        return artMaterial;
    }

    public void setArtMaterial(String artMaterial) {
        this.artMaterial = artMaterial;
    }

    public String getArtImageLink() {
        return artImageLink;
    }

    public void setArtImageLink(String artImageLink) {
        this.artImageLink = artImageLink;
    }
}
