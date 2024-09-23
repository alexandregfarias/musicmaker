package com.br.application;

import com.br.application.database.DBConnect;
import com.br.application.view.ViewLogin;

public class MusicMaker {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {	
		DBConnect.connect();		
		ViewLogin.exibirTelaDeLogin();
	}	
}