package com.cybertek.cnverters;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

@Component
public class MapperUtil {

    private ModelMapper modelMapper;
    public <T>T convert(Object obj,T convertedObj){
        return modelMapper.map(obj, (Type) convertedObj.getClass());
    }
}

