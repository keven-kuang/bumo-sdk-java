package io.bumo.sdk.core.adapter.bc.response.test;

import com.alibaba.fastjson.annotation.JSONField;
/***
 * 评估费用
 * @author bumo
 *
 */
public class TXEnv {
	@JSONField(name="transaction_env")
	private TransactionEnv te;

	public TransactionEnv getTe() {
		return te;
	}

	public void setTe(TransactionEnv te) {
		this.te = te;
	}
	
}
