package com.core.common;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-9-9
 * Time: 上午8:14
 * To change this template use File | Settings | File Templates.
 */
public class InitListener implements ApplicationListener<ContextRefreshedEvent> {
    private static Logger LOGGER = Logger.getLogger(InitListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        InputStream in = null;
        try {
            LOGGER.info("开始加载ws-config.properties文件内容.......");
            in = InitListener.class.getClassLoader().getResourceAsStream("ws-config.properties");
            BufferedReader bf = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            Constant.props.load(bf);
        } catch (FileNotFoundException e) {
            LOGGER.info("ws-config.properties文件未找到");
        } catch (IOException e) {
            LOGGER.info("出现IOException");
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
            } catch (IOException e) {
                LOGGER.info("ws-config.properties文件流关闭出现异常");
            }
            LOGGER.info("加载ws-config.properties文件内容完成...........");
        }

    }

}
