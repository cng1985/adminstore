package com.haoxuer.adminstore.web.conver;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.SerializingConverter;

public class BytesConverter implements Converter<Object, byte[]> {
  @Override
  public byte[] convert(Object o) {
    return new SerializingConverter().convert(o);
  }
}
