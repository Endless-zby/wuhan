package club.zby.wuhan.InternetFront.Controller;

import club.zby.wuhan.InternetFront.Service.WuHanService;
import club.zby.wuhan.bean.EpidemicBean.CityEpidemicBean;
import club.zby.wuhan.bean.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: 赵博雅
 * @Date: 2020/2/10 15:26
 */
@Controller
@RequestMapping(value = "wuhan")
@Api(value = "wuhan")
public class wuHanController {

    @Autowired
    private WuHanService wuHanService;

    /**
     * 查询各个区县市级的疫情情况
     * @return
     */
    @CrossOrigin(origins = "*")
    @GetMapping("cityEpidemic")
    @ResponseBody
    @ApiOperation(value="全国省市数据", notes="查询全国省市中已感染和疑似病例以及死亡人数")
    public Result cityEpidemic(){
        List<CityEpidemicBean> cityEpidemicBeans = wuHanService.cityEpidemic();
        return new Result(true,cityEpidemicBeans,"成功");
    }

    /**
     * 根据城市编码查询所选城市的疫情信息
     * @param cityCode
     * @return
     */
    @CrossOrigin(origins = "*")
    @GetMapping("cityEpidemicByCityCode")
    @ResponseBody
    @ApiOperation(value="市区详情", notes="查询本市区中已感染和疑似病例以及死亡人数")
    public Result cityEpidemicByCityCode(@RequestParam("cityCode") String cityCode){
        CityEpidemicBean cityEpidemicBean = wuHanService.cityEpidemicByCityCode(cityCode);
        return new Result(true,cityEpidemicBean,"成功");
    }

    @CrossOrigin(origins = "*")
    @GetMapping("sumNumber")
    @ResponseBody
    @ApiOperation(value="全国总感染人数", notes="查询全国总感染人数")
    public Result sumNumber(){
        Map map = wuHanService.sumNumber();
        return new Result(true,map,"成功");
    }

}
