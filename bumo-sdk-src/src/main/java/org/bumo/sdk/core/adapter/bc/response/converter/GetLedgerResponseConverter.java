package org.bumo.sdk.core.adapter.bc.response.converter;

import java.io.InputStream;

import org.bumo.sdk.core.adapter.bc.response.ledger.Ledger;
import org.bumo.sdk.core.utils.http.HttpServiceContext;
import org.bumo.sdk.core.utils.http.ResponseConverter;
import org.bumo.sdk.core.utils.http.agent.ServiceRequest;
import org.bumo.sdk.core.utils.http.converters.JsonResponseConverter;

import com.alibaba.fastjson.JSONObject;

public class GetLedgerResponseConverter implements ResponseConverter{
    private JsonResponseConverter jsonResponseConverter = new JsonResponseConverter(ServiceResponse.class);

    @Override
    public Object getResponse(ServiceRequest request, InputStream responseStream, HttpServiceContext serviceContext) throws Exception{
        ServiceResponse serviceResponse = (ServiceResponse) jsonResponseConverter.getResponse(request, responseStream, null);
        if (serviceResponse == null || !"0".equals(serviceResponse.getErrorCode())) {
            return null;
        }
        return JSONObject.toJavaObject(serviceResponse.getResult(), Ledger.class);
    }


}
