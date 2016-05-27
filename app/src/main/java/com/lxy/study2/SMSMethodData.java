package com.lxy.study2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wy on 2016/5/25.
 */
public class SMSMethodData implements Parcelable {
    public int[] calculateLength;
    public String displayMessageBody;
    public String DisplayOriginatingAddress;
    public String EmailBody;
    public int IndexOnIcc;
    public String MessageBody;
    public String OriginatingAddress;
    public byte[] Pdu;
    public String ProtocolIdentifier;
    public String PseudoSubject;
    public String ServiceCenterAddress;
    public int Status;
    public int StatusOnIcc;
    public int TPLayerLengthForPDU;
    public long TimestampMillis;
    public byte[] UserData;
    public boolean CphsMwiMessage;

    public static final Parcelable.Creator<SMSMethodData> CREATOR = new Creator<SMSMethodData>() {
        @Override
        public SMSMethodData createFromParcel(Parcel source) {
            SMSMethodData smsMethodData = new SMSMethodData();
            //source.readIntArray(smsMethodData.calculateLength);
            smsMethodData.displayMessageBody = source.readString();
            smsMethodData.DisplayOriginatingAddress = source.readString();
            smsMethodData.EmailBody = source.readString();
            smsMethodData.IndexOnIcc = source.readInt();
            smsMethodData.MessageBody = source.readString();
            smsMethodData.OriginatingAddress = source.readString();
            //source.readByteArray(smsMethodData.Pdu);
            smsMethodData.ProtocolIdentifier = source.readString();
            smsMethodData.PseudoSubject = source.readString();
            smsMethodData.ServiceCenterAddress = source.readString();
            return smsMethodData;
        }

        @Override
        public SMSMethodData[] newArray(int size) {
            return new SMSMethodData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        //parcel.writeIntArray(calculateLength);
        parcel.writeString(displayMessageBody);
        parcel.writeString(DisplayOriginatingAddress);
        parcel.writeString(EmailBody);
        parcel.writeInt(IndexOnIcc);
        parcel.writeString(MessageBody);
        parcel.writeString(OriginatingAddress);
        //parcel.writeByteArray(Pdu);
        parcel.writeString(ProtocolIdentifier);
        parcel.writeString(PseudoSubject);
        parcel.writeString(ServiceCenterAddress);
    }
}
