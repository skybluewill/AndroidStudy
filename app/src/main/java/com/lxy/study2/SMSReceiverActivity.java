package com.lxy.study2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.Set;

public class SMSReceiverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smsreceiver);
        TextView showTable = (TextView) findViewById(R.id.show_table);

        StringBuffer status = new StringBuffer();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (intent.hasExtra(MySMSReceiver.PAR_KEY)) {
            SMSMethodData smsMethodData = getIntent().getParcelableExtra(MySMSReceiver.PAR_KEY);
            if (smsMethodData == null) {
                Toast.makeText(this,"smsMethodData is null",Toast.LENGTH_LONG).show();
            }else {
                Log.d("TAA",smsMethodData.displayMessageBody);
                //status.append("displayMessageBody:" + smsMethodData.calculateLength + "\n");
                status.append("displayMessageBody:" + smsMethodData.displayMessageBody + "\n");
                status.append("DisplayOriginatingAddress:" + smsMethodData.DisplayOriginatingAddress);
                status.append("EmailBody:" + smsMethodData.EmailBody + "\n");
                status.append("IndexOnIcc:" + smsMethodData.IndexOnIcc);
                status.append("MessageBody:" + smsMethodData.MessageBody + "\n");
                //status.append("Pdu:" + smsMethodData.Pdu);
                status.append("ProtocolIdentifier:" + smsMethodData.ProtocolIdentifier);
                status.append("PseudoSubject:" + smsMethodData.PseudoSubject);
                status.append("ServiceCenterAddress:" + smsMethodData.ServiceCenterAddress);
                /* status.append("Status" + smsMethodData.Status);
                status.append("StatusOnIcc" + smsMethodData.StatusOnIcc);
                status.append("TimestampMillis" + smsMethodData.TimestampMillis);
                status.append("UserData" + smsMethodData.UserData);
                */
               /* public int[] calculateLength;
                public String displayMessageBody;
                public String DisplayOriginatingAddress;
                public String EmailBody;
                public int IndexOnIcc;
                public String MessageBody;
                public String OriginatingAddress;
                public byte[] Pdu;
                public String ProtocolIdentifier;
                public String PseudoSubject;
                public String ServiceCenterAddress;*/
            }
        }else {
            Toast.makeText(this,"Intent里没有存放PAR_KEY",Toast.LENGTH_LONG).show();
        }

       // Log.d("TAA",smsMethodData.EmailBody);
       // Log.d("TAA",smsMethodData.MessageBody);

        /*status.append("displayMessageBody" + smsMethodData.displayMessageBody);
        //status.append("DisplayOriginatingAddress" + smsMethodData.DisplayOriginatingAddress);
        status.append("EmailBody" + smsMethodData.EmailBody);
        //status.append("IndexOnIcc" + smsMethodData.IndexOnIcc);
        status.append("MessageBody" + smsMethodData.MessageBody);
        //status.append("Pdu" + smsMethodData.Pdu);
       /* status.append("ProtocolIdentifier" + smsMethodData.ProtocolIdentifier);
        status.append("PseudoSubject" + smsMethodData.PseudoSubject);
        status.append("ServiceCenterAddress" + smsMethodData.ServiceCenterAddress);
        status.append("Status" + smsMethodData.Status);
        status.append("StatusOnIcc" + smsMethodData.StatusOnIcc);
        status.append("TimestampMillis" + smsMethodData.TimestampMillis);
        status.append("UserData" + smsMethodData.UserData);
        */
        showTable.setText(status.toString());
    }
}
