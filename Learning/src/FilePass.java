import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FilePass {
	
	private static void findDirectory(File path) {
		File[] files = path.listFiles();
		if(files == null)
			return;
		for( File file : files ) {
			if( !file.exists())
				continue;
			else if( file.isDirectory())
				findDirectory(file);
			else if(file.isFile())
				execute(file);
		}
		return;
	}
	
	private static void execute(File file) {
		//日付比較
		long lastModified = file.lastModified();
		if(lastModified >= fromDatetimeMillis && lastModified < toDatetimeMillis) {
			Date lastModifiedDate = new Date(file.lastModified());
			System.out.println(dateFormat.format(lastModifiedDate) + " " + file.getPath());
		}
		return;
	}
	
	private static long fromDatetimeMillis;
	private static long toDatetimeMillis;
	private static SimpleDateFormat dateFormat;
	
	public static void main(String[] args) {
		//現在時刻
		Calendar calendar = Calendar.getInstance();
		//現在時刻の0分0秒
		calendar.set(
				calendar.get(Calendar.YEAR),
				calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DAY_OF_MONTH),
				calendar.get(Calendar.HOUR_OF_DAY),
				0,0
				);
		
		// 現在時刻の0分0秒
		//toDatetimeMillis = calendar.GetTime().GetTime();
		toDatetimeMillis = new Date().getTime();
		
		//二時間前の0分0秒
		calendar.add(Calendar.HOUR_OF_DAY, -2);
		fromDatetimeMillis = calendar.getTime().getTime();
		
		dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		/* 確認用に出力<不要なロジック>
		calendar.setTimeInMillis(fromDatetimeMillis);
		Date fromDate = calendar.getTime();
		calendar.setTimeInMillis(toDatetimeMillis);
		Date toDate = calendar.getTime();
		System.out.println("対象範囲 :" + dateFormat.format(fromDate) + "~" + dateFormat.format(toDate));
		確認用に出力(ここまで)*/ 
		
		findDirectory(new File("/Users/yuki_fukushima/eclipse-workspace/Learning/src/FilePass.java"));
		

	}

}
