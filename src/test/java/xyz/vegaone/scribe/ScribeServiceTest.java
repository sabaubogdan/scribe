package xyz.vegaone.scribe;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.vegaone.scribe.service.ScribeService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScribeServiceTest {
    @Autowired
    private ScribeService scribeService;

    @Test
    public void discoverAndIndexFilesTest() throws IOException {
        // given
        String path = "C:\\test";

        // when
        Map<String, List<String>> result = scribeService.discoverAndIndexFiles(path);

        // then
        Assert.assertNotNull(result);
    }

}
