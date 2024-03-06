package com.bookProject;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.jpos.iso.ISOUtil;
import org.jpos.tlv.TLVList;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.* ;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.stream.Collectors;



public class Rough{
    public static void main(String [] args) throws DecoderException, UnsupportedEncodingException, ParseException {
        byte[] emvData = ISOUtil.hex2byte("9F02060000000000009F260878705C64CCFEDD9A9F2701809F100706010A03A0A8009F120A564953412044454249549F3501115F3401019F090200965F201742494B415348204D41484150415452412020202020202F9F370475D80EC69F36020232950580800400009A032402215F2A02035682021C009F1A0203569F33036040009F34034203009F1E08364C3736353738398407A0000000031010500A564953412044454249549C0131");
        TLVList tlv = new TLVList();
        tlv.unpack(emvData);
        String serialno = new String(Hex.decodeHex(tlv.getString(0x9F1E)), "UTF-8");

           DateFormat tlvDt = new SimpleDateFormat("yyMMdd");

        List  <String > list = Arrays.asList(Arrays.toString(emvData)) ;
         list.forEach(System.out::println);
       String tlvDate = tlv.getString(0x9A);
       String posDate = String.valueOf(tlvDt.parse(tlvDate));

        System.out.println(posDate);
        System.out.println(serialno);
//        System.out.println(amount);

    }

}