package com.lxy.study2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.util.Set;

public class MySMSReceiver extends BroadcastReceiver {
    private  static final String SMS_RECEIVER = "android.provider.Telephony.SMS_RECEIVED";
    public static final  String PAR_KEY = "com.lxy.par";

    public MySMSReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        SMSMethodData rawData = new SMSMethodData();
        // an Intent broadcast.
        if(intent.getAction().equals(SMS_RECEIVER)){
            SmsManager smsManager = SmsManager.getDefault();

            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                Object[] pdus = (Object[]) bundle.get("pdus");
                SmsMessage[] smsMessages = new SmsMessage[pdus.length];

                for (int i = 0; i < pdus.length; i++) {
                    smsMessages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                }
                for (SmsMessage smsMessage : smsMessages) {
                    rawData.displayMessageBody = smsMessage.getDisplayMessageBody();
                    //rawData.DisplayOriginatingAddress  = smsMessage.getDisplayOriginatingAddress();
                    rawData.EmailBody = smsMessage.getEmailBody();
                    rawData.MessageBody = smsMessage.getMessageBody();
                    /*rawData.IndexOnIcc = smsMessage.getIndexOnIcc();
                    rawData.OriginatingAddress = smsMessage.getOriginatingAddress();
                    rawData.Pdu = smsMessage.getPdu();
                    rawData.ProtocolIdentifier = smsMessage.getPseudoSubject();
                    rawData.PseudoSubject = smsMessage.getPseudoSubject();
                    rawData.ServiceCenterAddress = smsMessage.getServiceCenterAddress();
                    rawData.Status = smsMessage.getStatus();
                    rawData.StatusOnIcc = smsMessage.getStatusOnIcc();
                    //rawData.TPLayerLengthForPDU = smsMessage.getTPLayerLengthForPDU();
                    rawData.TimestampMillis = smsMessage.getTimestampMillis();
                    rawData.UserData = smsMessage.getUserData();*/
                }

                Intent mIntent = new Intent(context,SMSReceiverActivity.class);
                mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle mBundle = new Bundle();
                mBundle.putParcelable(PAR_KEY, rawData);
                mIntent.putExtras(mBundle);

                /*Bundle gBundle = mIntent.getExtras();
                Set<String> keySet = gBundle.keySet();
                for (String key:keySet){
                    Log.d("AAA"+key+":", String.valueOf(gBundle.get(key)));
                }*/

                context.startActivity(mIntent);

            }
        }
    }


}
