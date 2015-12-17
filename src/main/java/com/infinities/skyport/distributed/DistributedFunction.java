package com.infinities.skyport.distributed;

public interface DistributedFunction<I, O> {

	O apply(I input);

}
