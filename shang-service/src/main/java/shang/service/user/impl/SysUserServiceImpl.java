package shang.service.user.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import domain.user.SysUserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shang.dao.SysUserDao;
import shang.service.user.SysUserService;

/**
 * @Author xiaoliang.shang
 * @Date 2020/1/13 15:29
 * @DESCRIPTION 实现类
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {
}
