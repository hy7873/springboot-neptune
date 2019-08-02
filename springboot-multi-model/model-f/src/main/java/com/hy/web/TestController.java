package com.hy.web;

import com.hy.model.ModelS;
import com.hy.model.ModelT;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wanghai
 * @Date:2019/7/17 10:12
 * @Copyright:reach-life
 * @Description:
 */
@RestController
public class TestController {

    @GetMapping("/")
    public String home() {
        ModelS modelS = new ModelS();
        modelS.setId(11);
        ModelT modelT = new ModelT();
        modelT.setId(22);
        return modelS.toString()  + "\n" + modelT.toString();
    }

}
