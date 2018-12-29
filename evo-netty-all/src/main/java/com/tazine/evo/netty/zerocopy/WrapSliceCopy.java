package com.tazine.evo.netty.zerocopy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * 通过 wrap / slice 实现零拷贝
 *
 * @author frank
 * @date 2018/12/30
 */
public class WrapSliceCopy {

    public static void main(String[] args) {

        // 通过wrappedBuffer 方法来将 bytes 包装成为一个 UnpooledHeapByteBuf 对象, 而在包装的过程中, 是不会有拷贝操作的.
        String name = "frank";
        ByteBuf buf = Unpooled.wrappedBuffer(name.getBytes());
        byte[] dest = new byte[name.length()];
        buf.readBytes(dest);
        System.out.println(new String(dest));

        // slice 操作可以将一个 ByteBuf 切片 为多个共享一个存储区域的 ByteBuf 对象.它产生 header 和 body 的过程是没有拷贝操作的,
        // header 和 body 对象在内部其实是共享了 byteBuf 存储空间的不同部分而已.
        String xm = "嘉尔";
        ByteBuf buf1 = Unpooled.wrappedBuffer(xm.getBytes());
        ByteBuf header = buf1.slice(0,3);
        ByteBuf body = buf1.slice(3, 3);
        byte[] headerBytes = new byte[3];
        byte[] bodyBytes = new byte[3];
        header.readBytes(headerBytes);
        body.readBytes(bodyBytes);
        System.out.println(new String(headerBytes));
        System.out.println(new String(bodyBytes));

        // 注：也可以设置Netty的接收Buffer为堆内存模式，有两种方法
        // boot.option(ChannelOption.ALLOCATOR,PooledByteBufAllocator.DEFAULT)
        // socketChannel.config.setAllocator(UnpooledByteBufAllocator.DEFAULT)
    }

}
