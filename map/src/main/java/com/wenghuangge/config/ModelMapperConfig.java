package com.wenghuangge.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName footmap
 * @ClassName ModelMapperConfig
 * @Date 2021/3/7 14:46
 * @Author wenghuangge
 * @Version 1.0
 */

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper(){
        return  new ModelMapper();
    }
}
