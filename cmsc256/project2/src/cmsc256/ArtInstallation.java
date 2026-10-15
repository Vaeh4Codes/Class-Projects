package cmsc256;

public class ArtInstallation {
    private String agency;
    private String stationName;
    private String line;
    private String artist;
    private String artTitle;
    private String artDate;
    private String artMaterial;
    private String artImageLink;

    public ArtInstallation() {
        this.agency = "n/a";
        this.stationName = "n/a";
        this.line = "";
        this.artist = "n/a";
        this.artTitle = "n/a";
        this.artDate = "";
        this.artMaterial = "n/a";
        this.artImageLink = "n/a";
    }
    public ArtInstallation(String agency, String stationName, String line, String artist, String artTitle, String artDate, String artMaterial, String artImageLink) {
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

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
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

    public String getArtDate() {
        return artDate;
    }

    public void setArtDate(String artDate) {
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
