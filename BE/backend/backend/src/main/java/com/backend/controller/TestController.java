package com.backend.controller;


import com.backend.model.SearchVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestController {

    // http통신할때 post는 body에다 data를 집어넣어서 받아오겠다.
    // @RequestBody에 SearchVO에 있는 값을 매칭해서 보내줘라.

    @RequestMapping(method = RequestMethod.POST, path = "/postRequest")
    public SearchVO postRequest(@RequestBody SearchVO searchVo){
        return searchVo;
    }

    @PostMapping(value = "/postMapping")
    public SearchVO postMapping(@RequestBody SearchVO searchVo){
        return searchVo;
    }
    @GetMapping("/getMultiParametersRtnJson")
    public SearchVO getMultiParametersRtnJson(SearchVO searchVo) {
        return searchVo;
    }
}