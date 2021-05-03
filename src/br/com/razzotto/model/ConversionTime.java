package br.com.razzotto.model;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Date;

public class ConversionTime {
	private long unixTimeInitial;
	private long unixTimeFinal;
	private DateFormat dateFormat;
	private String timeZoneID = "GMT+0:00";
	
	public long getUnixTimeInitial() {
		return unixTimeInitial;
	}

	public void setUnixTimeInitial(long unixTimeInitial) {
		this.unixTimeInitial = unixTimeInitial;
	}

	public long getUnixTimeFinal() {
		return unixTimeFinal;
	}

	public void setUnixTimeFinal(long unixTimeFinal) {
		this.unixTimeFinal = unixTimeFinal;
	}
	
	public long setDateInitial(Date date) {
		dateFormat = new SimpleDateFormat("yyyyMMddHHmm", Locale.ENGLISH);
		String time = dateFormat.format(date);
		setUnixTimeInitial(ConvertDatetoUnix(time));
		return getUnixTimeInitial();
	}
	public long setDateFinal(Date date) {
		dateFormat = new SimpleDateFormat("yyyyMMddHHmm", Locale.ENGLISH);
		String time = dateFormat.format(date);
		setUnixTimeFinal(ConvertDatetoUnix(time));
		return getUnixTimeFinal();
	}
	
	public long ConvertDatetoUnix(String time) {
		long unix = 0;
		TimeZone timeZone = TimeZone.getTimeZone(timeZoneID);
		dateFormat.setTimeZone(timeZone);
		try {
			unix = dateFormat.parse(time).getTime();
			unix = unix / 1000;		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return unix;
		
	}
	public Date ConvertUnixDate(long time) {
		return new Date((long)time*1000);		
	}
	public String ConvertDatetoString(Date time) {
		String format = "dd/MM/yyyy HH:mm:ss";
		DateFormat df = new SimpleDateFormat(format);
		return df.format(time);		
	}
	

}
