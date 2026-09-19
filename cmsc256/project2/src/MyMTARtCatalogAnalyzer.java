import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MyMTARtCatalogAnalyzer extends ArtInstallation implements MTARtCatalogAnalyzer {
    private ArrayList<ArtInstallation> artCatalog;

    /**
     * Reads the provided CSV file and populates the internal data structure(s)
     * with MTA art installation data.
     *
     * @param csvFileName The path to the CSV file.
     * @return true if the data was successfully loaded, false otherwise.
     * @throws IOException If an I/O error occurs during file reading.
     */
    @Override
    public boolean loadData(String csvFileName) throws IOException {
        try{
          File dataCSV = new File(csvFileName);
          Scanner input = new Scanner(dataCSV);

          while(input.hasNextLine()){
              String recordLine = input.nextLine();
              String[] record = recordLine.split(",");
              String agency = record[0];
              String stationName = record[1];
              int line = intConversion(record[2]);
              String artist = record[3];
              String artTitle = record[4];
              int artDate = intConversion(record[5]);
              String artMaterial = record[6];
              String artImageLink = record[7];

              ArtInstallation artwork = new ArtInstallation(agency, stationName, line, artist, artTitle,artDate,artMaterial,artImageLink);
              artCatalog.add(artwork);
          }

          return true;
        }catch (FileNotFoundException e){
            System.out.println("File Not Found.");

            return false;
        }
    }

    /**
     * Tries to parse a string parameter value as an integer.
     *
     * @param numberText
     * @return num if numberText can safely be parsed as an integer
     */
    public int intConversion(String numberText){
        try{
            int num = Integer.parseInt(numberText);
            return num;
        } catch (NumberFormatException e){
            return -1;
        }
    }

    /**
     * Adds an ArtInstallation to this catalog
     *
     * @param artInstallation
     */
    @Override
    public void add(ArtInstallation artInstallation) {
        artCatalog.add(artInstallation);
    }

    /**
     * Returns the total number of art installations loaded from the dataset.
     *
     * @return The count of art installations.
     */
    @Override
    public int getTotalArtInstallations() {
        return artCatalog.size();
    }

    /**
     * Retrieves a list of all unique artists present in the catalog.
     * The order of artists in the list is not strictly specified.
     *
     * @return A List of Strings, where each String is a unique artist's name.
     */
    @Override
    public List<String> getAllUniqueArtists() {
        ArrayList<String> uniqueArtists = new ArrayList<String>();

        for(ArtInstallation artwork: artCatalog){
            String artist = artwork.getArtist();

            if(!uniqueArtists.contains(artist)){
                uniqueArtists.add(artist);
            }
        }
        return uniqueArtists;
    }

    /**
     * Finds and returns a list of art installations located at a specific station.
     * The search should be case-insensitive for the station name.
     *
     * @param stationName The name of the station to search for.
     * @return A List of ArtInstallation objects (or a suitable representation),
     * or an empty list if no installations are found for the given station.
     */
    @Override
    public List<ArtInstallation> getInstallationsByStation(String stationName) {
        ArrayList<ArtInstallation> stationSpecific = new ArrayList<>();

        for(ArtInstallation installation: artCatalog){
            if(installation.getStationName().equals(stationName)){
                stationSpecific.add(installation);
            }
        }

        return stationSpecific;
    }

    /**
     *
     * @param artistName    an artist name
     * @return  List        a list of all installations by that artist
     */
    @Override
    public List<ArtInstallation> getInstallationsByArtist(String artistName) {
        ArrayList<ArtInstallation> artBySelectArtist = new ArrayList<>();

        for(ArtInstallation installation: artCatalog){
            if(installation.getStationName().equals(artistName)){
                artBySelectArtist.add(installation);
            }
        }

        return artBySelectArtist;
    }

    /**
     * Calculates and returns the average year of installation for all art pieces.
     * Consider how to handle entries where the year might be missing or invalid.
     *
     * @return The average installation year as a double.
     */
    @Override
    public double getAverageInstallationYear() {
        double sumYears = 0, average = 0;

        for(ArtInstallation installation: artCatalog){
            //TODO: handle missing years
            double year = getAverageInstallationYear();

            sumYears+=year;
        }

        average = sumYears / artCatalog.size();
        return average;
    }

    /**
     * Finds the artist(s) with the most art installations.
     * In case of a tie, all artists with the maximum number of unique installations should be *
     *
     * @return A List of Strings representing the names of the artist(s) with the most
     */
    @Override
    public List<String> getArtistWithMostInstallations() {
        ArrayList<String> artistsWithMost = new ArrayList<>();
        ArrayList<String> artists = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();
        int artistIndex = 0;


        for(ArtInstallation installation: artCatalog){
            String artist = installation.getArtist();

            if(!artists.contains(artist)){
                artists.add(artist);
                counts.add(1);
            } else{
                artistIndex = artists.indexOf(artist);
                counts.set(artistIndex, counts.get(artistIndex)+ 1);
            }
        }

        int max = 0;

        for(int count: counts){
            if(count >= max){
                max++;
            }
        }

        for(int count : counts) {
            if (count > max) {
                max = count;
            }
        }

        for(int i=0; i < counts.size(); i++){
            if(counts.get(i) == max) {
                artistsWithMost.add(artists.get(i));
            }
        }

        return artistsWithMost;
    }

    /**
     * Retrieves a List of the installations for the given line (e.g., "A", "L", "7").
     * Considerations: The "Line" column in the dataset might contain multiple lines (e.g., "1, 2, 3").
     * You'll need to decide how to parse and handle this (e.g., if an installation is on "1, 2, 3",
     * should it be returned if "1" is searched? Probably yes).
     * Case sensitivity for the line name.
     * @return A List<ArtInstallation> of installations
     */
    @Override
    public List<ArtInstallation> getInstallationsByLine(String subwayLine) {
        ArrayList<ArtInstallation> matchingInstallations = new ArrayList<>();

        for (ArtInstallation installation : artCatalog) {

            String line = String.valueOf(installation.getLine());
            String[] lines = line.split(",");

            for (String currentLine : lines) {

                if (currentLine.trim().equalsIgnoreCase(subwayLine.trim())) {
                    matchingInstallations.add(installation);
                    break;
                }
            }
        }

        return matchingInstallations;
    }

    /**
     * Returns all installations, sorted by their installation year in descending order
     *      Considerations: Requires implementing Comparable or using a Comparator for your ArtInstallation class.
     *      How to handle installations with no year?
     * @return      a list of installations
     */
    @Override
    public List<ArtInstallation> getInstallationsSortedByYear() {
        ArrayList<ArtInstallation> sortedInstallations = new ArrayList<>();
        //TODO: handle installations with no year
        Comparator<ArtInstallation> yearComparator = new Comparator<ArtInstallation>() {
            @Override
            public int compare(ArtInstallation artwork1, ArtInstallation artwork2) {
                int year1 = intConversion(String.valueOf(artwork1.getArtDate()));
                int year2 = intConversion(String.valueOf(artwork2.getArtDate()));

                return Integer.compare(year2, year1);
            }
        };

        sortedInstallations.sort(yearComparator);
        return sortedInstallations;
    }

    /**
     * Calculates the average number of art installations per unique station
     * Considerations: Requires identifying unique stations first, then counting installations per station.
     * @return  the average number by station
     */
    @Override
    public double getAverageInstallationsPerStation() {
        ArrayList<String> uniqueStations  = new ArrayList<>();

        for(ArtInstallation installation : artCatalog){
            String station = installation.getStationName();

            if(!uniqueStations.contains(station)){
                uniqueStations.add(station);
            }
        }

        if(uniqueStations.isEmpty()){
            return 0.0;
        }

        return (double) artCatalog.size()/ uniqueStations.size();
    }

    /**
     * Finds installations whose title or artist name contains a given keyword.
     * Considerations: Should the search be case-sensitive? Should it be an exact match or a substring match?
     * Which fields should be searched?
     *
     * @param keyword a single word string
     * @return a list of installations
     */
    @Override
    public List<ArtInstallation> searchByKeyword(String keyword) {
        ArrayList<ArtInstallation> matches = new ArrayList<>();
        String searchWord = keyword.toLowerCase();

        for(ArtInstallation installation : artCatalog) {
            String artist = installation.getArtist().toLowerCase();
            String title = installation.getArtTitle().toLowerCase();

            if(artist.contains(searchWord) || title.contains(searchWord)) {
                matches.add(installation);
            }
        }

        return matches;
    }
}
