package davincilabs.ai.test.endpoint;

import davincilabs.ai.test.model.DataParam;
import davincilabs.ai.test.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Dalgun.
 * User: dalgun
 * Date: 2020/04/25
 * Time: 12:47 오후
 */
@RestController
@Slf4j
public class TestEndpoint {

    private TestService testService;

    public TestEndpoint(TestService testService){
        this.testService = testService;
    }

    @PostMapping(value = "/predictions")
    public Map<String, Object> getId(@RequestBody DataParam dataParam){
        log.info("전달받은 PREDICATION 요청 URL: {}", dataParam.getUrl());
        return testService.getId(dataParam.getUrl());
    }

    @GetMapping(value = "/predictions/{id}")
    public Map<String, Object> getAge(@PathVariable(name = "id") Long id){
        log.info("전달받은 PREDICATION GET AGE 요청 ID : {}", id);
        return testService.predictAge(id);
    }
}
