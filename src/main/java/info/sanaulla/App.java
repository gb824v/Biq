package info.sanaulla;
import com.google.common.cache.CacheStats;
import info.sanaulla.model.Book;
import info.sanaulla.service.BookService;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, ExecutionException {
        Book book = BookService.getBookDetails("9780596009205").get();
        System.out.println(info.sanaulla.Util.getObjectMapper().writeValueAsString(book));
        book = BookService.getBookDetails("9780596009205").get();
        book = BookService.getBookDetails("9780596009205").get();
        book = BookService.getBookDetails("9780596009205").get();
        book = BookService.getBookDetails("9780596009205").get();
        CacheStats cacheStats = BookService.getCacheStats();
        System.out.println(cacheStats.toString());
    }
}
