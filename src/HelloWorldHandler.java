import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class HelloWorldHandler implements InvocationHandler{
	private Object obj;
	
	public HelloWorldHandler(Object obj) {
		super();
		this.obj = obj;
	}
	
	/**
	 * This is the real method will call when call the method on the proxy class
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] arg)
			throws Throwable {
		Object result = null;
		// Call before
		doBefore();
		// Call original method, invoke the method on the obj object
		result = method.invoke(obj, arg);
		// Call after
		doAfter();
		
		return result;
	}

	public void doBefore() {
		System.out.println("Before");
	}
	
	public void doAfter() {
		System.out.println("After");
	}
}
