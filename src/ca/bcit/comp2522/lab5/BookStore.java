package ca.bcit.comp2522.lab5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * Represents a book store with a name and a collection (List) of novels.
 *
 * @author Arshia Adamian, Abdullah Al Asmy, Rodrick Vyizigiro, Indervir Grewal, Sukhraj Sandhar
 * @version 1.0.0
 */
public class BookStore
{
    /**
     * The decade (starting year) to filter books by (e.g., 2000s).
     *
     */
    private static final int TARGET_DECADE_START_YEAR = 2000;

    /**
     * The specific year to check for book publication.
     */
    private static final int TARGET_SINGLE_YEAR = 1950;

    /**
     * The start year for calculating the percentage of books published.
     */
    private static final int PERCENTAGE_START_YEAR = 1940;

    /**
     * The end year for calculating the percentage of books published.
     */
    private static final int PERCENTAGE_END_YEAR = 1950;

    /**
     * The target length for book titles to filter by.
     */
    private static final int TARGET_TITLE_LENGTH_OF_CHARS = 15;

    /**
     * The substring to search for in book titles (case-insensitive search).
     */
    private static final String SEARCH_SUBSTRING_THE = "the";

    /**
     * The word to search for and count in book titles (case-insensitive search).
     */
    private static final String SEARCH_WORD_HEART = "heart";

    /**
     * The default name to be used for the book store if one is not provided.
     */
    private static final String DEFAULT_STORE_NAME = "The Local Bookstore";

    /**
     * The number of years to add to the starting year to calculate the final year of a decade.
     */
    private static final int DECADE_END_OFFSET = 9;

    /**
     * The value representing the number one, typically used for starting a count or as an increment.
     */
    private static final int ONE = 1;

    /**
     * The minimum possible percentage value.
     */
    private static final double MINIMUM_PERCENTAGE = 0.0;

    /**
     * The constant used to convert a fraction to a percentage (i.e., multiply by 100).
     */
    private static final double PERCENT_MULTIPLIER = 100.0;

    /**
     * The unique name of the book store.
     */
    private final String storeName;

    /**
     * The list of Novel references currently stocked by the store.
     */
    private final List<Novel> novels;

    /**
     * Constructs a BookStore object, initializing its name and populating the novels list
     * with the default collection. It then executes the required novel processing and filtering steps.
     *
     * @param storeName The name of the book store.
     */
    public BookStore(
        final String storeName
                    )
    {
        validateStoreName(storeName);

        this.storeName = storeName;
        this.novels    = createDefaultNovelsList();

        processAndFilterNovelMap(this.novels);
    }


