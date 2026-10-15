package cmsc256;

import java.io.IOException;
import java.util.List;

public interface MTARtCatalogAnalyzer {
    /**
     * Reads the provided CSV file and populates the internal data structure(s)
     * with MTA art installation data.
     *
     * @param csvFileName The path to the CSV file.
     * @return true if the data was successfully loaded, false otherwise.
     * @throws IOException If an I/O error occurs during file reading.
     */
    boolean loadData(String csvFileName) throws IOException;
    
    /**
     * Adds an ArtInstallation to this catalog
     *
     * @param artInstallation
     */
    void add(final ArtInstallation artInstallation);
    
    /**
     * Returns the total number of art installations loaded from the dataset.
     *
     * @return The count of art installations.
     */
    int getTotalArtInstallations();
    
    /**
     * Retrieves a list of all unique artists present in the catalog.
     * The order of artists in the list is not strictly specified.
     *
     * @return A List of Strings, where each String is a unique artist's name.
     */
    List<String> getAllUniqueArtists();
    
    /**
     * Finds and returns a list of art installations located at a specific station.
     * The search should be case-insensitive for the station name.
     *
     * @param stationName The name of the station to search for.
     * @return A List of ArtInstallation objects (or a suitable representation),
     * or an empty list if no installations are found for the given station.
     */
    List<ArtInstallation> getInstallationsByStation(final String stationName);
    
    
    /**
     *
     * @param artistName    an artist name
     * @return  List        a list of all installations by that artist
     */
    List<ArtInstallation> getInstallationsByArtist(final String artistName);
    
    
    /**
     * Calculates and returns the average year of installation for all art pieces.
     * Consider how to handle entries where the year might be missing or invalid.
     *
     * @return The average installation year as a double.
     */
    double getAverageInstallationYear();
    
    /**
     * Finds the artist(s) with the most art installations.
     * In case of a tie, all artists with the maximum number of unique installations should be *
     * @return A List of Strings representing the names of the artist(s) with the most */
    List<String> getArtistWithMostInstallations();
    
    
    /**
     * Retrieves a List of the installations for the given line (e.g., "A", "L", "7").
     * Considerations: The "Line" column in the dataset might contain multiple lines (e.g., "1, 2, 3").
     * You'll need to decide how to parse and handle this (e.g., if an installation is on "1, 2, 3",
     * should it be returned if "1" is searched? Probably yes).
     * Case sensitivity for the line name.
     * @return A List<ArtInstallation> of installations
     */
    List<ArtInstallation> getInstallationsByLine(final String subwayLine);
    
    
    /**
     * Returns all installations, sorted by their installation year in descending order
     *      Considerations: Requires implementing Comparable or using a Comparator for your ArtInstallation class.
     *      How to handle installations with no year?
     * @return      a list of installations
     */
    List<ArtInstallation> getInstallationsSortedByYear();
    
    
    /**
     * Calculates the average number of art installations per unique station
     * Considerations: Requires identifying unique stations first, then counting installations per station.
     * @return  the average number by station
     */
    double getAverageInstallationsPerStation();
    
    /**
     * Finds installations whose title or artist name contains a given keyword.
     * Considerations: Should the search be case-sensitive? Should it be an exact match or a substring match?
     * Which fields should be searched?
     *
     * @param keyword a single word string
     * @return a list of installations
     */
    List<ArtInstallation> searchByKeyword(final String keyword);
}
