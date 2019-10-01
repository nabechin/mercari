package com.example.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * @author yuma.watanabe
 *
 */
public class LoginUser extends User{

	private static final long serialVersionUID = 1L;
	
	/** ユーザ情報 */
	private final com.example.domain.User user;

	/**
	 * 通常の管理者情報に加え、認可用ロールを設定する.
	 * 
	 * @param user ユーザ情報
	 * @param authorityList 権限情報が入ったリスト
	 */
	public LoginUser(com.example.domain.User user, Collection<GrantedAuthority> authorities) {
		super(user.getEmail(), user.getPassword(), authorities);
		this.user = user;
	}
	
	public com.example.domain.User getUser(){
		return user;
	}

}
