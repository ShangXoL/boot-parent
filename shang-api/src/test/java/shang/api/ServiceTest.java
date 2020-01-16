package shang.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import domain.user.SysUserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import shang.mapper.user.SysUserDao;
import shang.service.user.SysUserService;

/**
 * @Author xiaoliang.shang
 * @Date 2020/1/15 10:10
 * @DESCRIPTION 业务层测试
 **/
public class ServiceTest extends AppApplicationTests {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserDao sysUserDao;
    @Test
    public void getSysUserByQueryWrapper(){
        SysUserEntity sysUserEntity=sysUserService.getSysUserByQueryWrapper();
        System.out.println(sysUserEntity.getPhone());
    }

    @Test
    public void getSysUserByLoginName(){
        String loginName="xiaoliang.shang";
        IPage<SysUserEntity> page=new Page<>();
        page.setCurrent(5);
        page.setSize(10);
        IPage<SysUserEntity> iPage= sysUserService.getSysUserByLoginName(page,loginName);
        System.out.println(iPage);

    }
    @Test
    public void getSysUserByLoginName2(){
        sysUserDao.getSysUserByLoginName2("xiaoliang.shang");
    }
}
