package com.lxy.study2;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;

import java.util.ArrayList;

/**
 * Created by wy on 2016/5/20.
 */
public class CellChinaLocation extends Object {
    private final static byte CHINAMOBILE1 = 0;  //对应mobile network code
    private final static byte CHINAUNICOM1 = 1;
    private final static byte CHINAMOBILE2 = 2;
    private final static byte CHINATELECOM1 = 3;
    private final static byte CHINATELECOM2 = 5;
    private final static byte CHINAMOBLIE3 = 7;
    private final static byte CHINATELECOM3 = 11;

    private final static byte GOODCODE = 1;       //正常情况
    private final static byte UNKOWNCODE = -1;   //系统返回未知类型网络商
    private final static byte UNEXPECTEDCODE = -2;     //没有定义的网络商,预留

    public CellChinaLocation() {

    }
    /**
     * @param context 上下文环境
     * @param  mnc 网络环境
     * @return 如果正常，返回cell id和location area code
     * @return 如果未知，返回-1                            返回结构：[CODE,cellId,lac],
     * @return 如果是意外的CODE，返回-2
     */
    public ArrayList getCellInformation(Context context, int mnc) {
        int cellId,lac;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        ArrayList rawLocation = new ArrayList();

        //根据mobile network code进行不同操作。
        switch (mnc){
            case CHINAMOBILE1:
            case CHINAMOBILE2:
            case CHINAMOBLIE3:
            case CHINAUNICOM1:
                GsmCellLocation gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation();
                cellId = gsmCellLocation.getCid();
                lac = gsmCellLocation.getLac();
                break;
            case CHINATELECOM1:
            case CHINATELECOM2:
            case CHINATELECOM3:
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) telephonyManager.getCellLocation();
                cellId = cdmaCellLocation.getBaseStationId();
                lac = cdmaCellLocation.getNetworkId();
                break;
            default:
                rawLocation.add(UNKOWNCODE);
                return rawLocation;
        }

        if (cellId == UNKOWNCODE) {
            rawLocation.add(UNKOWNCODE);
            return rawLocation;
        }

        rawLocation.add(GOODCODE);
        rawLocation.add(cellId);
        rawLocation.add(lac);
        return rawLocation;
    }



}
