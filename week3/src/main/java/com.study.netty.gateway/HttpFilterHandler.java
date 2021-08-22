package com.study.netty.gateway;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * 添加一个请求过滤的过滤器
 */
public class HttpFilterHandler extends ChannelOutboundHandlerAdapter {

    /*
    *  重现数据的数据
    * */
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println("hello ChannelOutboundHandlerAdapter2");
        super.write(ctx, msg, promise);
    }

    @Override
    public void read(ChannelHandlerContext ctx) throws Exception {
        System.out.println("hello   ChannelOutboundHandlerAdapter");
        super.read(ctx);
    }
}
