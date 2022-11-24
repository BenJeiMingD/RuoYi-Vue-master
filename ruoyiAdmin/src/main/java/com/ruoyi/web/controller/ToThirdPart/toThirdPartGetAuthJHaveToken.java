package com.ruoyi.web.controller.ToThirdPart;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.user.UserPasswordNotMatchException;
import com.ruoyi.common.utils.MessageUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.framework.manager.AsyncManager;
import com.ruoyi.framework.manager.factory.AsyncFactory;
import com.sun.deploy.net.HttpResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;

public class toThirdPartGetAuthJHaveToken {



     /* @Description: 平台带着token来系统里面登陆
     * 这边需要做两个步骤：
     * 1.检测数据库里面有没有这个用户名，有则不操作，无则添加
     * 2.去平台验证一下Token是否有，有的话继续操作后面的登录
     * 平台没有这个token，则直接打回去，不让上来
     * @author: 穆雄雄
     * @date: 2022/4/19 上午 11:38
     * @Return: com.ruoyi.common.core.domain.AjaxResult*/


   /* @PostMapping("/toThirdPartGetAuthJHaveToken")
    @ApiOperation(value = "平台带着token过来登录")
    public AjaxResult toThirdPartGetAuthJHaveToken(String token) {

        //调用验证token的方法
        JSONObject jsonObject = checkJToken(token);
        String code = jsonObject.getString("code");
        Integer level = 0;
        String loginName = "";
        Long organId = null;
        //返回结果
        AjaxResult ajax = null;
        if (code.equals("0")) {
            //验证成功
            JSONObject dataObject = jsonObject.getJSONObject("data");
            //拿到其他的信息
            level = dataObject.getInteger("level");
            loginName = dataObject.getString("name");
            organId = dataObject.getLong("organId");
        } else {
            ajax = AjaxResult.error(jsonObject.getString("msg"));
            return ajax;
        }

        String isUserNameHas = "";
        //检测一下用户名存在不存在
        if (UserConstants.NOT_UNIQUE.equals(userService.checkUserNameUnique(loginName))) {
            isUserNameHas = "用户已存在，不需要执行添加的操作";
        } else {
            //用户不存在时，将用户添加到数据库中
            SysUser sysUser = new SysUser();
            //登录名
            sysUser.setUserName(loginName);
            //昵称
            sysUser.setNickName(loginName);
            //密码统一都是123456
            sysUser.setPassword(SecurityUtils.encryptPassword("123456"));
            //创建者，标识J平台过来的用户
            sysUser.setCreateBy("j_have_token");
            //创建日期
            sysUser.setCreateTime(new Date());
            //所属等级
            sysUser.setHierarchy(level);
            //明文
            sysUser.setMingwen("123456");
            //账户权限：为了区分是平台的用户还是本系统用户

            //id返回来之后需要加上
            sysUser.setDeptId(organId);

            //所属等级如果没有，则角色是全国的
            //1  省  2 市     3  区
            if (level == null) {
                //角色
                Long[] roleids = {104L};
                sysUser.setRoleIds(roleids);
            } else {
                Long[] roleids = {100L};
                sysUser.setRoleIds(roleids);
            }
            int rows = userService.insertUser(sysUser);
            if (rows > 0) {
                isUserNameHas = "添加成功";
            }
        }
        ajax = AjaxResult.success();
        // 生成令牌(不加验证码登录)
        String tokenNew = loginService.loginNoCode(loginName, "123456", null);
        ajax.put(Constants.TOKEN, tokenNew);
        ajax.put("isUserNameHas", isUserNameHas);
        ajax.put("msg", "登录成功");
        return ajax;
    }


     /* 检测一下J平台的token 对不对
     *
     * @param token
     * @return*/


    /*public JSONObject checkJToken(String token) {
        JSONObject jsonObject = new JSONObject();
        //测试环境
        String baseUrl = "http://xxxxx/checkTokenRtnInfo?stk=" + token;
        HttpResponse d = HttpRequest.get(baseUrl)
                .header(HttpHeaders.CONTENT_TYPE, "application/json")
                .header(HttpHeaders.ACCEPT, "application/json")
                .execute();
        return (JSONObject) JSONObject.parse(d.body().toString());
    }



     /* 不加验证码登录
     *
     * @param username 用户名
     * @param password 密码
     * @param uuid 唯一标识
     * @return 结果


    public String loginNoCode(String username, String password,  String uuid)
    {
        // 用户验证
        Authentication authentication = null;
        try
        {
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }
        catch (Exception e)
        {
            if (e instanceof BadCredentialsException)
            {
                AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
                throw new UserPasswordNotMatchException();
            }
            else
            {
                AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, e.getMessage()));
                throw new ServiceException(e.getMessage());
            }
        }
        AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_SUCCESS, MessageUtils.message("user.login.success")));
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        recordLoginInfo(loginUser.getUserId());
        // 生成token
        return tokenService.createToken(loginUser);
    }*/

}