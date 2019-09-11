package tuling.dubbo.server;

import com.alibaba.dubbo.rpc.*;

/**
 * @author Tommy
 * Created by Tommy on 2018/11/23
 **/
public class LubanFilter implements Filter {
    /**
     * do invoke filter.
     * <p>
     * <code>
     * // before filter
     * Result result = invoker.invoke(invocation);
     * // after filter
     * return result;
     * </code>
     *
     * @param invoker    service
     * @param invocation invocation.
     * @return invoke result.
     * @throws RpcException
     * @see Invoker#invoke(Invocation)
     */
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("执行鲁班过滤器");
        return invoker.invoke(invocation);
    }
}
