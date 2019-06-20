package com.hitgou.common.util;

public class KryoSerializationCustom { //implements Serialization {

//    @Override
//    public byte getContentTypeId() {
//        return 8;
//    }
//
//    @Override
//    public String getContentType() {
//        return "x-application/kryocustom";
//    }
//
//    @Override
//    public ObjectOutput serialize(URL url, OutputStream out) throws IOException {
//        return new KryoObjectOutput(out);
//    }
//
//    @Override
//    public ObjectInput deserialize(URL url, InputStream is) throws IOException {
//        CustomObjectInputStream objectInputStream = new CustomObjectInputStream(is, this.getClass().getClassLoader());
//        return new KryoObjectInput(objectInputStream);
//    }
//
//    /**
//     * 增加 classloader 参数，解决devtools重新加载后，classloader变化的问题：<br>
//     * https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-devtools-known-restart-limitations<br>
//     * https://www.jianshu.com/p/32d38a7fd20a<br>
//     * 
//     * @author fengzilin
//     *
//     */
//    public static class CustomObjectInputStream extends ObjectInputStream {
//        protected ClassLoader classLoader = this.getClass().getClassLoader();
//
//        public CustomObjectInputStream(InputStream in) throws IOException {
//            super(in);
//        }
//
//        public CustomObjectInputStream(InputStream in, ClassLoader cl) throws IOException {
//            super(in);
//            this.classLoader = cl;
//        }
//
//        /*
//         * * (non-Javadoc) * * @see
//         * java.io.ObjectInputStream#resolveClass(java.io.ObjectStreamClass)
//         */
//        @Override
//        protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
//            String name = desc.getName();
//            try {
//                return Class.forName(name, false, this.classLoader);
//            } catch (ClassNotFoundException ex) {
//                return super.resolveClass(desc);
//            }
//        }
//
//    }
}