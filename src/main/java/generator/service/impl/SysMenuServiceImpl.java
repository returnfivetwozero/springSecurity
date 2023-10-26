package generator.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.SysMenu;
import generator.service.SysMenuService;
import generator.mapper.SysMenuMapper;
import org.springframework.stereotype.Service;

/**
* @author champion
* @description 针对表【sys_menu(菜单表)】的数据库操作Service实现
* @createDate 2023-10-06 19:00:19
*/
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu>
implements SysMenuService{

}
