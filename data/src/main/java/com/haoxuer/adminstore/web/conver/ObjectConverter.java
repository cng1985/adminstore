package com.haoxuer.adminstore.web.conver;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;

import java.util.Date;

public class ObjectConverter implements Converter<byte[], Object> {
  @Override
  public Object convert(byte[] bytes) {
    return new DeserializingConverter().convert(bytes);
  }
}
