<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.header-1 {
  box-sizing: border-box;
  width: 100%;
}

.header-inner {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 60px;
  padding: 0 2em;
}

.button {
font-family:"Yu Gothic";
  display       : inline-block;
  border-radius : 20%;          /* 角丸       */
  font-size     : 18pt;        /* 文字サイズ */
  text-align    : center;      /* 文字位置   */
  cursor        : pointer;     /* カーソル   */
  padding       : 12px 12px;   /* 余白       */
  background    : #b5cd60;     /* 背景色     */
  color         : rgba(255, 255, 255, 0.99); /* 文字色     */
  line-height   : 1em;         /* 1行の高さ  */
  transition    : .3s;         /* なめらか変化 */
  box-shadow    : 14px 14px 16px #666666;  /* 影の設定 */
  border        : 2px solid #990000;    /* 枠の指定 */
}
.button:hover {
  box-shadow    : none;        /* カーソル時の影消去 */
  color         :#16aa56;     /* 背景色     */
  background    : rgba(255, 255, 255, 0.99);     /* 文字色     */
}

</style>
</head>
<body>
<header class="header-1">
<div class="header-inner">
<form action="/ecsite/Logout" method="POST">
<input type="submit" value="ログアウト" class="button">
</form>
</div>

</header>
</body>
</html>