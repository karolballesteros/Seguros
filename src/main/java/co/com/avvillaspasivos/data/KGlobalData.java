/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 *
 */

package co.com.avvillaspasivos.data;

import co.com.avvillaspasivos.model.KActorData;
import co.com.avvillaspasivos.util.KConstantes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KGlobalData {
        // static variable single_instance of type Singleton
        private static KGlobalData globalData = null;
        // variable of type String
        private KActorData actorData;
        // private constructor restricted to this class itself
    private KGlobalData()
        {
        }
        // static method to create instance of Singleton class
        public static KGlobalData getInstance()
        {
            if (globalData == null)
                globalData = new KGlobalData();

            return globalData;
        }



    public  String getOtp(){
        KDbQuerys dbQuerys = new KDbQuerys();
        String dataTagOtp = dbQuerys.getXmlOtp(actorData.getPhone());
        String otp= Xml.getDataTextString(dataTagOtp, KConstantes.TAG_OTP);

        return otp.substring(8);
    }
}
