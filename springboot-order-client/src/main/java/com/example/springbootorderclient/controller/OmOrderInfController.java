package com.example.springbootorderclient.controller;

import com.example.springbootblmapi.entity.OmOrderInfEntity;
import com.example.springbootblmapi.form.OrderInfAllApp;
import com.example.springbootblmapi.form.OrderInfApp;
import com.example.springbootblmapi.service.OmOrderInfService;
import com.example.springbootblmapi.service.OmOrderService;
import com.example.springbootblmapi.util.AbstractJsonObject;
import com.example.springbootblmapi.util.ListJsonObject;
import com.example.springbootblmapi.util.SingleObject;
import com.example.springbootblmapi.util.StatusHouse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/orderinf")
@Api("订单详情接口")
public class OmOrderInfController {
    @Reference
    private OmOrderInfService orderInfService;
    @Reference(version = "1.0.0")
    private OmOrderService orderService;

    @GetMapping("/getOrderInf")
    @ApiOperation("获得订单详情信息：菜品名、菜品数量")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单id")
    })
    public AbstractJsonObject getOrderInf(@RequestParam int orderId) {
        ListJsonObject res = new ListJsonObject();
        res.setStatusObject(StatusHouse.COMMON_STATUS_OK);
        res.setData(orderInfService.getOrderInfName(orderId));
        return res;
    }

    @PostMapping("addOrderInfApp")
    @ApiOperation("添加订单详情")
    public AbstractJsonObject addOrderInfApp(@RequestBody OmOrderInfEntity form) {
        try {
            AbstractJsonObject res = new AbstractJsonObject();
            res.setStatusObject(StatusHouse.COMMON_STATUS_OK);
            orderInfService.insertSelective(form);
            return res;
        } catch (Exception e) {
            AbstractJsonObject res = new AbstractJsonObject();
            res.setStatusObject(StatusHouse.COMMON_STATUS_DBERROR);
            return res;
        }
    }

    @GetMapping("/getOrderInfByOrderIdApp")
    @ApiOperation("获得订单详情App")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单id")
    })
    public AbstractJsonObject getOrderInfByOrderIdApp(@RequestParam int orderId) {
        try {
            SingleObject res = new SingleObject();
            res.setStatusObject(StatusHouse.COMMON_STATUS_OK);
            List<OrderInfApp> orderInfApps = orderInfService.getOrderInfAll(orderId);
            OrderInfAllApp orderInfAllApp = orderService.getOrderByOrderId(orderId);
            orderInfAllApp.setOrderInfApps(orderInfApps);
            res.setData(orderInfAllApp);
            return res;
        } catch (Exception e) {
            AbstractJsonObject res = new AbstractJsonObject();
            res.setStatusObject(StatusHouse.COMMON_STATUS_DBERROR);
            return res;
        }
    }
}
