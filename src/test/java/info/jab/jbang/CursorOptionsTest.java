package info.jab.jbang;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class CursorOptionsTest {

    @Test
    void testIterator() {
        // Create an instance of CursorOptions
        CursorOptions cursorOptions = new CursorOptions();
        
        // Get the iterator
        Iterator<String> iterator = cursorOptions.iterator();
        
        // Collect all the values
        List<String> values = new ArrayList<>();
        while (iterator.hasNext()) {
            values.add(iterator.next());
        }
        
        // Verify all expected values are present
        assertThat(values).contains("java", "java-spring-boot", "java-quarkus");
        assertThat(values).hasSize(3); // Ensure exactly these two values
    }
    
    @Test
    void testIsValidOption() {
        // Test with valid options
        assertThat(CursorOptions.isValidOption("java")).isTrue();
        assertThat(CursorOptions.isValidOption("java-spring-boot")).isTrue();
        assertThat(CursorOptions.isValidOption("java-quarkus")).isTrue();
        // Test with invalid options
        assertThat(CursorOptions.isValidOption("invalid-option")).isFalse();
        assertThat(CursorOptions.isValidOption("")).isFalse();
        assertThat(CursorOptions.isValidOption(null)).isFalse();
    }
} 