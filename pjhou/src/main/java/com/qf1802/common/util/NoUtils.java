package com.qf1802.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NoUtils {

	public static String cteateNo() {
		return new SimpleDateFormat("yyMM").format(new Date());
	}
	
}