    /**
     * Initializes the novels list with the default collection of classic novels.
     */
    private List<Novel> createDefaultNovelsList()
    {
        final ArrayList<Novel> defaultNovels;

        defaultNovels = new ArrayList<>();


        defaultNovels.add(new Novel("The Adventures of Augie March", "Saul Bellow", 1953));
        defaultNovels.add(new Novel("All the King’s Men", "Robert Penn Warren", 1946));
        defaultNovels.add(new Novel("American Pastoral", "Philip Roth", 1997));
        defaultNovels.add(new Novel("An American Tragedy", "Theodore Dreiser", 1925));
        defaultNovels.add(new Novel("Animal Farm", "George Orwell", 1946));
        defaultNovels.add(new Novel("Appointment in Samarra", "John O'Hara", 1934));
        defaultNovels.add(new Novel("Are You There God? It's Me, Margaret.", "Judy Blume", 1970));
        defaultNovels.add(new Novel("The Assistant", "Bernard Malamud", 1957));
        defaultNovels.add(new Novel("At Swim-Two-Birds", "Flann O'Brien", 1938));
        defaultNovels.add(new Novel("Atonement", "Ian McEwan", 2002));
        defaultNovels.add(new Novel("Beloved", "Toni Morrison", 1987));
        defaultNovels.add(new Novel("The Berlin Stories", "Christopher Isherwood", 1946));
        defaultNovels.add(new Novel("The Big Sleep", "Raymond Chandler", 1939));
        defaultNovels.add(new Novel("The Blind Assassin", "Margaret Atwood", 2000));
        defaultNovels.add(new Novel("Blood Meridian", "Cormac McCarthy", 1986));
        defaultNovels.add(new Novel("Brideshead Revisited", "Evelyn Waugh", 1946));
        defaultNovels.add(new Novel("The Bridge of San Luis Rey", "Thornton Wilder", 1927));
        defaultNovels.add(new Novel("Call It Sleep", "Henry Roth", 1935));
        defaultNovels.add(new Novel("Catch-22", "Joseph Heller", 1961));
        defaultNovels.add(new Novel("The Catcher in the Rye", "J.D. Salinger", 1951));
        defaultNovels.add(new Novel("A Clockwork Orange", "Anthony Burgess", 1963));
        defaultNovels.add(new Novel("The Confessions of Nat Turner", "William Styron", 1967));
        defaultNovels.add(new Novel("The Corrections", "Jonathan Franzen", 2001));
        defaultNovels.add(new Novel("The Crying of Lot 49", "Thomas Pynchon", 1966));
        defaultNovels.add(new Novel("A Dance to the Music of Time", "Anthony Powell", 1951));
        defaultNovels.add(new Novel("The Day of the Locust", "Nathanael West", 1939));
        defaultNovels.add(new Novel("Death Comes for the Archbishop", "Willa Cather", 1927));
        defaultNovels.add(new Novel("A Death in the Family", "James Agee", 1958));
        defaultNovels.add(new Novel("The Death of the Heart", "Elizabeth Bowen", 1958));
        defaultNovels.add(new Novel("Deliverance", "James Dickey", 1970));
        defaultNovels.add(new Novel("Dog Soldiers", "Robert Stone", 1974));
        defaultNovels.add(new Novel("Falconer", "John Cheever", 1977));
        defaultNovels.add(new Novel("The French Lieutenant's Woman", "John Fowles", 1969));
        defaultNovels.add(new Novel("The Golden Notebook", "Doris Lessing", 1962));
        defaultNovels.add(new Novel("Go Tell It on the Mountain", "James Baldwin", 1953));
        defaultNovels.add(new Novel("Gone with the Wind", "Margaret Mitchell", 1936));
        defaultNovels.add(new Novel("The Grapes of Wrath", "John Steinbeck", 1939));
        defaultNovels.add(new Novel("Gravity's Rainbow", "Thomas Pynchon", 1973));
        defaultNovels.add(new Novel("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        defaultNovels.add(new Novel("A Handful of Dust", "Evelyn Waugh", 1934));
        defaultNovels.add(new Novel("The Heart Is a Lonely Hunter", "Carson McCullers", 1940));
        defaultNovels.add(new Novel("The Heart of the Matter", "Graham Greene", 1948));
        defaultNovels.add(new Novel("Herzog", "Saul Bellow", 1964));
        defaultNovels.add(new Novel("Housekeeping", "Marilynne Robinson", 1981));
        defaultNovels.add(new Novel("A House for Mr. Biswas", "V.S. Naipaul", 1962));
        defaultNovels.add(new Novel("I, Claudius", "Robert Graves", 1934));
        defaultNovels.add(new Novel("Infinite Jest", "David Foster Wallace", 1996));
        defaultNovels.add(new Novel("Invisible Man", "Ralph Ellison", 1952));
        defaultNovels.add(new Novel("Light in August", "William Faulkner", 1932));
        defaultNovels.add(new Novel("The Lion, The Witch and the Wardrobe", "C.S. Lewis", 1950));
        defaultNovels.add(new Novel("Lolita", "Vladimir Nabokov", 1955));
        defaultNovels.add(new Novel("Lord of the Flies", "William Golding", 1954));
        defaultNovels.add(new Novel("The Lord of the Rings", "J.R.R. Tolkien", 1954));
        defaultNovels.add(new Novel("Loving", "Henry Green", 1945));
        defaultNovels.add(new Novel("Lucky Jim", "Kingsley Amis", 1954));
        defaultNovels.add(new Novel("The Man Who Loved Children", "Christina Stead", 1940));
        defaultNovels.add(new Novel("Midnight's Children", "Salman Rushdie", 1981));
        defaultNovels.add(new Novel("Money", "Martin Amis", 1984));
        defaultNovels.add(new Novel("The Moviegoer", "Walker Percy", 1961));
        defaultNovels.add(new Novel("Mrs. Dalloway", "Virginia Woolf", 1925));
        defaultNovels.add(new Novel("Naked Lunch", "William Burroughs", 1959));
        defaultNovels.add(new Novel("Native Son", "Richard Wright", 1940));
        defaultNovels.add(new Novel("Neuromancer", "William Gibson", 1984));
        defaultNovels.add(new Novel("Never Let Me Go", "Kazuo Ishiguro", 2005));
        defaultNovels.add(new Novel("1984", "George Orwell", 1948));
        defaultNovels.add(new Novel("On the Road", "Jack Kerouac", 1957));
        defaultNovels.add(new Novel("One Flew Over the Cuckoo's Nest", "Ken Kesey", 1962));
        defaultNovels.add(new Novel("The Painted Bird", "Jerzy Kosinski", 1965));
        defaultNovels.add(new Novel("Pale Fire", "Vladimir Nabokov", 1962));
        defaultNovels.add(new Novel("A Passage to India", "E.M. Forster", 1924));
        defaultNovels.add(new Novel("Play It as It Lays", "Joan Didion", 1970));
        defaultNovels.add(new Novel("Portnoy's Complaint", "Philip Roth", 1969));
        defaultNovels.add(new Novel("Possession", "A.S. Byatt", 1990));
        defaultNovels.add(new Novel("The Power and the Glory", "Graham Greene", 1939));
        defaultNovels.add(new Novel("The Prime of Miss Jean Brodie", "Muriel Spark", 1961));
        defaultNovels.add(new Novel("Rabbit, Run", "John Updike", 1960));
        defaultNovels.add(new Novel("Ragtime", "E.L. Doctorow", 1975));
        defaultNovels.add(new Novel("The Recognitions", "William Gaddis", 1955));
        defaultNovels.add(new Novel("Red Harvest", "Dashiell Hammett", 1929));
        defaultNovels.add(new Novel("Revolutionary Road", "Richard Yates", 1961));
        defaultNovels.add(new Novel("The Sheltering Sky", "Paul Bowles", 1949));
        defaultNovels.add(new Novel("Slaughterhouse-Five", "Kurt Vonnegut", 1969));
        defaultNovels.add(new Novel("Snow Crash", "Neal Stephenson", 1992));
        defaultNovels.add(new Novel("The Sot-Weed Factor", "John Barth", 1960));
        defaultNovels.add(new Novel("The Sound and the Fury", "William Faulkner", 1929));
        defaultNovels.add(new Novel("The Sportswriter", "Richard Ford", 1986));
        defaultNovels.add(new Novel("The Spy Who Came in from the Cold", "John le Carré", 1964));
        defaultNovels.add(new Novel("The Sun Also Rises", "Ernest Hemingway", 1926));
        defaultNovels.add(new Novel("Their Eyes Were Watching God", "Zora Neale Hurston", 1937));
        defaultNovels.add(new Novel("Things Fall Apart", "Chinua Achebe", 1959));
        defaultNovels.add(new Novel("To Kill a Mockingbird", "Harper Lee", 1960));
        defaultNovels.add(new Novel("To the Lighthouse", "Virginia Woolf", 1929));
        defaultNovels.add(new Novel("Tropic of Cancer", "Henry Miller", 1934));
        defaultNovels.add(new Novel("Ubik", "Philip K. Dick", 1969));
        defaultNovels.add(new Novel("Under the Net", "Iris Murdoch", 1954));
        defaultNovels.add(new Novel("Under the Volcano", "Malcolm Lowry", 1947));
        defaultNovels.add(new Novel("Watchmen", "Alan Moore and Dave Gibbons", 1986));
        defaultNovels.add(new Novel("White Noise", "Don DeLillo", 1985));
        defaultNovels.add(new Novel("White Teeth", "Zadie Smith", 2000));
        defaultNovels.add(new Novel("Wide Sargasso Sea", "Jean Rhys", 1966));


        return defaultNovels;
    }


    /**
     * Executes the main operations of the BookStore, demonstrating various
     * filtering, printing, and sorting functionalities.
     *
     * @param args The command line arguments (not used).
     */
    static void main(final String[] args)
    {
        final BookStore bookstore;
        final Novel oldest;
        final List<Novel> fifteenCharTitles;


        bookstore = new BookStore("Classic Novels Collection");
        System.out.println("All Titles in UPPERCASE:");
        bookstore.printAllTitles();


        System.out.println("\nBook Titles Containing " + SEARCH_SUBSTRING_THE + ":");
        bookstore.printBookTitle(SEARCH_SUBSTRING_THE);
        System.out.println("\nAll Titles in Alphabetical Order:");
        bookstore.printTitlesInAlphaOrder();


        System.out.println("\nBooks from the " + TARGET_DECADE_START_YEAR + ":");
        bookstore.printGroupByDecade(TARGET_DECADE_START_YEAR);

        System.out.println("\nLongest Book Title: ");
        System.out.println(bookstore.getLongest());

        System.out.println("\nIs there a book written in " + TARGET_SINGLE_YEAR + "?");
        System.out.println(bookstore.isThereABookWrittenIn(TARGET_SINGLE_YEAR));

        System.out.println("\nHow many books contain " + SEARCH_WORD_HEART + "?");
        System.out.println(bookstore.howManyBooksContain(SEARCH_WORD_HEART));

        System.out.println("\nPercentage of books written between " + PERCENTAGE_START_YEAR + " and " + PERCENTAGE_END_YEAR + ":");
        System.out.println(bookstore.whichPercentWrittenBetween(PERCENTAGE_START_YEAR, PERCENTAGE_END_YEAR) + "%");

        System.out.println("\nOldest book:");
        oldest = bookstore.getOldestBook();
        System.out.println(oldest.getTitle() + " by " +
                               oldest.getAuthor() + ", " +
                               oldest.getYearOfPublication());

        System.out.println("\nBooks with titles " + TARGET_TITLE_LENGTH_OF_CHARS + " characters long:");
        fifteenCharTitles = bookstore.getBooksThisLength(TARGET_TITLE_LENGTH_OF_CHARS);
        fifteenCharTitles.forEach(novel -> System.out.println(novel.getTitle()));
    }


    /**
     * Validates that the provided store name is not null or blank.
     * Throws an IllegalArgumentException if the validation fails.
     *
     * @param storeName The name of the book store to validate.
     * @throws IllegalArgumentException if the storeName is null or consists only of whitespace.
     */
    private static void validateStoreName(final String storeName)
    {
        if (storeName == null || storeName.isBlank())
        {
            throw new IllegalArgumentException("The store name cannot be null or blank.");
        }
    }

    /**
     * Validates that the provided list of novels is not empty.
     * Throws an IllegalArgumentException if the validation fails.
     *
     * @param novels The list of Novel references to validate.
     * @throws IllegalArgumentException if the novels list is null or empty.
     */
    private static void validateNovels(final List<Novel> novels)
    {
        if (novels == null || novels.isEmpty())
        {
            throw new IllegalArgumentException("The list of novels cannot be null or empty.");
        }
    }


    /**
     * Prints all titles in uppercase.
     */
    public void printAllTitles()
    {
        novels.stream()
            .map(novel -> novel.getTitle().toUpperCase())
            .forEach(System.out::println);
    }

    /**
     * Prints all titles that contain the specified text.
     *
     * @param titlePart the text to search for
     */
    public void printBookTitle(final String titlePart)
    {
        novels.stream()
            .map(Novel::getTitle)
            .filter(title -> title.toLowerCase().contains(titlePart.toLowerCase()))
            .forEach(System.out::println);
    }

    /**
     * Prints all titles in alphabetical order (A–Z).
     */
    public void printTitlesInAlphaOrder()
    {
        novels.stream()
            .map(Novel::getTitle)
            .sorted(String::compareToIgnoreCase)
            .forEach(System.out::println);
    }

    /**
     * Filters the novel collection to find and print all books published within
     * the range starting at the specified {@code decadeStart} year and ending at
     * {@code decadeStart} plus the value of {@code DECADE_END_OFFSET}.
     *
     * @param decadeStart the starting year of the range.
     */
    public void printGroupByDecade(final int decadeStart)
    {
        final int start;
        final int end;

        start = decadeStart;
        end   = decadeStart + DECADE_END_OFFSET;

        novels.stream()
            .filter(novel ->
                    {
                        final int novelPublicationYear;
                        novelPublicationYear = novel.getYearOfPublication();

                        return novelPublicationYear >= start && novelPublicationYear <= end;
                    })
            .forEach(novel -> System.out.println(novel.getTitle()));
    }

    /**
     * Finds and returns the longest title in the bookstore.
     *
     * @return the longest title, or a message if none exist
     */
    public String getLongest()
    {
        return novels.stream()
            .map(Novel::getTitle)
            .max(Comparator.comparingInt(String::length))
            .orElse("No novels available.");
    }

    /**
     * Returns true if there is a novel written in the given year.
     *
     * @param year the year to check
     * @return true if a novel exists from that year, otherwise false
     */
    public boolean isThereABookWrittenIn(final int year)
    {
        return novels.stream()
            .anyMatch(novel -> novel.getYearOfPublication() == year);
    }

    /**
     * Counts how many novels contain the given word in their title.
     *
     * @param word the word to search for
     * @return the number of novels containing the word
     */
    public long howManyBooksContain(final String word)
    {
        return novels.stream()
            .filter(novel -> novel.getTitle().toLowerCase().contains(word.toLowerCase()))
            .count();
    }

    /**
     * Calculates what percentage of novels were written between two years (inclusive).
     *
     * @param first the first year
     * @param last  the last year
     * @return the percentage of novels published between these years
     */
    public double whichPercentWrittenBetween(
        final int first,
        final int last
                                            )
    {

        if (novels.isEmpty())
        {
            return MINIMUM_PERCENTAGE;
        }

        final long countInRange;

        countInRange = novels.stream()
            .filter(novel ->
                    {
                        final long novelYear;
                        novelYear = novel.getYearOfPublication();

                        return novelYear >= first && novelYear <= last;
                    }).count();

        return (countInRange * PERCENT_MULTIPLIER) / novels.size();
    }

    /**
     * Returns the oldest novel in the bookstore.
     *
     * @return the oldest novel, or null if empty
     */
    public Novel getOldestBook()
    {
        return novels.stream()
            .min(Comparator.comparingInt(Novel::getYearOfPublication))
            .orElse(null);
    }

    /**
     * Returns a list of all novels whose title is the given length.
     *
     * @param titleLength the desired title length
     * @return a list of novels with titles of that length
     */
    public List<Novel> getBooksThisLength(final int titleLength)
    {
        return novels.stream()
            .filter(novel -> novel.getTitle().length() == titleLength)
            .collect(Collectors.toList());
    }

    /**
     * Returns the store name
     *
     * @return the name of the store
     *
     */
    public String getStoreName()
    {
        return storeName;
    }

    /**
     * Executes all the requirements for Part 2 of the lab:
     * 1. Creates a Map from the List of Novels.
     * 2. Iterates and prints all titles.
     * 3. Removes novels whose title contains "the" using an Iterator.
     * 4. Sorts the remaining titles and prints the full Novel objects.
     *
     * @param novels the list of novels to be processed.
     */
    private void processAndFilterNovelMap(
        final List<Novel> novels
                                         )
    {
        final Map<String, Novel> novelMap;

        novelMap = createNovelMap(novels);

        printAllMapTitles(novelMap);

        removeTitlesContainingSubstring(novelMap, SEARCH_SUBSTRING_THE);

        printSortedRemainingNovels(novelMap);

    }


    /**
     * Converts a list of novels into a Map where the novel title is the key
     * and the novel object is the value.
     *
     * @param novels The list of Novel references to convert.
     * @return a Map<String, Novel> where the key is the title and the value is the novel.
     */
    private Map<String, Novel> createNovelMap(
        final List<Novel> novels
                                             )
    {
        final Map<String, Novel> novelMap;
        novelMap = new HashMap<>();

        for (final Novel novel : novels)
        {
            novelMap.put(novel.getTitle(), novel);
        }

        return novelMap;
    }

    /**
     * Iterates through the key set of the provided map and prints all novel titles.
     * The titles are printed in the order provided by the Map's key set iterator.
     *
     * @param novelMap The map containing the novel titles as keys.
     */
    private void printAllMapTitles(
        final Map<String, Novel> novelMap
                                  )
    {
        final Set<String> keySet;
        final Iterator<String> titleIterator;

        keySet        = novelMap.keySet();
        titleIterator = keySet.iterator();

        System.out.println("\nAll Novel Titles (from Map Key Set Iterator):");

        int count = ONE;
        while (titleIterator.hasNext())
        {
            System.out.println((count++) + ". " + titleIterator.next());
        }
    }

    /**
     * Filters the provided map by removing any novel whose title contains the
     * specified substring (case-insensitive search). This operation modifies the map in place.
     *
     * @param novelMap  The map to be modified and filtered.
     * @param substring The substring to search for and remove.
     */
    private void removeTitlesContainingSubstring(
        final Map<String, Novel> novelMap,
        final String substring
                                                )
    {
        final Iterator<Map.Entry<String, Novel>> entryIterator;

        entryIterator = novelMap.entrySet().iterator();

        while (entryIterator.hasNext())
        {
            final Map.Entry<String, Novel> entry;
            entry = entryIterator.next();

            if (entry.getKey().toLowerCase().contains(substring.toLowerCase()))
            {
                entryIterator.remove();
            }
        }
    }

    /**
     * Retrieves the remaining novel titles from the map, sorts them alphabetically,
     * and prints the full Novel objects in the sorted order.
     *
     * @param novelMap The map containing the remaining novel objects.
     */
    private void printSortedRemainingNovels(
        final Map<String, Novel> novelMap
                                           )
    {
        final Set<String> remainingKeySet;
        final List<String> keyList;

        remainingKeySet = novelMap.keySet();
        keyList         = new ArrayList<>(remainingKeySet);

        Collections.sort(keyList);

        System.out.println("\nRemaining Novels (Titles Sorted Alphabetically):");

        // Rule 21: Using final for the for-each variable
        for (final String title : keyList)
        {
            System.out.println(novelMap.get(title));
        }

        System.out.println("------------------------------------------------------------------");
    }

}
