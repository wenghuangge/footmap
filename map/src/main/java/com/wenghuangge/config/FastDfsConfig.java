package com.wenghuangge.config;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;

/**
 * fastdfs配置
 * @ProjectName footmap
 * @ClassName FastDfsConfig
 * @Date 2021/3/13 17:37
 * @Author wenghuangge
 * @Version 1.0
 */
@Configuration
@Import(FdfsClientConfig.class)
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class FastDfsConfig {

}
