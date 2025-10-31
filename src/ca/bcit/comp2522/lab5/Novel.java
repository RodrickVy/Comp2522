package ca.bcit.comp2522.lab5;

/**
 * Represents a novel with a title, author name, and year of publication.
 *
 * @author Arshia Adamian, Abdullah Al Asmy, Rodrick Vyizigiro, Indervir Grewal, Sukhraj Sandhar
 * @version 1.0.0
 */
public class Novel
{
    /**
     * The minimum valid publication year.
     */
    private static final int MIN_YEAR_OF_PUBLICATION = 1;
    /**
     * The maximum valid publication year.
     */
    private static final int MAX_YEAR_OF_PUBLICATION = 9999;

    private final String title;
    private final String author;
    private final int yearOfPublication;

    /**
     * Constructs a {@code Novel} with the specified title, author, and year.
     *
     * @param title             the title of the novel
     * @param author            the author's full name
     * @param yearOfPublication the year the novel was published
     */
    public Novel(
        final String title,
        final String author,
        final int yearOfPublication)
    {
        validateYearOfPublication(yearOfPublication);
        validateAuthor(author);
        validateTitle(title);

        this.title             = title;
        this.author            = author;
        this.yearOfPublication = yearOfPublication;
    }

    /**
     * Returns the title of this novel.
     *
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Returns the author of this novel.
     *
     * @return the author's name
     */
    public String getAuthor()
    {
        return author;
    }

    /**
     * Returns the year this novel was published.
     *
     * @return the publication year
     */
    public int getYearOfPublication()
    {
        return yearOfPublication;
    }


    /**
     * Validates that the given title is not null or blank.
     *
     * @param title the title to validate
     * @throws IllegalArgumentException if the title is null or blank
     */
    private static void validateTitle(final String title)
    {
        if (title == null || title.isBlank())
        {
            throw new IllegalArgumentException("Title cannot be null or blank.");
        }
    }


    /**
     * Validates that the given author name is not null or blank.
     *
     * @param author the author name to validate
     * @throws IllegalArgumentException if the author is null or blank
     */
    private static void validateAuthor(final String author)
    {
        if (author == null || author.isBlank())
        {
            throw new IllegalArgumentException("Author cannot be null or blank.");
        }
    }


    /**
     * Validates that the publication year is within the allowed range.
     *
     * @param yearOfPublication the year to validate
     * @throws IllegalArgumentException if the year is out of range
     */
    private static void validateYearOfPublication(final int yearOfPublication)
    {
        if (yearOfPublication < MIN_YEAR_OF_PUBLICATION
            || yearOfPublication > MAX_YEAR_OF_PUBLICATION)
        {
            throw new IllegalArgumentException(
                "Year of publication must be between " +
                    MIN_YEAR_OF_PUBLICATION + " and " +
                    MAX_YEAR_OF_PUBLICATION + ".");
        }
    }


    /**
     * Returns a concise string representation of this novel, including only
     * the title and the year of publication.
     *
     * @return a formatted string with the novel's title and publication year.
     */
    public String getTitleAndYearString()
    {
        return title + ", Published: " + yearOfPublication;
    }


    /**
     * Returns a string representation of this novel in a nice format.
     * Fulfills the requirement for Part 2.
     *
     * @return a formatted string with the novel's title, author, and year
     */
    @Override
    public String toString()
    {
        return "Novel: " + title + " by " +
            author + ", Published: " + yearOfPublication;
    }


}
