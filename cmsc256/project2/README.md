**Name:** Nevaeh Dickerson  
**Course:**  Data Structures and Object-Oriented Programming  (CMSC 256)
**Section:** 002

## Data Structures

The primary data structure used in this project is an `ArrayList<ArtInstallation>`. I chose an ArrayList because the number of records in the MTA dataset may change, so a dynamically sized structure is more appropriate than a fixed-size array.

I also used additional ArrayLists to store unique values, count occurrences, and collect results for methods that filter or analyze the art catalog.

## Design Decisions

Each row of the CSV file is stored as an `ArtInstallation` object to keep the information for each installation organized and encapsulated.


## Compile and Run

### macOS (Terminal)

1. Open Terminal.
2. Navigate to the project's root directory:

   ```bash
   cd path/to/Project2