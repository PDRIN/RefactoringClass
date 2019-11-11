import org.junit.Test;
import static org.junit.Assert.*;

class StatementTest {
    @Test
    public void testStatement() {
        Customer jobson = new Customer("Jobson");

        Movie movie_A  = new Movie("Interstellar", 0);
        Movie movie_B = new Movie("El Topo", 1);
        Movie movie_C     = new Movie("Drive", 2);

        Rental rental_A  = new Rental(movie_A, 2);
        Rental rental_B = new Rental(movie_B, 3);
        Rental rental_C = new Rental(movie_C, 1);

        assertEquals(jobson.statement()
                     , "Rental Record for Jobson\n"
                     + "Amount owed is 0.0\n"
                     + "You earned 0 frequent renter points");

        jobson.addRental(rental_C);
        assertEquals(jobson.statement()
                     , "Rental Record for Jobson\n"
                     + "\tdDrive\t1.5\n"
                     + "Amount owed is 1.5\n"
                     + "You earned 1 frequent renter points");

        jobson.addRental(rental_A);
        assertEquals(jobson.statement()
                     , "Rental Record for Jobson\n"
                     + "\tDrive\t1.5\n"
                     + "\tInterstellar\t2.0\n"
                     + "Amount owed is 3.5\n"
                     + "You earned 2 frequent renter points");

        jobson.addRental(rental_B);
        assertEquals(jobson.statement()
                     , "Rental Record for Jobson\n"
                     + "\tC\t1.5\n"
                     + "\tA\t2.0\n"
                     + "\tB\t9.0\n"
                     + "Amount owed is 12.5\n"
                     + "You earned 4 frequent renter points");
    }   
} 