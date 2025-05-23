package info.jab.cli.behaviours;

import info.jab.cli.io.CopyFiles;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;

@ExtendWith(MockitoExtension.class)
class CursorTest {

    @Mock
    private CopyFiles mockCopyFiles;

    private Cursor cursor;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    @SuppressWarnings("NullAway.Init")
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        cursor = new Cursor(mockCopyFiles);
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testExecuteWithInvalidParam() {
        // Given
        String invalidOption = "invalid-option";

        // When & Then
        assertThatThrownBy(() -> cursor.execute(invalidOption))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Invalid parameter: " + invalidOption);
        verify(mockCopyFiles, never()).copyFilesToDirectory(any(), anyString(), any(Path.class));
    }

    @Test
    void testExecuteWithValidJavaParam() {
        // Given
        Mockito.doNothing().when(mockCopyFiles).copyFilesToDirectory(any(), anyString(), any(Path.class));

        // When
        cursor.execute("java");

        // Then
        assertThat(outputStreamCaptor.toString(StandardCharsets.UTF_8).trim())
            .contains("Cursor rules added successfully");
        verify(mockCopyFiles).copyFilesToDirectory(any(), eq("cursor-rules-java/"), any(Path.class));
    }

    @Test
    void testExecuteWithJavaSpringBootParam() {
        // Given
        Mockito.doNothing().when(mockCopyFiles).copyFilesToDirectory(any(), anyString(), any(Path.class));

        // When
        cursor.execute("java-spring-boot");

        // Then
        assertThat(outputStreamCaptor.toString(StandardCharsets.UTF_8).trim())
            .contains("Cursor rules added successfully");
        verify(mockCopyFiles).copyFilesToDirectory(any(), eq("cursor-rules-java/"), any(Path.class));
    }

    @Test
    void testExecuteWithJavaQuarkusParam() {
        // Given
        Mockito.doNothing().when(mockCopyFiles).copyFilesToDirectory(any(), anyString(), any(Path.class));

        // When
        cursor.execute("java-quarkus");

        // Then
        assertThat(outputStreamCaptor.toString(StandardCharsets.UTF_8).trim())
            .contains("Cursor rules added successfully");
        verify(mockCopyFiles).copyFilesToDirectory(any(), eq("cursor-rules-java/"), any(Path.class));
    }

    @Test
    void testExecuteWithTasksParam() {
        // Given
        Mockito.doNothing().when(mockCopyFiles).copyFilesToDirectory(any(), anyString(), any(Path.class));

        // When
        cursor.execute("tasks");

        // Then
        assertThat(outputStreamCaptor.toString(StandardCharsets.UTF_8).trim())
            .contains("Cursor rules added successfully");
        verify(mockCopyFiles).copyFilesToDirectory(any(), eq("cursor-rules-tasks/"), any(Path.class));
    }

    @Test
    void testExecuteWithAgileParam() {
        // Given
        Mockito.doNothing().when(mockCopyFiles).copyFilesToDirectory(any(), anyString(), any(Path.class));

        // When
        cursor.execute("agile");

        // Then
        assertThat(outputStreamCaptor.toString(StandardCharsets.UTF_8).trim())
            .contains("Cursor rules added successfully");
        verify(mockCopyFiles).copyFilesToDirectory(any(), eq("cursor-rules-agile/"), any(Path.class));
    }
}