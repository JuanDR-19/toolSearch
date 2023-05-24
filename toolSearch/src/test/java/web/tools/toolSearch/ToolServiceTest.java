package web.tools.toolSearch;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import web.tools.toolSearch.Entities.Tool;
import web.tools.toolSearch.Repositories.ToolRepository;
import web.tools.toolSearch.Services.ToolService;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ToolServiceTest {
    @Mock
    private ToolRepository toolRepository;

    @InjectMocks
    private ToolService toolService;

    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSearchAll() {
        // Arrange
        ArrayList<Tool> expectedTools = new ArrayList<>();
        expectedTools.add(new Tool());
        when(toolRepository.findAll()).thenReturn(expectedTools);

        // Act
        ArrayList<Tool> actualTools = toolService.SearchAll();

        // Assert
        assertEquals(expectedTools, actualTools);
        verify(toolRepository, times(1)).findAll();
    }

    @Test
    public void testSearchToolById() {
        // Arrange
        Integer toolId = 1;
        Tool expectedTool = new Tool();
        when(toolRepository.findById(toolId)).thenReturn(Optional.of(expectedTool));

        // Act
        Optional<Tool> actualTool = toolService.searchToolById(toolId);

        // Assert
        assertEquals(Optional.of(expectedTool), actualTool);
        verify(toolRepository, times(1)).findById(toolId);
    }

    @Test
    public void testSearchToolByName() {
        // Arrange
        String toolName = "Tool1";
        ArrayList<Tool> expectedTools = new ArrayList<>();
        expectedTools.add(new Tool());
        when(toolRepository.findByName(toolName)).thenReturn(expectedTools);

        // Act
        ArrayList<Tool> actualTools = toolService.searchToolByName(toolName);

        // Assert
        assertEquals(expectedTools, actualTools);
        verify(toolRepository, times(1)).findByName(toolName);
    }

    @Test
    public void testSearchToolsByBrandName() {
        // Arrange
        String brandName = "Brand1";
        ArrayList<Tool> expectedTools = new ArrayList<>();
        expectedTools.add(new Tool());
        when(toolRepository.findByBrandName(brandName)).thenReturn(expectedTools);

        // Act
        ArrayList<Tool> actualTools = toolService.searchToolsByBrandName(brandName);

        // Assert
        assertEquals(expectedTools, actualTools);
        verify(toolRepository, times(1)).findByBrandName(brandName);
    }
}
