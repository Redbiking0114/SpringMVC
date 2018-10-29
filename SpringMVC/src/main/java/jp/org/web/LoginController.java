package jp.org.web;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ログイン画面コントローラの作成
 */
@Controller
public class LoginController {
	
	// ロガーを取得するインスタンスの作成
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	/**
	 * ホーム画面に返す値を設定する
	 */ 
	@RequestMapping(value = "/login")
	// 
	public String home(Locale locale, Model model) {
		// URLが"/login"の場合、login.jspを表示する
		return "login";
	}	
}