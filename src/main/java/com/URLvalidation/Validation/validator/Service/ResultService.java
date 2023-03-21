package com.URLvalidation.Validation.validator.Service;

import com.URLvalidation.Validation.validator.Model.Result;
import com.URLvalidation.Validation.validator.Repossitory.ResultRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class ResultService {


    private final ResultRepository resultRepository ;
   private static Map<String, Result> dataMap = new HashMap<>();

    Logger logger = LoggerFactory.getLogger(ResultService.class);

    @Autowired
    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;

    }
    @Async
    public  CompletableFuture<Result> getResult(String resp_key) {
        if( dataMap.get(resp_key)==null){
            Optional<Result> resultOptional = resultRepository.findResultByResp_key(resp_key);
            if(resultOptional.isPresent()){
                dataMap.put(resp_key, resultOptional.get());
                logger.info("saving result data in static map with thread : "+Thread.currentThread().getName());
                return CompletableFuture.completedFuture(resultOptional.get());
            }else{
                return CompletableFuture.completedFuture(null);
            }
        }else{
            return CompletableFuture.completedFuture(dataMap.get(resp_key));
        }
    }
    public void addNewResult(Result result) {

        resultRepository.save(result);
        System.out.println(result);
    }
}

