package shang.controller.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import domain.user.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shang.controller.base.BaseController;
import shang.service.user.SysUserService;
import shang.service.user.impl.SysUserServiceImpl;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author xiaoliang.shang
 * @Date 2020/1/10 17:57
 * @DESCRIPTION 系统正常检测接口
 **/
@RestController
@RequestMapping("user")
public class SysUserController extends BaseController {
    @Autowired
    private SysUserService sysUserService;
    /**
     * @description 系统正常测试接口
     * @return java.lang.String
     * @date 2020/1/10 17:59
     * @author xiaoliang.shang
     */
    @GetMapping("suc")
    public String suc(){
        return "true";
    }

    @GetMapping("getUserById")
    public SysUserEntity getUserById(String id){
        return sysUserService.getById(id);
    }

    @GetMapping("getUserListPage")
    public IPage<SysUserEntity> getUserListPage(HttpServletRequest request){
        IPage<SysUserEntity> page=new Page<>();
        String currentStr=request.getParameter("current");
        String sizeStr=request.getParameter("size");
        if(!(StringUtils.isEmpty(sizeStr)||StringUtils.isEmpty(currentStr))){
            //当前页数
            page.setCurrent(Integer.valueOf(currentStr));
            //每页条数
            page.setSize(Integer.valueOf(sizeStr));
        }else{
            //当前页数
            page.setCurrent(5);
            //每页条数
            page.setSize(10);
        }

        page=sysUserService.page(page);
        return page;
    }
}
