package com.pragra.abfapi.abfutils;

import com.aftership.sdk.config.EnvGetter;
import com.aftership.sdk.model.AftershipOption;

public final class CommonUtils {

        private static final String ENV_API_KEY = "a9a52cb7-f80a-431e-8963-1a95da540557";

        public static final String getEnvApiKey(){
            return EnvGetter.getString(ENV_API_KEY,"a9a52cb7-f80a-431e-8963-1a95da540557");
        }

        public static final AftershipOption getAfterShipOption(){
            AftershipOption option = new AftershipOption();
            String endPoint = EnvGetter.getString("Api-endPoint","https://api.aftership.com/v4");
            option.setEndpoint(endPoint);
            return option;
        }

}
