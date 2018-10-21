package jp.org.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ログイン画面の処理を呼び出すコントローラの作成
 * @author yuki_fukushima
 */
@Controller
public class HomeController {
	
	// ロガーを取得するインスタンスの作成
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	// valueで指定したURLに対してRequestMethodを実行する
	@RequestMapping(value = "/", method = RequestMethod.GET)
	
	/**
	 * 
	 * @param locale Localeクラスの引数
	 * @param model　Modelクラスの引数
	 * @return　homeメソッドを返す
	 */
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		// Date型の定義
		Date date = new Date();
		// 日付／時刻をlong形式に変換
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
