package com.ruoyi.web.controller.system;

import java.util.List;
import java.util.Set;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.system.domain.Deptqi;
import com.ruoyi.system.domain.configure.Configure;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysMenu;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginBody;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.framework.web.service.SysLoginService;
import com.ruoyi.framework.web.service.SysPermissionService;
import com.ruoyi.system.service.ISysMenuService;

/**
 * 登录验证
 * 
 * @author ruoyi
 */
@CrossOrigin
@RestController
public class SysLoginController
{
    @Autowired
    private SysLoginService loginService;

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private SysPermissionService permissionService;

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysUserService userService;

    /**
     * sso登录方法 单点登录
     *
     * @return 结果
     */
    @PostMapping("/ssoLogin")
    public AjaxResult ssoLogin(@RequestParam String name, String str) {
        AjaxResult ajax = AjaxResult.success();
        String token = loginService.ssoLogin(name, str);
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

    /**
     * 登录方法
     * 
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody)
    {
        AjaxResult ajax = AjaxResult.success();
        Configure configure = new Configure();
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
                loginBody.getUuid());
        //String token = configure.getToken();
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

    /**
     * 登录方法 ：单点登录
     *
     * @param loginBody 单点登录
     * @return 结果
     */
    @PostMapping("/singlelogin")
    public AjaxResult SinglePoint(@RequestBody String loginBody)
    {
        System.out.println("loginBody = " + loginBody);
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        Configure configure = new Configure();

        System.out.println("loginBody = " + loginBody);
        JSONObject jsonObject = JSON.parseObject(loginBody).getJSONObject("queryParam");
        //传入 用户名，反查出 用户id
        SysUser sysUser = JSON.toJavaObject(jsonObject, SysUser.class);
        if (sysUser.getToken().equals(configure.getToken())){

        List<SysUser> sysUsers = sysUserService.selectSysUserL(sysUser);

        Long userId = sysUsers.get(0).getUserId();//用户名 id
        String password = sysUsers.get(0).getPassword();// 原始密码md5加密
        //为生成tocken定义密码
        String passw =configure.getPassw();
                //通过更新密码返回自定义密码的tocken ，无需原有密码进行登录
        SysUser user = new SysUser();
        //userService.checkUserAllowed(user);
        //userService.checkUserDataScope(userId);

        //更新密码 通过id
        user.setPassword(SecurityUtils.encryptPassword(passw));
        user.setUserId(userId);
        int pwd = userService.resetPwd(user);
        // 生成令牌
        LoginBody loginBody1 = new LoginBody();
        loginBody1.setUsername(sysUser.getUserName());
        loginBody1.setPassword(passw);
        String token = loginService.login(loginBody1.getUsername(), loginBody1.getPassword(), loginBody1.getCode(),
                loginBody1.getUuid());
        //String token = configure.getToken();
        ajax.put(Constants.TOKEN, token);
        //将密码重新改回原始密码
        SysUser user1 = new SysUser();
        //userService.checkUserAllowed(user1);
        //userService.checkUserDataScope(userId);
        user1.setPassword(password);//
        user1.setUserId(userId);
        int pwd2 = userService.resetPwd(user1);
        return ajax;
        }else {
            return AjaxResult.error("登录失败");
        }
    }

    /**
     * 获取用户信息
     * 
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo()
    {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        return ajax;
    }

    /**
     * 获取路由信息
     * 
     * @return 路由信息
     */
    @GetMapping("getRouters")
    public AjaxResult getRouters()
    {
        Long userId = SecurityUtils.getUserId();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(userId);
        return AjaxResult.success(menuService.buildMenus(menus));
    }
}
