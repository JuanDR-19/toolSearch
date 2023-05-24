package web.tools.toolSearch;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import web.tools.toolSearch.Entities.Tool;
import web.tools.toolSearch.Services.ToolService;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ToolControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ToolService toolService;

    @Test
    public void testGetAll() throws Exception {
        // Arrange
        ArrayList<Tool> expectedTools = new ArrayList<>();
        Tool tool = new Tool();
        tool.setId(1);
        tool.setName("Tool1");
        expectedTools.add(tool);

        when(toolService.SearchAll()).thenReturn(expectedTools);

        // Act & Assert
        mockMvc.perform(get("/get_tools")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Tool1"));
    }

    @Test
    public void testGetToolById() throws Exception {
        // Arrange
        Integer toolId = 1;
        Tool expectedTool = new Tool();
        expectedTool.setId(toolId);
        expectedTool.setName("Tool1");

        when(toolService.searchToolById(toolId)).thenReturn(Optional.of(expectedTool));

        // Act & Assert
        mockMvc.perform(get("/get_tool/{ID}", toolId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(toolId))
                .andExpect(jsonPath("$.name").value("Tool1"));
    }

    @Test
    public void testGetToolByName() throws Exception {
        // Arrange
        String toolName = "Tool1";
        ArrayList<Tool> expectedTools = new ArrayList<>();
        Tool tool = new Tool();
        tool.setId(1);
        tool.setName(toolName);
        expectedTools.add(tool);

        when(toolService.searchToolByName(toolName)).thenReturn(expectedTools);

        // Act & Assert
        mockMvc.perform(get("/get_tool_name/{name}", toolName)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value(toolName));
    }

    @Test
    public void testGetToolByBrand() throws Exception {
        // Arrange
        String brandName = "Brand1";
        ArrayList<Tool> expectedTools = new ArrayList<>();
        Tool tool = new Tool();
        tool.setId(1);
        tool.setName("Tool1");
        expectedTools.add(tool);

        when(toolService.searchToolsByBrandName(brandName)).thenReturn(expectedTools);

        // Act & Assert
        mockMvc.perform(get("/get_tool_brand/{name}", brandName)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect( jsonPath("$[0].name").value("Tool1"));
    }



}
