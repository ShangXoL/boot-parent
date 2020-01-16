package shang.service.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import domain.user.SysUserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shang.mapper.user.SysUserDao;
import shang.service.user.SysUserService;

/**
 * @Author xiaoliang.shang
 * @Date 2020/1/13 15:29
 * @DESCRIPTION 实现类
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {
    @Override
    public SysUserEntity getSysUserByQueryWrapper(){
        QueryWrapper<SysUserEntity> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(SysUserEntity::getLoginName,"xiaoliang.shang");
        SysUserEntity sysUserEntity=this.getOne(queryWrapper);
        return sysUserEntity;
    }

    @Override
    public IPage<SysUserEntity> getSysUserByLoginName(IPage<SysUserEntity> iPage,String loginName) {
        return this.baseMapper.getSysUserByLoginName(iPage,loginName);
    }
}
