package com.digiwin.testapp.service.dap;

import com.digiwin.testapp.annotation.ApiInvoker;
import com.digiwin.testapp.annotation.AppService;
import com.digiwin.testapp.annotation.MulApiInvoker;

/**
 * FileName:ITestService
 * Author: shenbao
 * Date: 2022/2/19 22:18
 * Description:
 */
public interface ITestService {
    @AppService(id = "a.b.c.d", tableNames = "pcc_task")
    @ApiInvoker(callerName = "a1.b1.c1.d1")
    @ApiInvoker(callerName = "a2.b2.c2.d2")
    public void test();
}
