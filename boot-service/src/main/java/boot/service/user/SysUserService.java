package boot.service.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import boot.domain.user.SysUserEntity;

/**
 * @Author xiaoliang.shang
 * @Date 2020/1/13 15:25
 **/
public interface SysUserService extends IService<SysUserEntity> {
    /**
     * @description 条件构造器使用
     * @return domain.user.SysUserEntity
     * @date 2020/1/15 10:08
     * @author xiaoliang.shang
     */
    SysUserEntity getSysUserByQueryWrapper();

    /**
     * @description mapper.xml方式执行sql
     * @param loginName
     * @return com.baomidou.mybatisplus.core.metadata.IPage<domain.user.SysUserEntity>
     * @date 2020/1/15 11:31
     * @author xiaoliang.shang
     */
    IPage<SysUserEntity> getSysUserByLoginName(IPage<SysUserEntity> iPage,String loginName);
}
