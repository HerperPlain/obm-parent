package com.obm.common.config.redis;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * Redis 序列化：redis缓存的对象必须序列化，
 */
public class RedisObjectSerializer implements RedisSerializer<Object> {

    private Converter<Object,byte[]> serializer = new SerializingConverter();
    private Converter<byte[],Object> deserializer = new DeserializingConverter();

    static final byte[] EMPTY_ARRAY=new byte[0];


    @Override
    public byte[] serialize(Object o) throws SerializationException {
        if(o == null){
            return EMPTY_ARRAY;
        }
        return serializer.convert(o);
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if(isEmpty(bytes)){
            return EMPTY_ARRAY;
        }
        return deserializer.convert(bytes);
    }

    private boolean isEmpty(byte[] data){
        return (data == null || data.length == 0 );
    }
}
