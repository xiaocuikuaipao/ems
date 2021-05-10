package com.usst.ems.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Configuration
public class MyLocaleConfig implements LocaleResolver {
//    注意国际化login的文件名必须按规则填写
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String lang = httpServletRequest.getParameter("l");
//        Locale locale=Locale.getDefault();
//        System.out.println("---->"+lang);
//        if (!StringUtils.isEmpty(lang)){
//            String[] s = lang.split("_");
//            locale = new Locale(s[0], s[1]);
//            System.out.println("split----->"+s[0]+s[1]);
//        }
//        return locale;
        if (!StringUtils.isEmpty(lang)){
            String[] s = lang.split("_");
            return new Locale(s[0],s[1]);
        }else {
            Locale defaultLocale = Locale.getDefault();

            return defaultLocale;
        }
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
