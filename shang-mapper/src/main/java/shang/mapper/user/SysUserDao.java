package shang.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import domain.user.SysUserEntity;

/**
 * @Author xiaoliang.shang
 * @Date 2020/1/13 15:24
 **/
public interface SysUserDao extends BaseMapper<SysUserEntity> {
    IPage<SysUserEntity> getSysUserByLoginName(IPage<SysUserEntity> iPage,String loginName);
    SysUserEntity getSysUserByLoginName2(String loginName);
}
