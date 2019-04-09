package org.linlinjava.litemall.qwfb.shiro;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;

import org.crazycake.shiro.serializer.ObjectSerializer;
import org.crazycake.shiro.serializer.RedisSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.serializer.SerializationException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * {@link RedisSerializer} that can read and write JSON using
 * <a href="https://github.com/FasterXML/jackson-core">Jackson's</a> and
 * <a href="https://github.com/FasterXML/jackson-databind">Jackson Databind</a>
 * {@link ObjectMapper}.
 * <p>
 * This converter can be used to bind to typed beans, or untyped
 * {@link java.util.HashMap HashMap} instances. <b>Note:</b>Null objects are
 * serialized as empty arrays and vice versa.
 *
 * @author Thomas Darimont
 * @since 1.2
 */
public class ObjRedisSerializer<T> implements RedisSerializer<T> {

    private static Logger logger = LoggerFactory.getLogger(ObjectSerializer.class);

    public static final int BYTE_ARRAY_OUTPUT_STREAM_SIZE = 128;

    @Override
    public byte[] serialize(Object object) throws SerializationException {
        byte[] result = new byte[0];

        if (object == null) {
            return result;
        }
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream(BYTE_ARRAY_OUTPUT_STREAM_SIZE);
        if (!(object instanceof Serializable)) {
            throw new SerializationException("requires a Serializable payload " + "but received an object of type ["
                    + object.getClass().getName() + "]");
        }
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            result = byteStream.toByteArray();
        } catch (IOException e) {
            throw new SerializationException("serialize error, object=" + object, e);
        }

        return result;
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        T result = null;

        if (bytes == null || bytes.length == 0) {
            return result;
        }

        try {
            ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
            CustomObjectInputStream objectInputStream = new CustomObjectInputStream(byteStream,
                    this.getClass().getClassLoader());
            result = (T) objectInputStream.readObject();
        } catch (IOException e) {
            throw new SerializationException("deserialize error ", e);
        } catch (ClassNotFoundException e) {
            throw new SerializationException("deserialize error", e);
        }

        return result;
    }

    /**
     * 增加 classloader 参数，解决devtools重新加载后，classloader变化的问题：<br>
     * https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-devtools-known-restart-limitations<br>
     * https://www.jianshu.com/p/32d38a7fd20a<br>
     * 
     * @author fengzilin
     *
     */
    public static class CustomObjectInputStream extends ObjectInputStream {
        protected ClassLoader classLoader = this.getClass().getClassLoader();

        public CustomObjectInputStream(InputStream in) throws IOException {
            super(in);
            // TODO Auto-generated constructor stub
        }

        public CustomObjectInputStream(InputStream in, ClassLoader cl) throws IOException {
            super(in);
            // TODO Auto-generated constructor stub
            this.classLoader = cl;
        }

        /*
         * * (non-Javadoc) * * @see
         * java.io.ObjectInputStream#resolveClass(java.io.ObjectStreamClass)
         */
        @Override
        protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
            // TODO Auto-generated method stub
            String name = desc.getName();
            try {
                return Class.forName(name, false, this.classLoader);
            } catch (ClassNotFoundException ex) {
                return super.resolveClass(desc);
            }
        }

    }
}
