 function logout() {
  // 로그아웃 아이프레임
  $("body").append("<iframe id='logoutIframe' style='display: none;'></iframe>");
  $("#logoutIframe").attr("src", "http://nid.naver.com/nidlogin.logout");
  // 로그아웃 처리
//  $("#naver_id_login").show();
//  $("#naver_id_logout").hide();

//  https://nid.naver.com/oauth2.0/token?grant_type=delete&client_id={WUeDOqZsNJxhXOLW8uN7}" +
//		"&client_secret={gM8GQBEcxX}&access_token={AAAAOwicDRy4ZNGyem%2BmyIWfPFmfOen7ZdNz9D%2FgF1t4ep7OnNgdDKj2O31VAfuVAueGiMilVQQbmXk5PQyvnK6cnqo%3D}" +
//		"&service_provider=NAVER"
 }