package davincilabs.ai.test.service;

import davincilabs.ai.test.model.DataParam;
import davincilabs.ai.test.repository.DataParamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dalgun.
 * User: dalgun
 * Date: 2020/04/25
 * Time: 12:48 오후
 */
@Service
@Slf4j
public class TestService {

    private DataParamRepository dataParamRepository;

    @Autowired
    public TestService(DataParamRepository dataParamRepository){
        this.dataParamRepository = dataParamRepository;
    }

    public Map<String, Object> getId(String url){

        log.info("전달받은 URL : {}", url);
        DataParam dataParam = dataParamRepository.save(DataParam.builder()
                .url(url)
                .build());

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("id", dataParam.getId());

        return resultMap;
    }

    public Map<String, Object> predictAge(Long id){
        Map<String, Object> resultMap = new HashMap<>();
        DataParam dataParam = dataParamRepository.findById(id).orElseThrow(()->new RuntimeException("아이디에 해당하는 URL 정보가 없습니다"));
        try {
            Process process = Runtime.getRuntime().exec("python /docker/model.py "+dataParam.getUrl());
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            int age = Integer.valueOf(stdInput.readLine());

            resultMap.put("age", age);

            return resultMap;
        }catch (IOException e){
            log.error("오류 발생");
            resultMap.put("error", e.getMessage());
            return resultMap;
        }
    }

}
