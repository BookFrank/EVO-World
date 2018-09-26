package com.tazine.evo.annotation.controller;

import com.tazine.evo.annotation.service.ScanService;
import com.tazine.evo.noscan.DemoService;
import com.tazine.evo.noscan.NoScanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiaer.ly
 * @date 2018/09/19
 */
@RestController
public class HelloController {

    @Autowired
    private ScanService scanService;

    //@Autowired
    //private NoScanService noScanService;

    @Autowired
    private DemoService demoService;

    @RequestMapping("/import/demo")
    public void demoTest(){
        demoService.test();
    }

    @RequestMapping("/scan/test")
    public void test(){
        scanService.test();
    }

    //@RequestMapping("/noscan/test")
    //public void noTest(){
    //    noScanService.test();
    //}



}
