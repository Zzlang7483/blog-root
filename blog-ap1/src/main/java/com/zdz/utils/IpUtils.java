package com.zdz.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;



public class IpUtils {
    public static String getIpAddr(HttpServletRequest request) {

        String ip = null, unknown = "unknown", seperator = ",";

        int maxLength = 15;

        try {

            ip = request.getHeader("x-forwarded-for");

            if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)) {

                ip = request.getHeader("Proxy-Client-IP");

            }

            if (StringUtils.isEmpty(ip) || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {

                ip = request.getHeader("WL-Proxy-Client-IP");

            }

            if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)) {

                ip = request.getHeader("HTTP_CLIENT_IP");

            }

            if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)) {

                ip = request.getHeader("HTTP_X_FORWARDED_FOR");

            }

            if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)) {

                ip = request.getRemoteAddr();

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

// 使用代理，则获取第一个IP地址

        if (StringUtils.isEmpty(ip) && ip.length() > maxLength) {

            int idx = ip.indexOf(seperator);

            if (idx > 0) {

                ip = ip.substring(0, idx);

            }

        }

        return ip;

    }

    /**

     * 获取ip地址

     *

     * @return

     */

    public static String getIpAddr() {

        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();

        return getIpAddr(request);

    }

}
