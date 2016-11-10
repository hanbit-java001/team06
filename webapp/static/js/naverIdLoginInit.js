//var naver_id_login = new naver_id_login("WUeDOqZsNJxhXOLW8uN7", "http://localhost:8282/");
var naver_id_login = new naver_id_login("WUeDOqZsNJxhXOLW8uN7", "http://203.236.209.189:8282/home");
		var state = naver_id_login.getUniqState();
		naver_id_login.setButton("green", 3, 40);
//		naver_id_login.setDomain("http://localhost:8282/");
		naver_id_login.setDomain("http://203.236.209.189:8282/home");
		naver_id_login.setState(state);
		// 	naver_id_login.setPopup();
		naver_id_login.init_naver_id_login();